package estados.Comprable.Propiedad;

import modelo.Hotel;
import modelo.Jugador.Jugador;

public class PropiedadConDosCasas implements PropiedadEstado {

    private Propiedad propiedad;

    public PropiedadConDosCasas(Propiedad unaPropiedad){
        propiedad = unaPropiedad;
    }

    public int getCostoPase() {

        return propiedad.getCostoAlquilerConDosCasas();
    }

    public int getCostoEdificar() {
        return propiedad.getValorHotel();
    }

    public void construirCasa(Jugador unJugador){
    }

    public void construirHotel(Jugador unJugador){
        propiedad.hacerHotel(unJugador);
        propiedad.edificios.add(new Hotel());
        propiedad.setPropiedadEstado(propiedad.getPropiedadConHotel());
    }
}
