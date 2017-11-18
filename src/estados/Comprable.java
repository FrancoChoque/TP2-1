package estados;

import modelo.Jugador.Jugador;

public abstract class Comprable extends EstadoCasillero{
	
	private Jugador Duenio;

	
	public void cambiarDuenio(Jugador jugador) {
		Duenio = jugador;
	}
	
	public Jugador preguntarDuenio() {
		return Duenio;
	}
	
	public boolean tieneDuenio() {
		return Duenio != null;
	}

    public void pagarCompra(Jugador unjugador) {

    }

	public abstract void cobrarPorPasar(Jugador jugadpr);
	
}
