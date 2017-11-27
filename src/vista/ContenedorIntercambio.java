package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.eventos.BotonCancelarIntercambio;
import vista.eventos.BotonIntercambioJugador1;


public class ContenedorIntercambio extends VBox{
	
	Stage stage;
	
	public ContenedorIntercambio(Stage stage, Scene anterior){
		
		super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        

        Button botonJugador1 = new Button();
        botonJugador1.setText("jugador1");
        
       /* Button botonJugador2 = new Button();
        botonJugador1.setText("jugador2");
        
        Button botonJugador3 = new Button();
        botonJugador1.setText("jugador3");*/

        Button cancelar = new Button();
        cancelar.setText("Cancelar");
        
        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        etiqueta.setText("Elegir jugador para intercambiar");
        etiqueta.setTextFill(Color.web("#66A7C5"));

        BotonIntercambioJugador1 botonIntercambio = new BotonIntercambioJugador1(stage);
        botonJugador1.setOnAction(botonIntercambio);
        
        BotonCancelarIntercambio botonCancelar = new BotonCancelarIntercambio(stage,anterior);
        cancelar.setOnAction(botonCancelar);

        this.getChildren().addAll(etiqueta, botonJugador1,cancelar);
	}
}
