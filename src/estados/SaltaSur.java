package estados;

import modelo.Jugador.Jugador;

public class SaltaSur extends Propiedad {
	private int precioCompra = 23000;
	private int precioAlquiler = 2000;
	private int precioCasa = 4500;
	private int precioHotel = 7500;
	
	@Override
	public void cobrarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1); 
	}
}
