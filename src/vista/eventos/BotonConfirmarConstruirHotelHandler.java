package vista.eventos;

import controlador.App;
import controlador.VentanaJuego;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Edificio;
import modelo.Hotel;
import modelo.Tablero;
import modelo.Jugador.Jugador;

public class BotonConfirmarConstruirHotelHandler implements EventHandler<ActionEvent> {

	private Stage stage;


	public BotonConfirmarConstruirHotelHandler(Stage stage) {
		// TODO Auto-generated constructor stub
		this.stage = stage;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		App app = App.getInstance();
		AlgoPoly algopoly = app.getAlgoPoly();
		Jugador actual = algopoly.obtenerJugadorActual();
		
		Propiedad prop = (Propiedad) Tablero.getInstance().obtenerCasillero(actual).getestado();
		
		VentanaJuego juego = VentanaJuego.getInstance();
		
		
		try {

			Edificio edificio = new Hotel();
			actual.construir(prop, edificio);
			juego.play(new AudioClip("file:src/Sonido/constuir.mp3"));
			juego.agregaraccion("Construiste un hotel en " + prop.getNombre() + "\n");
			juego.agregaraccion("Por un costo de $" + prop.getValorHotel() + "\n");
		} catch (DineroInsuficiente e) {

			juego.agregaraccion("No tienes suficientes fondos para construir\n");
		} catch (NoEsTurnoJugador noEsTurnoJugador) {
			noEsTurnoJugador.printStackTrace();
		}

		VentanaJuego.getInstance().actualizarBotones();

		this.stage.close();
	}

}
