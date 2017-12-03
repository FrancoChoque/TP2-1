package estados.Comprable.Propiedad;

import excepciones.*;
import modelo.Casa;
import modelo.Hotel;
import modelo.Jugador.Jugador;

public class PropiedadSinCasa implements PropiedadEstado {

    private Propiedad propiedad;

    public PropiedadSinCasa(Propiedad unaPropiedad){
        propiedad = unaPropiedad;
    }


    public int getCostoPase(){
        return propiedad.getCostoAlquiler();

    }


<<<<<<< HEAD
    public void construirCasa(Jugador unJugador) throws DineroInsuficiente, JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {
        if(!unJugador.puedePagar(propiedad.getValorCasa())) throw new DineroInsuficiente();
        propiedad.hacerCasa(unJugador);
=======
    public void construir(Jugador unJugador, Casa casa) throws DineroInsuficiente {
        if(!unJugador.puedePagar(propiedad.getValorCasa())) throw new DineroInsuficiente();
>>>>>>> b2bc54ecda81db8007f32a63e3faf8def2477149
        propiedad.setPropiedadEstado(propiedad.getPropiedadConCasa());
    }

    public void construir(Jugador unJugador, Hotel hotel) throws DineroInsuficiente {
    }

    @Override
    public void puedeConstruir(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {
        propiedad.puedeEdificar(unJugador, casa);
    }

    @Override
    public void puedeConstruir(Jugador unJugador, Hotel hotel) throws JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles {
        throw new CasasInsuficientes();
    }


}
