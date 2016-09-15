package chiroque.aplicaciones.com.escuelainformatica.Matematicas;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

import chiroque.aplicaciones.com.escuelainformatica.Matematicas.OperacionMatriz.DeterminanteInversa;
import chiroque.aplicaciones.com.escuelainformatica.R;


public class Matrices extends ActionBarActivity {
    private Spinner spinord;
    private LinearLayout layrpta;
    private TableLayout tabla;
    private TableLayout tabla_2;
    TextView txte;
    TableRow.LayoutParams layoutFila;
    private Button botonop;
    int n=2;
    private TextView Determin;
    double [][] valores;
    double [][] inversa;
    String valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrices);

        Determin=(TextView)findViewById(R.id.Determin);


        spinord=(Spinner)findViewById(R.id.spinorden);
        botonop=(Button)findViewById(R.id.btnoperar);
        layrpta=(LinearLayout)findViewById(R.id.layresult);
        String [] orden={"3","4","5"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,orden);
        spinord.setAdapter(adapter);

        txte=(TextView)findViewById(R.id.txte);

        tabla=(TableLayout)findViewById(R.id.tabla);
        tabla_2=(TableLayout)findViewById(R.id.tabla2);

        layoutFila =new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_matrices, menu);
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
    public void okorden(View view){
        String selec=spinord.getSelectedItem().toString();
        n=Integer.parseInt(selec);
        valores=new double[n][n];
        inversa=new double[n][n];

        txte.setText("Matriz de "+n+" x "+n+" (Clic en cada celda para escribir en ella)");

        agregarcelda(n);
        botonop.setVisibility(View.VISIBLE);
        layrpta.setVisibility(View.VISIBLE);
    }

    public void agregarcelda(int num){
        TableRow fila ;
        EditText celda;
        tabla.removeAllViews();
        for(int i=0;i<num;i++){
            fila=new TableRow(this);
            fila.setLayoutParams(layoutFila);

            for(int j=0;j<num;j++){
                celda=new EditText(this);
                celda.setId((i*10)+j);
                celda.setWidth(80);
                celda.setTextSize(14);
                celda.setTextColor(Color.BLACK);
                celda.setGravity(Gravity.CENTER);
                celda.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
                celda.setBackgroundResource(R.drawable.borde);
                fila.addView(celda);
            }
            tabla.addView(fila);
        }
    }

    public void botonoperar(View view){
        TableRow filat2;
        TextView celdat2;
        tabla_2.removeAllViews();
        obtenerValores(n);
        try {
            DeterminanteInversa DI = new DeterminanteInversa();
            double x = DI.determinante(valores); //double x=determinante(valores);
            Determin.setText(x + "");
            DecimalFormat df = new DecimalFormat("###.###");
            if (x != 0) {
                inversa = DI.matrInversa(valores);
                //mostrar en otra tabla la inversa
                for (int i = 0; i < n; i++) {
                    filat2 = new TableRow(this);
                    filat2.setLayoutParams(layoutFila);

                    for (int j = 0; j < n; j++) {
                        celdat2 = new TextView(this);
                        celdat2.setText("" + df.format(inversa[i][j]));
                        celdat2.setWidth(100);
                        celdat2.setTextSize(13);
                        celdat2.setGravity(Gravity.CENTER);
                        celdat2.setBackgroundResource(R.drawable.borde);
                        filat2.addView(celdat2);
                    }
                    tabla_2.addView(filat2);
                } //++++++
            }

        }catch (Exception e){
            Toast notificacion=Toast.makeText(this,"Escribir los números de manera correcta",Toast.LENGTH_LONG);
            notificacion.show();
        }

    }

    //metodo obtener valores de la tabla
    public void obtenerValores(int n){

        for(int i=0; i<n;  i++){
            for(int j=0; j<n;  j++){
                EditText labe = (EditText) findViewById((i*10)+j);
                valor= labe.getText().toString();
                if (valor.equals(""))
                    valor=0+"";
                valores [i][j]=Double.parseDouble(valor);
            }
        }
    }

}
