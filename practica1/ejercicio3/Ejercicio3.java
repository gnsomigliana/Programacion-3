/*
 Creación de instancias mediante el uso del operador new
a. Cree una clase llamada Estudiante con los atributos especificados abajo y sus
correspondientes métodos getters y setters (haga uso de las facilidades que brinda
eclipse)
● nombre
● apellido
● comision
● email
● direccion
b. Cree una clase llamada Profesor con los atributos especificados abajo y sus
correspondientes métodos getters y setters (haga uso de las facilidades que brinda
eclipse)
● nombre
● apellido
● email
● catedra
● facultad
c. Agregue un método de instancia llamado tusDatos() en la clase Estudiante y en la
clase Profesor, que retorne un String con los datos de los atributos de las mismas.
Para acceder a los valores de los atributos utilice los getters previamente
definidos.
d. Escriba una clase llamada Test con el método main, el cual cree un arreglo con 2
objetos Estudiante, otro arreglo con 3 objetos Profesor, y luego recorra ambos
arreglos imprimiendo los valores obtenidos mediante el método tusDatos(). Recuerde
asignar los valores de los atributos de los objetos Estudiante y Profesor invocando los
respectivos métodos setters.
e. Agregue dos breakpoints, uno en la línea donde itera sobre los estudiantes y otro en la
línea donde itera sobre los profesores
f. Ejecute la clase Test en modo debug y avance paso a paso visualizando si el
estudiante o el profesor recuperado es lo esperado.

 */

package practica1.ejercicio3;

public class Ejercicio3{
	
	public static void main(String[] args){
		Estudiante[] e = new Estudiante[2];
		Profesor[] p = new Profesor[3];
		int i;
		for(i=0;i<2;i++) {
			e[i] = new Estudiante();
			e[i].setNombre("jose");
			e[i].setApellido("perez");
			e[i].setComision('A');
			e[i].setEmail("jp@gmail.com");
			e[i].setDireccion("calle 5 345");
		}
		for(i=0;i<3;i++) {
			p[i] = new Profesor();
			p[i].setNombre("jose");
			p[i].setApellido("perez");
			p[i].setCatedra("B2");
			p[i].setEmail("jp@gmail.com");
			p[i].setFacultad("ingenieria");
		}
		
		for(i=0;i<2;i++) {
			System.out.println(e[i].tusDatos());
		}
		for(i=0;i<3;i++) {
			System.out.println(p[i].tusDatos());
		}
		
		System.out.println("Fin del programa");
		
	}
}