package chiroque.aplicaciones.com.escuelainformatica.Matematicas;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.nfunk.jep.JEP;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class IntegralNumerica extends ActionBarActivity {
private EditText a, b, fx, n;
private TextView txtriemman, txttrapecios, txtsimpson13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral_numerica);

        a=(EditText)findViewById(R.id.edtxa);
        fx=(EditText)findViewById(R.id.edtxfuncion);
        b=(EditText)findViewById(R.id.edtxb);
        n=(EditText)findViewById(R.id.edtxn);
        txtriemman=(TextView)findViewById(R.id.textriemman);
        txttrapecios=(TextView)findViewById(R.id.texttrapecios);
        txtsimpson13=(TextView)findViewById(R.id.textsimpson13);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_integral_numerica, menu);
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

    public void riemman(View view){
        try{
            JEP objj=new JEP();
            objj.addStandardFunctions(); //agrega funciones
            objj.addStandardConstants(); //agrega constantes e, pi
            objj.setImplicitMul(true);

            objj.parseExpression(a.getText().toString());
            double a=objj.getValue();

            objj.parseExpression(b.getText().toString());
            double b=objj.getValue();

            int npart=Integer.parseInt(n.getText().toString());
            double h=(b-a)/npart;
            double x[]=new double[npart+1];
            double fxi[]=new double[npart+1];
            x[0]=a;
            x[npart]=b;

            for (int i=1;i<x.length-1;i++){
                x[i]=x[0]+(i*h);
            }
            double m=0;
            for (int i=0;i<x.length;i++){
                fxi[i]=objj.addVariable("x",x[i]);
                objj.parseExpression(fx.getText().toString());
                fxi[i]=objj.getValue();
            }

            for (int i=0;i<x.length;i++){
                m=m+fxi[i];
            }
            m=h*m;
            txtriemman.setText(m+"");

        }catch(Exception e){
            Toast notificacion=Toast.makeText(this,"Escribir correctamente la funcion",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }

    public void trapecios(View view){
      try{
          JEP objj=new JEP();
          objj.addStandardFunctions(); //agrega funciones
          objj.addStandardConstants(); //agrega constantes e, pi
          objj.setImplicitMul(true);

          objj.parseExpression(a.getText().toString());
          double a=objj.getValue();

          objj.parseExpression(b.getText().toString());
          double b=objj.getValue();

          int npart=Integer.parseInt(n.getText().toString());
          double h=(b-a)/npart;
          double x[]=new double[npart+1];
          double fxi[]=new double[npart+1];
          x[0]=a;
          x[npart]=b;

          for (int i=1;i<x.length-1;i++){
              x[i]=x[0]+(i*h);
          }
          double m=0;
          for (int i=0;i<x.length;i++){
              fxi[i]=objj.addVariable("x",x[i]);
              objj.parseExpression(fx.getText().toString());
              fxi[i]=objj.getValue();
          }

          for (int i=1;i<x.length-1;i++){
              m=m+(2*fxi[i]);
          }
          m=m+fxi[0]+fxi[npart];
          m=(h*m)/2;
          txttrapecios.setText(m+"");

      }catch (Exception e){
          Toast notificacion=Toast.makeText(this,"Escribir correctamente la funcion",Toast.LENGTH_LONG);
          notificacion.show();
      }
    }

    public void simpson13(View view){
        try{
            JEP objj=new JEP();
            objj.addStandardFunctions(); //agrega funciones
            objj.addStandardConstants(); //agrega constantes e, pi
            objj.setImplicitMul(true);

            objj.parseExpression(a.getText().toString());
            double a=objj.getValue();

            objj.parseExpression(b.getText().toString());
            double b=objj.getValue();

            int npart=Integer.parseInt(n.getText().toString());
            if (npart%2!=0){
                throw new Exception("error");
            }
            double h=(b-a)/npart;
            double x[]=new double[npart+1];
            double fxi[]=new double[npart+1];
            x[0]=a;
            x[npart]=b;

            for (int i=1;i<x.length-1;i++){
                x[i]=x[0]+(i*h);
            }
            double m=0;
            for (int i=0;i<x.length;i++){
                fxi[i]=objj.addVariable("x",x[i]);
                objj.parseExpression(fx.getText().toString());
                fxi[i]=objj.getValue();
            }

            for (int i=1;i<x.length-1;i++){
                if (i%2!=0){
                    m=m+(4*fxi[i]);
                }else{
                    m=m+(2*fxi[i]);
                }
            }
            m=m+fxi[0]+fxi[npart];
            m=(h*m)/3;
            txtsimpson13.setText(m+"");



        }catch(Exception e){
            Toast notificacion=Toast.makeText(this,"Escribir correctamente la funcion",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }

    public void resetearform(View view){
        a.setText("");
        fx.setText("");
        b.setText("");
        n.setText("");
        txtriemman.setText("");
        txttrapecios.setText("");
    }
}
