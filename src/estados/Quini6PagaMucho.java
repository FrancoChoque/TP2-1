package estados;

import modelo.Jugador;

public class Quini6PagaMucho implements Quini6Estrategia {

    @Override
    public void aplicarQuini6(Jugador unJugador) {
        unJugador.sumarDinero(50000);

    }
}
