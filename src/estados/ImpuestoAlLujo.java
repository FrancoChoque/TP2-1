package estados;

import modelo.Jugador.Jugador;

public class ImpuestoAlLujo extends EstadoCasillero {

	private final static  int PORCIENTO_DESCUENTO = 10;

	public void hacerEfectoDelCasillero(Jugador unJugador){
		int descuento = (PORCIENTO_DESCUENTO * (unJugador.getDinero())/100);
		unJugador.sumarDinero((-1)*descuento);
	}


	public String getNombre(){
		return "Impuesto al Lujo";
	}

	public String mensajeEfecto(Jugador unJugador){
		return "Pagas: " + (int)(unJugador.getDinero()*0.1);
	}
}
