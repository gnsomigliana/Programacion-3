/*Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() que
devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
árbol (divisibles por 2).
a) Implemente el método realizando un recorrido InOrden.
b) Implemente el método realizando un recorrido PostOrden.
 */

package practica2.ejercicio3;

import practica2.ejercicio2.*;

import java.util.ArrayList;
import java.util.List;

public class ContadorArbol {
	private BinaryTree<Integer> a;
	
	public ContadorArbol(BinaryTree<Integer> ar) {
		this.a = ar;
	}
	
	public List<Integer> numerosParesInOrden(){//utilizamos la sobrecarga de metodos, usamos dos metodos de igual nombre pero con diferentes parametros, el compilador detecta esto y actua en base a lo pedido
		List<Integer> lista = new ArrayList<>();
		numerosParesInOrden(this.a, lista);
		return lista;
		
	}
	
	public void numerosParesInOrden(BinaryTree<Integer> nodo, List <Integer> l){
		if(nodo == null) {
			return ;
		}
		if(nodo.hasLeftChild()) {
			numerosParesInOrden(nodo.getLeftChild(),l);
		}
		if(nodo.getData() % 2 == 0) {
			l.add(nodo.getData());
		}
		if(nodo.hasRightChild()) {
			numerosParesInOrden(nodo.getRightChild(),l);
		}
		
	}
	
	public List<Integer> numerosParesPostOrden(){
		List<Integer> lista = new ArrayList<>();
		numerosParesPostOrden(this.a, lista);
		return lista;
		
	}
	
	public void numerosParesPostOrden(BinaryTree<Integer> nodo, List <Integer> l){
		if(nodo == null) {
			return ;
		}
		if(nodo.hasLeftChild()) {
			numerosParesPostOrden(nodo.getLeftChild(),l);
		}
		if(nodo.hasRightChild()) {
			numerosParesPostOrden(nodo.getRightChild(),l);
		}
		if(nodo.getData() % 2 == 0) {
			l.add(nodo.getData());
		}
	}
}
