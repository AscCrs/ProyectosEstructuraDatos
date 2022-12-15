import java.util.Arrays;
import java.util.Scanner;

public class Estructuras {
    static Scanner sc = new Scanner(System.in);
    public static boolean Switch(int opc, Queue cola, int[] aux) throws Exception {
        int dato;
        int size = aux.length;
        char val;
        String clean = "\033[H\033[2J";
        System.out.println(
                "Menu de opciones: \n1.Agregar\n2.Eliminar\n3.Obtener Inicio\n4.Obtener Fin\n5.Mostrar los elementos de la cola\n6.Ordenamiento Interno\n7.Ordenamiento Externo\n8.Busquedas\n9.Salir");
        System.out.print("Ingrese una opcion: ");
        opc = sc.nextInt();
        switch (opc) {
            case 1:
                if (!(cola.size() <= size)) {
                    System.err.println("ERROR - COLA LLENA!");
                } else {
                    for (int i = 0; i < size; i++) {
                        System.out.print("Ingrese el dato: " + (i + 1) + " : ");
                        dato = sc.nextInt();
                        cola.push(dato);
                        aux[i] = dato;
                    }
                }
                System.out.println("Datos agregados correcamente!");
                System.out.flush();
                break;
            case 2:
                System.out.print("Desea eliminar el ultimo elemento añadido (Y/n)? ");
                val = sc.next().charAt(0);
                if (val == 'Y' || val == 'y') {
                    System.out.println("Acaba de eliminar " + cola.pop());
                }
                System.out.flush();
                break;
            case 3:
                System.out.println("El inicio de la cola es " + cola.getCabeza());
                System.out.flush();
                break;
            case 4:
                System.out.println("El fin de la cola es " + cola.getFin());
                System.out.flush();
                break;
            case 5:
                System.out.println("Los elementos de la cola son: ");
                System.out.println(cola.printArray());
                break;
            case 6:
                System.out.print(clean);
                System.out.println("1.BubbleSort\n2.QuickSort\n3.ShellSort\n4.RadixSort");
                System.out.print("Seleccione el metodo de ordenamiento que quiere aplicar: ");
                opc = sc.nextInt();
                System.out.println("El arreglo original es: " + Arrays.toString(aux));
                System.out.print("El arreglo ordenado es: ");
                switch (opc) {
                    case 1:
                        System.out.println(cola.bubbleSort());
                        break;
                    case 2:
                        System.out.println(cola.quickSort());
                        break;
                    case 3:
                        System.out.println(cola.shell());
                        break;
                    case 4:
                        System.out.println(cola.radixSort());
                        break;
                    default:
                        break;
                }
                break;
            case 7:
                System.out.print(clean);
                System.out.println("1.MergeSort\n2.Natural MergeSort\n3.In-place MergeSort");
                System.out.print("Seleccione el metodo de ordenamiento que quiere aplicar: ");
                opc = sc.nextInt();
                switch (opc) {
                    case 1:
                        System.out.println("El arreglo original es: " + Arrays.toString(aux));
                        System.out.print("El arreglo ordenado es: ");
                        cola.mergeSort();
                        break;
                    case 2:
                        System.out.println("El arreglo original es: " + Arrays.toString(aux));
                        System.out.print("El arreglo ordenado es: ");
                        cola.naturalMergeSort();
                        break;
                    case 3:
                        System.out.println("El arreglo original es: " + Arrays.toString(aux));
                        System.out.print("El arreglo ordenado es: ");
                        cola.intPlaceSort();
                        break;
                    default:
                        System.out.println("Opcion Invalida");
                        break;
                }
                break;
            case 8:
                int valor;
                System.out.print(clean);
                System.out.println("1.Busqueda Lineal\n2.Busqueda Binaria");
                System.out.print("Seleccione el metodo de busqueda que quiere aplicar: ");
                opc = sc.nextInt();
                switch (opc) {
                    case 1:
                        System.out.print("Indique el elemento a buscar: ");
                        valor = sc.nextInt();
                        if (!(!(cola.binarySearch(valor) == -1))) {
                            System.out.print("El elemento " + valor + " fue encontrado en la posicion "
                                    + cola.linealSearch(valor));
                        } else {
                            System.out.print("El elemento " + valor + " no se encuentra en la estructura");
                        }
                        System.out.flush();
                        break;
                    case 2:
                        System.out.print("Indique el elemento a buscar: ");
                        valor = sc.nextInt();
                        if (!(cola.binarySearch(valor) == -1)) {
                            System.out.print("El elemento " + valor + " fue encontrado en la posicion "
                                    + cola.binarySearch(valor));
                        } else {
                            System.out.print("El elemento " + valor + " no se encuentra en la estructura");
                        }
                        System.out.flush();
                        break;
                    default:
                        System.out.println("Opcion Invalida");
                        break;
                }
                break;
            case 9:
                return false;
            default:
                System.out.println("Ingrese una opcion valida");
                break;
        }
        return true;
    }
}
