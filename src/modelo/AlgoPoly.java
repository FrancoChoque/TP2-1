package modelo;
import estados.EstadoCasillero;
import estados.Comprable.Comprable;
import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;
import modelo.Jugador.Jugador;

public class AlgoPoly {


    private Tablero tablero;


    public AlgoPoly(){

        tablero = Tablero.getInstance();
        tablero.resetearTablero();

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
    
    public void comprar(Jugador unjugador) {
    	Casillero unacasilla = tablero.obtenerCasillero(unjugador);
    	EstadoCasillero unestado = unacasilla.getestado();
    	try {
    		unjugador.comprar((Comprable) unestado);
    	}
    	catch(ClassCastException e) {
    		//no puede comprar
    	}
    	catch (NoEsTurnoJugador e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    


}
