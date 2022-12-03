import java.util.Scanner;
import java.util.Arrays;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Scanner w = new Scanner(System.in);
        String clean = "\033[H\033[2J";
        int size = 0, opc = 0, dato;
        boolean vVal = true;
        char val;
        System.out.println(clean);
        do {
            System.out.print("Ingrese el limite de datos a ingresar en la cola: ");
            size = sc.nextInt();
            Queue cola = new Queue(size);
            if (size > 0) {
                int[] aux = new int[size];
                do {
                    System.out.print(clean);
                    System.out.println(
                            "Menu de opciones: \n1.Agregar\n2.Eliminar\n3.Obtener Inicio\n4.Obtener Fin\n5.Ordenamiento Interno\n6.Ordenamiento Externo\n7.Salir");
                    System.out.print("Ingrese una opcion: ");
                    opc = sc.nextInt();
                    switch (opc) {
                        case 1:
                            if (!(cola.size() <= size)) {
                                throw new Exception("Error - Cola llena");
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
                        case 6:
                            System.out.print(clean);
                            System.out.println("1.MergeSort\n2.Natural MergeSort\n3.In-place MergeSort");
                            System.out.print("Seleccione el metodo de ordenamiento que quiere aplicar: ");
                            opc = sc.nextInt();
                            System.out.println("El arreglo original es: " + Arrays.toString(aux));
                            System.out.print("El arreglo ordenado es: ");
                            switch (opc) {
                                case 1:
                                    cola.mergeSort();
                                    break;
                                case 2:
                                    cola.naturalMergeSort();
                                    break;
                                case 3:
                                    cola.intPlaceSort();
                                    break;
                            }
                            break;
                        case 7:
                            vVal = false;
                            break;
                        default:
                            break;
                    }
                    System.out.print("\n - - - - PRESIONE ENTER PARA CONTINUAR - - - - ");
                    w.nextLine();
                } while (vVal == true);
            } else {
                System.out.println("Ingrese valor valido");
            }
        } while (vVal == true);
        w.close();
        sc.close();
    }
}
