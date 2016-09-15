package chiroque.aplicaciones.com.escuelainformatica.RedesInformatica;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import chiroque.aplicaciones.com.escuelainformatica.R;


public class SubredesApps extends ActionBarActivity {
EditText eoct1,eoct2, eoct3, ecidrI, eb2, eb3, eb4;
TextView rptaform1, rptaform2;
int o1=0, o2=0, o3=0, maskform1=0, b2=0, b3=0, b4=0;
String clasered="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subredes_apps);
        eoct1=(EditText)findViewById(R.id.ipoct1);
        eoct2=(EditText)findViewById(R.id.ipoct2);
        eoct3=(EditText)findViewById(R.id.ipoct3);
        ecidrI=(EditText)findViewById(R.id.mascaracidrI);
        rptaform1=(TextView)findViewById(R.id.txtrptaSubredesform1);
        rptaform2=(TextView)findViewById(R.id.txtrptaSubredesform2);
        eb2=(EditText)findViewById(R.id.edtxbyte2);
        eb3=(EditText)findViewById(R.id.edtxbyte3);
        eb4=(EditText)findViewById(R.id.edtxbyte4);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subredes_apps, menu);
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
    public void operarformI(View view){
        try{
           capturayevaluaValores();
            operarI();

        }catch (Exception ex){
            Toast notificacion= Toast.makeText(this, "Datos no válidos (formulario 1).", Toast.LENGTH_LONG);
            notificacion.show();
        }
    }
    public void capturayevaluaValores(){
        if(eoct1.getText().toString()!=null && eoct2.getText().toString()!=null && eoct3.getText().toString()!=null && ecidrI.getText().toString()!=null){
            o1=Integer.parseInt(eoct1.getText().toString());
            o2=Integer.parseInt(eoct2.getText().toString());
            o3=Integer.parseInt(eoct3.getText().toString());
            maskform1=Integer.parseInt(ecidrI.getText().toString());
            if(o1<=127 && o2<=255 && o3<=255){
                clasered="A";
            }else{
                if(o1<=191 && o2<=255 && o3<=255){
                    clasered="B";
                }else{
                    if(o1<=223 && o2<=255 && o3<=255){
                        clasered="C";
                    }else{
                        Toast notificacion= Toast.makeText(this, "Máximo valor es 255 en cada octeto de la IP", Toast.LENGTH_LONG);
                        notificacion.show();
                    }
                }
            }
        }else{
            Toast notificacion= Toast.makeText(this, "Falta ingresar algún valor.", Toast.LENGTH_LONG);
            notificacion.show();
        }
    }

    public String operarI(){
        if(clasered.equals("A")){
            int a=maskform1-8;
            if(a>=0 && a<=23){
                rptaform1.setText("Solución:\n#Subredes:"+(Math.pow(2,a))+", clase:"+clasered+"\n#hosts por subred: "+(Math.pow(2,24))/(Math.pow(2,a))
                        +"\nMáscara: "+obtenermascaraA(a));
            }else{
                Toast notificacion= Toast.makeText(this, "Error de máscara: No se puede formar subredes.", Toast.LENGTH_LONG);
                notificacion.show();
                ecidrI.setText("");
            }
        }else{
            if(clasered.equals("B")){
                int b=maskform1-16;
                if(b>=0 && b<=15){
                    rptaform1.setText("Solución:\n#Subredes:"+(Math.pow(2,b))+", clase:"+clasered+"\n#hosts por subred: "+(Math.pow(2,16))/(Math.pow(2,b))
                            +"\nMáscara: "+obtenermascaraB(b));
                }else{
                    Toast notificacion= Toast.makeText(this, "Error de máscara: No se puede formar subredes.", Toast.LENGTH_LONG);
                    notificacion.show();
                    ecidrI.setText("");
                }
            }else{
                if(clasered.equals("C")){
                    int c=maskform1-24;
                    if(c>=0 && c<=7){
                        rptaform1.setText("Solución:\n#Subredes: "+(Math.pow(2,c))+", clase: "+clasered+"\n#hosts por subred: "+256/(Math.pow(2,c))
                        +"\nMáscara: "+obtenermascaraC(c));
                    }else{
                        Toast notificacion= Toast.makeText(this, "Error de máscara: No se puede formar subredes.", Toast.LENGTH_LONG);
                        notificacion.show();
                        ecidrI.setText("");
                    }
                }
            }
        }
        return clasered;
    }

    public String obtenermascaraA(int x){
        String a="", temp="", temp2="", temp3="";
        int tmp=0, tmp2=0, tmp3=0;
        for(int i=0;i<8;i++){
            if(x>0){
                temp=temp+1;
            }else{
                temp=temp+0;
            }
            x--;
        }
        for(int i=0;i<8;i++){
            if(x>0){
                temp2=temp2+1;
            }else{
                temp2=temp2+0;
            }
            x--;
        }
        for(int i=0;i<8;i++){
            if(x>0){
                temp3=temp3+1;
            }else{
                temp3=temp3+0;
            }
            x--;
        }
        tmp=Integer.parseInt(temp,2);
        tmp2=Integer.parseInt(temp2,2);
        tmp3=Integer.parseInt(temp3,2);
        a="255."+tmp+"."+tmp2+"."+tmp3;
        return a;
    }
    public String obtenermascaraB(int x){
        String b="", temp="", temp2="";
        int tmp=0, tmp2=0;
        for(int i=0;i<8;i++){
            if(x>0){
                temp=temp+1;
            }else{
                temp=temp+0;
            }
            x--;
        }
        for(int i=0;i<8;i++){
            if(x>0){
                temp2=temp2+1;
            }else{
                temp2=temp2+0;
            }
            x--;
        }
        tmp=Integer.parseInt(temp,2);
        tmp2=Integer.parseInt(temp2,2);
        b="255.255."+tmp+"."+tmp2;
        return b;
    }
    public String obtenermascaraC(int x){
        String c="", temp="";
        int tmp=0;
        for(int i=0;i<8;i++){
            if(x>0){
                temp=temp+1;
            }else{
                temp=temp+0;
            }
            x--;
        }
        tmp=Integer.parseInt(temp,2);
        c="255.255.255."+tmp;
        return c;
    }

    //Operaciones formulario 2
    public void operarform2(View view){
        try{
            capturarvaloresform2();
        }catch (Exception ex){
            Toast notificacion= Toast.makeText(this, "Datos no válidos (Formulario 2).", Toast.LENGTH_LONG);
            notificacion.show();
        }
    }
    public void capturarvaloresform2(){
        if(eoct1.getText().toString()!=null && eoct2.getText().toString()!=null && eoct3.getText().toString()!=null && ecidrI.getText().toString()!=null){
            b2=Integer.parseInt(eb2.getText().toString());
            b3=Integer.parseInt(eb3.getText().toString());
            b4=Integer.parseInt(eb4.getText().toString());
            if(b2<=255 && b3<=255 && b4<255){
                if(b2==255 && b3==255){
                    int valor4=compararbytemascara(b4);
                    if(valor4!=-1){
                        rptaform2.setText("Máscara CIDR: /"+(24+valor4));
                    }else{
                        rptaform2.setText("Máscara incorrecta.");
                    }
                }else{
                    if(b2==255 && b3<255 && b4==0){
                        int valor3=compararbytemascara(b3);
                        if(valor3!=-1){
                            rptaform2.setText("Máscara CIDR: /"+(16+valor3));
                        }else{
                            rptaform2.setText("Máscara incorrecta.");
                        }
                    }else{
                        if(b2<255 && b3==0 && b4==0){
                            int valor2=compararbytemascara(b2);
                            if(valor2!=-1){
                                rptaform2.setText("Máscara CIDR: /"+(8+valor2));
                            }else{
                                rptaform2.setText("Máscara incorrecta.");
                            }
                        }
                    }
                }
            }else{
                Toast notificacion= Toast.makeText(this, "Campos de máscaras no deben ser mayores a 255 (Formulario 2).", Toast.LENGTH_LONG);
                notificacion.show();
            }
        }

    }
    public int compararbytemascara(int b){
        int val=-1;//En caso no coincida con ninguno de los valores del array
        int [] valores={0,128,192,224,240,248,252,254};
        for(int i=0;i<valores.length;i++){
            if(b==valores[i]){
                val=i;
                break;
            }
        }
        return val;
    }


}
