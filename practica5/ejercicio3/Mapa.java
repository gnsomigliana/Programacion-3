/*1. devolverCamino (String ciudad1, String ciudad2): List<String>
Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso
de que se pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
2. devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String>
ciudades): List<String>
Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por
las ciudades que están contenidas en la lista ciudades pasada por parámetro, si no existe
camino retorna la lista vacía. (Sin tener en cuenta el combustible).
3. caminoMasCorto(String ciudad1, String ciudad2): List<String>
Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a
ciudad2, si no existe camino retorna la lista vacía. (Las rutas poseen la distancia).
4. caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto):
List<String>
Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El
auto no debe quedarse sin combustible y no puede cargar. Si no existe camino retorna la
lista vacía.
5. caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int
tanqueAuto): List<String>
Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2
teniendo en cuenta que el auto debe cargar la menor cantidad de veces. El auto no se
debe quedar sin combustible en medio de una ruta, además puede completar su tanque al
llegar a cualquier ciudad. Si no existe camino retorna la lista vacía.*/

package practica5.ejercicio3;

import practica5.ejercicio1.*;
import java.util.List;
import java.util.ArrayList;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}
	
	//A
	
	public List<String> devolverCamino(String ciudad1,String ciudad2){
		ArrayList<String> lista = new ArrayList<String>();
		ArrayList<String> aux = new ArrayList<String>();
		boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
		Vertex<String> v = this.mapaCiudades.search(ciudad1),w = this.mapaCiudades.search(ciudad2);
		if(v!=null && w!=null) {
			int i = v.getPosition();
			devolverCamino(i,this.mapaCiudades,marcas,ciudad1,ciudad2,aux,lista);
		}
		
		return lista;
	}
	
	private void devolverCamino(int i,Graph<String> grafo,boolean[] marcas,String ciudad1, String ciudad2,ArrayList<String> actual,ArrayList<String> devolver) {
		marcas[i] = true;
		Vertex<String> aux = grafo.getVertex(i);
		actual.add(aux.getData());
		if(!aux.getData().equals(ciudad2)) { //no llegamos a la ciudad destino
			List<Edge<String>> adyacentes = grafo.getEdges(aux);
			for(Edge<String> e : adyacentes) {
				int j = e.getTarget().getPosition();
				if(!marcas[j]) {
					devolverCamino(j,grafo,marcas,ciudad1,ciudad2,actual,devolver);
				}
				if(!devolver.isEmpty()) {//si tengo un camino a devolver no sigo recorriendo el grafo
					return;
				}
			}
			actual.remove(actual.size()-1);//notar que con la vuelta de la recursion se van eliminando los elementos de la lista si no se llega a la ciudad2 
			
		}
		else
			devolver.addAll(actual);
	}
	
	//B
	
