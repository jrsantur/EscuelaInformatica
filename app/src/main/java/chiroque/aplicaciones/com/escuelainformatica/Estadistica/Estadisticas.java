package chiroque.aplicaciones.com.escuelainformatica.Estadistica;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import chiroque.aplicaciones.com.escuelainformatica.R;


public class Estadisticas extends ActionBarActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_estadisticas, menu);
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

    public void chicuad(View view){
        startActivity(new Intent(this, ChiCuadrado.class));
    }
    public void disT(View view){
        startActivity(new Intent(this, Tstudent.class));
    }
    public void disN(View view){
        startActivity(new Intent(this, DistZnormal.class));
    }
    public void grafEstad(View view){
        startActivity(new Intent(this, GraficoEstadistico.class));
    }
    public void disH(View view){
        startActivity(new Intent(this, DistribHipergeomtrica.class));
    }
    public void disF(View view){
        startActivity(new Intent(this, DistribFisher.class));
    }
    public void disB(View view){
        startActivity(new Intent(this, DistribBinomial.class));
    }
    public void znormestand(View view){
        startActivity(new Intent(this, ZnormalStand.class));
    }
}
