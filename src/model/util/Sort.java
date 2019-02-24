package model.util;

import model.vo.VOMovingViolation;

public class Sort {
	
	/**
	 * Ordenar datos aplicando el algoritmo ShellSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public static void ordenarShellSort( Comparable[ ] datos ) {
		
		// TODO implementar el algoritmo ShellSort
		int N=datos.length;
		int j=1;
		while(j<N/3) j=3*j+1; 
		while(j>=1) {
			for(int i=j; i<N; i++) {
				for(int k=i;k>=j&&less(datos[k],datos[k-j]);k-=j) {
					exchange(datos,k,k-j);
				}
			}
		}
	}
	
	private static void merge(Comparable[] datos, Comparable[] izq, Comparable[] der) {
		int idizq=0; 
		int idder=0; 
		int idcompl=0;
		while(idizq<izq.length&&idder<der.length) {
			if(less(izq[idizq],der[idder])) {
				datos[idcompl]=izq[idizq];
				idizq++; 
			}else {
				datos[idcompl]=der[idder];
				idder++;
			}
			idcompl++; 
		}
	}
	
	
	
	/**
	 * Ordenar datos aplicando el algoritmo MergeSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public static void ordenarMergeSort( Comparable[ ] datos ) {

		// TODO implementar el algoritmo MergeSort
	
	}

	/**
	 * Ordenar datos aplicando el algoritmo QuickSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public static void ordenarQuickSort( Comparable[ ] datos ) {

		// TODO implementar el algoritmo QuickSort
	}
	
	/**
	 * Comparar 2 objetos usando la comparacion "natural" de su clase
	 * @param v primer objeto de comparacion
	 * @param w segundo objeto de comparacion
	 * @return true si v es menor que w usando el metodo compareTo. false en caso contrario.
	 */
	private static boolean less(Comparable v, Comparable w)
	{
		if(v.compareTo(w)<0) {
			return true; 
		}
		return false; 
	}
	
	/**
	 * Intercambiar los datos de las posicion i y j
	 * @param datos contenedor de datos
	 * @param i posicion del 1er elemento a intercambiar
	 * @param j posicion del 2o elemento a intercambiar
	 */
	private static void exchange( Comparable[] datos, int i, int j)
	{
		// TODO implementar
		Comparable copia=datos[j];
		datos[j]=datos[i];
		datos[i]=copia; 
		}

}
