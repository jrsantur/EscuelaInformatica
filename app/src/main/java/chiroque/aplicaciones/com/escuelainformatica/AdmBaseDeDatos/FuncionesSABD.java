package chiroque.aplicaciones.com.escuelainformatica.AdmBaseDeDatos;

import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class FuncionesSABD extends ActionBarActivity {
private TextView txtitlefuncescalares, txttitlefreturntable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funciones_sabd);
        txtitlefuncescalares=(TextView)findViewById(R.id.txttitulofuncEscalares);
        txttitlefreturntable=(TextView)findViewById(R.id.txttitulofuncReturnTabla);
        txtitlefuncescalares.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        txttitlefreturntable.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_funciones_sabd, menu);
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
