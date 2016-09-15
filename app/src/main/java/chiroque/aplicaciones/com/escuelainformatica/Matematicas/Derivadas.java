package chiroque.aplicaciones.com.escuelainformatica.Matematicas;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class Derivadas extends ActionBarActivity {
private TextView rptaDeriv;
private EditText funcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derivadas);

        rptaDeriv=(TextView)findViewById(R.id.txtRptaDerivada);
        funcion=(EditText)findViewById(R.id.edtFuncion);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_derivadas, menu);
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

    public String derivar(String func){
    String derivada="";
    DJep derivar=new DJep();
    derivar.addStandardFunctions();
    derivar.addStandardConstants();
    derivar.addComplex();
    derivar.setAllowUndeclared(true);
    derivar.setAllowAssignment(true);
    derivar.setImplicitMul(true);
    derivar.addStandardDiffRules();

    try{
        Node node=derivar.parse(func);
        Node diff=derivar.differentiate(node,"x");
        Node sim=derivar.simplify(diff);
        derivada=derivar.toString(sim);
    }catch (ParseException e){
        Toast notificacion=Toast.makeText(this,"Escribir correctamente la funcion",Toast.LENGTH_LONG);
        notificacion.show();
    }

   return derivada;
    }

    public void btnDerivar(View view){
    String funct=funcion.getText().toString();
    String rpta=derivar(funct);
    rptaDeriv.setText(rpta);
    }
}
