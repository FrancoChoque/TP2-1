package estados.Comprable.Propiedad;


import java.util.LinkedList;
import java.util.Stack;

import estados.Comprable.Comprable;
import excepciones.DineroInsuficienteException;
import excepciones.JugadorNoTieneTerreno;
import modelo.Casa;
import modelo.Edificio;
import modelo.Jugador.Jugador;

public class Propiedad extends Comprable {

	protected LinkedList<Integer> Alquileres = new LinkedList<Integer>();
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
	}

	public void edificar(Jugador unJugador){
		propiedadEstado.edificar(unJugador);
		unJugador.sumarDinero(propiedadEstado.getCostoEdificar() * -1);
	}


	public void cobrarPase(Jugador unJugador){

		unJugador.sumarDinero(propiedadEstado.getCostoPase() * -1);
	}




	public void construirCasa(Jugador unJugador){};
	public void construirHotel(Jugador unJugador){};

	public void vaciarEdificios() {
		while(!edificios.empty()) {
			edificios.pop();
		}
		
	}

	public void puedeEdificar(){};



}
