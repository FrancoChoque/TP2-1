package controlador;

import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import modelo.*;
import modelo.Jugador.Jugador;

public class BotonConfirmarConstruirCasaHandler implements EventHandler<ActionEvent> {

	private Stage stage;


	public BotonConfirmarConstruirCasaHandler(Stage stage) {
		this.stage = stage;
		// TODO Auto-generated constructor stub

	}


	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		App app = App.getInstance();
		AlgoPoly algopoly = app.getAlgoPoly();
		Jugador actual = algopoly.obtenerJugadorActual();
		Propiedad propiedad = (Propiedad) Tablero.getInstance().obtenerCasillero(actual).getestado();
		Edificio edificio = new Casa();
		VentanaJuego juego = VentanaJuego.getInstance();
		
		
		try {
			actual.construir(propiedad,edificio);

			juego.agregaraccion("Construiste una casa en " + propiedad.getNombre() + "\n");
			juego.agregaraccion("Por un costo de $" + propiedad.getValorCasa() + "\n");
		} catch (DineroInsuficiente e) {
			// TODO Auto-generated catch block

			juego.agregaraccion("No tienes suficientes fondos para construir\n");
		} catch (NoEsTurnoJugador noEsTurnoJugador) {
			noEsTurnoJugador.printStackTrace();
		}

		VentanaJuego.getInstance().actualizarBotones();
		this.stage.close();
		
		VentanaJuego.getInstance().actualizarCapa(actual);
	}

}
