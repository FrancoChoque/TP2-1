import org.junit.Assert;
import org.junit.Test;

public class DesplazamientoConDadosTest {

    private static final double DELTA = 1e-12;

    @Test

    public void desplazamientocConDadosTest(){

        AlgoPoly algoPoly = new AlgoPoly();


        Jugador jugador = algoPoly.nuevoJugador("player 1");

        Assert.assertEquals(0, algoPoly.obtenerPosicion(jugador), DELTA);

        algoPoly.usarTurno(jugador);

        Assert.assertEquals(6, algoPoly.obtenerPosicion(jugador), DELTA);


    }

}
