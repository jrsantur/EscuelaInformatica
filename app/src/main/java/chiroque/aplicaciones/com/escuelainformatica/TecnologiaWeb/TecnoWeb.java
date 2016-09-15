package chiroque.aplicaciones.com.escuelainformatica.TecnologiaWeb;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class TecnoWeb extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecno_web);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tecno_web, menu);
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

    public void html5(View view){
        startActivity(new Intent(this, Html5.class));
    }

    public void css(View view){
        startActivity(new Intent(this, Css.class));
    }

    public void bootstrap(View view){
        startActivity(new Intent(this, Bootstrap.class));
    }
    public void aspnet(View view){
        startActivity(new Intent(this, AspNet.class));
    }
    public void foundationn(View view){
        startActivity(new Intent(this, Foundation.class));
    }
    public void jsp(View view){
        startActivity(new Intent(this, Jsp.class));
    }
}
