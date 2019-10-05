public class Principal {

    /**
     * Función auxiliar para divide y vencerás
     * @param vector
     * @param i0 primer elemento a sumar
     * @param iN ultimo elemento a sumar
     * @return
     */
    public static int sumaPositivos1Aux(int[] vector, int i0, int iN){
        // El vector tiene un solo elemento
        if(i0 == iN){ // PASO BASE
            // El elemento es positivo
            if(vector[i0] >= 0)
                // Devolvemos el elemento
                return vector[i0];
            else
                // Si no es positivo devolvemos 0
                return 0;
        }
        else { // PASO DE INDUCCIÓN
            // DIVIDIR
            int k = (i0 + iN) / 2; // Dividimos por dos el array
            // CONQUISTAR - COMBINAR
            // Sumamos los elementos positivos del array
            return sumaPositivos1Aux(vector, i0, k) + sumaPositivos1Aux(vector, k + 1, iN);
        }
        /**
         * COMPLEJIDAD:
         * T(N) = 2T(N/2) + O(1) = O(N)
         * 1er Caso del Teorema del Maestro
         */
    }

    /**
     * La cabecera del método a implementar para el primer apartado.
     * @param vector
     * @return
     */
    public static int sumaPositivos1(int[] vector){
        // Llamada a la funcion auxiliar que usará el algoritmo Divide y Vencerás
        return sumaPositivos1Aux(vector, 0, vector.length - 1);
    }

    /**
     * Función auxiliar para divide y vencerás
     * @param vector
     * @param i0 primer elemento a sumar
     * @param iN ultimo elemento a sumar
     * @return
     */
    public static int sumaPositivos2Aux(int[] vector, int i0, int iN){
        // El vector tiene un solo elemento
        if(i0 == iN){ // PASO BASE
            // El elemento es positivo
            if(vector[i0] >= 0)
                // Devolvemos el elemento
                return vector[i0];
            else
                // Si no es positivo devolvemos 0
                return 0;
        }
        else {
            int k = (i0 + iN) / 2; // Dividimos por dos el array
             // El primer elemento (i0) y el ultimo (k) son negativos
             // y el primero es menor que el ultimo (k) quiere decir que es un subArray de negativos
            if(vector[i0] < 0 && vector[k] < 0 && vector[i0] < vector[k])
                // Cambiamos al lado derecho del subArray
                return sumaPositivos2Aux(vector, k+1, iN);
            // Igual pero con el otro subArray
            // Si el primer elemento (k + 1) y el ultimo (iN) son negativos
            // Y el primero es menor que el ultimo (iN) quiere decir que es un subArray de negativos
            else if (vector[k+1] < 0 && vector[iN] < 0 && vector[k+1] < vector[iN])
                // Cambiamos al lado izquierda del subArray
                return sumaPositivos2Aux(vector, i0, k);
                // Si es un subArray de positivos sumamos los elementos
                else return sumaPositivos2Aux(vector, i0, k) + sumaPositivos2Aux(vector, k + 1, iN);
        }
        /**
         * 
         */
    }

    public static int sumaPositivos2(int[] vector){
        return sumaPositivos2Aux(vector, 0, vector.length - 1);
    }
}
