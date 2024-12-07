package practica1.ejercicio3;
//● nombre● apellido● comision● email● direccion
public class Estudiante{
	private String nombre;
	private String apellido;
	private char comision;
	private String email;
	private String direccion;
	
	public Estudiante(){
		
	}
	
	public Estudiante(String nombre,String apellido,char comision,String email,String direccion){
		this.nombre = nombre;
		this.apellido = apellido;
		this.comision = comision;
		this.email = email;
		this.direccion = direccion;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getApellido(){
		return this.apellido;
	}
	
	public char getComision(){
		return this.comision;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getDireccion(){
		return this.direccion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setComision(char comision) {
		this.comision = comision;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String tusDatos(){
		String datos;
		datos = "nombre: " + getNombre();
		datos += " apellido: " + getApellido();
		datos += " comision: " + getComision();
		datos += " email: " + getEmail();
		datos += " direccion: " + getDireccion();
		return datos;
	}
}
