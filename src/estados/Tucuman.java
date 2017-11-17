package estados;

import modelo.Jugador;

public class Tucuman extends Propiedad {
	private int precioCompra = 25000;
	private int precioAlquiler = 2500;
	
	@Override
	public void pagarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1); 
	}
}
