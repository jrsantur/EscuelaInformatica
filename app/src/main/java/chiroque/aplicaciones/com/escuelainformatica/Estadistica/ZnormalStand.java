package chiroque.aplicaciones.com.escuelainformatica.Estadistica;

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
import jsc.distributions.Normal;


public class ZnormalStand extends ActionBarActivity {
private RadioButton rb1, rb2;
private EditText porc;
private TextView txtrpta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_znormal_stand);
        rb1=(RadioButton)findViewById(R.id.rbconfianza);
        rb2=(RadioButton)findViewById(R.id.rberror);
        porc=(EditText)findViewById(R.id.edtxporcznormst);
        txtrpta=(TextView)findViewById(R.id.txtrptaZnormEstand);
        porc.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        rb1.isChecked();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_znormal_stand, menu);
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

    public void hallarznormst(View view){
        try{
            double a=0.0;
            double val=Double.parseDouble(porc.getText().toString());
            if(val<=100){
                if(rb1.isChecked()==true){
                    a=1-(val/100);
                }else{
                    if(rb2.isChecked()==true){
                        a=val/100;
                    }
                }
                Normal n=new Normal(0,1);
                txtrpta.setText("Rpta: Z= "+n.inverseCdf(1-(a/2)));
            }else{
                txtrpta.setText("");
                Toast notificacion=Toast.makeText(this,"Porcentaje debe ser menor a 100.",Toast.LENGTH_LONG);
                notificacion.show();
            }
        }catch(Exception ex){
            txtrpta.setText("");
            Toast notificacion=Toast.makeText(this,"Datos vacíos o límite de valores.",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }
}
