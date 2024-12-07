package Ejercicio1Parcial;

import java.util.List;

public class Resultado {
	private List<Integer> l;
	private int cant;
	
	public Resultado() {
		
	}
	
	public Resultado(List<Integer> l, int cant ) {
		this.l = l;
		this.cant = cant;
	}

	public List<Integer> getL() {
		return l;
	}

	public void setL(List<Integer> l) {
		this.l = l;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}
	
	
}
