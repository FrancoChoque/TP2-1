package Entrega2;


import modelo.Jugador.Jugador;
import modelo.Tablero;
import modelo.Casa;
import org.junit.Assert;
import org.junit.Test;

public class Prueba214Test {

    @Test
    public void test01JugadorVendePropiedadYPierdeTodasLasConstrucciones() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player1 = new Jugador("Vendedor");
        Jugador player2 = new Jugador("Comprador");
        Jugador player3 = new Jugador("Inquilino");

        untablero.agregarJugador(player1);
        untablero.agregarJugador(player2);
        untablero.agregarJugador(player3);

        player1.setEstado(player1.getJugadorEmpezandoTurno());

        player1.comprar(untablero.getBuenosAiresSur());

        player1.comprar(untablero.getBuenosAiresNorte());

        player1.construir(untablero.getBuenosAiresNorte(), new Casa());

        player1.transferir(untablero.getBuenosAiresSur(), player2);

        untablero.moverJugador(player3,2);

        Assert.assertEquals(102000, player2.getDinero());
    }
}
