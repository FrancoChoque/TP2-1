package vista;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import estados.EstadoCasillero;
import estados.Comprable.Comprable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import modelo.Tablero;
import modelo.Jugador.Jugador;

public class JugadorCapa {
	
	//Metodos y atributos de clase
	
	//agrego dibujos de casa y hotel como atributo de clase
		
	private static Image iconohotel;
	private static Image iconocasa;
		
	static {
		iconocasa = new Image("imagenes/casa.png");
	    iconohotel = new Image("imagenes/hotel.png");
	}
	
	public Image getIconoCasa() {
		return iconocasa;
	}
	
	public Image getIconoHotel() {
		return iconohotel;
	}
	
	
	//Metodos y atributos de clase
	
	private Jugador jugador;
	private GraphicsContext gc;
	private Posicion posicionactual = Posicion.getPosicionJugador(0);
	private int alturajugador = 25;
	private int largojugador = 25;
	private Color color;
	private double desfasejugador = 60;
	private Image icono;
	
	
	public JugadorCapa(GraphicsContext ungc, Jugador unjugador, Color uncolor, Image iconojugador1) {
		this.jugador = unjugador;
		this.gc = ungc;
		this.color = uncolor;
		this.gc.setFill(Color.TRANSPARENT);
        this.gc.fillRect(0, 0, 800, 800);
        this.icono = iconojugador1;
	}
	
	public void clean() {

		this.gc.clearRect(posicionactual.getx() + desfasejugador, posicionactual.gety() + desfasejugador, largojugador, alturajugador);
	}
	
	public void dibujar() {
		
		Tablero tablero = Tablero.getInstance();
		int posicionjugador = tablero.obtenerPosicion(jugador);
		posicionactual = Posicion.getPosicionJugador(posicionjugador);
		
		this.gc.drawImage(icono, posicionactual.getx() + desfasejugador, posicionactual.gety() + desfasejugador,
				largojugador, alturajugador);
		
		
		marcarpropiedades();
	}

	private void marcarpropiedades() {
		// Recuadra las propiedades del jugador
		Tablero tablero = Tablero.getInstance();
		HashMap<Comprable, Integer> comprables = tablero.obtenerComprables();
		Set<Comprable> set = comprables.keySet();
		Iterator<Comprable> iter = set.iterator();
		while(iter.hasNext()) {
			Comprable comprable = iter.next();
			int numcasillero = comprables.get(comprable);
			Posicion pos = Posicion.getPosicionJugador(numcasillero);
			if(comprable.getDuenio() == this.jugador) {
				double alto = Posicion.getalto();
				double largo = Posicion.getlargo();
				
				this.gc.setStroke(color);
				
				this.gc.strokeLine(pos.getx(), pos.gety(), 
						pos.getx() + largo, pos.gety());
				
				this.gc.strokeLine(pos.getx(), pos.gety(), 
						pos.getx() , pos.gety() + alto);
				
				this.gc.strokeLine(pos.getx() + largo, pos.gety(), 
						pos.getx() + largo , pos.gety() + alto);
				
				this.gc.strokeLine(pos.getx(), pos.gety() + alto, 
						pos.getx() + largo , pos.gety() + alto);
				
			}
		}
	}

	public void actualizar() {
		// TODO Auto-generated method stub
		this.clean();
		this.dibujar();
	}
	
	
	
	
	
	
	
	
	
	
}
