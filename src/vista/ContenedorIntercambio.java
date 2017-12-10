package vista;


import static javafx.scene.text.Font.font;

import controlador.App;
import controlador.BotonVolverHandler;
import estados.Comprable.Comprable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Jugador.Jugador;
import vista.eventos.BotonAceptarIntercambio;
import vista.eventos.BotonIntercambioJugador;
import javafx.scene.paint.Color;

import vista.eventos.BotonSelecionarPropiedadesIntercambio;

public class ContenedorIntercambio extends VBox{
	
	public ContenedorIntercambio(){
		
		super();
	}
	
	public void elegirJugador(){
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);

        stage.setTitle("Elegir jugador");
        BorderPane layout = new BorderPane();
        
        Text text = new Text();
        text.setText("Elegir jugador para intercambio");
        text.setFont(font("Helvetica", FontPosture.ITALIC, 20));
        text.setTextAlignment(TextAlignment.CENTER);
        layout.setTop(text);
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(text);
        vbox.setPadding( new Insets(10,10,10,10));
        vbox.setAlignment(Pos.CENTER);
        
     
        
        Scene scene = new Scene(layout, 600, 200);
        stage.setScene(scene);
        
		App app = App.getInstance();
		AlgoPoly algoPoly = app.getAlgoPoly();
        
        Jugador jugador = algoPoly.obtenerJugadorActual();
        
        for(int i=0; i<algoPoly.getNumeroJugadores(); i++){
        	Jugador otroJugador = algoPoly.obtenerJugador(i);
        	if(otroJugador != jugador){
        		Button BotonotroJugador = new Button();
        		BotonotroJugador.setText(otroJugador.getNombre());
        		
        		BotonIntercambioJugador botonIntercambio = new BotonIntercambioJugador(stage,jugador,otroJugador);
        		BotonotroJugador.setOnAction(botonIntercambio);
        		
        		vbox.getChildren().add(BotonotroJugador);
                vbox.setPadding( new Insets(10,10,10,10));
                vbox.setAlignment(Pos.CENTER);
        	}
        }
        
        Button cancelar = new Button();
        cancelar.setText("Cancelar");
        cancelar.setOnAction(event -> stage.close());

        vbox.getChildren().add(cancelar);
        vbox.setPadding( new Insets(10,10,10,10));
        vbox.setAlignment(Pos.CENTER);
        
