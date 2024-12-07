/*
Una red binaria es una red que posee una topología de árbol binario lleno.
Los nodos que conforman una red binaria llena tiene la particularidad de que todos ellos conocen
cuál es su retardo de reenvío. El retardo de reenvío se define como el período comprendido entre
que un nodo recibe un mensaje y lo reenvía a sus dos hijos.
Su tarea es calcular el mayor retardo posible, en el camino que realiza un mensaje desde la raíz
hasta llegar a las hojas en una red binaria llena. En el ejemplo, debería retornar 10+3+9+12=34
(Si hay más de un máximo retorne el último valor hallado).
Nota: asuma que cada nodo tiene el dato de retardo de reenvío expresado en cantidad de
segundos.
a) Indique qué estrategia (recorrido en profundidad o por niveles) utilizará para resolver el
problema.
b) Cree una clase Java llamada RedBinariaLlena donde implementará lo solicitado en el
método retardoReenvio():int
 */


package practica2.ejercicio4;

import practica2.ejercicio2.*;

public class RedBinariaLlena {
	private BinaryTree<Integer> a;
	
	public RedBinariaLlena(BinaryTree<Integer> a) {
		this.a = a;
	}
	
	public int retardoReenvio() {
		if(this.a == null) {
			return 0;
		}
		return retardoReenvio(a,0);
	}
	//ache si esta  bien, pero la logico parece correcta
	//obs: notar que no hace falta verificar si tiene hijo der o izq ya que es una red binaria llena
	public int retardoReenvio(BinaryTree<Integer> a,int retardo) {
		retardo = retardo + a.getData();
		int rIzq = retardoReenvio(a.getLeftChild(),retardo);
		int rDer = retardoReenvio(a.getRightChild(),retardo);
		return (rIzq>rDer)? rIzq : rDer;
	}
}
