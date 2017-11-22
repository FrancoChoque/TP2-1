package Entrega3;

import modelo.*;
import modelo.Jugador.Jugador;

import org.junit.Test;

public class Prueba305Test {

    @Test

    public void test01NoSePuedeConstruirEnTerrenosSimples(){
        Tablero tablero = Tablero.resetInstance();
        Jugador jugador = new Jugador("jugador1");
        tablero.agregarJugador(jugador);

        jugador.comprarTerreno(tablero.getNeuquen());

        jugador.construirCasa(tablero.getNeuquen());

        jugador.construirHotel(tablero.getNeuquen());




    }

}
