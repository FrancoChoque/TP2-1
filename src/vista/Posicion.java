package vista;

public class Posicion {
	
	private static Posicion[] posiciones;
	private static int cantidad_casilleros = 20;
	
	
	//Las posiciones del jugador en la vista del tablero
	static {
		posiciones = new Posicion[cantidad_casilleros];
		posiciones[0] = new Posicion(770 , 770);  //Salida
		posiciones[1] = new Posicion(630 , 770);  //Quini6
		posiciones[2] = new Posicion(500 , 770);  //Buenos Aires Sur
		posiciones[3] = new Posicion(370 , 770);  //Edesur
		posiciones[4] = new Posicion(240 , 770);  //Buenos Aires Norte
		posiciones[5] = new Posicion(110 , 770);  //Carcel
		posiciones[6] = new Posicion(110 , 630);  //Cordoba sur
		posiciones[7] = new Posicion(110 , 500);  //Avance Dinamico
		posiciones[8] = new Posicion(110 , 370);  //Subte
		posiciones[9] = new Posicion(110 , 240);  //Cordoba norte
		posiciones[10] = new Posicion(110 , 110); //Impuesto al lujo
		posiciones[11] = new Posicion(240 , 110); //Santa fe
		posiciones[12] = new Posicion(370 , 110); //Aysa
		posiciones[13] = new Posicion(500 , 110); //Salta norte
		posiciones[14] = new Posicion(630 , 110); //Salta sur
		posiciones[15] = new Posicion(110 , 770); //Policia, ya que lo manda a la carcel
		posiciones[16] = new Posicion(770 , 240); //Tren
		posiciones[17] = new Posicion(770 , 370); //Neuquen
		posiciones[18] = new Posicion(770 , 500); //Retroceso dinamico
		posiciones[19] = new Posicion(770 , 630); //Tucuman
		
		
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
