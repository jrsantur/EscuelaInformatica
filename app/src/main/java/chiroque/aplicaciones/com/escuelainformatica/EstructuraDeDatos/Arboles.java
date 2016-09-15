package chiroque.aplicaciones.com.escuelainformatica.EstructuraDeDatos;

import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class Arboles extends ActionBarActivity {
    private TextView txtconcepto, txttituloarbol, txtterminologias, txttiposarbol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arboles);
        txtconcepto=(TextView)findViewById(R.id.txtarbolesConcepto);
        txttituloarbol=(TextView)findViewById(R.id.txttituloArboles);
        txtterminologias=(TextView)findViewById(R.id.txtterminologiasarboles);
        txttiposarbol=(TextView)findViewById(R.id.txttiposdearbol);
        txttituloarbol.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        txtconcepto.setText("En ciencias de la computación y en informática, un árbol es una estructura de datos que imula la forma de un árbol (un conjunto de nodos enlazados). \nUn nodo es la unidad sobre la que se crea el árbol y puede no tener nodos hijos o tener uno o más nodos hijos conectados a él. Ejem: Un nodo a es padre de un nodo b si existe un enlace desde a hacia b (en ese caso, también se dice que b es hijo de a). Sólo puede haber un único nodo sin padres, que llamaremos raíz. Los nodos que tienen padre y uno o varios hijos se les conoce como rama.");
        txtterminologias.setText("• Padre : Nodo con hijos.\n" +
                "• Hijo : Nodo descendiente de otro nodo.\n" +
                "• Hermanos : Nodos que comparten el mismo padre.\n" +
                "• Raíz : El nodo superior del árbol.\n" +
                "• Hojas : Nodos sin hijos.\n" +
                "• Nivel : El nivel de un nodo está definido por el número de conexiones entre el nodo y la raíz.\n" +
                "• Altura : Es el máximo número de niveles de todos los nodos del árbol. Equivale al nivel más alto de los nodos más 1. ");

        txttiposarbol.setText("•Árboles Binarios:\n" +
                "-Árbol de búsqueda binario auto-balanceable\n" +
                " ->Árboles AVL\n" +
                " ->Árboles Rojo-Negro\n" +
                " ->Árbol AA\n" +
                "-Árbol de segmento\n" +
                "\n" +
                "•Árboles Multicamino:\n" +
                "-Árboles B (Árboles de búsqueda multicamino autobalanceados)\n" +
                " ->Árbol-B+\n" +
                " ->Árbol-B*");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_arboles, menu);
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
