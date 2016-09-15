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

import jsc.distributions.Normal;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class ProcesoGaussianoNorm extends ActionBarActivity {
private EditText txtri, txtrii, txtu, txtv;
private RadioButton rbA, rbB;
private TextView txtrpta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_gaussiano_norm);
        rbA=(RadioButton)findViewById(R.id.rbNormA);
        rbB=(RadioButton)findViewById(R.id.rbNormB);
        txtu=(EditText)findViewById(R.id.txtMediaNorm);
        txtv=(EditText)findViewById(R.id.txtVarNorm);
        txtri=(EditText)findViewById(R.id.txtriNormGauss);
        txtrii=(EditText)findViewById(R.id.txtriiNormGauss);
        txtrpta=(TextView)findViewById(R.id.txtRptaNorm);
        txtu.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        txtv.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        txtri.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        txtrii.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        rbA.isChecked();
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_proceso_gaussiano_norm, menu);
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
    public void borrarRnorm(View view){
        txtri.setText("");
        txtrii.setText("");
        txtrpta.setText("");
    }

    public void generarNormal(View view){
        try{
            if(txtu.getText()!=null && txtv.getText()!=null && txtri.getText()!=null && txtrii.getText()!=null){
                double u=Double.parseDouble(txtu.getText().toString());
                double v=Double.parseDouble(txtv.getText().toString());
                double ri=Double.parseDouble(txtri.getText().toString());
                double rii=Double.parseDouble(txtrii.getText().toString());
                if(ri<1 && rii<1){
                    if(rbA.isChecked()==true){
                        hallarxNormalA(u, v, ri, rii);
                    }else{
                        if(rbB.isChecked()==true){
                            hallarxNormalB(u, v, ri, rii);
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

    public void hallarxNormalA(double u, double v, double ri, double rii){
        double x=u+((Math.sqrt(-2*v*Math.log(ri)))*(Math.cos(2*rii*Math.PI)));
        txtrpta.setText("x= "+x+" ("+Math.round(x)+")");
    }

    public void hallarxNormalB(double u, double v, double ri, double rii){
        double x=u+((Math.sqrt(-2*v*Math.log(ri)))*(Math.sin(2*rii*Math.PI)));
        txtrpta.setText("x= "+x+" ("+Math.round(x)+")");
    }
}
