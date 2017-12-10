package modelo;
import java.util.Iterator;
import java.util.LinkedList;

import controlador.VentanaJuego;
import estados.EstadoCasillero;
import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Barrios.BuenosAiresSur;
import excepciones.FinDelJuego;
import excepciones.JugadorNoEsPropietario;
import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;
import modelo.Jugador.Jugador;

public class AlgoPoly {


	private Tablero tablero;
	private LinkedList<Jugador> jugadores;
	private int actual = 0;
	private int dadosIgualesSeguidos = 0;

	public AlgoPoly(){

		tablero = Tablero.getInstance();
		tablero.resetearTablero();
		jugadores = new LinkedList<Jugador>();
	}


	public void arrojarDados(Jugador unJugador) throws NoEsTurnoJugador, JugadorYaTiroDados {


		unJugador.arrojarDados();

		tablero.moverJugador(unJugador, unJugador.getValorDados());
	}


	public void efectoCasillero(Jugador unJugador){
		this.tablero.obtenerCasillero(unJugador).getestado().hacerEfectoDelCasillero(unJugador);
	}

	public void tiraDeVuelta(Jugador unJugador) throws NoEsTurnoJugador, JugadorYaTiroDados, FinDelJuego {


		if(!unJugador.puedeMoverse()) {
			unJugador.setEstado(unJugador.getJugadorTiroDados());
			return;
		}

		if(unJugador.tieneDadosIguales() ) {
			unJugador.setEstado(unJugador.getJugadorEmpezandoTurno() );
			System.out.println("DADOS IGUALES");
			dadosIgualesSeguidos++;

		}else {
			dadosIgualesSeguidos = 0;
			unJugador.setEstado(unJugador.getJugadorTiroDados() );
			//this.avanzarJugador();
		}

		if(dadosIgualesSeguidos == 2) {
			unJugador.setEstado(unJugador.getJugadorTiroDados());
			dadosIgualesSeguidos = 0;
			//this.avanzarJugador();
		}

		if(this.jugadores.size()== 1 ) throw new FinDelJuego();
	}

	public Jugador nuevoJugador(String unNombre){

		Jugador jugador = new Jugador(unNombre);

		this.jugadores.add(jugador);

		tablero.agregarJugador(jugador);

		return jugador;

	}


	public int obtenerPosicion(Jugador unJugador){

		return tablero.obtenerPosicion(unJugador);

	}

	public void comprar(Jugador unjugador) {
		Casillero unacasilla = tablero.obtenerCasillero(unjugador);
		EstadoCasillero unestado = unacasilla.getestado();
		try {
			unjugador.comprar((Comprable) unestado);
		}
		catch(ClassCastException e) {
			//no puede comprar
			System.out.println("Cast ex\n");
		}
		catch (NoEsTurnoJugador e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NoEsTurno ex\n");
		}
	}


	public Jugador obtenerJugadorActual() {
		Jugador jugador = this.jugadores.get(actual);
		return jugador;
	}

	public void avanzarJugador() {
		this.actual = (this.actual + 1) % this.jugadores.size();
	}


	public int getCantidadJugadores() {
		// TODO Auto-generated method stub
		return this.jugadores.size();
	}


	public void quitarJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		this.jugadores.remove(jugador);
	}

	public int getNumeroJugadores(){
		return this.jugadores.size();
	}

	public Jugador obtenerJugador(int numero){
		return this.jugadores.get(numero);
	}


	public void vender(Jugador jugador, Comprable terreno) throws NoEsTurnoJugador, JugadorNoEsPropietario {
		jugador.vender(terreno);


	}

	public Tablero getTablero(){
		return tablero;
	}



	public void resetear() {
		// TODO Auto-generated method stub
		Iterator<Jugador> iter = this.jugadores.iterator();
		while(iter.hasNext()) {
			Jugador actual = iter.next();
			VentanaJuego ventana = VentanaJuego.getInstance();
			ventana.quitarcapa(actual);
		}
		while(this.jugadores.size()!= 0) this.jugadores.remove();
		
	}

}