        layout.setCenter(vbox);
        stage.showAndWait();

	}

	public void ElegirPropiedades(Stage stageAnterior,Jugador remitente, Jugador destinatario) {
		Stage stage = stageAnterior;
		stage.setTitle("Elegir Propiedades");
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
		if(destinatario.getCantidadPropiedad() != 0){
			Scene scene = new Scene(grid, 640, 200);
			stage.setScene(scene);
	        
	        ComboBox<Comprable> comboBoxremitente = new ComboBox<Comprable>();
	        for(int i=0;i < remitente.getCantidadPropiedad();i++){
	        	Comprable propiedad = remitente.getPropiedad(i);
	        	
	        	comboBoxremitente.getItems().add(propiedad);
	        	
	        }
	        
	        ComboBox<Comprable> comboBoxDestinatario = new ComboBox<Comprable>();
	        for(int i=0;i < destinatario.getCantidadPropiedad();i++){
	        	Comprable propiedad = destinatario.getPropiedad(i);
	        	
	        	comboBoxDestinatario.getItems().add(propiedad);
	        }
	       
	        Button botonCancelar = new Button();
	        botonCancelar.setText("Cancelar");
	        BotonVolverHandler botonVolver = new BotonVolverHandler(stage);
	        botonCancelar.setOnAction(botonVolver);
        
	        Button aceptar = new Button();
	        aceptar.setText("Aceptar");
	        BotonSelecionarPropiedadesIntercambio botonAceptar = new BotonSelecionarPropiedadesIntercambio(stage,remitente,destinatario);
	        aceptar.setOnAction(botonAceptar);
	        
	        comboBoxremitente.valueProperty().addListener((obs, oldVal, newVal) -> {
	            botonAceptar.setPropiedadDelRemitente(newVal);
	            System.out.println("se seleciono propiedad para intercambio: " +newVal.getNombre());
	        });
	        
	        comboBoxDestinatario.valueProperty().addListener((obs, oldVal, newVal) -> {
	            botonAceptar.setPropiedadDelDestinatario(newVal);
	            System.out.println("se seleciono propiedad para intercambio: " +newVal.getNombre());
	        });
	        
	        
			grid.setVgap(4);
			grid.setHgap(10);
			grid.setPadding(new Insets(5, 5, 5, 5));
			Text TextCeder = new Text("Propiedad a ceder: ");
			TextCeder.setFill(Color.RED);
			grid.add(TextCeder, 0, 0);
			grid.add(comboBoxremitente, 1, 0);
			
			Text textRecibir = new Text("Propiedad a Recibir: ");
			textRecibir.setFill(Color.GREEN);
			grid.add(textRecibir, 2, 0);
			grid.add(comboBoxDestinatario, 3, 0);           
			grid.add(botonCancelar, 3, 3); 
			grid.add(aceptar,1,3);
	        
		}else{
			BorderPane layout = new BorderPane();
			
	        Text text1 = new Text();
	        text1.setText("Jugador sin Propiedades");
	        text1.setFont(font("Helvetica", FontPosture.REGULAR, 20));
			
	        text1.setTextAlignment(TextAlignment.CENTER);
	        
	        layout.setTop(text1);

	        
	        Scene scene = new Scene(layout, 600, 100);
	        stage.setScene(scene);
	        
	        Button volver = new Button();
	        volver.setMinWidth(80);
	        volver.setText("Aceptar");
	        BotonVolverHandler botonVolver = new BotonVolverHandler(stage);
	        volver.setOnAction(botonVolver);
	        
	        VBox vbox = new VBox();
	        vbox.getChildren().addAll(text1,volver);
	        vbox.setPadding( new Insets(10,10,10,10));
	        vbox.setAlignment(Pos.CENTER);

	        
	        layout.setTop(vbox);
	        
		}
	}

	public void aceptarProuesta(Stage stage, Jugador remitente, Comprable propiedadDelRemitente, Jugador destinatario,
		Comprable propiedadDelDestino) {
		stage.setTitle("");
		
		BorderPane layout = new BorderPane();
		
		
		Text text0 = new Text();
        text0.setText("Jugador ");
        text0.setFont(font("Helvetica", FontPosture.REGULAR, 20));
		
        Text text1 = new Text();
        text1.setText(destinatario.getNombre());
        text1.setFont(font("Helvetica", FontWeight.BOLD, 25));
        
        Text text2 = new Text();
        text2.setText(" aceptas intercambio?");
        text2.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        TextFlow textos = new TextFlow();
        textos.setTextAlignment(TextAlignment.CENTER);
        textos.getChildren().addAll(text0,text1, text2);
        textos.setPadding(new Insets(10,10,10,10));
        layout.setCenter(textos);
        
        HBox opciones = new HBox();
        opciones.setAlignment(Pos.TOP_CENTER);
        opciones.setSpacing(15);
        opciones.setPadding(new Insets(10,10,10,10));
        layout.setBottom(opciones);
 
        Button botonaceptar = new Button();
        botonaceptar.setMinWidth(80);
        botonaceptar.setText("Aceptar");
        BotonAceptarIntercambio botonAceptar = new BotonAceptarIntercambio(stage,remitente,propiedadDelRemitente,destinatario,
    			propiedadDelDestino);
        botonaceptar.setOnAction(botonAceptar);
        
        
        Button botonrechazar = new Button();
        botonrechazar.setMinWidth(80);
        botonrechazar.setText("No");
        EventHandler<ActionEvent> botonrechazarhandler = new BotonVolverHandler(stage);
        botonrechazar.setOnAction(botonrechazarhandler);
        
        opciones.getChildren().addAll(botonaceptar, botonrechazar);
        
        Scene ecena = new Scene(layout,600, 200);
        stage.setScene(ecena);
		
	}

	public void interCambioAceptado(Stage stage){
		stage.setTitle("");
		
		BorderPane layout = new BorderPane();
		
        Text text1 = new Text();
        text1.setText("Intercambio Exitoso");
        text1.setFont(font("Helvetica", FontPosture.REGULAR, 20));
		
        text1.setTextAlignment(TextAlignment.CENTER);
        
        layout.setTop(text1);

        
        Scene scene = new Scene(layout, 600, 100);
        stage.setScene(scene);
        
        Button volver = new Button();
        volver.setText("Aceptar");
        BotonVolverHandler botonVolver = new BotonVolverHandler(stage);
        volver.setOnAction(botonVolver);
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(text1,volver);
        vbox.setPadding( new Insets(10,10,10,10));
        vbox.setAlignment(Pos.CENTER);

        
        layout.setTop(vbox);
        
	}
}
