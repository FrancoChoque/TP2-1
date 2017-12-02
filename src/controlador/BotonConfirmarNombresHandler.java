package controlador;

import controlador.excepciones.NombreInvalidoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class BotonConfirmarNombresHandler implements EventHandler<ActionEvent> {

	private Login ventana;
	private Stage stage;
	private Scene scene;

	@Override
	public void handle(ActionEvent arg0) {
		App app = App.getInstance();
		try {
			ventana.confirmarnombres();
			stage.close();
			VentanaJuego juego = VentanaJuego.getInstance();
			juego.initialize(app.getPrimaryStage(),app.getAlgoPoly(),
					this.ventana.getNombrejugador1(),this.ventana.getNombrejugador2(), this.ventana.getNombrejugador3());

		} catch (NombreInvalidoException e) {
			// TODO Auto-generated catch block
			ventanaError();
		}
		
	}
	
	private void ventanaError() {
		// TODO Auto-generated method stub
		Stage ventanaError = new Stage();
		ventanaError.setTitle("Error");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(15);
		
		Button botonVolver =  new Button();
		botonVolver.setText("Volver");
		EventHandler<ActionEvent> botonvolverhandler = new BotonVolverHandler(ventanaError);
		botonVolver.setOnAction(botonvolverhandler);
		botonVolver.setCacheShape(true);
		
		
		Text textoerror = new Text("Por favor ingrese un nombre sin espacios\ny de al menos 1 letra o numero.");
		textoerror.setTextAlignment(TextAlignment.CENTER);
		textoerror.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15) );
		
		
		vbox.getChildren().addAll(textoerror, botonVolver);
		
		
		grid.getChildren().add(vbox);
		
		
		Scene escenaError = new Scene(grid,300, 100);
		ventanaError.setScene(escenaError);
		
		ventanaError.showAndWait();
		
	}

	public BotonConfirmarNombresHandler(Login login, Stage stage, Scene scene) {
		this.ventana = login;
		this.stage = stage;
		this.scene = scene;
	}

}
