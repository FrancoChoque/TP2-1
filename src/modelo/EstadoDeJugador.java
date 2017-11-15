package modelo;

import estados.Terreno;
import excepciones.*;

public interface EstadoDeJugador {

    public void arrojarDados()throws NoEsTurnoJugador, JugadorYaTiroDados;

    public void comprar(Terreno unTerreno) throws NoEsTurnoJugador;

    public void pagar() throws NoEsTurnoJugador;

    public void pasarTurno() throws NoEsTurnoJugador;

}
