package implement.arreglos;

import api.DiccionarioSimpleTDA;
import implement.listas.ConjuntoLD;
import api.ConjuntoTDA;

public class DicSimpleA implements DiccionarioSimpleTDA {

	class Elemento{ 
		int clave; 
		int valor; 
	}
	Elemento[] elementos; 
	int cant;
	
	public void InicializarDiccionario()
	{ 
		cant = 0; 
		elementos = new Elemento[100]; 
	}
	
	public void Agregar(int clave , int valor)
	{ 
		int pos = Clave2Indice(clave); 
		if (pos==-1) 
		{ 
			pos=cant;
			elementos[pos]= new Elemento(); 
			elementos[pos].clave = clave; 
			cant++; 
		} 
		elementos[pos].valor = valor;
	}
	
	private int Clave2Indice(int clave)
	{ 
		int i=cant -1; 
		while(i>=0 && elementos[i].clave!=clave) 
			i--; 
			
		return i; 
		
	}
	
	
	public void Eliminar(int clave) 
	{ 
		int pos = Clave2Indice(clave); 
		if (pos!=-1) 
		{ 
			elementos[pos] = elementos[cant -1]; 
			cant --; 
		} 
	}
	
	public int Recuperar(int clave) 
	{ 
		int pos = Clave2Indice(clave); 
		return elementos[pos].valor; 
	}

	public ConjuntoTDA Claves() 
	{ 
		ConjuntoTDA c=new ConjuntoLD(); 
		c.InicializarConjunto();
		for( int i=0; i<cant; i++)
		{ 
			c.Agregar(elementos[i].clave); 
		} 
		return c;
	}


}
