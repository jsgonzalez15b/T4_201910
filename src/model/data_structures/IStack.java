package model.data_structures;

public interface IStack<T> extends Iterable<T>, Comparable<T>{
	
	/**
	 * Retorna true si la Pila esta vacia
	 * @return true si la Pila esta vacia, false de lo contrario
	 */
	public boolean isEmpty();
	
	/**
	 * Retorna el numero de elementos contenidos
	 * @return el numero de elemntos contenidos
	 */
	public int size();
	
	/**
	 * Inserta un nuevo elemento en la Pila
	 * @param t el nuevo elemento que se va ha agregar
	 */
	public void push(T t);
	
	/**
	 * Quita y retorna el elemento agregado más recientemente
	 * @return el elemento agregado más recientemente
	 */
	public T pop();	
	
	/**
	 * metodo de comparacion (Comparable<T>) 
	 *@return 1,0,-1 segun la relacion entre los elementos.
	 */
	public int compareTo(T pItem);
	
}
