package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import excepciones.CasasInsuficientes;
import excepciones.JugadorNoPoseeTodosLosBarrios;
import excepciones.NoPuedeConstruirMasCasas;
import excepciones.NoPuedeConstruirMasHoteles;
import modelo.Jugador.Jugador;


public class Neuquen extends Propiedad {

	public int getPrecioCompra(){ return 17000; }

	public int getValorCasa(){ return 4800; }

	public int getCostoAlquiler(){ return 1000; }

	public int getCostoAlquilerConCasa(){ return 3800;}


	public void hacerCasa(Jugador unJugador) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {

		if(!edificios.empty()) throw new NoPuedeConstruirMasCasas();

	}


	public void hacerHotel(Jugador unJugador) throws CasasInsuficientes, NoPuedeConstruirMasHoteles {

		throw new NoPuedeConstruirMasHoteles();

	}


}
