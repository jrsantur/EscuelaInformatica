package chiroque.aplicaciones.com.escuelainformatica.AdmBaseDeDatos;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import chiroque.aplicaciones.com.escuelainformatica.EstructuraDeDatos.Arboles;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class AdminBaseDeDatos extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_base_de_datos);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_admin_base_de_datos, menu);
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

    public void abrirActivitCrearBaseDeDatos(View view){
        Intent i =new Intent(this, CrearBaseDatos.class);
        startActivity(i);
    }

    public void abrirActivitCrearDropTabla(View view){
        Intent i =new Intent(this, CrearEliminarTabla.class);
        startActivity(i);
    }

    public void abrirActivitInsertSelectTabla(View view){
        Intent i =new Intent(this, InsertSelectTabla.class);
        startActivity(i);
    }

    public void abrirActivitDeleteUpdateTabla(View view){
        Intent i =new Intent(this, DeleteUpdateTabla.class);
        startActivity(i);
    }
    public void abrirActivitProcedimAlmacenados(View view){
        Intent i =new Intent(this, ProcedimientosAlmacenados.class);
        startActivity(i);
    }
    public void abrirActivitFuncionesSABD(View view){
        Intent i =new Intent(this, FuncionesSABD.class);
        startActivity(i);
    }
    public void abrirActivitTriggers(View view){
        Intent i =new Intent(this, Triggers.class);
        startActivity(i);
    }
}
