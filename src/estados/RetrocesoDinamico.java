package estados;

import modelo.Jugador.Jugador;
import modelo.Tablero;

public class RetrocesoDinamico extends Movimiento {



	@Override
	public void hacerEfectoDelCasillero(Jugador unJugador) {

		Tablero tablero = Tablero.getInstance();

		tablero.moverJugador(unJugador,(-1)*calcularDesplazamiento(unJugador));
	}



	public int calcularDesplazamiento(Jugador unJugador){

		int valorDeDados = unJugador.getValorDados();

		if(valorDeDados<= 6){
			return valorDeDados - unJugador.getNumeroPropiedades();
//			if(nuevoDesplazamiento<=0){
//				nuevoDesplazamiento = 1;
//			}
		}
		if(valorDeDados<= 10) return unJugador.getDinero() % valorDeDados;

		return valorDeDados - 2;
	}

	public String getNombre(){
		return "Retroceso Dinamico";
	}

	public String mensajeEfecto(Jugador unJugador){
		return "Retrocede: " + calcularDesplazamiento(unJugador) + " casilleros";
	}
}
