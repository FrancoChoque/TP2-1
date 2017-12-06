package vista.eventos;

import controlador.BotonConfirmarNombresHandler;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ConfirmarNombresOnKeyPress implements EventHandler<KeyEvent> {

	
	private BotonConfirmarNombresHandler botonhandler;


	public ConfirmarNombresOnKeyPress(BotonConfirmarNombresHandler confirmarnombres) {
		this.botonhandler = confirmarnombres;
	}
	
	
	@Override
	public void handle(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getCode() != KeyCode.ENTER) return;
		this.botonhandler.handle(null);
	}

}
