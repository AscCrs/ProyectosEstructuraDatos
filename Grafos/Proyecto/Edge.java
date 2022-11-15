package Proyecto;

public class Edge<T> {
    T verticeConectado; // Vertice conectado
	int peso; //weight
	
	//Constructor, Time O(1) Space O(1)
	public Edge(T v, int w) {
		this.verticeConectado = v; 
		this.peso = w;
	}
	public T getVertice(){
		return verticeConectado;
	}
	@Override
	public String toString() {
		return "(" + verticeConectado + "," + peso + ")";
	}
}
