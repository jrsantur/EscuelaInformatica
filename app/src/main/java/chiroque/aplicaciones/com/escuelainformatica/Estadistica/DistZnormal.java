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
import jsc.distributions.Normal;


public class DistZnormal extends ActionBarActivity {
private EditText media;
private EditText desvtip;
private EditText x1;
private EditText x2;
private TextView tprobT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dist_znormal);

        media=(EditText)findViewById(R.id.textMedia);
        desvtip=(EditText)findViewById(R.id.textDesv);
        x1=(EditText)findViewById(R.id.x1);
        x2=(EditText)findViewById(R.id.x2);
        tprobT=(TextView)findViewById(R.id.textViewProbT);

        media.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        desvtip.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        x1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        x2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dist_znormal, menu);
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

    public void zValor(View view){

        try{
            double u=0;
            double desv=0;
            double X1=0;
            double X2=0;
            double P=0,p1=0,p2=0;

            u=validarRetornaValor(media);
            desv=validarRetornaValor(desvtip);
            X1=validarRetornaValor(x1);
            X2=validarRetornaValor(x2);

            Normal obj=new Normal(u,desv);

            if (u!=0 && desv!=0 && (X1!=0 || X2!=0)){
                if (X2!=0){
                    p2=obj.cdf(X2);
                }
                if (X1!=0){
                    p1=obj.cdf(X1);
                }
                P=p2-p1;
            }
            tprobT.setText(P+"");

        }catch (Exception e){
              Toast notificacion=Toast.makeText(this,"Ingrese valores adecuados",Toast.LENGTH_LONG);
              notificacion.show();
        }
    }

    public double validarRetornaValor(EditText ed){
        double valor;
        String val=ed.getText().toString();
         if (val.equals("")){
             val=0+"";
         }
        valor=Double.parseDouble(val);
        return valor;
    }
}
