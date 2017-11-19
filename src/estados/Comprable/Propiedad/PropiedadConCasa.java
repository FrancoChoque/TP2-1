package estados.Comprable.Propiedad;

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


    public void edificar(Jugador unJugador){
        propiedad.construirCasa(unJugador);
    }

}
