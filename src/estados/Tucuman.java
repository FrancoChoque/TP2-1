package estados;

import modelo.Jugador.Jugador;

public class Tucuman extends Propiedad {
	private int precioCompra = 25000;
	private int precioAlquiler = 2500;
	private int precioHotel = 7000;

	@Override
	public void pagarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1); 
	}
}
