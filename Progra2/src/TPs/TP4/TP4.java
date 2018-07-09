package TPs.TP4;
import api.*;
import implement.listas.*;
import librerias.Utilidades;
import implement.arreglos.*;
import java.util.Scanner;
@SuppressWarnings("unused")

public class TP4 {
	public static void main(String[] args) {
	
		Utilidades util= new Utilidades();
		int buscado;
		ABBTDA abb = new ABB();
		
		ABBTDA ab1 = new ABB();
		ABBTDA ab2 = new ABB();
		
		int seleccion=0;
		Scanner input = new Scanner(System.in);
		
		 while(seleccion!=99)
	      {

		      System.out.println("-------------------------\n");
		      System.out.println("Trabajo Practico Nº4");
		      System.out.println("Elija el ejercicio");
		      System.out.println("-------------------------\n");
		      System.out.println("1 - Ejercicio 3 A");
		      System.out.println("2 - Ejercicio 3 B");
		      System.out.println("3 - Ejercicio 3 C");
		      System.out.println("4 - Ejercicio 3 D");
		      System.out.println("5 - Ejercicio 3 E");
		      System.out.println("6 - Ejercicio 3 F");
		      System.out.println("7 - Ejercicio 3 G");
		      System.out.println("8 - Ejercicio 3 H");
		      System.out.println("9 - Ejercicio 3 I");
		      System.out.println("10 - Ejercicio 3 J");
		      System.out.println("11 - Ejercicio 3 K");
		      System.out.println("12 - Ejercicio 3 L");
		      System.out.println("13 - Ejercicio 3 M");
		      System.out.println("14 - Ejercicio 3 N");
		      System.out.println("99 - Salir");
		
		      seleccion = input.nextInt();
		      
		      
		      System.out.println("-------------------------\n");
		      switch (seleccion) {
		      
		      	case 1:
		      	// (a) Dado un elemento, determinar si esta o no en un ABB

		    		
		    		abb.InicializaArbol();
		    		abb.AgregarElem(100);
		    		abb.AgregarElem(50);
		    		abb.AgregarElem(800);
		    		abb.AgregarElem(200);
		    		abb.AgregarElem(150);
		    		abb.AgregarElem(25);
		    		abb.AgregarElem(52);
		    		abb.AgregarElem(900);
		    		abb.AgregarElem(850);
		    		abb.AgregarElem(910);
		    		abb.AgregarElem(125);
		    		
		    		buscado = 80;

		    		if (util.existeElementoEnABB(abb, buscado))
		    			System.out.println("El elemento " + buscado + " existe en el arbol");
		    		else
		    			System.out.println("El elemento " +  buscado + " no existe en el arbol.");
		    		
		      		break;
		      	case 2:
		    		abb.InicializaArbol();
		    		abb.AgregarElem(100);
		    		abb.AgregarElem(50);
		    		abb.AgregarElem(800);
		    		abb.AgregarElem(200);
		    		abb.AgregarElem(150);
		    		abb.AgregarElem(25);
		    		abb.AgregarElem(52);
		    		abb.AgregarElem(900);
		    		abb.AgregarElem(850);
		    		abb.AgregarElem(910);
		    		abb.AgregarElem(125);
		    		
		    		// (b) Dado un elemento, determinar si es una hoja de un ABB
		    		buscado = 100;
		    		System.out.println("Es hoja el elemento " + buscado + "?:" + util.esHoja(abb, 100));	
		      		break;
		      	case 3:
		      		abb.InicializaArbol();
		    		abb.AgregarElem(100);
		    		abb.AgregarElem(50);
		    		abb.AgregarElem(800);
		    		abb.AgregarElem(200);
		    		abb.AgregarElem(150);
		    		abb.AgregarElem(25);
		    		abb.AgregarElem(52);
		    		abb.AgregarElem(900);
		    		abb.AgregarElem(850);
		    		abb.AgregarElem(910);
		    		abb.AgregarElem(125);
		    		
		    		
		    		// (c) Dado un elemento, calcular su profundidad en el ABB
		    		buscado = 150;
		    		System.out.println("La profundidad del elemento " + buscado + " es:" +
		    				util.calcularProfundidad(abb, buscado));
		      		break;
		      	case 4:
		    		
		    		abb.InicializaArbol();
		    		abb.AgregarElem(100);
		    		abb.AgregarElem(50);
		    		abb.AgregarElem(800);
		    		abb.AgregarElem(200);
		    		abb.AgregarElem(150);
		    		abb.AgregarElem(25);
		    		abb.AgregarElem(52);
		    		abb.AgregarElem(900);
		    		abb.AgregarElem(850);
		    		abb.AgregarElem(910);
		    		abb.AgregarElem(125);
		    		
		    		
		    		// (d) Obtener el valor del menor elemento de un ABB		
		    		if (!abb.ArbolVacio())
		    			System.out.println("El menor elemento del Arbol es: " + util.menor(abb));
		    		else
		    			System.out.println("El arbol esta vacio.");
		      		break;
		      	case 5:
		      		abb.InicializaArbol();
		    		abb.AgregarElem(100);
		    		abb.AgregarElem(50);
		    		abb.AgregarElem(800);
		    		abb.AgregarElem(200);
		    		abb.AgregarElem(150);
		    		abb.AgregarElem(25);
		    		abb.AgregarElem(52);
		    		abb.AgregarElem(900);
		    		abb.AgregarElem(850);
		    		abb.AgregarElem(910);
		    		abb.AgregarElem(125);
		    		
		    		// (e) Calcular la cantidad de elementos que contiene un ABB
		    		if (!abb.ArbolVacio())
		    			System.out.println("El arbol contiene " + util.Contar(abb) + " elementos.");
		    		else
		    			System.out.println("El arbol esta vacio.");
		      		break;
		      	case 6:
		    		
		    		abb.InicializaArbol();
		    		abb.AgregarElem(100);
		    		abb.AgregarElem(50);
		    		abb.AgregarElem(800);
		    		abb.AgregarElem(200);
		    		abb.AgregarElem(150);
		    		abb.AgregarElem(25);
		    		abb.AgregarElem(52);
		    		abb.AgregarElem(900);
		    		abb.AgregarElem(850);
		    		abb.AgregarElem(910);
		    		abb.AgregarElem(125);
		    		
		    		// (f) Calcular la suma de los elementos que contiene un ABB
		    		System.out.println("Suma de elementos del ABB: " + util.sumarElementos(abb));
		      		break;
		      	case 7:
		    		
		    		abb.InicializaArbol();
		    		abb.AgregarElem(100);
		    		abb.AgregarElem(50);
		    		abb.AgregarElem(800);
		    		abb.AgregarElem(200);
		    		abb.AgregarElem(150);
		    		abb.AgregarElem(25);
		    		abb.AgregarElem(52);
		    		abb.AgregarElem(900);
		    		abb.AgregarElem(850);
		    		abb.AgregarElem(910);
		    		abb.AgregarElem(125);
		    		
		    		// (g) Calcular la cantidad de hojas de un ABB
		    		System.out.println("Cantidad de hojas en el ABB: " + util.contarHojas(abb));
		      		break;
		      	case 8:
		    		
		    		abb.InicializaArbol();
		    		abb.AgregarElem(100);
		    		abb.AgregarElem(50);
		    		abb.AgregarElem(800);
		    		abb.AgregarElem(200);
		    		abb.AgregarElem(150);
		    		abb.AgregarElem(25);
		    		abb.AgregarElem(52);
		    		abb.AgregarElem(900);
		    		abb.AgregarElem(850);
		    		abb.AgregarElem(910);
		    		abb.AgregarElem(125);
		    		
		    		// (h) Calcular la altura de un ABB
		    		System.out.println("Altura del arbol: " + util.alturaArbol(abb));
		      		break;
		      	case 9:

		      		ab1.InicializaArbol();
		    		ab2.InicializaArbol();
		    		
		    		// arbol 1
		    		ab1.AgregarElem(1);
		    		ab1.AgregarElem(3);
		    		ab1.AgregarElem(8);
		    		
		    		// arbol 2
		    		ab2.AgregarElem(1);
		    		ab2.AgregarElem(3);
		    		ab2.AgregarElem(8);
		    		System.out.println("Verificar si 2 arboles tienen los mismos elementos: " + util.verificaABBIguales(ab1, ab2));
		      		break;
		      	case 10:
		      		ab1.InicializaArbol();
		    		ab2.InicializaArbol();
		    		
		    		ab1.AgregarElem(1);
		    		ab1.AgregarElem(3);
		    		ab1.AgregarElem(8);
		    		
		    		ab2.AgregarElem(1);
		    		ab2.AgregarElem(3);
		    		ab2.AgregarElem(8);
		    		System.out.println("Verificar si 2 arboles tienen los mismos elementos: " + util.verificaABBElementosIguales(ab1, ab2));
		      		break;
		      	case 11:
		      		abb.InicializaArbol();
		    		abb.AgregarElem(100);
		    		abb.AgregarElem(50);
		    		abb.AgregarElem(800);
		    		abb.AgregarElem(200);
		    		abb.AgregarElem(150);
		    		abb.AgregarElem(25);
		    		abb.AgregarElem(52);
		    		abb.AgregarElem(900);
		    		abb.AgregarElem(850);
		    		abb.AgregarElem(910);
		    		abb.AgregarElem(125);
		    				
		    		// (k) Contar la cantidad de elementos que estan en un cierto nivel N
		    		int nivel = 2;
		    		System.out.println("Cantidad de elementos en nivel " + nivel + ": " + util.elementosNivelArbol(abb, nivel) );
		      		break;
		      	case 12:
		      		abb.InicializaArbol();
		    		abb.AgregarElem(100);
		    		abb.AgregarElem(50);
		    		abb.AgregarElem(800);
		    		abb.AgregarElem(200);
		    		abb.AgregarElem(150);
		    		abb.AgregarElem(25);
		    		abb.AgregarElem(52);
		    		abb.AgregarElem(900);
		    		abb.AgregarElem(850);
		    		abb.AgregarElem(910);
		    		abb.AgregarElem(125);
		    				
		    		// (l) Mostrar por pantalla todos los elementos que contiene un ABB (inOrden, PreOrden, PostOrden)
		    		// in-orden
		    		System.out.println("Elementos del ABB In-orden: ");
		    		util.inOrder(abb);
		    		
		    		// pre-orden
		    		System.out.println("Elementos del ABB Pre-orden: ");
		    		util.preOrder(abb);
		    		// post-orden
		    		System.out.println("Elementos del ABB Post-orden:");
		    		util.postOrder(abb);
		      		break;
		      	case 13:
		    		ConjuntoTDA con = new ConjuntoLD();
		    		
		    		abb.InicializaArbol();
		    		abb.AgregarElem(100);
		    		abb.AgregarElem(50);
		    		abb.AgregarElem(800);
		    		abb.AgregarElem(200);
		    		abb.AgregarElem(150);
		    		abb.AgregarElem(25);
		    		abb.AgregarElem(52);
		    		abb.AgregarElem(900);
		    		abb.AgregarElem(850);
		    		abb.AgregarElem(910);
		    		abb.AgregarElem(125);
		    				

		    		// (m) Dado un valor k, arme un conjunto con todos los elementos del ABB que son mayores que k.
		    		con.InicializarConjunto();
		    		int k=125;
		    		
		    		con = util.cargarConjunto(abb, k);
		    		
		    		System.out.println("Datos cargados en el conjunto: ");
		    		while (!con.ConjuntoVacio()) {
		    			System.out.println(con.Elegir());
		    			con.Sacar(con.Elegir());
		    		}
		      		break;
		      	case 14:
		    		
		    		abb.InicializaArbol();
		    		abb.AgregarElem(100);
		    		abb.AgregarElem(50);
		    		abb.AgregarElem(800);
		    		abb.AgregarElem(200);
		    		abb.AgregarElem(150);
		    		abb.AgregarElem(25);
		    		abb.AgregarElem(52);
		    		abb.AgregarElem(900);
		    		abb.AgregarElem(850);
		    		abb.AgregarElem(910);
		    		abb.AgregarElem(125);
		    		
		    		// (n) Dado un elemento de valor v (presente en el ABB), obtener el elemento
		    		// del arbol que es inmediatamente anterior
		    		int valorBuscado = 150;
		    		int valorEncontrado = util.valorAnterior(abb, valorBuscado);
		    		if (valorEncontrado==valorBuscado)
		    			System.out.println("No se ha encontrado el elemento anterior.");
		    		else
		    			System.out.println("El elemento anterior al elemento buscado (" + valorBuscado + ") es: " + valorEncontrado);
		      		break;
		      }
	
	      }
	}
}