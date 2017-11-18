package modelo;

import estados.EstadoCasillero;
import modelo.Jugador.Jugador;

public class Casillero {
	
	private EstadoCasillero estadoCasillero;
	
	public Casillero(){
	}
	
	public void setEstadoCasillero(EstadoCasillero unestado) {
		estadoCasillero = unestado;
	}
	
	
	public Casillero (EstadoCasillero unestado) {
		estadoCasillero = unestado;
	}
	
	public String getPropietario() {
		return "a";
	}

	public void hacerEfectoDelCasillero(Jugador unJugador){
		estadoCasillero.hacerEfectoDelCasillero(unJugador);
	}

	public EstadoCasillero getestado() {
		// TODO Auto-generated method stub
		return estadoCasillero;
	}


}
