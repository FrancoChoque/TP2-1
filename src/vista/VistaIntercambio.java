package vista;

import javafx.scene.canvas.Canvas;
import modelo.AlgoPoly;


public class VistaIntercambio {

	private AlgoPoly modelo;
    Canvas canvas;
    
    public VistaIntercambio(AlgoPoly unModelo, Canvas unaCanvas) {
        this.modelo = unModelo;
        this.canvas = unaCanvas;
    }
}
