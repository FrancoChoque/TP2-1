package controlador;

import controlador.excepciones.NombreInvalidoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VentanaLogin {

	private BorderPane layout;
	private Scene escenaLogin;
	private VBox textos;
	private TextField nombrejugador3;
	private TextField nombrejugador2;
	private TextField nombrejugador1;
	
	public VentanaLogin() {
		App app = App.getInstance();
		
		this.layout = new BorderPane();
		this.escenaLogin = new Scene(layout,300,270);
		
		this.textos =  new VBox();
		this.textos.setPadding( new Insets(10,10,10,10));
		this.textos.setSpacing(15);
		this.textos.setCenterShape(true);
		this.cargarcampos();
		
		Button botonConfirmarNombres = new Button();
		botonConfirmarNombres.setCenterShape(true);
		botonConfirmarNombres.setText("Continuar");
		EventHandler<ActionEvent> botonConfirmarNombresHandler = new BotonConfirmarNombresHandler(this);
		botonConfirmarNombres.setOnAction(botonConfirmarNombresHandler);
		
		
		
		this.textos.getChildren().add(botonConfirmarNombres);
		
	}

	private void cargarcampos() {
		
		Text header1 = new Text("Ingrese el nombre del jugador1");
		nombrejugador1 = new TextField();
		
		Text header2 = new Text("Ingrese el nombre del jugador2");
		nombrejugador2 = new TextField();
		
		Text header3 = new Text("Ingrese el nombre del jugador3");
		nombrejugador3 = new TextField();
		
		this.textos.getChildren().addAll(header1, nombrejugador1, 
				header2, nombrejugador2, 
				header3, nombrejugador3);
		this.layout.setCenter(this.textos);
		
	}

	public void login() {
		App main = App.getInstance();
		main.getPrimaryStage().setScene(escenaLogin);
	}

	public void confirmarnombres() throws NombreInvalidoException {
		// TODO Auto-generated method stub
		String nombre1 = nombrejugador1.getText().trim();
		String nombre2 = nombrejugador2.getText().trim();
		String nombre3 = nombrejugador3.getText().trim();
		
		if( (nombre1.length() == 0) ||
			(nombre2.length() == 0) ||
			(nombre3.length() == 0) ) throw new NombreInvalidoException();
		
	}

	public String getNombrejugador1() {
		// TODO Auto-generated method stub
		return this.nombrejugador1.getText();
	}

	public String getNombrejugador2() {
		// TODO Auto-generated method stub
		return this.nombrejugador2.getText();
	}

	public String getNombrejugador3() {
		// TODO Auto-generated method stub
		return this.nombrejugador3.getText();
	}

	
	
}
