package estados;

import modelo.Jugador.Jugador;
import modelo.Tablero;
import vista.eventos.mensajescasillero.Mensaje;

public class RetrocesoDinamico extends Movimiento {



	@Override
	public void hacerEfectoDelCasillero(Jugador unJugador) {

		Tablero tablero = Tablero.getInstance();

		tablero.moverJugador(unJugador,(-1)*calcularDesplazamiento(unJugador));
	}



	public int calcularDesplazamiento(Jugador unJugador){

		int valorDeDados = unJugador.getValorDados();

		if(valorDeDados<= 6){
			return valorDeDados - unJugador.getCantidadPropiedad();
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

	public String getMensaje(Jugador unJugador){
		return "Retrocede: " + calcularDesplazamiento(unJugador) + " casilleros";
	}

	@Override
	public void mensajeEfecto(Jugador unJugador) {

		Mensaje mensaje = new Mensaje();

		mensaje.mensajeEfecto(unJugador,this);
	}
}
