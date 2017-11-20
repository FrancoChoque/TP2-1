package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import modelo.Jugador.Jugador;
import modelo.Tablero;

;

public class BuenosAiresSur extends Propiedad {

	public int getPrecioCompra(){ return 20000; }

	public int getValorCasa(){ return 5000; }

	public int getValorHotel(){ return 8000; }

	public int getCostoAlquiler(){ return 2000; }

	public int getCostoAlquilerConCasa(){ return 3000;}

	public int getCostoAlquilerConDosCasas(){ return 3500;}

	public int getCostoAlquilerConHotel(){ return 5000;}


	public void hacerCasa(Jugador unJugador){

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getBuenosAiresNorte())) return;// throw new JugadorNoTieneTerreno();

		if(edificios.size()>1)return; //throw capacidad maxima


	}

	public void hacerHotel(Jugador unJugador){

		Tablero tablero = Tablero.getInstance();

		if(tablero.getBuenosAiresNorte().getCantidadEdificios() < 2) return;

		if(!unJugador.esDuenio(tablero.getBuenosAiresNorte())) return;

		unJugador.sumarDinero(getValorHotel() * -1);


	}

	
}
