package modelo.Jugador;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;
import modelo.*;

import java.util.LinkedList;

import estados.Comprable.Comprable;

public class Jugador {

	static final int DINERO_INICIAL = 100000;
	public String nombre;
	private int dinero;

	private LinkedList<Comprable> propiedades;
	private boolean movimientoPosible;


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
		estadoDeJugador.arrojarDados(dado1, dado2);
	}


	public void vender(Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario {

		estadoDeJugador.vender(unComprable);

		propiedades.remove(unComprable);
	}


	public void construir(Propiedad unaPropiedad, Edificio edificio) throws DineroInsuficiente, NoEsTurnoJugador {
		estadoDeJugador.construir(unaPropiedad, edificio);

	}

	public boolean puedeConstruir(Propiedad propiedad, Edificio edificio){
		return estadoDeJugador.puedeConstruir(propiedad, edificio);
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
		//if(this.dinero < Math.abs(unMonto)) throw new DineroInsuficiente();
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




	public void cambiarMovimiento(boolean value) {

		this.movimientoPosible = value;
	}



	public boolean puedePagar(int monto) {

		return dinero >= monto;
	}

	public boolean puedeMoverse() {

		return this.movimientoPosible;
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



	public Comprable getPropiedad(int i) {
		return this.propiedades.get(i);
	}

	public void elimarPropiedad(Comprable propiedad) {
		for(int i=0; i< this.propiedades.size();i++){
			Comprable comprable = this.propiedades.get(i);
			if(comprable == propiedad){
				this.propiedades.remove(i);
				System.out.println("elimino: "+propiedad.getNombre() + " de "+this.nombre);
			}
		}
		
	}

	public void transferir(Comprable comprable, Jugador player2) {
		// TODO Auto-generated method stub
		this.propiedades.remove(comprable);
		player2.propiedades.add(comprable);
		comprable.setDuenio(player2);
	}

	public int getValorDado1() {
		// TODO Auto-generated method stub
		return this.dado1.getValor();
	}

	public int getValorDado2() {
		// TODO Auto-generated method stub
		return this.dado2.getValor();
	}







	
	
}
