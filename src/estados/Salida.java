package estados;


import modelo.Jugador;

public class Salida extends EstadoCasillero {

    private int direccion; //hacia donde apunta la flecha


    @Override
    public boolean esComprable() {
        return false;
    }

    @Override
    public void hacerEfectoDelCasillero(Jugador unJugador) {

    }
}
