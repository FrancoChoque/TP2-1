package modelo.Jugador;


import estados.Comprable;
import estados.Propiedad;
import excepciones.JugadorNoTieneTerreno;
import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;
import modelo.Edificio;

public class JugadorTiroDados implements EstadoDeJugador {


    Jugador jugador;

    public JugadorTiroDados(Jugador unJugador){

        jugador = unJugador;
    }

    public void arrojarDados() throws NoEsTurnoJugador, JugadorYaTiroDados {

        throw new JugadorYaTiroDados();
    }

    
    @Override
    public void comprar(Comprable uncomprable) throws NoEsTurnoJugador {
        if( uncomprable.tieneDuenio() ) return;
        uncomprable.cobrarCompra(jugador);
        uncomprable.cambiarDuenio(jugador);
        jugador.adquirirPropiedad(uncomprable);

    }

    public void edificar(Propiedad unaPropiedad, Edificio unEdificio) throws NoEsTurnoJugador, JugadorNoTieneTerreno{
        unaPropiedad.preguntarDuenio();
    }


    public void vender() throws NoEsTurnoJugador {

    }

    public void pasarTurno() throws NoEsTurnoJugador{
        jugador.setEstado(jugador.getJugadorSinTurno());
    }

	


}
