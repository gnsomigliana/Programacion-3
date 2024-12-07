/*Se quiere realizar un paseo en bicicleta por lugares emblemáticos de Oslo. Para esto se cuenta
con un grafo de bicisendas. Partiendo desde el “Ayuntamiento” hasta un lugar destino en menos
de X minutos, sin pasar por un conjunto de lugares que están restringidos
Escriba una clase llamada VisitaOslo e implemente su método:
paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String>
lugaresRestringidos) : List<String>
En este ejemplo, para llegar desde Ayuntamiento a Museo Vikingo, sin pasar por: {“Akker
Brigge”, “Palacio Real”} y en no más de 120 minutos, el camino marcado en negrita cumple las
condiciones.
Notas:
● El “Ayuntamiento” debe ser buscado antes de comenzar el recorrido para encontrar un
camino.
● De no existir camino posible, se debe retornar una lista vacía.
● Debe retornar el primer camino que encuentre que cumple las restricciones.
● Ejemplos de posibles caminos a retornar, sin pasar por “Akker Brigge” y “Palacio Real” en
no más de 120 min (maxTiempo)
● Ayuntamiento, El Tigre, Museo Munch, Parque Botánico, Galería Nacional,
Parque Vigeland, FolkMuseum, Museo Fram, Museo del Barco Polar, Museo
Vikingo. El recorrido se hace en 91 minutos.
● Ayuntamiento, Parque Botánico, Galería Nacional, Parque Vigeland,
FolkMuseum, Museo Fram, Museo del Barco Polar, Museo Vikingo. El
recorrido se hace en 70 minutos.

*/

package practica5.ejercicio4;

import practica5.ejercicio1.*;
import java.util.List;
import java.util.ArrayList;

public class VisitaOslo {
	
	public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
		boolean[] marcas = new boolean[lugares.getSize()];
		ArrayList<String> lista = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<>();
		Vertex<String> inicio = lugares.search("Ayuntamiento");
		if(inicio!=null) { //me aseguro que exista el lugar de partida
			int x;
			for(String l : lugaresRestringidos) {// pongo como visitados los lugares restringidos para que no se acceda
				x = lugares.search(l).getPosition();
				marcas[x] = true;
			}
			int i = inicio.getPosition();
			paseoEnBici(i,lugares,marcas,destino,maxTiempo,0,aux,lista);
		}
		return lista;
	}
	
	public void paseoEnBici(int i, Graph<String> lugares, boolean[] marcas, String destino, int maxTiempo, int tiempoAcumulado, ArrayList<String> camino, ArrayList<String> caminoDevolver) {
		marcas[i] = true;
		Vertex<String> aux = lugares.getVertex(i);
		camino.add(aux.getData());
		if(!aux.getData().equals(destino)) {
			List<Edge<String>> adyacentes = lugares.getEdges(aux);
			for(Edge<String> e : adyacentes) {
				int j = e.getTarget().getPosition();
				if(!marcas[j]) {
					if(tiempoAcumulado + e.getWeight() < maxTiempo) {
						paseoEnBici(j,lugares,marcas,destino,maxTiempo,tiempoAcumulado+e.getWeight(),camino,caminoDevolver);
					}
					if(!caminoDevolver.isEmpty())//me aseguro que devuelva el primer camino
						return;
				}
			}
			camino.remove(camino.size()-1); //elimino el ultimo elemento con backtracking
			marcas[i] = false;
		}
		else {//llegue al destino
			caminoDevolver.addAll(camino);
		}
	}
	//NO PROBADO PERO LA LOGICA PARECE CORRECTA
	//SI ME PIDIERA EL CAMINO CON EL TIEMPO MAS CORTO AHI DEBERIA CREAR UN OBJETO PARA GUARDAR EL TIEMPO DEL CAMINO, PERO ACA
	//SOLO NOS PIDE EL PRIMER CAMINO QUE SE PUEDA RECORRER SIN EXCEDER UN TIEMPO FIJO 
}
