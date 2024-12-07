/*Dada una clase Caminos que contiene una variable de instancia de tipo GeneralTree de números
enteros, implemente un método que retorne el camino a la hoja más lejana. En el caso de haber más
de un camino máximo retorne el primero que encuentre.
El método debe tener la siguiente firma: public List<Integer> caminoAHojaMasLejana ()
Por ejemplo, para el siguiente árbol, la lista a retornar seria: 12, 17, 6, 1 de longitud 3*/

package practica3.ejercicio7;

import practica3.ejercicio1.*;
import java.util.List;
import java.util.LinkedList;

public class Caminos {
	private GeneralTree<Integer> a;

	public Caminos(GeneralTree<Integer> a) {
		this.a = a;
	}
	
	public GeneralTree<Integer> getA() {
		return a;
	}

	public void setA(GeneralTree<Integer> a) {
		this.a = a;
	}


	public List<Integer> caminoAHojaMasLejana(){
		List<Integer> lista = new LinkedList<Integer>();
		List<Integer> aux = new LinkedList<Integer>();
		return caminoAHojaMasLejana(this.a,lista,aux);
	}
	
	// a chequear si esta bien pero la logica parece correcta
	private List<Integer> caminoAHojaMasLejana(GeneralTree<Integer> arbol,List<Integer> l,List<Integer> aux){
		aux.add(arbol.getData());
		if(arbol.isLeaf()) {//si es una hoja comparo con la lista maxima(caso base)
			if(aux.size()>l.size()) {//el camino actual es mas grande que el maximo
				l.clear();
				l.addAll(aux);
			}
		}
		else {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for(GeneralTree<Integer> child : children) {
				caminoAHojaMasLejana(child,l,aux);
			}
		}
		return l;
	}
	
	
}