//OPCION 2 INSPIRADA EN EMI: MAS FACIL Y FUNCIONA 
	
	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
		ArrayList<String> lista = new ArrayList<String>();
		ArrayList<String> aux = new ArrayList<String>();
		boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
		Vertex<String> v = this.mapaCiudades.search(ciudad1), w = this.mapaCiudades.search(ciudad2),x;
		if(v!=null && w!=null) {
			for(String c : ciudades) {//marco las ciudades que no debemos pasar como visitadas asi no entran
				x = this.mapaCiudades.search(c);
				marcas[x.getPosition()] = true;
			}
			int i = v.getPosition();
			devolverCamino(i,this.mapaCiudades,marcas,ciudad1,ciudad2,aux,lista); // uso recorrido del inciso anterior(en este caso puedo)
		}
		return lista;
	}
	
	//C
	
	//vamos a crear un objeto para poder comparar camino actual y su distancia total con la del objeto y asi guardar un camino minimo 
	//necesitamos si o si crear un objeto porque los parametros se pasan POR VALOR EN JAVA
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		CaminoMin obj = new CaminoMin();
		boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
		ArrayList<String> aux = new ArrayList<>(); //solo necesitamos una lista porque vamos a devolver el camino minimo en el objeto
		Vertex<String> v = this.mapaCiudades.search(ciudad1), w = this.mapaCiudades.search(ciudad2);
		if(v!=null && w!=null) {
			int i = v.getPosition();
			caminoMasCorto(i,this.mapaCiudades,marcas,ciudad1,ciudad2,aux,obj,0);
		}
		return obj.getListaMin();
	}
	
	private void caminoMasCorto(int i, Graph<String> grafo, boolean[] marcas, String ciudad1, String ciudad2, List<String> camino, CaminoMin o,int distancia) {
		marcas[i] = true;
		Vertex<String> aux = grafo.getVertex(i);
		camino.add(aux.getData());
		if(!aux.getData().equals(ciudad2)) {
			List<Edge<String>> adyacentes = grafo.getEdges(aux);
			for(Edge<String> e : adyacentes) {
				int j = e.getTarget().getPosition();
				if(!marcas[j]) {
					caminoMasCorto(j,grafo,marcas,ciudad1,ciudad2,camino,o,distancia+e.getWeight());
				}
			}
		}
		else {//llegamos a la ciudad2 por lo tanto debemos comparar con el objeto
			if(distancia<o.getDistanciaMin()) {
				o.setDistanciaMin(distancia);
				ArrayList<String> copia = new ArrayList<>(); //creo una copia porque sino asigno la referencia a la lista camino solamente
				copia.addAll(camino);
				o.setListaMin(copia);
			}
		}
		camino.remove(camino.size()-1); // se elimina el ultimo elemento de la lista en backtracking
		marcas[i] = false; // debo poner la marca en falso para que se visiten en los proximos recorridos
	}
	
	//D
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
		ArrayList<String> lista = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<>();
		Vertex<String> v = this.mapaCiudades.search(ciudad1), w = this.mapaCiudades.search(ciudad2);
		if(v!=null && w!=null) {
			int i = v.getPosition();
			caminoSinCargarCombustible(i,this.mapaCiudades,marcas,ciudad1,ciudad2,tanqueAuto,aux,lista);
		}
		return lista;
	}
	
	//tomamos el combustible como el weight de la arista
	private void caminoSinCargarCombustible(int i, Graph<String> grafo, boolean[] marcas, String ciudad1, String ciudad2, int combustible, List<String> camino, List<String> caminoDevolver ) {
		marcas[i] = true;
		Vertex<String> aux = grafo.getVertex(i);
		camino.add(aux.getData());
		if(!aux.getData().equals(ciudad2)) {
			List<Edge<String>> adyacentes = grafo.getEdges(aux);
			for (Edge<String> e : adyacentes) {
				int j = e.getTarget().getPosition();
				int combustibleNec = e.getWeight();
				if(!marcas[j]) {
					if(combustibleNec<combustible) {
						caminoSinCargarCombustible(j,grafo,marcas,ciudad1,ciudad2,(combustible-combustibleNec),camino,caminoDevolver);
					}
				}
				if(!caminoDevolver.isEmpty())//devuelvo primer camino que cumpla con el requisito
					return;
			}
			camino.remove(camino.size()-1);
			marcas[i] = false;
		}
		else {//llegue a la ciudad 2
			caminoDevolver.addAll(camino);
		}
		
	}
	
	//E
	
//	public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
//		boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
//		ArrayList<String> lista = new ArrayList<>();
//		Vertex<String> v = this.mapaCiudades.search(ciudad1), w = this.mapaCiudades.search(ciudad2);
//		if(v!=null && w!=null) {
//			int i = v.getPosition();
//			caminoConMenorCargaDeCombustible(i,this.mapaCiudades,marcas,ciudad1,ciudad2,tanqueAuto,lista);
//		}
//		return lista;
//	}
//	
}
 
  