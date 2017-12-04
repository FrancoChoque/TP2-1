package vista;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import estados.EstadoCasillero;
import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import estados.Comprable.Propiedad.PropiedadConCasa;
import estados.Comprable.Propiedad.PropiedadConDosCasas;
import estados.Comprable.Propiedad.PropiedadConHotel;
import estados.Comprable.Propiedad.PropiedadEstado;
import estados.Comprable.Propiedad.PropiedadSinCasa;
import javafx.scene.canvas.Canvas;
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
	private static int desfaseEdificioY;
	private static int desfaseEdificioX1;
	private static int desfaseEdificioX2;
	private static int alturaedificio;
	private static int largoedificio;
		
	static {
		iconocasa = new Image("file:src/imagenes/casa.png");
	    iconohotel = new Image("file:src/imagenes/hotel.png");
	    desfaseEdificioX1 = 0;
	    desfaseEdificioX2 = 35;
	    desfaseEdificioY = 60;
	    alturaedificio = 30;
	    largoedificio = 30;
	}
	
	public static Image getIconoCasa() {
		return iconocasa;
	}
	
	public static Image getIconoHotel() {
		return iconohotel;
	}
	
	public static int getalturaedificio(){
		return alturaedificio;
	}
	
	public static int getlargoedificio() {
		return largoedificio;
	}
	
	public static int getdesfaseX1() {
		return desfaseEdificioX1;
	}
	
	public static int getdesfaseX2() {
		return desfaseEdificioX2;
	}
	
	public static int getdesfaseY() {
		return desfaseEdificioY;
	}
	
	
	//Metodos y atributos de clase
	
	private Jugador jugador;
	private GraphicsContext gc;
	private Posicion posicionactual = Posicion.getPosicionJugador(0);
	private int alturajugador = 30;
	private int largojugador = 30;
	private Color color;
	private double desfasejugador = 70;
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
		this.gc.clearRect(0, 0, 600, 600); //limpia todo el canvas
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


		LinkedList<Comprable> list = this.jugador.getpropiedades();
		Iterator<Comprable> iter = list.iterator();
		while(iter.hasNext()) {
			Comprable comprable = iter.next();
			int numcasillero = comprables.get(comprable);
			Posicion pos = Posicion.getPosicionJugador(numcasillero);

			double alto = Posicion.getalto();
			double largo = Posicion.getlargo();
				
			this.gc.setStroke(color);
			this.gc.setLineWidth(3);
				
			this.gc.strokeLine(pos.getx(), pos.gety(), 
					pos.getx() + largo, pos.gety());
				
			this.gc.strokeLine(pos.getx(), pos.gety(), 
					pos.getx() , pos.gety() + alto);
				
			this.gc.strokeLine(pos.getx() + largo, pos.gety(), 
					pos.getx() + largo , pos.gety() + alto);
				
			this.gc.strokeLine(pos.getx(), pos.gety() + alto, 
					pos.getx() + largo , pos.gety() + alto);
				
			try {
				Propiedad prop = (Propiedad) comprable;
				prop.getPropiedadEstado().dibujarEdificios(this.gc, pos);
				
			} catch (ClassCastException e) {
				continue;
			}
			
			
		}
	}
	

	public void actualizar() {
		// TODO Auto-generated method stub
		this.clean();
		this.dibujar();
	}

	public void ocultar() {
		// TODO Auto-generated method stub
		this.clean();
	}

	public void mostrar() {
		// TODO Auto-generated method stub
		this.gc.getCanvas().toFront();
	}

	public Color getColor() {
		return color;
	}
}
