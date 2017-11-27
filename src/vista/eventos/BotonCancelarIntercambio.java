package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonCancelarIntercambio implements EventHandler<ActionEvent>{

	Stage stage;
	Scene anterior;
	
	public BotonCancelarIntercambio(Stage stage, Scene anterior) {
        this.stage = stage;
        this.anterior = anterior;
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		stage.setScene(this.anterior);
	}
}
