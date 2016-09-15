package chiroque.aplicaciones.com.escuelainformatica.Programation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class Programacion extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programacion);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_programacion, menu);
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

    public void abrirtecprogram(View view){
        Intent i =new Intent(this, TecProgramacion.class);
        startActivity(i);
    }
    public void abrirPOO(View view){
        Intent i =new Intent(this, ProgOO.class);
        startActivity(i);
    }
    public void abrirLengProg(View view){
        Intent i =new Intent(this, LenguajeProgramacion.class);
        startActivity(i);
    }
    public void abrirMetodologiaDesarr(View view){
        Intent i =new Intent(this, MetodologiaDesarrollo.class);
        startActivity(i);
    }
    public void abrirIngenSoftware(View view){
        Intent i =new Intent(this, IngenieriaSoftware.class);
        startActivity(i);
    }
    public void abrirJavaLenguaje(View view){
        Intent i =new Intent(this, JavaLenguaje.class);
        startActivity(i);
    }
    public void abrirDesarrolloAgil(View view){
        Intent i =new Intent(this, DesAgilSoftw.class);
        startActivity(i);
    }
    public void abrirRup(View view){
        Intent i =new Intent(this, Rup.class);
        startActivity(i);
    }
}
