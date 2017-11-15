
public class RetrocesoDinamico extends Suerte{

	public void hacerEfectoDelCasillero(Jugador unJugador) {
		unJugador.continuarMoviendose();
		int valorQueseMovio = unJugador.getValorQueseTieneQueMover();
		if(valorQueseMovio<= 6) {
			int retroceso = valorQueseMovio - unJugador.getNumeroPropiedades();
			unJugador.setValorQueseTieneQueMover(retroceso * -1);
			return;
		}
		if(valorQueseMovio<= 10) {
			int retroceso = unJugador.getDinero() % valorQueseMovio ;
			unJugador.setValorQueseTieneQueMover(retroceso * -1);
			return;
		}
		int retroceso = valorQueseMovio - 2;
		unJugador.setValorQueseTieneQueMover(retroceso * -1);
	}
}
