package model.util;

import model.vo.VOMovingViolation;

public class Sort {

	/**
	 * Ordenar datos aplicando el algoritmo ShellSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public static void ordenarShellSort( Comparable[ ] datos ) {

		// TODO implementar el algoritmo ShellSort
		long startTime = System.currentTimeMillis();
		int N=datos.length;
		int j=1;
		while(j<N/3) j=3*j+1; 
		while(j>=1) {
			for(int i=j; i<N; i++) {
				for(int k=i;k>=j&&less(datos[k],datos[k-j]);k-=j) {
					exchange(datos,k,k-j);
				}
			}
		j=j/3;
		}
		long endTime = System.currentTimeMillis() - startTime;
		System.out.println(endTime+"");
	}



	private static void merge(Comparable[] datos, int l, int m, int r) {
		int j; 
		int i; 
		int n1=m-l+1;
		int n2=r-m;
		Comparable[] izquierdo=new Comparable[n1];
		Comparable[] derecho=new Comparable[n2];
		for(i=0;i<n1;i++) {
			izquierdo[i]=datos[l+i];
		}
		for(j=0; j<n2;j++) {
			derecho[j]=datos[m+1+j];
		}
		i=0; 
		j=0;
		int k =l;
		while(i<n1&&j<n2) {
			if(less(izquierdo[i], derecho[j])) {
				datos[k]=izquierdo[i];
				i++;
			}else {
				datos[k]=derecho[j];
				j++;
			}
		k++;
		}
		while(i<n1) {
			datos[k]=izquierdo[i];
			i++;
			k++;
		}
		while(i<n2) {
			datos[k]=derecho[j];
			j++;
			k++;
		}
		
	}
	
	public static void mergeSort(Comparable[]datos, int izq, int der) {
		if(izq<der) {
			int m=izq+(der-izq)/2;
			mergeSort(datos,izq,m);
			mergeSort(datos, m+1, der);
			merge(datos, izq, m, der);
		}
	}



	/**
	 * Ordenar datos aplicando el algoritmo MergeSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public static void ordenarMergeSort( Comparable[ ] datos ) {

		// TODO implementar el algoritmo MergeSort
		long startTime = System.currentTimeMillis();
		mergeSort(datos, 0, datos.length-1);
		long endTime = System.currentTimeMillis() - startTime;
		System.out.println(endTime+"");

	}

	
	/**
	 * Ordenar datos respecto a un pivote recibido por parametro en un arreglo
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 * @param inicio - indice que indica el inicio del ordenamiento por pivote
	 * @param final - indice que indica el final del ordenamiento por pivote
	 */
	public static void QuickSort( Comparable[ ] datos, int inicio, int fin)
	{
		// TODO 
		//se escoge como pivote el primer termino
		Comparable pivote = datos[inicio];
		int primermayor = inicio;
		if(inicio<fin&&inicio<datos.length)
		{
			for(int i=inicio +1; i<fin; i++) //ordena los elementos empezando por el segundo de la lista
			{
				if(less(datos[i],pivote)) 
				{
					//si el elemento en la posicion i es menor al pivote se intercambio con el indice del primer elemento mayor al pivote
					exchange(datos, i, primermayor);
					primermayor++;
				}
			}
			//se repite recursivamente el metodo
			QuickSort(datos,inicio, primermayor);
			QuickSort(datos,primermayor+1,fin);
		}
	}
	
	
	
	
	/**
	 * Ordenar datos aplicando el algoritmo QuickSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public static void ordenarQuickSort( Comparable[ ] datos )
	{
		// TODO 
		// Ejecuto Quick Sort y ordeno recursivamente las secciones restantes
		int inicio = 0;//indice que indica el inicio del ordenamiento por pivote
		int fin = datos.length; //indice que indica el final del ordenamiento por pivote
		Comparable pivote = datos[inicio]; //escogo el pivote como el primer termino del arreglo
		int primermayor = inicio;
		if( inicio != fin)
		{
			//primer ordenamiento
			for(int i=inicio +1; i<fin; i++) //ordena los elementos con respecto al pivote empezando por el segundo de la lista
			{
				if(less(datos[i], pivote)) 
				{
					//si el elemento en la posicion i es menor al pivote se intercambio con el indice del primer elemento mayor al pivote
					exchange(datos, i, primermayor);
					primermayor++;
				}
			}
			//ordenamientos sucesivos
			QuickSort (datos, inicio, primermayor);
			QuickSort (datos, primermayor+1, fin);
		}
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
