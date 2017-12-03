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
		
		LinkedList<Comprable> propiedadess = actual.getpropiedades();
		Iterator<Comprable> iter = propiedadess.iterator();
		HashMap<String, Propiedad> map = new HashMap<String, Propiedad>();
		
		while(iter.hasNext()) {
			Comprable comprable = iter.next();
			try {
				Propiedad prop = (Propiedad) comprable;
				prop.hacerHotel(actual);
				map.put(prop.getNombre(), prop);
			} catch(ClassCastException e) {
				continue;			
			} catch (CasasInsuficientes e) {
				// TODO Auto-generated catch block
				continue;
			} catch (NoPuedeConstruirMasHoteles e) {
				// TODO Auto-generated catch block
				continue;
			} catch (JugadorNoPoseeTodosLosBarrios e) {
				// TODO Auto-generated catch block
				continue;
			}
		}
		
		VentanaOperacion ventana = new VentanaOperacion();
		ventana.setMap(map);
		ventana.construirhotel();
	}

}
