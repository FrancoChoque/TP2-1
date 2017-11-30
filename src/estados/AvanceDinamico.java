package estados;

import modelo.Jugador.Jugador;
import modelo.Tablero;

public class AvanceDinamico extends Suerte{

	public void hacerEfectoDelCasillero(Jugador unJugador){
		Tablero tablero = Tablero.getInstance();
		int valorDeDados = unJugador.getValorDados();
		int nuevoDesplazamiento = 0;
		if(valorDeDados<= 6){
			nuevoDesplazamiento = valorDeDados - 2;
		}else if(valorDeDados<= 10){
			nuevoDesplazamiento = unJugador.getDinero() % valorDeDados;
		}else{
			nuevoDesplazamiento = valorDeDados - unJugador.getNumeroPropiedades();
			
		}
		if(nuevoDesplazamiento == 0) return; //cae en stackoverflow error
		tablero.moverJugador(unJugador,nuevoDesplazamiento );
	}

	public boolean esComprable() {
		return false;
	}

	public String getNombre(){
		return "Avance Dinamico";
	}
}
