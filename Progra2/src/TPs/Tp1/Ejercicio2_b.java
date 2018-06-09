package TPs.Tp1;

import api.PilaTDA;
import impl.PilaTF;
import librerias.Utilidades;

public class Ejercicio2_b {
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
		
		
		tp1.CopiarPila(a, b);
		System.out.println("Elementos nuevos:");
		tp1.ImprimirPila(b);
		
		
		}
}
