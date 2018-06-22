package librerias;

import api.PilaTDA;
import api.ColaPrioridadTDA;
import api.ColaTDA;
import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import api.DiccionarioSimpleTDA;
import impl.PilaTF;
import impl.PilaTI;
import impl.ColaPU;
import impl.ColaPI;
import impl.ColaPrioridadAO;
import impl.ColaPrioridadDA;
import impl.ColaPrioridadLD;
import impl.ConjuntoLD;
import impl.DicSimpleA;
import impl.DicMultipleA;

public class Utilidades {

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
		while (!p.PilaVacia()){ 
			suma = suma + p.tope(); 
			p.Desapilar(); 
			} 
		return suma;
	} 
	public float CalcularPromedioPila(PilaTDA p)
	{ 
		int suma = 0;
		int cantidad = 0;
		float promedio = 0;
		suma = SumarElementosPila(p);
		cantidad = ContarPila(p);
		promedio = suma/cantidad;
		return promedio;
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


	//TP 3 1A
	public boolean IsPilaCapicua(PilaTDA p)
	{
			
		PilaTDA pilaaux = new PilaTF();
		pilaaux.InicializarPila();
		
		ColaTDA colaaux = new ColaPI();
		colaaux.InicializarCola();
		
		//copio la pila para no perder la original
		this.CopiarPila(p, pilaaux);
		
		//paso la pila a una cola
		while (!pilaaux.PilaVacia())
		{ 
			colaaux.Acolar(pilaaux.tope()); 
			pilaaux.Desapilar(); 
		}
		
		//verifico si es capicua (comparando los elementos 1 a 1 retornando false cuando hay 1 distinto
		while(!colaaux.ColaVacia()){
			if(pilaaux.tope()!=colaaux.Primero())
				return false;
				
			pilaaux.Desapilar();
			colaaux.Desacolar();
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
	public void DividirPila(PilaTDA p)
	{
		int CantElem=0;
		//genero pila auxiliar, con esta voy a contar la cantidad de elementos que tiene para luego
		//desapilar solo en la mitad, y apilarla en una pila nueva
		PilaTDA pilaaux = new PilaTF();
		pilaaux.InicializarPila();
		
		PilaTDA M1 = new PilaTF();
		M1.InicializarPila();
		
		PilaTDA M2 = new PilaTF();
		M2.InicializarPila();
		
		this.CopiarPila(p, pilaaux);
		
		//cuento la cantidad de elementos
		while(!pilaaux.PilaVacia())
		{
			CantElem++;
			pilaaux.Desapilar();
		}
		CantElem = CantElem/2;
		
		this.CopiarPila(p, M1);
		//De la original M1, voy a desapilar solamente la mitad, la cual se va a apilar en M2
		while(CantElem!=0)
		{
			M2.Apilar(M1.tope());
			M1.Desapilar();
			CantElem--;
		}
		
	}

	//TP 3 1d
	public void ConjElemRep(PilaTDA p)
	{

		// pasar pila a un diccionario simple
		//la clave es el elemento de la pial
		// a medida que voy agregando, voy viendo si ya existe la clave, y si existe, voy 
		// incrementando el valor
		//una vez finalizado, pido la lista de claves de ese diccionario
		//lo recorro, y elimino del diccionario todos los que tengan clave 1
		//una vez finalizado, paso el diccionario a un conjunto
		
		PilaTDA pilaaux = new PilaTF();
		pilaaux.InicializarPila();
		
		DiccionarioSimpleTDA dict = new DicSimpleA();
		dict.InicializarDiccionario();
		
		this.CopiarPila(p, pilaaux);
		

		
		while(!pilaaux.PilaVacia())
		{
			ConjuntoTDA claves = dict.Claves();
			int valor;
			if(claves.Pertenece(pilaaux.tope()))//reviso si existe la clave con el valor del tope de la pila
			{
				valor = dict.Recuperar(pilaaux.tope());
				valor++;
				dict.Agregar(pilaaux.tope(), valor);
			}
			else
			{
				dict.Agregar(pilaaux.tope(), 1);
			}
			pilaaux.Desapilar();
		}
		//ahora tengo un diccionario dict donde tengo las claves y valores, elimino lo de valor 1
		ConjuntoTDA claves = dict.Claves();
		while(!claves.ConjuntoVacio())
		{
			if(dict.Recuperar(claves.Elegir()) == 1)
			{
				dict.Eliminar(claves.Elegir());
			}
			claves.Sacar(claves.Elegir());
		}
		
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
	public void DividirCola(ColaTDA c)
	{
		int CantElem=0;
		//genero cola auxiliar, con esta voy a contar la cantidad de elementos que tiene para luego
		//desacolar solo en la mitad, y acolarla en una cola nueva
		ColaTDA colaaux = new ColaPI();
		colaaux.InicializarCola();
		
		ColaTDA M1 = new ColaPI();
		M1.InicializarCola();
		
		ColaTDA M2 = new ColaPI();
		M1.InicializarCola();
		
		this.CopiarCola(c, colaaux);
		
		//cuento la cantidad de elementos
		while(!colaaux.ColaVacia())
		{
			CantElem++;
			colaaux.Desacolar();
		}
		CantElem = CantElem/2;
		this.CopiarCola(c, M1);
		//De la original M1, voy a desacolar solamente la mitad, la cual se va a acolar en M2
		while(CantElem!=0)
		{
			M2.Acolar(M1.Primero());
			M1.Desacolar();
			CantElem--;
		}
		
	}
	
	//TP3 2c
	//NO LO HICE, es caso copia del 1D
	
	
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
}




