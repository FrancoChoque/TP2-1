package vista.eventos;

import java.util.HashMap;

import controlador.App;
import controlador.VentanaJuego;
import estados.Comprable.Comprable;
import excepciones.JugadorNoEsPropietario;
import excepciones.NoEsTurnoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Jugador.Jugador;

public class BotonConfirmarVenderTerrenoHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	private ComboBox<String> combobox;
	private HashMap<String, Comprable> map;

	public BotonConfirmarVenderTerrenoHandler(Stage stage, ComboBox<String> combobox, HashMap<String, Comprable> hash) {
		this.stage = stage;
		// TODO Auto-generated constructor stub
		this.combobox = combobox;
		this.map = hash;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		App app = App.getInstance();
		AlgoPoly algopoly = app.getAlgoPoly();
		Jugador actual = algopoly.obtenerJugadorActual();
		String eleccion = this.combobox.getValue();
		Comprable comprable = this.map.get(eleccion);
		
		VentanaJuego juego = VentanaJuego.getInstance();
		
		try {
			int dineroanterior = actual.getDinero();
			algopoly.vender(actual,comprable);
			int dineroactual = actual.getDinero()-dineroanterior;
			juego.agregaraccion("Vendiste " + comprable.getNombre() + "por $"+ dineroactual +  "\n");
		} catch (NoEsTurnoJugador e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JugadorNoEsPropietario e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.stage.close();
		juego.actualizarCapa(actual);
	}

}
