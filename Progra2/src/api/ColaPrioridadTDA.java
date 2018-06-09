package api;

public interface ColaPrioridadTDA {
	void InicializarCola();
	// siempre que la cola este inicializada
	void AcolarPrioridad(int x, int prioridad);
	// siempre que la cola este inicializada y no este vacia
	void Desacolar();
	// siempre que la cola este inicializada y no este vacia
	int Primero();
	// siempre que la cola este inicializada
	boolean ColaVacia();
	// siempre que la cola este inicializada y no este vacia
	int Prioridad();
}
