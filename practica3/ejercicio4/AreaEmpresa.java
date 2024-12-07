/*Donde AreaEmpresa es una clase que representa a un área de la empresa mencionada y que contiene
la identificación de la misma representada con un String y una tardanza de transmisión de mensajes
interna representada con int.*/

package practica3.ejercicio4;

public class AreaEmpresa {
	private String iden;
	private int tardanza;
	
	public AreaEmpresa() {
		
	}
	
	public AreaEmpresa(String iden, int tardanza) {
		this.iden = iden;
		this.tardanza = tardanza;
	}
	
	public String getIden() {
		return iden;
	}
	public void setIden(String iden) {
		this.iden = iden;
	}
	public int getTardanza() {
		return tardanza;
	}
	public void setTardanza(int tardanza) {
		this.tardanza = tardanza;
	}
	
	
}
