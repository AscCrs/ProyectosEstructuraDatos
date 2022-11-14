package Proyecto;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void limpiar() {
        String clean = "\033[H\033[2J";
        sc.nextLine();
        System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR... ");
        sc.nextLine();

        System.out.println(clean);
    }

    public static void main(String[] args) {
        Graph<Integer> grafo = new Graph<Integer>();
        int opc = 0, src = 0, dest = 0, weight = 0, a = 0;
        boolean vVal = true;

        do {
            System.out.println("Menu de opciones:\n1.Agregar Arista\n2.Eliminar Arista\n3.Eliminar Vertice");
            System.out.println("4.Verificar si existe un vertice\n5.Verificar si existe una arista");
            System.out.println("6.Buscar si existe un camino entre dos nodos\n7.Imprimir grafo\n8.Salir");
            System.out.print("Ingrese su opcion: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("Ingrese el valor del vertice que va a ingresar: ");
                    src = sc.nextInt();
                    System.out.print("Ingrese el vertice con el cual estara conectado: ");
                    dest = sc.nextInt();
                    System.out.print("Ingrese el peso que tendra recorrer ese vertice: ");
                    weight = sc.nextInt();

                    grafo.addEdge(src, dest, weight);
                    limpiar();
                    break;
                case 2:
                    System.out.print("Ingrese el vertice fuente: ");
                    src = sc.nextInt();
                    System.out.print("Ingrese el vertice destino: ");
                    dest = sc.nextInt();

                    grafo.removeEdge(src, dest);
                    limpiar();
                    break;
                case 3:
                    System.out.print("Ingrese el vertice que desea eliminar: ");
                    a = sc.nextInt();

                    grafo.removeNode(a);
                    limpiar();
                    break;
                case 4:
                    System.out.print("Ingrese el vertice que desea buscar: ");
                    a = sc.nextInt();
                    System.out.println("El vertice existe: " + grafo.hasNode(a));
                    limpiar();
                    break;
                case 5:
                    System.out.print("Ingrese el vertice fuente: ");
                    src = sc.nextInt();
                    System.out.print("Ingrese el vertice destino: ");
                    dest = sc.nextInt();

                    System.out
                            .println("Existe una arista entre " + src + " y " + dest + ": " + grafo.hasEdge(src, dest));
                    limpiar();
                    break;
                case 6:
                    System.out.print("Ingrese el vertice fuente: ");
                    src = sc.nextInt();
                    System.out.print("Ingrese el vertice destino: ");
                    dest = sc.nextInt();
                    System.out.println("Existe un camino desde el vertice " + src + " hasta el vertice " + dest + ": "
                            + grafo.hasPathDFS(src, dest));
                    limpiar();
                    break;
                case 7:
                    grafo.printAdyacencyList();
                    limpiar();
                    break;
                case 8:
                    vVal = false;
                    break;
                case 9:
                    grafo.listaAristas();
                    limpiar();
                    break;
                default:
                    break;
            }
        } while (vVal == true);
        sc.close();
    }
}
