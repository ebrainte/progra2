package librerias;

import api.PilaTDA;
import api.ColaPrioridadTDA;
import api.ColaTDA;
import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import api.DiccionarioSimpleTDA;
import api.ABBTDA;
import api.GrafoTDA;
import implement.arreglos.ColaPI;
import implement.arreglos.ColaPU;
import implement.arreglos.ColaPrioridadAO;
import implement.arreglos.ColaPrioridadDA;
import implement.arreglos.DicMultipleA;
import implement.arreglos.DicSimpleA;
import implement.arreglos.PilaTF;
import implement.arreglos.PilaTI;
import implement.listas.ColaPrioridadLD;
import implement.listas.ConjuntoLD;
import implement.listas.PilaLD;
import implement.listas.ABB;


public class Utilidades {

	// Objetos y atributos auxiliares para la carga de elementos
	int altura;
	int counter;
	int aux;
	boolean verificado;
	ConjuntoTDA conjuntoAux;
	
	/////////////////////////////////////////////////////////////////////////////
	//Pilas
	/////////////////////////////////////////////////////////////////////////////
	
	public void ImprimirPila(PilaTDA o){
	
	PilaTDA aux = new PilaTF();
	aux.InicializarPila();
	CopiarPila(o,aux);
	while(!aux.PilaVacia()){
		System.out.println(aux.tope());
		aux.Desapilar();
		}
	}
	
	
	
	public void PasarPila(PilaTDA o, PilaTDA d){
		while (!o.PilaVacia())
		{ 
			d.Apilar(o.tope()); 
			o.Desapilar(); 
		}
	}
	public void CopiarPila(PilaTDA o, PilaTDA d){
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		PasarPila(o,aux);
		while(!aux.PilaVacia()){
			o.Apilar(aux.tope());
			d.Apilar(aux.tope());
			aux.Desapilar();
			}
		}
	public void InvertirPila(PilaTDA o){
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		PasarPila(o,aux);
		CopiarPila(aux,o);
	}
	public int ContarPila(PilaTDA p){
		int total = 0;
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		CopiarPila(p,aux);
		while (!aux.PilaVacia())
		{
			total++;
			aux.Desapilar();
		}
		return total;
			
	}
	public int SumarElementosPila(PilaTDA p)
	{ 
		int suma = 0; 
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		CopiarPila(p,aux);
		while (!aux.PilaVacia()){ 
			suma = suma + aux.tope(); 
			aux.Desapilar(); 
			} 
		return suma;
	} 
	public float CalcularPromedioPila(PilaTDA p)
	{ 
		int suma = 0;
		int cantidad = 0;
		suma = SumarElementosPila(p);
		cantidad = ContarPila(p);
		return suma/cantidad;
	}
	/////////////////////////////////////////////////////////////////////////////
	//Colas
	/////////////////////////////////////////////////////////////////////////////
	
	
	public void ImprimirCola(ColaTDA o){
		
	ColaTDA aux = new ColaPU();
	aux.InicializarCola();
	CopiarCola(o,aux);
	while(!aux.ColaVacia()){
		System.out.println(aux.Primero());
		aux.Desacolar();
		}
	}
	
	
	public void PasarCola(ColaTDA o, ColaTDA d){
		while (!o.ColaVacia())
		{ 
			d.Acolar(o.Primero()); 
			o.Desacolar(); 
		}
	}
	
	public void CopiarCola(ColaTDA o, ColaTDA d){
		ColaTDA aux = new ColaPU();
		aux.InicializarCola();
		PasarCola(o,aux);
		while(!aux.ColaVacia()){
			o.Acolar(aux.Primero());
			d.Acolar(aux.Primero());
			aux.Desacolar();
			}
		}
	
	public void InvertirCola(ColaTDA o){
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		while (!o.ColaVacia())
		{ 
			aux.Apilar(o.Primero()); 
			o.Desacolar(); 
		}
		while (!aux.PilaVacia())
		{ 
			o.Acolar(aux.tope()); 
			aux.Desapilar();
		}
		
		
	}
	public void InvertirColaR(ColaTDA c){
		int x;
		x = c.Primero();
		c.Desacolar();
		if (!c.ColaVacia())
			InvertirColaR(c);
		c.Acolar(x);
	}
	
