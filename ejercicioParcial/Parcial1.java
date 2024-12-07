/* Franchesca Johnson quiere poner en marcha un emprendimiento de turismo que permita visitar los puentes cubiertos de Madison, Iowa. 
 * Franchesca posee un mapa de las localidades y la interconexion a traves de los puentes, esto se encuentra modelado a traves de un grafo
 * Los puentes (conexiones) poseen los siguientes valores: 0 = visita opcional y 1 = visita imperdible
 * Escriba un algoritmo que le permita a Francesca ofrecer el siguiente recorrido: a partir de la localidad "Cedar Creek" hasta la 
 * localidad "Joshua" , obtener el camino completo que le permita transitar por la mayor cantidad de puentes imperdibles, sin pasar 2 veces
 * por la misma localidad. En caso de existir mas de un camino posible, devolver el que transita la menor cantidad de puentes opcionales
 
  */

package ejercicioParcial;

import practica5.ejercicio1.*;

import java.util.ArrayList;
import java.util.List;

public class Parcial1 {
	private Graph<String> grafo;
	
	public List<String> obtenerCamino(String ciudadOrigen, String ciudadDestino){
		boolean[] marcas = new boolean[this.grafo.getSize()];
		ObjetoPuentes obj = new ObjetoPuentes();
		ArrayList<String> aux = new ArrayList<>();
		Vertex<String> ini = grafo.search(ciudadOrigen), dest = grafo.search(ciudadDestino);
		if(ini!=null && dest!=null) {
			int i = ini.getPosition();
			obtenerCamino(i,this.grafo,marcas,ciudadDestino,0,0,obj,aux);
		}
		return obj.getLista();
	}
	
	private void obtenerCamino(int i, Graph<String> grafo, boolean[] marcas, String ciudadDestino, int cantPuentesOpc, int cantPuentesImp, ObjetoPuentes obj, ArrayList<String> camino) {
		marcas[i] = true;
		Vertex<String> aux = grafo.getVertex(i);
		camino.add(aux.getData());
		if(!aux.getData().equals(ciudadDestino)) {
			List<Edge<String>> adyacentes = grafo.getEdges(aux);
			for(Edge<String> e : adyacentes) {
				int j = e.getTarget().getPosition();
				int dato = e.getWeight();
				if(!marcas[j]) {
					if(dato == 0) {
						obtenerCamino(j,grafo,marcas,ciudadDestino,cantPuentesOpc+1,cantPuentesImp,obj,camino);
					}
					else obtenerCamino(j,grafo,marcas,ciudadDestino,cantPuentesOpc,cantPuentesImp+1,obj,camino);
				}
			}
		}
		else {//llegue al destino
			if(cantPuentesImp >= obj.getCantImp() && cantPuentesOpc < obj.getCantOpc()) {
				ArrayList<String> copia = new ArrayList<>();
				copia.addAll(camino);
				obj.setLista(copia);
				obj.setCantImp(cantPuentesImp);
				obj.setCantOpc(cantPuentesOpc);
			}
		}
		//nose si esto esta bien puesto ahi
		camino.remove(camino.size()-1); //elimino por backtracking
		marcas[i] = false;
	}
	
	//NOSE SI ESTA BIEN PERO LA LOGICA PARECE CORRECTA
}
