package estados.Comprable;

import estados.EstadoCasillero;
import modelo.Jugador.Jugador;
import vista.eventos.mensajescasillero.Mensaje;

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

	public int getCostoPase(Jugador unJugador){ return 0;}


	public void reembolsar(){
		estado.reembolsar();
	}

	public String getNombre(){return "";}

	public void mensajeEfecto(Jugador unJugador){

	}

	public String getMensaje(Jugador unJugador){
		return estado.getMensaje(unJugador);
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
