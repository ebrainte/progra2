package api;

import impl.ConjuntoLD;
import impl.DicSimpleA;

public interface DiccionarioSimpleTDA {

	public void InicializarDiccionario();
	public void Agregar(int clave , int valor);
	public void Eliminar(int clave);
	public int Recuperar(int clave);
	public ConjuntoTDA Claves();
	
}
