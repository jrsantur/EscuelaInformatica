package chiroque.aplicaciones.com.escuelainformatica.SimulacionDeSistemas;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class ProductoMedio extends ActionBarActivity {
    private EditText txtr0, txtr1, txtNaleat;
    private Spinner spNCifras;
    private TableLayout tabla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_medio);
        tabla=(TableLayout)findViewById(R.id.tablaNroAleatPM);
        spNCifras=(Spinner)findViewById(R.id.spinNCifrasaleatPM);
        txtr0=(EditText)findViewById(R.id.txtr0PM);
        txtr1=(EditText)findViewById(R.id.txtr1PM);
        txtNaleat=(EditText)findViewById(R.id.txtNAleatoriosPM);
        txtr0.setInputType(InputType.TYPE_CLASS_NUMBER);
        txtr1.setInputType(InputType.TYPE_CLASS_NUMBER);
        String [] opciones={"2","3","4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spNCifras.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_producto_medio, menu);
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

    public void btnGenerarNrosAleatoriosPM(View view){
     try{
        if(txtr0.getText()!=null && txtr1.getText()!=null){
            tabla.removeAllViews();
            tabla.setVisibility(View.VISIBLE);
            int r0=Integer.parseInt(txtr0.getText().toString());
            int r1=Integer.parseInt(txtr1.getText().toString());
            int ncifras=Integer.parseInt(spNCifras.getSelectedItem().toString());
            int nnumeros=Integer.parseInt(txtNaleat.getText().toString());
            int [] arr=metodoProductoMedio(r0,r1,nnumeros,ncifras);
            agregarcabecera();
            agregarcelda(nnumeros,arr);
        }
     }catch(Exception ex){
         Toast notificacion=Toast.makeText(this,"Ingresar datos correctamente",Toast.LENGTH_LONG);
         notificacion.show();
     }

    }

    private int []  metodoProductoMedio(int r0, int r1,int n, int ncifrasGenerados){
        int cm=0;
        int [] serie=new int[n];
        if(ncifrasGenerados%2==0){
            cm=Integer.parseInt(siguienteRnPar(r0,r1, ncifrasGenerados));
            serie[0]=r1;
            serie[1]=cm;
            for(int i=2;i<=n-1;i++){
                serie[i]=Integer.parseInt(siguienteRnPar(serie[i-2],serie[i-1], ncifrasGenerados));
            }
        }else{
            cm=Integer.parseInt(siguienteRnInmpar(r0, r1, ncifrasGenerados));
            serie[0]=r1;
            serie[1]=cm;
            for(int i=2;i<=n-1;i++){
                serie[i]=Integer.parseInt(siguienteRnInmpar(serie[i-2],serie[i-1], ncifrasGenerados));
            }
        }
        return serie;
    }
    //si el nro de cifras es par
    private String siguienteRnInmpar(int rn, int rnsig, int longitud){
        String siguientern=((rn*rnsig)+"");
        if((siguientern.length())%2==0){
            siguientern="0"+siguientern;
        }
        if(siguientern.length()<longitud){
            for(int i=0;i<=longitud-siguientern.length();i++){
                siguientern="0"+siguientern;
            }
        }
        int indice=((siguientern.length())-(longitud))/2;
        siguientern=siguientern.substring(indice,longitud+indice);
        return  siguientern;
    }
    //si el nro de cifras es impar
    private String siguienteRnPar(int rn, int rnsig, int longitud){
        String siguientern=((rn*rnsig)+"");
        if((siguientern.length())%2!=0){
            siguientern="0"+siguientern;
        }
        if(siguientern.length()<longitud){
            for(int i=0;i<=longitud-siguientern.length();i++){
                siguientern="0"+siguientern;
            }
        }
        int indice=((siguientern.length())-(longitud))/2;
        siguientern=siguientern.substring(indice,longitud+indice);
        return  siguientern;
    }

    public void agregarcabecera(){
        TableRow fila=new TableRow(this) ;
        TextView celda;
        for(int i=0;i<3;i++){
            celda=new TextView(this);
            celda.setGravity(Gravity.CENTER);
            celda.setTextColor(Color.BLUE);
            celda.setWidth(80);
            celda.setTextSize(10);
            celda.setPadding(2,2,2,2);
            celda.setBackgroundResource(R.drawable.borde);
            fila.addView(celda);
            if(i==0){
                celda.setText("n");
            }else{
                if(i==1){
                    celda.setText("Rn");
                }else{
                    celda.setText("Rn [0,1]");
                }
            }
        }
        tabla.addView(fila);
    }

    public void agregarcelda(int num, int [] arr){
        TableRow fila ;
        TextView celda;
        for(int i=0;i<num;i++){
            fila=new TableRow(this);

            for(int j=0;j<3;j++){
                celda=new TextView(this);
                celda.setHeight(40);
                celda.setTextSize(15);
                if(j==0){
                    celda.setWidth(60);
                    celda.setText((i+1)+"");
                }else{
                    if(j==1){
                        celda.setWidth(120);
                        celda.setText(arr[i]+"");
                    }else{
                        celda.setWidth(140);
                        celda.setText("0."+arr[i]);
                    }
                }
                celda.setTextColor(Color.BLACK);
                celda.setGravity(Gravity.CENTER);
                celda.setBackgroundResource(R.drawable.borde);
                fila.addView(celda);
            }
            tabla.addView(fila);
        }
    }
}
