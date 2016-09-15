package chiroque.aplicaciones.com.escuelainformatica.InvestOperaciones;

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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import chiroque.aplicaciones.com.escuelainformatica.InvestOperaciones.metodosimplex.Simplex;
import chiroque.aplicaciones.com.escuelainformatica.InvestOperaciones.metodosimplex.Problema;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class SimplexMax extends ActionBarActivity {
private Spinner spnrest;
private LinearLayout layPanelLlenar;
private TableLayout tablarestricciones;
private EditText edtFuncion;
private TextView txtResultMax;
private Button resolver;
Problema problema;
boolean accionMax=true;
private int nRest = 0, nVar = 0;
String [] valores={"x1","x2","x3","x4"};
String [][] restricciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplex);

        spnrest=(Spinner)findViewById(R.id.spnnrest);
        layPanelLlenar=(LinearLayout)findViewById(R.id.layParaLlenar);
        tablarestricciones=(TableLayout)findViewById(R.id.tablaRestricciones);
        edtFuncion=(EditText)findViewById(R.id.editFuncionMax);
        txtResultMax=(TextView)findViewById(R.id.txtrptaMax);
        txtResultMax.setTextColor(Color.BLACK);
        resolver=(Button)findViewById(R.id.btnResolver);

        String [] opciones={"2","3","4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spnrest.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simplex_max, menu);
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
    public void generarTablas(View view){
    resolver.setVisibility(View.VISIBLE);
    tablarestricciones.removeAllViews();
    ponercabecera();
    layPanelLlenar.setVisibility(View.VISIBLE);
    nRest=Integer.parseInt(spnrest.getSelectedItem().toString());
    String [] opciones={"<=","=",">="};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
    TableRow fila;
    for (int i=0;i<nRest;i++){
        fila=new TableRow(this);
        EditText labe;
        Spinner spnsign;
        for (int j=0;j<3;j++){
            if(j==1) {
                spnsign=new Spinner(this);
                spnsign.setId(3000+((10*i)+j));
                spnsign.setAdapter(adapter);
                fila.addView(spnsign);
            }else{
               if(j==0){
                   labe=new EditText(this);
                   labe.setId(3000+((10*i)+j));
                   labe.setWidth(200);
                   labe.setBackgroundResource(R.drawable.borde);
                   labe.setTextSize(15);
                   labe.setPadding(10,8,10,4);
                   fila.addView(labe);
               }else{
                   labe=new EditText(this);
                   labe.setId(3000+((10*i)+j));
                   labe.setWidth(80);
                   labe.setBackgroundResource(R.drawable.borde);
                   labe.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
                   labe.setTextSize(15);
                   labe.setPadding(10, 8, 10, 4);
                   fila.addView(labe);
               }
            }
        }
        tablarestricciones.addView(fila);
    }
    }
    public void ponercabecera(){
    TableRow fila=new TableRow(this);
    TextView label=new TextView(this);
    label.setText("Restricción Ejemplo (3x1+4x2 <= 12)");
    fila.addView(label);
    tablarestricciones.addView(fila);
    }

    public void capturarDatos(){
        restricciones=new String[nRest][3];
        EditText labe;
        Spinner spinsigno;
        for (int i=0;i<nRest;i++){
            for (int j=0;j<3;j++){
                if (j==1){
                    spinsigno=(Spinner)findViewById(3000+((10*i)+j));
                    restricciones[i][j]=spinsigno.getSelectedItem().toString();
                }else{
                    labe=(EditText)findViewById(3000+((10*i)+j));
                    restricciones[i][j]=labe.getText().toString();
                }

            }
        }
    }

    public void resolverMax(View view){
       try{
            capturarDatos();
            problema = new Problema(true);
            problema.borrarTodo();
            problema.setFuncionObjetivo(Simplex.capturar(edtFuncion.getText().toString()));

        for (int i = 0; i < nRest; i++) {

            problema.nuevaRestriccion(restricciones[i][0],restricciones[i][1],restricciones[i][2]);

        }
            problema.preparar();
           txtResultMax.setVisibility(View.VISIBLE);
           txtResultMax.setText(problema.resolverMetodoSimplex());
        }catch (Exception e){
           Toast notificacion=Toast.makeText(this,"El problema planteado no tiene solución",Toast.LENGTH_LONG);
           notificacion.show();
        }
    }

}
