package Proyecto;

import java.util.*;

public class Graph<T> {
    Map<T, LinkedList<Edge<T>>> adyacencylist;

    // Constructor
    public Graph() {
        adyacencylist = new HashMap<>();
    }

    /**
     * Agrega los nodos y las conexiones de cada arista
     * 
     * @param a Indica el nodo fuente
     * @param b Indica el nodo al que se encontrara conectada la fuente
     * @param w Indica el peso o coste de recorrer ese camino
     * @T Indica que la clase y los tipos de datos utilizados son genericos,
     * @ por lo que podria tomar valores numericos o objetos
     */
    public void addEdge(T a, T b, int w) {
        adyacencylist.putIfAbsent(a, new LinkedList<>()); // Agrega el nodo de origen
        adyacencylist.putIfAbsent(b, new LinkedList<>()); // Agrega el nodo al cual estara conectado
        Edge<T> edge1 = new Edge<>(b, w);
        adyacencylist.get(a).add(edge1); // Agrega la arista
    }

    /**
     * Metodo auxiliar que encuentra una arista entre dos nodos
     * 
     * @param a Indica el nodo fuente a partir del cual se realizara la busqueda
     * @param b Indica el nodo al cual se encuentra conectada la fuente
     * @return Devolvera el objeto vertice en caso de ser encontrado
     */
    private Edge<T> findEdgeByVertice(T a, T b) {
        LinkedList<Edge<T>> listAux = adyacencylist.get(a);
        for (Edge<T> edge : listAux) {
            if (edge.verticeConectado.equals(b))
                return edge;
        }
        return null;
    }

    /**
     * Elimina la conexion directa entre un nodo a y b
     * 
     * @param a Indica el nodo fuente
     * @param b Indica el con el cual se eliminara la conexion
     */
    public void removeEdge(T a, T b) {
        LinkedList<Edge<T>> auxSource = adyacencylist.get(a);
        LinkedList<Edge<T>> auxTarget = adyacencylist.get(b);
        if (auxSource == null || auxTarget == null) {
            System.out.println("No se puede eliminar porque no existe esa conexion!");
            return;
        }
        Edge<T> edge1 = findEdgeByVertice(a, b);
        auxSource.remove(edge1);
    }

    /**
     * Elimina un nodo, incluyendo todas sus conexiones con las demas aristas
     * 
     * @param a Indica la arista que se va a eliminar
     * 
     */
    public void removeNode(T a) {
        for (T key : adyacencylist.keySet()) {
            Edge<T> edge2 = findEdgeByVertice(key, a);
            if (edge2 != null)
                adyacencylist.get(key).remove(edge2);
        }
        adyacencylist.remove(a);
    }

    /**
     * Verifica si un nodo existe a traves de su llave (hash)
     * 
     * @param key Valor que tiene el nodo (llave)
     * @return Valor booleano dependiendo si es que el elemento existe o no
     */
    public boolean hasNode(T key) {
        return adyacencylist.containsKey(key);
    }

    /**
     * Verifica si es que existe una conexion directa entre dos nodos
     * 
     * @param a Nodo fuente
     * @param b Nodo objetivo sobre el cual se verificara si existe la conexion
     * @return valor booleano dependiendo de si existe o no la conexion con el nodo
     */
    public boolean hasEdge(T a, T b) {
        Edge<T> edge1 = findEdgeByVertice(a, b);
        return edge1 != null;
    }

    /**
     * Metodo principal del algoritmo DFS (Busqueda por profundidad)
     * 
     * @param src  Indica el nodo fuente sobre el cual se iniciara la busqueda
     * @param dest Indica el nodo destino sobre el cual se analizara si existe o no
     *             un camino
     * 
     *             El algoritmo DFS recorre los nodos del grafo. Expande cada uno de
     *             los nodos que va localizando
     *             de forma recursiva. Cuando ya no queden mas nodos que visitar en
     *             el camino, regresara al nodo
     *             predecesor, este algoritmo utiliza una pila recursiva.
     */
    public boolean hasPathDFS(T src, T dest) {
        HashMap<T, Boolean> visited = new HashMap<>();
        return dfsHelper(src, dest, visited);
    }

    /**
     * Metodo auxiliar del dfs
     * 
     * @param src  Indica la fuente sobre la cual se la busqueda
     * @param dest Indica el nodo sobre el cual se buscara si existe un camino
     */
    private boolean dfsHelper(T src, T dest, HashMap<T, Boolean> visited) {
        if (!(src == dest)) {
            visited.put(src, true);
            for (Edge<T> edge : adyacencylist.get(src)) {
                T u = edge.verticeConectado;
                if (visited.get(u) == null)
                    return dfsHelper(u, dest, visited);
            }
            return false;
        } else
            return true;
    }

    // Imprime el grafo
    public void printAdyacencyList() {
        for (T key : adyacencylist.keySet()) {
            System.out.println(key + " -> " + adyacencylist.get(key));
        }
    }
    
    // Imprime la lista de aristas
    public void printEdgelist(){       
        for(T key : adyacencylist.keySet()){
            LinkedList<Edge<T>> listaux = adyacencylist.get(key);            
            for(Edge<T> edge : listaux){                
                System.out.print("( "+key+" , "+edge.getVertice()+" ) ");           
            }
        }
        System.out.println();
    }

    //Imprime la matriz de adyacencia
    public void printAdyacencyMatrix(){
        System.out.print("   ");
        for(T key : adyacencylist.keySet()){
            System.out.print(" "+key+" ");
        }
        System.out.println();
        System.out.println("   ---------------------------");
        for(T key : adyacencylist.keySet()){
            System.out.print(key+"| ");
            for(T key2 : adyacencylist.keySet()){
                if(hasEdge(key, key2)){
                    System.out.print(" 1 ");
                }else{
                    System.out.print( " 0 ");
                }
            }
            System.out.println();
        }
    }
}
