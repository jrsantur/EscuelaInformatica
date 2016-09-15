package chiroque.aplicaciones.com.escuelainformatica.InvestOperaciones.ClasesObjetos;

import java.util.ArrayList;

/**
 * Created by OP on 24/07/2015.
 */
public class Nodo {
int numero;
int etapa;
ArrayList<Nodo> METASantecesores=new ArrayList<Nodo>();
ArrayList<Integer> distancias=new ArrayList<Integer>();
Nodo antecesorMasCercano;
int menorDistanciaAesteNodo;

    public Nodo(int numero, int etapa) {
        this.numero = numero;
        this.etapa = etapa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getEtapa() {
        return etapa;
    }

    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }

    public ArrayList<Nodo> getMETASantecesores() {
        return METASantecesores;
    }

    public void setMETASantecesores(ArrayList<Nodo> METASantecesores) {
        this.METASantecesores = METASantecesores;
    }

    public ArrayList<Integer> getDistancias() {
        return distancias;
    }

    public void setDistancias(ArrayList<Integer> distancias) {
        this.distancias = distancias;
    }

    public Nodo getAntecesorMasCercano() {
        return antecesorMasCercano;
    }

    public void setAntecesorMasCercano(Nodo antecesorMasCercano) {
        this.antecesorMasCercano = antecesorMasCercano;
    }

    public int getMenorDistanciaAesteNodo() {
        return menorDistanciaAesteNodo;
    }

    public void setMenorDistanciaAesteNodo(int menorDistanciaAesteNodo) {
        this.menorDistanciaAesteNodo = menorDistanciaAesteNodo;
    }
}
