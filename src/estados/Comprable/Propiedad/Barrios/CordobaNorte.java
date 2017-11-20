package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import modelo.Jugador.Jugador;
import modelo.Tablero;

public class CordobaNorte extends Propiedad {

	public int getPrecioCompra(){ return 20000; }

	public int getValorCasa(){ return 2200; }

	public int getValorHotel(){ return 3500; }

	public int getCostoAlquiler(){ return 1300; }

	public int getCostoAlquilerConCasa(){ return 1800;}

	public int getCostoAlquilerConDosCasas(){ return 2900;}

	public int getCostoAlquilerConHotel(){ return 3500;}




	public void hacerCasa(Jugador unJugador){

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getCordobaSur()))// throw new JugadorNoTieneTerreno();

			if(edificios.size()>1)return;


	}

	public void hacerHotel(Jugador unJugador){

		Tablero tablero = Tablero.getInstance();

		if(tablero.getCordobaSur().getCantidadEdificios() < 2) return;

		if(!unJugador.esDuenio(tablero.getCordobaSur())) return;

		unJugador.sumarDinero(getValorHotel() * -1);

	}


}
