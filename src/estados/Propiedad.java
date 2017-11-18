package estados;


import java.util.LinkedList;
import java.util.Stack;

import excepciones.DineroInsuficienteException;
import excepciones.JugadorNoTieneTerreno;
import modelo.Casa;
import modelo.Edificio;
import modelo.Jugador.Jugador;

public class Propiedad extends Comprable{

	int precioCompra;
	int valorCasa;
	int valorHotel;
	int costoAlquiler;
	int costoAlquilerConCasa;
	int costoAlquilerConDosCasas;
	int costoAlquilerConHotel;
	int AlquilerActual;
	LinkedList<Integer> Alquileres = new LinkedList<Integer>();
	protected Stack<Edificio> edificios = new Stack<Edificio>();


	public void puedeEdificar(Jugador unJugador, Edificio unEdificio) throws JugadorNoTieneTerreno{};

	@Override
	public void hacerEfectoDelCasillero(Jugador unJugador) {
		if(this.preguntarDuenio() == unJugador) return;

	}

	public void cobrarPase(Jugador unJugador){
	}


	public void cobrarCompra(Jugador unJugador) throws DineroInsuficienteException {
		if(!unJugador.puedePagar(precioCompra)) throw new DineroInsuficienteException();
		unJugador.sumarDinero(precioCompra * -1);
	}

	public void cobrarAlquiler(Jugador unJugador) throws DineroInsuficienteException {
		if(!unJugador.puedePagar(costoAlquiler)) throw new DineroInsuficienteException();
		unJugador.sumarDinero(costoAlquiler * -1);
	}

	public void cobrarAlquilerConCasa(Jugador unJugador) throws DineroInsuficienteException {
		if(!unJugador.puedePagar(costoAlquilerConCasa)) throw new DineroInsuficienteException();
		unJugador.sumarDinero(costoAlquilerConCasa * -1);
	}

	public void cobrarAlquilerConDosCasas(Jugador unJugador) throws DineroInsuficienteException {
		if(!unJugador.puedePagar(costoAlquilerConDosCasas)) throw new DineroInsuficienteException();
		unJugador.sumarDinero(costoAlquilerConDosCasas * -1);
	}

	public void cobrarAlquilerConHotel(Jugador unJugador) throws DineroInsuficienteException {
		if(!unJugador.puedePagar(costoAlquilerConHotel)) throw new DineroInsuficienteException();
		unJugador.sumarDinero(costoAlquilerConHotel * -1);
	}


	public void edificar(Jugador unJugador, Edificio unEdificio) throws DineroInsuficienteException{
		try{
			puedeEdificar(unJugador, unEdificio);
		}catch(JugadorNoTieneTerreno noTieneTerreno){
		}

		if(unEdificio instanceof Casa) unJugador.sumarDinero(valorCasa * -1);
		else unJugador.sumarDinero(valorHotel *-1);
	}

	public boolean esComprable() {
		return true;
	}

	public boolean puedeConstruir() {
		return true;
	}

	public void vaciarEdificios() {
		while(!edificios.empty()) {
			edificios.pop();
		}
		
	}



}
