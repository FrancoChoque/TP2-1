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


	public void construir(Propiedad unaPropiedad, Casa casa) throws JugadorNoPoseeTodosLosBarrios, JugadorNoEsPropietario, NoPuedeConstruirMasCasas, DineroInsuficiente{

		estadoDeJugador.construir(unaPropiedad, casa);


	}

	public void construir(Propiedad unaPropiedad, Hotel hotel) throws NoPuedeConstruirMasHoteles, JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, DineroInsuficiente, JugadorNoEsPropietario{

		estadoDeJugador.construir(unaPropiedad, hotel);

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

	public boolean puedeconstruircasas(Propiedad propiedad) {

		Casa casa = new Casa();

		if(!this.esDuenio(propiedad)){
			return true;
		}

		try {
			propiedad.puedeConstruir(this,casa);
		} catch (JugadorNoPoseeTodosLosBarrios jugadorNoPoseeTodosLosBarrios) {
			return true;
		} catch (NoPuedeConstruirMasCasas noPuedeConstruirMasCasas) {
			return true;
		}

		return false;
	}

	public boolean puedeconstruirhotel(Propiedad propiedad) {

		Hotel hotel = new Hotel();

		if(!this.esDuenio(propiedad)) return true;

		try {
			propiedad.puedeConstruir(this, hotel);
		} catch (CasasInsuficientes casasInsuficientes) {
			return true;
		} catch (JugadorNoPoseeTodosLosBarrios jugadorNoPoseeTodosLosBarrios) {
			return true;
		} catch (NoPuedeConstruirMasHoteles noPuedeConstruirMasHoteles) {
			return true;
		}
		return false;
	}






	
	
}
