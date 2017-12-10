package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import excepciones.CasasInsuficientes;
import excepciones.JugadorNoPoseeTodosLosBarrios;
import excepciones.NoPuedeConstruirMasCasas;
import modelo.Casa;
import modelo.Hotel;
import modelo.Jugador.Jugador;
import modelo.Tablero;

public class SaltaNorte extends Propiedad {

	public int getPrecioCompra(){ return 23000; }

	public int getValorCasa(){ return 4500; }

	public int getValorHotel(){ return 7500; }

	public int getCostoAlquiler(){ return 2000; }

	public int getCostoAlquilerConCasa(){ return 3250;}

	public int getCostoAlquilerConDosCasas(){ return 3850;}

	public int getCostoAlquilerConHotel(){ return 5500;}




	public void puedeEdificar(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getSaltaSur())) throw new JugadorNoPoseeTodosLosBarrios();

		if(edificios.size()>1) throw new NoPuedeConstruirMasCasas();



	}

	public void puedeEdificar(Jugador unJugador, Hotel hotel) throws CasasInsuficientes, JugadorNoPoseeTodosLosBarrios {

		Tablero tablero = Tablero.getInstance();


		if(!unJugador.esDuenio(tablero.getSaltaSur())) throw new JugadorNoPoseeTodosLosBarrios();

		if(tablero.getSaltaSur().getCantidadEdificios() < 2) throw new CasasInsuficientes();

	}

	public String getNombre(){
		return "Salta Norte";
	}

	@Override
	public String toString(){
		return "Salta Norte";
	}

	@Override
	public String otropar() {
		// TODO Auto-generated method stub
		Tablero tablero = Tablero.getInstance();
		return tablero.getSaltaSur().getNombre();
	}
}
