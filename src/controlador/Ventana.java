package controlador;

import java.util.HashMap;

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
import modelo.Tablero;
import modelo.Jugador.Jugador;
import vista.JugadorCapa;

public class Ventana extends Application{
	
	@Override
    public void start(Stage primaryStage) {
               
        AlgoPoly juego = new AlgoPoly();
        HashMap<Jugador, JugadorCapa> hash = new HashMap<Jugador, JugadorCapa>();
        Jugador jugador1 = juego.nuevoJugador("Player1");
        Jugador jugador2 = juego.nuevoJugador("player2");
		
		
		//Layout borderpane
        
        BorderPane root = new BorderPane();
        
        // Agrego imagen del tablero
        Image unaimagen = new Image("imagenes/tablero.jpg");
        ImageView univ = new ImageView();
        univ.setImage(unaimagen);
        univ.setPreserveRatio(true);
        univ.setFitWidth(800);
        
        
        //Creo la pila de capas de jugadores
        StackPane stackcapas = new StackPane();
        
        // Creo los canvas para cada jugador, los agrego al hashmap
        Canvas canvasjugador1 = new Canvas(800, 800);
        GraphicsContext gcjugador1 = canvasjugador1.getGraphicsContext2D();
        JugadorCapa capajugador1 = new JugadorCapa(gcjugador1, jugador1, Color.BLACK);
        stackcapas.getChildren().add(canvasjugador1);
        hash.put(jugador1, capajugador1);
        
        Canvas canvasjugador2 = new Canvas(800, 800);
        GraphicsContext gcjugador2 = canvasjugador2.getGraphicsContext2D();
        JugadorCapa capajugador2 = new JugadorCapa(gcjugador2, jugador2, Color.SPRINGGREEN);
        stackcapas.getChildren().add(canvasjugador2);
        hash.put(jugador2, capajugador2);
    
        
        capajugador1.dibujar();
        capajugador2.dibujar();
        
        Tablero tablero = Tablero.getInstance();
        tablero.moverJugador(jugador1, 1);
        
        capajugador1.dibujar();
        
        tablero.moverJugador(jugador1, 1);
        
        capajugador1.dibujar();
        
        StackPane stack = new StackPane();
        stack.getChildren().addAll(univ,
        		stackcapas);
        
        root.setCenter(stack);
        
        Scene scene = new Scene(root, 1000, 900);
        
       
        //Botonera horizontal
        
        Button BotonSalir = new Button();
        BotonSalir.setText("Salir");
        EventHandler<ActionEvent> BotonSalirHandler = new BotonSalirHandler();
        BotonSalir.setOnAction(BotonSalirHandler);
        
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        
        hbox.getChildren().addAll(BotonSalir);
        
        root.setTop(hbox);
        
        //Botonera de acciones en vertical
        
        Button BotonArrojarDados = new Button();
        BotonArrojarDados.setText("Tirar Dados");
        EventHandler<ActionEvent> BotonArrojarDadosHandler = new BotonArrojarDadosHandler(juego,hash);
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
        

        primaryStage.setTitle("Lorem ipsum");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
 public static void main(String[] args) {
        launch(args);
    }
}
