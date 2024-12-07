/*a. Implemente en JAVA una clase llamada Recorridos ubicada dentro del paquete
ejercicio2 cumpliendo la siguiente especificación:

dfs(Graph<T> grafo): List<T>
// Retorna una lista de vértices con el recorrido en profundidad del grafo recibido como parámetro.
bfs(Graph<T> grafo): List<T>
// Retorna una lista de vértices con el recorrido en amplitud del grafo recibido como parámetro.
b. Estimar el orden de ejecución de los métodos anteriores.
	???????????????????????????????????????

*/

package practica5.ejercicio2;

import practica5.ejercicio1.*;
import practica1.ejercicio8.*;
//import practica5.ejercicio1.listaAdy.*;
import java.util.List;
import java.util.LinkedList;

public class Recorridos<T>{

	public List<T> dfs(Graph<T> grafo){
		int i;
		boolean[] marcas = new boolean[grafo.getSize()];
		List<T> lista = new LinkedList<>();
		for(i=0;i<grafo.getSize();i++) { //me aseguro que se recorran todos los vertices
			if(!marcas[i]) {
				dfs(i,grafo,lista,marcas);
			}
		}
		return lista;
	}
	
	private void dfs(int i,Graph<T> grafo, List<T> l, boolean [] marcas){ // similar a preorden de arboles generales
		marcas[i] = true;
		Vertex<T> v = grafo.getVertex(i);
		l.add(v.getData()); //procesar
		List<Edge<T>> adyacentes = grafo.getEdges(v);
		for (Edge<T> e : adyacentes) {
			int j = e.getTarget().getPosition();
			if(!marcas[j])
				dfs(j,grafo,l,marcas);
		}
	}
	
	public List<T> bfs(Graph<T> grafo){
		int i;
		boolean[] marcas = new boolean[grafo.getSize()];
		List<T> lista = new LinkedList<>();
		for(i=0;i<grafo.getSize();i++) {//me aseguro que se recorran todos los vertices
			if(!marcas[i]) 
				bfs(i,grafo,lista,marcas);
		}
		return lista;
	}
	
	private void bfs(int i, Graph<T> grafo, List<T> l, boolean[] marcas){ // similar a por niveles de arboles generales 
		marcas[i] = true;
		Vertex<T> aux = null;
		Queue<Vertex<T>> cola = new Queue<>();
		cola.enqueue(grafo.getVertex(i));
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			l.add(aux.getData()); //procesar, si uso null para separar niveles debo preguntar si no es null
			List<Edge<T>> adyacentes = grafo.getEdges(aux);
			for(Edge<T> e : adyacentes) {
				int j = e.getTarget().getPosition();
				if(!marcas[j]) {
					marcas[j] = true;
					cola.enqueue(e.getTarget());
				}
			}
			
		}
	}
	
	
}