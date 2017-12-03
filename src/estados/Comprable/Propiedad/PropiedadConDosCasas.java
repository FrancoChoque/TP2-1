package estados.Comprable.Propiedad;

import excepciones.*;
import modelo.Casa;
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


    public void construir(Jugador unJugador, Casa casa) throws DineroInsuficiente {

    }

    public void construir(Jugador unJugador, Hotel hotel) throws DineroInsuficiente {
        if(!unJugador.puedePagar(propiedad.getValorHotel())) throw new DineroInsuficiente();
        propiedad.setPropiedadEstado(propiedad.getPropiedadConHotel());

    }

    @Override
    public void puedeConstruir(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {
        throw new NoPuedeConstruirMasCasas();
    }

    @Override
    public void puedeConstruir(Jugador unJugador, Hotel hotel) throws JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles {
        propiedad.puedeEdificar(unJugador, hotel);
    }
}
