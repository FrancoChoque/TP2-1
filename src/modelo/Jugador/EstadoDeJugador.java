package modelo.Jugador;

import estados.Comprable;
import estados.Propiedad;
import excepciones.*;
import modelo.Edificio;

public interface EstadoDeJugador {

    public void arrojarDados()throws NoEsTurnoJugador, JugadorYaTiroDados;

    public void comprar(Comprable uncomprable) throws NoEsTurnoJugador;

    public void edificar(Propiedad unaPropiedad, Edificio unEdificio) throws NoEsTurnoJugador, JugadorNoTieneTerreno;

    public void vender() throws NoEsTurnoJugador;

    public void pasarTurno() throws NoEsTurnoJugador, JugadorNoTiroDados;

}
