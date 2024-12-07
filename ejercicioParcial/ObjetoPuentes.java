package ejercicioParcial;

import java.util.ArrayList;

public class ObjetoPuentes {
	private ArrayList<String> lista;
	private int cantOpc;
	private int cantImp;
	
	public ObjetoPuentes() {
		this.lista = new ArrayList<>();
		this.cantImp = -1;
		this.cantOpc = 9999;
	}

	public ArrayList<String> getLista() {
		return lista;
	}

	public void setLista(ArrayList<String> lista) {
		this.lista = lista;
	}

	public int getCantOpc() {
		return cantOpc;
	}

	public void setCantOpc(int cantOpc) {
		this.cantOpc = cantOpc;
	}

	public int getCantImp() {
		return cantImp;
	}

	public void setCantImp(int cantImp) {
		this.cantImp = cantImp;
	}

	
	
	
}
