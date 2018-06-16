package api;

public interface DiccionarioMultipleTDA {

	
	public void InicializarDiccionario();
	public void Agregar(int clave , int valor);
	public void Eliminar(int clave);
	public void EliminarValor(int clave , int valor);
	public ConjuntoTDA Recuperar(int clave);
	public ConjuntoTDA Claves();
}
