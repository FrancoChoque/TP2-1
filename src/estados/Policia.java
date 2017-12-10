package estados;

import modelo.Jugador.Jugador;
import modelo.Tablero;
import vista.eventos.mensajescasillero.Mensaje;

public class Policia extends Movimiento {

	private Tablero tablero;

	public Policia(Tablero untablero) {
		tablero = untablero;
	}


	@Override
	public void hacerEfectoDelCasillero(Jugador unjugador) {
		tablero.moverJugador(unjugador, 10);
	}


	public boolean esComprable() {
		return false;
	}

	public String getNombre(){
		return "Policia";
	}

	public String getMensaje(Jugador unJugador){
		return "Marche a la carcel";
	}

	public void mensajeEfecto(Jugador unJugador){
		Mensaje mensaje = new Mensaje();

		mensaje.mensajeEfecto(unJugador,this);
	}
}
