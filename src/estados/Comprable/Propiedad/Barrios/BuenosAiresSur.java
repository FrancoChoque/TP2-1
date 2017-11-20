package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import excepciones.CasasInsuficientes;
import excepciones.JugadorNoPoseeTodosLosBarrios;
import excepciones.NoPuedeConstruirMasCasas;
import excepciones.NoPuedeConstruirMasHoteles;
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


	public void hacerCasa(Jugador unJugador) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getBuenosAiresNorte())) throw  new JugadorNoPoseeTodosLosBarrios();



	}

	public void hacerHotel(Jugador unJugador) throws CasasInsuficientes, NoPuedeConstruirMasHoteles, JugadorNoPoseeTodosLosBarrios{

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getBuenosAiresNorte())) throw new JugadorNoPoseeTodosLosBarrios();

		if(tablero.getBuenosAiresNorte().getCantidadEdificios() < 2) throw new CasasInsuficientes();

	}

	
}
