package estados.Comprable.Propiedad;


import java.util.LinkedList;
import java.util.Stack;

import estados.Comprable.Comprable;
import modelo.Edificio;
import modelo.Jugador.Jugador;

public class Propiedad extends Comprable {


	protected Stack<Edificio> edificios = new Stack<Edificio>();

	PropiedadEstado propiedadEstado;
	PropiedadSinCasa propiedadSinCasa;
	PropiedadConCasa propiedadConCasa;
	PropiedadConHotel propiedadConHotel;
	PropiedadConDosCasas propiedadConDosCasas;



	public Propiedad(){

		propiedadSinCasa = new PropiedadSinCasa(this);
		propiedadConCasa = new PropiedadConCasa(this);
		propiedadConDosCasas = new PropiedadConDosCasas(this);
		propiedadConHotel = new PropiedadConHotel(this);
		propiedadEstado = propiedadSinCasa;
	}


	public PropiedadEstado getPropiedadEstado() { return propiedadEstado; }

	public PropiedadSinCasa getPropiedadSinCasa() { return propiedadSinCasa; }

	public PropiedadConCasa getPropiedadConCasa() { return propiedadConCasa; }

	public PropiedadConDosCasas getPropiedadConDosCasas() { return propiedadConDosCasas; }

	public PropiedadConHotel getPropiedadConHotel() { return propiedadConHotel; }

	public void setPropiedadEstado(PropiedadEstado estado){
		this.propiedadEstado = estado;
	}

	public int getPrecioCompra(){ return 0; }

	public int getValorCasa(){ return 0; }

	public int getValorHotel(){ return 0; }

	public int getCostoAlquiler(){ return 0; }

	public int getCostoAlquilerConCasa(){ return 0;}

	public int getCostoAlquilerConDosCasas(){ return 0;}

	public int getCostoAlquilerConHotel(){ return 0;}



	public void comprar(Jugador unJugador){

		unJugador.sumarDinero(this.getPrecioCompra()*-1);

		this.cambiarDuenio(unJugador);

	}
	public int getCostoEdificar(){
		return propiedadEstado.getCostoEdificar();
	}

	public void cobrarPase(Jugador unJugador){

		unJugador.sumarDinero(propiedadEstado.getCostoPase() * -1);
	}


	public void construirCasa(Jugador unJugador){

		propiedadEstado.construirCasa(unJugador);
		unJugador.sumarDinero(getValorCasa() * -1);

	}
	public void construirHotel(Jugador unJugador){
		propiedadEstado.construirHotel(unJugador);

	}

	public void vaciarEdificios() {
		while(!edificios.empty()) {
			edificios.pop();
		}
		this.setPropiedadEstado(getPropiedadSinCasa());
		
	}

	public void hacerCasa(Jugador jugador){

	}
	public void hacerHotel(Jugador jugador){
	}

	public void puedeEdificar(){};

	public int getCantidadEdificios(){
		return edificios.size();
	}



}
