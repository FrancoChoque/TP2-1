package estados;

import modelo.Jugador.Jugador;

public class BuenosAiresNorte extends Propiedad {
	private int precioCompra = 25000;
	private int precioAlquiler = 2500;
	private int precioCasa = 5500;
	private int precioHotel = 9000;
	
	@Override
	public void pagarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1); 
	}
}
