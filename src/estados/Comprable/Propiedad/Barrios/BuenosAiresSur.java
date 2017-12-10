package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import excepciones.CasasInsuficientes;
import excepciones.JugadorNoPoseeTodosLosBarrios;
import excepciones.NoPuedeConstruirMasCasas;
import modelo.Casa;
import modelo.Hotel;
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


	public void puedeEdificar(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getBuenosAiresNorte())) throw  new JugadorNoPoseeTodosLosBarrios();

		if(edificios.size()>1) throw new NoPuedeConstruirMasCasas();



	}

	public void puedeEdificar(Jugador unJugador, Hotel hotel) throws CasasInsuficientes, JugadorNoPoseeTodosLosBarrios {

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(tablero.getBuenosAiresNorte())) throw new JugadorNoPoseeTodosLosBarrios();

		if(tablero.getBuenosAiresNorte().getCantidadEdificios() < 2) throw new CasasInsuficientes();

	}

	public String getNombre(){
		return "Buenos Aires Sur";
	}
	
	@Override
	public String toString(){
		return "Buenos Aires Sur";
	}

	@Override
	public String otropar() {
		// TODO Auto-generated method stub
		Tablero tablero = Tablero.getInstance();
		return tablero.getBuenosAiresNorte().getNombre();
	}

	
}
