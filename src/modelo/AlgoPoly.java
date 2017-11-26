package modelo;
import java.util.LinkedList;

import estados.EstadoCasillero;
import estados.Comprable.Comprable;
import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;
import modelo.Jugador.Jugador;

public class AlgoPoly {


    private Tablero tablero;
    private LinkedList<Jugador> jugadores;
    private int actual = 0;

    public AlgoPoly(){

        tablero = Tablero.getInstance();
        tablero.resetearTablero();
        jugadores = new LinkedList<Jugador>();
    }


    public void usarTurno(Jugador unJugador) throws NoEsTurnoJugador, JugadorYaTiroDados {
    	
        unJugador.setEstado(unJugador.getJugadorEmpezandoTurno());

        unJugador.arrojarDados();
        
        System.out.println(unJugador.getValorDados() );

        tablero.moverJugador(unJugador, unJugador.getValorDados());

    }

    public Jugador nuevoJugador(String unNombre){

        Jugador jugador = new Jugador("Player 1");
        
        this.jugadores.add(jugador);
        
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


	public Jugador obtenerJugadorActual() {
		Jugador jugador = this.jugadores.get(actual);
		actual = (actual + 1) % this.jugadores.size();
		return jugador;
	}

    


}
