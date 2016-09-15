package chiroque.aplicaciones.com.escuelainformatica.InvestOperaciones;

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
import java.text.DecimalFormat;
import java.util.EmptyStackException;

import Jama.Matrix;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class CadMarkovPotencia extends ActionBarActivity {
private TableLayout tabla;
private TableLayout tabla2;
private Spinner numEstados;
private LinearLayout layMatrizEstado;
private int nestados=0;
private EditText npotencia;
double a [][];
double b [][];
Matrix A, B, C;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_markov_potencia);
        tabla=(TableLayout)findViewById(R.id.tablaMatrizEstado);
        tabla2=(TableLayout)findViewById(R.id.tablarptamatrizpotencia);
        layMatrizEstado=(LinearLayout)findViewById(R.id.layoutMatrizEstado);
        npotencia=(EditText)findViewById(R.id.edtNpotencia);
        numEstados=(Spinner)findViewById(R.id.spinNumEstados);
        String []opciones={"2","3","4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        numEstados.setAdapter(adapter);

    }

    public void crearTabla(View view){
    layMatrizEstado.setVisibility(View.VISIBLE);
    nestados=Integer.parseInt(numEstados.getSelectedItem().toString());
    tabla.removeAllViews();
    TableRow fila;
    EditText celda;
    TextView etiqueta;

    agregarCabecera(tabla);
    for (int i=0;i<nestados;i++){
    fila=new TableRow(this);
    etiqueta=new TextView(this);
    etiqueta.setTextSize(10);
    etiqueta.setPadding(20, 8, 20, 4);
    etiqueta.setText("E"+i);
    etiqueta.setTextColor(Color.BLACK);
    fila.addView(etiqueta);

        for (int j=0;j<nestados;j++){
        celda=new EditText(this);
        celda.setId(3600+((10*i)+j));
        celda.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        celda.setWidth(80);
        celda.setTextSize(10);
        celda.setPadding(20,8,20,4);
        celda.setBackgroundResource(R.drawable.borde);
        fila.addView(celda);
        }

     tabla.addView(fila);
    }
   }

    public void agregarCabecera(TableLayout tabl){
    TableRow fila=new TableRow(this);
    TextView label;
        for (int i=0;i<nestados+1;i++){
        label=new TextView(this);
        if (i==0){
          label.setText("Estados");
          label.setTextSize(10);
          label.setTextColor(Color.BLACK);
          label.setGravity(Gravity.CENTER);
         }else{
          label.setText("E"+i);
          label.setTextSize(10);
          label.setTextColor(Color.BLACK);
          label.setGravity(Gravity.CENTER);
        }
        fila.addView(label);
       }
       tabl.addView(fila);

    }


    public void elevarMatriz(View view){
    try{
        tabla2.removeAllViews();
        obtenerDatos();
        A=new Matrix(a);
        B=A;
        int n=0;
        n=Integer.parseInt(npotencia.getText().toString());
        for(int i=2;i<=n;i++){
            C=B.times(A);
            B=C;
        }
        b=B.getArray();

        TableRow fila;
        TextView etiqueta, columnaestado;
        agregarCabecera(tabla2);
        for(int i=0;i<nestados;i++){
            fila=new TableRow(this);
            columnaestado=new TextView(this);
            columnaestado.setText("E"+i);
            columnaestado.setTextSize(10);
            columnaestado.setTextColor(Color.BLACK);
            columnaestado.setGravity(Gravity.CENTER);
            fila.addView(columnaestado);
            for(int j=0;j<nestados;j++){
                etiqueta=new TextView(this);
                etiqueta.setBackgroundResource(R.drawable.borde);
                DecimalFormat dt = new DecimalFormat("#.##");
                etiqueta.setText(dt.format(b[i][j])+"");
                etiqueta.setTextSize(10);
                etiqueta.setPadding(10,8,10,4);
                etiqueta.setGravity(Gravity.CENTER);
                fila.addView(etiqueta);
            }
            tabla2.addView(fila);
        }
    }catch(Exception e){
        Toast notificacion=Toast.makeText(this,"Ingrese parámetros correctos",Toast.LENGTH_LONG);
        notificacion.show();
    }

    }

    public void obtenerDatos(){
        a=new double[nestados][nestados];
        for(int i=0;i<nestados;i++){
            for (int j=0;j<nestados;j++){
                EditText labe=(EditText)findViewById(3600+((10*i)+j));
                String cad=labe.getText().toString();
                if (cad.equals("")){
                    cad=0+"";
                }
                if (Double.parseDouble(cad)>=1){
                    throw new EmptyStackException();
                }
                a[i][j]=Double.parseDouble(cad);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cad_markov_potencia, menu);
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
