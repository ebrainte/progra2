package TPs.Tp1;

import api.ColaTDA;
import implement.arreglos.ColaPU;
import librerias.Utilidades;

public class Ejercicio4_b {

	public static void main(String[] args) {
		ColaTDA a= new ColaPU();
		a.InicializarCola();
		
		a.Acolar(1);
		a.Acolar(6);
		a.Acolar(3);
		
		Utilidades tp1= new Utilidades();
		
		System.out.println("Elementos viejoskjh:");
		tp1.ImprimirCola(a);
		
		//Inversion
		tp1.InvertirCola(a);
		
		System.out.println("Elementos nuevos:");
		tp1.ImprimirCola(a);
		
		
		}

}
