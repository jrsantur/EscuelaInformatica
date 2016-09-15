package chiroque.aplicaciones.com.escuelainformatica.InvestOperaciones;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import chiroque.aplicaciones.com.escuelainformatica.InvestOperaciones.ClasesObjetos.Nodo;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class ProblemaDiligencia extends ActionBarActivity {
private Spinner spnEtapas, spinNodo, spinnumnodos;;
private TableLayout paso2, paso3;
private TextView rptaDilig;
private Button btnNnodos;
private LinearLayout linPaso3;
private int numetapas, numeroNodos=0;;
private Nodo NODOS[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problema_diligencia);

        paso2=(TableLayout)findViewById(R.id.layoutPaso2);
        paso3=(TableLayout)findViewById(R.id.layoutPaso3);
        rptaDilig=(TextView)findViewById(R.id.diligenciaRpta);
        spnEtapas=(Spinner)findViewById(R.id.spinNDiligencia);
        spinNodo =(Spinner)findViewById(R.id.spinNodo);
        btnNnodos=(Button)findViewById(R.id.btnOkNnodos);
        linPaso3=(LinearLayout)findViewById(R.id.linearPaso3);

        String []opciones={"3","4","5","6"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spnEtapas.setAdapter(adapter);

        seleccionoNodo();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_problema_diligencia, menu);
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

    public void okNumeroDeEtapas(View view){
     paso2.removeAllViews();
     TextView etapa, Netapa;
     TableRow fila1, fila2;
     String selec=spnEtapas.getSelectedItem().toString();
     numetapas=Integer.parseInt(selec);
     fila1=new TableRow(this);
     fila2=new TableRow(this);
     for (int i=0;i<numetapas;i++){
         Netapa=new TextView(this);
         Netapa.setText("Columna "+(i+1));
         Netapa.setBackgroundResource(R.drawable.borde);
         Netapa.setWidth(80);
         Netapa.setTextSize(10);
         Netapa.setTextColor(Color.BLACK);
         fila1.addView(Netapa);
         if (i==0 || i==numetapas-1){
             etapa=new TextView(this);
             etapa.setText("1");
             etapa.setId(i);
             etapa.setGravity(Gravity.CENTER);
             etapa.setBackgroundResource(R.drawable.borde);
             fila2.addView(etapa);
         }else{
             spinnumnodos=new Spinner(this);
             spinnumnodos.setId(i);
             String []opciones={"1","2","3","4","5"};
             ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
             spinnumnodos.setAdapter(adapter);
             spinnumnodos.setBackgroundResource(R.drawable.borde);
             fila2.addView(spinnumnodos);
         }

     }
     paso2.addView(fila1);
     paso2.addView(fila2);
     btnNnodos.setVisibility(View.VISIBLE);
    }

    public void okNodosXEtapa(View view){
    linPaso3.setVisibility(View.VISIBLE);
    String []opciones;
    numeroNodos=0;
    for (int i=0;i<numetapas;i++){
        if (i==0 || i==numetapas-1){
            numeroNodos=numeroNodos+1;

        }else{
            Spinner spn=(Spinner)findViewById(i);
            int nodosxesaetapa=Integer.parseInt(spn.getSelectedItem().toString());
            numeroNodos=numeroNodos+nodosxesaetapa;
        }

    }
        //Llenar array de NODOS
        NODOS=new Nodo[numeroNodos];
        int contadorNodos=1;
        for (int i=0;i<numetapas;i++){
            if (i==0 || i==numetapas-1){
                NODOS[contadorNodos-1]=new Nodo(contadorNodos,i);
                contadorNodos++;
            }else{
                Spinner spn=(Spinner)findViewById(i);
                int nodosxesaetapa=Integer.parseInt(spn.getSelectedItem().toString());
                for (int j=0;j<nodosxesaetapa;j++){
                    NODOS[contadorNodos-1]=new Nodo(contadorNodos,i);
                    contadorNodos++;
                }
            }

        }
    //Para llenar spinNodo con nodos existentes
    opciones = new String[numeroNodos-1];
    for (int i=2;i<=numeroNodos;i++){
        opciones[i-2]="Nodo"+i;
    }
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
    spinNodo.setAdapter(adapter);
    }

    public void seleccionoNodo(){
    try{
        spinNodo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                String selec=spinNodo.getSelectedItem().toString();
                paso3.removeAllViews();
                agregarCabecera();
                llenarTablaEnlazar(selec);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }catch (Exception e){
        Toast notificacion=Toast.makeText(this,"Siga pasos en orden",Toast.LENGTH_LONG);
        notificacion.show();
    }

    }

    //metodo para llenar tabla para nodos departida, y relacionarlos a nodos META
    public void llenarTablaEnlazar(String seleccion){
        int numordenNODO=Integer.parseInt(seleccion.substring(4));
        int etapa=NODOS[numordenNODO-1].getEtapa();
        TableRow fila;
        for (int i=0;i<numeroNodos;i++){
            fila=new TableRow(this);
            if (NODOS[i].getEtapa()==etapa-1){
                EditText labenodo=new EditText(this);
                EditText distancia=new EditText(this);
                labenodo.setText(NODOS[i].getNumero()+"");
                distancia.setId((i + 1) * 100);
                labenodo.setTextSize(15);
                labenodo.setTextColor(Color.BLACK);
                distancia.setInputType(InputType.TYPE_CLASS_NUMBER);
                distancia.setTextSize(15);
                labenodo.setGravity(Gravity.CENTER);
                labenodo.setEnabled(false);
                labenodo.setBackgroundResource(R.drawable.borde);
                distancia.setBackgroundResource(R.drawable.borde);
                fila.addView(labenodo);
                fila.addView(distancia);
                paso3.addView(fila);
            }
        }
        paso3.setVisibility(View.VISIBLE);
    }

    public void agregarCabecera(){
        TableRow fila=new TableRow(this);
        TextView titleNodo=new TextView(this);
        TextView titleDistancia=new TextView(this);
        titleNodo.setText("Nodo partida");
        titleNodo.setBackgroundResource(R.drawable.borde);
        titleDistancia.setText("Distancia");
        titleDistancia.setBackgroundResource(R.drawable.borde);
        fila.addView(titleNodo);
        fila.addView(titleDistancia);
        paso3.addView(fila);
    }

    public void AgregarNodoCaracteristicas(View view){
    String selec=spinNodo.getSelectedItem().toString();
    int numordenNODO=Integer.parseInt(selec.substring(4));
    int etapa=NODOS[numordenNODO-1].getEtapa();
    ArrayList<Nodo> antecesor=new ArrayList<Nodo>();
    ArrayList<Integer> distancia=new ArrayList<Integer>();
    antecesor.clear();
    distancia.clear();
    for (int i=0;i<numeroNodos;i++){
        if (NODOS[i].getEtapa()==etapa-1){
           EditText dist=(EditText)findViewById((i + 1) * 100);
           String cad=dist.getText().toString();
           if (!cad.equals("")){
               antecesor.add(NODOS[i]);
               distancia.add(Integer.parseInt(cad));
           }

        }
    }
        NODOS[numordenNODO-1].setMETASantecesores(antecesor);
        NODOS[numordenNODO-1].setDistancias(distancia);
    }

    public void operarTODO(View view){
    try{

        NODOS[0].setMenorDistanciaAesteNodo(0);
        int D=0;
        for (int i=1;i<numeroNodos;i++){
            ArrayList<Integer> distTemp= NODOS[i].getDistancias();
            ArrayList<Integer> X=new ArrayList<Integer>();
            for (int y=0;y<distTemp.size();y++){
                int h=NODOS[i].getMETASantecesores().get(y).getMenorDistanciaAesteNodo();
                NODOS[i].setAntecesorMasCercano(NODOS[i].getMETASantecesores().get(y));
                int m= NODOS[i].getDistancias().get(y);
                X.add(h+m);
            }
            ArrayList Xcopia=(ArrayList)X.clone();
            Collections.sort(X);
            int indice=Xcopia.indexOf(X.get(0));
            NODOS[i].setAntecesorMasCercano(NODOS[i].getMETASantecesores().get(indice));
            NODOS[i].setMenorDistanciaAesteNodo(X.get(0));

        }

        Nodo nodocercano=NODOS[numeroNodos-1].getAntecesorMasCercano();
        String rpta=""+NODOS[numeroNodos-1].getNumero()+","+nodocercano.getNumero();
        for(int j=0;j<numetapas-2;j++){
            nodocercano=nodocercano.getAntecesorMasCercano();
            int nmc=nodocercano.getNumero();
            rpta=rpta+","+nmc;
        }

        D=NODOS[numeroNodos-1].getMenorDistanciaAesteNodo();
        rptaDilig.setText("Distancia minima"+D+" recorrido Nodos:{"+rpta+"}");

    }catch (Exception e){
        Toast notificacion=Toast.makeText(this,"Por lo menos en una etapa 1 nodo partida debe estar conectado al nodo META",Toast.LENGTH_LONG);
        notificacion.show();
        System.out.println(e);
    }
    }



}
