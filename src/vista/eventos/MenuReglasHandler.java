package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VentanaOperacion;

public class MenuReglasHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		VentanaOperacion ventana = new VentanaOperacion();
		ventana.menuReglas();
	}

}
