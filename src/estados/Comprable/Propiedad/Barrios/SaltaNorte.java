package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import modelo.Jugador.Jugador;
import modelo.Tablero;

public class SaltaNorte extends Propiedad {

	public int getPrecioCompra(){ return 23000; }

	public int getValorCasa(){ return 4500; }

	public int getValorHotel(){ return 7500; }

	public int getCostoAlquiler(){ return 2000; }

	public int getCostoAlquilerConCasa(){ return 3250;}

	public int getCostoAlquilerConDosCasas(){ return 3850;}

	public int getCostoAlquilerConHotel(){ return 5500;}




	public void hacerCasa(Jugador unJugador){

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getSaltaSur()))// throw new JugadorNoTieneTerreno();

			if(edificios.size()>1)return;


	}

	public void hacerHotel(Jugador unJugador){

		Tablero tablero = Tablero.getInstance();

		if(tablero.getSaltaSur().getCantidadEdificios() < 2) return;

		if(!unJugador.esDuenio(tablero.getSaltaSur())) return;

		unJugador.sumarDinero(getValorHotel() * -1);

	}

}
