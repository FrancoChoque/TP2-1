package estados.Comprable.Servicio;


import estados.Comprable.Comprable;
import modelo.Jugador.Jugador;

public abstract class Servicio extends Comprable {



    public void cobrarPase(Jugador unJugador){

        unJugador.sumarDinero(this.getCostoPase(unJugador)*-1);
        this.Duenio.sumarDinero(getCostoPase(unJugador));
    }

    public void reembolsar(){

        Duenio.sumarDinero((int)(getPrecioCompra() - 0.15 * getPrecioCompra()));
        this.setDuenio(null);
        this.setEstado(this.getNoTieneDuenio());
    }


    public abstract int getPrecioCompra();

    public abstract int getCostoPase(Jugador unJugador);

}
