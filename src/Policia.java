

public class Policia extends Estado {
	
	private Tablero tablero;
	
	public Policia(Tablero untablero) {
		tablero = untablero;
	}
	
	
	@Override
	public void hacerEfectoDelCasillero(Jugador unjugador) {
		tablero.moverJugador(unjugador, 10);
	}
}
