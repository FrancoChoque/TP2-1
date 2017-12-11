package controlador;

import estados.Comprable.Propiedad.Propiedad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.AlgoPoly;
import modelo.Tablero;
import modelo.Jugador.Jugador;
import vista.VentanaOperacion;

public class BotonConstruirHotelHandler implements EventHandler<ActionEvent> {

	public BotonConstruirHotelHandler() {
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Construir hotel");
		
		App app = App.getInstance();
		AlgoPoly algopoly = app.getAlgoPoly();		
		Jugador actual = algopoly.obtenerJugadorActual();
		
		Propiedad prop = (Propiedad) Tablero.getInstance().obtenerCasillero(actual).getestado();
		
		VentanaOperacion ventana = new VentanaOperacion();

		ventana.ventanaconstruirhotel(prop);

		VentanaJuego.getInstance().play(new AudioClip("file:src/Sonido/constuir.mp3"));
		
		VentanaJuego.getInstance().actualizarCapa(actual);
	}

}
