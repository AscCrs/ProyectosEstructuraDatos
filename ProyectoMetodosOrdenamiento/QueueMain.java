import java.util.Scanner;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = 0, opc = 0;
        boolean vVal = true;
        char val;

        try {
            do {
                System.out.print("Ingrese el limite de datos a ingresar en la cola: ");
                size = sc.nextInt();
                Queue cola = new Queue(size);
                if (size > 0) {
                    do {
                        System.out.println(
                                "Menu de opciones: \n1.Agregar\n2.Eliminar\n3.Obtener Inicio\n4.Obtener Fin\n5.Salir");
                        System.out.print("Ingrese una opcion: ");
                        opc = sc.nextInt();
                        switch (opc) {
                            case 1:
                                if (!(cola.size() <= size)) {
                                    throw new Exception("Error - Cola llena");
                                } else {
                                    for (int i = 0; i < size; i++) {
                                        System.out.print("Ingrese el dato: " + (i + 1) + " : ");
                                        cola.push(sc.nextInt());
                                    }
                                }
                                System.out.println("Datos agregados correcamente!");
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                System.out.print("Desea eliminar el ultimo elemento añadido (Y/n)? ");
                                val = sc.next().charAt(0);
                                if (val == 'Y' || val == 'y') {
                                    System.out.println("Acaba de eliminar " + cola.pop());
                                }
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 3:
                                System.out.println("El inicio de la cola es " + cola.getCabeza());
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 4:
                                System.out.println("El fin de la cola es " + cola.getFin());
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 5:
                                System.out.print("Seleccione el metodo de ordenamiento que quiere aplicar: ");
                                opc = sc.nextInt();
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
                            case 6:
                                vVal = false;
                                break;
                            default:
                                break;
                        }
                    } while (vVal == true);
                } else {
                    System.out.println("Ingrese valor valido");
                }
            } while (vVal == true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
