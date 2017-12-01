package controlador;


import javafx.geometry.Pos;
import javafx.scene.Scene;


import javafx.scene.layout.BorderPane;

import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
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

        button.setText("OK");


        button.setOnAction(event -> stage.close());


        TextFlow text3 = new TextFlow(text,text2);

        layout.setTop(text3);

        button.setAlignment(Pos.CENTER);
        layout.setCenter(button);


        Scene scene = new Scene(layout, 300,150);

        stage.setScene(scene);

        stage.showAndWait();

    }
}
