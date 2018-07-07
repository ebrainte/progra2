package implement.listas;
import api.PilaTDA;
import impl.Nodo;

public class PilaLD implements PilaTDA
{
	Nodo primero;

	public void InicializarPila()
	{ 
		primero = null; 
	}

	public void Apilar(int x)
	{ 
		Nodo aux = new Nodo(); 
		aux.info = x; 
		aux.sig = primero; 
		primero = aux; 
	}

	public void Desapilar()
	{ 
		primero = primero.sig; 
	}

	public boolean PilaVacia()
	{ 
		return (primero == null); 
	}

	public int tope()
	{ 
		return primero.info; 
	}
} 