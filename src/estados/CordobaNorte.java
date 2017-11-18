package estados;

import modelo.Jugador.Jugador;

public class CordobaNorte extends Propiedad {
	private int precioCompra = 20000;
	private int precioAlquiler = 1300;
	private int precioCasa = 2200;
	private int precioHotel = 3500;


	public void cobrarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1);
	}

}
