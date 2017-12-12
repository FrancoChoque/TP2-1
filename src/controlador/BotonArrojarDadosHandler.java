package controlador;

import java.util.HashMap;

import estados.EstadoCasillero;
import estados.Comprable.Comprable;
import estados.Movimiento;
import excepciones.DineroInsuficiente;
import excepciones.FinDelJuego;
import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import modelo.AlgoPoly;
import modelo.Casillero;
import modelo.Tablero;
import modelo.Jugador.Jugador;
import vista.JugadorCapa;
import vista.VentanaOperacion;
import vista.eventos.mensajescasillero.Mensaje;

public class BotonArrojarDadosHandler implements EventHandler<ActionEvent> {

	private AlgoPoly algopoly;
	private HashMap<Jugador, JugadorCapa> hash;
	private VentanaJuego ventana =  VentanaJuego.getInstance();
	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Arrojar dados");
		Jugador actual = this.algopoly.obtenerJugadorActual();
		String accion;
		AlertBox box = new AlertBox();
		try {


			this.algopoly.arrojarDados(actual);

			ventana.play(new AudioClip("file:src/Sonido/dados.mp3"));

			EstadoCasillero casillero = algopoly.getTablero().obtenerCasillero(actual).getestado();

			box.display(casillero.getNombre(), actual.getValorDado1(), actual.getValorDado2());

			accion = "Arrojaste los dados y sacaste: " + actual.getValorDado1() + " y " + actual.getValorDado2() + "\n";

			this.ventana.agregaraccion(accion);

			mensajeEfecto(actual);

			this.algopoly.efectoCasillero(actual);

			if(casillero instanceof Movimiento) {
				mensajeEfecto(actual);
				this.algopoly.efectoCasillero(actual);
			}

			this.algopoly.tiraDeVuelta(actual);
			if(actual.getEstadoDeJugador() == actual.getJugadorEmpezandoTurno() )
				VentanaJuego.getInstance().agregaraccion("Sacaste dados iguales. Vuelves a tirar.\n");

			
		} catch (NoEsTurnoJugador | JugadorYaTiroDados e) {
			// TODO Auto-generated catch block
			box.error("Ya arrojaste los dados este turno.\nDebes esperar al proximo turno.");
			
			accion = "Ya arrojaste los dados este turno.\n";
			this.ventana.agregaraccion(accion);
			return;
		} catch (FinDelJuego e) {
			// TODO Auto-generated catch block
			//System.out.println("Fin del juego");
		} catch (DineroInsuficiente e) {
			this.ventana.actualizarposicion(actual);
			if(actual.getCantidadPropiedad() == 0) {
				this.hash.get(actual).ocultar(); //mando la capa al fondo
				this.algopoly.quitarJugador(actual);
			}
			else {
				VentanaOperacion ventana = new VentanaOperacion();
				ventana.venderterreno(actual);
				this.algopoly.efectoCasillero(actual);
			}
		}
		
		this.ventana.actualizarposicion(actual);


		this.ventana.actualizarBotones();

		JugadorCapa capa = hash.get(actual);
		capa.actualizar();
	}



	private void mensajeEfecto(Jugador jugador) {

		Tablero tablero = this.algopoly.getTablero();
		Mensaje mensaje = new Mensaje();
		mensaje.mensajeEfecto(jugador,tablero.obtenerCasillero(jugador).getestado());
	}

	public BotonArrojarDadosHandler(AlgoPoly unalgopoly, HashMap<Jugador, JugadorCapa> hash, VentanaJuego unaventana, Button botonArrojarDados) {
		this.algopoly = unalgopoly;
		this.hash = hash;
		this.ventana = unaventana;
	}

}
