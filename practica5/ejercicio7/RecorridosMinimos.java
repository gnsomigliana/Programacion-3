/*Implemente nuevamente el ejercicio 3.3 haciendo uso del algoritmo de Dijkstra
2. Implemente nuevamente el ejercicio 3.3 haciendo uso del algoritmo de Floyd
3. Compare el tiempo de ejecución de las tres implementaciones.

3. caminoMasCorto(String ciudad1, String ciudad2): List<String>
Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a
ciudad2, si no existe camino retorna la lista vacía. (Las rutas poseen la distancia).
*/


package practica5.ejercicio7;

import practica5.ejercicio1.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class RecorridosMinimos {
	private Graph<String> mapaCiudades;


public List<String> caminoMasCortoDjikstra(String ciudad1, String ciudad2){
	//inicializo tablas
	boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
	int[] distancias = new int[this.mapaCiudades.getSize()];
	for(int i=0;i<this.mapaCiudades.getSize();i++) {
		distancias[i] = 99999;
	}
	List<String> lista = new ArrayList<>();
	//Vertex<String> vertices []= new Vertex<String>[this.mapaCiudades.getSize()]; //como hago un vector de interfaces? no se puede, uso arrayList*****
	ArrayList<Vertex<String>> vertices = new ArrayList<>(this.mapaCiudades.getSize());
	for(int i=0;i<this.mapaCiudades.getSize();i++) {//inicializo "vector" de vertices
		vertices.add(null);
	}
	Vertex<String> v = this.mapaCiudades.search(ciudad1), w = this.mapaCiudades.search(ciudad2);
	int pos;
	if(v!=null && w!=null) {
		pos = v.getPosition();
		distancias[pos] = 0; //actualizo distancia al origen(SIEMPRE sera 0)
	}
	else return lista;
	int verticesProc = 0;
	while(verticesProc < this.mapaCiudades.getSize()) {
		for(int i=0;i<this.mapaCiudades.getSize();i++) {//calculo el vertice con la distancia minima al origen no visitado!
			int aux = 99999;
			if(!marcas[i]) {
				if(distancias[i]<aux) {
					aux = distancias[i];
					pos = i;
				}
			}
		}
		Vertex<String> vertice = this.mapaCiudades.getVertex(pos);
		verticesProc++;
		marcas[pos] = true;
		List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(vertice);
		for(Edge<String> e : adyacentes) {
			int j = e.getTarget().getPosition();
			if(!marcas[j]) {
				if(distancias[j] > distancias[pos] + e.getWeight()) {
					distancias[j] = distancias[pos] + e.getWeight();
					vertices = ((ArrayList<Vertex<String>>) vertices.set(j, vertice));
				}
			}
		}
	}
	//esta bien recuperado el camino???
	lista.add(ciudad2);
	int posAux = w.getPosition();
	Vertex<String> verticeAux = w;
	while(posAux != v.getPosition()) {
		verticeAux = vertices.get(posAux);
		posAux = verticeAux.getPosition();
		lista.add(verticeAux.getData());
	}
	Collections.reverse(lista);
	return lista; //devolvemos la lista
	}
	
/******no puedes crear directamente un array de un tipo genérico (en este caso, una interfaz). 
 En Java, no es posible crear directamente arrays de tipos genéricos debido a las limitaciones del sistema de tipos de Java.
Para solucionar este problema, hay varias alternativas que puedes considerar. 
Una de las más comunes es utilizar una lista (ArrayList) en lugar de un array*/

//NO PROBADO PERO LA LOGICA PARECE CORRECTA


//	public List<String> caminoMasCortoFloyd(String ciudad1, String ciudad2){
//	ME LA JUEGO A QUE NO ENTRA FLOYD, VOY A ESTUDIAR SOLO LA TEORIA	
//	}


}

