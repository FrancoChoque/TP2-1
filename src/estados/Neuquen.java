package estados;

import modelo.Jugador;

public class Neuquen extends Propiedad {
	private int precioCompra = 17000;
	private int precioAlquiler = 1800;
	
	@Override
	public void pagarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1); 
	}
}
