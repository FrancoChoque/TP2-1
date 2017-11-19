package estados;

import java.util.LinkedList;
import java.util.Stack;

import excepciones.JugadorNoTieneTerreno;
import modelo.Casa;
import modelo.Edificio;
import modelo.Hotel;
import modelo.Tablero;
import modelo.Jugador.*;

;

public class BuenosAiresSur extends Propiedad {
	
	private boolean puedeConstruir;
	private LinkedList<Integer> Alquileres = new LinkedList<Integer>();
	private Stack<Edificio> edificios = new Stack<Edificio>();

	public BuenosAiresSur(){
		super();
		precioCompra = 20000;
		valorCasa = 5000;
		valorHotel = 8000;
		costoAlquiler = 2000;
		costoAlquilerConCasa= 3000;
		costoAlquilerConDosCasas = 3500;
		costoAlquilerConHotel = 5000;
		puedeConstruir = true;
		 
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

		if(!unJugador.esDuenio(this) || !unJugador.esDuenio(tablero.getBuenosAiresNorte())) throw new JugadorNoTieneTerreno();

		if(unEdificio instanceof Hotel){
			if(this.edificios.size()!=2) return;
		}
			
		if(unEdificio instanceof Casa){
				if(this.edificios.size()>=2)return;
				this.edificios.add(unEdificio);
		}
		AlquilerActual = Alquileres.get(edificios.size() );

	}


	public int getCantidadDeEdificios(){
		return edificios.size();
	}


	@Override
	public void vaciarEdificios() {
		while(!this.edificios.empty()) {
			this.edificios.pop();
		}
		
	}
	
}
