package estados.Comprable;

import excepciones.DineroInsuficiente;
import modelo.Jugador.Jugador;

public interface ComprableEstado {


    public void hacerEfectoDelCasillero(Jugador unJugador);

    public void reembolsar();

    public Jugador getDuenio();

    public boolean tieneDuenio();

    public void comprar(Jugador unjugador) throws DineroInsuficiente;

    public void cobrarPase(Jugador unJugador);

    public String getMensaje(Jugador unJugador);






}
