package TPs.Tp1;

import api.*;
import implement.listas.*;
import librerias.Utilidades;
import implement.arreglos.*;
import java.util.Scanner;
@SuppressWarnings("unused")

public class TP1 {
	public static void main(String[] args) {
		
		Utilidades tp1= new Utilidades();	
	
		int seleccion=0;
		Scanner input = new Scanner(System.in);

      
  		PilaTDA a= new PilaTF();
  		PilaTDA b= new PilaTF();
		
  		
  		ColaTDA colaa= new ColaPU();
  		ColaTDA colab= new ColaPU();
  		
  		
		ColaTDA C1= new ColaPU();
		ColaTDA C2= new ColaPU();
		
      while(seleccion!=99)
      {

	      System.out.println("-------------------------\n");
	      System.out.println("Trabajo Practico Nº1");
	      System.out.println("Elija el ejercicio");
	      System.out.println("-------------------------\n");
	      System.out.println("1 - Ejercicio 2 A");
	      System.out.println("2 - Ejercicio 2 B");
	      System.out.println("3 - Ejercicio 2 C");
	      System.out.println("4 - Ejercicio 2 D");
	      System.out.println("5 - Ejercicio 2 E");
	      System.out.println("6 - Ejercicio 2 F");
	      System.out.println("7 - Ejercicio 4 A");
	      System.out.println("8 - Ejercicio 4 B");
	      System.out.println("9 - Ejercicio 4 C");
	      System.out.println("10 - Ejercicio 4 D");
	      System.out.println("11 - Ejercicio 4 E");
	      System.out.println("12 - Ejercicio 4 F");
	      System.out.println("99 - Salir");
	
	      seleccion = input.nextInt();
	      
	      
	      System.out.println("-------------------------\n");
	      switch (seleccion) {
	      	case 1:
	      		a.InicializarPila();
	      		b.InicializarPila();
	      		
	      		a.Apilar(1);
	      		a.Apilar(2);
	      		a.Apilar(3);
	      		
	      		System.out.println("Elementos viejos:");
	      		tp1.ImprimirPila(a);
	      		
	      		
	      		tp1.PasarPila(a, b);
	      		System.out.println("Elementos nuevos:");
	      		tp1.ImprimirPila(b);
	      		
	    		break;
	    	case 2:
	    		a.InicializarPila();
	    		b.InicializarPila();
	    		
	    		a.Apilar(1);
	    		a.Apilar(2);
	    		a.Apilar(3);
	    		

	    		
	    		System.out.println("Elementos viejos:");
	    		tp1.ImprimirPila(a);
	    		
	    		
	    		tp1.CopiarPila(a, b);
	    		System.out.println("Elementos nuevos:");
	    		tp1.ImprimirPila(b);
	    		break;
	    	case 3:
	    		a.InicializarPila();
	    		
	    		a.Apilar(1);
	    		a.Apilar(2);
	    		a.Apilar(3);
	    		

	    		
	    		System.out.println("Elementos viejos:");
	    		tp1.ImprimirPila(a);
	    		
	    		tp1.InvertirPila(a);
	    		
	    		System.out.println("Elementos nuevos:");
	    		tp1.ImprimirPila(a);
	    		break;
	      
	    	case 4:
	    		a.InicializarPila();
	    		
	    		a.Apilar(1);
	    		a.Apilar(2);
	    		a.Apilar(3);
	    		a.Apilar(345345);
	    		

	    		
	    		System.out.println("Cantidad:");
	    		int total = tp1.ContarPila(a);
	    		System.out.println(total);
	    		break;
	    	case 5:
	    		a.InicializarPila();
	    		
	    		a.Apilar(1);
	    		a.Apilar(2);
	    		a.Apilar(3);
	    		a.Apilar(4);
	    		

	    		
	    		System.out.println("Suma:");
	    		System.out.println(tp1.SumarElementosPila(a));
	    		break;
	    	case 6:
	    		a.InicializarPila();
	    		
	    		a.Apilar(1);
	    		a.Apilar(3);
	    		a.Apilar(5);
	    		a.Apilar(4);
	    		System.out.println("Promedio:");
	    		float promedio = tp1.CalcularPromedioPila(a);
	    		System.out.println(promedio);
	    		break;
	    	case 7:
	    		
	    		colaa.InicializarCola();
	    		
	    		colab.InicializarCola();
	    		
	    		colaa.Acolar(1);
	    		colaa.Acolar(2);
	    		colaa.Acolar(3);
	    		

	    		
	    		System.out.println("Elementos viejos:");
	    		tp1.ImprimirCola(colaa);
	    		
	    		
	    		tp1.PasarCola(colaa, colab);
	    		System.out.println("Elementos nuevos:");
	    		tp1.ImprimirCola(colab);
	    		break;
	    	case 8:
	    		colaa.InicializarCola();
	    		
	    		colaa.Acolar(1);
	    		colaa.Acolar(6);
	    		colaa.Acolar(3);
	    		

	    		
	    		System.out.println("Elementos viejoskjh:");
	    		tp1.ImprimirCola(colaa);
	    		
	    		//Inversion
	    		tp1.InvertirCola(colaa);
	    		
	    		System.out.println("Elementos nuevos:");
	    		tp1.ImprimirCola(colaa);
	    		break;
	    	case 9:
	    		colaa.InicializarCola();
	    		
	    		colaa.Acolar(1);
	    		colaa.Acolar(6);
	    		colaa.Acolar(3);
	    		

	    		
	    		System.out.println("Elementos viejoskjh:");
	    		tp1.ImprimirCola(colaa);
	    		
	    		//Inversion
	    		tp1.InvertirColaR(colaa);
	    		
	    		System.out.println("Elementos nuevos:");
	    		tp1.ImprimirCola(colaa);
	    		break;
	    	case 10:

	    		C1.InicializarCola();
	    		C2.InicializarCola();
	    		
	    		C1.Acolar(1);
	    		C1.Acolar(2);
	    		C1.Acolar(3);
	    		
	    		C2.Acolar(4);
	    		C2.Acolar(5);
	    		C2.Acolar(6);
	    		C2.Acolar(5);
	    		

	    		
	    		if(tp1.IsColaEqual(C1,C2)){
	    			System.out.println("La cola tiene la misma cantidad de elementos");
	    		}
	    		else
	    			System.out.println("La cola tiene distinta cantidad de elementos");
	    		break;
	    	case 11:
	    		C1.InicializarCola();
	    		
	    		C1.Acolar(3);
	    		C1.Acolar(2);
	    		C1.Acolar(3);
	    		C1.Acolar(2);
	    		C1.Acolar(2);
	    		C1.Acolar(3);
	    		

	    		
	    		if(tp1.IsColaCapicua(C1)){
	    			System.out.println("La cola es capicua");
	    		}
	    		else
	    			System.out.println("La cola no es capicua");

	    		break;
	    	case 12:
	    		C1.InicializarCola();
	    		C2.InicializarCola();
	    		
	    		C1.Acolar(3);
	    		C1.Acolar(2);
	    		C1.Acolar(1);
	    		
	    		C2.Acolar(3);
	    		C2.Acolar(2);
	    		C2.Acolar(1);
	    		
	    		
	    		if(tp1.IsColaInvertida(C1,C2)){
	    			System.out.println("La cola esta invertida");
	    		}
	    		else
	    			System.out.println("La cola no esta invertida");
	    		break;
	    	
	      }
    	      	  
	  }
	      
      
      
	}	
}
