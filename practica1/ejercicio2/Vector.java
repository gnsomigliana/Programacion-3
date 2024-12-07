package practica1.ejercicio2;

public class Vector{
	
	public static int[] crearVectorMultiplos(int n) {
		int[] v = new int[n];
		int i,k=1;
		for (i=0;i<n;i++){
			v[i] = k*n;
			k++;
		}
		return v;
	}
}