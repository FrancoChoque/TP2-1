package modelo.Jugador;


import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;
import modelo.Casa;
import modelo.Dado;
import modelo.Hotel;


public class JugadorSinTurno implements EstadoDeJugador {

    Jugador jugador;


    public JugadorSinTurno(Jugador unJugador) {


        jugador = unJugador;

    }

    public void arrojarDados(Dado dado1, Dado dado2) throws NoEsTurnoJugador, JugadorYaTiroDados {

        throw new NoEsTurnoJugador();

    }

    public void construir(Propiedad unaPropiedad, Casa casa) throws DineroInsuficiente, JugadorNoPoseeTodosLosBarrios, JugadorNoEsPropietario, NoPuedeConstruirMasCasas {

    }

    public void construir(Propiedad unaPropiedad, Hotel hotel) throws DineroInsuficiente, JugadorNoEsPropietario, JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles {

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


    public void intercambiarPropiedades(Jugador unJugador, Comprable propiedadNueva, Comprable propiedadACambiar) {
    }

}
