package controlador;

import java.util.HashMap;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.ContenedorIntercambio;
import modelo.Tablero;
import modelo.Jugador.Jugador;
import vista.JugadorCapa;


public class Ventana{
	
	private Text nombrejugador = new Text();
	private Text dinerojugador = new Text();
	private Text posicionjugador = new Text();
	private String accionesjugador = "";
	private AlgoPoly algopoly;

	private Paint valor = Paint.valueOf("FFFFFF");
	private Text text5;

	public void initialize(Stage primaryStage, AlgoPoly juego, String nombreJugador1, String nombreJugador2) {
        


	    this.algopoly = juego;

        HashMap<Jugador, JugadorCapa> hash = new HashMap<Jugador, JugadorCapa>();
        Jugador jugador1 = juego.nuevoJugador(nombreJugador1);
        Jugador jugador2 = juego.nuevoJugador(nombreJugador2);

        //Jugador jugador3 = juego.nuevoJugador("player3");
		

		App mainApp = App.getInstance();
		
		//Layout borderpane y escena
        
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1000, 700);
        mainApp.setecenaPrincipal(scene);
        
        // Agrego imagen del tablero
        Image unaimagen = new Image("imagenes/tablero.jpg");
        ImageView univ = new ImageView();
        univ.setImage(unaimagen);
        univ.setPreserveRatio(true);
        univ.setFitWidth(600);
        
        
        //Creo la pila de capas de jugadores
        StackPane stackcapas = new StackPane();
        
        // Creo los canvas para cada jugador, los agrego al hashmap
        Image iconojugador1 = new Image("imagenes/galera.jpg");
        Image iconojugador2 = new Image("imagenes/carretilla.jpg");
        
        Canvas canvasjugador1 = new Canvas(600, 600);
        GraphicsContext gcjugador1 = canvasjugador1.getGraphicsContext2D();
        JugadorCapa capajugador1 = new JugadorCapa(gcjugador1, jugador1, Color.BLACK, iconojugador1);
        stackcapas.getChildren().add(canvasjugador1);
        hash.put(jugador1, capajugador1);
        
        
        Canvas canvasjugador2 = new Canvas(600, 600);
        GraphicsContext gcjugador2 = canvasjugador2.getGraphicsContext2D();
        JugadorCapa capajugador2 = new JugadorCapa(gcjugador2, jugador2, Color.SPRINGGREEN, iconojugador2);
        stackcapas.getChildren().add(canvasjugador2);
        hash.put(jugador2, capajugador2);
        
        /*Canvas canvasjugador3 = new Canvas(800, 800);
        GraphicsContext gcjugador3 = canvasjugador3.getGraphicsContext2D();
        JugadorCapa capajugador3 = new JugadorCapa(gcjugador3, jugador3, Color.LIGHTBLUE);
        stackcapas.getChildren().add(canvasjugador3);
        hash.put(jugador3, capajugador3);*/
    
        
        capajugador1.dibujar();
        capajugador2.dibujar();
        //capajugador3.dibujar();
        

        StackPane stack = new StackPane();
        stack.getChildren().addAll(univ, stackcapas);
        
        root.setCenter(stack);
        
       
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
        EventHandler<ActionEvent> BotonArrojarDadosHandler = new BotonArrojarDadosHandler(this.algopoly ,hash, this);
        BotonArrojarDados.setOnAction(BotonArrojarDadosHandler);
        
        Button BotonComprarTerreno = new Button();
        BotonComprarTerreno.setText("Comprar Terreno");
        EventHandler<ActionEvent> BotonComprarTerrenoHandler = new BotonComprarTerrenoHandler();
        BotonComprarTerreno.setOnAction(BotonComprarTerrenoHandler);
        
        Button BotonVenderTerreno = new Button();
        BotonVenderTerreno.setText("Vender Terreno");
        EventHandler<ActionEvent> BotonVenderTerrenoHandler = new BotonVenderTerrenoHandler();
        BotonVenderTerreno.setOnAction(BotonVenderTerrenoHandler);
        
