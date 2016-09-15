package chiroque.aplicaciones.com.escuelainformatica.Estadistica.GraficosEstadisticos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Arrays;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class BarChartPLOT extends ActionBarActivity {
LinearLayout layout1;
private int num;
private double [] valores;
private double [] valors;
private double maxValor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart_plot);

        layout1 = (LinearLayout) findViewById(R.id.fondoBar);


        num=Integer.parseInt(getIntent().getStringExtra("numero"));
        valores=new double[num];
        valors=new double[num];
        for(int i=0;i<num;i++){
            double valor=Double.parseDouble(getIntent().getStringExtra("valor"+i));
            valores[i]=valor;
            valors[i]=valor;
        }
        Arrays.sort(valores);
        maxValor=valores[num-1];

        Lienzo fondo = new Lienzo(this);
        layout1.addView(fondo);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bar_chart_plot, menu);
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

    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(255,255,255);
            int ancho=canvas.getWidth();
            int alto=canvas.getHeight();
            Paint pincel=new Paint();
            int [] colores={Color.BLUE,Color.rgb(255, 0, 0),Color.GREEN,Color.rgb(255, 153, 0),Color.rgb(75, 0, 130),
                    Color.CYAN,Color.YELLOW,Color.GRAY,Color.MAGENTA,Color.rgb(210, 105, 30)};

            pincel.setColor(Color.BLACK);
            canvas.drawLine(80,20,80,alto-180,pincel);// eje Y
            canvas.drawLine(60,alto-200,ancho, alto-200, pincel); //eje X

            pincel.setTextSize(20);
            for(int i=0;i<num;i++){
                String serie=getIntent().getStringExtra("serie"+i);
                String serie1letra=serie.substring(0,1);
                canvas.drawText(serie1letra,120+(40*i),alto-200+20, pincel);
            }


            pincel.setStrokeWidth(40);
            if(maxValor>0){
                for (int i=0;i<num;i++){
                    pincel.setColor(colores[i]);
                    int val=Math.round(Float.parseFloat(valors[i]*(alto-220)/maxValor+""));
                    canvas.drawLine(140+(40*i),alto-200,140+(40*i), alto-200-val, pincel);
                }
                pincel.setColor(Color.BLACK);
                for(int j=0;j<num;j++){
                    int val=Math.round(Float.parseFloat(valores[j]*(alto-220)/maxValor+""));
                    canvas.drawText(valores[j]+"",40,alto-200-val, pincel);
                }
            }

        }

    }

}
