package estados.Comprable.Servicio.Servicios;


import estados.Comprable.Servicio.Servicio;
import modelo.Jugador.Jugador;
import modelo.Tablero;
import vista.eventos.mensajescasillero.Mensaje;

public class Subte extends Servicio {

    public int getPrecioCompra(){
        return 40000;
    }


    public int getCostoPase(Jugador unJugador){

        Tablero tablero = Tablero.getInstance();

        if(this.getDuenio() == tablero.getTren().getDuenio()){
            return unJugador.getValorDados() * 1100;
        }

        return unJugador.getValorDados()* 600;
    }

    public String getNombre(){
        return "Subte";
    }

    @Override
   	public String toString(){
   		return "Subte";
   	}
    
    public void mensajeEfecto(Jugador unJugador) {
        Mensaje mensaje = new Mensaje();

        mensaje.mensajeEfecto(unJugador, this);
    }
}
