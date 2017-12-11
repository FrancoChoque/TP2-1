package controlador;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;


public class BotonToggleBgmHandler implements EventHandler <ActionEvent> {

    VentanaJuego ventana =VentanaJuego.getInstance();

    @Override
    public void handle(ActionEvent event) {
        ventana.toggleBgm();
    }
}
