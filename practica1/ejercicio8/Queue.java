package practica1.ejercicio8;

/*
 a- Implemente en JAVA la clase Queue de acuerdo con la especificación dada en el
diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.
● Queue() Constructor de la clase
● enqueue(dato: T): Inserta el elemento al final de la cola
● dequeue():T Elimina el elemento del frente de la cola y lo retorna. Si la cola
está vacía se produce un error.
● head(): T Retorna el elemento del frente de la cola. Si la cola está vacía se
produce un error.
● isEmpty(): boolean Retorna verdadero si la cola no tiene elementos y falso en
caso contrario
● size():int Retorna la cantidad de elementos de la cola.
● toString(): String Retorna los elementos de la cola en un String*/

//para que funcionen las listas y las parametrizaciones (<t>), debemos poner el parametro en cada lado que nos crea posibleXXXXX 

import java.util.*;

public class Queue<t> extends Sequence<t> {
	
	private List<t> data;
	
	public Queue(){
		this.data = new ArrayList<>();
	}
	
	public void enqueue(t dato){
		this.data.add(dato);
	}
	
	public t dequeue(){
		if(!isEmpty()) {
			t aux = this.data.get(0);
			this.data.remove(0);
			return aux;	
		}
		else {
			System.out.println("ERROR, LA PILA ESTA VACIA");
			return null;
		}
	}
	
	public t head(){
		if(!isEmpty()) {
			return this.data.get(0);	
		}
		else {
			System.out.println("ERROR, LA PILA ESTA VACIA");
			return null;
		}
	}
	
	public boolean isEmpty() {
		return this.data.isEmpty();
	}
	
	public int size() {
		return this.data.size();
	}
	
	@Override
	public String toString() {
		String s = "";
		for(t elem : this.data) {
			s += elem.toString() + " ";
		}
		return s;
	}
	
	public List<t> getData(){
		return this.data;
	}
	
	
}