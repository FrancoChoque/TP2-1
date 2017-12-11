package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import excepciones.JugadorNoPoseeTodosLosBarrios;
import excepciones.NoPuedeConstruirMasCasas;
import excepciones.NoPuedeConstruirMasHoteles;
import modelo.Casa;
import modelo.Hotel;
import modelo.Jugador.Jugador;


public class SantaFe extends Propiedad {

	public int getPrecioCompra(){ return 15000; }

	public int getValorCasa(){ return 4000; }

	@Override
	public int getValorHotel() {
		return 0;
	}

	public int getCostoAlquiler(){ return 1500; }

	public int getCostoAlquilerConCasa(){ return 3500;}

	@Override
	public int getCostoAlquilerConDosCasas() {
		return 0;
	}

	@Override
	public int getCostoAlquilerConHotel() {
		return 0;
	}


	public void puedeEdificar(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {

		if(!edificios.empty()) throw new NoPuedeConstruirMasCasas();

	}


	public void puedeEdificar(Jugador unJugador, Hotel hotel) throws NoPuedeConstruirMasHoteles {

		throw new NoPuedeConstruirMasHoteles();

	}

	public String getNombre(){
		return "Santa Fe";
	}

	@Override
	public String toString(){
		return "Santa Fe";
	}


}
