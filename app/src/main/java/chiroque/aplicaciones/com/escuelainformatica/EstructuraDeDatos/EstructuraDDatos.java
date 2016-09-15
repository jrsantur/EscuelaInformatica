package chiroque.aplicaciones.com.escuelainformatica.EstructuraDeDatos;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class EstructuraDDatos extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estructura_de_datos);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_estructura_de_datos, menu);
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

    public void abrirActivityTiposDeDatos(View view){
        Intent i =new Intent(this, TiposDeDatos.class);
        startActivity(i);
    }

    public void abrirActivityAlgoritmosOrdenamArreglos(View view){
        Intent i =new Intent(this, AlgoritmOrdenacionArreglos.class);
        startActivity(i);
    }

    public void abrirActivityPilas(View view){
        Intent i =new Intent(this, Pilas.class);
        startActivity(i);
    }

    public void abrirActivityRecursividad(View view){
        Intent i =new Intent(this, Recursividad.class);
        startActivity(i);
    }

    public void abrirActivityListasEnlazadas(View view){
        Intent i =new Intent(this, ListasEnlazadas.class);
        startActivity(i);
    }

    public void abrirActivityArboles(View view){
        Intent i =new Intent(this, Arboles.class);
        startActivity(i);
    }
}
