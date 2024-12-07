/*Se necesita generar una permutación random de los n primeros números enteros. Por ejemplo
[4,3,1,0,2] es una permutación legal, pero [0,4,1,2,4] no lo es, porque un número está duplicado
(el 4) y otro no está (el 3). Presentamos tres algoritmos para solucionar este problema. Asumimos
la existencia de un generador de números random, ran_int (i,j) el cual genera en tiempo constante,
enteros entre i y j inclusive con igual probabilidad (esto significa que puede retornar el mismo valor
más de una vez). También suponemos el mensaje swap() que intercambia dos datos entre sí.

a. Analizar si todos los algoritmos terminan o alguno puede quedar en loop infinito.
Ninguno puede terminar con un loop infinito...NO ESTOY SEGURO porque a mayor n pasan cosas raras

b. Describa con palabras la cantidad de operaciones que realizan.
Me concentro en los bucles dejando de lado las operaciones constantes
Primer metodo: es el que mas operaciones realiza ya que cuenta con un for anidado a un while(en el peor caso puede ser de orden n)
que tiene anidado un for osea que tenemos un algoritmo de orden O(n^3) 
Segundo metodo: es el segundo algoritmo mas eficiente ya que implementa un for anidado a un while, dando un algoritmo de orden O(n^2)
Tercer metodo: es el metodo mas eficiente ya que implementa dos for que no estan anidados dando como resultado un algoritmo de orden lineal O(n)

*/

package practica4.ejercicio5;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio4 {
	private static Random rand = new Random();
	public static int[] randomUno(int n) {
		int i, x = 0, k;
		int[] a = new int[n];
		for (i = 0; i < n; i++) {
			boolean seguirBuscando = true;
			while (seguirBuscando) {
				x = ran_int(0, n - 1);
				seguirBuscando = false;
				for (k = 0; k < i && !seguirBuscando; k++)
					if (x == a[k])
						seguirBuscando = true;
			}
			a[i] = x;
		}
		return a;
	}
	public static int[] randomDos(int n) {
		int i, x;
		int[] a = new int[n];
		boolean[] used = new boolean[n];
		for (i = 0; i < n; i++) used[i] = false;
		for (i = 0; i < n; i++) {
			x = ran_int(0, n - 1);
			while (used[x]) x = ran_int(0, n - 1);
			a[i] = x;
			used[x] = true;
		}
		return a;
	}

	public static int[] randomTres(int n) {
		int i;
		int[] a = new int[n];
		for (i = 0; i < n; i++) a[i] = i;
		for (i = 1; i < n; i++) swap(a, i, ran_int(0, i - 1));
		return a;
	}
	private static void swap(int[] a, int i, int j) {
		int aux;
		aux = a[i]; a[i] = a[j]; a[j] = aux;
	}
/** Genera en tiempo constante, enteros entre i y j con igual probabilidad.
*/
	private static int ran_int(int a, int b) {
		if (b < a || a < 0 || b < 0) throw new IllegalArgumentException("Parametros invalidos");
		return a + (rand.nextInt(b - a + 1));
	}
	
	public static void main(String[] args) {
		System.out.println("metodo1");
		System.out.println(Arrays.toString(randomUno(100000)));
		System.out.println("metodo2");
		System.out.println(Arrays.toString(randomDos(100000)));
		System.out.println("metodo3");
		System.out.println(Arrays.toString(randomTres(100000)));
	}
}