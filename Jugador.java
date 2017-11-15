import excepciones.*;

import java.util.LinkedList;

public class Jugador {

	static final int DINERO_INICIAL = 100000;
	private String nombre = "NONAME";
	private int dinero;

	private LinkedList<Comprable> propiedades;
	private boolean movimientoPosible;

	private int valorQueseTieneQueMover;
	private boolean tieneQueMoverse;
	private int numeroPropiedades;

	private EstadoDeJugador jugadorEmpezandoTurno;
	private EstadoDeJugador jugadorSinTurno;
	private EstadoDeJugador jugadorTiroDados;
	private EstadoDeJugador estadoDeJugador;


	public Jugador(String unNombre){


		this.nombre = unNombre;


		this.dinero = DINERO_INICIAL;
		propiedades = new LinkedList<Comprable>();

		movimientoPosible = true;

		this.valorQueseTieneQueMover = 0;
		this.tieneQueMoverse = false;
		this.numeroPropiedades = 0;

		jugadorEmpezandoTurno = new JugadorEmpezandoTurno(this);
		jugadorSinTurno = new JugadorSinTurno(this);
		jugadorTiroDados = new JugadorTiroDados(this);
		estadoDeJugador = jugadorSinTurno;


	}

	public int arrojarDados() throws NoEsTurnoJugador, JugadorYaTiroDados {

		return estadoDeJugador.arrojarDados();

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

	public void comprar(Terreno unTerreno) throws NoEsTurnoJugador, JugadorYaTiroDados {
		estadoDeJugador.comprar(unTerreno);

	}

	public void setEstado(EstadoDeJugador unEstado){

		this.estadoDeJugador = unEstado;

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

	public boolean puedeMoverse() {
		// TODO Auto-generated method stub
		return movimientoPosible;
	}


	public void adquirirPropiedad(Terreno unTerreno){

		this.propiedades.add(unTerreno);
	}


	public void cambiarMovimiento() {
		// TODO Auto-generated method stub
		movimientoPosible = movimientoPosible ? false : true ;
	}



	public boolean puedePagar(int monto) {
		// TODO Auto-generated method stub
		return dinero >= monto;
	}

	public void setValorQueseTieneQueMover(int valor){
		this.valorQueseTieneQueMover = valor;
	}

	public int getValorQueseTieneQueMover(){

		return this.valorQueseTieneQueMover;
	}

	public void comenzarAmoverse(){
		this.tieneQueMoverse = true;
	}

	public void continuarMoviendose(){
		this.tieneQueMoverse = true;
	}

	public boolean getTieneQueMoverse(){
		return this.tieneQueMoverse;
	}

	public void seMovio(){
		this.tieneQueMoverse = false;
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

}
