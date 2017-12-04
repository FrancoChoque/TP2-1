package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import controlador.BotonVolverHandler;

public class ContenedorMensaje extends VBox{

	private Stage stage;
	public ContenedorMensaje(Stage stage){
		super();
        this.stage = stage;
	}

	public void mostrarMensaje(String mensaje) {
	
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);
        
        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        etiqueta.setText(mensaje);
        etiqueta.setTextFill(Color.web("#66A7C5"));
        grid.add(etiqueta,0,1);
        
        Button volver = new Button();
        volver.setText("Aceptar");
        BotonVolverHandler botonVolver = new BotonVolverHandler(stage);
        volver.setOnAction(botonVolver);
        
        grid.add(volver,0,2);
        stage.setScene(scene);
        stage.showAndWait();
		
	}
	
}
