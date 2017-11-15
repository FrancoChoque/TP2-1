
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
		tablero.moverJugador(unJugador,nuevoDesplazamiento );
	}
}
