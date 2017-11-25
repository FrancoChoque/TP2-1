package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonVenderTerrenoHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		// Lo que hace el boton
		System.out.println("VendoTerreno");
	}

}
