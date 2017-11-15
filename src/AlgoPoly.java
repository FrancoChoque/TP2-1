import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;

public class AlgoPoly {


    private Tablero tablero;


    public AlgoPoly(){

        tablero = Tablero.getInstance();

    }


    public void usarTurno(Jugador unJugador) throws NoEsTurnoJugador, JugadorYaTiroDados {
    	
        unJugador.setEstado(unJugador.getJugadorEmpezandoTurno());

        unJugador.arrojarDados();

        tablero.moverJugador(unJugador, unJugador.getValorDados());

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
