package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonIntercambioJugador implements EventHandler<ActionEvent> {

	Stage stage;
   // Scene proximaEscena;
    

    public BotonIntercambioJugador(Stage stage/*, Scene proximaEscena*/) {
        this.stage = stage;
        //this.proximaEscena = proximaEscena;
    }
	@Override
    public void handle(ActionEvent actionEvent) {
		
		System.out.println("Intercambio");
    }
	
}
