package modelo;

import estados.Propiedad;
import excepciones.*;

public interface EstadoDeJugador {

    public void arrojarDados()throws NoEsTurnoJugador, JugadorYaTiroDados;

    public void comprar(Propiedad unPropiedad) throws NoEsTurnoJugador;

    public void pagar() throws NoEsTurnoJugador;

    public void pasarTurno() throws NoEsTurnoJugador;

}
