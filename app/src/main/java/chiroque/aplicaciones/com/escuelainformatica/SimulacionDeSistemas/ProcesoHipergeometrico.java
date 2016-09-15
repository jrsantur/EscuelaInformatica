package chiroque.aplicaciones.com.escuelainformatica.SimulacionDeSistemas;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import jsc.distributions.Hypergeometric;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class ProcesoHipergeometrico extends ActionBarActivity {
    private TableLayout tabla;
    private EditText txtn, txtNa, txtN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_hipergeometrico);
        tabla=(TableLayout)findViewById(R.id.tablaHG);
        txtN=(EditText)findViewById(R.id.txtNpobHG);
        txtn=(EditText)findViewById(R.id.txtnensayosHG);
        txtNa=(EditText)findViewById(R.id.txtNaHG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_proceso_hipergeometrico, menu);
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

    public void vaciarformularioHG(View view){
        tabla.removeAllViews();
        txtn.setText("");
        txtN.setText("");
        txtNa.setText("");
    }

    public void generarHG(View view){
    try{
        int muestra=Integer.parseInt(txtn.getText().toString());
        int poblacion=Integer.parseInt(txtN.getText().toString());
        int itemsna=Integer.parseInt(txtNa.getText().toString());
        if(poblacion>=muestra && poblacion>itemsna){
            procesoHipergeometrico(muestra,poblacion,itemsna);
        }else{
            Toast notificacion=Toast.makeText(this,"Población es el mayor número.",Toast.LENGTH_LONG);
            notificacion.show();
        }

    }catch(Exception ex){
        Toast notificacion=Toast.makeText(this,"Datos vacíos o límite de valores.",Toast.LENGTH_LONG);
        notificacion.show();
    }
    }
    public void agregarcabecera(){
        TableRow fila=new TableRow(this) ;
        TextView celda;
        for(int i=0;i<2;i++){
            celda=new TextView(this);
            celda.setGravity(Gravity.CENTER);
            celda.setTextColor(Color.BLUE);
            celda.setWidth(80);
            celda.setTextSize(10);
            celda.setPadding(2,2,2,2);
            celda.setBackgroundResource(R.drawable.borde);
            fila.addView(celda);
            if(i==0){
                celda.setText("x=");
            }else{
                celda.setText("f(x) ó r");
            }
        }
        tabla.addView(fila);
    }

    public void procesoHipergeometrico(int n, int N, int Na){
        tabla.removeAllViews();
        TableRow fila ;
        TextView celda;
        agregarcabecera();
        Hypergeometric hp=new Hypergeometric(n,N,Na);
        double val=0.0;
        for(int i=1;i<=Na;i++){
            fila=new TableRow(this);
            for(int j=0;j<2;j++){
                celda=new TextView(this);
                celda.setHeight(40);
                celda.setTextSize(15);
                if(j==0){
                    celda.setWidth(30);
                    celda.setText((i)+"");
                }else{
                    celda.setWidth(380);
                    val=hp.pdf(i);
                    celda.setText(val+"");
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
