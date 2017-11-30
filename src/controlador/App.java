package controlador;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import modelo.AlgoPoly;


public class App extends Application {

    private Stage primaryStage;
    private BorderPane root;
    private Scene ecenaPrincipal;
    private AlgoPoly algoPoly;
    private static App instance;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AlgoPoly");

        menuPrincipal();

    }


    public void menuPrincipal(){
    	

        VentanaLogin registro = new VentanaLogin();

        algoPoly = new AlgoPoly();

        Menu fileMenu = new Menu("Juego");
        MenuItem nuevoJuego = new MenuItem("Nueva Partida...");
        MenuItem salirJuego = new MenuItem("Salir");
        fileMenu.getItems().add(nuevoJuego);
        fileMenu.getItems().add(salirJuego);

        salirJuego.setOnAction(event -> this.primaryStage.close());
        nuevoJuego.setOnAction(event -> registro.login());


        Image imagen = new Image("file:src/imagenes/menu.jpg");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        Background background = new Background(imagenDeFondo);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);

        root = new BorderPane();

        root.setTop(menuBar);

        root.setBackground(background);
        Scene scene = new Scene(root, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public App() {
        instance = this;
        algoPoly = new AlgoPoly();
    }
    
    public void setecenaPrincipal(Scene scene){
    	this.ecenaPrincipal = scene;
    }
    
    public Scene getecenaPrincipal(){
    	return this.ecenaPrincipal;
    }
    
    public Stage getPrimaryStage(){
    	return this.primaryStage;
    }
    public AlgoPoly getAlgoPoly(){
    	return this.algoPoly;
    }
    public static App getInstance() {
        return instance;
    }
}