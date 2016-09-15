package chiroque.aplicaciones.com.escuelainformatica.Estadistica;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import chiroque.aplicaciones.com.escuelainformatica.R;
import jsc.distributions.Hypergeometric;


public class DistribHipergeomtrica extends ActionBarActivity {
private EditText edtN;
private EditText edtn;
private EditText edta;
private EditText edtx;
private TextView txtresult1, txtresult2;
private int N, n ,a, x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distrib_hipergeomtrica);

        edtN=(EditText)findViewById(R.id.etNpob);
        edtn=(EditText)findViewById(R.id.etn);
        edta=(EditText)findViewById(R.id.eta);
        edtx=(EditText)findViewById(R.id.etx);
        txtresult1=(TextView)findViewById(R.id.txtResultH1);
        txtresult2=(TextView)findViewById(R.id.txtResultH2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_distrib_hipergeomtrica, menu);
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

    public void probHiperg(View view){
        try{

            N=Integer.parseInt(edtN.getText().toString());
            n=Integer.parseInt(edtn.getText().toString());
            a=Integer.parseInt(edta.getText().toString());
            String xstr=edtx.getText().toString();
            if (xstr.equals("")){
                xstr=0+"";
            }
            x=Integer.parseInt(xstr);

            Hypergeometric hg=new Hypergeometric(n,N,a);

            txtresult1.setText("  "+hg.cdf(x)+"");
            txtresult1.setTextColor(Color.BLUE);
            txtresult2.setText("  "+hg.pdf(x)+"");
            txtresult2.setTextColor(Color.BLUE);

        }catch (Exception e){
            Toast notificacion=Toast.makeText(this,"Ingrese valores adecuados",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }
}
