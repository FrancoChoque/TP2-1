package vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class BotonVolverOnKeyPress implements EventHandler<KeyEvent> {

	private Stage stage;

	public BotonVolverOnKeyPress(Stage stage) {
		this.stage = stage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(KeyEvent event) {
		// TODO Auto-generated method stub
		if(event.getCode() != KeyCode.ENTER) return;
		this.stage.close();
	}

}
