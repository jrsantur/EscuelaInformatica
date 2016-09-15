package chiroque.aplicaciones.com.escuelainformatica.Matematicas;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import Jama.Matrix;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class ProductoMatrices extends ActionBarActivity {
private TableLayout tablamatriz;
private Spinner spnm, spnn;
private Button mxn, x, resultado;
int m, n;
Matrix A, B, C;
double matriz [][];
double matresultado [][];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_matrices);
        tablamatriz=(TableLayout)findViewById(R.id.tablamatriz);
        mxn=(Button)findViewById(R.id.btnmxn);
        x=(Button)findViewById(R.id.btnx);
        resultado=(Button)findViewById(R.id.btnresultado);
        spnm =(Spinner)findViewById(R.id.spinm);
        spnn =(Spinner)findViewById(R.id.spinn);
        String []opciones={"2","3","4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spnm.setAdapter(adapter);
        spnn.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_producto_matrices, menu);
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
    public void okmxn(View view){
        m=Integer.parseInt(spnm.getSelectedItem().toString());
        n=Integer.parseInt(spnn.getSelectedItem().toString());
        generarTabla(m,n);
    }
    public void generarTabla(int filas,int columnas){
        tablamatriz.removeAllViews();
        TableRow fila;
        EditText celda;
        for(int i=0;i<filas;i++){
            fila=new TableRow(this);
            for(int j=0;j<columnas;j++){
                celda=new EditText(this);
                celda.setId(3700+(10*i)+j);
                celda.setTextSize(10);
                celda.setWidth(80);
                celda.setPadding(20, 8, 20, 4);
                celda.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                celda.setBackgroundResource(R.drawable.borde);
                fila.addView(celda);
            }
            tablamatriz.addView(fila);
        }
    }

    public void obtenerDatos(int filas,int columnas){
    matriz=new double[filas][columnas];
    for (int i=0;i<filas;i++){
        for (int j=0;j<columnas;j++){
            EditText labe=(EditText)findViewById(3700+(10*i)+j);
            String cad=labe.getText().toString();
            if (cad.equals("")){
                cad=0+"";
            }
            matriz[i][j]=Double.parseDouble(cad);
        }
     }
    }
    public void primerFactor(View view){
    mxn.setVisibility(View.INVISIBLE);
    x.setVisibility(View.INVISIBLE);
    resultado.setVisibility(View.VISIBLE);
    obtenerDatos(m, n);
    A=new Matrix(matriz);
    generarTabla(n,m);
    spnm.setVisibility(View.INVISIBLE);
    spnn.setVisibility(View.INVISIBLE);
    }

    public void multiplicar(View view){
    matresultado=new double[m][m];
    resultado.setVisibility(View.INVISIBLE);
    obtenerDatos(n, m);
    tablamatriz.removeAllViews();
    B=new Matrix(matriz);
    C=A.times(B);
    matresultado=C.getArray();
    TableRow fila;
    TextView celda;
    for (int i=0;i<m;i++){
        fila=new TableRow(this);
        for(int j=0;j<m;j++){
            celda=new TextView(this);
            celda.setText(matresultado[i][j]+"");
            celda.setBackgroundResource(R.drawable.borde);
            celda.setTextSize(10);
            celda.setWidth(80);
            celda.setPadding(20, 8, 20, 4);
            celda.setTextColor(Color.BLACK);
            fila.addView(celda);
        }
        tablamatriz.addView(fila);
    }
    }
}
