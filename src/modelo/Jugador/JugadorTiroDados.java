package modelo.Jugador;


import ch.qos.logback.classic.jul.JULHelper;
import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
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
        uncomprable.comprar(jugador);
        jugador.adquirirPropiedad(uncomprable);

    }

    public void edificar(Propiedad unaPropiedad){
        unaPropiedad.preguntarDuenio();
    }


    public void vender() throws NoEsTurnoJugador {

    }

    public void pasarTurno() throws NoEsTurnoJugador{
        jugador.setEstado(jugador.getJugadorSinTurno());
    }

	


}
