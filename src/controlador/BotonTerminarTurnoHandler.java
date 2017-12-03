package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import modelo.Jugador.Jugador;
import vista.JugadorCapa;

public class BotonTerminarTurnoHandler implements EventHandler<ActionEvent> {

	private VentanaJuego ventana;
	private AlgoPoly juego;
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Terminar turno");
		
		Jugador anterior = this.juego.obtenerJugadorActual();
		ventana.escondercapa(anterior);
		
		this.juego.avanzarJugador();
		this.ventana.actualizarturno();
		
		Jugador actual = this.juego.obtenerJugadorActual();
		ventana.mostrarcapa(actual);
		
		
	}
	

	public BotonTerminarTurnoHandler(VentanaJuego ventana, AlgoPoly algopoly) {
		this.juego = algopoly;
		this.ventana = ventana;
	}
}
