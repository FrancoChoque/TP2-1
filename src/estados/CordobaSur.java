package estados;

import modelo.Jugador;

public class CordobaSur extends Propiedad {
	private int precioCompra = 18000;
	private int precioAlquiler = 1000;
	
	@Override
	public void pagarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1); 
	}
}
