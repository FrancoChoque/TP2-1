package estados.Comprable.Propiedad;

import modelo.Casa;
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


    public void construirCasa(Jugador unJugador){
        propiedad.hacerCasa(unJugador);
        propiedad.edificios.add(new Casa());
        propiedad.setPropiedadEstado(propiedad.getPropiedadConCasa());
    }

    public void construirHotel(Jugador unJugador){
    }


}
