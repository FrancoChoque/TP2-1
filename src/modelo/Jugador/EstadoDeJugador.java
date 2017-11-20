package modelo.Jugador;

import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;

public interface EstadoDeJugador {

    public void arrojarDados()throws NoEsTurnoJugador, JugadorYaTiroDados;

    public void comprar(Comprable uncomprable) throws NoEsTurnoJugador;

    public void construirCasa(Propiedad unaPropiedad);

    public void construirHotel(Propiedad unaPropiedad);

    public void vender(Comprable unComprable) throws NoEsTurnoJugador;

    public void vender(Jugador unJugador, Comprable unComprable) throws NoEsTurnoJugador;

    public void pasarTurno() throws NoEsTurnoJugador, JugadorNoTiroDados;

}
