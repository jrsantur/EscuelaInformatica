package chiroque.aplicaciones.com.escuelainformatica.InvestOperaciones;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import chiroque.aplicaciones.com.escuelainformatica.MainActivity;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class ProblemaMochila extends ActionBarActivity {
private TableLayout tabla;
private EditText capacidad;
private Spinner numtipos;
private LinearLayout layoutTab;
private LinearLayout mochRpta;
private TextView viewResult,viewResultI;
private int num=2;
private String  [] nombre;
private int [] valor;
private int [] magn;
private int [] cantD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problema_mochila);
        tabla=(TableLayout)findViewById(R.id.tablaDatosMochila);
        capacidad=(EditText)findViewById(R.id.edtCapacidad);
        numtipos=(Spinner)findViewById(R.id.spnNtipos);
        layoutTab=(LinearLayout)findViewById(R.id.layoutTabla);
        mochRpta=(LinearLayout)findViewById(R.id.mochilaRpta);
        viewResult=(TextView)findViewById(R.id.viewResultado);
        viewResultI=(TextView)findViewById(R.id.viewResultadoI);
        String []opciones={"2","3","4","5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        numtipos.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_problema_mochila, menu);
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

    public void crearTabla(View view){
    TableRow fila;
    EditText celda;
    num=Integer.parseInt(numtipos.getSelectedItem().toString());
    for (int i=0;i<num;i++){
    fila=new TableRow(this);
        for (int j=0;j<3;j++){
        celda=new EditText(this);
        celda.setId(((10*i)+j)*1000);
        celda.setBackgroundResource(R.drawable.borde);
        celda.setWidth(100);
            if (j==1 || j==2){
                celda.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
        fila.addView(celda);
        }
        tabla.addView(fila);
    }
    layoutTab.setVisibility(View.VISIBLE);
    }

    public void obtenerValorMochila(View view){
        String cadenaResultado="";
        int TotalResultado=0;
        try{
            int capacidadMax=Integer.parseInt(capacidad.getText().toString());
            nombre=new String[num];
            valor=new int[num];
            magn=new int[num];
            obtenerDatos(nombre,valor,magn);
            metodoMochila(num,capacidadMax,valor, magn);
            for (int i=0;i<num;i++){
                cadenaResultado=cadenaResultado+""+cantD[i]+" de "+nombre[i]+" | ";
                TotalResultado=TotalResultado+(cantD[i]*valor[i]);
            }
            viewResultI.setText("RESULTADO Máximo: "+TotalResultado);
            viewResult.setText(cadenaResultado);
            mochRpta.setVisibility(View.VISIBLE);

        }catch (Exception e ){
            Toast notificacion=Toast.makeText(this,"Ingrese valores adecuados",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }

    private void obtenerDatos(String [] nom,int [] val, int [] mag){
    for (int i=0;i<num;i++){
        for (int j=0;j<3;j++){
            EditText labe = (EditText) findViewById(((10*i)+j)*1000);
            String labeString=labe.getText().toString();
            if (j==0){
                if (labeString.equals("")){
                    labeString="Indefinido";
                    System.exit(0);
                }
                nom[i]=labeString;
            }
            if (j==1){
                if (labeString.equals("")){
                    labeString=0+"";
                    System.exit(0);

                }
                int valor=Integer.parseInt(labeString);
                val[i]=valor;
            }
            if (j==2){
                if (labeString.equals("")){
                    labeString=0+"";
                    System.exit(0);
                }
                int mg=Integer.parseInt(labeString);
                mag[i]=mg;
            }
        }
    }

    }


    public void metodoMochila(int N,int W, int[] precio, int[] volumen) {
        try{
            cantD=new int[N];
            int [] volumenCopia=volumen.clone();
            int [] precioCopia=precio.clone();
            volumenCopia=invertir(volumen);
            precioCopia=invertir(precio);
            ArrayList<ArrayList> funcion = new ArrayList<ArrayList>();
            ArrayList<ArrayList> desicion = new ArrayList<ArrayList>();
            for (int n=0;n<N-1;n++){
                ArrayList<Integer> fS = new ArrayList<Integer>(); //f
                ArrayList<Integer> fD = new ArrayList<Integer>(); //f

                int vol=volumenCopia[n];
                for (int S=0;S<=W;S++){
                    int Fanterior=0;
                    int D=0;

                    ArrayList<Integer> ftemp = new ArrayList<Integer>();
                    while (D*vol<=S){
                        if (n!=0){
                            Fanterior=(int)(funcion.get(n-1)).get(S-(D*vol));
                        }
                        ftemp.add(precioCopia[n]*D+Fanterior);
                        D++;
                    }
                    ArrayList ftempCopia = (ArrayList) ftemp.clone();
                    Collections.sort(ftemp);
                    int mayor=ftemp.get(ftemp.size()-1);
                    int d=ftempCopia.indexOf(mayor);
                    fS.add(mayor);
                    fD.add(d);
                }
                funcion.add(fS);
                desicion.add(fD);
            }
            //Obtener sumatoria de pesos en mochila llena
            int vol=volumenCopia[N-1];
            int maxD=(int)W/vol;
            int S=8;
            ArrayList<Integer> pesoTotal = new ArrayList<Integer>();
            for (int D=0;D<=maxD;D++){
                int FA=(int)(funcion.get(N-2)).get(S-(D*vol));
                int funUltim=(precioCopia[N-1]*D)+FA;
                pesoTotal.add(funUltim);
            }
            ArrayList copiaPesoTotal=(ArrayList)pesoTotal.clone();
            Collections.sort(pesoTotal);
            int PesoTotal=pesoTotal.get(maxD);

            cantD[0]=copiaPesoTotal.indexOf(PesoTotal);
            int cont=1;
            for (int i=N-2;i>=0;i--){
                PesoTotal=PesoTotal-(precio[cont-1]*cantD[cont-1]);
                int indice=(funcion.get(i)).indexOf(PesoTotal);
                cantD[cont]=(int)(desicion.get(i)).get(indice);
                cont++;
            }

            for (int i=0;i<cantD.length;i++){
                System.out.println(cantD[i]+"");
            }

            funcion.clear();
            desicion.clear();

        }catch (Exception ex){
            Toast notificacion=Toast.makeText(this,"Ingrese valores adecuados",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }

    public static int []  invertir(int [] arreglo){
        int [] aux=new int[arreglo.length];
        for (int i=0,j=aux.length-1; i<arreglo.length;i++,j--){
            aux[i]=arreglo[j];
        }
        return aux;
    }
}
