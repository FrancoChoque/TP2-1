package estados.Comprable.Servicio.Servicios;
import estados.Comprable.Servicio.Servicio;
import modelo.Jugador.Jugador;
import modelo.Tablero;
import vista.eventos.mensajescasillero.Mensaje;

public class Aysa extends Servicio {



    public int getPrecioCompra(){
        return 30000;
    }


    public int getCostoPase(Jugador unJugador){

        Tablero tablero = Tablero.getInstance();

        if(this.getDuenio() == tablero.getEdesur().getDuenio()){
            return unJugador.getValorDados() * 500;
        }

        return unJugador.getValorDados()*300;
    }

    public String getNombre(){
        return "Aysa";
    }

    @Override
	public String toString(){
		return "Aysa";
	}

    public void mensajeEfecto(Jugador unJugador) {
        Mensaje mensaje = new Mensaje();

        mensaje.mensajeEfecto(unJugador, this);
    }
}
