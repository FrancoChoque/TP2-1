package controlador;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.AlgoPoly;
import vista.eventos.MenuReglasHandler;


public class App extends Application {

    private Stage primaryStage;
    private BorderPane root;
    private Scene ecenaPrincipal;
    private AlgoPoly algoPoly= new AlgoPoly();
    private static App instance;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Bienvenida");

        menuPrincipal();

    }


    public void menuPrincipal(){
    	

        //VentanaLogin registro = new VentanaLogin();
    	Login registro = new Login();


        Menu fileMenu = new Menu("Juego");
        MenuItem nuevoJuego = new MenuItem("Nueva Partida...");
        MenuItem salirJuego = new MenuItem("Salir");
        fileMenu.getItems().add(nuevoJuego);
        fileMenu.getItems().add(salirJuego);

        salirJuego.setOnAction(event -> this.primaryStage.close());
        nuevoJuego.setOnAction(event -> registro.login());
        
        Menu menuayuda = new Menu("Ayuda");
        MenuItem reglas = new MenuItem("Reglas del juego");
  
        
        menuayuda.getItems().add(reglas);

        
        reglas.setOnAction(new MenuReglasHandler() );
        
        
        

        
        /*
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
        		new BackgroundPosition(null, 0, false, null, 100, false), BackgroundSize.DEFAULT);
        
        Background background = new Background(imagenDeFondo);
        */
        
        MenuBar menuBar = new MenuBar();
        
		menuBar.getMenus().addAll(fileMenu,menuayuda);

        root = new BorderPane();

        root.setTop(menuBar);
        
        Text text1 = new Text("Bienvenido a AlgoPoly");
        text1.setFont(Font.font("Helvetica", FontWeight.BOLD, 40));

        TextFlow textos = new TextFlow();
        textos.getChildren().add(text1);
        textos.setTextAlignment(TextAlignment.CENTER);
        textos.setPadding(new Insets(5));
        
        root.setCenter(textos);
        
        //Agrego imagen de fondo
        
        Image imagen = new Image("file:src/imagenes/menu.jpg");
        ImageView univ = new ImageView(imagen);
        univ.setPreserveRatio(true);
        univ.setFitHeight(800);
        
        StackPane stack = new StackPane();
        stack.getChildren().add(univ);
        
        root.setBottom(stack);
        
        //root.setBackground(background);
        Scene scene = new Scene(root, 750,850);
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