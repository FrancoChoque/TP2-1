package estados;

import modelo.Jugador.Jugador;

public class CordobaSur extends Propiedad {
	private int precioCompra = 18000;
	private int precioAlquiler = 1000;
	private int precioCasa = 2000;
	private int precioHotel = 3000;
	
	@Override
	public void cobrarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1); 
	}
}
