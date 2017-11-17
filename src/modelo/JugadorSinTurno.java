package modelo;


import estados.Comprable;
import estados.Propiedad;
import excepciones.*;


public class JugadorSinTurno implements EstadoDeJugador {

    Jugador jugador;


    public JugadorSinTurno(Jugador unJugador) {


        jugador = unJugador;

    }

    public void arrojarDados() throws NoEsTurnoJugador, JugadorYaTiroDados {

        throw new NoEsTurnoJugador();

    }
    
    @Override
    public void comprar(Comprable uncomprable) throws NoEsTurnoJugador {
        throw new NoEsTurnoJugador();
    }

    public void vender() throws NoEsTurnoJugador{
        throw new NoEsTurnoJugador();
    }

    public void pasarTurno() throws NoEsTurnoJugador{
        throw new NoEsTurnoJugador();
    }


}
