package controlador;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import static javafx.scene.text.Font.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import estados.EstadoCasillero;
import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import modelo.Jugador.Jugador;
import vista.eventos.BotonVolverOnKeyPress;


public class AlertBox {

    public void display(String posicion, int valorDado1, int valorDado2){

        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setTitle("Desplazamiento");

        BorderPane layout = new BorderPane();

        Text text = new Text();

        ImageView view = new ImageView(new Image("file:src/imagenes/Casilleros/dados.png"));


        text.setText("Valor de los dados: " + valorDado1 + " y " + valorDado2 +"\n" + "Caiste en: " + posicion +"\n");
        text.setFont(font("Helvetica", FontPosture.ITALIC, 20));

        Button button = new Button();
        button.setAlignment(Pos.CENTER);
        button.setMinWidth(80);
        button.setText("OK");


        button.setOnAction(event -> stage.close());
        button.setOnKeyPressed(new BotonVolverOnKeyPress(stage));


        TextFlow text3 = new TextFlow(text);
        text3.setTextAlignment(TextAlignment.CENTER);
        text3.setPadding( new Insets(10,10,10,10));
        BorderPane.setAlignment(view,Pos.TOP_CENTER);
        layout.setTop(view);

        button.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(text3,button);
        vbox.setPadding( new Insets(10,10,10,10));
        vbox.setAlignment(Pos.CENTER);

        layout.setCenter(vbox);


        Scene scene = new Scene(layout, 370,325);

        stage.setScene(scene);

        stage.showAndWait();

    }

    public void error(String string) {
        // TODO Auto-generated method stub
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setTitle("Error");

        BorderPane layout = new BorderPane();

        Text text = new Text();
        text.setText(string);
        text.setFont(font("Helvetica", FontPosture.ITALIC, 20));


        Button button = new Button();
        button.setAlignment(Pos.CENTER);
        button.setMinWidth(80);
        button.setText("OK");

        button.setOnAction(event -> stage.close());
        button.setOnKeyPressed(new BotonVolverOnKeyPress(stage));


        TextFlow text3 = new TextFlow(text);
        text3.setTextAlignment(TextAlignment.CENTER);
        text3.setPadding( new Insets(10,10,10,10));


        VBox vbox = new VBox();
        vbox.getChildren().addAll(text3,button);
        vbox.setPadding( new Insets(10,10,10,10));
        vbox.setAlignment(Pos.CENTER);

        layout.setCenter(vbox);

        Scene scene = new Scene(layout, 350,160);
        stage.setScene(scene);

        stage.showAndWait();
    }

    public void ofrecercompra(BorderPane layout, Stage stage) {


        HBox opciones = new HBox();
        opciones.setAlignment(Pos.TOP_CENTER);
        opciones.setSpacing(15);
        opciones.setPadding(new Insets(10,10,10,10));
        layout.setBottom(opciones);

        Button botonaceptar = new Button();
        botonaceptar.setMinWidth(80);
        botonaceptar.setText("Comprar");
        EventHandler<ActionEvent> botonaceptarhandler = new BotonComprarTerrenoHandler(stage);
        botonaceptar.setOnAction(botonaceptarhandler);


        Button botonrechazar = new Button();
        botonrechazar.setMinWidth(80);
        botonrechazar.setText("Volver");
        EventHandler<ActionEvent> botonrechazarhandler = new BotonVolverHandler(stage);
        botonrechazar.setOnAction(botonrechazarhandler);

        opciones.getChildren().addAll(botonaceptar, botonrechazar);

        layout.setBottom(opciones);
    }

    public void errorcompra() {
        // TODO Auto-generated method stub
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setTitle("Error al comprar");

        BorderPane layout = new BorderPane();

        Text text = new Text();

        text.setText("Dinero insuficiente para comprar.\n" );

        text.setFont(font("Helvetica", FontPosture.ITALIC, 20));


        Button button = new Button();
        button.setAlignment(Pos.CENTER);
        button.setMinWidth(80);

        button.setText("OK");

        button.setOnAction(event -> stage.close());

        TextFlow text3 = new TextFlow(text);
        text3.setTextAlignment(TextAlignment.CENTER);
        text3.setPadding( new Insets(10,10,10,10));



        VBox vbox = new VBox();
        vbox.getChildren().addAll(text3,button);
        vbox.setPadding( new Insets(10,10,10,10));
        vbox.setAlignment(Pos.CENTER);

        layout.setCenter(vbox);


        Scene scene = new Scene(layout, 300,150);

        stage.setScene(scene);

        stage.showAndWait();
    }

    public void mensajeEfecto(Jugador jugador, EstadoCasillero casillero, AudioClip audioClip, Image imagen){

        Stage stage = new Stage();


        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setTitle(casillero.getNombre());

        BorderPane layout = new BorderPane();

        Text text = new Text();

        text.setText(casillero.getMensaje(jugador));

        text.setFont(font("Helvetica", FontPosture.ITALIC, 23));

        layout.setCenter(text);

        ImageView view = new ImageView(imagen);

        BorderPane.setAlignment(view,Pos.BOTTOM_CENTER);

        layout.setTop(view);

        if(casillero instanceof Comprable){
            if(!((Comprable) casillero).tieneDuenio()){
                ofrecercompra(layout,stage);
            }else return;

        }else{
            Button button = new Button();
            button.setAlignment(Pos.CENTER);
            button.setMinWidth(80);
            button.setText("OK");

            button.setOnAction(event -> stage.close());
            button.setOnKeyPressed(new BotonVolverOnKeyPress(stage));
            button.setAlignment(Pos.TOP_CENTER);
            BorderPane.setAlignment(button,Pos.TOP_CENTER);
            layout.setBottom(button);
        }
        Scene scene = new Scene(layout, 400,250);
        stage.setScene(scene);

        stage.showAndWait();

    }




}
