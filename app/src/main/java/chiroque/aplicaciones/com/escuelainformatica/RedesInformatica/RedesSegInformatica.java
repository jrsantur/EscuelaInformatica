package chiroque.aplicaciones.com.escuelainformatica.RedesInformatica;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class RedesSegInformatica extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redes_seg_informatica);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_redes_seg_informatica, menu);
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
    public void abrirActivityipv4(View view){
        Intent i =new Intent(this, Ipv4.class);
        startActivity(i);
    }
    public void abrirActivitymascarared(View view){
        Intent i =new Intent(this, MascaradeRed.class);
        startActivity(i);
    }
    public void abrirActivityClasesdeIp(View view){
        Intent i =new Intent(this, ClasesdeIp.class);
        startActivity(i);
    }
    public void abrirActivitysubred(View view){
        Intent i =new Intent(this, Subred.class);
        startActivity(i);
    }
    public void abrirActivitysubredapp(View view){
        Intent i =new Intent(this, SubredesApps.class);
        startActivity(i);
    }
    public void abrirActivityipv6(View view){
        Intent i =new Intent(this, IPv6.class);
        startActivity(i);
    }
    public void abrirActivityipv6ii(View view){
        Intent i =new Intent(this, Ipv6II.class);
        startActivity(i);
    }
    public void abrirActivityvlan(View view){
        Intent i =new Intent(this, Vlan.class);
        startActivity(i);
    }
    public void abrirActivityatqinformatico(View view){
        Intent i =new Intent(this, AtaqueInformatico.class);
        startActivity(i);
    }
}
