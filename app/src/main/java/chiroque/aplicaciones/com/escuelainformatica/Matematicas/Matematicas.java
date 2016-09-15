package chiroque.aplicaciones.com.escuelainformatica.Matematicas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class Matematicas extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematicas);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_matematicas, menu);
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

    public void derivadas(View view){
        Intent i =new Intent(this, Derivadas.class);
        startActivity(i);
    }

    public void matrices(View view){
        Intent i =new Intent(this, Matrices.class);
        startActivity(i);
    }
    public void Prodmatrices(View view){
        Intent i =new Intent(this,ProductoMatrices.class);
        startActivity(i);
    }

    public void converAngulos(View view){
        Intent i =new Intent(this, ConversionAngulos.class);
        startActivity(i);
    }

    public void sistemaEcuaciones(View view){
        Intent i =new Intent(this, SistemEcuaciones.class);
        startActivity(i);
    }

    public void formulIntegrales(View view){
        Intent i =new Intent(this, FormulaIntegrales.class);
        startActivity(i);
    }
    public void IntegralNum(View view){
        Intent i =new Intent(this, IntegralNumerica.class);
        startActivity(i);
    }
}
