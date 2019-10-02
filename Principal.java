public class Principal {

    public static int maxSubArray(int[] vector, int i0, int k, int iN){
        int max = Integer.MIN_VALUE; int suma = 0;
        for (int i = k; i >= i0; i--) {
            suma += vector[i];
            if (suma > max) {
                max = suma;
            }
        }
        suma=max;
        for (int j = k+1; j <= iN; j++) {
            suma += vector[j];
            if (suma > max) {
                max = suma;
            }
        }
        return max;
    }

    /**
     * Funcion auxiliar para divide y vencerás
     * @param vector
     * @param i0 primer elemento a sumar
     * @param iN ultimo elemento a sumar
     * @return
     */
    // {-15, -12, -10, -7, -3, -2, -2, 0, 1, -19, -15, -15} => i0 = 0 ; iN = 11
    public static int sumaPositivos1Aux(int[] vector, int i0, int iN){
        // si el siguiente número es negativo, paramos
        if(i0 == iN)
            return vector[i0];
        else {
            // DIVIDIR
            int k = (i0 + iN) / 2;
            // CONQUISTAR
            int m1 = sumaPositivos1Aux(vector, i0, k);
            int m2 = sumaPositivos1Aux(vector, k + 1, iN);
            //COMBINAR
            int m3 = maxSubArray(vector, i0, k, iN);
            return Math.max(m1, Math.max(m2, m3));
        }
    }

    /**
     * La cabecera del método a implementar para el primer apartado.
     * @param vector
     * @return
     */
     public static int sumaPositivos1(int[] vector){
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
