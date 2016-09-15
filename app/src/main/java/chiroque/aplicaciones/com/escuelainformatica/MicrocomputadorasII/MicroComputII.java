package chiroque.aplicaciones.com.escuelainformatica.MicrocomputadorasII;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import chiroque.aplicaciones.com.escuelainformatica.Matematicas.Matematicas;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class MicroComputII extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro_computadoras_ii);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_micro_computadoras_ii, menu);
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

    public void funcionamComputador(View view){
        Intent i =new Intent(this, FuncComputador.class);
        startActivity(i);
    }

    public void arqInstruccion(View view){
        Intent i =new Intent(this, ArquitecturaInstruccion.class);
        startActivity(i);
    }

    public void cicloInstruccion(View view){
        Intent i =new Intent(this, CicloInstruccion.class);
        startActivity(i);
    }

    public void segmentacionInstr(View view){
        Intent i =new Intent(this, SegmInstrucciones.class);
        startActivity(i);
    }

    public void laMemoria(View view){
        Intent i =new Intent(this, Memoria.class);
        startActivity(i);
    }

    public void jerarqMemoria(View view){
        Intent i =new Intent(this, JerarquiaMemoria.class);
        startActivity(i);
    }

    public void converBinHexa(View view){
        Intent i =new Intent(this, ConversionBinHexa.class);
        startActivity(i);
    }


}
