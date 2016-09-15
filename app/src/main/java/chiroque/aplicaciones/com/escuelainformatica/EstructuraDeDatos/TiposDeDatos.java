package chiroque.aplicaciones.com.escuelainformatica.EstructuraDeDatos;

import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class TiposDeDatos extends ActionBarActivity {
    private TextView txtconcepto, txttitulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_de_datos);
        txtconcepto=(TextView)findViewById(R.id.txtTipoDatoConcepto);
        txttitulo=(TextView)findViewById(R.id.txttituloTipoDeDatos);
        txttitulo.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        txtconcepto.setText("En ciencias de la computación un tipo de dato informático es un atributo de los datos que indica al ordenador y  al programador sobre la clase de datos que se está utilizando. Esto incluye imponer restricciones en los datos tales como los valores pueden tomar, el rango y operaciones se pueden realizar con dichos datos.\n" +
                "Los tipos de datos conocidos son: cadenas alfanuméricas (y unicodes), números de coma flotante(decimales), números enteros, números con signo (negativos), estados, etc.\n");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tipos_de_datos, menu);
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
