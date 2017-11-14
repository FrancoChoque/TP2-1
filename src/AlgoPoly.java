public class AlgoPoly {


    private Tablero tablero;


    public AlgoPoly(){

        tablero = new Tablero();

    }


    public void usarTurno(Jugador unJugador){
    	
        int desplazamiento = unJugador.arrojarDados();

        tablero.moverJugador(unJugador, desplazamiento);

    }

    public Jugador nuevoJugador(String unNombre){

        Jugador jugador = new Jugador("Player 1");

        tablero.agregarJugador(jugador);

        return jugador;

    }


    public int obtenerPosicion(Jugador unJugador){

        return tablero.obtenerPosicion(unJugador);

    }




}
