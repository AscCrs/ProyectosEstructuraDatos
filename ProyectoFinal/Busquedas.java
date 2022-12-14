public class Busquedas {
    // Metodo del algoritmo de busqueda secuencial
    public static int linealSearch(int queue[], int elemento) { // O(n) - Complejidad
        int[] aux = queue; 
        for (int i = 0; i < aux.length; i++) {
            if (aux[i] == elemento)
                return i + 1; 
        }
        return -1;
    }

    // Metodo del algoritmo de busqueda binaria
    public static int binarySearch(int queue[], int l, int r, int x) { // Recursivo 
        if (r >= l) { // Mejor de los casos O(nlogn), peor caso O(n2)
            int mid = l + (r - l) / 2;
            if (queue[mid] == x)
                return mid;
            if (queue[mid] > x) 
                return binarySearch(queue, l, mid - 1, x);

            return binarySearch(queue, mid + 1, r, x);
        }
        return -1;
    }
}
