package Ejercicio1Parcial;

import practica2.ejercicio2.*;

public class ProcesadorDeArbol {
	private BinaryTree<Integer> a;
	
	public Resultado procesar() {
		Resultado r = new Resultado();
		procesar(this.a,r);
		return r;
	}
	
	private void procesar(BinaryTree<Integer> a, Resultado res) {
		if(a.hasLeftChild()) {
			procesar();
		}
		if(a.hasRightChild()) {
			procesar();
		}
		if(a.getData()%2 == 1) {//es impar
			int aux = res.getCant();
			aux++;
			res.setCant(aux);
			if((!a.hasLeftChild()&& a.hasRightChild())||(a.hasLeftChild()&&!a.hasRightChild())) {//tiene un solo hijo
				res.getL().add(a.getData());
			}
		}
		
	}
}
