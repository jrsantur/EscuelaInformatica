package chiroque.aplicaciones.com.escuelainformatica;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import chiroque.aplicaciones.com.escuelainformatica.AdmBaseDeDatos.AdminBaseDeDatos;
import chiroque.aplicaciones.com.escuelainformatica.Estadistica.Estadisticas;
import chiroque.aplicaciones.com.escuelainformatica.EstructuraDeDatos.EstructuraDDatos;
import chiroque.aplicaciones.com.escuelainformatica.InvestOperaciones.InvestOperaciones;
import chiroque.aplicaciones.com.escuelainformatica.Matematicas.Matematicas;
import chiroque.aplicaciones.com.escuelainformatica.MicrocomputadorasI.MicrocomputI;
import chiroque.aplicaciones.com.escuelainformatica.MicrocomputadorasII.MicroComputII;
import chiroque.aplicaciones.com.escuelainformatica.Programation.Programacion;
import chiroque.aplicaciones.com.escuelainformatica.RedesInformatica.RedesSegInformatica;
import chiroque.aplicaciones.com.escuelainformatica.SimulacionDeSistemas.SimulacionSistemas;
import chiroque.aplicaciones.com.escuelainformatica.TecnologiaWeb.TecnoWeb;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void estadistica(View view){
        Intent i =new Intent(this, Estadisticas.class);
        startActivity(i);
    }
    public void investop(View view){
        Intent i =new Intent(this, InvestOperaciones.class);
        startActivity(i);
    }
    public void microcompI(View view){
        Intent i =new Intent(this, MicrocomputI.class);
        startActivity(i);
    }
    public void microcompII(View view){
        Intent i =new Intent(this, MicroComputII.class);
        startActivity(i);
    }
    public void matematicas(View view){
        Intent i =new Intent(this, Matematicas.class);
        startActivity(i);
    }
    public void simulacionsistemas(View view){
        Intent i =new Intent(this, SimulacionSistemas.class);
        startActivity(i);
    }
    public void estructuraDeDatos(View view){
        Intent i =new Intent(this, EstructuraDDatos.class);
        startActivity(i);
    }
    public void adminBaseDeDatos(View view){
        Intent i =new Intent(this, AdminBaseDeDatos.class);
        startActivity(i);
    }
    public void redesSeguridadInform(View view){
        Intent i =new Intent(this, RedesSegInformatica.class);
        startActivity(i);
    }
    public void tecnologyWeb(View view){
        Intent i =new Intent(this, TecnoWeb.class);
        startActivity(i);
    }
    public void programac(View view){
        Intent i =new Intent(this, Programacion.class);
        startActivity(i);
    }
}
