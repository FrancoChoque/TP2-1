package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonIntercambioJugador1 implements EventHandler<ActionEvent> {

	Stage stage;
   // Scene proximaEscena;
    

    public BotonIntercambioJugador1(Stage stage/*, Scene proximaEscena*/) {
        this.stage = stage;
        //this.proximaEscena = proximaEscena;
    }
	@Override
    public void handle(ActionEvent actionEvent) {
       //la proxima escena aca va 
		System.out.println("Intercambio");
    }
	
}
