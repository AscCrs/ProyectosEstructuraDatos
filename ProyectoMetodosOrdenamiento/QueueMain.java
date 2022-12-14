import java.util.Scanner;

public class QueueMain {
    static Scanner sc = new Scanner(System.in);
    static Scanner w = new Scanner(System.in);
    static int size = 0, opc = 0;
    static boolean vVal = true;
    static String clean = "\033[H\033[2J";
    public static void main(String[] args) throws Exception {
        System.out.println(clean);
        do {
            System.out.print("Ingrese el limite de datos a ingresar en la cola: ");
            size = sc.nextInt();
            Queue cola = new Queue(size);
            if (size > 0) {
                int[] aux = new int[size];
                do {
                    vVal = Estructuras.Switch(opc, cola, aux);
                    System.out.print("\n - - - - PRESIONE ENTER PARA CONTINUAR - - - - ");
                    w.nextLine();
                    System.out.print(clean);
                } while (vVal == true);
            } else {
                System.out.println("Ingrese valor valido");
            }
        } while (vVal == true);
        w.close();
        sc.close();
    }
}
