package estados;

import modelo.Jugador;

public class Quini6PagaPoco implements Quini6Estrategia {

    @Override
    public void aplicarQuini6(Jugador unJugador) {
        unJugador.sumarDinero(30000);

    }
}
