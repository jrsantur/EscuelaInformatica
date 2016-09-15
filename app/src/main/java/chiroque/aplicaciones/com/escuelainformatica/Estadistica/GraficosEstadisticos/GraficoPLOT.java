package chiroque.aplicaciones.com.escuelainformatica.Estadistica.GraficosEstadisticos;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.androidplot.pie.PieChart;
import com.androidplot.pie.PieRenderer;
import com.androidplot.pie.Segment;
import com.androidplot.pie.SegmentFormatter;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class GraficoPLOT extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_plot);

        int num=Integer.parseInt(getIntent().getStringExtra("numero"));
        //++++++++++++++++++++++

        int [] colores={Color.BLUE,Color.rgb(255, 0, 0),Color.GREEN,Color.rgb(255, 153, 0),Color.rgb(75, 0, 130),
                        Color.CYAN,Color.YELLOW,Color.GRAY,Color.MAGENTA,Color.rgb(210, 105, 30)};
        Segment [] seg=new Segment[10];

        PieChart graficoPartidos = (PieChart) findViewById(R.id.Sectorchart);
        graficoPartidos.getBackgroundPaint().setColor(Color.WHITE);

        double total=0;
        for (int j=0;j<num;j++){
            double valor=Double.parseDouble(getIntent().getStringExtra("valor"+j));
            total=total+valor;
        }

        for(int i=0;i<num;i++){
            String serie=getIntent().getStringExtra("serie"+i);
            double valor=Double.parseDouble(getIntent().getStringExtra("valor"+i));
            double porcentaje=valor*100/total;
            seg[i]=new Segment(serie+" ("+porcentaje+"%)",valor);
            graficoPartidos.addSeries(seg[i], new SegmentFormatter(colores[i], Color.BLACK,Color.BLACK, Color.BLACK));
        }

        PieRenderer pieRenderer = graficoPartidos.getRenderer(PieRenderer.class);
        pieRenderer.setDonutSize((float) 0 / 100,   PieRenderer.DonutMode.PERCENT);
        graficoPartidos.redraw();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_grafico_plot, menu);
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
