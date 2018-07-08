package TPs.Tp1;

import api.ColaTDA;
import implement.arreglos.ColaPU;
import librerias.Utilidades;

public class Ejercicio4_d {
	
	public static void main(String[] args) {
		ColaTDA C1= new ColaPU();
		ColaTDA C2= new ColaPU();
		C1.InicializarCola();
		C2.InicializarCola();
		
		C1.Acolar(1);
		C1.Acolar(2);
		C1.Acolar(3);
		
		C2.Acolar(4);
		C2.Acolar(5);
		C2.Acolar(6);
		C2.Acolar(5);
		
		Utilidades tp1= new Utilidades();
		
		if(tp1.IsColaEqual(C1,C2)){
			System.out.println("La cola tiene la misma cantidad de elementos");
		}
		else
			System.out.println("La cola tiene distinta cantidad de elementos");
		}

}
