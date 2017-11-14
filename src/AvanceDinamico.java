
public class AvanceDinamico extends Suerte{

	public void hacerEfectoDelCasillero(Jugador unJugador){
		unJugador.continuarMoviendose();
		int valorQueseMovio = unJugador.getValorQueseTieneQueMover();
		if(valorQueseMovio<= 6){
			int nuevoDesplazamiento = valorQueseMovio - 2;
			unJugador.setValorQueseTieneQueMover(nuevoDesplazamiento);
		}else if(valorQueseMovio<= 10){
			int nuevoDesplazamiento = unJugador.getDinero() % valorQueseMovio;
			unJugador.setValorQueseTieneQueMover(nuevoDesplazamiento);
		}else{
			int nuevoDesplazamiento = valorQueseMovio - unJugador.getNumeroPropiedades();
			unJugador.setValorQueseTieneQueMover(nuevoDesplazamiento);
		}
		
	}
}
