package modelo;

import estados.Propiedad;
import excepciones.*;

public interface EstadoDeJugador {

    public void arrojarDados()throws NoEsTurnoJugador, JugadorYaTiroDados;

    public void comprar(Propiedad unPropiedad) throws NoEsTurnoJugador;

    public void vender() throws NoEsTurnoJugador;

    public void pasarTurno() throws NoEsTurnoJugador, JugadorNoTiroDados;

}
