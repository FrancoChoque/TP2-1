package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonComprarTerrenoHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		// Lo que hace el boton
		System.out.println("Compro terreno");
	}

}
