package implement.arreglos;

import api.ConjuntoTDA;
import api.GrafoTDA;
import implement.listas.ConjuntoLD;

public class GrafoM implements GrafoTDA {

	private int Cant = 100;
	private int[][] Aristas;
	private int[] Vertices;
	private int CantNodos;

	public void InicializarGrafo() {
		Aristas = new int[Cant][Cant];
		Vertices = new int[Cant];
		CantNodos = 0;
	}

	public void AgregarVertice(int x) {
		Vertices[CantNodos] = x;
		for (int i = 0; i <= CantNodos; i++) {
			Aristas[i][CantNodos] = 0;
			Aristas[CantNodos][i] = 0;
		}
		CantNodos++;
	}

	public void EliminarVertice(int x) {
		int ind = Vert2Ind(x);
		for (int i = 0; i < CantNodos; i++) {
			Aristas[i][ind] = Aristas[i][CantNodos - 1];
			Aristas[ind][i] = Aristas[CantNodos - 1][i];
		}
		Vertices[ind] = Vertices[CantNodos - 1];
		CantNodos--;
	}

	private int Vert2Ind(int x) {
		int i = CantNodos - 1;
		while (i>=0 && Vertices [i] != x)
			i--;
		return i;
	}

	public ConjuntoTDA Vertices() {
		ConjuntoTDA ret = new ConjuntoLD();
		ret.InicializarConjunto();
		for(int i = 0; i < CantNodos; i++)
			ret.Agregar(Vertices[i]);
		return ret;
	}

	public void AgregarArista(int v1, int v2, int peso) {
		Aristas[this.Vert2Ind(v1)][this.Vert2Ind(v2)] = peso;
	}

	public void EliminarArista(int v1, int v2) {
		Aristas[this.Vert2Ind(v1)][this.Vert2Ind(v2)] = 0;
	}

	public boolean ExisteArista(int v1, int v2) {
		return (Aristas[this.Vert2Ind(v1)][this.Vert2Ind(v2)] != 0);
	}

	public int PesoArista(int v1, int v2) {
		return Aristas[this.Vert2Ind(v1)][this.Vert2Ind(v2)];
	}



}
