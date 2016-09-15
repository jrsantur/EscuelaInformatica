package chiroque.aplicaciones.com.escuelainformatica.Estadistica;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import chiroque.aplicaciones.com.escuelainformatica.R;
import jsc.distributions.StudentsT;


public class Tstudent extends ActionBarActivity {
private Spinner spingl;
private EditText textt;
private EditText gradl;
private EditText etTr;
private TextView tv1;
private Spinner spsigno;
public double gl=0;
public double t=0;
public double p=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tstudent);

        gradl=(EditText)findViewById(R.id.Textgradlib);
        textt=(EditText)findViewById(R.id.textT);
        tv1=(TextView)findViewById(R.id.textview1);
        etTr=(EditText)findViewById(R.id.editTresult);
        spsigno=(Spinner)findViewById(R.id.spinsigno);

        String []opciones={"<",">"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spsigno.setAdapter(adapter);

        textt.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
        gradl.setInputType(InputType.TYPE_CLASS_NUMBER);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tstudent, menu);
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

    public void valordeT(View view){
    try{
        String valorgl=gradl.getText().toString();
        String valort=textt.getText().toString();
        if (valort.equals("")){
            valort=0+"";
        }

        if (valorgl.equals("")){
            valorgl=0+"";
        }
        gl=Double.parseDouble(valorgl);
        t=Double.parseDouble(valort);

        StudentsT st =new StudentsT(gl);

        String selec=spsigno.getSelectedItem().toString();
        p=st.cdf(t);
        if (selec.equals(">")) {
            p=1-p;
        }

        String cad="p ( t "+selec+ ""+t+ ") es:";
        tv1.setText(cad);
        etTr.setText(p+"");

    }catch (Exception e){
        Toast notificacion=Toast.makeText(this,"Ingrese valores adecuados",Toast.LENGTH_LONG);
        notificacion.show();
    }
    }

}
