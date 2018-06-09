package TPs.Tp1;
import api.PilaTDA;
import impl.PilaTF;

public class Ejercicio1 {

	public static void main(String[] args) {
		//TODO
	PilaTDA a= new PilaTF();
	a.InicializarPila();
	
	PilaTDA b= new PilaTF();
	b.InicializarPila();
	
	a.Apilar(1);
	a.Apilar(2);
	a.Apilar(3);
	
	Tp1 tp1= new Tp1();
	tp1.PasarPila(a, b);
	}
}


//copio el origen en el auxiliar, cuando se copia en auxiliar queda al reves
//origen 1,2,3
//auxiliar 3,2,1
//luego se pasa de auxiliar a origen y destino