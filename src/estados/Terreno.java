package estados;


import excepciones.*;
import modelo.Jugador;

public class Terreno extends Estado implements Comprable{

	private Jugador propietario = null;

	public boolean tieneDuenio() {
		return propietario != null;
	}

	@Override
	public boolean esComprable() {
		return true;
	}
	
	public void cambiarDuenio(Jugador jugador) {
		propietario = jugador;
	}

	@Override
	public Jugador preguntarDuenio() {
		return propietario;
	}

	@Override
	public void hacerEfectoDelCasillero(Jugador unjugador) {
		unjugador.comprarTerreno(this);
	}


	public void pagarCompra(Jugador jugador) {
		// TODO Auto-generated method stub
	}

}
