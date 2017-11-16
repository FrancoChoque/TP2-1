package estados;


import modelo.Jugador;

public class Propiedad extends EstadoCasillero implements Comprable{

	private Jugador propietario = null;

	public boolean tieneDuenio() {
		return this.propietario != null;
	}

	@Override
	public boolean esComprable() {
		return true;
	}
	
	public void cambiarDuenio(Jugador jugador) {
		this.propietario = jugador;
	}

	@Override
	public Jugador preguntarDuenio() {
		return this.propietario;
	}

	@Override
	public void hacerEfectoDelCasillero(Jugador unjugador) {
		unjugador.comprarTerreno(this);
	}


	public void pagarCompra(Jugador jugador) {
		// TODO Auto-generated method stub
	}

}
