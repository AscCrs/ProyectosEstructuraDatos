public class Busquedas {
    // Metodo del algoritmo de busqueda secuencial
    public static int linealSearch(int queue[], int elemento) {
        int[] aux = queue;
        for (int i = 0; i < aux.length; i++) {
            if (aux[i] == elemento)
                return i;
        }
        return -1;
    }

    // Metodo del algoritmo de busqueda binaria
    public static int binarySearch(int queue[], int l, int r, int x) {
        if (r >= l) { 
            int mid = l + (r - 1) / 2;
            if (queue[mid] == x) 
                return mid;
            if (queue[mid] > x)
                return binarySearch(queue, l, mid - 1, x); 

            return binarySearch(queue, mid + 1, r, x);
        }
        return -1;
    }
}
