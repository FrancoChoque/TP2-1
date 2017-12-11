package estados;

import modelo.Jugador.Jugador;
import modelo.Tablero;
import vista.eventos.mensajescasillero.Mensaje;


public class AvanceDinamico extends Movimiento {


    public void hacerEfectoDelCasillero(Jugador unJugador){
        Tablero tablero = Tablero.getInstance();
        tablero.moverJugador(unJugador,calcularDesplazamiento(unJugador));
    }

    public int calcularDesplazamiento(Jugador unJugador){

        int valorDeDados = unJugador.getValorDados();

        if(valorDeDados<= 6){
            return valorDeDados - 2;
        }
        if(valorDeDados<= 10){
            return unJugador.getDinero() % valorDeDados;
        }

        return  valorDeDados - unJugador.getCantidadPropiedad();
    }

    public String getNombre(){
        return "Avance Dinamico";
    }

    public String getMensaje(Jugador unJugador){
        return "Avanza: " + calcularDesplazamiento(unJugador) + " casilleros";
    }

    public void mensajeEfecto(Jugador unJugador) {

        Mensaje mensaje = new Mensaje();

        mensaje.mensajeEfecto(unJugador,this);
    }

}

