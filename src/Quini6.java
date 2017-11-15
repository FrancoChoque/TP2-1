

import java.util.HashMap;

public class Quini6 extends Suerte {
	private HashMap<Jugador,Integer> numeroDeVecesEnQuini;
	
	public Quini6(){
		this.numeroDeVecesEnQuini = new HashMap<Jugador,Integer>();
	}
	
	public void agregarJugador(Jugador unJugador){
		numeroDeVecesEnQuini.put(unJugador, 0);
	}
	
	public int cantidadDevecesQueCalloJugador(Jugador unJugador){
		
		return this.numeroDeVecesEnQuini.get(unJugador);
	}
	
	public void hacerEfectoDelCasillero(Jugador unJugador){
		if(!numeroDeVecesEnQuini.containsKey(unJugador) ) {
			numeroDeVecesEnQuini.put(unJugador, 0);
		}
		int cantidadVeces = numeroDeVecesEnQuini.get(unJugador);
		cantidadVeces++;
		numeroDeVecesEnQuini.put(unJugador, cantidadVeces);
		switch (cantidadVeces){
		case	1:
			unJugador.sumarDinero(50000);
			break;
		case	2:
			unJugador.sumarDinero(30000);
			break;
		default:
			break;
		}
	}
}
