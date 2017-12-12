package controlador;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import estados.Comprable.Comprable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.AlgoPoly;
import modelo.Jugador.Jugador;
import vista.VentanaOperacion;

public class BotonVenderTerrenoHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {


		
		App app = App.getInstance();
		AlgoPoly algopoly = app.getAlgoPoly();		
		Jugador actual = algopoly.obtenerJugadorActual();
		
		VentanaOperacion ventana = new VentanaOperacion();
		ventana.venderterreno(actual);

		VentanaJuego ventanaJuego = VentanaJuego.getInstance();

		
		ventanaJuego.actualizarCapa(actual);
		ventanaJuego.actualizardinero();
	}

}
