package chiroque.aplicaciones.com.escuelainformatica.TecnologiaWeb;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class Css extends ActionBarActivity {
    private ImageView image;
    private TextView npag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_css);
        image=(ImageView)findViewById(R.id.imgcss);
        image.setImageResource(R.drawable.css1);
        npag=(TextView)findViewById(R.id.txtnumpagcss);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_css, menu);
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

    public void anteriorHojacss(View view){
        String cadena=npag.getText().toString();
        switch(cadena){
            case "Página 2:":
                npag.setText("Página 1:");
                image.setImageResource(R.drawable.css1);
                break;
            case "Página 3:":
                npag.setText("Página 2:");
                image.setImageResource(R.drawable.css2);
                break;
        }
    }
    public void siguienteHojacss(View view) {
        String cadena = npag.getText().toString();
        switch (cadena) {
            case "Página 1:":
                npag.setText("Página 2:");
                image.setImageResource(R.drawable.css2);
                break;
            case "Página 2:":
                npag.setText("Página 3:");
                image.setImageResource(R.drawable.css3);
                break;

        }
    }
}
