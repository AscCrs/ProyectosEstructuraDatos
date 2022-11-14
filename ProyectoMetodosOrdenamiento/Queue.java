/*
 * Programa de cola simple con arreglos
 */

import java.util.Arrays;

public class Queue {
    private int queue[];
    private int cabeza = 0;
    private int fin = -1;
    private int size = 0;

    Queue(int size) {
        this.size = size;
        queue = new int[size];
    }

    public int getCabeza() {
        return queue[cabeza];
    }

    public int getFin() {
        return queue[fin];
    }

    public int size() {
        return fin + 1;
    }

    public Object pop() throws Exception {
        if (!isEmpty()) {
            return queue[cabeza++];
        } else {
            throw new Exception("Error - Queue is empty");
        }
    }

    public void push(int data) throws Exception {
        if (!isFull()) {
            queue[++fin] = data;
        } else
            throw new Exception("Error - Queue is full");
    }

    private boolean isFull() {
        return (size() > size);
    }

    private boolean isEmpty() {
        return (fin < 0);
    }

    public String bubbleSort() {
        int[] aux = queue;
        sortArray(aux);
        return Arrays.toString(aux);
    }

    private int[] sortArray(int[] arr) {
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

    private int particion(int arr[], int izq, int der) {
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

    public String quicksort() {
        int[] aux = queue;
        quicksort(aux, 0, aux.length - 1);
        return Arrays.toString(aux);
    }

    private void quicksort(int arr[], int izq, int der) {
        if (izq < der) {
            int indiceParticion = particion(arr, izq, der);
            quicksort(arr, izq, indiceParticion);
            quicksort(arr, indiceParticion + 1, der);
        }
    }

    // Metodo que devuelve el maximo valor edl arreglo
    public int getMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    // Funcion que contara la cantidad de ordenamientos del arreglo de acuerdo
    // al digito representado por el exponencial
    public void countSort(int arr[], int exp) {
        int output[] = new int[arr.length]; // arreglo de salida
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Conteo de las concurrencias en el arreglo Count[]
        for (i = 0; i < arr.length; i++)
            count[(arr[i] / exp) % 10]++;

        // Cambio de count[i] para que count[] contenga la
        // posicion actual del digito en el arreglo de salida[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Construir el arreglo de salida
        for (i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copia de la salida del arreglo en arr[], para que arr[] ahora
        // Copy the output array to arr[], so that arr[] now
        // contenga los numeros ordenados de acuerdo a al digito actual
        for (i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }

    // La funcion principal ordenara un arreglo arr[] de
    // ancho n usando el ordenamiento radix
    public String radixSort() {
        // Busca el maximo numero
        int[] arr = queue;
        int m = getMax(arr);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, exp);

        return Arrays.toString(arr);
    }

    public String shell() {
        int[] aux = queue;
        shell(aux);
        return Arrays.toString(aux);
    }

    private void shell(int arr[]) {

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