	public boolean IsColaEqual(ColaTDA a,ColaTDA b){
		int cola1=0;
		int cola2=0;
		while(!a.ColaVacia()){
			cola1++;
			a.Desacolar();
		}
			
		while(!b.ColaVacia()){
			cola2++;
			b.Desacolar();
		}
		
		if(cola1==cola2){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean IsColaInvertida(ColaTDA a,ColaTDA b){
		this.InvertirCola(b);
		
		while(!a.ColaVacia()){
			if(a.Primero()!=b.Primero())
				return false;
			
			a.Desacolar();
			b.Desacolar();	
		}
		return true;
		
	}
	
	public boolean IsColaCapicua(ColaTDA a){
		PilaTDA pilaaux = new PilaTF();
		pilaaux.InicializarPila();
		ColaTDA colaaux = new ColaPI();
		colaaux.InicializarCola();
		
		this.CopiarCola(a, colaaux);
		
		while (!colaaux.ColaVacia())
		{ 
			pilaaux.Apilar(colaaux.Primero()); 
			colaaux.Desacolar(); 
		}
		
		while(!a.ColaVacia()){
			if(pilaaux.tope()!=a.Primero())
				return false;
				
			pilaaux.Desapilar();
			a.Desacolar();
		}
		
		return true;
		
		
	}





/////////////////////////////////////////////////////////////////////////////
//Cola con Prioridad
/////////////////////////////////////////////////////////////////////////////

	public void CombinarColaPrioridad(ColaPrioridadTDA a,ColaPrioridadTDA b){
		ColaPrioridadTDA colaaux = new ColaPrioridadDA();
		colaaux.InicializarCola();
		
		//Primero Acolo CP1
		while(!a.ColaVacia())
		{
			colaaux.AcolarPrioridad(a.Primero(), a.Prioridad());
			a.Desacolar();
		}
		//Primero Acolo CP2
		while(!b.ColaVacia())
		{
			colaaux.AcolarPrioridad(b.Primero(), b.Prioridad());
			b.Desacolar();
		}
	}
	
	public boolean VerificarColaPrioridadIdentica(ColaPrioridadTDA a,ColaPrioridadTDA b){
		//Genero 2 nuevas colas  y las copio para no destruir las originales
		ColaPrioridadTDA cola_a = new ColaPrioridadDA();
		cola_a.InicializarCola();
		ColaPrioridadTDA cola_b = new ColaPrioridadDA();
		cola_b.InicializarCola();
		
		this.CopiarColaPrioridad(a, cola_a);
		this.CopiarColaPrioridad(b, cola_b);
		
		while(!cola_a.ColaVacia())
		{
			if (cola_a.Primero() != cola_b.Primero() || cola_a.Prioridad() != cola_b.Prioridad())
			{
				return false;
			}
			cola_a.Desacolar();
			cola_b.Desacolar();
		}
		return true;
	}

	public void CopiarColaPrioridad(ColaPrioridadTDA o, ColaPrioridadTDA d) {
		ColaPrioridadAO colaaux = new ColaPrioridadAO();
		colaaux.InicializarCola();
		
		while (!o.ColaVacia()) {
			colaaux.AcolarPrioridad(o.Primero(), o.Prioridad());
			o.Desacolar();
		}
		while (!colaaux.ColaVacia()) {
			o.AcolarPrioridad(colaaux.Primero(), colaaux.Prioridad());
			d.AcolarPrioridad(colaaux.Primero(), colaaux.Prioridad());
			colaaux.Desacolar();
		}
	}

	
	//TRABAJO PRACTICO 2
	
	
	
	// TRABAJO PRACTICO3

	public void ImprimirConjunto(ConjuntoTDA c)
	{
		ConjuntoTDA conjaux = new ConjuntoLD();
		conjaux.InicializarConjunto();
		
		CopiarConjunto(c, conjaux);
		
		while(!conjaux.ConjuntoVacio())
		{
			System.out.println(conjaux.Elegir());
			conjaux.Sacar(conjaux.Elegir());
		}
	}

	//TP 3 1A
	public boolean IsPilaCapicua(PilaTDA p)
	{
			
		PilaTDA pilaaux = new PilaTF();
		pilaaux.InicializarPila();
		PilaTDA pilaaux2 = new PilaTF();
		pilaaux2.InicializarPila();
		
		ColaTDA colaaux = new ColaPU();
		colaaux.InicializarCola();
		
		//copio la pila para no perder la original
		this.CopiarPila(p, pilaaux);
		
		//paso la pila a una cola
		while (!pilaaux.PilaVacia())
		{ 
			colaaux.Acolar(pilaaux.tope()); 
			pilaaux.Desapilar(); 
		}
		
		CopiarPila(p,pilaaux);
		//paso la cola a una pila (para que quede al reves)
		while (!colaaux.ColaVacia())
		{ 
			pilaaux2.Apilar(colaaux.Primero()); 
			colaaux.Desacolar(); 
		}
		
		//verifico si es capicua (comparando los elementos 1 a 1 retornando false cuando hay 1 distinto
		while(!pilaaux.PilaVacia()){
			if(pilaaux.tope()!=pilaaux2.tope())
				return false;
			pilaaux.Desapilar();
			pilaaux2.Desapilar();
		}
		
		return true;
	}
	
	//TP 3 1b
	public void EliminarRepeticiones(PilaTDA p)
	{

		PilaTDA pilaaux = new PilaTF();
		pilaaux.InicializarPila();
		
		ConjuntoTDA c = new ConjuntoLD();
		
		while(!p.PilaVacia())
		{
			if (!c.Pertenece(p.tope()))
			{
				pilaaux.Apilar(p.tope());
				c.Agregar(p.tope());
			}
			p.Desapilar();
		}
			
		this.CopiarPila(pilaaux, p);
	}
	
	//TP 3 1c
	public void DividirPila(PilaTDA p, PilaTDA M1, PilaTDA M2)
	{
		int CantElem=0;
		CantElem = ContarPila(p);
		
		CantElem = CantElem/2;
		
		this.CopiarPila(p, M1);
		//De la original M1, voy a desapilar solamente la mitad, la cual se va a apilar en M2
		while(CantElem!=0)
		{
			M2.Apilar(M1.tope());
			M1.Desapilar();
			CantElem--;
		}
		InvertirPila(M2);
		
	}

	//TP 3 1d
	public ConjuntoTDA ConjElemRep(PilaTDA p)
	{

		PilaLD pilaAux = new PilaLD();
		pilaAux.InicializarPila();
		ConjuntoLD conjAux = new ConjuntoLD();
		conjAux.InicializarConjunto();
		ConjuntoLD ret = new ConjuntoLD();
		ret.InicializarConjunto();
		CopiarPila(p, pilaAux);
		while (!pilaAux.PilaVacia()) {
			if (!conjAux.Pertenece(pilaAux.tope())) {
				ret.Agregar(pilaAux.tope());
			}
			conjAux.Agregar(pilaAux.tope());
			pilaAux.Desapilar();
		}
		return ret;

	}
	
	
	//TP3 2a
	public void EliminarRepeticiones(ColaTDA c)
	{

		ColaTDA colaaux = new ColaPI();
		colaaux.InicializarCola();
		
		ConjuntoTDA conj = new ConjuntoLD();
		
		while(!c.ColaVacia())
		{
			if (!conj.Pertenece(c.Primero()))
			{
				colaaux.Acolar(c.Primero());
				conj.Agregar(c.Primero());
			}
			c.Desacolar();
		}
			
		this.CopiarCola(colaaux, c);
	}

	//TP3 2b
	public void DividirCola(ColaTDA c, ColaTDA M1, ColaTDA M2)
	{
		int CantElem=0;
		//genero cola auxiliar, con esta voy a contar la cantidad de elementos que tiene para luego
		//desacolar solo en la mitad, y acolarla en una cola nueva
		ColaTDA colaaux = new ColaPI();
		colaaux.InicializarCola();
		
		this.CopiarCola(c, colaaux);
		
		//cuento la cantidad de elementos
		while(!colaaux.ColaVacia())
		{
			CantElem++;
			colaaux.Desacolar();
		}
		CantElem = CantElem/2;
		this.CopiarCola(c, M2);
		//De la original M2, voy a desacolar solamente la mitad, la cual se va a acolar en M1
		while(CantElem!=0)
		{
			M1.Acolar(M2.Primero());
			M2.Desacolar();
			CantElem--;
		}
		
	}
	
	//TP 3 2C
		public ConjuntoTDA ConjElemRepCola(ColaTDA c)
		{

			ColaTDA colaAux = new ColaPI();
			colaAux.InicializarCola();
			ConjuntoLD conjAux = new ConjuntoLD();
			conjAux.InicializarConjunto();
			ConjuntoLD ret = new ConjuntoLD();
			ret.InicializarConjunto();
			CopiarCola(c, colaAux);
			while (!colaAux.ColaVacia()) {
				if (!conjAux.Pertenece(colaAux.Primero())) {
					ret.Agregar(colaAux.Primero());
				}
				conjAux.Agregar(colaAux.Primero());
				colaAux.Desacolar();
			}
			return ret;

		}
	
	
	public void CopiarConjunto(ConjuntoTDA o, ConjuntoTDA d)
	{
		ConjuntoTDA aux = new ConjuntoLD();
		aux.InicializarConjunto();

		
		while (!o.ConjuntoVacio())
		{ 
			int elemento = o.Elegir();
			aux.Agregar(elemento);
			d.Agregar(elemento);
			o.Sacar(elemento);
		}
		
		while(!aux.ConjuntoVacio())
		{
			int elemento = aux.Elegir();
			o.Agregar(elemento);
			aux.Sacar(elemento);
		}
		
		
	}
	
	//TP2 Ejercicio 6
	//Union de Conjuntos
	
	public ConjuntoTDA Union(ConjuntoTDA A, ConjuntoTDA B){
		ConjuntoTDA conjaaux = new ConjuntoLD();
		ConjuntoTDA conjbaux = new ConjuntoLD();
		ConjuntoTDA union = new ConjuntoLD();
		conjaaux.InicializarConjunto();
		conjbaux.InicializarConjunto();
		union.InicializarConjunto();
		
		//copio los Conjuntos Originales para que no se pierdan los originales
		this.CopiarConjunto(A, conjaaux);
		this.CopiarConjunto(B, conjbaux);
		
		//primero agrego en el conjunto union el conjunto A
		while(!conjaaux.ConjuntoVacio())
		{
			int elemento = conjaaux.Elegir();
			union.Agregar(elemento);
			conjaaux.Sacar(elemento);
		}
		
		//luego agrego los elemento del conjunto B al conjunto union
		while(!conjbaux.ConjuntoVacio())
		{
			int elemento = conjbaux.Elegir();
			union.Agregar(elemento);
			conjbaux.Sacar(elemento);
		}
		
		return union;
				
	}
	
	//TP2 Ejercicio 6
	//Interseccion de Conjuntos
	public ConjuntoTDA Interseccion(ConjuntoTDA A, ConjuntoTDA B)
	{
		ConjuntoTDA conjaaux = new ConjuntoLD();
		ConjuntoTDA conjbaux = new ConjuntoLD();
		ConjuntoTDA interseccion = new ConjuntoLD();
		conjaaux.InicializarConjunto();
		conjbaux.InicializarConjunto();
		interseccion.InicializarConjunto();
		
		//copio los Conjuntos Originales para que no se pierdan
		this.CopiarConjunto(A, conjaaux);
		this.CopiarConjunto(B, conjbaux);
		
		//tomo los valores del conjunto A, y si pertenecen en B, se agregan al conjunto interseccion
		
		while(!conjaaux.ConjuntoVacio())
		{
			int elemento = conjaaux.Elegir();
			if (conjbaux.Pertenece(elemento))
			{
				interseccion.Agregar(elemento);
			}
			conjaaux.Sacar(elemento);
		}
		//vuelvo a regenerar el conjunto A auxiliar
		this.CopiarConjunto(A, conjaaux);
		
		//tomo los valores del conjunto B, y si pertenecen en A, se agregan al conjunto interseccion
		
		while(!conjbaux.ConjuntoVacio())
		{
			int elemento = conjbaux.Elegir();
			if(conjaaux.Pertenece(elemento))
			{
				interseccion.Agregar(elemento);
			}
			conjbaux.Sacar(elemento);
		}
		
		return interseccion;
	}
	
	//TP2 Ejercicio 6
	//Diferencia de Conjuntos
	public ConjuntoTDA diferenciaConjuntos(ConjuntoTDA A, ConjuntoTDA B)
	{
		ConjuntoTDA conjaaux = new ConjuntoLD();
		ConjuntoTDA conjbaux = new ConjuntoLD();
		ConjuntoTDA diferencia = new ConjuntoLD();
		conjaaux.InicializarConjunto();
		conjbaux.InicializarConjunto();
		diferencia.InicializarConjunto();
		
		
		//copio los Conjuntos Originales para que no se pierdan
		this.CopiarConjunto(A, conjaaux);
		this.CopiarConjunto(B, conjbaux);
		
		
		while(!conjaaux.ConjuntoVacio())
		{
			int elemento = conjaaux.Elegir();
			if(!conjbaux.Pertenece(elemento))
			{
				diferencia.Agregar(elemento);
			}
			conjaaux.Sacar(elemento);
		}
			
		return diferencia;
				
	}
	
	//TP3 3b
	public ConjuntoTDA diferenciaSimetricaSinOperaciones(ConjuntoTDA A, ConjuntoTDA B)
	{ 
		ConjuntoTDA resultado = new ConjuntoLD();
		resultado.InicializarConjunto();
	
		while (!A.ConjuntoVacio())
		{ 
			int elemento = A.Elegir(); 
			if (!B.Pertenece(elemento))
			{ 
				resultado.Agregar(elemento); 
			} 
			else
			{ 
				B.Sacar(elemento); 
			} 
			A.Sacar(elemento); 
		}
		
		while (!B.ConjuntoVacio())
		{ 
			int elemento = B.Elegir();
			resultado.Agregar(elemento); 
			B.Sacar(elemento);
		} 
		return resultado;
	}
	
	//TP3 3C
	public ConjuntoTDA diferenciaSimetricaConOperaciones(ConjuntoTDA A, ConjuntoTDA B)
	{
		ConjuntoTDA difsim = new ConjuntoLD();
		difsim.InicializarConjunto();
		
		difsim = this.Union(this.diferenciaConjuntos(A, B), this.diferenciaConjuntos(B, A));
		return (difsim);
	}
	
	//TP3 3D
	public boolean ConjuntosIguales(ConjuntoTDA A, ConjuntoTDA B)
	{

		//Si dos conjuntos son iguales, la diferencia deberia devolver un conjunto vacio, revisamos eso
		ConjuntoTDA aux = new ConjuntoLD();
		aux.InicializarConjunto();
		
		aux = this.diferenciaConjuntos(A, B);
		
		return (aux.ConjuntoVacio());
	}
	
	//TP3 3E
	public int CardinalidadConjunto(ConjuntoTDA A)
	{
		ConjuntoTDA aux = new ConjuntoLD();
		aux.InicializarConjunto();
		
		int a=0;
		
		this.CopiarConjunto(A, aux);
		
		while(!aux.ConjuntoVacio())
		{
			int elemento = aux.Elegir();
			a=a+1;
			aux.Sacar(elemento);
		}
		
		return a;
	}
	
	//TP3 3F
	public ConjuntoTDA GenerarConjunto(PilaTDA P, ColaTDA C)
	{
		//generamos una pila y una cola auxiliar para evitar destruir las originales
		PilaTDA pilaaux = new PilaTF();
		pilaaux.InicializarPila();
		
		ColaTDA colaaux = new ColaPI();
		colaaux.InicializarCola();
		
		this.CopiarPila(P, pilaaux);
		this.CopiarCola(C, colaaux);
		
		ConjuntoTDA conjuntoaux = new ConjuntoLD();
		conjuntoaux.InicializarConjunto();
		
		//primero agrego elementos de la pila
		while(!pilaaux.PilaVacia())
		{
			conjuntoaux.Agregar(pilaaux.tope());
			pilaaux.Desapilar();
		}
		
		//luego agrego elementos de la cola
		while(!colaaux.ColaVacia())
		{
			conjuntoaux.Agregar(colaaux.Primero());
			colaaux.Desacolar();
		}
		
		return(conjuntoaux);
	}
	
	//TP3 3G
	public boolean IsPilaIgualCola(PilaTDA P, ColaTDA C)
	{
		//generamos una pila y una cola auxiliar para evitar destruir las originales
		PilaTDA pilaaux = new PilaTF();
		pilaaux.InicializarPila();
				
		ColaTDA colaaux = new ColaPI();
		colaaux.InicializarCola();
				
		this.CopiarPila(P, pilaaux);
		this.CopiarCola(C, colaaux);
		
		ConjuntoTDA conjuntoaux = new ConjuntoLD();
		conjuntoaux.InicializarConjunto();
		
		//primero agrego elementos de la pila
		while(!pilaaux.PilaVacia())
		{
			conjuntoaux.Agregar(pilaaux.tope());
			pilaaux.Desapilar();
		}
		
		
		//ahora verificamos que existan todos los elementos de la cola adentro del conjunto, si existen es porque tanto la pila como la cola son iguales
		while(!colaaux.ColaVacia())
		{
			int elemento = colaaux.Primero();
			if (!conjuntoaux.Pertenece(elemento))
				return false;
			
			colaaux.Desacolar();
		}
		return true;
		
	}
	
	//Imprimo Diccionario Multiple
	public void ImprimirDicMult(DiccionarioMultipleTDA D)
	{
		int c;
		DiccionarioMultipleTDA dictaux = new DicMultipleA();
		dictaux.InicializarDiccionario();
		
		ConjuntoTDA claves = new ConjuntoLD();
		claves.InicializarConjunto();
		
		ConjuntoTDA valores = new ConjuntoLD();
		valores.InicializarConjunto();
		
		claves = D.Claves();
		while(!claves.ConjuntoVacio())
		{
			c = claves.Elegir();
			valores = D.Recuperar(c);
			System.out.print("Clave:");
			System.out.print(c);
			while(!valores.ConjuntoVacio())
			{
				System.out.print(" Valor:");
				System.out.println(valores.Elegir());
				valores.Sacar(valores.Elegir());				
			}
			claves.Sacar(c);
		}
	}
	
	//TP3 4a
	public void ColaPrioridadADicMult(ColaPrioridadTDA C, DiccionarioMultipleTDA D)
	{
		//genero cola auxiliar y la copio para no perder la original
		
		ColaPrioridadTDA colaaux = new ColaPrioridadLD();
		colaaux.InicializarCola();
		
		this.CopiarColaPrioridad(C, colaaux);
		
		while(!colaaux.ColaVacia())
		{
			D.Agregar(colaaux.Primero(), colaaux.Prioridad());
			colaaux.Desacolar();
		}
	}
	
	// TP3 5 1.1
	public DiccionarioMultipleTDA UnionDicMult(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2)
	{
		int c,v;
		ConjuntoTDA claves = new ConjuntoLD();
		claves.InicializarConjunto();
		ConjuntoTDA valores = new ConjuntoLD();
		valores.InicializarConjunto();
		
		DiccionarioMultipleTDA resultado = new DicMultipleA();
		resultado.InicializarDiccionario();
		
		claves = D1.Claves();
		
		while(!claves.ConjuntoVacio())
		{
			c = claves.Elegir();
			valores = D1.Recuperar(c);
			while(!valores.ConjuntoVacio())
			{
				v = valores.Elegir();
				resultado.Agregar(c, v);
				valores.Sacar(v);
			}
			claves.Sacar(c);
		}
		
		
		
		claves = D2.Claves();
		
		while(!claves.ConjuntoVacio())
		{
			c = claves.Elegir();
			valores = D2.Recuperar(c);
			while(!valores.ConjuntoVacio())
			{
				v = valores.Elegir();
				resultado.Agregar(c, v);
				valores.Sacar(v);
			}
			claves.Sacar(c);
		}
		
		return resultado;
		
	}
	
	
	//TP3 5 1.2
	public DiccionarioMultipleTDA InterseccionDicMult(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2)
	{
		
		int c,v;
		ConjuntoTDA claves = new ConjuntoLD();
		claves.InicializarConjunto();
		ConjuntoTDA valores = new ConjuntoLD();
		valores.InicializarConjunto();
		
		DiccionarioMultipleTDA resultado = new DicMultipleA();
		resultado.InicializarDiccionario();
		
		claves = this.Union(D1.Claves(), D1.Claves());
		
		while(!claves.ConjuntoVacio())
		{
			c = claves.Elegir();
			valores = this.Interseccion(D1.Recuperar(c), D2.Recuperar(c));
			while(!valores.ConjuntoVacio())
			{
				v = valores.Elegir();
				resultado.Agregar(c, v);
				valores.Sacar(v);
			}
			claves.Sacar(c);
		}
		
		return resultado;
	}
	
	
	//TP3 5 1.3
	public DiccionarioMultipleTDA InterseccionClavesDicMult(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2)
	{
		
		int c,v;
		ConjuntoTDA claves = new ConjuntoLD();
		claves.InicializarConjunto();
		ConjuntoTDA valores = new ConjuntoLD();
		valores.InicializarConjunto();
		
		DiccionarioMultipleTDA resultado = new DicMultipleA();
		resultado.InicializarDiccionario();
		
		claves = this.Interseccion(D1.Claves(), D1.Claves());
		
		while(!claves.ConjuntoVacio())
		{
			c = claves.Elegir();
			valores = this.Union(D1.Recuperar(c), D1.Recuperar(c));
			while(!valores.ConjuntoVacio())
			{
				v = valores.Elegir();
				resultado.Agregar(c, v);
				valores.Sacar(v);
			}
			claves.Sacar(c);
		}
		
		return resultado;
	}
	
	//TP3 5 1.4
	public DiccionarioMultipleTDA InterseccionClavesyValoresDicMult(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2)
	{
		
		int c,v;
		ConjuntoTDA claves = new ConjuntoLD();
		claves.InicializarConjunto();
		ConjuntoTDA valores = new ConjuntoLD();
		valores.InicializarConjunto();
		
		DiccionarioMultipleTDA resultado = new DicMultipleA();
		resultado.InicializarDiccionario();
		
		claves = this.Interseccion(D1.Claves(), D1.Claves());
		
		while(!claves.ConjuntoVacio())
		{
			c = claves.Elegir();
			valores = this.Interseccion(D1.Recuperar(c), D1.Recuperar(c));
			while(!valores.ConjuntoVacio())
			{
				v = valores.Elegir();
				resultado.Agregar(c, v);
				valores.Sacar(v);
			}
			claves.Sacar(c);
		}
		
		return resultado;
	}
	
	//TP3 5.2
	
	public DiccionarioMultipleTDA DiccionarioMultipleDS(DiccionarioSimpleTDA D)
	{
		int c,v;
		ConjuntoTDA conjaux = new ConjuntoLD();
		conjaux.InicializarConjunto();
		
		DiccionarioMultipleTDA resultado = new DicMultipleA();
		resultado.InicializarDiccionario();
		
		conjaux = D.Claves();
		while(!conjaux.ConjuntoVacio())
		{
			c=conjaux.Elegir();
			v=D.Recuperar(c);
			resultado.Agregar(v, c);
			conjaux.Sacar(c);
		}
		return resultado;
	}
	
	
	
	
	
	//////TP4
	
	
	
	
	
	
	// Arboles
	public void preOrder(ABBTDA a) {
		if (!a.ArbolVacio()) {
			System.out.println(a.Raiz());
			preOrder(a.HijoIzq());
			preOrder(a.HijoDer());
		}
	}
	
	public void inOrder(ABBTDA a) {
		if (!a.ArbolVacio()) {
			inOrder(a.HijoIzq());
			System.out.println(a.Raiz());
			inOrder(a.HijoDer());
		}
	}
	
	public void postOrder(ABBTDA a) {
		if (!a.ArbolVacio()) {
			postOrder(a.HijoIzq());
			postOrder(a.HijoDer());
			System.out.println(a.Raiz());
		}
	}
	
	// Metodo para cargar un conjunto siempre que los valores del arbol sean mayor que K
	public ConjuntoTDA cargarConjunto(ABBTDA arbol, int k) {
		conjuntoAux = new ConjuntoLD();
		conjuntoAux.InicializarConjunto();
		cConjunto(arbol, k);
		return conjuntoAux;
	}
	
	// Metodo auxiliar recursivo para la carga del conjunto enviado desde cargarConjunto()
	private void cConjunto(ABBTDA arbol, int k) {
		if (!arbol.ArbolVacio()) {
			if (arbol.Raiz()>k)
				conjuntoAux.Agregar(arbol.Raiz());
			cConjunto(arbol.HijoDer(), k);
			cConjunto(arbol.HijoIzq(), k);
		}
	}
	
	// Buscar el valor inmediatamente anterior a k en un arbol
	public int valorAnterior(ABBTDA arbol, int k) {
		aux = k;
		valAnterior (arbol, k);
		return aux;
	}
	
	private void valAnterior(ABBTDA arbol, int k) {
		if (!arbol.ArbolVacio()) {
			if (!arbol.HijoDer().ArbolVacio() && arbol.HijoDer().Raiz()==k)
				aux = arbol.Raiz();
			if (!arbol.HijoIzq().ArbolVacio() && arbol.HijoIzq().Raiz()==k)
				aux = arbol.Raiz();
			valAnterior(arbol.HijoDer(),k);
			valAnterior(arbol.HijoIzq(),k);			
		}
	}
	
	public boolean verificaABBElementosIguales(ABBTDA a, ABBTDA b) {
		// Siempre que sean identicos entra en este if
		if (!a.ArbolVacio() && !b.ArbolVacio() && a.Raiz() == b.Raiz()) {
			return ( (verificaABBElementosIguales(a.HijoDer(), b.HijoDer()) && 
					verificaABBElementosIguales(a.HijoIzq(), b.HijoIzq())));
		}				
		else // si llego al final devuelve true ya que son identicos hasta el final, si hay diferencias devuelve false
			return (a.ArbolVacio() && b.ArbolVacio());
	}
	
	public boolean verificaABBIguales(ABBTDA a, ABBTDA b) {
		// Siempre que sean identicos entra en este if
		if (!a.ArbolVacio() && !b.ArbolVacio()) {
			return ( (verificaABBIguales(a.HijoDer(), b.HijoDer()) && verificaABBIguales(a.HijoIzq(), b.HijoIzq())));
		}				
		else // si llego al final devuelve true ya que son identicos hasta el final, si hay diferencias devuelve false
			return (a.ArbolVacio() && b.ArbolVacio());
	}
	
	public int Contar(ABBTDA a) {
		if (a.ArbolVacio()) {
			return 0;
		} else {
			return (1+Contar(a.HijoIzq()) + Contar(a.HijoDer()));
		}
	}
	
	public int sumarElementos(ABBTDA a) {
		if (a.ArbolVacio())
			return 0;
		else 
			return (a.Raiz()+sumarElementos(a.HijoDer()) + sumarElementos(a.HijoIzq()));
	}
	
	public int contarHojas(ABBTDA a) {
		if (a.ArbolVacio())
			return 0;
		else if (a.HijoDer().ArbolVacio() && a.HijoIzq().ArbolVacio())
			return 1 + contarHojas(a.HijoDer()) + contarHojas(a.HijoIzq());
		else
			return contarHojas(a.HijoDer()) + contarHojas(a.HijoIzq());

	}
	
	public int alturaArbol(ABBTDA a) {
		altura = 0;
		if (!a.ArbolVacio())
			alturaArbol(a,1);
		return altura;
	}
	
	public void alturaArbol(ABBTDA a, int nivel) {
		if (!a.ArbolVacio()) {
			alturaArbol(a.HijoDer(),nivel+1);
			if (nivel>altura)
				altura = nivel;
			alturaArbol(a.HijoIzq(), nivel+1);
		}
	}
	
	public int elementosNivelArbol(ABBTDA a, int nivel) {
		altura = nivel;
		
		if (!a.ArbolVacio())
			nivelArbol(a, 1);
		return counter;
	}
	
	public void nivelArbol(ABBTDA a, int nivel) {
		if (!a.ArbolVacio()) {
			nivelArbol(a.HijoDer(), nivel+1);
			if (nivel==altura)
				counter++;
			nivelArbol(a.HijoIzq(),nivel+1);
		}
	}
	
	public boolean existeElementoEnABB(ABBTDA t, int x) {
		if (t.ArbolVacio()) {
			return false;
		} else if (t.Raiz() == x) {
			return true;
		} 
		else if (t.Raiz() > x) {
			return this.existeElementoEnABB(t.HijoIzq(), x);
		} else 
			return this.existeElementoEnABB(t.HijoDer(),x);
	}
	
	public int calcularProfundidad(ABBTDA t, int x) {
		if (t.ArbolVacio()) {
			return 0;
		}
		else if (t.Raiz() == x) {
			return 0;
		} else if (t.Raiz() >x) {
			return (1+this.calcularProfundidad(t.HijoIzq(), x));
		} else 
			return (1+this.calcularProfundidad(t.HijoDer(), x));
	}
	
	
	public boolean esHoja(ABBTDA a, int x) {
		if (a.ArbolVacio())
			return false;
		else if ( a.Raiz() == x && a.HijoDer().ArbolVacio() && a.HijoDer().ArbolVacio()) {
			return true;
		} else if (a.Raiz() > x)
			return this.esHoja(a.HijoIzq(), x);
		else
			return this.esHoja(a.HijoDer(), x);
	}
	
	public int mayor(ABBTDA a) {
		if (a.HijoDer().ArbolVacio())
			return a.Raiz();
		else 
			return mayor(a.HijoDer());
	}
	
	public int menor(ABBTDA a) {
		if (a.HijoIzq().ArbolVacio())
			return a.Raiz();
		else
			return menor(a.HijoIzq());
	}
	
	
	
	
	//////TP6
	
	//TP 5 Ejercicio 4
	public ConjuntoTDA VerticesAdyacentesDobles(GrafoTDA grafo, int vert) {
		int x, y;
		ConjuntoTDA ret = new ConjuntoLD();
		ret.InicializarConjunto();
		ConjuntoTDA aux1 = grafo.Vertices();
		aux1.Sacar(vert);
		ConjuntoTDA aux2 = grafo.Vertices();
		while (!aux1.ConjuntoVacio()) {
			x = aux1.Elegir();
			aux2.Sacar(vert);
			aux2.Sacar(x);
			if (grafo.ExisteArista(vert, x)) {
				while (!aux2.ConjuntoVacio()) {
					y = aux2.Elegir();
					if (grafo.ExisteArista(x, y))
						ret.Agregar(y);
					aux2.Sacar(y);
				}
			aux2 = grafo.Vertices();
			}
			aux1.Sacar(x);
		}
		return ret;
	}

	//TP 5 Ejercicio 5
	public int AristaMayor(GrafoTDA grafo, int vert) {
		int ret = 0;
		int x;
		ConjuntoTDA conj = grafo.Vertices();
		while (!conj.ConjuntoVacio()) {
			x = conj.Elegir();
			if (grafo.ExisteArista(vert, x))
				if (grafo.PesoArista(vert, x) > ret)
					ret = grafo.PesoArista(vert, x);
			conj.Sacar(x);
		}

		return ret;
	}

	//TP 5 Ejercicio 6
	public ConjuntoTDA ConjuntoVertPredecesores(GrafoTDA grafo, int vert) {
		int x;
		ConjuntoTDA ret = new ConjuntoLD();
		ret.InicializarConjunto();
		ConjuntoTDA aux = grafo.Vertices();
		while (!aux.ConjuntoVacio()) {
			x = aux.Elegir();
			if (grafo.ExisteArista(x, vert))
				ret.Agregar(x);
			aux.Sacar(x);
		}
		return ret;
	}
	//TP 5 Ejercicio 7
	public ConjuntoTDA ConjuntoVertAislados(GrafoTDA grafo) {
		int x, y;
		boolean aislado = true;
		ConjuntoTDA ret = new ConjuntoLD();
		ret.InicializarConjunto();
		ConjuntoTDA aux1 = grafo.Vertices();
		ConjuntoTDA aux2 = grafo.Vertices();
		while (!aux1.ConjuntoVacio()) {
			x = aux1.Elegir();
			while (!aux2.ConjuntoVacio() && aislado) {
				y = aux2.Elegir();
				if (grafo.ExisteArista(x, y) || grafo.ExisteArista(y, x))
					aislado = false;
				aux2.Sacar(y);
			}
			if (aislado)
				ret.Agregar(x);
			aux1.Sacar(x);
			aux2 = grafo.Vertices();
			aislado = true;
		}
		return ret;
	}
	
	//TP 5 Ejercicio 8
	public ConjuntoTDA ConjuntoVertPuente(GrafoTDA grafo, int vert1, int vert2) {
		int x;
		ConjuntoTDA ret = new ConjuntoLD();
		ret.InicializarConjunto();
		ConjuntoTDA aux = grafo.Vertices();
		aux.Sacar(vert1);
		aux.Sacar(vert2);
		while (!aux.ConjuntoVacio()) {
			x = aux.Elegir();
			if (grafo.ExisteArista(vert1, x))
				if (grafo.ExisteArista(x, vert2))
					ret.Agregar(x);
			aux.Sacar(x);
		}
		return ret;
	}

	//TP 5 Ejercicio 9
	public int CalcularGradoVertice(GrafoTDA grafo, int vert) {
		int ret = 0;
		int x;
		ConjuntoTDA conj = grafo.Vertices();
		while (!conj.ConjuntoVacio()) {
			x = conj.Elegir();
			if (grafo.ExisteArista(vert, x))
				ret++;
			if (grafo.ExisteArista(x, vert))
				ret--;
			conj.Sacar(x);
		}
		return ret;
	}

	
}




