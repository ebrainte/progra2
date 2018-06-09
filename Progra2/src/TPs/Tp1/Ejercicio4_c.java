package TPs.Tp1;

import api.ColaTDA;
import impl.ColaPU;
import librerias.Utilidades;

public class Ejercicio4_c {

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
		tp1.InvertirColaR(a);
		
		System.out.println("Elementos nuevos:");
		tp1.ImprimirCola(a);
		
		
		}

}
