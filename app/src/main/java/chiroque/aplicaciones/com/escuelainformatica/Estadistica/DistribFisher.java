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
import jsc.distributions.FishersF;


public class DistribFisher extends ActionBarActivity {
private EditText gl1;
private EditText gl2;
private EditText alfa;
private TextView ResultF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distrib_fisher);

        gl1=(EditText)findViewById(R.id.textgl1);
        gl2=(EditText)findViewById(R.id.textgl2);
        alfa=(EditText)findViewById(R.id.textalfa);
        ResultF=(TextView)findViewById(R.id.textResultF);

        alfa.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_distrib_fisher, menu);
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

    public void hallarFisher(View view){
    try{
        String alf=alfa.getText().toString();
        if (alf.equals("")){
            alf=0+"";
        }
        double g1=Double.parseDouble(gl1.getText().toString());
        double g2=Double.parseDouble(gl2.getText().toString());
        double a=Double.parseDouble(alf);
        FishersF fsh=new FishersF(g1,g2);

        ResultF.setText(fsh.inverseCdf(1-a)+"");

    }catch (Exception e){
        Toast notificacion=Toast.makeText(this,"Ingrese valores adecuados",Toast.LENGTH_LONG);
        notificacion.show();
     }
    }
}
