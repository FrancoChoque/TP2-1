package estados.Comprable;


import estados.Comprable.Propiedad.Propiedad;
import modelo.Jugador.Jugador;


public class ComprableTieneDuenio implements ComprableEstado {


    Comprable comprable;

    public ComprableTieneDuenio(Comprable unComprable){

        comprable = unComprable;
    }



    public void hacerEfectoDelCasillero(Jugador unJugador){
            comprable.cobrarPase(unJugador);

    }

    @Override
    public void cambiarDuenio(Jugador unJugador) {
       //throw ya tiene duenio
    }

    @Override
    public Jugador preguntarDuenio() {
        return comprable.getDuenio();
    }

    @Override
    public boolean tieneDuenio() {
        return true;
    }

    @Override
    public void comprar(Jugador unjugador) {
        //no puedo comprar dos veces
        return;
    }

    @Override
    public void cobrarPase(Jugador unJugador) {

    }

    @Override
    public boolean esComprable() {
        return false;
    }
}
