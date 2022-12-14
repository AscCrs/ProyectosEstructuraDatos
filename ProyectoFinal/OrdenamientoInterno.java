import java.util.Arrays;

public class OrdenamientoInterno {
    public static String bubbleSort(int[] queue) {
        int[] aux = queue;
        sortArray(aux);
        return Arrays.toString(aux);
    }

    private static int[] sortArray(int[] arr) {
        int[] array = arr;
        int aux;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    aux = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
        array = arr;
        return array;
    }

    private static int particion(int arr[], int izq, int der) {
        int pivote = arr[izq];
        while (true) {
            while (arr[izq] < pivote) {
                izq++;
            }
            while (arr[der] > pivote) {
                der--;
            }

            if (izq >= der) {
                return der;
            }
            int aux = arr[izq];
            arr[izq] = arr[der];
            arr[der] = aux;
            izq++;
            der--;
        }
    }

    public static int[] squicksort(int[] queue) {
        int[] aux = queue;
        quicksort(aux, 0, aux.length - 1);
        return aux;
    }

    public static String quicksort(int[] queue) {
        int[] aux = queue;
        quicksort(aux, 0, aux.length - 1);
        return Arrays.toString(aux);
    }

    private static void quicksort(int arr[], int izq, int der) {
        if (izq < der) {
            int indiceParticion = particion(arr, izq, der);
            quicksort(arr, izq, indiceParticion);
            quicksort(arr, indiceParticion + 1, der);
        }
    }

    public static String radixSort(int[] queue) {
        int[] arr = queue;
        int m = getMax(arr);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, exp);
        return Arrays.toString(arr);
    }

    public static int getMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    public static void countSort(int arr[], int exp) {
        int output[] = new int[arr.length]; // arreglo de salida
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        for (i = 0; i < arr.length; i++)
            count[(arr[i] / exp) % 10]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
    }

    public static String shell(int[] queue) {
        int[] aux = queue;
        shellaux(aux);
        return Arrays.toString(aux);
    }

    private static void shellaux(int arr[]) {
        int salto, aux, i;
        boolean cambios;
        for (salto = arr.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) { // Mientras se intercambie algún elemento
                cambios = false;
                for (i = salto; i < arr.length; i++) // se da una pasada
                {
                    if (arr[i - salto] > arr[i]) { // y si están desordenados
                        aux = arr[i]; // se reordenan
                        arr[i] = arr[i - salto];
                        arr[i - salto] = aux;
                        cambios = true; // y se marca como cambio.
                    }
                }
            }
        }
    }
}
