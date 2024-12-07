/*. Implemente en JAVA las clase CircularQueue de acuerdo con la especificación dada en
el diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.
● shift(): T Permite rotar los elementos, haciéndolo circular. Retorna el elemento
encolado.
*/


package practica1.ejercicio8;

public class CircularQueue<t> extends Queue<t> {
	
	CircularQueue(){
		super();
	}
	
	public t shift(){
		if(isEmpty()) {
			System.out.println("ERROR LA COLA ESTA VACIA");
			return null;
		}
		t elem = dequeue();
		enqueue(elem);
		return elem;
	}
}
