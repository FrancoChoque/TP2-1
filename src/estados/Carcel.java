package estados;


import java.util.HashMap;

import excepciones.DineroInsuficiente;
import excepciones.TurnosEnCalabozoInvalidoException;
import modelo.Jugador.Jugador;



public class Carcel extends EstadoCasillero {

	private HashMap<Jugador, Integer> calabozo;

	private int montoFianza = 45000;



	public Carcel() {

		calabozo = new HashMap<Jugador, Integer>();
	}


	@Override
	public void hacerEfectoDelCasillero(Jugador unjugador) {

	    if(! calabozo.containsKey(unjugador) ) {
			calabozo.put(unjugador, 1);
			unjugador.cambiarMovimiento();
			return;
		}

		int turnosEnCarcel = calabozo.get(unjugador);
		turnosEnCarcel++;
		calabozo.put(unjugador, turnosEnCarcel);

		if(turnosEnCarcel == 4) liberar(unjugador);


	}


	public int preguntarTurnosEnCalabozo(Jugador unjugador) {

	    if(! calabozo.containsKey(unjugador) ) return 0;
		return calabozo.get(unjugador);
	}


	public void cobrarFianza(Jugador unjugador) {

	    if(! calabozo.containsKey(unjugador) ) return;

		int turnosEnCalabozo = calabozo.get(unjugador);

		if((turnosEnCalabozo == 2) || (turnosEnCalabozo == 3)){

			if(! unjugador.puedePagar(montoFianza) ) {
				throw new DineroInsuficiente();
			}
            unjugador.sumarDinero(montoFianza  * -1);
			this.liberar(unjugador);
		}

		else {
			throw new TurnosEnCalabozoInvalidoException();
		}

	}


	private void liberar(Jugador unjugador) {

	    calabozo.remove(unjugador);
		unjugador.cambiarMovimiento();

	}

	public String getNombre(){
		return "Carcel";
	}

	public boolean esComprable() {
		return false;
	}
}
