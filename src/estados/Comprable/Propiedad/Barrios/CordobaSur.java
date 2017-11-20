package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import modelo.Jugador.Jugador;
import modelo.Tablero;

public class CordobaSur extends Propiedad {

	public int getPrecioCompra(){ return 18000; }

	public int getValorCasa(){ return 2000; }

	public int getValorHotel(){ return 3000; }

	public int getCostoAlquiler(){ return 1000; }

	public int getCostoAlquilerConCasa(){ return 1500;}

	public int getCostoAlquilerConDosCasas(){ return 2500;}

	public int getCostoAlquilerConHotel(){ return 3000;}



	public void hacerCasa(Jugador unJugador){

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getCordobaNorte()))// throw new JugadorNoTieneTerreno();

			if(edificios.size()>1)return;


	}

	public void hacerHotel(Jugador unJugador){

		Tablero tablero = Tablero.getInstance();

		if(tablero.getCordobaNorte().getCantidadEdificios() < 2) return;

		if(!unJugador.esDuenio(tablero.getCordobaNorte())) return;

		unJugador.sumarDinero(getValorHotel() * -1);

	}

}
