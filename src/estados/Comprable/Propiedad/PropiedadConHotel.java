package estados.Comprable.Propiedad;

import excepciones.*;
import modelo.Jugador.Jugador;

public class PropiedadConHotel implements PropiedadEstado {


    Propiedad propiedad;


    public PropiedadConHotel(Propiedad unaPropiedad){
        propiedad = unaPropiedad;
    }


    public int getCostoPase() {
        return propiedad.getCostoAlquilerConHotel();
    }



    public void construirCasa(Jugador unJugador) throws DineroInsuficiente, JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {
        throw new NoPuedeConstruirMasCasas();
    }

    public void construirHotel(Jugador unJugador) throws DineroInsuficiente, NoPuedeConstruirMasHoteles, CasasInsuficientes, JugadorNoPoseeTodosLosBarrios {
        throw new NoPuedeConstruirMasHoteles();
    }



}
