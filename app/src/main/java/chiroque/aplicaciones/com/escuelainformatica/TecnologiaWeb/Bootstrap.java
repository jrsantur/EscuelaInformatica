package chiroque.aplicaciones.com.escuelainformatica.TecnologiaWeb;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class Bootstrap extends ActionBarActivity {
    private Spinner spincomando;
    private TextView teoria;
    private ImageView image, image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bootstrap);
        image=(ImageView)findViewById(R.id.imgbootstrapA);
        image2=(ImageView)findViewById(R.id.imgbootstrapB);
        teoria=(TextView)findViewById(R.id.txtbootstrap);
        spincomando = (Spinner) findViewById(R.id.spinbootstrap);
        String []opciones={"Rejilla .col-md-*","Rejilla para móviles y ordenadores"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spincomando.setAdapter(adapter);
        spincomando.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selec=spincomando.getSelectedItem().toString();
                if(selec.equals("Rejilla .col-md-*")){
                    teoria.setText(R.string.c_bootstrap_colmd);
                    image.setImageResource(R.drawable.rejillaboots1);
                    image2.setImageResource(R.drawable.vistarb1);
                }else
                if(selec.equals("Rejilla para móviles y ordenadores")){
                    teoria.setText(R.string.c_bootstrap_colxsmd);
                    image.setImageResource(R.drawable.rejillaboots2);
                    image2.setImageResource(R.drawable.vistarb2);
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
        getMenuInflater().inflate(R.menu.menu_bootstrap, menu);
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
