package estados;




import java.util.HashMap;

import modelo.Jugador.Jugador;

public class Quini6 extends EstadoCasillero {

	private HashMap<Jugador,Integer> numeroDeVecesEnQuini;

	private int[] premio;

	public Quini6(){
		super();
		this.numeroDeVecesEnQuini = new HashMap<Jugador,Integer>();

		this.premio = new int[3];

		this.premio[0] = 50000;
		this.premio[1] = 30000;
		this.premio[2] = 0;

	}


	public void hacerEfectoDelCasillero(Jugador unJugador) {

		unJugador.sumarDinero(getDinero(unJugador));

		if (!numeroDeVecesEnQuini.containsKey(unJugador)) {
			numeroDeVecesEnQuini.put(unJugador, 1);
		}else numeroDeVecesEnQuini.put(unJugador, numeroDeVecesEnQuini.get(unJugador) + 1);

	}

	public String getNombre(){
		return "Quini6";
	}

	public String mensajeEfecto(Jugador unJugador) {
		return "Sumas: $" + getDinero(unJugador);
	}

	public int getDinero(Jugador unJugador){

		if(!numeroDeVecesEnQuini.containsKey(unJugador)) {
			return premio[0];
		}

		int cantidadVeces = numeroDeVecesEnQuini.get(unJugador);

		if (cantidadVeces > 1) return 0;

		return (premio[cantidadVeces]);
	}

}


