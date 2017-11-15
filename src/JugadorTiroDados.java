import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;

public class JugadorTiroDados implements EstadoDeJugador {


    Jugador jugador;

    public JugadorTiroDados(Jugador unJugador){

        jugador = unJugador;
    }

    public int arrojarDados() throws NoEsTurnoJugador, JugadorYaTiroDados {

        throw new JugadorYaTiroDados();
    }

    public void comprar(Terreno unTerreno) throws NoEsTurnoJugador, JugadorYaTiroDados {
        System.out.println("no puede");
    }

    public void pagar() throws NoEsTurnoJugador {
        System.out.println("no puede");
    }

    public void pasarTurno() throws NoEsTurnoJugador{
        System.out.println("no puede");
    }


}