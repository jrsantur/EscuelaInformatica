package chiroque.aplicaciones.com.escuelainformatica.SimulacionDeSistemas;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class ProcesoLognormal extends ActionBarActivity {
    private EditText txtri, txtrii, txtu, txtv;
    private RadioButton rbA, rbB;
    private TextView txtrpta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_lognormal);
        rbA=(RadioButton)findViewById(R.id.rbLognormA);
        rbB=(RadioButton)findViewById(R.id.rbLognormB);
        txtu=(EditText)findViewById(R.id.txtMediaLognorm);
        txtv=(EditText)findViewById(R.id.txtVarLognorm);
        txtri=(EditText)findViewById(R.id.txtriLognorm);
        txtrii=(EditText)findViewById(R.id.txtriiLognorm);
        txtrpta=(TextView)findViewById(R.id.txtRptaLognorm);
        txtu.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        txtv.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        txtri.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        txtrii.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        rbA.isChecked();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_proceso_lognormal, menu);
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
    public void borrarRlognorm(View view){
        txtri.setText("");
        txtrii.setText("");
        txtrpta.setText("");
    }

    public void generarLognormal(View view){
        try{
            if(txtu.getText()!=null && txtv.getText()!=null && txtri.getText()!=null && txtrii.getText()!=null){
                double u=Double.parseDouble(txtu.getText().toString());
                double v=Double.parseDouble(txtv.getText().toString());
                double ri=Double.parseDouble(txtri.getText().toString());
                double rii=Double.parseDouble(txtrii.getText().toString());
                if(ri<1 && rii<1){
                    if(rbA.isChecked()==true){
                        hallarxLognormalA(u, v, ri, rii);
                    }else{
                        if(rbB.isChecked()==true){
                            hallarxLognormalB(u, v, ri, rii);
                        }
                    }
                }else{
                    txtrpta.setText("");
                    Toast notificacion=Toast.makeText(this,"Los r deben ser menor a 1.",Toast.LENGTH_LONG);
                    notificacion.show();
                }
            }
        }catch (Exception ex){
            txtrpta.setText("");
            Toast notificacion=Toast.makeText(this,"Datos vacíos o límite de valores.",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }
    public void hallarxLognormalA(double u, double v, double ri, double rii){
        double x=Math.pow(Math.E,u+((Math.sqrt(-2*v*Math.log(ri)))*(Math.cos(2*rii*Math.PI))));
        txtrpta.setText("x= "+x+"");
    }

    public void hallarxLognormalB(double u, double v, double ri, double rii){
        double x=Math.pow(Math.E,u+((Math.sqrt(-2*v*Math.log(ri)))*(Math.sin(2*rii*Math.PI))));
        txtrpta.setText("x= "+x+"");
    }
}
