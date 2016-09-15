package chiroque.aplicaciones.com.escuelainformatica.SimulacionDeSistemas;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import jsc.distributions.Binomial;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class ProcesoBinomial extends ActionBarActivity {
private TableLayout tabla;
private EditText txtn, txtp, txta, txtb;
private TextView lblentre;
private Button btngenerardec, btngenerarfrac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_binomial);
        btngenerardec=(Button)findViewById(R.id.btnGenerarBinDec);
        btngenerarfrac=(Button)findViewById(R.id.btnGenerarBinFrac);
        lblentre=(TextView)findViewById(R.id.labelentreBin);
        tabla=(TableLayout)findViewById(R.id.tablaBinomial);
        txtn=(EditText)findViewById(R.id.txtNensayosBin);
        txta=(EditText)findViewById(R.id.txtprobbinNum);
        txtb=(EditText)findViewById(R.id.txtprobbinDenom);
        txtp=(EditText)findViewById(R.id.txtprobBinDecimal);
        txtn.setInputType(InputType.TYPE_CLASS_NUMBER);
        txta.setInputType(InputType.TYPE_CLASS_NUMBER);
        txtb.setInputType(InputType.TYPE_CLASS_NUMBER);
        txtp.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_proceso_binomial, menu);
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
    public void vaciarformularioBin(View view){
        tabla.removeAllViews();
        txtn.setText("");
        efectoDecimal();
        efectoFraccionario();
    }
    public void okFraccion(View view){
        btngenerarfrac.setVisibility(View.VISIBLE);
        efectoFraccionario();
        txta.setVisibility(View.VISIBLE);
        lblentre.setVisibility(View.VISIBLE);
        txtb.setVisibility(View.VISIBLE);
    }

    public void okDecimal(View view){
     btngenerardec.setVisibility(View.VISIBLE);
     efectoDecimal();
     txtp.setVisibility(View.VISIBLE);
    }
    public void efectoFraccionario(){
        btngenerardec.setVisibility(View.INVISIBLE);
        txtp.setVisibility(View.INVISIBLE);
        txtp.setText("");
    }
    public void efectoDecimal(){
       btngenerarfrac.setVisibility(View.INVISIBLE);
       txta.setVisibility(View.INVISIBLE);
       lblentre.setVisibility(View.INVISIBLE);
       txtb.setVisibility(View.INVISIBLE);
       txta.setText("");
       txtb.setText("");
    }
    public void generarBinomialDec(View view){
        try{
            if(txtn.getText()!=null){
                if(txtp.getText()!=null){
                    double p=Double.parseDouble(txtp.getText().toString());
                    txta.setText("");
                    txtb.setText("");
                    if(p<1){
                        int n=Integer.parseInt(txtn.getText().toString());
                        processBinomial(n,p);
                    }else{
                        Toast notificacion=Toast.makeText(this,"Probabilidad debe ser menor a 1",Toast.LENGTH_LONG);
                        notificacion.show();
                        tabla.removeAllViews();
                    }
                }
            }
        }catch (Exception ex){
            Toast notificacion=Toast.makeText(this,"Datos vacíos o límite de valores.",Toast.LENGTH_LONG);
            notificacion.show();
        }

    }
    public void generarBinomialFrac(View view){
        try{
            if(txta.getText()!=null && txtb.getText()!=null){
                txtp.setText("");
                int n=Integer.parseInt(txtn.getText().toString());
                int a=Integer.parseInt(txta.getText().toString());
                int b=Integer.parseInt(txtb.getText().toString());
                if(a<b){
                    double p=((double)a)/b;
                    processBinomial(n,p);
                }else{
                    Toast notificacion=Toast.makeText(this,"Probabilidad debe ser menor a 1",Toast.LENGTH_LONG);
                    notificacion.show();
                    tabla.removeAllViews();
                }
            }
        }catch (Exception ex){
            Toast notificacion=Toast.makeText(this,"Datos vacíos o límite de valores.",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }
    public void agregarcabecera(){
        TableRow fila=new TableRow(this) ;
        TextView celda;
        for(int i=0;i<3;i++){
            celda=new TextView(this);
            celda.setGravity(Gravity.CENTER);
            celda.setTextColor(Color.BLUE);
            celda.setWidth(80);
            celda.setTextSize(10);
            celda.setPadding(2,2,2,2);
            celda.setBackgroundResource(R.drawable.borde);
            fila.addView(celda);
            if(i==0){
                celda.setText("x");
            }else{
                if(i==1){
                    celda.setText("f(x) ó r");
                }else{
                    celda.setText("F(x)");
                }
            }
        }
        tabla.addView(fila);
    }

    public void processBinomial(int n,double p){
     tabla.removeAllViews();
     TableRow fila ;
     TextView celda;
     agregarcabecera();
     Binomial bn=new Binomial(n,p);
     double Fx=0.0, val=0.0;
        for(int i=0;i<=n;i++){
            fila=new TableRow(this);
            for(int j=0;j<3;j++){
                celda=new TextView(this);
                celda.setHeight(40);
                celda.setTextSize(15);
                if(j==0){
                    celda.setWidth(30);
                    celda.setText((i)+"");
                }else{
                    if(j==1){
                        celda.setWidth(380);
                        val=bn.pdf(i);
                        Fx=Fx+val;
                        celda.setText(val+"");

                    }else{
                        celda.setWidth(380);
                        celda.setText(Fx+"");
                    }
                }
                celda.setTextColor(Color.BLACK);
                celda.setGravity(Gravity.CENTER);
                celda.setBackgroundResource(R.drawable.borde);
                fila.addView(celda);
            }
            tabla.addView(fila);
        }

    }
}
