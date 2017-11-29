package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;

public class BotonTerminarTurnoHandler implements EventHandler<ActionEvent> {

	private Ventana ventana;
	private AlgoPoly juego;
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Terminar turno");
		
		this.juego.avanzarJugador();
		this.ventana.actualizarturno();
		
		
	}
	

	public BotonTerminarTurnoHandler(Ventana ventana, AlgoPoly algopoly) {
		this.juego = algopoly;
		this.ventana = ventana;
	}
}
