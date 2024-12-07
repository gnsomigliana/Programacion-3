/*
  Escriba tres métodos de clase (static) que reciban por parámetro dos números enteros (tipo
int) a y b e impriman todos los números enteros comprendidos entre a; b (inclusive), uno por
cada línea en la salida estándar. Para ello, dentro de una nueva clase escriba un método por
cada uno de los siguientes incisos:
a. Que realice lo pedido con un for.
b. Que realice lo pedido con un while.
c. Que realice lo pedido sin utilizar estructuras de control iterativas (for, while, do
while).
Por último, escriba en el método de clase main el llamado a cada uno de los métodos
creados, con valores de ejemplo. En su computadora, ejecute el programa y verifique
que se cumple con lo pedido.
 
 
 */

/*MAIN*/

package practica1.ejercicio1;

public class Ejercicio1 {
	
	public static void main(String[] args ) {
		int a=1;
		int b=10;
		Modulos.imprimirFor(a, b);
		Modulos.imprimirWhile(a, b);
		Modulos.imprimirRecursivo(a, b);
		System.out.println("Fin del programa");
	}
}
