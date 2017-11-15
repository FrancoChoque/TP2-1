import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;

public interface EstadoDeJugador {

    public int arrojarDados()throws NoEsTurnoJugador, JugadorYaTiroDados;

    public void comprar(Terreno unTerreno) throws NoEsTurnoJugador, JugadorYaTiroDados;

    public void pagar() throws NoEsTurnoJugador;

    public void pasarTurno() throws NoEsTurnoJugador;

}
