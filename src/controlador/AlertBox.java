package controlador;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;


import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import static javafx.scene.text.Font.*;


public class AlertBox {

    public void display(String posicion, int valorDados){

        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setTitle("Desplazamiento");

        BorderPane layout = new BorderPane();

        Text text = new Text();
        Text text2 = new Text();

        System.out.println("Valor de los dados: " + valorDados + "\n" + "Caiste en: " + posicion);
        text.setText("Valor de los dados: " + valorDados + "\n" );
        text2.setText("Caiste en: " + posicion);

        text.setFont(font("Helvetica", FontPosture.ITALIC, 20));
        text2.setFont(font("Helvetica", FontPosture.ITALIC, 20));

        Button button = new Button();
        button.setAlignment(Pos.CENTER);

        button.setText("OK");


        button.setOnAction(event -> stage.close());


        TextFlow text3 = new TextFlow(text,text2);
        text3.setTextAlignment(TextAlignment.CENTER);
        text3.setPadding( new Insets(10,10,10,10));

        layout.setTop(text3);

        button.setAlignment(Pos.CENTER);
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(text3,button);
        vbox.setPadding( new Insets(10,10,10,10));
        vbox.setAlignment(Pos.CENTER);
        
        layout.setCenter(vbox);


        Scene scene = new Scene(layout, 300,120);

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

        Scene scene = new Scene(layout, 350,120);
	    stage.setScene(scene);
	        
	    stage.showAndWait();
	}
}
