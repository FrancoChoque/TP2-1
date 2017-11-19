package estados.Comprable.Propiedad;

import modelo.Jugador.Jugador;

public class PropiedadSinCasa implements PropiedadEstado {

    private Propiedad propiedad;

    public PropiedadSinCasa(Propiedad unaPropiedad){
        propiedad = unaPropiedad;
    }


    public int getCostoPase(){
        return propiedad.getCostoAlquiler();

    }

    public int getCostoEdificar(){
        return propiedad.getValorCasa();
    }


    public void edificar(Jugador unJugador){
        propiedad.construirCasa(unJugador);
        propiedad.setPropiedadEstado(propiedad.getPropiedadConCasa());
    }



}
