/*
a-Escriba una clase llamada TestArrayList cuyo método main recibe una secuencia de
números, los agrega a una lista de tipo ArrayList, y luego de haber agregado todos los
números a la lista, imprime el contenido de la misma iterando sobre cada elemento.*/

/*
 d. Escriba un método que realice las siguientes acciones:
■ cree una lista que contenga 3 estudiantes
■ genere una nueva lista que sea una copia de la lista del inciso i
■ imprima el contenido de la lista original y el contenido de la nueva lista
■ modifique algún dato de los estudiantes
■ vuelva a imprimir el contenido de la lista original y el contenido de la nueva lista.
¿Qué conclusiones obtiene a partir de lo realizado?
■ ¿Cuántas formas de copiar una lista existen? ¿Qué diferencias existen entre
ellas?
La podemos copiar asignando punteros es decir, copia = listaOriginal pero asi cuando modifiquemos una, en realidad modificaremos las dos
Otra forma (la correcta) es agregando cada elemento de la lista original a la copia mediante una iteracion,
esto permite que las listas sean independientes ante las modificaciones
 */
/*
e. A la lista del punto 7d, agregue un nuevo estudiante. Antes de agregar, verifique que el
estudiante no estaba incluido en la lista.

f. Escriba un método que devuelva verdadero o falso si la secuencia almacenada en la
lista es o no capicúa:

 */

package practica1.ejercicio7;

import practica1.ejercicio3.*;
import java.util.*;

public class TestArrayList{
	
	public static void main (String[] args) {
		/*//inciso a
		int[] v = {1,2,3,4,5,6,7,8,9,10};
		List <Integer> lista = new ArrayList<Integer>();
		for(int numero : v) {
			lista.add(numero);
		}
		for(int i : lista) {// uso de for each, una de las formas mas faciles de recorrer una estructura 
			System.out.println(i);
		}
		*/
		/*//inciso d
		List<Estudiante> e = crearLista();
		List<Estudiante> copia = copiarLista(e);
		imprimirLista(e);
		System.out.println("------------------------------------------------------------------");
		imprimirLista(copia);
		System.out.println("------------------------------------------------------------------");
		Estudiante nuevo = new Estudiante("pepe","pepon",'A',"pepo@gmail.com","jamaica 23");
		copia.removeLast();
		copia.add(nuevo);
		imprimirLista(e);
		System.out.println("------------------------------------------------------------------");
		imprimirLista(copia);
		System.out.println("------------------------------------------------------------------");
		Estudiante nueve = new Estudiante("pepe","pepon",'A',"pepo@gmail.com","jamaica 23");
		if(!verificarPresencia(e,nueve)) {
			e.add(nueve);
			System.out.println("Estudiante agregado correctamente");
		}
		else System.out.println("El estudiante ya se encuentra en la lista");*/
		//inciso f
		ArrayList<Integer> capi = new ArrayList<>();
		capi.add(1);
		capi.add(1);
		capi.add(3);
		capi.add(2);
		capi.add(1);
		if(esCapicua(capi)) {
			System.out.println("La lista es capicua");
		}
		else System.out.println("La lista NO es capicua");
	}
	
	public static List<Estudiante> crearLista(){
		Scanner s = new Scanner(System.in);
		List<Estudiante> l = new ArrayList<>();
		Estudiante e = new Estudiante();
		String nombre,apellido,email,direccion;
		char comision;
		int i;
		for(i=0;i<1;i++) {
			System.out.println("Ingrese el nombre del Estudiante " + i);
			nombre = s.nextLine();
			e.setNombre(nombre);
			System.out.println("Ingrese el apellido del Estudiante " + i);
			apellido = s.nextLine();
			e.setApellido(apellido);
			System.out.println("Ingrese el email del Estudiante " + i);
			email = s.nextLine();
			e.setEmail(email);
			System.out.println("Ingrese la direccion del Estudiante " + i);
			direccion = s.nextLine();
			e.setDireccion(direccion);
			System.out.println("Ingrese la comision del Estudiante " + i);
			comision = s.next().charAt(0);
			s.nextLine();
			e.setComision(comision);
			l.add(e);
		}
		s.close();
		return l;
	}
	
	public static List<Estudiante> copiarLista(List<Estudiante> l){
		List<Estudiante> copia = new ArrayList<>();
		// copia = l; SI HACEMOS ESTO, EL PUNTERO APUNTA A LA MISMA LISTA, SI MODIFICAMOS UNA SE MODIFICARAN LAS DOS, ESTA MAL
		for(Estudiante e : l) {
			copia.add(e);
		}
		return copia;
	}
	
	public static void imprimirLista(List<Estudiante> l){
		for(Estudiante e : l) {
			System.out.println(e.tusDatos());
		}
	}
	
	public static boolean verificarPresencia(List<Estudiante> l, Estudiante buscar) {
		for(Estudiante e : l){
			if(e.equals(buscar))
				return true;
		}
		return false;
	}
	
	public static boolean esCapicua(ArrayList<Integer> lista) {
		int ini = 0, fin = lista.size()-1;
		while(ini<fin) {
			if(!(lista.get(ini).equals(lista.get(fin)))) {
				return false;
			}
			ini++;
			fin--;
		}
		return true;
	}
}

/*
b-Si en lugar de usar un ArrayList en el inciso anterior hubiera usado un LinkedList ¿Qué
diferencia encuentra respecto de la implementación? Justifique

Si el programa se centra principalmente en agregar elementos al final de la lista y luego iterar sobre ellos, 
tanto ArrayList como LinkedList funcionarían bien, sin embargo el uso de memoria y tiempo de ejecucion se verian afectados
 */

/*
c. ¿Existen otras alternativas para recorrer los elementos de la lista del punto 7a.?

Podemos recorrer los elementos de la lista con un for comun o un while pero la mejor forma para recorrer estas estructuras es con for each
 */
