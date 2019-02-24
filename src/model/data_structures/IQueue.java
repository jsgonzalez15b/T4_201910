package model.data_structures;

public interface IQueue<T> extends Iterable<T>, Comparable<T>{

	/**
	 * Retorna true si la Cola esta vacia
	 * @return true si la Cola esta vacia, false de lo contrario
	 */
	public boolean isEmpty();
	
	/**
	 * Retorna el numero de elementos contenidos
	 * @return el numero de elemntos contenidos
	 */
	public int size();
	
	/**
	 * Inserta un nuevo elemento en la Cola
	 * @param t el nuevo elemento que se va ha agregar
	 */
	public void enqueue(T t);
	
	/**
	 * Quita y retorna el elemento agregado menos recientemente
	 * @return el elemento agregado menos recientemente
	 */
	public T dequeue();
	
	/**
	 * metodo de comparacion (Comparable<T>) 
	 *@return 1,0,-1 segun la relacion entre los elementos.
	 */
	public int compareTo(T pItem);
	
	public T darElemento(int pos);
	
}
