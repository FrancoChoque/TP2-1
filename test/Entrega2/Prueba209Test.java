package Entrega2;

import estados.Comprable.Propiedad.Propiedad;
import modelo.Edificio;
import modelo.Jugador.Jugador;
import modelo.Casa;
import modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class Prueba209Test {


    @Test
    public void test01JugadorCompraCasaEnSantaFe() throws Exception {
        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("Player");
        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getSantaFe());

        Assert.assertEquals(85000, player.getDinero());

        Edificio edificio = new Casa();

        player.construir(untablero.getSantaFe(), edificio);

        Assert.assertEquals(81000, player.getDinero());
    }
}
