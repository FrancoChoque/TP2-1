import excepciones.JugadorYaTiroDados;
import modelo.*;
import excepciones.NoEsTurnoJugador;
import org.junit.Assert;
import org.junit.Test;

public class DesplazamientoConDadosTest {

    private static final double DELTA = 1e-12;

    @Test

    public void desplazamientocConDadosTest() throws JugadorYaTiroDados, NoEsTurnoJugador{

        AlgoPoly algoPoly = new AlgoPoly();


        Jugador jugador = algoPoly.nuevoJugador("player 1");

        jugador.setEstado(jugador.getJugadorEmpezandoTurno());

        Assert.assertEquals(0, algoPoly.obtenerPosicion(jugador), DELTA);

        algoPoly.usarTurno(jugador);


        Assert.assertNotEquals(0, algoPoly.obtenerPosicion(jugador), DELTA);


    }

}
