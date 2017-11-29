package vista.eventos;

import controlador.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonSalir implements EventHandler<ActionEvent>{
	
	public BotonSalir() {
       
	}
	
	@Override
	public void handle(ActionEvent event) {
		App datosVista = App.getInstance();
		datosVista.getPrimaryStage().setScene(datosVista.getecenaPrincipal());
	}
}
