package chiroque.aplicaciones.com.escuelainformatica.MicrocomputadorasI;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class Copr8087 extends ActionBarActivity {
    private Spinner spincomando;
    private TextView teoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copr8087);
        teoria=(TextView)findViewById(R.id.txttiposcom8087);
        spincomando = (Spinner) findViewById(R.id.spincmd8087);
        String []opciones={"Transferencia de números","Carga de constantes","Transferencia de datos de control","Aritméticas"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spincomando.setAdapter(adapter);
        spincomando.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selec=spincomando.getSelectedItem().toString();
                if(selec.equals("Transferencia de números")){
                    teoria.setText(R.string.c1_copr8087);
                }else
                if(selec.equals("Carga de constantes")){
                    teoria.setText(R.string.c2_copr8087);
                }else
                if(selec.equals("Transferencia de datos de control")){
                    teoria.setText(R.string.c3_copr8087);
                }else
                if(selec.equals("Aritméticas")){
                    teoria.setText(R.string.c4_copr8087);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_copr8087, menu);
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
