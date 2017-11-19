package estados;

import modelo.Jugador.Jugador;

public abstract class EstadoCasillero {

	public abstract void hacerEfectoDelCasillero(Jugador unJugador);

	public abstract boolean esComprable();



}
