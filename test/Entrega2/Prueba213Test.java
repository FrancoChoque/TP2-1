package Entrega2;


import modelo.Jugador.Jugador;
import modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class Prueba213Test {

    @Test
    public void test01JugadorVendePropiedadYTransfiereTitularidad() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player1 = new Jugador("Vendedor");
        Jugador player2 = new Jugador("Comprador");
        Jugador player3 = new Jugador("Inquilino");

        untablero.agregarJugador(player1);
        untablero.agregarJugador(player2);
        untablero.agregarJugador(player3);

        player1.setEstado(player1.getJugadorEmpezandoTurno());

        player1.comprar(untablero.getEdesur());

        player1.transferir(untablero.getEdesur(),player2);


        player3.setValorDados(3);

        untablero.moverJugador(player3,3);
		Tablero.getInstance().obtenerCasillero(player3).getestado().hacerEfectoDelCasillero(player3);
		

        Assert.assertEquals(101500, player2.getDinero());
    }

    @Test
    public void test02JugadorIntercambiaPropiedadTransfiereTitularidad() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player1 = new Jugador("Vendedor");
        Jugador player2 = new Jugador("Comprador");
        Jugador player3 = new Jugador("Inquilino");

        untablero.agregarJugador(player1);
        untablero.agregarJugador(player2);
        untablero.agregarJugador(player3);

        player1.setEstado(player1.getJugadorEmpezandoTurno());

        player1.comprar(untablero.getEdesur());

        player2.setEstado(player1.getJugadorEmpezandoTurno());

        player2.comprar(untablero.getAysa());

        player1.intercambiarPropiedades(player2,untablero.getAysa(),untablero.getEdesur());

        player3.setEstado(player1.getJugadorEmpezandoTurno());

        player3.setValorDados(3);

        untablero.moverJugador(player3,3);
		Tablero.getInstance().obtenerCasillero(player3).getestado().hacerEfectoDelCasillero(player3);
		

        Assert.assertEquals(101500, player2.getDinero());
    }
}
