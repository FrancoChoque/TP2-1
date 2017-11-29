package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import vista.eventos.BotonSalir;

public class ContenedorMensaje extends VBox{

	public ContenedorMensaje(String mensaje){
		super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        
        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        etiqueta.setText(mensaje);
        etiqueta.setTextFill(Color.web("#66A7C5"));
        this.getChildren().add(etiqueta);
        
        Button cancelar = new Button();
        cancelar.setText("Aceptar");
        
        BotonSalir botonCancelar = new BotonSalir();
        cancelar.setOnAction(botonCancelar);

        this.getChildren().add(cancelar);
        
	}
	
}
