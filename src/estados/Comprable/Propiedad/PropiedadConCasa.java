package estados.Comprable.Propiedad;

import excepciones.*;
import modelo.Jugador.Jugador;

public class PropiedadConCasa implements PropiedadEstado {

    private Propiedad propiedad;

    public PropiedadConCasa(Propiedad unaPropiedad){
        propiedad = unaPropiedad;
    }

    public int getCostoPase() {
        return propiedad.getCostoAlquilerConCasa();
    }



    public void construirCasa(Jugador unJugador) throws DineroInsuficiente, JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {
        if(!unJugador.puedePagar(propiedad.getValorHotel())) throw new DineroInsuficiente();
        propiedad.hacerCasa(unJugador);
        propiedad.setPropiedadEstado(propiedad.getPropiedadConDosCasas());
    }

    public void construirHotel(Jugador unJugador) throws DineroInsuficiente, NoPuedeConstruirMasHoteles, CasasInsuficientes, JugadorNoPoseeTodosLosBarrios {

        propiedad.hacerHotel(unJugador);

    }

}
