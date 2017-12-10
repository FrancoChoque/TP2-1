package estados;


import modelo.Jugador.Jugador;
import vista.eventos.mensajescasillero.Mensaje;

public class Salida extends EstadoCasillero {

    private int direccion; //hacia donde apunta la flecha

    @Override
    public void hacerEfectoDelCasillero(Jugador unJugador) {

    }

    public String getNombre(){
        return "Salida";
    }



    public void mensajeEfecto(Jugador unJugador){

        Mensaje mensaje = new Mensaje();

        mensaje.mensajeEfecto(unJugador,this);
    }

}

