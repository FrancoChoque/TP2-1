public class Casillero {
	
	private Estado estado;
	
	public Casillero(){
	}
	
	public void setEstado(Estado unestado) {
		estado = unestado;
	}
	
	
	public Casillero (Estado unestado) {
		estado = unestado;
	}
	
	public String getPropietario() {
		return "a";
	}

	public void hacerEfectoDelCasillero(Jugador unJugador){
		estado.hacerEfectoDelCasillero(unJugador);
	}

	public Estado getestado() {
		// TODO Auto-generated method stub
		return estado;
	}


}
