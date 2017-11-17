package estados;

import modelo.Jugador;

public class SaltaNorte extends Propiedad {
	private int precioCompra = 23000;
	private int precioAlquiler = 2000;
	
	@Override
	public void pagarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1); 
	}
}
