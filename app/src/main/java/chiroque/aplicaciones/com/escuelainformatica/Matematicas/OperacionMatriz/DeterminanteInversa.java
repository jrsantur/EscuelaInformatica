package chiroque.aplicaciones.com.escuelainformatica.Matematicas.OperacionMatriz;

/**
 * Created by OP on 26/06/2015.
 */
public class DeterminanteInversa {
    public double determinante(double[][] matr)
    {
        double det;
        if(matr.length==2)
        {
            det=(matr[0][0]*matr[1][1])-(matr[1][0]*matr[0][1]);
            return det;
        }
        double suma=0;
        for(int i=0; i<matr.length; i++){
            double[][] nm=new double[matr.length-1][matr.length-1];
            for(int j=0; j<matr.length; j++){
                if(j!=i){
                    for(int k=1; k<matr.length; k++){
                        int indice=-1;
                        if(j<i)
                            indice=j;
                        else if(j>i)
                            indice=j-1;
                        nm[indice][k-1]=matr[j][k];
                    }
                }
            }
            if(i%2==0)
                suma+=matr[i][0] * determinante(nm);
            else
                suma-=matr[i][0] * determinante(nm);
        }
        return suma;
    }

    public double[][] matrInversa(double[][] matr) {
        double det=1/determinante(matr);
        double[][] nmatriz= matrAdjunta(matr);
        multMatriz(det, nmatriz);
        return nmatriz;
    }


    public void multMatriz(double n, double[][] matr) {
        for(int i=0;i<matr.length;i++)
            for(int j=0;j<matr.length;j++)
                matr[i][j]*=n;
    }

    public double[][] matrAdjunta(double[][] matr){
        return matrTransp(MatrCofactores(matr));
    }

    public double[][] MatrCofactores(double[][] matr) {
        double[][] nm = new double[matr.length][matr.length];
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr.length; j++) {
                double[][] det = new double[matr.length - 1][matr.length - 1];
                double detValor;
                for (int k = 0; k < matr.length; k++) {
                    if (k != i) {
                        for (int l = 0; l < matr.length; l++) {
                            if (l != j) {
                                int indice1 = k < i ? k : k - 1;
                                int indice2 = l < j ? l : l - 1;
                                det[indice1][indice2] = matr[k][l];
                            }
                        }
                    }
                }
                detValor = determinante(det);
                nm[i][j] = detValor * (double) Math.pow(-1, i + j + 2);
            }
        }
        return nm;
    }

    public double[][] matrTransp(double[][] matr){
        double[][]nuevam=new double[matr[0].length][matr.length];
        for(int i=0; i<matr.length; i++)
        {
            for(int j=0; j<matr.length; j++)
                nuevam[i][j]=matr[j][i];
        }
        return nuevam;
    }

}
