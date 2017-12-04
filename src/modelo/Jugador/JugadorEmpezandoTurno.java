package modelo.Jugador;
import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;
import modelo.Casa;
import modelo.Dado;
import modelo.Hotel;

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


    public void construir(Propiedad unaPropiedad, Casa casa) throws DineroInsuficiente, JugadorNoPoseeTodosLosBarrios, JugadorNoEsPropietario, NoPuedeConstruirMasCasas {
        unaPropiedad.construir(jugador, casa);

    }

    public void construir(Propiedad unaPropiedad, Hotel hotel) throws DineroInsuficiente, JugadorNoEsPropietario, JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles {
        unaPropiedad.construir(jugador, hotel);
    }


    public void vender(Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario {
        unComprable.reembolsar();
        jugador.devolverPropiedad(unComprable);
    }


    public void vender(Jugador unComprador, Comprable unComprable) throws NoEsTurnoJugador, JugadorNoEsPropietario, DineroInsuficiente {
        if(!jugador.esDuenio(unComprable)) throw new JugadorNoEsPropietario();
        if(!unComprador.puedePagar(unComprable.getPrecioCompra())) throw new DineroInsuficiente();
        unComprable.reembolsar();
        unComprable.setDuenio(unComprador);
        unComprador.adquirirPropiedad(unComprable);
    }

    public void intercambiarPropiedades(Jugador unJugador, Comprable propiedadNueva, Comprable propiedadACambiar) {
        propiedadACambiar.setDuenio(unJugador);
        unJugador.adquirirPropiedad(propiedadACambiar);
        propiedadNueva.setDuenio(jugador);
        jugador.adquirirPropiedad(propiedadNueva);
    }

    public void pasarTurno() throws NoEsTurnoJugador, JugadorNoTiroDados {
        throw new JugadorNoTiroDados();
    }



}
