package estados.Comprable.Propiedad;

import modelo.Edificio;
import modelo.Jugador.Jugador;

public interface PropiedadEstado {

    public int getCostoPase ();

    public int getCostoEdificar ();

    public void edificar(Jugador unJugador);

}
