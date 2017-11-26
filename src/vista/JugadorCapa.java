package vista;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modelo.Tablero;
import modelo.Jugador.Jugador;

public class JugadorCapa {
	
	private Jugador jugador;
	private GraphicsContext gc;
	private Posicion posicionactual = Posicion.getPosicionJugador(0);
	private int alturajugador = 15;
	private int largojugador = 15;
	private Color color;
	
	public JugadorCapa(GraphicsContext ungc, Jugador unjugador, Color uncolor) {
		this.jugador = unjugador;
		this.gc = ungc;
		this.color = uncolor;
	}
	
	public void clean() {
		this.gc.clearRect(posicionactual.getx(), posicionactual.gety(), largojugador, alturajugador);
	}
	
	public void dibujar() {
		this.clean();
		
		Tablero tablero = Tablero.getInstance();
		int posicionjugador = tablero.obtenerPosicion(jugador);
		posicionactual = Posicion.getPosicionJugador(posicionjugador);
		
		this.gc.setFill(color);
		this.gc.fillRect(posicionactual.getx(), posicionactual.gety(), largojugador, alturajugador);
	}
	
	
	
	
	
	
	
	
	
	
}
