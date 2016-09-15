package chiroque.aplicaciones.com.escuelainformatica.Matematicas;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import Jama.Matrix;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class SistemEcuaciones extends ActionBarActivity {
private Spinner spinnvar;
private Spinner spinnecuac;
private TableLayout tabla;
private LinearLayout layOperar;
private int numvar=2, numecuac=2;
private double [][] sisteq;
private double[] rhsArray; //matriz valores de c (Ejm: mx+ny=b)
private String [] nombrevar={"x","y","z","w","v"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistem_ecuaciones);

        spinnvar=(Spinner)findViewById(R.id.spinnumvar);
        spinnecuac=(Spinner)findViewById(R.id.spinnumecuac);
        tabla=(TableLayout)findViewById(R.id.tablaSistemaEcuac);
        layOperar=(LinearLayout)findViewById(R.id.layoutOperar);
        String []opciones1={"2","3","4","5"};
        String []opciones2={"2","3","4","5"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones2);
        spinnvar.setAdapter(adapter1);
        spinnecuac.setAdapter(adapter2);
    }

    public void aceptaNdatosNecuac(View view){
        layOperar.setVisibility(View.VISIBLE);
        numvar=Integer.parseInt(spinnvar.getSelectedItem().toString());
        numecuac=Integer.parseInt(spinnecuac.getSelectedItem().toString());
        tabla.removeAllViews();
        agregarCabecer();
        crearTable();
    }
    public void agregarCabecer(){
        TableRow fila=new TableRow(this);
        TextView celda;
        for (int i=0;i<numvar+2;i++){
            celda=new TextView(this);
            if (i!=numvar){
                if (i==numvar+1){
                    celda.setText("b");
                }else{
                    celda.setText(nombrevar[i]);
                }
            }else{
                celda.setText("=");
            }
            celda.setGravity(Gravity.CENTER);
            fila.addView(celda);
        }
        tabla.addView(fila);
    }
    public void crearTable(){
        TableRow fila;
        EditText celda;
        for(int i=0;i<numecuac;i++){
            fila=new TableRow(this);
            for (int j=0;j<numvar+2;j++){
                celda=new EditText(this);
                celda.setId((i*10)+j+2000);
                celda.setWidth(100);
                celda.setTextSize(14);
                celda.setTextColor(Color.BLACK);
                celda.setBackgroundResource(R.drawable.borde);
                celda.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
                if(j==numvar){
                    celda.setText("=");
                    celda.setEnabled(false);
                    celda.setGravity(Gravity.CENTER);
                }
                fila.addView(celda);
            }
            tabla.addView(fila);
        }
    }

    public void resolver(View view){
        try{
            sisteq=new double[numecuac][numvar];
            rhsArray=new double[numecuac];
            obtenerValors();
            Matrix lhs = new Matrix(sisteq);
            Matrix rhs = new Matrix(rhsArray, numecuac);

            //resuelve matriz
            Matrix ans = lhs.solve(rhs);
            for (int i=0;i<numvar;i++){
                System.out.println("x = " + Math.round(ans.get(i,0)));
            }
        }catch (Exception e){
            Toast notificacion=Toast.makeText(this,"Escribir los números de manera correcta",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }

    public void obtenerValors(){
        for(int i=0; i<numecuac;  i++) {
            for (int j=0; j<numvar; j++) {
                EditText labe=(EditText)findViewById((i*10)+j+2000);
                String valor=labe.getText().toString();
                if (valor.equals(""))
                    valor=0+"";
                sisteq[i][j]=Double.parseDouble(valor);
            }
            EditText labe=(EditText)findViewById((i*10)+(numvar+1)+2000);
            String valor=labe.getText().toString();
            if (valor.equals(""))
                valor=0+"";
            rhsArray[i]=Double.parseDouble(valor);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sistem_ecuaciones, menu);
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
}
