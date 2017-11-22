package Entrega3;

import modelo.*;
import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class Prueba301Test {

    @Test

    public void test(){
        Tablero tablero = Tablero.resetInstance();
        Jugador jugador = new Jugador("jugador1");
        tablero.agregarJugador(jugador);
        tablero.moverJugador(jugador, 1);

        Assert.assertEquals(150000,jugador.getDinero());
    }

}
