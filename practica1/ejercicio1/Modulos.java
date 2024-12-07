package practica1.ejercicio1;

public class Modulos{
	
	public static void imprimirFor(int a, int b){
		int i;
		if(a<b) {
			for(i=a;i<=b;i++){
				System.out.println(i);
			}
		}
		else System.out.println("El primer numero debe ser menor al segundo");
	}
	
	public static void imprimirWhile(int a, int b){
		int i;
		if(a<b) {
			i=a;
			while(i<=b){
				System.out.println(i);
				i++;
			}
		}
		else System.out.println("El primer numero debe ser menor al segundo");
	}
	
	public static void recursor(int x, int b) {
		if(x<=b){
			System.out.println(x);
			recursor(x+1,b);
		}
	}
	
	public static void imprimirRecursivo(int a, int b){
		int i;
		if(a<b) {
			i=a;
			recursor(i,b);
		}
		else System.out.println("El primer numero debe ser menor al segundo");
	}
	
}