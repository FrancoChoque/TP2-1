package estados.Comprable.Servicio.Servicios;


import estados.Comprable.Servicio.Servicio;
import modelo.Jugador.Jugador;
import modelo.Tablero;
import vista.eventos.mensajescasillero.Mensaje;

public class Tren extends Servicio {

    public int getPrecioCompra(){
        return 38000;
    }


    public int getCostoPase(Jugador unJugador){

        Tablero tablero = Tablero.getInstance();

        if(this.getDuenio() == tablero.getSubte().getDuenio()){
            return unJugador.getValorDados() * 800;
        }

        return unJugador.getValorDados()*450;
    }

    public String getNombre(){
        return "Tren";
    }

    public void mensajeEfecto(Jugador unJugador) {
        Mensaje mensaje = new Mensaje();

        mensaje.mensajeEfecto(unJugador, this);
    }
}
