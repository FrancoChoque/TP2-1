package vista;

import static javafx.scene.text.Font.font;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import controlador.BotonConfirmarConstruirCasaHandler;
import controlador.BotonVolverHandler;
import controlador.VentanaJuego;
import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Jugador.Jugador;
import vista.eventos.BotonConfirmarCobrarFianzaHandler;
import vista.eventos.BotonConfirmarConstruirHotelHandler;
import vista.eventos.BotonConfirmarVenderTerrenoHandler;

public class VentanaOperacion {

	private HashMap<String, Propiedad> map;
	private VentanaJuego juego = VentanaJuego.getInstance();

	public VentanaOperacion() {
	}
	
	public void setMap(HashMap<String, Propiedad> map) {
		this.map = map;
	}

	public void ventanaconstruirhotel(Propiedad prop) {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Construir hotel");

        BorderPane layout = new BorderPane();
        
        Text text1 = new Text();
        text1.setText("Desea construir un hotel\n");
        text1.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        Text text2 = new Text();
        text2.setText("en "+ prop.getNombre() + "?");
        text2.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        TextFlow textos = new TextFlow();
        textos.setTextAlignment(TextAlignment.CENTER);
        textos.getChildren().addAll(text1, text2);
        textos.setPadding(new Insets(10,10,10,10));
        
        layout.setTop(textos);
               
        
        HBox opciones = new HBox();
        opciones.setAlignment(Pos.TOP_CENTER);
        opciones.setSpacing(15);
        opciones.setPadding(new Insets(10,10,10,10));
        layout.setBottom(opciones);
 
        Button botonaceptar = new Button();
        botonaceptar.setText("Construir");
        EventHandler<ActionEvent> botonaceptarhandler = new BotonConfirmarConstruirHotelHandler(stage);
        botonaceptar.setOnAction(botonaceptarhandler);
        
        
        Button botonrechazar = new Button();
        botonrechazar.setText("Volver");
        EventHandler<ActionEvent> botonrechazarhandler = new BotonVolverHandler(stage);
        botonrechazar.setOnAction(botonrechazarhandler);
        
        
        
        
        opciones.getChildren().addAll(botonaceptar, botonrechazar);
        
        Scene scene = new Scene(layout, 300,170);
        stage.setScene(scene);
        stage.showAndWait();
	}

	public void venderterreno(HashMap<String, Comprable> hash) {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Vender terreno");

        BorderPane layout = new BorderPane();
        
        Text text1 = new Text();
        text1.setText("Seleccione la propiedad\n");
        text1.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        Text text2 = new Text();
        text2.setText("que desee vender");
        text2.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        TextFlow textos = new TextFlow();
        textos.setTextAlignment(TextAlignment.CENTER);
        textos.getChildren().addAll(text1, text2);
        textos.setPadding(new Insets(10,10,10,10));
        
        layout.setTop(textos);
        
        ComboBox<String> combobox = new ComboBox<String>();
        Set<String> entradas = hash.keySet();
        Iterator<String> iter = entradas.iterator();
        while(iter.hasNext()) {
        	String propiedadactual = iter.next();
        	combobox.getItems().add(propiedadactual);        	
        }
        
        layout.setCenter(combobox);
        
        
        HBox opciones = new HBox();
        opciones.setAlignment(Pos.TOP_CENTER);
        opciones.setSpacing(15);
        opciones.setPadding(new Insets(10,10,10,10));
        layout.setBottom(opciones);
 
        Button botonaceptar = new Button();
        botonaceptar.setText("Vender");
        EventHandler<ActionEvent> botonaceptarhandler = new BotonConfirmarVenderTerrenoHandler(stage,combobox,hash);
        botonaceptar.setOnAction(botonaceptarhandler);
        
        
        Button botonrechazar = new Button();
        botonrechazar.setText("Volver");
        EventHandler<ActionEvent> botonrechazarhandler = new BotonVolverHandler(stage);
        botonrechazar.setOnAction(botonrechazarhandler);
        
        
        
        
        opciones.getChildren().addAll(botonaceptar, botonrechazar);
        
        Scene scene = new Scene(layout, 300,170);
        stage.setScene(scene);
        stage.showAndWait();
	}

	public void cobrarfianza() {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Cobrar fianza");

        BorderPane layout = new BorderPane();
        
        Text text1 = new Text();
        text1.setText("La fianza cuesta $45000\n");
        text1.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        Text text2 = new Text();
        text2.setText("Desea pagarla?");
        text2.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        TextFlow textos = new TextFlow();
        textos.setTextAlignment(TextAlignment.CENTER);
        textos.getChildren().addAll(text1, text2);
        textos.setPadding(new Insets(10,10,10,10));
        
        layout.setTop(textos);
        
        
        
        HBox opciones = new HBox();
        opciones.setAlignment(Pos.TOP_CENTER);
        opciones.setSpacing(15);
        opciones.setPadding(new Insets(10,10,10,10));
        layout.setBottom(opciones);
 
        Button botonaceptar = new Button();
        botonaceptar.setText("Si");
        EventHandler<ActionEvent> botonaceptarhandler = new BotonConfirmarCobrarFianzaHandler(stage);
        botonaceptar.setOnAction(botonaceptarhandler);
        
        
        Button botonrechazar = new Button();
        botonrechazar.setText("No");
        EventHandler<ActionEvent> botonrechazarhandler = new BotonVolverHandler(stage);
        botonrechazar.setOnAction(botonrechazarhandler);
        
        
        
        
        opciones.getChildren().addAll(botonaceptar, botonrechazar);
        
        Scene scene = new Scene(layout, 300,170);
        stage.setScene(scene);
        stage.showAndWait();
	}

	public void ventanaconstruircasa(Jugador actual, Propiedad prop) {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Construir casa");

        BorderPane layout = new BorderPane();
        
        Text text1 = new Text();
        text1.setText("Desea construir una casa\n");
        text1.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        Text text2 = new Text();
        text2.setText("en" + prop.getNombre() + "?");
        text2.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        TextFlow textos = new TextFlow();
        textos.setTextAlignment(TextAlignment.CENTER);
        textos.getChildren().addAll(text1, text2);
        textos.setPadding(new Insets(10,10,10,10));
        
        layout.setTop(textos);
        
        
        
        HBox opciones = new HBox();
        opciones.setAlignment(Pos.TOP_CENTER);
        opciones.setSpacing(15);
        opciones.setPadding(new Insets(10,10,10,10));
        layout.setBottom(opciones);
 
        Button botonaceptar = new Button();
        botonaceptar.setText("Si");
        EventHandler<ActionEvent> botonaceptarhandler = new BotonConfirmarConstruirCasaHandler(stage);
        botonaceptar.setOnAction(botonaceptarhandler);
        
        
        Button botonrechazar = new Button();
        botonrechazar.setText("No");
        EventHandler<ActionEvent> botonrechazarhandler = new BotonVolverHandler(stage);
        botonrechazar.setOnAction(botonrechazarhandler);
        
        
        
        
        opciones.getChildren().addAll(botonaceptar, botonrechazar);
        
        Scene scene = new Scene(layout, 300,170);
        stage.setScene(scene);
        stage.showAndWait();
	}

}
