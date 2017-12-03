package controlador;

import java.util.HashMap;

import estados.EstadoCasillero;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.DineroInsuficiente;
import excepciones.JugadorNoEsPropietario;
import excepciones.JugadorNoPoseeTodosLosBarrios;
import excepciones.NoPuedeConstruirMasCasas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Casa;
import modelo.Tablero;
import modelo.Jugador.Jugador;

public class BotonConfirmarConstruirCasaHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	private ComboBox<String> combobox;
	private HashMap<String, Propiedad> map;

	public BotonConfirmarConstruirCasaHandler(Stage stage, ComboBox<String> combobox, HashMap<String, Propiedad> map) {
		this.stage = stage;
		// TODO Auto-generated constructor stub
		this.combobox = combobox;
		this.map = map;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		App app = App.getInstance();
		AlgoPoly algopoly = app.getAlgoPoly();
		Jugador actual = algopoly.obtenerJugadorActual();
		String eleccion = this.combobox.getValue();
		Propiedad propiedad = this.map.get(eleccion);
		
		VentanaJuego juego = VentanaJuego.getInstance();
		
		
		try {
			actual.construir(propiedad,new Casa());

			juego.agregaraccion("Construiste una casa en " + propiedad.getNombre() + "\n");
			juego.agregaraccion("Por un costo de $" + propiedad.getValorCasa() + "\n");
		} catch (DineroInsuficiente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			juego.agregaraccion("No tienes suficientes fondos para construir\n");
		} catch (JugadorNoPoseeTodosLosBarrios e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String otra = propiedad.otropar();
			juego.agregaraccion("Te falta comprar "+ otra +"\n");
		} catch (JugadorNoEsPropietario e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			juego.agregaraccion("No eres propietario del barrio\n");
		} catch (NoPuedeConstruirMasCasas e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			juego.agregaraccion("No puedes construir mas casas aqui\n");
		}
		
		this.stage.close();
		
		
	}

}
