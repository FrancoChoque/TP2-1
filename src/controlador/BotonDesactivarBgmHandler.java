package controlador;

import javafx.event.Event;
import javafx.event.EventHandler;


public class BotonDesactivarBgmHandler implements EventHandler {

    VentanaJuego ventana =VentanaJuego.getInstance();

    public void handle(Event event) {

        ventana.toggleBgm();
    }
}
