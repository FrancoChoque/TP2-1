package Entrega3;

import modelo.*;
import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;

public class Prueba301Test {

    @Test

    public void test(){
    	AlgoPoly algopoly = new AlgoPoly();
		Jugador jugador = algopoly.nuevoJugador("jugador1");
		jugador.ponerDadosIguales();
		jugador.setEstado(jugador.getJugadorEmpezandoTurno() );
		
		
		try {
			algopoly.arrojarDados(jugador);
		} catch (NoEsTurnoJugador | JugadorYaTiroDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(jugador.getJugadorEmpezandoTurno() , jugador.getEstadoDeJugador() );
    }

}
