package estados.Comprable.Propiedad;

import excepciones.*;
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


    public void construirCasa(Jugador unJugador) throws DineroInsuficiente, JugadorNoEsPropietario, JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {
        throw new NoPuedeConstruirMasCasas();
    }

    public void construirHotel(Jugador unJugador) throws DineroInsuficiente, JugadorNoEsPropietario, NoPuedeConstruirMasHoteles, CasasInsuficientes, JugadorNoPoseeTodosLosBarrios {
        if(!unJugador.puedePagar(propiedad.getValorHotel())) throw new DineroInsuficiente();
        propiedad.hacerHotel(unJugador);
        propiedad.setPropiedadEstado(propiedad.getPropiedadConHotel());

    }
}
