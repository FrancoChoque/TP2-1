package estados.Comprable.Servicio.Servicios;

import estados.Comprable.Servicio.Servicio;
import modelo.Jugador.Jugador;
import modelo.Tablero;
import vista.eventos.mensajescasillero.Mensaje;

public class Edesur extends Servicio {


    public int getPrecioCompra(){
        return 35000;
    }




    public int getCostoPase(Jugador unJugador){

        Tablero tablero = Tablero.getInstance();

        if(this.getDuenio() == tablero.getAysa().getDuenio()){
            return unJugador.getValorDados() * 1000;
        }

        return unJugador.getValorDados()*500;
    }

    public String getNombre(){
        return "Edesur";
    }

    public void mensajeEfecto(Jugador unJugador) {
        Mensaje mensaje = new Mensaje();

        mensaje.mensajeEfecto(unJugador, this);
    }
}
