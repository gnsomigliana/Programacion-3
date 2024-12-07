/*Un día, Caperucita Roja decide ir desde su casa hasta la de su abuelita, recolectando frutos del
bosque del camino y tratando de hacer el paseo de la manera más segura posible. La casa de
Caperucita está en un claro del extremo oeste del bosque, la casa de su abuelita en un claro del
extremo este, y dentro del bosque entre ambas hay algunos otros claros.
El bosque está representado por un grafo, donde los vértices representan los claros (identificados
por un String) y las aristas los senderos que los unen. Cada arista informa la cantidad de árboles
frutales que hay en el sendero. Caperucita sabe que el lobo es muy goloso y le gustan mucho las
frutas, entonces para no ser capturada por el lobo, desea encontrar todos los caminos que no
pasen por los senderos con cantidad de frutales >= 5 y lleguen a la casa de la abuelita.
Su tarea es definir una clase llamada BuscadorDeCaminos, con una variable de instancia llamada
"bosque" de tipo Graph, que representa el bosque descrito e implementar un método de instancia
con la siguiente firma:
public List < List <String>> recorridosMasSeguro()
que devuelva un listado con TODOS los caminos que cumplen con las condiciones mencionadas
anteriormente.
Nota: La casa de Caperucita debe ser buscada antes de comenzar a buscar el recorrido.
*/

package practica5.ejercicio6;

import practica5.ejercicio1.*;
import java.util.List;
import java.util.ArrayList;

public class BuscadorDeCaminos {
	private Graph<String> bosque;
	
	public List<List<String>> recorridoMasSeguro(){
		String ini = "Casa Caperucita", dest = "Casa Abuelita"; // podria recibirse como parametro tambien
		boolean[] marcas = new boolean[this.bosque.getSize()];
		ArrayList<List<String>> lista = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<>();
		Vertex<String> inicio = this.bosque.search(ini);
		if(ini!=null) {
			int i = inicio.getPosition();
			recorridoMasSeguro(i,this.bosque,marcas,dest,5,aux,lista);
		}
		return lista;
	}
	
	private void recorridoMasSeguro(int i, Graph<String> grafo, boolean[] marcas, String destino, int maxFrutales, ArrayList<String> camino, ArrayList<List<String>> caminos) {
		marcas[i] = true;
		Vertex<String> aux = grafo.getVertex(i);
		camino.add(aux.getData());
		if(!aux.getData().equals(destino)) {
			List<Edge<String>> adyacentes = grafo.getEdges(aux);
			for(Edge<String> e : adyacentes) {
				int frutales = e.getWeight();
				int j = e.getTarget().getPosition();
				if(frutales<maxFrutales && !marcas[j]) {//llamo a la recursion solo con los que no hayan sido visitos y cumplan condicion
					recorridoMasSeguro(j,grafo,marcas,destino,maxFrutales,camino,caminos); 
				}
			}
			marcas[i] = false; //desmarcamos para que puedan acceder otros caminos
			camino.remove(camino.size()-1); //por backtracking eliminamos el ultimo elemento de la lista
		}
		else {//llegamos al destino
			caminos.add(camino);
			//no deberiamos dejar camino vacio???
		}
	}
	//NO ESTA PROBADO PERO LA LOGICA PARECE CORRECTA
}
