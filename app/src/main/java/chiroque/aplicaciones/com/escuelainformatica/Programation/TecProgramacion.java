package chiroque.aplicaciones.com.escuelainformatica.Programation;

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


public class TecProgramacion extends ActionBarActivity {
    private Spinner spintecnica;
    private TextView teoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tec_programacion);
        teoria=(TextView)findViewById(R.id.teoria_tec_prog);
        spintecnica = (Spinner) findViewById(R.id.spintecprogr);
        String []opciones={"Programación declarativa","Programación estructurada","Programación modular","Programación orientada a objetos"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spintecnica.setAdapter(adapter);
        spintecnica.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selec = spintecnica.getSelectedItem().toString();
                if (selec.equals("Programación declarativa")) {
                    teoria.setText(R.string.c1_prog_declarat);
                } else if (selec.equals("Programación estructurada")) {
                    teoria.setText(R.string.c2_prog_estruct);
                } else if (selec.equals("Programación modular")) {
                    teoria.setText(R.string.c3_prog_modul);
                } else if (selec.equals("Programación orientada a objetos")) {
                    teoria.setText(R.string.c4_prog_or_obj);
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
        getMenuInflater().inflate(R.menu.menu_tec_programacion, menu);
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
