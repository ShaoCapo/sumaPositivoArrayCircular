public class Principal {

    /**
     * Funcion auxiliar para divide y vencerás
     * @param vector
     * @param i0 primer elemento a sumar
     * @param iN ultimo elemento a sumar
     * @return
     */
    public static int sumaPositivos1Aux(int[] vector, int i0, int iN){
        // si el vector solo tiene un valor
        if(i0 == iN){
            // el valor es positivo
            if(vector[i0] >= 0)
                return vector[i0];
            else
                return 0;
        }
        else {
            // DIVIDIR
            int k = (i0 + iN) / 2;
            return sumaPositivos1Aux(vector, i0, k) + sumaPositivos1Aux(vector, k + 1, iN);
        }
    }

    /**
     * La cabecera del método a implementar para el primer apartado.
     * @param vector
     * @return
     */
    public static int sumaPositivos1(int[] vector){
        // llamada a la funcion auxiliar que usará el algoritmo Divide y Vencerás
        return sumaPositivos1Aux(vector, 0, vector.length - 1);
    }

    /**
     * La cabecera del método a implementar para el segundo apartado.
     * @param vector
     * @return
     */
    public static int sumaPositivos2(int[] vector){
        return -1;
    }

}
