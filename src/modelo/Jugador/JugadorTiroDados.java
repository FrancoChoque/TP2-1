package modelo.Jugador;


import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;

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
        jugador.setEstado(jugador.getJugadorSinTurno());

    }

    public void construirCasa(Propiedad unaPropiedad) throws DineroInsuficiente, JugadorNoPoseeTodosLosBarrios, JugadorNoEsPropietario, NoPuedeConstruirMasCasas {
        if(!jugador.esDuenio(unaPropiedad)) throw new JugadorNoEsPropietario();
        unaPropiedad.construirCasa(jugador);


    }

    public void construirHotel(Propiedad unaPropiedad) throws DineroInsuficiente, JugadorNoEsPropietario, JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles {
        unaPropiedad.construirHotel(jugador);

    }


    public void vender(Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario {
        unComprable.reembolsar();
    }

    public void vender(Jugador unComprador, Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario, DineroInsuficiente {
        if(!jugador.esDuenio(unComprable)) throw new JugadorNoEsPropietario();
        if(!unComprador.puedePagar(unComprable.getPrecioCompra())) throw new DineroInsuficiente();
        unComprable.reembolsar();
        unComprable.comprar(unComprador);
        unComprador.adquirirPropiedad(unComprable);
    }

    public void pasarTurno() throws NoEsTurnoJugador{
        jugador.setEstado(jugador.getJugadorSinTurno());
    }

    public void intercambiarPropiedades(Jugador unJugador, Comprable propiedadNueva, Comprable propiedadACambiar){
        propiedadACambiar.setDuenio(unJugador);
        unJugador.adquirirPropiedad(propiedadACambiar);
        propiedadNueva.setDuenio(jugador);
        jugador.adquirirPropiedad(propiedadNueva);
    }
	


}
