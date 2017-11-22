package estados.Comprable;

import estados.EstadoCasillero;
import modelo.Jugador.Jugador;

public class Comprable extends EstadoCasillero {
	
	protected Jugador Duenio;


	ComprableEstado noTieneDuenio;
	ComprableEstado tieneDuenio;
	ComprableEstado estado;

	public Comprable(){

		noTieneDuenio = new ComprableNoTieneDuenio(this);
		tieneDuenio = new ComprableTieneDuenio(this);
		estado = noTieneDuenio;
	}


	public void hacerEfectoDelCasillero(Jugador unJugador) {
		estado.hacerEfectoDelCasillero(unJugador);
	}

	public void comprar(Jugador unjugador){
		estado.comprar(unjugador);
	}

	public void cobrarPase(Jugador unJugador){
		estado.cobrarPase(unJugador);
	}


	public void reembolsar(){
		estado.reembolsar();
	}


	public Jugador getDuenio(){
		return estado.getDuenio();
	}

	public boolean tieneDuenio(){
		return estado.tieneDuenio();
	}

	public int getPrecioCompra(){
		return 0;
	}


	public boolean esComprable() {
		return true;
	}


	public ComprableEstado getEstado() {
		return estado;
	}

	public ComprableEstado getNoTieneDuenio() {
		return noTieneDuenio;
	}

	public ComprableEstado getTieneDuenio() {
		return tieneDuenio;
	}

	public void setDuenio(Jugador duenio) {
		Duenio = duenio;
	}

	public void setEstado(ComprableEstado estado) {
		this.estado = estado;
	}


}
