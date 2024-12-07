package practica5.ejercicio3;

import java.util.ArrayList;

public class CaminoMin {
	private ArrayList<String> listaMin;
	private int distanciaMin;
	
	public CaminoMin() {
		this.listaMin = new ArrayList<String>();
		distanciaMin = 0;
	}

	public ArrayList<String> getListaMin() {
		return listaMin;
	}

	public void setListaMin(ArrayList<String> listaMin) {
		this.listaMin = listaMin;
	}

	public int getDistanciaMin() {
		return distanciaMin;
	}

	public void setDistanciaMin(int distanciaMin) {
		this.distanciaMin = distanciaMin;
	}
	
	
}
