package vista;

import controlador.App;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Jugador.Jugador;
import vista.eventos.BotonSalir;
import vista.eventos.BotonIntercambioJugador;


public class ContenedorIntercambio extends VBox{
	
	Stage stage;
	
	public ContenedorIntercambio(){
		
		super();
		App app = App.getInstance();
		AlgoPoly algoPoly = app.getAlgoPoly();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        
        Jugador jugador = algoPoly.obtenerJugadorActual();
        //String nombreDeJugador = jugador.getNombre();
        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        etiqueta.setText(jugador.getNombre() + " elegir otro jugador para intercambiar");
        etiqueta.setTextFill(Color.web("#66A7C5"));
        
        this.getChildren().add(etiqueta);
        
        if(algoPoly.getNumeroJugadores() >2){
        	Jugador otroJugador1 = algoPoly.obtenerJugador(0);
        	if(otroJugador1 != jugador){
        		Button BotonotroJugador1 = new Button();
        		BotonotroJugador1.setText(otroJugador1.getNombre());
        		
        		BotonIntercambioJugador botonIntercambio = new BotonIntercambioJugador(stage,jugador,otroJugador1);
        		BotonotroJugador1.setOnAction(botonIntercambio);
        		
        		this.getChildren().add(BotonotroJugador1);
        	}
        	Jugador otroJugador2 = algoPoly.obtenerJugador(1);
        	if(otroJugador2 != jugador){
        		Button BotonotroJugador2 = new Button();
        		BotonotroJugador2.setText(otroJugador2.getNombre());
        		
        		BotonIntercambioJugador botonIntercambio = new BotonIntercambioJugador(stage,jugador,otroJugador2);
        		BotonotroJugador2.setOnAction(botonIntercambio);
        		
        		this.getChildren().add(BotonotroJugador2);
        	}
        	Jugador otroJugador3 = algoPoly.obtenerJugador(2);
        	if(otroJugador3 != jugador){
        		Button BotonotroJugador3 = new Button();
        		BotonotroJugador3.setText(otroJugador3.getNombre());
        		
        		BotonIntercambioJugador botonIntercambio = new BotonIntercambioJugador(stage,jugador,otroJugador3);
        		BotonotroJugador3.setOnAction(botonIntercambio);
        		
        		this.getChildren().add(BotonotroJugador3);
        	}
        }else{
        	Jugador otroJugador1 = algoPoly.obtenerJugador(0);
        	if(otroJugador1 != jugador){
        		Button BotonotroJugador1 = new Button();
        		BotonotroJugador1.setText(otroJugador1.getNombre());
        		
        		BotonIntercambioJugador botonIntercambio = new BotonIntercambioJugador(stage,jugador,otroJugador1);
        		BotonotroJugador1.setOnAction(botonIntercambio);
        		
        		this.getChildren().add(BotonotroJugador1);
        	}
        	Jugador otroJugador2 = algoPoly.obtenerJugador(1);
        	if(otroJugador2 != jugador){
        		Button BotonotroJugador2 = new Button();
        		BotonotroJugador2.setText(otroJugador2.getNombre());
        		
        		BotonIntercambioJugador botonIntercambio = new BotonIntercambioJugador(stage,jugador,otroJugador1);
        		BotonotroJugador2.setOnAction(botonIntercambio);
        		
        		this.getChildren().add(BotonotroJugador2);
        	}
        }
        
        Button cancelar = new Button();
        cancelar.setText("Cancelar");
        
        BotonSalir botonCancelar = new BotonSalir();
        cancelar.setOnAction(botonCancelar);

        this.getChildren().add(cancelar);
        
	}
}
