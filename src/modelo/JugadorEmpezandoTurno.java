package modelo;
import estados.Terreno;
import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;

public class JugadorEmpezandoTurno implements EstadoDeJugador {

    Jugador jugador;

    public JugadorEmpezandoTurno(Jugador unJugador){

        jugador = unJugador;
    }


    public void arrojarDados() throws NoEsTurnoJugador, JugadorYaTiroDados {

        int valordado1;
        int valordado2;

        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        valordado1 = dado1.arrojar();
        valordado2 = dado2.arrojar();

        jugador.setEstado(jugador.getJugadorTiroDados());

        jugador.setValorDados(valordado1+valordado2);


    }

    public void comprar(Terreno unTerreno) throws NoEsTurnoJugador {
        //if(! unterreno.tieneDuenio() )
        jugador.adquirirPropiedad(unTerreno);
        unTerreno.cambiarDuenio(jugador);
        unTerreno.pagarCompra(jugador);
    }

    public void pagar(){
        System.out.println("no puede");
    }

    public void pasarTurno(){
        System.out.println("no tiro dados");
    }




}
