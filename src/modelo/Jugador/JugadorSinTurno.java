package modelo.Jugador;


import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;


public class JugadorSinTurno implements EstadoDeJugador {

    Jugador jugador;


    public JugadorSinTurno(Jugador unJugador) {


        jugador = unJugador;

    }

    public void arrojarDados() throws NoEsTurnoJugador, JugadorYaTiroDados {

        throw new NoEsTurnoJugador();

    }

    public void construirCasa(Propiedad unaPropiedad){

    }

    public void construirHotel(Propiedad unaPropiedad){

    }
    
    @Override
    public void comprar(Comprable uncomprable) throws NoEsTurnoJugador {
        //catch si le esta comprando a otro jugador
    }

    public void vender(Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario {
        throw new NoEsTurnoJugador();
    }

    public void vender(Jugador unJugador, Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario, DineroInsuficiente {
        throw new NoEsTurnoJugador();
    }

    public void pasarTurno() throws NoEsTurnoJugador{
        throw new NoEsTurnoJugador();
    }


}
