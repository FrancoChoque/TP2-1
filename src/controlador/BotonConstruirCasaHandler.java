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
import vista.JugadorCapa;

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
		
		LinkedList<Comprable> propiedadess = actual.getpropiedades();
		Iterator<Comprable> iter = propiedadess.iterator();
		HashMap<String, Propiedad> map = new HashMap<String, Propiedad>();
		while(iter.hasNext()) {
			Comprable comprable = iter.next();
			try {
				Propiedad prop = (Propiedad) comprable;
				map.put(prop.getNombre(), prop);
			} catch(ClassCastException e) {
				continue;			
			}
			
		}
		
		AlertBox box = new AlertBox();
		box.ventanaconstruircasa(this.juego, map);
		

	}

}
