package chiroque.aplicaciones.com.escuelainformatica.MicrocomputadorasI;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class AsemblerFormComandos extends ActionBarActivity{
private Spinner spincomando;
private TextView titulo;
private TextView teoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asembler_form_comandos);
        titulo=(TextView)findViewById(R.id.title_instrucciones);
        teoria=(TextView)findViewById(R.id.teoria_instrucciones);

        spincomando = (Spinner) findViewById(R.id.spincomando);
        String []opciones={"Movimiento de datos","Operaciones Aritméticas","Lógicas","Desplazamientos y rotaciones","E/S por puertos","Operaciones de stack","Transferencia de control"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spincomando.setAdapter(adapter);

        spincomando.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String selec=spincomando.getSelectedItem().toString();
            titulo.setText(selec);
            if(selec.equals("Movimiento de datos")){
                teoria.setText(R.string.c1_asembler_form_comandos);
            }else
            if(selec.equals("Operaciones Aritméticas")){
                teoria.setText(R.string.c2_asembler_form_comandos);
            }else
            if(selec.equals("Lógicas")){
                teoria.setText(R.string.c3_asembler_form_comandos);
            }else
            if(selec.equals("Desplazamientos y rotaciones")){
                teoria.setText(R.string.c4_asembler_form_comandos);
            }else
            if(selec.equals("E/S por puertos")){
                teoria.setText(R.string.c5_asembler_form_comandos);
            }else
            if(selec.equals("Operaciones de stack")){
                teoria.setText(R.string.c6_asembler_form_comandos);
            }else
            if(selec.equals("Transferencia de control")){
                teoria.setText(R.string.c7_asembler_form_comandos);
            }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_asembler_form_comandos, menu);
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
