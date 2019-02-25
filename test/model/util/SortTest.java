package model.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.util.Sort;

public class SortTest
{
	// -----------------------------------------------------------------
   	 // Atributos
   	 // -----------------------------------------------------------------

    	/**
    	 * Queue para probar enqueue
    	 */
    	private Queue<VOMovingViolations> enqueuer;

    	/**
    	 * Queue para probar dequeue
    	 */
    	private Queue<VOMovingViolations> dequeuer;

   	 /**
     	 * Queue para eliminar 1 nodo
    	 */
    	private Queue<VOMovingViolations> dequeuer1;
    
    	/**
     	* Elemento 1
     	*/
    	private VOMovingViolations pInfraccion1;

    	/**
     	* Elemento 2
     	*/
    	private VOMovingViolations pInfraccion2;

    	/**
     	* Elemento 3
     	*/
    	private VOMovingViolations pInfraccion3;
    
    	/**
     	* Elemento 4
     	*/
    	private VOMovingViolations pInfraccion4;
	
	/**
     	* Elemento 5 
     	*/
    	private VOMovingViolations pInfraccion5;
	
	/**
     	* Elemento 6 
     	*/
    	private VOMovingViolations pInfraccion6;
	
	/**
     	* Elemento 7 
     	*/
    	private VOMovingViolations pInfraccion7;
	
	/**
     	* Elemento 8 
     	*/
    	private VOMovingViolations pInfraccion8;

	/**
     	* Muestra de datos a ordenar
     	*/
	private Comparable[] datos;
    
    // -----------------------------------------------------------------
    // MÃ©todos
    // -----------------------------------------------------------------

   
	@Before
	public void setUp() throws Exception
	{
		System.out.println("Codigo de configuracion de muestra de datos a probar");
		
		//Inicializacion de datos
		datos = new Comparable[5];
		
		//InicializaciÃ³n de elementos y enqueue
		System.out.println("Codigo de iniciacion");
		pInfraccion1 = new VOMovingViolations(1, "Bogota", "2018-02-13", 0, "123000", "Licence", "0001", 1453.2);
		pInfraccion2 = new VOMovingViolations(2, "Bogota", "2018-02-15", 0, "123001", "Drunk", "0002", 1450.2);
		pInfraccion3 = new VOMovingViolations(3, "Bogota", "2018-02-17", 0, "123002", "Asshole", "9999", 1451.2);
		pInfraccion4 = new VOMovingViolations(4, "Bogota", "2018-02-23", 0, "123003", "Speed", "0007", 1451.2);
		pInfraccion5 = new VOMovingViolations(5, "Bogota", "2018-02-23", 0, "123004", "RedLight", "0010", 1455.2);
		pInfraccion6 = new VOMovingViolations(6, "Bogota", "2018-02-23", 0, "123005", "Cellphone", "0100", 1432.2);
		pInfraccion7 = new VOMovingViolations(7, "Bogota", "2018-02-25", 0, "123006", "RedLight", "0010", 1423.2);
		pInfraccion8 = new VOMovingViolations(8, "Bogota", "2018-02-26", 0, "123007", "Glasses", "0083", 1550.2);
		
		//inicializo el arreglo desordenado de la siguiente forma
		datos [3] = pInfraccion1;
		datos [2] = pInfraccion2;
		datos [4] = pInfraccion3;
		datos [1] = pInfraccion4;
		datos [5] = pInfraccion5;
	}
	
