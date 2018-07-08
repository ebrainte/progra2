package TPs.Tp1;

import api.ColaTDA;
import implement.arreglos.ColaPU;
import librerias.Utilidades;

public class Ejercicio4_a {

	public static void main(String[] args) {
		ColaTDA a= new ColaPU();
		a.InicializarCola();
		
		ColaTDA b= new ColaPU();
		b.InicializarCola();
		
		a.Acolar(1);
		a.Acolar(2);
		a.Acolar(3);
		
		Utilidades tp1= new Utilidades();
		
		System.out.println("Elementos viejos:");
		tp1.ImprimirCola(a);
		
		
		tp1.PasarCola(a, b);
		System.out.println("Elementos nuevos:");
		tp1.ImprimirCola(b);
		
		
		}
}
