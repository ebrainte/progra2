package TPs.Tp1;

import api.PilaTDA;
import implement.arreglos.PilaTF;
import librerias.Utilidades;

public class Ejercicio2_f {
	public static void main(String[] args) {
		PilaTDA a= new PilaTF();
		a.InicializarPila();
		
		a.Apilar(1);
		a.Apilar(2);
		a.Apilar(3);
		a.Apilar(4);
		
		Utilidades tp1= new Utilidades();
		
		System.out.println("Suma:");
		System.out.println(tp1.CalcularPromedioPila(a));
		
		
		}
}
