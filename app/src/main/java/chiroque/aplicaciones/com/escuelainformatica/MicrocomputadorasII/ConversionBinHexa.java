package chiroque.aplicaciones.com.escuelainformatica.MicrocomputadorasII;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class ConversionBinHexa extends ActionBarActivity {
private EditText binario, hexadecimal;
private TextView hexadecim, binar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_bin_hexa);

        binario=(EditText)findViewById(R.id.edtxBinario);
        hexadecimal=(EditText)findViewById(R.id.edtxHexadecimal);
        hexadecim=(TextView)findViewById(R.id.BinHexa);
        binar=(TextView)findViewById(R.id.HexaBin);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_conversion_bin_hexa, menu);
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

    public void deBinaHexa(View view){
       try{
          String cadbin=binario.getText().toString();
          String cadbinario=cadbin.replace(" ","");
          int dec=Integer.parseInt(cadbinario, 2);
           String rpta=Integer.toHexString(dec);
           hexadecim.setText(" "+rpta.toUpperCase());
       }catch(Exception e){
           Toast notificacion=Toast.makeText(this,"Ingrese datos correctos",Toast.LENGTH_LONG);
           notificacion.show();
       }
    }

    public void deHexaBin(View view){
        try{
            String cadhexa=hexadecimal.getText().toString();
            int dec=Integer.parseInt(cadhexa,16);
            String rpta=Integer.toBinaryString(dec);
            int grupos=rpta.length()/4;
            int carr=rpta.length()%4;
           rpta = new StringBuffer(rpta).insert(carr," ").toString();

            for (int i=1;i<grupos;i++){
                rpta = new StringBuffer(rpta).insert(carr+i*5," ").toString();
            }
            binar.setText(" "+rpta);

        }catch(Exception e){
            Toast notificacion=Toast.makeText(this,"Ingrese datos correctos",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }
}
