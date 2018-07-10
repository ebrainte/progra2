package TPs.TP6;
import api.*;
import implement.listas.*;
import librerias.Utilidades;
import implement.arreglos.*;
import java.util.Scanner;
@SuppressWarnings("unused")


public class TP6 {
	public static void main(String[] args) {
		
		Utilidades tp6 = new Utilidades();
		ConjuntoTDA conj = new ConjuntoLD();
		conj.InicializarConjunto();
		GrafoTDA grafo = new GrafoLD();
		grafo.InicializarGrafo();
		grafo.AgregarVertice(1);
		grafo.AgregarVertice(2);
		grafo.AgregarVertice(3);
		grafo.AgregarVertice(4);
		grafo.AgregarVertice(5);
		grafo.AgregarVertice(6);
		grafo.AgregarVertice(7);
		grafo.AgregarArista(1, 2, 100);
		grafo.AgregarArista(1, 3, 200);
		grafo.AgregarArista(1, 5, 300);
		grafo.AgregarArista(1, 7, 400);
		grafo.AgregarArista(2, 1, 500);
		grafo.AgregarArista(2, 3, 600);
		grafo.AgregarArista(2, 5, 700);
		grafo.AgregarArista(3, 1, 800);
		grafo.AgregarArista(5, 1, 900);
		grafo.AgregarArista(5, 2, 910);
		grafo.AgregarArista(7, 3, 920);

		int seleccion=0;
		Scanner input = new Scanner(System.in);
		
		 while(seleccion!=99)
	     {

		      System.out.println("-------------------------\n");
		      System.out.println("Trabajo Practico Nº6");
		      System.out.println("Elija el ejercicio");
		      System.out.println("-------------------------\n");
		      System.out.println("1 - Ejercicio 4");
		      System.out.println("2 - Ejercicio 5");
		      System.out.println("3 - Ejercicio 6");
		      System.out.println("4 - Ejercicio 7");
		      System.out.println("5 - Ejercicio 8");
		      System.out.println("6 - Ejercicio 9");
		      System.out.println("99 - Salir");
		
		      seleccion = input.nextInt();
		      
		      
		      System.out.println("-------------------------\n");
		      switch (seleccion) {
		      
		      	case 1:
		    		System.out.println("Vertices adyacentes vertice 1:");
		    		conj = tp6.VerticesAdyacentesDobles(grafo, 1);
		    		tp6.ImprimirConjunto(conj);
		    		System.out.println("Vertices adyacentes vertice 2:");
		    		conj.InicializarConjunto();
		    		conj = tp6.VerticesAdyacentesDobles(grafo, 2);
		    		tp6.ImprimirConjunto(conj);
		      		break;
		      	case 2:
		    		System.out.println("Arista mas costosa del Vertice 1 es: " + tp6.AristaMayor(grafo, 1));
		    		System.out.println("Arista mas costosa del Vertice 2 es: " + tp6.AristaMayor(grafo, 2));
		      		break;
		      	case 3:
		      		System.out.println("Predecesores vertice 1:");
		    		conj.InicializarConjunto();
		    		conj = tp6.ConjuntoVertPredecesores(grafo, 1);
		    		tp6.ImprimirConjunto(conj);
		    		System.out.println("Predecesores vertice 2:");
		    		conj.InicializarConjunto();
		    		conj = tp6.ConjuntoVertPredecesores(grafo, 2);
		    		tp6.ImprimirConjunto(conj);

		      		break;
		      	case 4:
		      		System.out.println("Conjunto de Vertices aislados en G");
		    		conj.InicializarConjunto();
		    		conj = tp6.ConjuntoVertAislados(grafo);
		    		tp6.ImprimirConjunto(conj);
		      		break;
		      	case 5:
		      		System.out.println("Vertices puente entre 1 y 3");
		    		conj.InicializarConjunto();
		    		conj = tp6.ConjuntoVertPuente(grafo, 1, 3);
		    		tp6.ImprimirConjunto(conj);
		      		break;
		      	case 6:
		    		System.out.println("Grado Vertice 1: " + tp6.CalcularGradoVertice(grafo, 1));
		    		System.out.println("Grado Vertice 2: " + tp6.CalcularGradoVertice(grafo, 2));
		    		System.out.println("Grado Vertice 3: " + tp6.CalcularGradoVertice(grafo, 3));
		      		break;

		      
		      
		      }
	      }
	}
}
