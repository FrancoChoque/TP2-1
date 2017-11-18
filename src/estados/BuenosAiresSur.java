package estados;

import modelo.Jugador.*;

;

public class BuenosAiresSur extends Propiedad {
	private int precioCompra = 20000;
	private int precioAlquiler = 2000;
	private int valorCasa = 5000;
	private int valorHotel = 8000;


	@Override
	public void cobrarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1);
	}
	
}
