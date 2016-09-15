package chiroque.aplicaciones.com.escuelainformatica.MicrocomputadorasI;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class MicrocomputI extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microcomputadoras_i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_microcomputadoras_i, menu);
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

    public void arquitect8086(View view){
        Intent i =new Intent(this, Arquitectura8086.class);
        startActivity(i);
    }
    public void registr8086(View view){
        Intent i =new Intent(this, Registros8086.class);
        startActivity(i);
    }
    public void memoriasegm(View view){
        Intent i =new Intent(this, MemoriaSegm.class);
        startActivity(i);
    }
    public void memoriadirec(View view){
        Intent i =new Intent(this, MemDirecc.class);
        startActivity(i);
    }
    public void asemblercomandos(View view){
        Intent i =new Intent(this, AsemblerFormComandos.class);
        startActivity(i);
    }
    public void interrup(View view){
        Intent i =new Intent(this, Interrupciones.class);
        startActivity(i);
    }
    public void entrsalid8086(View view){
        Intent i =new Intent(this, ES8086.class);
        startActivity(i);
    }
    public void contr8259(View view){
        Intent i =new Intent(this, Controlador8259.class);
        startActivity(i);
    }
    public void cop8087(View view){
        Intent i =new Intent(this, Copr8087.class);
        startActivity(i);
    }
}
