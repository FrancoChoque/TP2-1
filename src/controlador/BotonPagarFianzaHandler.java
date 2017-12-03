package controlador;

import estados.Carcel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import modelo.Tablero;
import vista.VentanaOperacion;
import excepciones.DineroInsuficiente;
import excepciones.TurnosEnCalabozoInvalidoException;

public class BotonPagarFianzaHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		VentanaOperacion ventana = new VentanaOperacion();
		ventana.cobrarfianza();
	}

}
