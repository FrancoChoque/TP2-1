package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonIntercambiarTerrenoHandler implements EventHandler<ActionEvent> {

	Stage stage;
	Scene proximaEscena;
	
	 public BotonIntercambiarTerrenoHandler(Stage stage, Scene proximaEscena) {
	        this.stage = stage;
	        this.proximaEscena = proximaEscena;
	}
	@Override
	public void handle(ActionEvent event) {
		
		stage.setScene(proximaEscena);
        stage.setFullScreen(false);
	}

}
