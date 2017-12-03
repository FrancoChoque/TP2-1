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



	public void reembolsar(){
		Duenio.sumarDinero((int)(getPrecioCompra()- getPrecioCompra()*0.15));
		this.vaciarEdificios();
	}

	public void cobrarPase(Jugador unJugador){

		unJugador.sumarDinero(propiedadEstado.getCostoPase() * -1);
		
		if(unJugador.getDinero()<0) throw new DineroInsuficiente();
		
		this.getDuenio().sumarDinero(propiedadEstado.getCostoPase());
	}


	public void construir(Jugador unJugador, Casa casa) throws NoPuedeConstruirMasCasas, DineroInsuficiente, JugadorNoEsPropietario, JugadorNoPoseeTodosLosBarrios{

		propiedadEstado.puedeConstruir(unJugador, casa);
		edificios.add(casa);
		unJugador.sumarDinero(getValorCasa() * -1);
	}



	public void construir(Jugador unJugador, Hotel hotel) throws NoPuedeConstruirMasHoteles, DineroInsuficiente, JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, JugadorNoEsPropietario {

		propiedadEstado.puedeConstruir(unJugador, hotel);
		edificios.add(hotel);
		unJugador.sumarDinero(getValorHotel() * -1);

	}


	public void puedeConstruir(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {

		propiedadEstado.puedeConstruir(unJugador, casa);

	}


	public void puedeConstruir(Jugador unJugador, Hotel hotel) throws JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles {
		propiedadEstado.puedeConstruir(unJugador, hotel);
	}


	public void vaciarEdificios() {
		while(!edificios.empty()) {
			edificios.pop();
		}
		this.setPropiedadEstado(getPropiedadSinCasa());

	}

	public void puedeEdificar(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {

	}

	public void puedeEdificar(Jugador unJugador, Hotel hotel) throws NoPuedeConstruirMasHoteles, CasasInsuficientes, JugadorNoPoseeTodosLosBarrios {

	}

	public int getCantidadEdificios(){
		return edificios.size();
	}


	public String otropar() {
		// TODO Auto-generated method stub
		return null;
	}



}
