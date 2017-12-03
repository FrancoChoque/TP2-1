package vista.eventos;

import java.util.HashMap;

import controlador.App;
import controlador.VentanaJuego;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.CasasInsuficientes;
import excepciones.DineroInsuficiente;
import excepciones.JugadorNoEsPropietario;
import excepciones.JugadorNoPoseeTodosLosBarrios;
import excepciones.NoPuedeConstruirMasHoteles;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Hotel;
import modelo.Tablero;
import modelo.Jugador.Jugador;

public class BotonConfirmarConstruirHotelHandler implements EventHandler<ActionEvent> {

	private Stage stage;


	public BotonConfirmarConstruirHotelHandler(Stage stage) {
		// TODO Auto-generated constructor stub
		this.stage = stage;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		App app = App.getInstance();
		AlgoPoly algopoly = app.getAlgoPoly();
		Jugador actual = algopoly.obtenerJugadorActual();
		
		Propiedad prop = (Propiedad) Tablero.getInstance().obtenerCasillero(actual).getestado();
		
		VentanaJuego juego = VentanaJuego.getInstance();
		
		
		try {
			actual.construir(prop, new Hotel());

			juego.agregaraccion("Construiste un hotel en " + prop.getNombre() + "\n");
			juego.agregaraccion("Por un costo de $" + prop.getValorCasa() + "\n");
		} catch (DineroInsuficiente e) {
			// TODO Auto-generated catch block
			juego.agregaraccion("No tienes suficientes fondos para construir\n");
		} catch (JugadorNoPoseeTodosLosBarrios e) {
			// TODO Auto-generated catch block
			String otra = prop.otropar();
			juego.agregaraccion("Te falta comprar "+ otra +"\n");
		} catch (JugadorNoEsPropietario e) {
			// TODO Auto-generated catch block
			juego.agregaraccion("No eres propietario del barrio\n");
		} catch (NoPuedeConstruirMasHoteles e) {
			// TODO Auto-generated catch block
			juego.agregaraccion("No puedes construir mas hoteles en el barrio\n");
		} catch (CasasInsuficientes e) {
			// TODO Auto-generated catch block
			juego.agregaraccion("Los barrios no tienen la maxima cantidad de casas\n");
		}
		
		this.stage.close();
	}

}
