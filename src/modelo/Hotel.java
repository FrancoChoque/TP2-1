package modelo;


import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;
import modelo.Jugador.Jugador;

public class Hotel implements Edificio {
    @Override
    public void puedeConstruir(Jugador jugador, Propiedad propiedad) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasHoteles, CasasInsuficientes {
        propiedad.puedeConstruir(jugador,this);
    }

    @Override
    public void construir(Jugador jugador, Propiedad propiedad) throws DineroInsuficiente {
        if(!jugador.puedePagar(propiedad.getValorHotel())) throw new DineroInsuficiente();
        jugador.sumarDinero(propiedad.getValorHotel() *-1);
        propiedad.getEdificios().add(this);
    }
}
