package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import excepciones.CasasInsuficientes;
import excepciones.JugadorNoPoseeTodosLosBarrios;

import excepciones.NoPuedeConstruirMasCasas;
import modelo.Casa;
import modelo.Hotel;
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




	public void puedeEdificar(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getCordobaSur())) throw new JugadorNoPoseeTodosLosBarrios();

		if(edificios.size()>1) throw new NoPuedeConstruirMasCasas();

	}



	public void puedeEdificar(Jugador unJugador, Hotel hotel) throws CasasInsuficientes, JugadorNoPoseeTodosLosBarrios {

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getCordobaSur())) throw new JugadorNoPoseeTodosLosBarrios();

		if(tablero.getCordobaSur().getCantidadEdificios() < 2) throw new CasasInsuficientes();

	}

	public String getNombre(){
		return "Cordoba Norte";
	}

	@Override
	public String toString(){
		return "Cordoba Norte";
	}



}
