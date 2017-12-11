package estados.Comprable.Propiedad;

import excepciones.*;
import javafx.scene.canvas.GraphicsContext;
import modelo.Casa;
import modelo.Edificio;
import modelo.Hotel;
import modelo.Jugador.Jugador;
import vista.Posicion;

public interface PropiedadEstado {

    public int getCostoPase ();

    public void construir();

    public void puedeConstruir(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas;

    public void puedeConstruir(Jugador unJugador, Hotel hotel) throws JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles;

    public void dibujarEdificios(GraphicsContext gc, Posicion pos);
}
