package practica3.ejercicio1;

import java.util.List;
import practica1.ejercicio8.*;
import java.util.LinkedList;


public class GeneralTree<T> {

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}

	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}

	public boolean hasChildren() {
		return children != null && !children.isEmpty();
	}

	public boolean isEmpty() {
		return this.data == null && !hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren()) {
			List<GeneralTree<T>> children = this.getChildren();
			if (children.contains(child))
				children.remove(child);
		}
	}

/*a) public int altura(): int devuelve la altura del árbol, es decir, la longitud del camino más largo desde el nodo raíz hasta una hoja.*/
	
	public int altura(){
		if(this != null) {
			return altura(this,1);
		}
		else return 0;
	}
	
	private int altura(GeneralTree<T> a,int cont) {
		GeneralTree<T> aux = null;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(a);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {//encolo los hijos
				if(aux.hasChildren()) {
				List<GeneralTree<T>> children = a.getChildren();
					for(GeneralTree<T> child : children) {
						cola.enqueue(child);
					}
				}
			}
			else if(!cola.isEmpty()){//es null osea estoy en el limite de nivel
				cont++;
				cola.enqueue(null);
			}		
		}
		return cont;
		
	}
	
/*b) public int nivel(T dato) devuelve la profundidad o nivel del dato en el árbol. El nivel de un nodo 
 es la longitud del único camino de la raíz al nodo.*/

	public int nivel(T dato) {
		boolean encontre = false;
		int nivel = 1;
		GeneralTree<T> aux = null;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(aux);
		cola.enqueue(null);
		while(!cola.isEmpty()||(!encontre)) {
			aux = cola.dequeue();
			if(aux != null){
				if(aux.getData() == dato) {
					encontre = true;
				}
				if(aux.hasChildren()) {
					List<GeneralTree<T>> children = aux.getChildren();
					for(GeneralTree<T> child : children) {
						cola.enqueue(child);
					}
				}
			}
			else if((aux == null)&&(!cola.isEmpty())){
				nivel++;
				cola.enqueue(null);
			}
		}
		if(encontre){
			return nivel;
		}
		else return -1;
	}

/*c) public int ancho(): int la amplitud (ancho) de un árbol se define como la cantidad de nodos que
se encuentran en el nivel que posee la mayor cantidad de nodos.*/
	
	public int ancho(){
		int max=0, maxNivel = 0;
		GeneralTree<T> aux = null;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(aux);
		cola.enqueue(null);
		while(!cola.isEmpty()){
			aux = cola.dequeue();
			if(aux != null) {
				maxNivel++;
				if(aux.hasChildren()) {
					List<GeneralTree<T>> children = aux.getChildren();
					for(GeneralTree<T> child : children){
						cola.enqueue(child);
					}
				}
			}
			else if((aux == null)&&(!cola.isEmpty())){
				cola.enqueue(null);
				if(maxNivel>max) {
					max = maxNivel;
				}
				maxNivel = 0;
			}
		}
		if(maxNivel>max) {//pregunto por el ultimo nivel
			max = maxNivel;
		}
		return max;
	}
	
	/*Se dice que un nodo n es ancestro de un nodo m si existe un camino desde n a m. Implemente un
método en la clase GeneralTree con la siguiente firma:
public boolean esAncestro(T a, T b): devuelve true si el valor “a” es ancestro del valor “b”.*/
	
	public GeneralTree<T> buscarNodo(GeneralTree<T> a, T dato) {
		GeneralTree<T> aux = null;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(a);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				if(aux.getData() == dato) {
					return aux;
				}
				if(aux.hasChildren()) {
					List<GeneralTree<T>> children = aux.getChildren();
					for(GeneralTree<T> child : children) {
						cola.enqueue(child);
					}
				}
			}
			else if(!cola.isEmpty()) {
				cola.enqueue(null);
			}
		}
		return null;
	}
	
	public boolean esAncestro(T a, T b){
		//preguntar si el nodo a esta en el arbol
		GeneralTree<T> nodoA = buscarNodo(this,a);

		//recorrer el nodo a y preguntar si alguno de sus hijos es igual a b
		if((nodoA==null)||(nodoA.isEmpty())||(nodoA.isLeaf()||(nodoA.getData() == b))){
			return false;
		}
		GeneralTree<T> aux = null;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(nodoA);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				if(aux.getData()==b) {// si a = b retorna false en el primer if 
					return true;
				}
				if(aux.hasChildren()) {
					List<GeneralTree<T>> children = aux.getChildren();
					for(GeneralTree<T> child : children ) {
						cola.enqueue(child);
					}
				}
			}
			else if(!cola.isEmpty()) {
				cola.enqueue(null);
			}
		}
		return false;
	}
}
 