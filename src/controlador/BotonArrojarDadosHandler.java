package controlador;

import java.util.HashMap;

import estados.EstadoCasillero;
import estados.Comprable.Comprable;
import excepciones.FinDelJuego;
import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoPoly;
import modelo.Casillero;
import modelo.Tablero;
import modelo.Jugador.Jugador;
import vista.JugadorCapa;

public class BotonArrojarDadosHandler implements EventHandler<ActionEvent> {

	private AlgoPoly algopoly;
	private HashMap<Jugador, JugadorCapa> hash;
	private VentanaJuego ventana =  VentanaJuego.getInstance();
	private Button boton;

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Arrojar dados");
		Jugador actual = this.algopoly.obtenerJugadorActual();
		String accion;
		AlertBox box = new AlertBox();
		try {
			
			System.out.println(actual.nombre);
			this.algopoly.usarTurno(actual);

			box.display(algopoly.getTablero().obtenerCasillero(actual).getNombre(), actual.getValorDados());
		
			accion = "Arrojaste los dados y sacaste: " + actual.getValorDados() + "\n";
			this.ventana.agregaraccion(accion);
			
		} catch (NoEsTurnoJugador | JugadorYaTiroDados e) {
			// TODO Auto-generated catch block
			box.error("Ya arrojaste los dados este turno.\nDebes esperar al proximo turno.");
			
			accion = "Ya arrojaste los dados este turno.\n";
			this.ventana.agregaraccion(accion);
			return;
		} catch (FinDelJuego e) {
			// TODO Auto-generated catch block
			//System.out.println("Fin del juego");
		}
		
		this.ventana.actualizarposicion(actual);
		if(actual.getEstadoDeJugador() == actual.getJugadorTiroDados()) {
			boton.setDisable(true);
			this.ventana.setTerminarturno(false);

		}

		this.ventana.actualizarBotones();

		//Casilleros comprables
		casillerocomprable();
		
		JugadorCapa capa = hash.get(actual);
		capa.actualizar();


	}
	
	private void casillerocomprable() {
		// TODO Auto-generated method stub
		Tablero tablero = this.algopoly.getTablero();
		Casillero casillero = tablero.obtenerCasillero(this.algopoly.obtenerJugadorActual() );
		EstadoCasillero estado = casillero.getestado();
		AlertBox box = new AlertBox();
		try {
			Comprable uncomprable = (Comprable) estado;
			if(uncomprable.tieneDuenio()) return;
			box.ofrecercompra((EstadoCasillero) uncomprable);
			
		} catch(ClassCastException e) {
			return;
		}
	}

	public BotonArrojarDadosHandler(AlgoPoly unalgopoly, HashMap<Jugador, JugadorCapa> hash, VentanaJuego unaventana, Button botonArrojarDados) {
		this.algopoly = unalgopoly;
		this.hash = hash;
		this.ventana = unaventana;
		this.boton = botonArrojarDados;
	}

}
