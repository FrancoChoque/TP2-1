package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import modelo.Hotel;
import modelo.Casa;

import modelo.Jugador.Jugador;
import modelo.Tablero;

public class BuenosAiresNorte extends Propiedad {



	public int getPrecioCompra(){ return 25000; }

	public int getValorCasa(){ return 5500; }

	public int getValorHotel(){ return 9000; }

	public int getCostoAlquiler(){ return 2500; }

	public int getCostoAlquilerConCasa(){ return 3500;}

	public int getCostoAlquilerConDosCasas(){ return 4000;}

	public int getCostoAlquilerConHotel(){ return 6000;}

	
	public void hacerCasa(Jugador unJugador){

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getBuenosAiresSur()))// throw new JugadorNoTieneTerreno();

		if(edificios.size()>1)return;


	}

	public void hacerHotel(Jugador unJugador){

		Tablero tablero = Tablero.getInstance();

		if(tablero.getBuenosAiresSur().getCantidadEdificios() < 2) return;

		if(!unJugador.esDuenio(tablero.getBuenosAiresSur())) return;

		unJugador.sumarDinero(getValorHotel() * -1);

	}


}
