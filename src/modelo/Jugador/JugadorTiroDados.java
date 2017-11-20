package modelo.Jugador;


import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;

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
        jugador.adquirirPropiedad(uncomprable);

    }

    public void construirCasa(Propiedad unaPropiedad){
        unaPropiedad.construirCasa(jugador);


    }

    public void construirHotel(Propiedad unaPropiedad){
        unaPropiedad.construirHotel(jugador);
    }


    public void vender(Comprable unComprable){
        unComprable.reembolsar();
    }

    public void vender(Jugador unJugador, Comprable unComprable){
        unComprable.reembolsar();
        unComprable.cambiarDuenio(unJugador);
        unJugador.adquirirPropiedad(unComprable);
    }

    public void pasarTurno() throws NoEsTurnoJugador{
        jugador.setEstado(jugador.getJugadorSinTurno());
    }

	


}
