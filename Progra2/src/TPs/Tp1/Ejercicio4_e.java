package TPs.Tp1;

import api.ColaTDA;
import implement.arreglos.ColaPU;
import librerias.Utilidades;

public class Ejercicio4_e {
	
	public static void main(String[] args) {
		ColaTDA C1= new ColaPU();
		C1.InicializarCola();
		
		C1.Acolar(3);
		C1.Acolar(2);
		C1.Acolar(3);
		C1.Acolar(2);
		C1.Acolar(2);
		C1.Acolar(3);
		
		Utilidades tp1= new Utilidades();
		
		if(tp1.IsColaCapicua(C1)){
			System.out.println("La cola es capicua");
		}
		else
			System.out.println("La cola no es capicua");
		}


}
