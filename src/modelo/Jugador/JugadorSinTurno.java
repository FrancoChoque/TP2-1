package modelo.Jugador;


import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;
import modelo.Dado;
import modelo.Edificio;


public class JugadorSinTurno implements EstadoDeJugador {

    Jugador jugador;


    public JugadorSinTurno(Jugador unJugador) {

        jugador = unJugador;

    }

    public void arrojarDados(Dado dado1, Dado dado2) throws NoEsTurnoJugador, JugadorYaTiroDados {

        throw new NoEsTurnoJugador();

    }

    @Override
    public void construir(Propiedad unaPropiedad, Edificio edificio) throws NoEsTurnoJugador, DineroInsuficiente {
        throw new NoEsTurnoJugador();
    }


    @Override
    public boolean puedeConstruir(Propiedad unaPropiedad, Edificio unEdificio) {
        return false;
    }

    @Override
    public void comprar(Comprable uncomprable) throws NoEsTurnoJugador {
        throw new NoEsTurnoJugador();
    }


    public void vender(Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario {
        throw new NoEsTurnoJugador();
    }


    public void pasarTurno() throws NoEsTurnoJugador{
        throw new NoEsTurnoJugador();
    }


    public void intercambiarPropiedades(Jugador unJugador, Comprable propiedadNueva, Comprable propiedadACambiar) {
    }

}
