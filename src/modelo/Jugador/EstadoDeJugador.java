package modelo.Jugador;

import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;
import modelo.Dado;
import modelo.Edificio;

public interface EstadoDeJugador {

    public void arrojarDados(Dado dado1, Dado dado2)throws NoEsTurnoJugador, JugadorYaTiroDados;

    public void comprar(Comprable uncomprable) throws NoEsTurnoJugador;

    public void construir(Propiedad unaPropiedad, Edificio edificio) throws NoEsTurnoJugador, DineroInsuficiente;

    public boolean puedeConstruir(Propiedad unaPropiedad, Edificio edificio);

    public void vender(Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario;

    public void pasarTurno() throws NoEsTurnoJugador, JugadorNoTiroDados;

    public void intercambiarPropiedades(Jugador unJugador, Comprable propiedadNueva, Comprable propiedadACambiar);

}
