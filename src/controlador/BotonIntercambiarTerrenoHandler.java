package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.ContenedorIntercambio;

public class BotonIntercambiarTerrenoHandler implements EventHandler<ActionEvent> {

	Stage stage;
	AlgoPoly algoPoly;
	Scene escenaAnterior;
	
	 public BotonIntercambiarTerrenoHandler(Stage stage, Scene escenaAnterior,AlgoPoly algoPoly) {
	        this.stage = stage;
	        this.algoPoly = algoPoly;
	        this.escenaAnterior = escenaAnterior;
	}
	@Override
	public void handle(ActionEvent event){
		ContenedorIntercambio contenedorIntercambio = new ContenedorIntercambio(this.stage,this.escenaAnterior,this.algoPoly);
        Scene escenaIntercambio = new Scene(contenedorIntercambio, 640, 480);
		stage.setScene(escenaIntercambio);
        stage.setFullScreen(false);
	}

}
