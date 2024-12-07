/* Implemente en la clase RecorridosAG los siguientes métodos:
public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,
Integer n)
Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
pasados como parámetros, recorrido en preorden.
public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,
Integer n)
Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
pasados como parámetros, recorrido en inorden.
public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,
Integer n)
Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
pasados como parámetros recorrido en postorden.
public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,
Integer n)
Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
pasados como parámetros, recorrido por niveles.
*/


package practica3.ejercicio2;
import practica3.ejercicio1.*;
import practica1.ejercicio8.*;
import java.util.LinkedList;
import java.util.List;

public class RecorridosAG {
	//preorden
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a,Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		return numerosImparesMayoresQuePreOrden(a,lista,n);
	}
	
	private List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a,List<Integer> l,Integer n){
		if((a.getData() % 2 == 1)&&(a.getData() > n)) {
			l.add(a.getData());
		}
		List<GeneralTree<Integer>> children = a.getChildren();
		for(GeneralTree<Integer> child : children) {
			numerosImparesMayoresQuePreOrden(child,l,n);
		}
		return l;
	}
	
	
	//en orden
	public List<Integer> numerosImparesMayoresQueEnOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		return numerosImparesMayoresQueEnOrden(a,lista,n);
	}
	
	private List<Integer> numerosImparesMayoresQueEnOrden(GeneralTree<Integer> a, List<Integer> l, Integer n){
		GeneralTree<Integer> primero;
		List<GeneralTree<Integer>> children = a.getChildren();
		primero = children.get(0);
		numerosImparesMayoresQueEnOrden(primero,l,n);
		if((a.getData() % 2 == 1)&&(a.getData() > n)) {
			l.add(a.getData());
		}
		int i;
		for(i=1;i<children.size()-1;i++) {
			numerosImparesMayoresQueEnOrden(children.get(i),l,n);
		}
		return l;
	}
	
	
	//post orden 
	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree <Integer> a,Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		return numerosImparesMayoresQuePostOrden(a,lista,n);
	}
	
	private List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree <Integer> a,List<Integer> l,Integer n){
		List<GeneralTree<Integer>> children = a.getChildren();
		for(GeneralTree<Integer> child : children) {
			numerosImparesMayoresQuePostOrden(child,l,n);
		}
		if((a.getData() % 2 == 1)&&(a.getData() > n)) {
			l.add(a.getData());
		}
		return l;
	}
	
	//en niveles
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		return numerosImparesMayoresQuePorNiveles(a,lista,n);
	}
	
	private List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, List<Integer> l, Integer n){
		//int nivel = 1; en este ejercicio no es necesario el nivel
		GeneralTree<Integer> aux = null;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(a);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				if((aux.getData()%2 == 1)&&(aux.getData()>n)){
					l.add(aux.getData());
				}
				if(aux.hasChildren()) {
					List<GeneralTree<Integer>> children = aux.getChildren();
					for(GeneralTree<Integer> child : children){
						cola.enqueue(child);
					}
				}
			}
			else if(!cola.isEmpty()){
				//nivel++;
				cola.enqueue(null);
			}
		}
		return l;
	}
}
