package vista;

public class Posicion {

	public  static Posicion[] posiciones;
	private static int cantidad_casilleros = 20;
	private static double largo = 130;
	private static double alto = 130;

	public static double getlargo() {
		return largo;
	}

	public static double getalto() {
		return alto;
	}

	//Las posiciones del jugador en la vista del tablero
	static {
		posiciones = new Posicion[cantidad_casilleros];
		posiciones[0] = new Posicion(668, 668);  //Salida
		posiciones[1] = new Posicion(535 , 668);  //Quini6
		posiciones[2] = new Posicion(402 , 668);  //Buenos Aires Sur
		posiciones[3] = new Posicion(268 , 668);  //Edesur
		posiciones[4] = new Posicion(134 , 668);  //Buenos Aires Norte
		posiciones[5] = new Posicion(2 , 668);  //Carcel
		posiciones[6] = new Posicion(2 , 535);  //Cordoba sur
		posiciones[7] = new Posicion(2 , 402);  //Avance Dinamico
		posiciones[8] = new Posicion(2, 268);  //Subte
		posiciones[9] = new Posicion(2 , 134);  //Cordoba norte
		posiciones[10] = new Posicion(2 , 2); //Impuesto al lujo
		posiciones[11] = new Posicion(134 , 2); //Santa fe
		posiciones[12] = new Posicion(268 , 2); //Aysa
		posiciones[13] = new Posicion(402 , 2); //Salta norte
		posiciones[14] = new Posicion(535 , 2); //Salta sur
		posiciones[15] = new Posicion(2 , 668); //Policia, ya que lo manda a la carcel
		posiciones[16] = new Posicion(668 , 134); //Tren
		posiciones[17] = new Posicion(668 , 268); //Neuquen
		posiciones[18] = new Posicion(668 , 402); //Retroceso dinamico
		posiciones[19] = new Posicion(668 , 535); //Tucuman


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
