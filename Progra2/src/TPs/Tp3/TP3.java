package TPs.Tp3;

import api.*;
import implement.listas.*;
import librerias.Utilidades;
import implement.arreglos.*;
import java.util.Scanner;
@SuppressWarnings("unused")

public class TP3 {
	public static void main(String[] args) {
		
		Utilidades tp3= new Utilidades();	
	
		int seleccion=0;
		Scanner input = new Scanner(System.in);

      
  		PilaTDA a= new PilaTF();
  		PilaTDA b= new PilaTF();
		
  		
  		ColaTDA colaa= new ColaPU();
  		ColaTDA colab= new ColaPU();
  		
		PilaTDA P1= new PilaTF();
		PilaTDA P2= new PilaTF();
		
		ColaTDA C1= new ColaPU();
		ColaTDA C2= new ColaPU();
		
      while(seleccion!=99)
      {

	      System.out.println("-------------------------\n");
	      System.out.println("Trabajo Practico Nº1");
	      System.out.println("Elija el ejercicio");
	      System.out.println("-------------------------\n");
	      System.out.println("1 - Ejercicio 1 A");
	      System.out.println("2 - Ejercicio 1 B");
	      System.out.println("3 - Ejercicio 1 C");
	      System.out.println("4 - Ejercicio 1 D");
	      System.out.println("5 - Ejercicio 2 A");
	      System.out.println("6 - Ejercicio 2 B");
	      System.out.println("7 - Ejercicio 2 C");
	      System.out.println("8 - Ejercicio 3 B");
	      System.out.println("9 - Ejercicio 3 C");
	      System.out.println("10 - Ejercicio 3 D");
	      System.out.println("11 - Ejercicio 3 E");
	      System.out.println("12 - Ejercicio 3 F");
	      System.out.println("13 - Ejercicio 3 G");
	      System.out.println("14 - Ejercicio 4 A");
	      System.out.println("15 - Ejercicio 5 1A");
	      System.out.println("15 - Ejercicio 5 1B");
	      System.out.println("15 - Ejercicio 5 1C");
	      System.out.println("15 - Ejercicio 5 1D");
	      System.out.println("15 - Ejercicio 5 2");
	      System.out.println("99 - Salir");
	
	      seleccion = input.nextInt();
	      
	      
	      System.out.println("-------------------------\n");
	      switch (seleccion) {
	      
	      	case 1:
	      		P1.InicializarPila();
	    		P1.Apilar(3);
	    		P1.Apilar(3);
	    		P1.Apilar(3);
	    		P1.Apilar(4);
	    		if(tp3.IsPilaCapicua(P1)){
	    			System.out.println("La pila es capicua");
	    		}
	    		else
	    			System.out.println("La pila no es capicua");
	    		
	      		break;
	      	case 2:
	      		P1.InicializarPila();
	    		P1.Apilar(3);
	    		P1.Apilar(3);
	    		P1.Apilar(3);
	    		P1.Apilar(4);
	    		tp3.EliminarRepeticiones(P1);
	    		tp3.ImprimirPila(P1);
	      		break;
	      	case 3:
	      		PilaTDA M1 = new PilaTF();
	      		PilaTDA M2 = new PilaTF();
	      		M1.InicializarPila();
	      		M2.InicializarPila();
	      		
	      		P1.InicializarPila();
	    		P1.Apilar(1);
	    		P1.Apilar(2);
	    		P1.Apilar(3);
	    		P1.Apilar(4);
	    		tp3.DividirPila(P1, M1, M2);
	    		System.out.println("Pila Original");
	    		tp3.ImprimirPila(P1);
	    		System.out.println("Primer mitad M1");
	    		tp3.ImprimirPila(M1);
	    		System.out.println("Primer mitad M2");
	    		tp3.ImprimirPila(M2);
	      		break;
	      	case 4:
	      		P1.InicializarPila();
	    		P1.Apilar(1);
	    		P1.Apilar(2);
	    		P1.Apilar(2);
	    		P1.Apilar(4);
	    		P1.Apilar(3);
	    		P1.Apilar(4);
	    		ConjuntoTDA conj1 = new ConjuntoLD();
	    		conj1.InicializarConjunto();
	    		conj1 = tp3.ConjElemRep(P1);
	    	
	    		System.out.println("Pila Original");
	    		tp3.ImprimirPila(P1);
	    		System.out.println("Conjunto Resultante");
	    		tp3.ImprimirConjunto(conj1);

	      		break;
	      	case 5:
	      		break;
	      	case 6:
	      		break;
	      	case 7:
	      		break;
	      	case 8:
	      		break;
	      	case 9:
	      		break;
	      	case 10:
	      		break;
	      	case 11:
	      		break;
	      	case 12:
	      		break;
	      	case 13:
	      		break;
	      	case 14:
	      		break;
	      	case 15:
	      		break;
	      }
      	  
	  }
	      
      
      
	}	
}