package estados.Comprable.Propiedad;

import modelo.Jugador.Jugador;

public interface PropiedadEstado {

    public int getCostoPase ();

    public int getCostoEdificar ();

    public void construirCasa(Jugador unJugador);

    public void construirHotel(Jugador unJugador);

}
