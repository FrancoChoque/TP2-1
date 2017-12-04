package vista.eventos;

import estados.Comprable.Comprable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Jugador.Jugador;
import vista.ContenedorIntercambio;

public class BotonIntercambioJugador implements EventHandler<ActionEvent> {

	Stage stage;
	Jugador remitente;
	Jugador destinatario;

    public BotonIntercambioJugador(Stage stage,Jugador remitente, Jugador destinatario ) {
        this.stage = stage;
    	this.remitente = remitente;
        this.destinatario = destinatario;
    }
	@Override
    public void handle(ActionEvent actionEvent) {
		ContenedorIntercambio contenedorIntercambio = new ContenedorIntercambio();
		contenedorIntercambio.ElegirPropiedades(stage,remitente,destinatario);
		
	}
	
}
