package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VentanaOperacion;

public class BotonPagarFianzaHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		VentanaOperacion ventana = new VentanaOperacion();
		ventana.cobrarfianza();
	}

}
