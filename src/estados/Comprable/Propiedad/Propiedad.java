package estados.Comprable.Propiedad;


import java.util.Stack;

import estados.Comprable.Comprable;
import excepciones.*;
import modelo.Casa;
import modelo.Edificio;
import modelo.Hotel;
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


	public void cobrarPase(Jugador unJugador){

		unJugador.sumarDinero(propiedadEstado.getCostoPase() * -1);
	}


	public void construirCasa(Jugador unJugador){


		try {
			propiedadEstado.construirCasa(unJugador);
		} catch (excepciones.JugadorNoEsPropietario jugadorNoEsPropietario) {
			//jugadorNoEsPropietario.printStackTrace();
			return;
		} catch (excepciones.JugadorNoPoseeTodosLosBarrios jugadorNoPoseeTodosLosBarrios) {
			//jugadorNoPoseeTodosLosBarrios.printStackTrace();
			return;
		} catch (NoPuedeConstruirMasCasas noPuedeConstruirMasCasas) {
			//noPuedeConstruirMasCasas.printStackTrace();
			return;
		}

		edificios.add(new Casa());
		unJugador.sumarDinero(getValorCasa() * -1);
	}



	public void construirHotel(Jugador unJugador){
		try {
			propiedadEstado.construirHotel(unJugador);
		} catch (excepciones.JugadorNoEsPropietario jugadorNoEsPropietario) {
			//jugadorNoEsPropietario.printStackTrace();
			return;
		} catch (NoPuedeConstruirMasHoteles noPuedeConstruirMasHoteles) {
			//noPuedeConstruirMasHoteles.printStackTrace();
			return;
		} catch (excepciones.CasasInsuficientes casasInsuficientes) {
			//casasInsuficientes.printStackTrace();
			return;
		} catch (JugadorNoPoseeTodosLosBarrios jugadorNoPoseeTodosLosBarrios) {
		//	jugadorNoPoseeTodosLosBarrios.printStackTrace();
			return;
		}

		edificios.add(new Hotel());
		unJugador.sumarDinero(getValorHotel() * -1);

	}

	public void vaciarEdificios() {
		while(!edificios.empty()) {
			edificios.pop();
		}
		this.setPropiedadEstado(getPropiedadSinCasa());
		
	}

	public void hacerCasa(Jugador jugador) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas { }


	public void hacerHotel(Jugador jugador) throws CasasInsuficientes, NoPuedeConstruirMasHoteles, JugadorNoPoseeTodosLosBarrios {
	}



	public int getCantidadEdificios(){
		return edificios.size();
	}



}
