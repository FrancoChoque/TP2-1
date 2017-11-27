package controlador;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.ContenedorIntercambio;

public class Ventana extends Application{
	
	@Override
    public void start(Stage primaryStage) {
               
        //Layout borderpane
		
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1400, 900);
        //Botonera horizontal
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("eeeee");
            }
        });
        
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        
        hbox.getChildren().addAll(btn);
        
        root.setTop(hbox);
        
        //Botonera de acciones en vertical
        
        Button BotonArrojarDados = new Button();
        BotonArrojarDados.setText("Tirar Dados");
        EventHandler<ActionEvent> BotonArrojarDadosHandler = new BotonArrojarDadosHandler();
        BotonArrojarDados.setOnAction(BotonArrojarDadosHandler);
        
        Button BotonComprarTerreno = new Button();
        BotonComprarTerreno.setText("Comprar Terreno");
        EventHandler<ActionEvent> BotonComprarTerrenoHandler = new BotonComprarTerrenoHandler();
        BotonComprarTerreno.setOnAction(BotonComprarTerrenoHandler);
        
        Button BotonVenderTerreno = new Button();
        BotonVenderTerreno.setText("Vender Terreno");
        EventHandler<ActionEvent> BotonVenderTerrenoHandler = new BotonVenderTerrenoHandler();
        BotonVenderTerreno.setOnAction(BotonVenderTerrenoHandler);
        
        
        ContenedorIntercambio contenedorIntercambio = new ContenedorIntercambio(primaryStage,scene);
        Scene escenaIntercambio = new Scene(contenedorIntercambio, 640, 480);
        
        Button BotonIntercambiarTerreno = new Button();
        BotonIntercambiarTerreno.setText("Intercambiar terreno");
        EventHandler<ActionEvent> BotonIntercambiarTerrenoHandler = new BotonIntercambiarTerrenoHandler(primaryStage,escenaIntercambio);
        BotonIntercambiarTerreno.setOnAction(BotonIntercambiarTerrenoHandler);
        
        Button BotonConstruirCasa = new Button();
        BotonConstruirCasa.setText("Construir casa");
        EventHandler<ActionEvent> BotonConstruirCasaHandler = new BotonConstruirCasaHandler();
        BotonConstruirCasa.setOnAction(BotonConstruirCasaHandler);
        
        Button BotonConstruirHotel = new Button();
        BotonConstruirHotel.setText("Construir hotel");
        EventHandler<ActionEvent> BotonConstruirHotelHandler = new BotonConstruirHotelHandler();
        BotonConstruirHotel.setOnAction(BotonConstruirHotelHandler);
        
        Button BotonVenderCasa = new Button();
        BotonVenderCasa.setText("Vender casa");
        EventHandler<ActionEvent> BotonVenderCasaHandler = new BotonVenderCasaHandler();
        BotonVenderCasa.setOnAction(BotonVenderCasaHandler);
        
        Button BotonVenderHotel = new Button();
        BotonVenderHotel.setText("Vender hotel");
        EventHandler<ActionEvent> BotonVenderHotelHandler = new BotonVenderHotelHandler();
        BotonVenderHotel.setOnAction(BotonVenderHotelHandler);
        
        Button BotonTerminarTurno = new Button();
        BotonTerminarTurno.setText("Terminar turno");
        EventHandler<ActionEvent> BotonTerminarTurnoHandler = new BotonTerminarTurnoHandler();
        BotonTerminarTurno.setOnAction(BotonTerminarTurnoHandler);
        
        VBox AccionesVBox = new VBox();
        AccionesVBox.setPadding(new Insets(10,12,10,12) );
        AccionesVBox.setSpacing(10);
        
        AccionesVBox.getChildren().addAll(BotonArrojarDados, BotonComprarTerreno, 
        		BotonVenderTerreno, BotonIntercambiarTerreno, BotonConstruirCasa,
        		BotonConstruirHotel, BotonVenderCasa, BotonVenderHotel,
        		BotonTerminarTurno);
        
        root.setLeft(AccionesVBox);
        
        
        /*Pongo canvas del centro
        
        Canvas uncanvas = new Canvas(600,600);
        GraphicsContext ungc = uncanvas.getGraphicsContext2D();
        
        ungc.setFill(Color.TRANSPARENT);
        ungc.fillRect(0, 0, 600, 600);
        
        ungc.setFill(Color.AQUA);
        ungc.fillRect(0, 0, 100, 100);
        
        root.setCenter(uncanvas);
		*/
        
        
        // Agrego imagen en el centro
        Image unaimagen = new Image("imagenes/tablero.jpg");
        ImageView univ = new ImageView();
        univ.setImage(unaimagen);
        univ.setPreserveRatio(true);
        univ.setFitWidth(800);
        //root.setCenter(univ);

        Canvas uncanvas = new Canvas(800,800);
        GraphicsContext ungc = uncanvas.getGraphicsContext2D();
        ungc.setFill(Color.TRANSPARENT);
        ungc.fillRect(0, 0, 800, 800);
        ungc.setFill(Color.DEEPSKYBLUE);
        ungc.fillRect(770, 770, 10, 10);
        
        StackPane stack = new StackPane();
        stack.getChildren().addAll(univ,
        		uncanvas);
        
        root.setCenter(stack);
        
        //Scene scene = new Scene(root, 1400, 900);

        primaryStage.setTitle("Lorem ipsum");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
 public static void main(String[] args) {
        launch(args);
    }
}
