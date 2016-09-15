package chiroque.aplicaciones.com.escuelainformatica.Matematicas;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class ConversionAngulos extends ActionBarActivity {
private RadioButton rSexag1, rCent1, rRadian1, rSexag2, rCent2, rRadian2;
private TextView rpta;
private EditText angulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_angulos);

        rSexag1=(RadioButton)findViewById(R.id.radioBtnSexag1);
        rCent1=(RadioButton)findViewById(R.id.radioBtnCent1);
        rRadian1=(RadioButton)findViewById(R.id.radioBtnRadian1);

        rSexag2=(RadioButton)findViewById(R.id.radioBtnSexag2);
        rCent2=(RadioButton)findViewById(R.id.radioBtnCent2);
        rRadian2=(RadioButton)findViewById(R.id.radioBtnRadian2);
        angulo=(EditText)findViewById(R.id.edtxangulo);
        rpta=(TextView)findViewById(R.id.RptaConverAng);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_conversion_angulos, menu);
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

    public void convertirAngulo(View view){
         String cadenaAngle=angulo.getText().toString();
         cadenaAngle=cadenaAngle.replace("pi",""+Math.PI);
         String anglee="";
         DJep operar=new DJep();
         operar.addStandardFunctions();
         operar.addStandardConstants();
         operar.addComplex();
         operar.setAllowUndeclared(true);
         operar.setAllowAssignment(true);
         operar.setImplicitMul(true);
         operar.addStandardDiffRules();
         try{
             Node node=operar.parse(cadenaAngle);
             Node sim=operar.simplify(node);
             anglee=operar.toString(sim);
             double angle=Double.parseDouble(anglee);

             if (rSexag1.isChecked()==true && rCent2.isChecked()==true) {
                 double cent=200*angle/180;
                 rpta.setText(cent+" grad. cent.");
             }else
             if (rSexag1.isChecked()==true && rRadian2.isChecked()==true){
                 double rad=Math.PI*angle/180;
                 rpta.setText(rad+" rad");
             }else
             if (rCent1.isChecked()==true && rSexag2.isChecked()==true){
                 double sex=180*angle/200;
                 rpta.setText(sex+" ºsexag");
             }else
             if (rCent1.isChecked()==true && rRadian2.isChecked()==true){
                 double rad=Math.PI*angle/200;
                 rpta.setText(rad+" rad");
             }else
             if (rRadian1.isChecked()==true && rSexag2.isChecked()==true){
                 double sex=180*angle/Math.PI;
                 rpta.setText(sex+" ºsexag");
             }else
             if (rRadian1.isChecked()==true && rCent2.isChecked()==true){
                 double cent=200*angle/Math.PI;
                 rpta.setText(cent+" grad. cent.");
             }

         }catch (ParseException e){
             Toast notificacion=Toast.makeText(this,"Escribir correctamente la funcion",Toast.LENGTH_LONG);
             notificacion.show();
         }

    }

    /*
    public int mcd(int num1, int num2) {
        int mcd = 0;
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);
        do {
            mcd = b;
            b = a%b;
            a = mcd;
        } while(b!=0);
        return mcd;
    }
    */

}
