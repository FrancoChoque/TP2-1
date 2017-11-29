package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.ContenedorIntercambio;

public class BotonIntercambiarTerrenoHandler implements EventHandler<ActionEvent> {

	 public BotonIntercambiarTerrenoHandler() {
	        
	}
	@Override
	public void handle(ActionEvent event){
		ContenedorIntercambio contenedorIntercambio = new ContenedorIntercambio();
        Scene escenaIntercambio = new Scene(contenedorIntercambio, 640, 480);
        App app = App.getInstance();
        app.getPrimaryStage().setScene(escenaIntercambio);
        app.getPrimaryStage().setFullScreen(false);
	}

}
