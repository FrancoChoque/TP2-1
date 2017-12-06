package controlador;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import modelo.Casillero;
import modelo.Tablero;
import modelo.Jugador.Jugador;
import vista.JugadorCapa;
import vista.VentanaOperacion;

public class BotonConstruirCasaHandler implements EventHandler<ActionEvent> {


	private VentanaJuego juego;

	
	public BotonConstruirCasaHandler(VentanaJuego ventana) {
		this.juego = ventana;
		
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

		App app = App.getInstance();
		AlgoPoly algopoly = app.getAlgoPoly();
		
		Jugador actual = algopoly.obtenerJugadorActual();
		String accion;
		
		Casillero casillero = Tablero.getInstance().obtenerCasillero(actual);
		Propiedad prop = (Propiedad) casillero.getestado();
		
		
		
		VentanaOperacion box = new VentanaOperacion();	
		box.ventanaconstruircasa(actual, prop);
		
		juego.actualizarCapa(actual);
	}

}
