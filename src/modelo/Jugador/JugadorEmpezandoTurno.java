package modelo.Jugador;
import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;
import modelo.Dado;
import modelo.Edificio;

public class JugadorEmpezandoTurno implements EstadoDeJugador {

    Jugador jugador;

    public JugadorEmpezandoTurno(Jugador unJugador){

        jugador = unJugador;
    }


    public void arrojarDados(Dado dado1, Dado dado2) throws NoEsTurnoJugador, JugadorYaTiroDados {

        dado1.arrojar();
        dado2.arrojar();

        jugador.setValorDados(dado1.getValor() + dado2.getValor());

    }

    @Override
    public void comprar(Comprable uncomprable) throws NoEsTurnoJugador {

        uncomprable.comprar(jugador);
        jugador.adquirirPropiedad(uncomprable);
    }

    @Override
    public void construir(Propiedad unaPropiedad, Edificio edificio) throws NoEsTurnoJugador, DineroInsuficiente {
        unaPropiedad.construir(jugador, edificio);
    }


    @Override
    public boolean puedeConstruir(Propiedad unaPropiedad, Edificio unEdificio) {

        if(!jugador.esDuenio(unaPropiedad)) return false;

        try {
            unaPropiedad.puedeConstruir(jugador, unEdificio);
        } catch (NoPuedeConstruirMasCasas | CasasInsuficientes | NoPuedeConstruirMasHoteles | JugadorNoPoseeTodosLosBarrios noPuedeConstruirMasCasas) {
            return false;
        }
        return true;
    }


    public void vender(Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario {
        unComprable.reembolsar();
        jugador.devolverPropiedad(unComprable);
    }



    public void intercambiarPropiedades(Jugador unJugador, Comprable propiedadNueva, Comprable propiedadACambiar) {
        jugador.elimarPropiedad(propiedadACambiar);
    	propiedadACambiar.setDuenio(unJugador);
        unJugador.adquirirPropiedad(propiedadACambiar);
        unJugador.elimarPropiedad(propiedadNueva);
        propiedadNueva.setDuenio(jugador);
        jugador.adquirirPropiedad(propiedadNueva);
    }

    public void pasarTurno() throws NoEsTurnoJugador, JugadorNoTiroDados {
        throw new JugadorNoTiroDados();
    }



}
