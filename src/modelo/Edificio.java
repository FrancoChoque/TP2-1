package modelo;

import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;
import modelo.Jugador.Jugador;

public interface Edificio {

    public void puedeConstruir(Jugador jugador, Propiedad propiedad) throws NoPuedeConstruirMasCasas, JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasHoteles, CasasInsuficientes;

    public void construir(Jugador jugador, Propiedad propiedad) throws DineroInsuficiente;
}
