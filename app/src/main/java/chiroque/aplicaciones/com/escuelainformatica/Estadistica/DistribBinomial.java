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
import jsc.distributions.Binomial;


public class DistribBinomial extends ActionBarActivity {
private TextView resultMayor;
private TextView resultMayorIgual;
private TextView resultIgual;
private TextView resultMenorIgual;
private TextView resultMenor;
private EditText n;
private EditText p;
private EditText x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distrib_binomial);

        resultMayor=(TextView)findViewById(R.id.edtMayor);
        resultMayorIgual=(TextView)findViewById(R.id.edtMayorIgual);
        resultIgual=(TextView)findViewById(R.id.edtIgual);
        resultMenorIgual=(TextView)findViewById(R.id.edtMenorIgual);
        resultMenor=(TextView)findViewById(R.id.edtMenor);
        n=(EditText)findViewById(R.id.EdTn);
        p=(EditText)findViewById(R.id.EdTprob);
        x=(EditText)findViewById(R.id.EdTx);
        p.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_distrib_binomial, menu);
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

    public void obtenerProbBinom(View view){

     try{
         long N;
         double P;
         double X;
         String cadx=x.getText().toString();
         String cadp=p.getText().toString();
         if(cadx.equals("")){
             cadx=0+"";
         }
         if (cadp.equals("")){
             cadp=0+"";
         }

         N=Long.parseLong(n.getText().toString());
         P=Double.parseDouble(cadp);
         X=Double.parseDouble(cadx);

         Binomial bn=new Binomial(N,P);
         resultMenorIgual.setText(bn.cdf(X)+"");
         resultMenor.setText((bn.cdf(X)-bn.pdf(X))+"");
         resultIgual.setText(bn.pdf(X)+"");
         resultMayor.setText((1-bn.cdf(X))+"");
         resultMayorIgual.setText((1-bn.cdf(X)+bn.pdf(X))+"");


     }catch (Exception e){
         Toast notificacion=Toast.makeText(this,"Ingrese valores adecuados",Toast.LENGTH_LONG);
         notificacion.show();
     }
    }
}
