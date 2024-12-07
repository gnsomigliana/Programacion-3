/*Implemente una clase Java llamada ProfundidadDeArbolBinario que tiene como variable de
instancia un árbol binario de números enteros y un método de instancia
sumaElementosProfundidad (int p):int el cuál devuelve la suma de todos los nodos del árbol
que se encuentren a la profundidad pasada como argumento.
*/

package practica2.ejercicio5;

import practica2.ejercicio2.*;
import practica1.ejercicio8.*;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> a;
	
	public ProfundidadDeArbolBinario() {
		
	}
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> a){
		this.a = a;
	}

	public BinaryTree<Integer> getA() {
		return a;
	}

	public void setA(BinaryTree<Integer> a) {
		this.a = a;
	}
	
	//implemento un recorrido por niveles en el que sumo los elementos del nivel pasado por parametro
	public int sumaElementosProfundidad(int p) {
		int nivel = 1, cont = 0;
		BinaryTree<Integer> aux = null;
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		cola.enqueue(a);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux!= null) {
				if(nivel == p) {
					cont += aux.getData();
				}
				if(aux.hasLeftChild()) {
					cola.enqueue(aux.getLeftChild());
				}
				if(aux.hasRightChild()) {
					cola.enqueue(aux.getRightChild());
				}
			}
			else if(!cola.isEmpty()) {
				nivel++;
				cola.enqueue(null);
			}
		}
		return cont;
	}
}
 