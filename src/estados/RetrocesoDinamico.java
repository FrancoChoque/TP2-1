package estados;

import modelo.Jugador.Jugador;
import modelo.Tablero;

public class RetrocesoDinamico extends Suerte{

	@Override
	public void hacerEfectoDelCasillero(Jugador unJugador) {
		Tablero tablero = Tablero.getInstance();
		int valorDeDados = unJugador.getValorDados();
		int nuevoDesplazamiento = 0;
		if(valorDeDados<= 6){
			nuevoDesplazamiento = valorDeDados - unJugador.getNumeroPropiedades();
//			if(nuevoDesplazamiento<=0){
//				nuevoDesplazamiento = 1;
//			}
			
		}else if(valorDeDados<= 10){
			nuevoDesplazamiento = unJugador.getDinero() % valorDeDados;
		}else{
			nuevoDesplazamiento = valorDeDados - 2;
		}
		if(nuevoDesplazamiento == 0) return;
		tablero.moverJugador(unJugador,(-1)*nuevoDesplazamiento );
	}
}
