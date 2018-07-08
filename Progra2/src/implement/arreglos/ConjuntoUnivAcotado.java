package implement.arreglos;

import api.ConjuntoTDA;

public class ConjuntoUnivAcotado implements ConjuntoTDA {

	int[] a;
	int cant;
	@Override
	public void InicializarConjunto() {
		a = new int [100]; 
		cant = 0;
	}

	@Override
	public boolean ConjuntoVacio() {
		
		return cant==0;
	}

	@Override
	public void Agregar(int x) {
		if((x%2)==0) //si es par lo dejo entrar, acotando el universo
		{
			if(!this.Pertenece(x))
			{ 
				a[cant] = x; 
				cant++; 
			}
		}
	}
	

	@Override
	public int Elegir() {
		return a[cant-1];
	}

	@Override
	public void Sacar(int x) {
		int i = 0; 
		while (i<cant && a[i]!=x) 
			i++;
		if(i < cant){ 
			a[i] = a[cant -1]; 
			cant --;
		}

	}

	@Override
	public boolean Pertenece(int x) {
		int i = 0;
		while (i<cant && a[i]!=x) 
			i++; 
		return ( i < cant);
	}

}
