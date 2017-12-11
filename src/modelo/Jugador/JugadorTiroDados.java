package modelo.Jugador;


import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;
import modelo.Dado;
import modelo.Edificio;

public class JugadorTiroDados implements EstadoDeJugador {


    Jugador jugador;

    public JugadorTiroDados(Jugador unJugador){

        jugador = unJugador;
    }

    public void arrojarDados(Dado dado1, Dado dado2) throws NoEsTurnoJugador, JugadorYaTiroDados {

        throw new JugadorYaTiroDados();
    }

    
    @Override
    public void comprar(Comprable uncomprable) throws NoEsTurnoJugador {

        uncomprable.comprar(jugador);
        jugador.adquirirPropiedad(uncomprable);
        jugador.setEstado(jugador.getJugadorSinTurno());

    }

    @Override
    public void construir(Propiedad unaPropiedad, Edificio edificio) throws NoEsTurnoJugador, DineroInsuficiente {
        return;
    }

    @Override
    public boolean puedeConstruir(Propiedad unaPropiedad, Edificio unEdificio) {
        return false;
    }


    public void vender(Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario {
        unComprable.reembolsar();
        jugador.devolverPropiedad(unComprable);
    }


    public void pasarTurno() throws NoEsTurnoJugador{
        jugador.setEstado(jugador.getJugadorSinTurno());
    }

    public void intercambiarPropiedades(Jugador unJugador, Comprable propiedadNueva, Comprable propiedadACambiar){
        jugador.elimarPropiedad(propiedadACambiar);
    	propiedadACambiar.setDuenio(unJugador);
        unJugador.adquirirPropiedad(propiedadACambiar);
        unJugador.elimarPropiedad(propiedadNueva);
        propiedadNueva.setDuenio(jugador);
        jugador.adquirirPropiedad(propiedadNueva);
    }
	


}
