package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import excepciones.JugadorNoTieneTerreno;
import modelo.Edificio;
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

	
	public void construirCasa(Jugador unJugador){

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(this) || !unJugador.esDuenio(tablero.getBuenosAiresSur()))// throw new JugadorNoTieneTerreno();

		if(edificios.size()>1)return;

		edificios.add(new Casa());



	}

	public void construirHotel(Jugador unJugador){

		Tablero tablero = Tablero.getInstance();

		edificios.empty();

		edificios.add(new Hotel());

	}


	public int getCantidadDeEdificios(){
		return edificios.size();
	}

}
