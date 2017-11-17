package modelo;


import estados.Comprable;
import estados.Propiedad;
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
        //if(! unterreno.tieneDuenio() )
        uncomprable.pagarCompra(jugador);
        uncomprable.cambiarDuenio(jugador);
        jugador.adquirirPropiedad(uncomprable);

    }

    public void vender() throws NoEsTurnoJugador {

    }

    public void pasarTurno() throws NoEsTurnoJugador{
        jugador.setEstado(jugador.getJugadorSinTurno());
    }

	


}