        Button BotonIntercambiarTerreno = new Button();
        BotonIntercambiarTerreno.setText("Intercambiar terreno");

        EventHandler<ActionEvent> BotonIntercambiarTerrenoHandler = new BotonIntercambiarTerrenoHandler();
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
        EventHandler<ActionEvent> BotonTerminarTurnoHandler = new BotonTerminarTurnoHandler(this, juego);
        BotonTerminarTurno.setOnAction(BotonTerminarTurnoHandler);
        
        VBox AccionesVBox = new VBox();
        AccionesVBox.setPadding(new Insets(10,12,10,12) );
        AccionesVBox.setSpacing(10);
        
        AccionesVBox.getChildren().addAll(BotonArrojarDados,BotonTerminarTurno, BotonComprarTerreno, 
        		BotonVenderTerreno, BotonIntercambiarTerreno, BotonConstruirCasa,
        		BotonConstruirHotel, BotonVenderCasa, BotonVenderHotel
        		);
        
        root.setLeft(AccionesVBox);
        
        
        //Agrego Textflow a la derecha
        
        StackPane stackderecho = new StackPane();
        
                
       /*       
        Text untexto = new Text();
        untexto.setText("Turno actual\n");
        
        Text textoestado = new Text();
        untexto.setText("Yolo: " + "swag" + "\n" + "blaze it 420");
        
        TextFlow textflow = new TextFlow(untexto,textoestado);
        textflow.setMaxHeight(600);
        textflow.setBackground(new Background(new BackgroundFill(valor, CornerRadii.EMPTY, Insets.EMPTY)));
        */
        
        Text textoturnojugador = new Text("Turno Actual: ");
        textoturnojugador.setFill(Color.RED);
        textoturnojugador.setFont(Font.font("Helvetica", FontPosture.ITALIC, 20));
        Text textodinerojugador = new Text("Dinero disponible: ");
        textodinerojugador.setFill(Color.BLUE);
        textodinerojugador.setFont(Font.font("Helvetica", FontWeight.BOLD, 10));
        Text textoposicionjugador = new Text();
        textoposicionjugador.setText("Posicion del jugador: ");
        Text textoaccionesjugador = new Text();
        textoaccionesjugador.setText("Acciones realizadas en el turno:\n");
        this.text5 = new Text();
        text5.setText(accionesjugador);
        
        
        TextFlow textFlow = new TextFlow(textoturnojugador,this.nombrejugador, textodinerojugador,this.dinerojugador, textoposicionjugador,this.posicionjugador,
        		textoaccionesjugador, text5);
        textFlow.setMaxHeight(600);
        textFlow.setMinWidth(400);
        textFlow.setBackground(new Background(new BackgroundFill(valor, CornerRadii.EMPTY, Insets.EMPTY)));
        
        stackderecho.getChildren().addAll(textFlow);
        root.setRight(stackderecho);
        

        primaryStage.setTitle("Lorem ipsum");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        this.actualizarturno();
    }
	
	public void actualizarturno() {
		Jugador jugadoractual = this.algopoly.obtenerJugadorActual();
		this.nombrejugador.setText(jugadoractual.getNombre() + "\n");
		this.dinerojugador.setText(jugadoractual.getDinero() + "\n" );
		Tablero tablero = Tablero.getInstance();
		this.posicionjugador.setText(tablero.obtenerPosicion(jugadoractual) + "\n");
		this.accionesjugador = "";
		this.text5.setText(accionesjugador);
		jugadoractual.setEstado(jugadoractual.getJugadorEmpezandoTurno() );
	}

	public void agregaraccion(String accion) {
		// TODO Auto-generated method stub
		this.accionesjugador = this.accionesjugador + accion;
		this.text5.setText(accionesjugador);
	}
	
	public void actualizarposicion(Jugador jugadoractual) {
		Tablero tablero = Tablero.getInstance();
		this.posicionjugador.setText(tablero.obtenerPosicion(jugadoractual) + "\n");
		this.dinerojugador.setText(jugadoractual.getDinero() + "\n");
	}
    
}