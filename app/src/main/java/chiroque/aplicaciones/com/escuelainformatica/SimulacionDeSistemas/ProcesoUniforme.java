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

import jsc.distributions.Uniform;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class ProcesoUniforme extends ActionBarActivity {
    private EditText txta, txtb, txtr;
    private TextView txtrpta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_uniforme);
        txta=(EditText)findViewById(R.id.txtMinUniform);
        txtb=(EditText)findViewById(R.id.txtMaxUniform);
        txtr =(EditText)findViewById(R.id.txtrUniform);
        txtrpta=(TextView)findViewById(R.id.txtRptaUniform);
        txta.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        txtb.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        txtr.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_proceso_uniforme, menu);
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

    public void vaciarformularioUniform(View view){
        txta.setText("");
        txtb.setText("");
        txtr.setText("");
        txtrpta.setText("");
    }

    public void borrarRuniform(View view){
        txtr.setText("");
        txtrpta.setText("");
    }

    public void generarUniforme(View view){
        try{
            if(txta.getText()!=null && txtb.getText()!=null && txtr.getText()!=null){
                double a=Double.parseDouble(txta.getText().toString());
                double b=Double.parseDouble(txtb.getText().toString());
                double r=Double.parseDouble(txtr.getText().toString());
                if(r<1){
                    if(b>a){
                        hallarxUniforme(a,b,r);
                    }else{
                        Toast notificacion=Toast.makeText(this,"'b' debe ser mayor que 'a'",Toast.LENGTH_LONG);
                        notificacion.show();
                    }
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

    public void hallarxUniforme(double a, double b, double r){
        Uniform u=new Uniform(a,b);
        double x=u.inverseCdf(r);
        txtrpta.setText("x= "+x+" ("+Math.round(x)+")");
    }
}
