package estados.Comprable.Servicio;


import estados.Comprable.Comprable;
import modelo.Jugador.Jugador;

public class Servicio extends Comprable {


    public void comprar(Jugador unJugador){

        unJugador.sumarDinero(this.getPrecioCompra()*-1);
        this.cambiarDuenio(unJugador);
    }

    public void cobrarPase(Jugador unJugador){

        unJugador.sumarDinero(this.getCostoPase(unJugador.getValorDados())*-1);
        this.Duenio.sumarDinero(getCostoPase(unJugador.getValorDados()));
    }

    public void reembolsar(){
        Duenio.sumarDinero((int)(getPrecioCompra() - 0.15 * getPrecioCompra()));
        Duenio = null;
        tieneDuenio = false;
    }


    public int getPrecioCompra(){
        return 0;
    }

    public int getCostoPase(int valorDados){
        return 0;
    }

}
