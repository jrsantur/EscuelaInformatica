package chiroque.aplicaciones.com.escuelainformatica.SimulacionDeSistemas;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import jsc.distributions.Poisson;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class ProcesoPoisoniano extends ActionBarActivity {
    private TableLayout tabla;
    private EditText txtpromedio, txtx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_poisoniano);
        txtpromedio=(EditText)findViewById(R.id.txtpromedioPoison);
        txtx=(EditText)findViewById(R.id.txtNocurrenciasPoison);
        tabla=(TableLayout)findViewById(R.id.tablaPoison);
        txtpromedio.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_proceso_poisoniano, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void vaciarformularioPoison(View view){
        tabla.removeAllViews();
        txtpromedio.setText("");
        txtx.setText("");
    }

    public void generarPoisioniano(View view){
        try{
            if(txtpromedio.getText()!=null && txtx.getText()!=null){
                double prom=Double.parseDouble(txtpromedio.getText().toString());
                int x=Integer.parseInt(txtx.getText().toString());
                if(prom<=500){
                    processBinomial(prom,x);
                }else{
                    Toast notificacion=Toast.makeText(this,"Promedio muy alto, máximo valor permitido: 500.",Toast.LENGTH_LONG);
                    notificacion.show();
                }
            }
        }catch (Exception ex){
            Toast notificacion=Toast.makeText(this,"Datos vacíos o límite de valores.",Toast.LENGTH_LONG);
            notificacion.show();
        }

    }

    public void agregarcabecera(){
        TableRow fila=new TableRow(this) ;
        TextView celda;
        for(int i=0;i<3;i++){
            celda=new TextView(this);
            celda.setGravity(Gravity.CENTER);
            celda.setTextColor(Color.BLUE);
            celda.setWidth(80);
            celda.setTextSize(10);
            celda.setPadding(2,2,2,2);
            celda.setBackgroundResource(R.drawable.borde);
            fila.addView(celda);
            if(i==0){
                celda.setText("x");
            }else{
                if(i==1){
                    celda.setText("f(x) ó r");
                }else{
                    celda.setText("F(x)");
                }
            }
        }
        tabla.addView(fila);
    }

    public void processBinomial(double promedio,int n){
        tabla.removeAllViews();
        TableRow fila ;
        TextView celda;
        agregarcabecera();
        Poisson ps=new Poisson(promedio);
        double Fx=0.0, val=0.0;
        for(int i=0;i<=n;i++){
            fila=new TableRow(this);
            for(int j=0;j<3;j++){
                celda=new TextView(this);
                celda.setHeight(40);
                celda.setTextSize(15);
                if(j==0){
                    celda.setWidth(30);
                    celda.setText((i)+"");
                }else{
                    if(j==1){
                        celda.setWidth(380);
                        val=ps.pdf(i);
                        Fx=Fx+val;
                        celda.setText(val+"");

                    }else{
                        celda.setWidth(380);
                        celda.setText(Fx+"");
                    }
                }
                celda.setTextColor(Color.BLACK);
                celda.setGravity(Gravity.CENTER);
                celda.setBackgroundResource(R.drawable.borde);
                fila.addView(celda);
            }
            tabla.addView(fila);
        }

    }
}
