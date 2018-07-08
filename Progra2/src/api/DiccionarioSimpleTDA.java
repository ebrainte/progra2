package api;

import implement.arreglos.DicSimpleA;
import implement.listas.ConjuntoLD;

public interface DiccionarioSimpleTDA {

	public void InicializarDiccionario();
	public void Agregar(int clave , int valor);
	public void Eliminar(int clave);
	public int Recuperar(int clave);
	public ConjuntoTDA Claves();
	
}
