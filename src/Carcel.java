import java.util.HashMap;

public class Carcel extends Estado {
	
	private HashMap<Jugador, Integer> calabozo;
	
	public Carcel() {
		calabozo = new HashMap<Jugador, Integer>();
	}
	
	
	@Override
	public void hacerEfectoDelCasillero(Jugador unjugador) {
		if(! calabozo.containsKey(unjugador) ) {
			calabozo.put(unjugador, 1);
			unjugador.cambiarMovimiento();
			return;
		}
		
		int turnosEnCarcel = calabozo.get(unjugador);
		calabozo.put(unjugador, turnosEnCarcel + 1);
		
		
	}


	public int preguntarTurnosEnCalabozo(Jugador unjugador) {
		if(! calabozo.containsKey(unjugador) ) return 0;
		return calabozo.get(unjugador);
	}
}
