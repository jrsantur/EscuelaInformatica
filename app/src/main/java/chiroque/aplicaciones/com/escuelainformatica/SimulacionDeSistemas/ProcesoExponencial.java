package chiroque.aplicaciones.com.escuelainformatica.SimulacionDeSistemas;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class ProcesoExponencial extends ActionBarActivity {
    private EditText txtu, txtr;
    private TextView txtrpta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_exponencial);
        txtu=(EditText)findViewById(R.id.txtPromedioexpo);
        txtr =(EditText)findViewById(R.id.txtrExpon);
        txtrpta=(TextView)findViewById(R.id.txtRptaExpon);
        txtr.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        txtu.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_proceso_exponencial, menu);
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

    public void vaciarformularioExpo(View view){
        txtu.setText("");
        txtr.setText("");
        txtrpta.setText("");
    }

    public void borrarRexpo(View view){
        txtr.setText("");
        txtrpta.setText("");
    }


    public void generarExponencial(View view){
        try{
            if(txtu.getText()!=null && txtr.getText()!=null){
                double prom=Double.parseDouble(txtu.getText().toString());
                double x=Double.parseDouble(txtr.getText().toString());
                if(x<1){
                    hallarxExponencial(prom, x);
                }else{
                    txtrpta.setText("");
                    Toast notificacion=Toast.makeText(this,"r debe ser menor a 1.",Toast.LENGTH_LONG);
                    notificacion.show();
                }
            }
        }catch (Exception ex){
            txtrpta.setText("");
            Toast notificacion=Toast.makeText(this,"Datos vacíos o límite de valores.",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }

    public void hallarxExponencial(double u, double r){
        double x=(-u)*Math.log(1 - r);
        txtrpta.setText("x= "+x+" ("+Math.round(x)+")");
    }
}
