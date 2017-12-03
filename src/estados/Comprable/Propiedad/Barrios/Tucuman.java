package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import excepciones.CasasInsuficientes;
import excepciones.JugadorNoPoseeTodosLosBarrios;
import excepciones.NoPuedeConstruirMasCasas;
import excepciones.NoPuedeConstruirMasHoteles;
import modelo.Casa;
import modelo.Hotel;
import modelo.Jugador.Jugador;


public class Tucuman extends Propiedad {

	public int getPrecioCompra(){ return 25000; }

	public int getValorCasa(){ return 7000; }

	public int getCostoAlquiler(){ return 2500; }

	public int getCostoAlquilerConCasa(){ return 4500;}



	public void puedeConstuir(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {

		if(!edificios.empty()) throw new NoPuedeConstruirMasCasas();

	}


	public void puedeConstuir(Jugador unJugador, Hotel hotel) throws NoPuedeConstruirMasHoteles {

		throw new NoPuedeConstruirMasHoteles();

	}

	public String getNombre(){
		return "Tucuman";
	}


}
