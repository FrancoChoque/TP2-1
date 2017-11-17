package estados;

import modelo.Jugador;

public class Comprable extends EstadoCasillero{
	
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
	
	public void pagarCompra(Jugador jugador) {
		// TODO Auto-generated method stub
	}
	
}
