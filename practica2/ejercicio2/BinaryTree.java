package practica2.ejercicio2;

import practica1.ejercicio8.*;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		int cont = 0;
		return contarHojas(this,cont);
	}
	
	private int contarHojas(BinaryTree<T> a, int cont) {
		if(a.isLeaf()) {
			return 1;
		}
		if(a.hasLeftChild()) {
			cont += contarHojas(a.getLeftChild(),cont); 
		}
		if(a.hasRightChild()) {
			cont += contarHojas(a.getRightChild(),cont); 
		}
		return cont;
	}
    	 
    public BinaryTree<T> espejo(){
	       		  
 	   return null;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		int nivel = 1;
		BinaryTree<T> aux = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				if((nivel>=n)&&(nivel<=m)) {
					System.out.println(aux.getData().toString());
				}
				if(aux.hasLeftChild()) {
					cola.enqueue(aux.getLeftChild());
				}
				if(aux.hasRightChild()) {
					cola.enqueue(aux.getRightChild());
				}
			}
			else if(!cola.isEmpty()){
				nivel++;
				cola.enqueue(null);
			}
		}
   }
		
}

