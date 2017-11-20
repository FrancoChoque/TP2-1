package estados.Comprable.Propiedad;

import excepciones.*;
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


    public void construirCasa(Jugador unJugador) throws DineroInsuficiente, JugadorNoEsPropietario, JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {
        if(!unJugador.puedePagar(propiedad.getValorHotel())) throw new DineroInsuficiente();
        propiedad.hacerCasa(unJugador);
        propiedad.setPropiedadEstado(propiedad.getPropiedadConCasa());
    }

    public void construirHotel(Jugador unJugador) throws DineroInsuficiente, JugadorNoEsPropietario, NoPuedeConstruirMasHoteles, CasasInsuficientes, JugadorNoPoseeTodosLosBarrios {
        throw new CasasInsuficientes();
    }


}
