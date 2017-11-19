package estados.Comprable.Servicio.Servicios;

import estados.Comprable.Comprable;
import modelo.Casillero;
import modelo.Jugador.Jugador;
import modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class AysaTest {

    @Test
    public void aysaCuesta30000(){

    Tablero untablero = Tablero.resetInstance();
    Jugador player = new Jugador("plauer");

    player.setEstado(player.getJugadorEmpezandoTurno());

    untablero.agregarJugador(player);

    untablero.moverJugador(player, 12);

    Casillero unacasilla = untablero.obtenerCasillero(player);
    Comprable unterreno = (Comprable) unacasilla.getestado();

    player.comprarTerreno(unterreno);

    Assert.assertEquals(70000, player.getDinero() );

    }


    @Test
    public void jugadorCaeEnAysaConDuenio(){

        Tablero untablero = Tablero.resetInstance();
        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);
        untablero.moverJugador(player, 12);


        Casillero unacasilla = untablero.obtenerCasillero(player);
        Comprable unterreno = (Comprable) unacasilla.getestado();

        player.comprarTerreno(unterreno);

        Jugador player2 = new Jugador("player2");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);
        untablero.moverJugador(player2, 12);

        player2.setValorDados(12);

        unterreno.cobrarPase(player2);


        Assert.assertNotEquals(100000,player2.getDinero());

    }



}
