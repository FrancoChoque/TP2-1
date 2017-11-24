package estados.Comprable.Propiedad;

import excepciones.*;
import modelo.Jugador.Jugador;

public interface PropiedadEstado {

    public int getCostoPase ();

    public void construirCasa(Jugador unJugador) throws DineroInsuficiente, JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas;

    public void construirHotel(Jugador unJugador) throws DineroInsuficiente, NoPuedeConstruirMasHoteles, CasasInsuficientes, JugadorNoPoseeTodosLosBarrios;

}
