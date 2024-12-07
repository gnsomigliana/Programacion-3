/*Implemente en JAVA la clase DoubleEndedQueue de acuerdo con la especificación
dada en el diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.

● enqueueFirst():void Permite encolar al inicio.*/


package practica1.ejercicio8;
import java.util.*;

   public class DoubleEndedQueue<t> extends Queue<t>{
	
	DoubleEndedQueue(){
		super();
	}
	
	public void enqueueFirst(t dato){
		if(isEmpty()){
			System.out.println("ERROR LA COLA ESTA VACIA");
		}
		List<t> aux = getData();
		aux.add(0, dato);
	}
 }	

