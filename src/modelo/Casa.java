package modelo;


import estados.Comprable.Propiedad.Propiedad;
import excepciones.DineroInsuficiente;
import excepciones.JugadorNoEsPropietario;
import excepciones.JugadorNoPoseeTodosLosBarrios;
import excepciones.NoPuedeConstruirMasCasas;
import modelo.Jugador.Jugador;

public class Casa implements Edificio{


    @Override
    public void puedeConstruir(Jugador jugador, Propiedad propiedad) throws NoPuedeConstruirMasCasas, JugadorNoPoseeTodosLosBarrios {
        propiedad.puedeConstruir(jugador,this);
    }

    @Override
    public void construir(Jugador jugador, Propiedad propiedad) throws DineroInsuficiente {
        if(!jugador.puedePagar(propiedad.getValorCasa())) throw new DineroInsuficiente();
        jugador.sumarDinero(propiedad.getValorCasa() *-1);
        propiedad.getEdificios().add(this);
    }
}
