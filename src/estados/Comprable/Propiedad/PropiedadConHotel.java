package estados.Comprable.Propiedad;

import excepciones.*;
import modelo.Casa;
import modelo.Hotel;
import modelo.Jugador.Jugador;

public class PropiedadConHotel implements PropiedadEstado {


    Propiedad propiedad;


    public PropiedadConHotel(Propiedad unaPropiedad){
        propiedad = unaPropiedad;
    }


    public int getCostoPase() {
        return propiedad.getCostoAlquilerConHotel();
    }



    public void construir(Jugador unJugador, Casa casa) throws DineroInsuficiente {
    }

    public void construir(Jugador unJugador, Hotel hotel) throws DineroInsuficiente {
    }

    @Override
    public void puedeConstruir(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {
        throw new NoPuedeConstruirMasCasas();
    }

    @Override
    public void puedeConstruir(Jugador unJugador, Hotel hotel) throws JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles {
        throw new NoPuedeConstruirMasHoteles();
    }


}
