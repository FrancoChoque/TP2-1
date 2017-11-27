package Entrega3;

import modelo.*;
import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;
import excepciones.FinDelJuego;

public class Prueba301Test {

    @Test

    public void test(){
    	AlgoPoly algopoly = new AlgoPoly();
		Jugador jugador = algopoly.nuevoJugador("jugador1");
		jugador.ponerDadosIguales();
		
		
		try {
			algopoly.usarTurno(jugador);
		} catch (NoEsTurnoJugador | JugadorYaTiroDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(FinDelJuego e) {
			System.out.println("Fin del juego");
		}
		
		Assert.assertEquals(jugador.getJugadorEmpezandoTurno() , jugador.getEstadoDeJugador() );
    }

}
