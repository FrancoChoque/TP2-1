package modelo.Jugador;

import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;

public interface EstadoDeJugador {

    public void arrojarDados()throws NoEsTurnoJugador, JugadorYaTiroDados;

    public void comprar(Comprable uncomprable) throws NoEsTurnoJugador;

    public void construirCasa(Propiedad unaPropiedad);

    public void construirHotel(Propiedad unaPropiedad);

    public void vender(Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario;

    public void vender(Jugador unJugador, Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario, DineroInsuficiente;

    public void pasarTurno() throws NoEsTurnoJugador, JugadorNoTiroDados;

}
