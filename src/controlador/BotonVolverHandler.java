package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVolverHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	

	public BotonVolverHandler(Stage stage) {

		this.stage = stage;
		// TODO Auto-generated constructor stub

	}

	@Override
	public void handle(ActionEvent arg0) {
		this.stage.close();
	}

}
