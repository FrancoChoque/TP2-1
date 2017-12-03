package controlador;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.CasasInsuficientes;
import excepciones.JugadorNoPoseeTodosLosBarrios;
import excepciones.NoPuedeConstruirMasHoteles;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	}

}
