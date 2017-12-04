package estados.Comprable.Propiedad;

import excepciones.*;
import javafx.scene.canvas.GraphicsContext;
import modelo.Casa;
import modelo.Hotel;
import modelo.Jugador.Jugador;
import vista.Posicion;

public interface PropiedadEstado {

    public int getCostoPase ();

    public void construir(Jugador unJugador, Casa casa) throws DineroInsuficiente;

    public void construir(Jugador unJugador, Hotel hotel) throws DineroInsuficiente;

    public void puedeConstruir(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas;

    public void puedeConstruir(Jugador unJugador, Hotel hotel) throws JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles;

    public void dibujarEdificios(GraphicsContext gc, Posicion pos);
}
