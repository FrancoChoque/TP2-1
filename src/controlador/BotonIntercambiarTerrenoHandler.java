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
        contenedorIntercambio.elegirJugador();
	}

}
