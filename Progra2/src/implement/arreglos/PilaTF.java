package implement.arreglos;

import api.PilaTDA;

public class PilaTF implements PilaTDA {
	int indice; //variable entera en donde se guarda la cantidad de elementos que se tienen guardados
	int[] a; //arreglo en donde se guarda la informacion 

	public void InicializarPila() {
		a = new int [100]; 
		indice = 0;
	}
	public void Apilar(int x) {
		a[indice] = x; 
		indice++; 
		} 
	public void Desapilar() { 
		indice --;
		}
	
	public int tope() {
		return a[indice -1];
	}
	public boolean PilaVacia() {
		return (indice == 0);
	}
	
}
