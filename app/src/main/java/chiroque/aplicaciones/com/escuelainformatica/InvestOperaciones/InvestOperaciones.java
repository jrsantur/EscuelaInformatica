package chiroque.aplicaciones.com.escuelainformatica.InvestOperaciones;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class InvestOperaciones extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest_operaciones);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_invest_operaciones, menu);
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

    public void problemMochila(View view){
        startActivity(new Intent(this,ProblemaMochila.class));
    }
    public void problemDiligencia(View view){
        startActivity(new Intent(this,ProblemaDiligencia.class));
    }
    public void cadmarkovPotencia(View view){
        startActivity(new Intent(this,CadMarkovPotencia.class));
    }
    public void maxminSimplex(View view){
        startActivity(new Intent(this,SimplexMax.class));
    }

}
