/*La persona conoce si es empleado o jubilado, el nombre y
el domicilio.*/

package practica5.ejercicio5;

public class Persona {
	private String nombre;
	private String domicilio;
	private boolean jubilado;
	
	public Persona(String nombre, String domicilio, boolean jubilado) {
		this.domicilio = domicilio;
		this.jubilado = jubilado;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public boolean isJubilado() {
		return jubilado;
	}
	public void setJubilado(boolean jubilado) {
		this.jubilado = jubilado;
	}
	
	
}
