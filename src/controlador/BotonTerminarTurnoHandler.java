package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import modelo.Jugador.Jugador;

public class BotonTerminarTurnoHandler implements EventHandler<ActionEvent> {

	private VentanaJuego ventana;

	AlgoPoly juego = App.getInstance().getAlgoPoly();
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Terminar turno");

		this.juego.avanzarJugador();
		this.ventana.actualizarturno();
		
		Jugador actual = this.juego.obtenerJugadorActual();
		ventana.mostrarcapa(actual);
		
		ventana.actualizarCapa(actual);
		
	}
	

	public BotonTerminarTurnoHandler(VentanaJuego ventana, AlgoPoly algopoly) {
		this.juego = algopoly;
		this.ventana = ventana;
	}
}
