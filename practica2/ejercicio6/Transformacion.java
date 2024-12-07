/*Cree una clase Java llamada Transformacion que tenga como variable de instancia un árbol
binario de números enteros y un método de instancia suma (): BinaryTree<Integer> el cuál
devuelve el árbol en el que se reemplazó el valor de cada nodo por la suma de todos los
elementos presentes en su subárbol izquierdo y derecho. Asuma que los valores de los subárboles
vacíos son ceros*/

package practica2.ejercicio6;

import practica2.ejercicio2.*;

public class Transformacion {
	private BinaryTree<Integer> a;

	public Transformacion(BinaryTree<Integer> a) {
		this.a = a;
	}

	public BinaryTree<Integer> getA() {
		return a;
	}

	public void setA(BinaryTree<Integer> a) {
		this.a = a;
	}
	
	//lo estoy pensando bien????? se ve bastante mal, no encuentro la logica
	public BinaryTree<Integer> suma(){
		BinaryTree<Integer> copia = new BinaryTree<Integer>();
		
		return copia;
	}
	//vamos a necesitar un arbol de copia para ir guardando los resultados
	private BinaryTree<Integer> suma(BinaryTree<Integer> original, BinaryTree<Integer> copia){
		int suma = 0;
		if(a.hasLeftChild()) {
			suma += a.getLeftChild().getData();
		}
		if(a.hasRightChild()) {
			suma += a.getRightChild().getData();
		} 
		aux.setData(suma);
		return aux;
	}
	
	
}
