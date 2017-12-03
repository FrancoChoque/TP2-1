package vista.eventos;

import controlador.App;
import controlador.VentanaJuego;
import estados.Carcel;
import excepciones.DineroInsuficiente;
import excepciones.TurnosEnCalabozoInvalidoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Tablero;

public class BotonConfirmarCobrarFianzaHandler implements EventHandler<ActionEvent> {

	private Stage stage;

	public BotonConfirmarCobrarFianzaHandler(Stage stage) {
		this.stage = stage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

		String accion;
		Carcel carcel = Tablero.getInstance().getCarcel();
		AlgoPoly algopoly = App.getInstance().getAlgoPoly();
		
		
		try {
			carcel.cobrarFianza(algopoly.obtenerJugadorActual());
			accion = "Pagaste $45000 de fianza y saliste de la carcel.\n";
		} catch (DineroInsuficiente e) {
			accion = "No tienes suficiente dinero para pagar fianza.\n";
		} catch (TurnosEnCalabozoInvalidoException e) {
			accion = "No puedes pagar la fianza en este turno.\n";
		}
			
		VentanaJuego.getInstance().agregaraccion(accion);
		this.stage.close();
	}

}
