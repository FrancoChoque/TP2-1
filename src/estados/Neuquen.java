package estados;

import modelo.Jugador.Jugador;

public class Neuquen extends Propiedad {
	private int precioCompra = 17000;
	private int precioAlquiler = 1800;
	private int precioCasa = 4800;

	
	@Override
	public void cobrarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1); 
	}
}
