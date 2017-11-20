package Entrega2;

import estados.Comprable.Comprable;
import excepciones.NoEsTurnoJugador;
import modelo.Jugador.Jugador;
import modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class Prueba214Test {

    @Test
    public void test01JugadorVendePropiedadYPierdeTodasLasConstrucciones(){

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player1 = new Jugador("Vendedor");
        Jugador player2 = new Jugador("Comprador");
        Jugador player3 = new Jugador("Inquilino");

        untablero.agregarJugador(player1);
        untablero.agregarJugador(player2);
        untablero.agregarJugador(player3);

        player1.setEstado(player1.getJugadorEmpezandoTurno());

        player1.comprarTerreno(untablero.getBuenosAiresSur());

        player1.comprarTerreno(untablero.getBuenosAiresNorte());

        player1.construirCasa(untablero.getBuenosAiresNorte());

        player1.vender(player2, untablero.getBuenosAiresSur());

        untablero.moverJugador(player3,2);

        Assert.assertEquals(102000, player2.getDinero());
    }
}
