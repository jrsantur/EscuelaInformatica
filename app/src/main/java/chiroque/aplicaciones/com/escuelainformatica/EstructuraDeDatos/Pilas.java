package chiroque.aplicaciones.com.escuelainformatica.EstructuraDeDatos;

import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class Pilas extends ActionBarActivity {
private TextView txttitulo, txtoperaciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilas);
        txttitulo=(TextView)findViewById(R.id.txttituloPilas);
        txtoperaciones=(TextView)findViewById(R.id.txtpilasoperaciones);
        txttitulo.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        txtoperaciones.setText("Una pila posee 2 operaciones básicas: apilar y desapilar, a las que en las implementaciones actuales de las pilas se suelen añadir más de uso habitual.\n" +
                "•Crear (constructor): Se crea la pila vacía.\n" +
                "•Tamaño (size): Retorna el número de elementos que contiene la pila.\n" +
                "•Apilar (push): agrega un elemento a la pila.\n" +
                "•Desapilar (pop): Elimina el elemento de la cima de la pila.\n" +
                "•Cima (top o peek): Retorna el elemento que esta en la cima de la pila.\n" +
                "•Vacía (empty): Devuelve verdad (true)si la pila está sin elementos o falso en caso de que contenga uno.");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pilas, menu);
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
}
