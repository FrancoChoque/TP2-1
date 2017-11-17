package estados;

import modelo.Jugador;

public class CordobaNorte extends Propiedad {
	private int precioCompra = 20000;
	private int precioAlquiler = 1300;


	public void pagarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1);
	}

}
