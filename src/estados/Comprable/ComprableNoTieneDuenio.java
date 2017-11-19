package estados.Comprable;

import modelo.Jugador.Jugador;

public class ComprableNoTieneDuenio implements ComprableEstado{


    Comprable comprable;

    public ComprableNoTieneDuenio(Comprable unComprable){
        comprable = unComprable;
    }


    @Override
    public void hacerEfectoDelCasillero(Jugador unJugador) {
    }

    public void cambiarDuenio(Jugador jugador) {
        comprable.setDuenio(jugador);
        comprable.setComprableEstado(comprable.getComprableTieneDuenio());
    }

    @Override
    public Jugador preguntarDuenio() {
        //throw no tiene duenio
        return null;
    }

    @Override
    public boolean tieneDuenio() {
        return false;
    }

    @Override
    public void comprar(Jugador unJugador) {
    }

    @Override
    public void cobrarPase(Jugador unJugador) {
        //throw no tiene duenio
    }

    @Override
    public boolean esComprable() {
        return true;
    }
}
