package Entrega3;

import excepciones.CasasInsuficientes;
import modelo.*;
import modelo.Jugador.Jugador;

import org.junit.Assert;
import org.junit.Test;

public class Prueba305Test {

    @Test

    public void test01NoSePuedeConstruirEnTerrenosSimples() throws Exception {
        Tablero tablero = Tablero.resetInstance();
        Jugador jugador = new Jugador("jugador1");
        tablero.agregarJugador(jugador);


        jugador.setEstado(jugador.getJugadorEmpezandoTurno());

        jugador.comprar(tablero.getNeuquen());

        jugador.construir(tablero.getNeuquen(), new Casa());

        jugador.construir(tablero.getNeuquen(), new Hotel());

        Assert.assertEquals(jugador.puedeConstruir(tablero.getNeuquen(), new Hotel()), false);
    }


}
