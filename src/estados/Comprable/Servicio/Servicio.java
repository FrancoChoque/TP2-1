package estados.Comprable.Servicio;


import estados.Comprable.Comprable;
import modelo.Jugador.Jugador;

public class Servicio extends Comprable {



    public void cobrarPase(Jugador unJugador){

        unJugador.sumarDinero(this.getCostoPase(unJugador.getValorDados())*-1);
        this.Duenio.sumarDinero(getCostoPase(unJugador.getValorDados()));
    }

    public void reembolsar(){

        Duenio.sumarDinero((int)(getPrecioCompra() - 0.15 * getPrecioCompra()));
        this.setDuenio(null);
        this.setEstado(this.getNoTieneDuenio());
    }


    public int getPrecioCompra(){
        return 0;
    }

    public int getCostoPase(int valorDados){
        return 0;
    }

    @Override
    public String mensajeEfecto(Jugador unJugador) {
        return "Costo del alquiler: " + getCostoPase(unJugador.getValorDados());
    }
}
