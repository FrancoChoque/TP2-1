package modelo.Jugador;
import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.*;
import modelo.Dado;

public class JugadorEmpezandoTurno implements EstadoDeJugador {

    Jugador jugador;

    public JugadorEmpezandoTurno(Jugador unJugador){

        jugador = unJugador;
    }


    public void arrojarDados() throws NoEsTurnoJugador, JugadorYaTiroDados {

        int resultado = resultadoDados();

        if(resultado == 0){
            resultado = resultadoDados();
        }

        if(resultado == 0){
            jugador.setEstado(jugador.getJugadorSinTurno());
        }else {
            jugador.setEstado(jugador.getJugadorTiroDados());
            jugador.setValorDados(resultado);
        }



    }

    @Override
    public void comprar(Comprable uncomprable) throws NoEsTurnoJugador {

        uncomprable.comprar(jugador);
        jugador.adquirirPropiedad(uncomprable);
    }


    public void construirCasa(Propiedad unaPropiedad) throws DineroInsuficiente, JugadorNoPoseeTodosLosBarrios, JugadorNoEsPropietario, NoPuedeConstruirMasCasas {
        unaPropiedad.construirCasa(jugador);

    }

    public void construirHotel(Propiedad unaPropiedad) throws DineroInsuficiente, JugadorNoEsPropietario, JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles {
        unaPropiedad.construirHotel(jugador);
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

    private int resultadoDados(){      
        
    	this.jugador.tirarDados();             
        return this.jugador.getValorDados();
    
    }


}