	@Test
	public void testQuickSort() 
	{
		//en caso de que no se haya inicializado @before llamo al setUp
		if(datos==null)
		{
			try 
			{
				setUp();
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		//Primera  prueba de ordenarQuickSort()
		ordenarQuickSort(datos);
		assertEquals( "El primero no es el elemento para el orden esperado", "2018-02-13" , datos[1].getTicketIssueDate() );
		assertEquals( "El segundo no es el elemento para el orden esperado", "2018-02-15" , datos[2].getTicketIssueDate() );
		assertEquals( "El tercero no es el elemento para el orden esperado", "2018-02-17" , datos[3].getTicketIssueDate() );
		
		//pruebas de ordenarQuickSort y misma fecha para compareTo()
		assertEquals( "El cuarto no es el esperado, compareTo podría estar mal", 4, datos[4].objectId() );
		assertEquals( "El quinto no es el esperado para el ordenamiento, compareTo() funciona sin embargo", 5 , datos[5].objectId() );
		
		//inicializo el arreglo desordenado nuevamente para probar el metodo nuevamente
		datos [3] = pInfraccion1;
		datos [2] = pInfraccion2;
		datos [4] = pInfraccion5;
		datos [1] = pInfraccion7;
		datos [5] = pInfraccion8;
		
		//Segunda  prueba de ordenarQuickSort()
		ordenarQuickSort(datos);
		assertEquals( "El primero no es el elemento para el orden esperado", "2018-02-13" , datos[1].getTicketIssueDate() );
		assertEquals( "El segundo no es el elemento para el orden esperado", "2018-02-15" , datos[2].getTicketIssueDate() );
		assertEquals( "El tercero no es el elemento para el orden esperado", "2018-02-23" , datos[3].getTicketIssueDate() );
		assertEquals( "El cuarto no es el esperado para el orden esperado", "2018-02-25", datos[4].getTicketIssueDate() );
		assertEquals( "El quinto no es el esperado para el ordenamiento", "2018-02-26" , datos[5].getTicketIssueDate() );
	}
	
	@Test
	public void testShellSort() 
	{
		//Inicializo en los mismo valores del primer intento
		datos [3] = pInfraccion1;
		datos [2] = pInfraccion2;
		datos [4] = pInfraccion3;
		datos [1] = pInfraccion4;
		datos [5] = pInfraccion5;
		//Primera  prueba de ordenarShellSort()
		ordenarShellSort(datos);
		assertEquals( "El primero no es el elemento para el orden esperado", "2018-02-13" , datos[1].getTicketIssueDate() );
		assertEquals( "El segundo no es el elemento para el orden esperado", "2018-02-15" , datos[2].getTicketIssueDate() );
		assertEquals( "El tercero no es el elemento para el orden esperado", "2018-02-17" , datos[3].getTicketIssueDate() );
		
		//pruebas de ordenarQuickSort y misma fecha para compareTo()
		assertEquals( "El cuarto no es el esperado, compareTo podría estar mal", 4, datos[4].objectId() );
		assertEquals( "El quinto no es el esperado para el ordenamiento, compareTo() funciona sin embargo", 5 , datos[5].objectId() );
		
		//inicializo el arreglo desordenado nuevamente para probar el metodo nuevamente
		datos [3] = pInfraccion1;
		datos [2] = pInfraccion4;
		datos [4] = pInfraccion6;
		datos [1] = pInfraccion7;
		datos [5] = pInfraccion8;
		
		//Segunda  prueba de ordenarQuickSort()
		ordenarQuickSort(datos);
		assertEquals( "El primero no es el elemento para el orden esperado", "2018-02-13" , datos[1].getTicketIssueDate() );
		assertEquals( "El segundo no es el elemento para el orden esperado", "2018-02-23" , datos[2].getTicketIssueDate() );
		assertEquals( "El tercero no es el elemento para el orden esperado", "2018-02-23" , datos[3].getTicketIssueDate() );
		assertEquals( "El cuarto no es el esperado para el orden esperado", "2018-02-25", datos[4].getTicketIssueDate() );
		assertEquals( "El quinto no es el esperado para el ordenamiento", "2018-02-26" , datos[5].getTicketIssueDate() );
	}
	
	@Test
	public void testMergeSort() 
	{
		//Inicializo en los mismo valores del primer intento
		datos [3] = pInfraccion1;
		datos [2] = pInfraccion2;
		datos [4] = pInfraccion3;
		datos [1] = pInfraccion4;
		datos [5] = pInfraccion5;
		//Primera  prueba de ordenarMergeSort()
		ordenarMergeSort(datos);
		assertEquals( "El primero no es el elemento para el orden esperado", "2018-02-13" , datos[1].getTicketIssueDate() );
		assertEquals( "El segundo no es el elemento para el orden esperado", "2018-02-15" , datos[2].getTicketIssueDate() );
		assertEquals( "El tercero no es el elemento para el orden esperado", "2018-02-17" , datos[3].getTicketIssueDate() );
		
		//pruebas de ordenarMergeSort() y misma fecha para compareTo()
		assertEquals( "El cuarto no es el esperado, compareTo podría estar mal", 4, datos[4].objectId() );
		assertEquals( "El quinto no es el esperado para el ordenamiento, compareTo() funciona sin embargo", 5 , datos[5].objectId() );
		
		//inicializo el arreglo desordenado nuevamente para probar el metodo nuevamente
		datos [3] = pInfraccion1;
		datos [2] = pInfraccion3;
		datos [4] = pInfraccion5;
		datos [1] = pInfraccion6;
		datos [5] = pInfraccion8;
		
		//Segunda  prueba de ordenarMergeSort()
		ordenarMergeSort(datos);
		assertEquals( "El primero no es el elemento para el orden esperado", "2018-02-13" , datos[1].getTicketIssueDate() );
		assertEquals( "El segundo no es el elemento para el orden esperado", "2018-02-17" , datos[2].getTicketIssueDate() );
		assertEquals( "El tercero no es el elemento para el orden esperado", "2018-02-23" , datos[3].getTicketIssueDate() );
		assertEquals( "El cuarto no es el esperado para el orden esperado", "2018-02-23", datos[4].getTicketIssueDate() );
		assertEquals( "El quinto no es el esperado para el ordenamiento", "2018-02-26" , datos[5].getTicketIssueDate() );
	}
}
