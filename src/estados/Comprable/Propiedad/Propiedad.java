package estados.Comprable.Propiedad;


import java.util.Stack;

import estados.Comprable.Comprable;
import excepciones.*;
import modelo.Casa;
import modelo.Edificio;
import modelo.Hotel;
import modelo.Jugador.Jugador;
import vista.eventos.mensajescasillero.Mensaje;

public abstract class Propiedad extends Comprable {


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

	public abstract int getPrecioCompra();

	public abstract int getValorCasa();

	public abstract int getValorHotel();

	public abstract int getCostoAlquiler();

	public abstract int getCostoAlquilerConCasa();

	public abstract int getCostoAlquilerConDosCasas();

	public abstract int getCostoAlquilerConHotel();



	public void reembolsar(){
		Duenio.sumarDinero((int)(getPrecioCompra()- getPrecioCompra()*0.15));
		this.vaciarEdificios();
		this.setDuenio(null);
		this.setEstado(this.getNoTieneDuenio());
	}

	public void cobrarPase(Jugador unJugador){

		unJugador.sumarDinero(propiedadEstado.getCostoPase() * -1);

		if(unJugador.getDinero()<0) throw new DineroInsuficiente();

		this.getDuenio().sumarDinero(propiedadEstado.getCostoPase());
	}


	public int getCostoPase(Jugador unJugador) {
		return propiedadEstado.getCostoPase();

	}


	public void construir(Jugador jugador, Edificio edificio) throws DineroInsuficiente{
		edificio.construir(jugador,this);
		propiedadEstado.construir();
	}


	public void puedeConstruir(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {
		propiedadEstado.puedeConstruir(unJugador, casa);
	}

	public void puedeConstruir(Jugador unJugador, Hotel hotel) throws JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles {
		propiedadEstado.puedeConstruir(unJugador, hotel);
	}

	public void puedeConstruir(Jugador jugador, Edificio edificio) throws NoPuedeConstruirMasCasas, CasasInsuficientes, NoPuedeConstruirMasHoteles, JugadorNoPoseeTodosLosBarrios {
		edificio.puedeConstruir(jugador,this);
	}


	public void vaciarEdificios() {
		while(!edificios.empty()) {
			edificios.pop();
		}
		this.setPropiedadEstado(getPropiedadSinCasa());

	}

	public abstract void puedeEdificar(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas;

	public abstract void puedeEdificar(Jugador unJugador, Hotel hotel) throws NoPuedeConstruirMasHoteles, CasasInsuficientes, JugadorNoPoseeTodosLosBarrios;


	public int getCantidadEdificios(){
		return edificios.size();
	}

	public Stack<Edificio> getEdificios() {
		return edificios;
	}

	public void mensajeEfecto(Jugador unJugador){
		Mensaje mensaje = new Mensaje();

		mensaje.mensajeEfecto(unJugador,this);
	}


}
