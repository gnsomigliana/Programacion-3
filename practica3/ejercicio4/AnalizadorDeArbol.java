/*Se debe devolver el mayor promedio entre todos los valores promedios de los niveles.
Para el ejemplo presentado, el promedio del nivel 0 es 14, el del nivel 1 es 16 y el del nivel 2 es 10. Por
lo tanto, debe devolver 16.
a) Indique y justifique qué tipo de recorrido utilizará para resolver el problema.

Voy a utilizar un recorrido por niveles ya que me pide devolver el mayor promedio de entre todos los niveles

b) Implementar en una clase AnalizadorArbol, el método con la siguiente firma:
public int devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol)
*/

package practica3.ejercicio4;
import practica3.ejercicio1.*;
import practica1.ejercicio8.*;
import java.util.List;

public class AnalizadorDeArbol {
	
	public int devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		int maxProm = 0, prom = 0, elem = 0;
		GeneralTree<AreaEmpresa> aux = null;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				prom += aux.getData().getTardanza();
				elem++; 
				if(aux.hasChildren()) {
					List<GeneralTree<AreaEmpresa>> children = aux.getChildren();
					for(GeneralTree<AreaEmpresa> child : children) {
						cola.enqueue(child);
					}
				}
			}
			else if((aux == null)&&(!cola.isEmpty())) {
				prom = prom / elem;
				if(prom>maxProm) {
					maxProm = prom;
				}
				cola.enqueue(null);
				prom = 0;
				elem = 0;
				
			}	
		}
		prom = prom / elem; //proceso ultimo nivel
		if(prom>maxProm) {
			maxProm = prom;
		}
		return maxProm;
	}
	
}
