package TPs.Tp1;

import api.ColaTDA;
import implement.arreglos.ColaPU;
import librerias.Utilidades;

public class Ejercicio4_F {
	
	public static void main(String[] args) {
		ColaTDA C1= new ColaPU();
		ColaTDA C2= new ColaPU();
		C1.InicializarCola();
		C2.InicializarCola();
		
		C1.Acolar(3);
		C1.Acolar(2);
		C1.Acolar(1);
		
		C2.Acolar(3);
		C2.Acolar(2);
		C2.Acolar(1);
		
		Utilidades tp1= new Utilidades();
		
		if(tp1.IsColaInvertida(C1,C2)){
			System.out.println("La cola esta invertida");
		}
		else
			System.out.println("La cola no esta invertida");
		}


}
