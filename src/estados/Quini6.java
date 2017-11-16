package estados;




import java.util.HashMap;

import modelo.Jugador;

public class Quini6 extends Suerte {

    private HashMap<Jugador,Integer> numeroDeVecesEnQuini;

	Quini6Estrategia quini6Estrategia;
	
	public Quini6(){
		super();
	    this.numeroDeVecesEnQuini = new HashMap<Jugador,Integer>();

	}
	
	public void agregarJugador(Jugador unJugador){
		numeroDeVecesEnQuini.put(unJugador, 0);
	}
	
	public int cantidadDevecesQueCalloJugador(Jugador unJugador){
		
		return this.numeroDeVecesEnQuini.get(unJugador);
	}
	
	public void hacerEfectoDelCasillero(Jugador unJugador){

	    setQuini6Estrategia(unJugador);

		pagarQuini6(unJugador);

	}

	private void setQuini6Estrategia(Jugador unJugador){

        if(!numeroDeVecesEnQuini.containsKey(unJugador) ) {
            numeroDeVecesEnQuini.put(unJugador, 1);
            this.quini6Estrategia = new Quini6PagaMucho();
            return;
        }

        int cantidadVeces = numeroDeVecesEnQuini.get(unJugador);
        cantidadVeces ++;
        numeroDeVecesEnQuini.put(unJugador, cantidadVeces );

        if(cantidadVeces == 2 ) {
            this.quini6Estrategia = new Quini6PagaPoco();
        }else {
            this.quini6Estrategia = new Quini6NoPaga();
        }


    }

	public void pagarQuini6(Jugador unJugador){
        this.quini6Estrategia.aplicarQuini6(unJugador);
    }
}
