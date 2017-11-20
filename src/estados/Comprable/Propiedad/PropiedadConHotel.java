package estados.Comprable.Propiedad;

import modelo.Jugador.Jugador;

public class PropiedadConHotel implements PropiedadEstado {


    Propiedad propiedad;


    public PropiedadConHotel(Propiedad unaPropiedad){
        propiedad = unaPropiedad;
    }


    public int getCostoPase() {
        return propiedad.getCostoAlquilerConHotel();
    }



    public int getCostoEdificar() {
        //throw exception
        return 0;
    }

    public void construirCasa(Jugador unJugador){
    }

    public void construirHotel(Jugador unJugador){

    }



}
