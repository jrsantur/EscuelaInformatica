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
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class MetodoCongruencialLinealMultiplicativo extends ActionBarActivity {
    private EditText txtr0, txtnAleat, txtm, txta;
    private TableLayout tabla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_congruencial_lineal_multiplicativo);
        txtr0=(EditText)findViewById(R.id.txtr0LinMult);
        txta=(EditText)findViewById(R.id.txtMultiplicativoLinMult);
        txtm=(EditText)findViewById(R.id.txtModuloLinMult);
        txtnAleat=(EditText)findViewById(R.id.txtNAleatLinMult);
        tabla=(TableLayout)findViewById(R.id.tablaNroAleatLinMult);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_metodo_congruencial_lineal_multiplicativo, menu);
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
    public void btnGenerarNrosAleatLinMult(View view){
      try{
          if(txtr0.getText()!=null && txta.getText()!=null && txtm.getText()!=null && txtnAleat.getText()!=null) {
              tabla.removeAllViews();
              tabla.setVisibility(View.VISIBLE);
              int r0=Integer.parseInt(txtr0.getText().toString());
              int a=Integer.parseInt(txta.getText().toString());
              int m=Integer.parseInt(txtm.getText().toString());
              int nnumeros=Integer.parseInt(txtnAleat.getText().toString());
              int [] arr=metodoLinealMultiplicativo(r0,a,m,nnumeros);
              agregarcabecera();
              agregarcelda(nnumeros,arr,m);
          }
      }catch(Exception ex){
        Toast notificacion=Toast.makeText(this,"Ingresar datos correctamente"+ex,Toast.LENGTH_LONG);
        notificacion.show();
     }
    }

    private int []  metodoLinealMultiplicativo(int r0, int a, int m,int n){
        int [] serie=new int[n];
        serie[0]=(a*r0)%m;
        for(int i=1;i<n;i++){
            serie [i]=(a*serie [i-1])%m;
        }
        return serie;
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
                celda.setText("n");
            }else{
                if(i==1){
                    celda.setText("Rn");
                }else{
                    celda.setWidth(180);
                    celda.setText("Rn [0,1]");
                }
            }
        }
        tabla.addView(fila);
    }

    public void agregarcelda(int num, int [] arr, int m){
        TableRow fila ;
        TextView celda;
        DecimalFormat df = new DecimalFormat("#.######");
        for(int i=0;i<num;i++){
            fila=new TableRow(this);

            for(int j=0;j<3;j++){
                celda=new TextView(this);
                celda.setHeight(30);
                celda.setTextSize(15);
                if(j==0){
                    celda.setWidth(60);
                    celda.setInputType(InputType.TYPE_CLASS_NUMBER);
                    celda.setText((i+1)+"");
                }else{
                    if(j==1){
                        celda.setWidth(120);
                        celda.setInputType(InputType.TYPE_CLASS_NUMBER);
                        celda.setText(arr[i]+"");
                    }else{
                        celda.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                        double valor=(double) arr[i]/m;
                        celda.setWidth(140);
                        celda.setText(""+df.format(valor));
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
