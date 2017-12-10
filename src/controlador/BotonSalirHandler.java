package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;

public class BotonSalirHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		App app = App.getInstance();
		AlgoPoly algopoly = app.getAlgoPoly();
		algopoly.resetear();
		
		app.menuPrincipal();
	}

}
