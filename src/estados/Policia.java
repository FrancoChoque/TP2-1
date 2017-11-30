package estados;

import modelo.Jugador.Jugador;
import modelo.Tablero;

public class Policia extends EstadoCasillero {
	
	private Tablero tablero;
	
	public Policia(Tablero untablero) {
		tablero = untablero;
	}
	
	
	@Override
	public void hacerEfectoDelCasillero(Jugador unjugador) {
		tablero.moverJugador(unjugador, 10);
	}

	@Override
	public boolean esComprable() {
		return false;
	}

	public String getNombre(){
		return "Policia";
	}
}
