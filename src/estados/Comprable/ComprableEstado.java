package estados.Comprable;

import modelo.Jugador.Jugador;

public interface ComprableEstado {


    public void hacerEfectoDelCasillero(Jugador unJugador);

    public void reembolsar();

    public Jugador getDuenio();

    public boolean tieneDuenio();

    public void comprar(Jugador unjugador);

    public void cobrarPase(Jugador unJugador);



}
