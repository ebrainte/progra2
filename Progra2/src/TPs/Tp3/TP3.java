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
		
		ColaTDA CM1= new ColaPU();
		ColaTDA CM2= new ColaPU();
		
		ConjuntoTDA conj1 = new ConjuntoLD();
		ConjuntoTDA conj2 = new ConjuntoLD();
		
  		PilaTDA P = new PilaLD();
  		ColaTDA C = new ColaLD();
  		
  		DiccionarioMultipleTDA D1 = new DicMultipleLD();
  		DiccionarioMultipleTDA D2 = new DicMultipleLD();
  		
  		
  		ColaPrioridadTDA CP = new ColaPrioridadLD();
      while(seleccion!=99)
      {

	      System.out.println("-------------------------\n");
	      System.out.println("Trabajo Practico Nº3");
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
	      System.out.println("16 - Ejercicio 5 1B");
	      System.out.println("17 - Ejercicio 5 1C");
	      System.out.println("18 - Ejercicio 5 1D");
	      System.out.println("19 - Ejercicio 5 2");
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
	    		conj1.InicializarConjunto();
	    		conj1 = tp3.ConjElemRep(P1);
	    	
	    		System.out.println("Pila Original");
	    		tp3.ImprimirPila(P1);
	    		System.out.println("Conjunto Resultante");
	    		tp3.ImprimirConjunto(conj1);

	      		break;
	      	case 5:
	      		C1.InicializarCola();
	      		C1.Acolar(1);
	      		C1.Acolar(2);
	      		C1.Acolar(2);
	      		C1.Acolar(2);
	      		C1.Acolar(3);
	      		C1.Acolar(4);
	      		C1.Acolar(5);
	      		C1.Acolar(5);
	      		System.out.println("Cola Original:");
	      		tp3.ImprimirCola(C1);
	      		System.out.println("Cola sin repeticiones");
	      		tp3.EliminarRepeticiones(C1);
	      		tp3.ImprimirCola(C1);
	      		break;
	      	case 6:
	      		CM1.InicializarCola();
	      		CM2.InicializarCola();
	      		C1.InicializarCola();
	      		C1.Acolar(1);
	      		C1.Acolar(2);
	      		C1.Acolar(2);
	      		C1.Acolar(2);
	      		C1.Acolar(3);
	      		C1.Acolar(4);
	      		C1.Acolar(5);
	      		C1.Acolar(5);
	      		System.out.println("Cola Original:");
	      		tp3.ImprimirCola(C1);
	      		tp3.DividirCola(C1, CM1, CM2);
	      		System.out.println("Nueva Cola M1:");
	      		tp3.ImprimirCola(CM1);
	      		System.out.println("Nueva Cola M2:");
	      		tp3.ImprimirCola(CM2);
	      		break;
	      	case 7:
	      		C1.InicializarCola();
	      		C1.Acolar(1);
	      		C1.Acolar(2);
	      		C1.Acolar(2);
	      		C1.Acolar(2);
	      		C1.Acolar(3);
	      		C1.Acolar(4);
	      		C1.Acolar(5);
	      		C1.Acolar(5);
	      		System.out.println("Cola Original:");
	      		tp3.ImprimirCola(C1);
	      		
	      		ConjuntoTDA conjrep = new ConjuntoLD();
	      		conjrep.InicializarConjunto();
	      		
	      		conjrep = tp3.ConjElemRepCola(C1);
	      		System.out.println("Conjunto:");
	      		tp3.ImprimirConjunto(conjrep);
	      		break;
	      	case 8:
	      		conj1.InicializarConjunto();
	      		conj2.InicializarConjunto();
	      		
	      		conj1.Agregar(1);
	      		conj1.Agregar(2);
	      		conj1.Agregar(3);
	      		conj1.Agregar(4);
	      		conj1.Agregar(5);
	      		conj1.Agregar(6);
	      		
	      		conj2.Agregar(3);
	      		conj2.Agregar(4);
	      		conj2.Agregar(5);
	      		conj2.Agregar(6);
	      		conj2.Agregar(7);
	      		conj2.Agregar(8);
	      		
	      		System.out.println("Conjunto 1:");
	      		tp3.ImprimirConjunto(conj1);
	      		System.out.println("Conjunto 2:");
	      		tp3.ImprimirConjunto(conj2);
	      		
	      		System.out.println("Conjunto con la Diferencia Simetrica sin operaciones:");
	      		tp3.ImprimirConjunto(tp3.diferenciaSimetricaSinOperaciones(conj1, conj2));
	      		
	      		break;
	      	case 9:
	      		conj1.InicializarConjunto();
	      		conj2.InicializarConjunto();
	      		
	      		conj1.Agregar(1);
	      		conj1.Agregar(2);
	      		conj1.Agregar(3);
	      		conj1.Agregar(4);
	      		conj1.Agregar(5);
	      		conj1.Agregar(6);
	      		
	      		conj2.Agregar(3);
	      		conj2.Agregar(4);
	      		conj2.Agregar(5);
	      		conj2.Agregar(6);
	      		conj2.Agregar(7);
	      		conj2.Agregar(8);
	      		
	      		System.out.println("Conjunto 1:");
	      		tp3.ImprimirConjunto(conj1);
	      		System.out.println("Conjunto 2:");
	      		tp3.ImprimirConjunto(conj2);
	      		
	      		System.out.println("Conjunto con la Diferencia Simetrica con operaciones:");
	      		tp3.ImprimirConjunto(tp3.diferenciaSimetricaConOperaciones(conj1, conj2));
	      		break;
	      	case 10:
	      		
	      		conj1.InicializarConjunto();
	      		conj2.InicializarConjunto();
	      		
	      		conj1.Agregar(1);
	      		conj1.Agregar(2);
	      		conj1.Agregar(3);
	      		conj1.Agregar(4);
	      		conj1.Agregar(5);
	      		conj1.Agregar(6);
	      		
	      		/*
	      		conj2.Agregar(3);
	      		conj2.Agregar(4);
	      		conj2.Agregar(5);
	      		conj2.Agregar(6);
	      		conj2.Agregar(7);
	      		conj2.Agregar(8);
	      		*/
	      		conj2.Agregar(1);
	      		conj2.Agregar(2);
	      		conj2.Agregar(3);
	      		conj2.Agregar(4);
	      		conj2.Agregar(5);
	      		conj2.Agregar(6);
	      		
	      		System.out.println("Conjunto 1:");
	      		tp3.ImprimirConjunto(conj1);
	      		System.out.println("Conjunto 2:");
	      		tp3.ImprimirConjunto(conj2);
	      		
	      		System.out.println("Los conjuntos son iguales?");
	      		if(tp3.ConjuntosIguales(conj1, conj2))
	      			System.out.println("SI");
	      		else
	      			System.out.println("NO");
	      		break;
	      	case 11:
	      		conj1.InicializarConjunto();
	      		
	      		conj1.Agregar(1);
	      		conj1.Agregar(2);
	      		conj1.Agregar(3);
	      		conj1.Agregar(4);
	      		conj1.Agregar(5);
	      		conj1.Agregar(6);
	      		
	      		
	      		System.out.println("Cardinalidad:");
	      		System.out.println(tp3.CardinalidadConjunto(conj1));
	      		
	      		
	      		break;
	      	case 12:
	      		

	      		
	      		P.InicializarPila();
	      		C.InicializarCola();
	      		
	      		P.Apilar(1);
	      		P.Apilar(2);
	      		P.Apilar(3);
	      		C.Acolar(4);
	      		C.Acolar(5);
	      		C.Acolar(6);
	      		
	      		System.out.println("Pila:");
	      		tp3.ImprimirPila(P);
	      		
	      		System.out.println("Cola:");
	      		tp3.ImprimirCola(C);
	      		
	      		System.out.println("Conjunto:");
	      		tp3.ImprimirConjunto(tp3.GenerarConjunto(P, C));
	      		
	      		
	      		break;
	      	case 13:
	      		
	      		P.InicializarPila();
	      		C.InicializarCola();
	      		
	      		P.Apilar(1);
	      		P.Apilar(2);
	      		P.Apilar(3);
	      		C.Acolar(1);
	      		C.Acolar(2);
	      		C.Acolar(3);
	      		
	      		
	      		System.out.println("Pila:");
	      		tp3.ImprimirPila(P);
	      		
	      		System.out.println("Cola:");
	      		tp3.ImprimirCola(C);
	      		
	      		System.out.println("La pila es igual a la cola?");
	      		if(tp3.IsPilaIgualCola(P, C))
	      			System.out.println("SI");
	      		else
	      			System.out.println("NO");
	      		
	      		break;
	      	case 14:
	      		D1.InicializarDiccionario();
	      		CP.InicializarCola();
	      		CP.AcolarPrioridad(1, 4);
	      		CP.AcolarPrioridad(3, 1);
	      		CP.AcolarPrioridad(6, 2);
	      		CP.AcolarPrioridad(2, 3);
	      		
	      		tp3.ColaPrioridadADicMult(CP, D1);
	      		tp3.ImprimirDicMult(D1);
	      		break;
	      	case 15:
	      		
	      		D1.InicializarDiccionario();
	      		D2.InicializarDiccionario();
	      		
	      		D1.Agregar(1, 2);
	      		D1.Agregar(2, 3);
	      		D2.Agregar(3, 4);
	      		D2.Agregar(4, 5);
	      		
	      		tp3.ImprimirDicMult(tp3.UnionDicMult(D1, D2));
	      		break;
	      	case 16:
	      		
	      		D1.InicializarDiccionario();
	      		D2.InicializarDiccionario();
	      		
	      		D1.Agregar(1, 2);
	      		D1.Agregar(2, 3);
	      		D2.Agregar(1, 2);
	      		D2.Agregar(4, 5);
	      		
	      		tp3.ImprimirDicMult(tp3.InterseccionDicMult(D1, D2));
	      		break;
	      		
	      	case 17:
	      		
	      		D1.InicializarDiccionario();
	      		D2.InicializarDiccionario();
	      		
	      		D1.Agregar(1, 2);
	      		D1.Agregar(2, 3);
	      		D2.Agregar(1, 2);
	      		D2.Agregar(4, 5);
	      		
	      		tp3.ImprimirDicMult(tp3.InterseccionClavesDicMult(D1, D2));
	      		break;
	      		
	      	case 18:
	      		
	      		D1.InicializarDiccionario();
	      		D2.InicializarDiccionario();
	      		
	      		D1.Agregar(1, 2);
	      		D1.Agregar(2, 3);
	      		D2.Agregar(1, 2);
	      		D2.Agregar(4, 5);
	      		
	      		tp3.ImprimirDicMult(tp3.InterseccionClavesyValoresDicMult(D1, D2));
	      		break;
	      		
	      	case 19:
	      		DiccionarioSimpleTDA D = new DicSimpleA();
	      		D.InicializarDiccionario();
	      		D1.InicializarDiccionario();
	      		
	      		D.Agregar(1, 2);
	      		D.Agregar(2, 2);
	      		D.Agregar(3, 2);
	      		D.Agregar(4, 2);
	      		D.Agregar(5, 3);
	      		D.Agregar(6, 3);
	      		D.Agregar(7, 3);
	      		D.Agregar(8, 3);
	      		
	      		tp3.ImprimirDicMult(tp3.DiccionarioMultipleDS(D));
	      		break;
	      }
      	  
	  }
	      
      
      
	}	
}