package modelo;


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

    public void comprar(Propiedad unPropiedad) throws NoEsTurnoJugador {
        //if(! unterreno.tieneDuenio() )
        unPropiedad.pagarCompra(jugador);
        unPropiedad.cambiarDuenio(jugador);
        jugador.adquirirPropiedad(unPropiedad);

    }

    public void vender() throws NoEsTurnoJugador {

    }

    public void pasarTurno() throws NoEsTurnoJugador{
        jugador.setEstado(jugador.getJugadorSinTurno());
    }


}
