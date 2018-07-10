package implement.listas;

import api.ConjuntoTDA;
import api.GrafoTDA;

public class GrafoLD implements GrafoTDA {

	private class NodoGrafo {
		int valor;
		NodoArista arista;
		NodoGrafo sig;
	}

	private class NodoArista {
		int peso;
		NodoGrafo destino;
		NodoArista sig;
	}

	NodoGrafo start;

	public void InicializarGrafo() {
		start = null;
	}

	public void AgregarVertice(int x) {
		NodoGrafo nuevo = new NodoGrafo();
		nuevo.valor = x;
		nuevo.arista = null;
		nuevo.sig = start;
		start = nuevo;
	}

	public void EliminarVertice(int x) {
		if (start.valor == x)
			start = start.sig;

		NodoGrafo aux = start;
		while (aux != null) {
			this.EliminarAristaNodo(aux, x);
			if (aux.sig != null && aux.sig.valor == x)
				aux.sig = aux.sig.sig;
			aux = aux.sig;
		}
	}

	private void EliminarAristaNodo(NodoGrafo nodo, int x) {
		NodoArista aux = nodo.arista;

		if (aux.destino.valor == x)
			nodo.arista = aux.sig;
		else {
			while (aux.sig != null && aux.sig.destino.valor != x)
				aux = aux.sig;
			if (aux.sig != null)
				aux.sig = aux.sig.sig;
		}
	}

	public ConjuntoTDA Vertices() {
		ConjuntoTDA ret = new ConjuntoLD();
		ret.InicializarConjunto();
		NodoGrafo aux = start;
		while (aux != null) {
			ret.Agregar(aux.valor);
			aux = aux.sig;
		}
		return ret;
	}

	public void AgregarArista(int v1, int v2, int p) {
		NodoGrafo aux1 = this.Vert2Nodo(v1);
		NodoGrafo aux2 = this.Vert2Nodo(v2);

		NodoArista nuevo = new NodoArista();
		nuevo.peso = p;
		nuevo.destino = aux2;
		nuevo.sig = aux1.arista;
		aux1.arista = nuevo;
	}

	private NodoGrafo Vert2Nodo(int x) {
		NodoGrafo ret = start;
		while (ret != null && ret.valor != x)
			ret = ret.sig;
		return ret;
	}

	public void EliminarArista(int v1, int v2) {
		NodoGrafo aux = this.Vert2Nodo(v1);
		this.EliminarAristaNodo(aux, v2);
	}

	public boolean ExisteArista(int v1, int v2) {
		NodoGrafo nodo = this.Vert2Nodo(v1);
		NodoArista aux = nodo.arista;
		while (aux != null && aux.destino.valor != v2)
			aux = aux.sig;
		return (aux != null);
	}

	public int PesoArista(int v1, int v2) {
		NodoGrafo nodo = this.Vert2Nodo(v1);
		NodoArista aux = nodo.arista;
		while(aux.destino.valor != v2)
			aux = aux.sig;
		return aux.peso;
	}


}
