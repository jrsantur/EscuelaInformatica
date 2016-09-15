package chiroque.aplicaciones.com.escuelainformatica.Estadistica;

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
import jsc.distributions.ChiSquared;


public class ChiCuadrado extends ActionBarActivity {
private EditText etGL;
private EditText etProb;
private TextView resultChi2;
private double chiResult;
private double gl;
private double prob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_cuadrado);

        resultChi2=(TextView)findViewById(R.id.ResultChi2);
        etGL=(EditText)findViewById(R.id.editTextGL);
        etProb=(EditText)findViewById(R.id.editTextProb);

        etGL.setInputType(InputType.TYPE_CLASS_NUMBER);
        etProb.setInputType(InputType.TYPE_CLASS_NUMBER |InputType.TYPE_NUMBER_FLAG_DECIMAL);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chi_cuadrado, menu);
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
    public void aceptarChi(View view){
     try{
         prob=Double.parseDouble(etProb.getText().toString());
         gl=Double.parseDouble(etGL.getText().toString());

         ChiSquared chs=new ChiSquared(gl);
         chiResult=chs.inverseCdf(1-prob);
         resultChi2.setText(chiResult+"");

     }catch (Exception e){
         Toast notificacion=Toast.makeText(this,"Ingrese valores adecuados",Toast.LENGTH_LONG);
         notificacion.show();
      }
    }
}
