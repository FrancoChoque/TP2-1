package controlador;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import modelo.Jugador.Jugador;
import vista.VentanaOperacion;

public class BotonVenderTerrenoHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {


		
		App app = App.getInstance();
		AlgoPoly algopoly = app.getAlgoPoly();		
		Jugador actual = algopoly.obtenerJugadorActual();
		
		LinkedList<Comprable> propiedadess = actual.getpropiedades();
		Iterator<Comprable> iter = propiedadess.iterator();
		HashMap<String, Comprable> map = new HashMap<String, Comprable>();
		
		while(iter.hasNext()) {
			Comprable comprable = iter.next();
			map.put(comprable.getNombre(), comprable);			
		}
		
		VentanaOperacion ventana = new VentanaOperacion();
		ventana.venderterreno(map);
		
		VentanaJuego.getInstance().actualizarCapa(actual);
		VentanaJuego.getInstance().actualizardinero();
	}

}
