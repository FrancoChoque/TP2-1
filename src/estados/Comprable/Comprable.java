package estados.Comprable;

import estados.EstadoCasillero;
import modelo.Jugador.Jugador;

public class Comprable extends EstadoCasillero {
	
	protected Jugador Duenio;
	boolean tieneDuenio;

	public Comprable(){

		tieneDuenio = false;
	}


	public void hacerEfectoDelCasillero(Jugador unJugador) {
		if(!tieneDuenio) return;
		cobrarPase(unJugador);
	}

	public void cambiarDuenio(Jugador jugador){
		Duenio = jugador;
	}

	public Jugador preguntarDuenio(){
		return Duenio;
	}

	public boolean tieneDuenio(){
		return tieneDuenio;
	}


	public void comprar(Jugador unjugador){

	}

	public void cobrarPase(Jugador unJugador){

	}

	public boolean esComprable(){
		return true;
	}



}
