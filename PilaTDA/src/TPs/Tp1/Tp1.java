package TPs.Tp1;

import api.PilaTDA;
import impl.PilaTF;

public class Tp1 {

		public void PasarPila(PilaTDA o, PilaTDA d){
			while( !o.PilaVacia() ) {
				
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
}
