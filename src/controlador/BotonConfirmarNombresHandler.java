package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonConfirmarNombresHandler implements EventHandler<ActionEvent> {

	private VentanaLogin ventana;

	@Override
	public void handle(ActionEvent arg0) {
		ventana.confirmarnombres();
		
	}
	
	public BotonConfirmarNombresHandler(VentanaLogin ventana) {
		this.ventana = ventana;
	}

}
