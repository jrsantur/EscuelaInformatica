package chiroque.aplicaciones.com.escuelainformatica.Estadistica;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;


import chiroque.aplicaciones.com.escuelainformatica.Estadistica.GraficosEstadisticos.BarChartPLOT;
import chiroque.aplicaciones.com.escuelainformatica.Estadistica.GraficosEstadisticos.GraficoPLOT;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class GraficoEstadistico extends ActionBarActivity {
private Spinner spinnumdatos;
private Spinner spintipograf;
private TableLayout tabladata;
private Button btn;
private int n=0;
private String selec2="Sectores";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_estadistico);

        spinnumdatos=(Spinner) findViewById(R.id.spinnumdatos);
        spintipograf=(Spinner) findViewById(R.id.spintipodegrafico);
        String [] opciones1={"Sectores","De Barras"};
        String []opciones={"1","2","3","4","5","6","7","8","9","10"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones1);
        spinnumdatos.setAdapter(adapter);
        spintipograf.setAdapter(adapter1);

        tabladata=(TableLayout)findViewById(R.id.tabladedatos);
        btn=(Button)findViewById(R.id.graficar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_grafico_estadistico, menu);
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

    public void agregarcabecera(String tipodegrafico){

    TableRow fila;
    EditText textcabecera;
    fila=new TableRow(this);
    if(tipodegrafico.equals("Sectores")|| tipodegrafico.equals("De Barras") ){
         textcabecera=new EditText(this);
         textcabecera.setText("x (Serie)");
         textcabecera.setGravity(Gravity.CENTER);
         textcabecera.setBackgroundResource(R.drawable.borde);
         fila.addView(textcabecera);
         textcabecera=new EditText(this);
         textcabecera.setText("Frecuencia");
         textcabecera.setGravity(Gravity.CENTER);
         textcabecera.setBackgroundResource(R.drawable.borde);
         fila.addView(textcabecera);
         tabladata.addView(fila);
    }
    }
    public void creartabla(int nm,String tipodegrafico){
    TableRow fila ;
    EditText celda;

    for(int i=0;i<nm;i++){
        fila=new TableRow(this);
        for (int j=0;j<2;j++){
            celda=new EditText(this);
            celda.setId(100+(i*10)+j);
            if (j==1){
                celda.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            }
            celda.setWidth(100);
            celda.setBackgroundResource(R.drawable.borde);
            fila.addView(celda);
        }
        tabladata.addView(fila);
     }
    }

    public void oktablaparallenar(View view){
    String selec=spinnumdatos.getSelectedItem().toString();
    selec2=spintipograf.getSelectedItem().toString();
    n=0;
    n=Integer.parseInt(selec);

    tabladata.removeAllViews();
    agregarcabecera(selec2);
    creartabla(n,selec2);
    btn.setVisibility(View.VISIBLE);
    }

    public void ObtenerDatosSimple(int nm,Intent i){
      i.putExtra("numero",nm+"");
        for(int x=0;x<nm;x++){
            for (int y=0;y<2;y++){
                EditText labe = (EditText) findViewById(100+(x*10)+y);
                if(y==1){
                    String val=labe.getText().toString();
                    if (val.equals(""))
                        val="0";
                    i.putExtra("valor"+x,val);
                }else
                    if(y==0){
                        String ser=labe.getText().toString();
                        if (ser.equals(""))
                            ser="Indefinido";
                        i.putExtra("serie"+x,ser);
                    }
            }
        }

       startActivity(i);

    }

    public void Graficar(View view){

        if (selec2.equals("Sectores")){
            Intent i=new Intent(this, GraficoPLOT.class);
            ObtenerDatosSimple(n,i);
        }else
        if (selec2.equals("De Barras")){
            Intent i=new Intent(this, BarChartPLOT.class);
            ObtenerDatosSimple(n,i);
        }
    }
}
