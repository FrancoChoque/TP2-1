package controlador;

import controlador.excepciones.NombreInvalidoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonConfirmarNombresHandler implements EventHandler<ActionEvent> {

	private Login ventana;
	private Stage stage;

	@Override
	public void handle(ActionEvent arg0) {
		App app = App.getInstance();
		try {
			ventana.confirmarnombres();
			String nombrejugador1 = ventana.getNombrejugador1();
			String nombrejugador2 = ventana.getNombrejugador2();
			//String nombrejugador3 = ventana.getNombrejugador3();
			System.out.println(nombrejugador1 + "\n" + nombrejugador2 + "\n" );
			stage.close();
			VentanaJuego juego = new VentanaJuego();
			juego.initialize(app.getPrimaryStage(),app.getAlgoPoly(),
					this.ventana.getNombrejugador1(),this.ventana.getNombrejugador2());

		} catch (NombreInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public BotonConfirmarNombresHandler(Login login, Stage stage) {
		this.ventana = login;
		this.stage = stage;
	}

}
