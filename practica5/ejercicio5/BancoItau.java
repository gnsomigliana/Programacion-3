/* El Banco Itaú se suma a las campañas "QUEDATE EN CASA" lanzando un programa para acercarle
a los jubilados el sueldo hasta sus domicilios. Para ello el banco cuenta con información que
permite definir un grafo de personas donde la persona puede ser un jubilado o un empleado del
banco que llevará el dinero.
Se necesita armar la cartera de jubilados para cada empleado repartidor del banco, incluyendo en
cada lista los jubilados que vivan un radio cercano a su casa y no hayan percibido la jubilación del
mes. Para ello, implemente un algoritmo que dado un Grafo<Persona> retorne una lista de
jubilados que se encuentren a una distancia menor a un valor dado del empleado Itaú (grado de
separación del empleado Itaú). El método recibirá un Grafo<Persona>, un empleado y un grado
de separación/distancia y debe retornar una lista de hasta 40 jubilados que no hayan percibido la
jubilación del mes y se encuentre a una distancia menor a recibido como parámetro.

En este grafo simple, donde los empleados del banco están
en color rojo y se desea retornar los jubilados hasta
distancia 2, se debería retornar los jubilados en color negro.
La persona conoce si es empleado o jubilado, el nombre y
el domicilio.
*/

package practica5.ejercicio5;

import java.util.List;
import java.util.LinkedList;
import practica5.ejercicio1.*;
import practica1.ejercicio8.*;

public class BancoItau {
	
	public List<Persona> devolverListaJubilados(Graph<Persona> grafo, Persona empleado, int gradoSeparacion){
		boolean[] marcas = new boolean[grafo.getSize()];
		LinkedList<Persona> lista = new LinkedList<>();
		for(int i=0; i < grafo.getSize(); i++) {
			if(!marcas[i]) {//me aseguro que todos los vertices sean visitados
				devolverListaJubilados(i,grafo,marcas,empleado,gradoSeparacion,lista,40); // recorrido bfs
			}
		}
		return lista;
	}
	
	private void devolverListaJubilados(int i, Graph<Persona> grafo, boolean[] marcas, Persona empleado, int gradoSeparacion, LinkedList<Persona> lista, int maxPersonas) {
		int gradoActual = 0, cantPersonas = 0;
		Queue<Vertex<Persona>> cola = new Queue<>();
		Vertex<Persona> v = grafo.search(empleado), aux = null;
		cola.enqueue(v);
		cola.enqueue(null);
		marcas[i] = true;
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux!=null) {
				if(aux.getData().isJubilado()) {
					if(gradoActual<gradoSeparacion) {
						if(cantPersonas<maxPersonas) {
							lista.add(aux.getData());
							cantPersonas++;
						}
					}
				}
				List<Edge<Persona>> adyacentes = grafo.getEdges(aux); // que pasa si no tiene adyacentes???? no se rompe el codigo??? 
				for(Edge<Persona> e : adyacentes) {
					int j = e.getTarget().getPosition();
					if(!marcas[j]) {
						cola.enqueue(e.getTarget());
						marcas[j] = true;
					}
				}
			}
			else if(!cola.isEmpty()){
				gradoActual++;
				cola.enqueue(null);
			}
		}
	}
	
	//NO ESTA PROBADO PERO LA LOGICA PARECE CORRECTA
}
