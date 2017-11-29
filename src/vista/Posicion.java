package vista;

public class Posicion {
	
	private static Posicion[] posiciones;
	private static int cantidad_casilleros = 20;
	
	
	//Las posiciones del jugador en la vista del tablero
	static {
		posiciones = new Posicion[cantidad_casilleros];
		posiciones[0] = new Posicion(500, 500);  //Salida
		posiciones[1] = new Posicion(400 , 500);  //Quini6
		posiciones[2] = new Posicion(300 , 500);  //Buenos Aires Sur
		posiciones[3] = new Posicion(200 , 500);  //Edesur
		posiciones[4] = new Posicion(100 , 500);  //Buenos Aires Norte
		posiciones[5] = new Posicion(0 , 500);  //Carcel
		posiciones[6] = new Posicion(0 , 400);  //Cordoba sur
		posiciones[7] = new Posicion(0 , 300);  //Avance Dinamico
		posiciones[8] = new Posicion(0 , 200);  //Subte
		posiciones[9] = new Posicion(0 , 100);  //Cordoba norte
		posiciones[10] = new Posicion(0 , 0); //Impuesto al lujo
		posiciones[11] = new Posicion(100 , 0); //Santa fe
		posiciones[12] = new Posicion(200 , 0); //Aysa
		posiciones[13] = new Posicion(300 , 0); //Salta norte
		posiciones[14] = new Posicion(400 , 0); //Salta sur
		posiciones[15] = new Posicion(0 , 500); //Policia, ya que lo manda a la carcel
		posiciones[16] = new Posicion(500 , 100); //Tren
		posiciones[17] = new Posicion(500 , 200); //Neuquen
		posiciones[18] = new Posicion(500 , 300); //Retroceso dinamico
		posiciones[19] = new Posicion(500 , 400); //Tucuman
		
		
	}
	
	
	
	private int y;
	private int x;

	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	static public Posicion getPosicionJugador(int posicionJugador) {
		return posiciones[posicionJugador];
	}

	public double gety() {
		// TODO Auto-generated method stub
		return this.y;
	}

	public double getx() {
		// TODO Auto-generated method stub
		return this.x;
	}
	
	
}
