package estados;

import modelo.Jugador;

;

public class BuenosAiresSur extends Terreno{
	private int precioCompra = 20000;
	
	@Override
	public void pagarCompra(Jugador unjugador) {
		unjugador.sumarDinero(precioCompra * -1); 
	}
	
}
