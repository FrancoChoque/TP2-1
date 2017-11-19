package estados.Comprable;

import estados.EstadoCasillero;
import modelo.Jugador.Jugador;

public class Comprable extends EstadoCasillero {
	
	protected Jugador Duenio;
	private ComprableEstado comprableNoTieneDuenio;
	private ComprableEstado comprableTieneDuenio;
	private ComprableEstado comprableEstado;


	public Comprable(){

		comprableNoTieneDuenio = new ComprableNoTieneDuenio(this);
		comprableTieneDuenio = new ComprableTieneDuenio(this);
		comprableEstado = comprableNoTieneDuenio;
	}

	public void cambiarDuenio(Jugador unJugador){
		comprableEstado.cambiarDuenio(unJugador);
	}
	
	public Jugador preguntarDuenio(){
		return comprableEstado.preguntarDuenio();
	}
	
	public boolean tieneDuenio(){
		return comprableEstado.tieneDuenio();
	}

	public void comprar(Jugador unJugador){
		comprableEstado.comprar(unJugador);
	}

	public void cobrarPase(Jugador unJugador){
		comprableEstado.cobrarPase(unJugador);
	}


	public void setComprableEstado(ComprableEstado comprableEstado) { this.comprableEstado = comprableEstado; }

	public ComprableEstado getComprableEstado() { return comprableEstado; }

	public ComprableEstado getComprableNoTieneDuenio() {return comprableNoTieneDuenio; }

	public ComprableEstado getComprableTieneDuenio() { return comprableTieneDuenio; }




	public void setDuenio(Jugador unJugador){ this.Duenio = unJugador; }

	public Jugador getDuenio(){ return this.Duenio; }

	public boolean esComprable(){ return comprableEstado.esComprable(); }

	public void hacerEfectoDelCasillero(Jugador unJugador){

		comprableEstado.hacerEfectoDelCasillero(unJugador);
	}


}
