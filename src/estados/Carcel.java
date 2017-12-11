package estados;


import java.util.HashMap;

import excepciones.DineroInsuficiente;
import excepciones.TurnosEnCalabozoInvalidoException;
import modelo.Jugador.Jugador;
import vista.eventos.mensajescasillero.Mensaje;


public class Carcel extends EstadoCasillero {

	private HashMap<Jugador, Integer> calabozo;

	private int montoFianza = 45000;



	public Carcel() {

		calabozo = new HashMap<Jugador, Integer>();
	}


	@Override
	public void hacerEfectoDelCasillero(Jugador unjugador) {

		if(! calabozo.containsKey(unjugador) ) {
			calabozo.put(unjugador, 0);
			unjugador.cambiarMovimiento(false);
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

		if(!puedePagarFianza(unjugador)) throw new TurnosEnCalabozoInvalidoException();

		if(!unjugador.puedePagar(montoFianza)) throw new DineroInsuficiente();

		unjugador.sumarDinero(montoFianza  * -1);

		this.liberar(unjugador);
	}



	public boolean puedePagarFianza(Jugador unJugador){

		if(!calabozo.containsKey(unJugador)) return false;

		int turnosEnCalabozo = calabozo.get(unJugador);

		if((turnosEnCalabozo == 2) || (turnosEnCalabozo == 3)) return true;
		else return false;
	}


	private void liberar(Jugador unjugador) {

		calabozo.remove(unjugador);
		unjugador.cambiarMovimiento(true);

	}

	public String getNombre(){
		return "Carcel";
	}

	public String getMensaje(Jugador jugador){
		if(calabozo.containsKey(jugador)) return "Tenes que esperar: " + (3- preguntarTurnosEnCalabozo(jugador))+ " turnos.";
		return "Tenes que esperar: " + (4- preguntarTurnosEnCalabozo(jugador))+ " turnos.";
}

	public void mensajeEfecto(Jugador unJugador){

		Mensaje mensaje = new Mensaje();

		mensaje.mensajeEfecto(unJugador,this);
	}
}
