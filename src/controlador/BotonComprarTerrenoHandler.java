package controlador;

import estados.Comprable.Comprable;
import excepciones.DineroInsuficiente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Casillero;
import modelo.Tablero;

public class BotonComprarTerrenoHandler implements EventHandler<ActionEvent> {

	private Stage stage;

	public BotonComprarTerrenoHandler(Stage stage) {
		this.stage = stage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		// Lo que hace el boton
		VentanaJuego juego = VentanaJuego.getInstance();
		System.out.println("Compro terreno");
		App app = App.getInstance();
		AlgoPoly algopoly = app.getAlgoPoly();
		Tablero tablero = algopoly.getTablero();
		Casillero casillero = tablero.obtenerCasillero(algopoly.obtenerJugadorActual());
		Comprable estado = (Comprable)casillero.getestado();
		try {
			algopoly.comprar( algopoly.obtenerJugadorActual() );
			juego.agregaraccion("Compraste " + casillero.getNombre() + " por $" + estado.getPrecioCompra() + "\n");
			juego.actualizarVenderTerreno(algopoly.obtenerJugadorActual() );
		} catch (DineroInsuficiente e) {
			AlertBox box = new AlertBox();
			box.errorcompra();
		}
		
		this.stage.close();
		
		
		juego.actualizardinero();
		
	}

}
