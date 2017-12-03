package modelo.Jugador;

import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;
import modelo.Casa;
import modelo.Hotel;

public interface EstadoDeJugador {

    public void arrojarDados()throws NoEsTurnoJugador, JugadorYaTiroDados;

    public void comprar(Comprable uncomprable) throws NoEsTurnoJugador;

    public void construir(Propiedad unaPropiedad, Casa casa) throws DineroInsuficiente, JugadorNoPoseeTodosLosBarrios, JugadorNoEsPropietario, NoPuedeConstruirMasCasas;

    public void construir(Propiedad unaPropiedad, Hotel hotel) throws DineroInsuficiente, JugadorNoEsPropietario, JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles;

    public void vender(Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario;

    public void vender(Jugador unJugador, Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario, DineroInsuficiente;

    public void pasarTurno() throws NoEsTurnoJugador, JugadorNoTiroDados;

    public void intercambiarPropiedades(Jugador unJugador, Comprable propiedadNueva, Comprable propiedadACambiar);

}
