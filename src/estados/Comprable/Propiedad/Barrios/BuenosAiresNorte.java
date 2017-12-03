package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;

import excepciones.CasasInsuficientes;
import excepciones.JugadorNoPoseeTodosLosBarrios;
import excepciones.NoPuedeConstruirMasCasas;
import excepciones.NoPuedeConstruirMasHoteles;
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

	
	public void hacerCasa(Jugador unJugador) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getBuenosAiresSur())) throw new JugadorNoPoseeTodosLosBarrios();

		if(edificios.size()>1) throw new NoPuedeConstruirMasCasas();


	}

	public void hacerHotel(Jugador unJugador) throws CasasInsuficientes, JugadorNoPoseeTodosLosBarrios {

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getBuenosAiresSur())) throw new JugadorNoPoseeTodosLosBarrios();

		if(tablero.getBuenosAiresSur().getCantidadEdificios() < 2) throw new CasasInsuficientes();


	}

	public String getNombre(){
		return "Buenos Aires Norte";
	}

	@Override
	public String otropar() {
		// TODO Auto-generated method stub
		Tablero tablero = Tablero.getInstance();
		return tablero.getBuenosAiresSur().getNombre();
	}

}
