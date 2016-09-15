package chiroque.aplicaciones.com.escuelainformatica.TecnologiaWeb;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class Html5 extends ActionBarActivity {
private ImageView image;
private TextView npag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html5);
        image=(ImageView)findViewById(R.id.html5img);
        image.setImageResource(R.drawable.html51);
        npag=(TextView)findViewById(R.id.txtnumpaghtml5);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_html5, menu);
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

    public void anteriorHojahtml5(View view){
        String cadena=npag.getText().toString();
        switch(cadena){
            case "Página 2:":
                npag.setText("Página 1:");
                image.setImageResource(R.drawable.html51);
                break;
            case "Página 3:":
                npag.setText("Página 2:");
                image.setImageResource(R.drawable.html52);
                break;
            case "Página 4:":
                npag.setText("Página 3:");
                image.setImageResource(R.drawable.html53);
                break;
            case "Página 5:":
                npag.setText("Página 4:");
                image.setImageResource(R.drawable.html54);
                break;
        }
    }
    public void siguienteHojahtml5(View view){
        String cadena=npag.getText().toString();
        switch(cadena){
            case "Página 1:":
                npag.setText("Página 2:");
                image.setImageResource(R.drawable.html52);
                break;
            case "Página 2:":
                npag.setText("Página 3:");
                image.setImageResource(R.drawable.html53);
                break;
            case "Página 3:":
                npag.setText("Página 4:");
                image.setImageResource(R.drawable.html54);
                break;
            case "Página 4:":
                npag.setText("Página 5:");
                image.setImageResource(R.drawable.html55);
                break;
        }
    }

}
