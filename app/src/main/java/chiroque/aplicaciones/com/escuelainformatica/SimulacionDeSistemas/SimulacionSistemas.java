package chiroque.aplicaciones.com.escuelainformatica.SimulacionDeSistemas;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class SimulacionSistemas extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulacion_sistemas);
        TextView tv=(TextView)findViewById(R.id.titleSimulacion);
        tv.setPaintFlags(tv.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simulacion_sistemas, menu);
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

    public void abrirActivityCuadradoMedio(View view){
        Intent i =new Intent(this, CuadradoMedio.class);
        startActivity(i);
    }
    public void abrirActivityProductoCuadradoMedio(View view){
        Intent i =new Intent(this, ProductoMedio.class);
        startActivity(i);
    }
    public void abrirActivityMCLMixto(View view){
        Intent i =new Intent(this, MetodoLinealMixto.class);
        startActivity(i);
    }
    public void abrirActivityMCLinealMultiplicativo(View view){
        Intent i =new Intent(this, MetodoCongruencialLinealMultiplicativo.class);
        startActivity(i);
    }
    public void abrirActivityProcesoBinomial(View view){
        Intent i =new Intent(this, ProcesoBinomial.class);
        startActivity(i);
    }
    public void abrirActivityProcesoGeomtrico(View view){
        Intent i =new Intent(this, ProcesoGeometrico.class);
        startActivity(i);
    }
    public void abrirActivityProcesoBinomialNegativo(View view){
        Intent i =new Intent(this, ProcesoBinomialNegativo.class);
        startActivity(i);
    }
    public void abrirActivityProcesoHiperGeom(View view){
        Intent i =new Intent(this, ProcesoHipergeometrico.class);
        startActivity(i);
    }
    public void abrirActivityPoisoniano(View view){
        Intent i =new Intent(this, ProcesoPoisoniano.class);
        startActivity(i);
    }

    public void abrirActivityProcesoUniforme(View view){
        Intent i =new Intent(this, ProcesoUniforme.class);
        startActivity(i);
    }
    public void abrirActivityProcesoExpon(View view){
        Intent i =new Intent(this, ProcesoExponencial.class);
        startActivity(i);
    }
    public void abrirActivityProcesoNormGauss(View view){
        Intent i =new Intent(this, ProcesoGaussianoNorm.class);
        startActivity(i);
    }
    public void abrirActivityProcesoLognormal(View view){
        Intent i =new Intent(this, ProcesoLognormal.class);
        startActivity(i);
    }
}
