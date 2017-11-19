package estados;

import excepciones.DineroInsuficienteException;
import excepciones.JugadorNoTieneTerreno;
import modelo.Edificio;
import modelo.Hotel;
import modelo.Casa;

import modelo.Jugador.Jugador;
import modelo.Tablero;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BuenosAiresNorte extends Propiedad {

	private boolean puedeConstruir;
	private LinkedList<Integer> Alquileres;
	private Stack<Edificio> edificios;


	public BuenosAiresNorte(){
		super();
		precioCompra = 25000;
		valorCasa = 5500;
		valorHotel = 9000;
		costoAlquiler = 2500;
		costoAlquilerConCasa= 3500;
		costoAlquilerConDosCasas = 4000;
		costoAlquilerConHotel = 6000;
		puedeConstruir = true;
		edificios = new Stack<Edificio>();
	 
		Alquileres = new LinkedList<Integer>();
		Alquileres.add(costoAlquiler);
		Alquileres.add(costoAlquilerConCasa);
		Alquileres.add(costoAlquilerConDosCasas);
		Alquileres.add(costoAlquilerConHotel);

	}

	
	
	
	@Override
	public void hacerEfectoDelCasillero(Jugador unjugador) {
		if(! this.tieneDuenio()) return;
		if(unjugador == this.Duenio) return;
		
		unjugador.sumarDinero(AlquilerActual * -1);
	}
	

	
	
	public void puedeEdificar(Jugador unJugador, Edificio unEdificio) throws JugadorNoTieneTerreno{

		Tablero tablero = Tablero.getInstance();

		if(!unJugador.esDuenio(this) || !unJugador.esDuenio(tablero.getBuenosAiresSur())) throw new JugadorNoTieneTerreno();

		if(unEdificio instanceof Hotel){
			if(this.edificios.size()!=2) return;
		}
			
		if(unEdificio instanceof Casa){
				if(this.edificios.size()>=2)return;
				this.edificios.add(unEdificio);
		}
		AlquilerActual = Alquileres.get(this.edificios.size() );
		


	}

	@Override
	public void vaciarEdificios() {
		while(!edificios.empty()) {
			edificios.pop();
		}
	}

	public int getCantidadDeEdificios(){
		return edificios.size();
	}

}
