package chiroque.aplicaciones.com.escuelainformatica.AdmBaseDeDatos;

import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class ProcedimientosAlmacenados extends ActionBarActivity {
private TextView txttitleprocalmac, txttitleparamentrada, txttitleparamsalida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedimientos_almacenados);
        txttitleprocalmac=(TextView)findViewById(R.id.txttituloprocalmac);
        txttitleparamentrada=(TextView)findViewById(R.id.txttituloparamentrada);
        txttitleparamsalida=(TextView)findViewById(R.id.txttituloparamsalida);
        txttitleprocalmac.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        txttitleparamentrada.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        txttitleparamsalida.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_procedimientos_almacenados, menu);
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
