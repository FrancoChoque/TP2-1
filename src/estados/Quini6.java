package estados;




import java.util.HashMap;

import modelo.Jugador.Jugador;

public class Quini6 extends Suerte {

    private HashMap<Jugador,Integer> numeroDeVecesEnQuini;

    private int[] premio;
	
	public Quini6(){
		super();
	    this.numeroDeVecesEnQuini = new HashMap<Jugador,Integer>();

	    this.premio = new int[2];

	    this.premio[0] = 50000;
	    this.premio[1] = 30000;

	}
	
	public void agregarJugador(Jugador unJugador){
		numeroDeVecesEnQuini.put(unJugador, 0);
	}
	
	public int cantidadDevecesQueCalloJugador(Jugador unJugador){
		
		return this.numeroDeVecesEnQuini.get(unJugador);
	}
	
	public void hacerEfectoDelCasillero(Jugador unJugador) {

        if (!numeroDeVecesEnQuini.containsKey(unJugador)) {
            numeroDeVecesEnQuini.put(unJugador, 0);
        }

        int cantidadVeces = numeroDeVecesEnQuini.get(unJugador);

        if (cantidadVeces > 1) return;

        unJugador.sumarDinero(premio[cantidadVeces]);

        numeroDeVecesEnQuini.put(unJugador, cantidadVeces + 1);

        }

	public String getNombre(){
		return "Quini6";
	}

    }


