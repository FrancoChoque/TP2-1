package controlador;

import controlador.excepciones.NombreInvalidoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonConfirmarNombresHandler implements EventHandler<ActionEvent> {

	private VentanaLogin ventana;

	@Override
	public void handle(ActionEvent arg0) {
		App app = App.getInstance();
		try {
			ventana.confirmarnombres();
			String nombrejugador1 = ventana.getNombrejugador1();
			String nombrejugador2 = ventana.getNombrejugador2();
			String nombrejugador3 = ventana.getNombrejugador3();
			System.out.println(nombrejugador1 + "\n" + nombrejugador2 + "\n" + nombrejugador3 + "\n");
		} catch (NombreInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public BotonConfirmarNombresHandler(VentanaLogin ventana) {
		this.ventana = ventana;
	}

}
