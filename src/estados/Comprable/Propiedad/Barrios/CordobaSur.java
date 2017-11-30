package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import excepciones.CasasInsuficientes;
import excepciones.JugadorNoPoseeTodosLosBarrios;
import excepciones.NoPuedeConstruirMasCasas;
import excepciones.NoPuedeConstruirMasHoteles;
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



	public void hacerCasa(Jugador unJugador) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getCordobaNorte())) throw new JugadorNoPoseeTodosLosBarrios();

		if(edificios.size()>1) throw new NoPuedeConstruirMasCasas();

	}



	public void hacerHotel(Jugador unJugador) throws CasasInsuficientes, NoPuedeConstruirMasHoteles {

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getCordobaNorte())) throw new NoPuedeConstruirMasHoteles();

		if(tablero.getCordobaNorte().getCantidadEdificios() < 2) throw new CasasInsuficientes();

	}

	public String getNombre(){
		return "Cordoba Sur";
	}

}
