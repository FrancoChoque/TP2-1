package estados.Comprable;

import modelo.Jugador.Jugador;

public interface ComprableEstado {

    public void hacerEfectoDelCasillero(Jugador unJugador);

    public void cambiarDuenio(Jugador jugador);

    public Jugador preguntarDuenio();

    public boolean tieneDuenio();

    public void comprar(Jugador unjugador);

    public void cobrarPase(Jugador unJugador);

    public boolean esComprable();
}
