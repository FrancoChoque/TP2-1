package estados.Comprable.Propiedad;

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

    public void edificar(Jugador unJugador){
        propiedad.construirHotel(unJugador);
        propiedad.setPropiedadEstado(propiedad.getPropiedadConHotel());
    }
}
