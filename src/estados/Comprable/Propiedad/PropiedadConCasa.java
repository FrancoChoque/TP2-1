package estados.Comprable.Propiedad;

import modelo.Casa;
import modelo.Jugador.Jugador;

public class PropiedadConCasa implements PropiedadEstado {

    private Propiedad propiedad;

    public PropiedadConCasa(Propiedad unaPropiedad){
        propiedad = unaPropiedad;
    }

    public int getCostoPase() {
        return propiedad.getCostoAlquilerConCasa();
    }

    public int getCostoEdificar() {
        return propiedad.getValorCasa();
    }

    public void construirCasa(Jugador unJugador){
        propiedad.hacerCasa(unJugador);
        propiedad.setPropiedadEstado(propiedad.getPropiedadConDosCasas());
        propiedad.edificios.add(new Casa());
    }

    public void construirHotel(Jugador unJugador){

        propiedad.getPrecioCompra();

        return;
    }

}
