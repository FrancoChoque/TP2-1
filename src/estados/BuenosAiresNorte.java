package estados;

import excepciones.DineroInsuficienteException;
import excepciones.JugadorNoTieneTerreno;
import modelo.Edificio;
import modelo.Hotel;
import modelo.Casa;

import modelo.Jugador.Jugador;
import modelo.Tablero;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BuenosAiresNorte extends Propiedad {

	private boolean puedeConstruir;
	private Stack<Edificio> edificios;




	public BuenosAiresNorte(){
	 precioCompra = 25000;
	 valorCasa = 5500;
	 valorHotel = 9000;
	 costoAlquiler = 2500;
	 costoAlquilerConCasa= 3500;
	 costoAlquilerConDosCasas = 4000;
	 costoAlquilerConHotel = 6000;
	 puedeConstruir = true;
	 edificios = new Stack<Edificio>();

	}



	public void puedeEdificar(Jugador unJugador, Edificio unEdificio) throws JugadorNoTieneTerreno{

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(this) || !unJugador.esDuenio(tablero.getBuenosAiresSur())) throw new JugadorNoTieneTerreno();

		if(unEdificio instanceof Hotel){
			if(edificios.size()>1) return;
		}else{
			if(unEdificio instanceof Casa){
				if(edificios.size()>2)return;
			}
		}


	}


	public int getCantidadDeEdificios(){
		return edificios.size();
	}

}
