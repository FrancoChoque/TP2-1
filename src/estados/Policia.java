package estados;

import modelo.Jugador.Jugador;
import modelo.Tablero;

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

	public String mensajeEfecto(Jugador unJugador){
		return "Marche a la carcel";
	}
}
