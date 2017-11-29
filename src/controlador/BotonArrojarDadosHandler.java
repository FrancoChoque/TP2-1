package controlador;

import java.util.HashMap;

import excepciones.FinDelJuego;
import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import modelo.Jugador.Jugador;
import vista.JugadorCapa;

public class BotonArrojarDadosHandler implements EventHandler<ActionEvent> {

	private AlgoPoly algopoly;
	private HashMap<Jugador, JugadorCapa> hash;
	private Ventana ventana;

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Arrojar dados");
		Jugador actual = this.algopoly.obtenerJugadorActual();
		String accion;
		try {
			
			System.out.println(actual.nombre);
			this.algopoly.usarTurno(actual);
			
		
			accion = "Arrojaste los dados y sacaste: " + actual.getValorDados() + "\n";
			this.ventana.agregaraccion(accion);
			
		} catch (NoEsTurnoJugador | JugadorYaTiroDados e) {
			// TODO Auto-generated catch block
			accion = "Ya arrojaste los dados este turno.\n";
			this.ventana.agregaraccion(accion);
		} catch (FinDelJuego e) {
			// TODO Auto-generated catch block
			//System.out.println("Fin del juego");
		}
		JugadorCapa capa = hash.get(actual);
		capa.actualizar();
		this.ventana.actualizarposicion(actual);
		
	}
	
	public BotonArrojarDadosHandler(AlgoPoly unalgopoly, HashMap<Jugador, JugadorCapa> hash, Ventana unaventana) {
		this.algopoly = unalgopoly;
		this.hash = hash;
		this.ventana = unaventana;
	}

}
