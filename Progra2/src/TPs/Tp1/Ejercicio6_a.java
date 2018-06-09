package TPs.Tp1;

import api.ColaPrioridadTDA;
import api.ColaTDA;
import impl.ColaPU;
import impl.ColaPrioridadDA;
import librerias.Utilidades;

public class Ejercicio6_a {

	public static void main(String[] args) {
		ColaPrioridadTDA C1= new ColaPrioridadDA();
		ColaPrioridadTDA C2= new ColaPrioridadDA();
		C1.InicializarCola();
		C2.InicializarCola();
		
		C1.AcolarPrioridad(3,5);
		C1.AcolarPrioridad(6,1);
		C1.AcolarPrioridad(1,2);
		
		C2.AcolarPrioridad(5,3);
		C2.AcolarPrioridad(2,4);
		C2.AcolarPrioridad(7,8);
		
		Utilidades tp1= new Utilidades();
		
		tp1.CombinarColaPrioridad(C1, C2);

	
	
	}
}
