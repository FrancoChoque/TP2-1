package estados;

import modelo.Jugador.Jugador;

public class SantaFe extends Propiedad {
	private int precioCompra = 15000;
	private int precioAlquiler = 1500;
	private int precioCasa = 4000;

	
	@Override
	public void pagarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1); 
	}
}
