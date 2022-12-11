import java.util.Arrays;

/*
 * Programa de cola simple con arreglos
 */
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

    public String printArray() {
        return Arrays.toString(queue);
    }

    public void intPlaceSort() {
        OrdenamientoExterno.inplaceSort(queue);
    }

    public void naturalMergeSort() {
        OrdenamientoExterno.Naturalsort(queue);
    }

    public void mergeSort() {
        OrdenamientoExterno.sort(queue, 0, queue.length - 1);
        OrdenamientoExterno.printArray(queue);
    }

    public String bubbleSort() {
        return OrdenamientoInterno.bubbleSort(queue);
    }

    public String quickSort() {
        return OrdenamientoInterno.quicksort(queue);
    }

    public String radixSort() {
        return OrdenamientoInterno.radixSort(queue);
    }

    public String shell() {
        return OrdenamientoInterno.shell(queue);
    }

    public int linealSearch(int n) {
        return Busquedas.linealSearch(queue, n);
    }

    public int binarySearch(int n) {
        int[] arr = OrdenamientoInterno.squicksort(queue);
        return Busquedas.binarySearch(arr, 0, arr.length - 1, n);
    }
}
