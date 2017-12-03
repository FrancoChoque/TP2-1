package estados.Comprable;

import excepciones.DineroInsuficiente;
import modelo.Jugador.Jugador;

public class ComprableTieneDuenio implements ComprableEstado {



    Comprable comprable;


    public ComprableTieneDuenio(Comprable unComprable){
        comprable = unComprable;
    }



    public void hacerEfectoDelCasillero(Jugador unJugador) {
        comprable.cobrarPase(unJugador);
    }


    public void reembolsar(){
        comprable.reembolsar();
        comprable.setDuenio(null);
        comprable.setEstado(comprable.getNoTieneDuenio());
    }

    public void comprar(Jugador unjugador) throws DineroInsuficiente {
        System.out.println("tiene duenio");
    }

    public Jugador getDuenio(){
        return comprable.Duenio;
    }

    public boolean tieneDuenio(){
        return true;
    }

    public void cobrarPase(Jugador unJugador){}


}
