package TPs.Tp1;

import api.PilaTDA;
import implement.arreglos.PilaTF;
import librerias.Utilidades;

public class Ejercicio1_a {
	public static void main(String[] args) {
	PilaTDA a= new PilaTF();
	a.InicializarPila();
	
	PilaTDA b= new PilaTF();
	b.InicializarPila();
	
	a.Apilar(1);
	a.Apilar(2);
	a.Apilar(3);
	
	Utilidades tp1= new Utilidades();
	
	System.out.println("Elementos viejos:");
	tp1.ImprimirPila(a);
	
	
	tp1.PasarPila(a, b);
	System.out.println("Elementos nuevos:");
	tp1.ImprimirPila(b);
	
	
	}
}
//copio el origen en el auxiliar, cuando se copia en auxiliar queda al reves
//origen 1,2,3
//auxiliar 3,2,1
//luego se pasa de auxiliar a origen y destino