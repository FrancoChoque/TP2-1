package Entrega2;


import org.junit.Assert;
import org.junit.Test;


import modelo.Jugador.Jugador;
import modelo.Tablero;

public class Prueba210Test {

    @Test
    public void test01JugadorCaeEnBuenosAiresSurConCasa() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getBuenosAiresSur());

        player.comprar(untablero.getBuenosAiresNorte());

        player.construirCasa(untablero.getBuenosAiresSur());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,2);

        Assert.assertEquals(97000, player2.getDinero());
    }

    @Test
    public void test02JugadorCaeEnBuenosAiresSurConDosCasas() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getBuenosAiresSur());

        player.comprar(untablero.getBuenosAiresNorte());

        player.construirCasa(untablero.getBuenosAiresSur());

        player.construirCasa(untablero.getBuenosAiresSur());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,2);

        Assert.assertEquals(96500, player2.getDinero());
    }

    @Test
    public void test03JugadorCaeEnBuenosAiresSurConHotel() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getBuenosAiresSur());

        player.comprar(untablero.getBuenosAiresNorte());

        player.construirCasa(untablero.getBuenosAiresSur());

        player.construirCasa(untablero.getBuenosAiresSur());

        player.construirCasa(untablero.getBuenosAiresNorte());

        player.construirCasa(untablero.getBuenosAiresNorte());

        player.construirHotel(untablero.getBuenosAiresSur());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,2);

        Assert.assertEquals(95000, player2.getDinero());
    }


    @Test
    public void test04JugadorCaeEnBuenosAiresNorteConCasa() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getBuenosAiresNorte());

        player.comprar(untablero.getBuenosAiresSur());

        player.construirCasa(untablero.getBuenosAiresNorte());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,4);

        Assert.assertEquals(96500, player2.getDinero());
    }

    @Test
    public void test05JugadorCaeEnBuenosAiresNorteConDosCasas() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getBuenosAiresNorte());

        player.comprar(untablero.getBuenosAiresSur());

        player.construirCasa(untablero.getBuenosAiresNorte());

        player.construirCasa(untablero.getBuenosAiresNorte());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,4);

        Assert.assertEquals(96000, player2.getDinero());
    }

    @Test
    public void test06JugadorCaeEnBuenosAiresNorteConHotel() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getBuenosAiresSur());

        player.comprar(untablero.getBuenosAiresNorte());

        player.construirCasa(untablero.getBuenosAiresSur());

        player.construirCasa(untablero.getBuenosAiresSur());

        player.construirCasa(untablero.getBuenosAiresNorte());

        player.construirCasa(untablero.getBuenosAiresNorte());

        player.construirHotel(untablero.getBuenosAiresNorte());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,4);

        Assert.assertEquals(94000, player2.getDinero());
    }


    @Test
    public void test07JugadorCaeEnCordobaSurConCasa() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getCordobaSur());

        player.comprar(untablero.getCordobaNorte());

        player.construirCasa(untablero.getCordobaSur());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,6);

        Assert.assertEquals(98500, player2.getDinero());
    }

    @Test
    public void test08JugadorCaeEnCordobaSurConDosCasas() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getCordobaSur());

        player.comprar(untablero.getCordobaNorte());

        player.construirCasa(untablero.getCordobaSur());

        player.construirCasa(untablero.getCordobaSur());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,6);

        Assert.assertEquals(97500, player2.getDinero());
    }


    @Test
    public void test09JugadorCaeEnCordobaSurConHotel() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getCordobaSur());

        player.comprar(untablero.getCordobaNorte());

        player.construirCasa(untablero.getCordobaSur());

        player.construirCasa(untablero.getCordobaSur());

        player.construirCasa(untablero.getCordobaNorte());

        player.construirCasa(untablero.getCordobaNorte());

        player.construirHotel(untablero.getCordobaSur());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,6);

        Assert.assertEquals(97000, player2.getDinero());
    }


    @Test
    public void test10JugadorCaeEnCordobaNorteConCasa() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();
        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getCordobaNorte());

        player.comprar(untablero.getCordobaSur());

        player.construirCasa(untablero.getCordobaNorte());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,9);

        Assert.assertEquals(98200, player2.getDinero());
    }


    @Test
    public void test11JugadorCaeEnCordobaNorteConDosCasas() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getCordobaNorte());

        player.comprar(untablero.getCordobaSur());

        player.construirCasa(untablero.getCordobaNorte());

        player.construirCasa(untablero.getCordobaNorte());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,9);

        Assert.assertEquals(97100, player2.getDinero());
    }


    @Test
    public void test12JugadorCaeEnCordobaNorteConHotel() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getCordobaSur());

        player.comprar(untablero.getCordobaNorte());

        player.construirCasa(untablero.getCordobaSur());

        player.construirCasa(untablero.getCordobaSur());

        player.construirCasa(untablero.getCordobaNorte());

        player.construirCasa(untablero.getCordobaNorte());

        player.construirHotel(untablero.getCordobaNorte());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,9);

        Assert.assertEquals(96500, player2.getDinero());
    }

    @Test
    public void test13JugadorCaeEnSantaFeConCasa() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getSantaFe());

        player.construirCasa(untablero.getSantaFe());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,11);

        Assert.assertEquals(96500, player2.getDinero());
    }


    @Test
    public void test14JugadorCaeEnSaltaNorteConCasa() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getSaltaNorte());

        player.comprar(untablero.getSaltaSur());

        player.construirCasa(untablero.getSaltaNorte());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,13);

        Assert.assertEquals(96750, player2.getDinero());
    }

    @Test
    public void test15JugadorCaeEnSaltaNorteConDosCasas() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getSaltaNorte());

        player.comprar(untablero.getSaltaSur());

        player.construirCasa(untablero.getSaltaNorte());

        player.construirCasa(untablero.getSaltaNorte());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,13);

        Assert.assertEquals(96150, player2.getDinero());
    }

    @Test
    public void test16JugadorCaeEnSaltaNorteConHotel() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getSaltaSur());

        player.comprar(untablero.getSaltaNorte());

        player.construirCasa(untablero.getSaltaSur());

        player.construirCasa(untablero.getSaltaSur());

        player.construirCasa(untablero.getSaltaNorte());

        player.construirCasa(untablero.getSaltaNorte());

        player.construirHotel(untablero.getSaltaNorte());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,13);

        Assert.assertEquals(94500, player2.getDinero());
    }


    @Test
    public void test17JugadorCaeEnSaltaSurConCasa() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getSaltaSur());

        player.comprar(untablero.getSaltaNorte());

        player.construirCasa(untablero.getSaltaSur());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,14);

        Assert.assertEquals(96750, player2.getDinero());
    }

    @Test
    public void test18JugadorCaeEnSaltaSurConDosCasas() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getSaltaSur());

        player.comprar(untablero.getSaltaNorte());

        player.construirCasa(untablero.getSaltaSur());

        player.construirCasa(untablero.getSaltaSur());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,14);

        Assert.assertEquals(96150, player2.getDinero());
    }

    @Test
    public void test19JugadorCaeEnSaltaSurConHotel() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getSaltaSur());

        player.comprar(untablero.getSaltaNorte());

        player.construirCasa(untablero.getSaltaSur());

        player.construirCasa(untablero.getSaltaSur());

        player.construirCasa(untablero.getSaltaNorte());

        player.construirCasa(untablero.getSaltaNorte());

        player.construirHotel(untablero.getSaltaSur());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,14);

        Assert.assertEquals(94500, player2.getDinero());
    }


    @Test
    public void test20JugadorCaeEnNeuquenConCasa() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getNeuquen());

        player.construirCasa(untablero.getNeuquen());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,17);

        Assert.assertEquals(96200, player2.getDinero());
    }

    @Test
    public void test21JugadorCaeEnTucumanConCasa() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getTucuman());

        player.construirCasa(untablero.getTucuman());

        Jugador player2 = new Jugador("plauer");

        player.setEstado(player2.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,19);

        Assert.assertEquals(95500, player2.getDinero());
    }

}
