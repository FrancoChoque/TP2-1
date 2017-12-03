package modelo.Jugador;
import estados.Comprable.Propiedad.Propiedad;
import estados.Comprable.Propiedad.PropiedadEstado;
import estados.Comprable.Propiedad.Barrios.BuenosAiresNorte;
import estados.Comprable.Propiedad.Barrios.BuenosAiresSur;
import estados.Comprable.Propiedad.Barrios.CordobaNorte;
import estados.Comprable.Propiedad.Barrios.CordobaSur;
import excepciones.*;
import modelo.Dado;
import modelo.Tablero;

import java.util.LinkedList;
import java.util.ListIterator;

import estados.Comprable.Comprable;

public class Jugador {

	static final int DINERO_INICIAL = 100000;
	public String nombre;
	private int dinero;

	private LinkedList<Comprable> propiedades;
	private boolean movimientoPosible;
	private int numeroPropiedades;

	private Dado dado1;
	private Dado dado2;

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
        
        dado1 = new Dado();
        dado2 = new Dado();

        jugadorEmpezandoTurno = new JugadorEmpezandoTurno(this);
		jugadorSinTurno = new JugadorSinTurno(this);
		jugadorTiroDados = new JugadorTiroDados(this);
		estadoDeJugador = jugadorSinTurno;

    }
	
	public String getNombre(){
		return this.nombre;
	}
	public void arrojarDados() throws NoEsTurnoJugador, JugadorYaTiroDados {
		estadoDeJugador.arrojarDados();
	}


	public void vender(Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario {

		estadoDeJugador.vender(unComprable);

		propiedades.remove(unComprable);
	}

	public void vender(Jugador unJugador, Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario, DineroInsuficiente {

		estadoDeJugador.vender(unJugador, unComprable);

		propiedades.remove(unComprable);
	}

	public void construirCasa(Propiedad unaPropiedad) throws JugadorNoPoseeTodosLosBarrios, JugadorNoEsPropietario, NoPuedeConstruirMasCasas, DineroInsuficiente{

		estadoDeJugador.construirCasa(unaPropiedad);


	}

	public void construirHotel(Propiedad unaPropiedad) throws NoPuedeConstruirMasHoteles, JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, DineroInsuficiente, JugadorNoEsPropietario{

		estadoDeJugador.construirHotel(unaPropiedad);

	}



	public void comprar(Comprable uncomprable) throws NoEsTurnoJugador{
		estadoDeJugador.comprar(uncomprable);
	}

	public void pasarTurno() throws NoEsTurnoJugador, JugadorNoTiroDados{
	    estadoDeJugador.pasarTurno();
    }


    public boolean esDuenio(Comprable unaPropiedad){
	    return propiedades.contains(unaPropiedad);
    }

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDinero(){
		return this.dinero;
	}

	public void setDinero(int unMonto){
		if(this.dinero < Math.abs(unMonto)) throw new DineroInsuficiente();
		this.dinero = unMonto;
	}

	public void sumarDinero(int unMonto){
		this.dinero += unMonto;
	}

	public void setEstado(EstadoDeJugador unEstado){
		this.estadoDeJugador = unEstado;

	}

	public void intercambiarPropiedades(Jugador unJugador, Comprable propiedadNueva, Comprable propiedadACambiar){
		this.estadoDeJugador.intercambiarPropiedades(unJugador,propiedadNueva,propiedadACambiar);
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

	public void devolverPropiedad(Comprable uncomprable){

		this.propiedades.remove(uncomprable);
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

	public void tirarDados() {
		// TODO Auto-generated method stub
		dado1.arrojar();
		dado2.arrojar();
		
		valorDados = dado1.getValor() + dado2.getValor();
	}

	public boolean tieneDadosIguales() {
		// TODO Auto-generated method stub
		return dado1.getValor() == dado2.getValor();
	}

	public void ponerDadosIguales() {
		// metodo para probar dados iguales
		dado1 = dado2;
	}
	
	public int getCantidadPropiedad(){
		return this.propiedades.size();
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

	public LinkedList<Comprable> getpropiedades() {
		// TODO Auto-generated method stub
		return this.propiedades;
	}

	public boolean puedeconstruircasas() {
		// para actualizar el boton construir casas
		Tablero tablero = Tablero.getInstance();
		if(tieneGrupo(tablero.getBuenosAiresNorte(),tablero.getBuenosAiresSur())) return false;
		if(tieneGrupo(tablero.getCordobaNorte(),tablero.getCordobaSur())) return false;
		if(tieneGrupo(tablero.getSaltaNorte(),tablero.getSaltaSur())) return false;
		
		if(this.propiedades.contains(tablero.getNeuquen()) ||
				this.propiedades.contains(tablero.getTucuman()) ||
				this.propiedades.contains(tablero.getSantaFe())) return false;
			
		return true;
	}

	public boolean puedeconstruirhotel() {
		// TODO Auto-generated method stub
		Tablero tablero = Tablero.getInstance();
		if(puedeAgregarHotel(tablero.getBuenosAiresNorte(),tablero.getBuenosAiresSur())) return false;
		if(puedeAgregarHotel(tablero.getCordobaNorte(),tablero.getCordobaSur())) return false;
		if(puedeAgregarHotel(tablero.getSaltaNorte(),tablero.getSaltaSur())) return false;
		return true;
	}

	private boolean puedeAgregarHotel(Propiedad prop1, Propiedad prop2) {
		// TODO Auto-generated method stub
		return tieneGrupo(prop1,prop2) && estanCompletas(prop1,prop2);
	}

	private boolean estanCompletas(Propiedad prop1, Propiedad prop2) {
		// TODO Auto-generated method stub
		PropiedadEstado estado1 = prop1.getPropiedadEstado();
		PropiedadEstado estado2 = prop2.getPropiedadEstado();
		return (estado1 == prop1.getPropiedadConDosCasas() || estado1 == prop1.getPropiedadConHotel()) &&
				(estado2 == prop2.getPropiedadConDosCasas() || estado2 == prop2.getPropiedadConHotel());
	}

	private boolean tieneGrupo(Propiedad prop1, Propiedad prop2) {
		// TODO Auto-generated method stub

		return this.propiedades.contains(prop1) && 
				this.propiedades.contains(prop2);
	}

	
	
}
