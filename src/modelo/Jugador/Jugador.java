package modelo.Jugador;
import excepciones.*;

import java.util.LinkedList;

import estados.Comprable;

public class Jugador {

	static final int DINERO_INICIAL = 100000;
	private String nombre = "NONAME";
	private int dinero;

	private LinkedList<Comprable> propiedades;
	private boolean movimientoPosible;
	private int numeroPropiedades;



	private int valorDados;

	private EstadoDeJugador jugadorEmpezandoTurno;
	private EstadoDeJugador jugadorSinTurno;
	private EstadoDeJugador jugadorTiroDados;
	private EstadoDeJugador estadoDeJugador;


	public Jugador(String unNombre){


		this.nombre = unNombre;
		this.valorDados = 0;

		this.dinero = DINERO_INICIAL;
		propiedades = new LinkedList<Comprable>();


		movimientoPosible = true;


		jugadorEmpezandoTurno = new JugadorEmpezandoTurno(this);
		jugadorSinTurno = new JugadorSinTurno(this);
		jugadorTiroDados = new JugadorTiroDados(this);
		estadoDeJugador = jugadorSinTurno;


	}

	public void arrojarDados() throws NoEsTurnoJugador, JugadorYaTiroDados {
		estadoDeJugador.arrojarDados();
	}


	public void vender() throws NoEsTurnoJugador{
		estadoDeJugador.vender();
	}



	public void comprar(Comprable uncomprable) throws NoEsTurnoJugador{
		estadoDeJugador.comprar(uncomprable);

	}


	public int getDinero(){
		return this.dinero;
	}

	public void setDinero(int unMonto){
		this.dinero = unMonto;
	}

	public void sumarDinero(int unMonto){
		this.dinero += unMonto;
	}



	public void setEstado(EstadoDeJugador unEstado){
		this.estadoDeJugador = unEstado;

	}

	public void setValorDados(int unValor){
		this.valorDados = unValor;
	}

	public int getValorDados(){
		return this.valorDados;
	}

	public EstadoDeJugador getEstadoDeJugador() {
		return estadoDeJugador;
	}

	public EstadoDeJugador getJugadorEmpezandoTurno() {
		return jugadorEmpezandoTurno;
	}

	public EstadoDeJugador getJugadorSinTurno() {
		return jugadorSinTurno;
	}

	public EstadoDeJugador getJugadorTiroDados() {
		return jugadorTiroDados;
	}



	public void adquirirPropiedad(Comprable uncomprable){

		this.propiedades.add(uncomprable);
	}


	public void comprarTerreno(Comprable uncomprable) {
		try {
			this.comprar(uncomprable);
		} catch (NoEsTurnoJugador noEsTurnoJugador) {
			System.out.println("no es el turno del jugador");
		}
	}


	public void cambiarMovimiento() {

		if (!movimientoPosible) movimientoPosible = true;
		else movimientoPosible = false;
	}



	public boolean puedePagar(int monto) {

		return dinero >= monto;
	}

	public boolean puedeMoverse() {

		return movimientoPosible;
	}


	public int getNumeroPropiedades() {
		return numeroPropiedades;
	}

	public void setNumeroPropiedades(int numPropiedades) {
		this.numeroPropiedades = numPropiedades;
	}


	public void aumentarNumeroDePropiedades(int unAumento){
			this.numeroPropiedades += unAumento;
	}

/*	public int getNumeroPropiedades() {

		int numeroDePropiedades = 0;

		for (each propiedad){
		 	numeroDePropiedades++;
		 	if(propiedad es barrio){
				numeroDePropiedades +=get cantidad de construcciones
			}
		}

		return numeroDePropiedades;
	}*/
}
