package modelo.Jugador;
import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import excepciones.JugadorNoTiroDados;
import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;
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
        //if(! unterreno.tieneDuenio() )
        uncomprable.comprar(jugador);
        jugador.adquirirPropiedad(uncomprable);
        uncomprable.cambiarDuenio(jugador);

    }


    public void construirCasa(Propiedad unaPropiedad){
        unaPropiedad.construirCasa(jugador);

    }

    public void construirHotel(Propiedad unaPropiedad){
        unaPropiedad.construirHotel(jugador);
    }


    public void vender(){
    }

    public void pasarTurno() throws NoEsTurnoJugador, JugadorNoTiroDados {
        throw new JugadorNoTiroDados();
    }

    private int resultadoDados(){

        int valordado1;
        int valordado2;

        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        valordado1 = dado1.arrojar();
        valordado2 = dado2.arrojar();


        if(valordado1 == valordado2) {
            return 0;

        }else{
            return valordado1+valordado2;
        }
    }


}
