/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chiroque.aplicaciones.com.escuelainformatica.InvestOperaciones.metodosimplex;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *
 * @author Simplex
 */
public class Problema {
   Tabla proceso;
   boolean  accionMax; //maximizar = true , minimizar = false
   ArrayList<Restriccion> restricciones = new ArrayList<Restriccion>();

   public Problema(boolean max){
       accionMax=max;
   }

    public void nuevaRestriccion(String subindicesn,String desigualdadn,String valorObjn){
        try{
        restricciones.add(new Restriccion(subindicesn, desigualdadn, valorObjn,0));
        }catch(Exception ex){System.out.println("Problema en la restriccion "+restricciones.size());}
        }

    public void setFuncionObjetivo(double[] funcObj){
         for(int i=0;i<funcObj.length;i++){
             try{
            funcObj[i] = funcObj[i] * -1;
             }catch(Exception ex){
             System.out.println("Error en Problema.setFuncionObjetivo");
             }
         }
        restricciones.add(new Restriccion(funcObj, 0, 0, 1));
    }

/*
 * prepara el problema
 */
    public void preparar(){
        proceso=new Tabla(this);
    }

    public String resolverMetodoSimplex() {
        String resultado="Rpta:\n";
        proceso.resolverMetodoSimplex(accionMax);
        for(int i=0;i<proceso.resultado.length;i++){
           resultado=resultado+" x"+(i+1)+" = "+proceso.resultado[i]+"\n";
        }
        resultado=resultado+" z = "+proceso.z;
        return resultado;
    }

    public void borrarTodo(){
     restricciones.clear();
    }

}
