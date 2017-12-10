package estados;

import modelo.Jugador.Jugador;
import vista.eventos.mensajescasillero.Mensaje;

public class ImpuestoAlLujo extends EstadoCasillero {

	private final static  int PORCIENTO_DESCUENTO = 10;

	public void hacerEfectoDelCasillero(Jugador unJugador){
		int descuento = (PORCIENTO_DESCUENTO * (unJugador.getDinero())/100);
		unJugador.sumarDinero((-1)*descuento);
	}


	public String getNombre(){
		return "Impuesto al Lujo";
	}

	public String getMensaje(Jugador unJugador){
		return "Pagas: " + (int)(unJugador.getDinero()*0.1);
	}

	public void mensajeEfecto(Jugador unJugador) {

		Mensaje mensaje = new Mensaje();

		mensaje.mensajeEfecto(unJugador,this);
	}
}
