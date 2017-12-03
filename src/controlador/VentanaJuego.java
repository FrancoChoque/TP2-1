package controlador;

import java.util.HashMap;


import estados.Comprable.Propiedad.Propiedad;
import estados.EstadoCasillero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
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
import modelo.Casillero;
import vista.ContenedorIntercambio;
import modelo.Tablero;
import modelo.Jugador.Jugador;
import vista.JugadorCapa;


public class VentanaJuego{
	
	private static VentanaJuego instance;


	//Metodos y atributos de clase
	
	public static VentanaJuego getInstance() {
		return instance;
	}
	
	static {
		instance = new VentanaJuego();
	}
	
	//Metodos y atributos de instancia
	
	private Text nombrejugador = new Text();
	private Text dinerojugador = new Text();
	private Text posicionjugador = new Text();
	private String accionesjugador = "";
	private ChoiceBox<String> propiedadesJugador = new ChoiceBox<>();
	private AlgoPoly algopoly;

	private Paint valor = Paint.valueOf("FFFFFF"); //pinta de blanco
	private Text text5;
	private Button botonArrojarDados;
	private Button botonVenderTerreno;
	private Button botonIntercambiarTerreno;
	private Button botonConstruirCasa;
	private Button botonConstruirHotel;
	private Button botonTerminarTurno;
	private Button botonPagarFianza;
	private HashMap<Jugador, JugadorCapa> hash;
	private Button botonVender;
	
	
	private VentanaJuego() {};
	
	public void initialize(Stage primaryStage, AlgoPoly juego, String nombreJugador1, String nombreJugador2, String nombrejugador3) {
        


	    this.algopoly = juego;

        hash = new HashMap<Jugador, JugadorCapa>();
        Jugador jugador1 = juego.nuevoJugador(nombreJugador1);
        Jugador jugador2 = juego.nuevoJugador(nombreJugador2);
        Jugador jugador3 = juego.nuevoJugador(nombrejugador3);
		

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
        Image iconojugador3 = new Image("imagenes/auto.png");
        
        Canvas canvasjugador1 = new Canvas(600, 600);
        GraphicsContext gcjugador1 = canvasjugador1.getGraphicsContext2D();
        JugadorCapa capajugador1 = new JugadorCapa(gcjugador1, jugador1, Color.CYAN, iconojugador1);
        stackcapas.getChildren().add(canvasjugador1);
        hash.put(jugador1, capajugador1);
        
        
        Canvas canvasjugador2 = new Canvas(600, 600);
        GraphicsContext gcjugador2 = canvasjugador2.getGraphicsContext2D();
        JugadorCapa capajugador2 = new JugadorCapa(gcjugador2, jugador2, Color.PINK, iconojugador2);
        stackcapas.getChildren().add(canvasjugador2);
        hash.put(jugador2, capajugador2);
        
        Canvas canvasjugador3 = new Canvas(600, 600);
        GraphicsContext gcjugador3 = canvasjugador3.getGraphicsContext2D();
        JugadorCapa capajugador3 = new JugadorCapa(gcjugador3, jugador3, Color.SPRINGGREEN, iconojugador3);
        stackcapas.getChildren().add(canvasjugador3);
        hash.put(jugador3, capajugador3);
    
        
        capajugador1.dibujar();
        capajugador2.dibujar();
        capajugador3.dibujar();
        

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
        
        botonArrojarDados = new Button();
        botonArrojarDados.setText("Tirar Dados");
        botonArrojarDados.setMinWidth(125);
        EventHandler<ActionEvent> BotonArrojarDadosHandler = new BotonArrojarDadosHandler(this.algopoly ,hash, this,botonArrojarDados);
        botonArrojarDados.setOnAction(BotonArrojarDadosHandler);
        
        
        botonPagarFianza = new Button();
        botonPagarFianza.setText("Pagar Fianza");
        botonPagarFianza.setMinWidth(125);
        EventHandler<ActionEvent> BotonPagarFianzaHandler = new BotonPagarFianzaHandler();
        botonPagarFianza.setOnAction(BotonPagarFianzaHandler);
        
        
        botonVenderTerreno = new Button();
        botonVenderTerreno.setText("Vender Terreno");
        botonVenderTerreno.setMinWidth(125);
        EventHandler<ActionEvent> BotonVenderTerrenoHandler = new BotonVenderTerrenoHandler();
        botonVenderTerreno.setOnAction(BotonVenderTerrenoHandler);
        
        botonIntercambiarTerreno = new Button();
        botonIntercambiarTerreno.setText("Intercambiar terreno");
        botonIntercambiarTerreno.setMinWidth(125);
        EventHandler<ActionEvent> BotonIntercambiarTerrenoHandler = new BotonIntercambiarTerrenoHandler();
        botonIntercambiarTerreno.setOnAction(BotonIntercambiarTerrenoHandler);
        
        botonConstruirCasa = new Button();
        botonConstruirCasa.setText("Construir casa");
        botonConstruirCasa.setMinWidth(125);
        EventHandler<ActionEvent> BotonConstruirCasaHandler = new BotonConstruirCasaHandler(this);
        botonConstruirCasa.setOnAction(BotonConstruirCasaHandler);
        
        botonConstruirHotel = new Button();
        botonConstruirHotel.setText("Construir hotel");
        botonConstruirHotel.setMinWidth(125);
        EventHandler<ActionEvent> BotonConstruirHotelHandler = new BotonConstruirHotelHandler();
        botonConstruirHotel.setOnAction(BotonConstruirHotelHandler);
        

        
        botonTerminarTurno = new Button();        
        botonTerminarTurno.setText("Terminar turno");
        botonTerminarTurno.setMinWidth(125);
        EventHandler<ActionEvent> BotonTerminarTurnoHandler = new BotonTerminarTurnoHandler(this, juego);
        botonTerminarTurno.setOnAction(BotonTerminarTurnoHandler);

        propiedadesJugador.getItems().add("Propiedad a vender");
        propiedadesJugador.setValue("Propiedad a vender");
        botonVender = new Button();
        botonVender.setText("Vender");
        botonVender.setOnAction(event ->  getChoice(propiedadesJugador));
        
        VBox AccionesVBox = new VBox();
        AccionesVBox.setPadding(new Insets(10,12,10,12) );
        AccionesVBox.setSpacing(10);
        
        AccionesVBox.getChildren().addAll(botonArrojarDados,botonTerminarTurno,  
        		botonVenderTerreno, botonIntercambiarTerreno, botonConstruirCasa,
        		botonConstruirHotel,propiedadesJugador,botonVender
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
		this.nombrejugador.setFill(hash.get(jugadoractual).getColor());
		this.dinerojugador.setText("$"+ jugadoractual.getDinero() + "\n" );
		Tablero tablero = Tablero.getInstance();
        this.posicionjugador.setText(tablero.obtenerCasillero(jugadoractual).getNombre() + "\n");
		this.accionesjugador = "";
		this.text5.setText(accionesjugador);
		jugadoractual.setEstado(jugadoractual.getJugadorEmpezandoTurno() );



		this.botonArrojarDados.setDisable(false);
		setTerminarturno(true);

		actualizarVenderTerreno(jugadoractual);
		actualizarConstruirCasa(jugadoractual);
		actualizarConstruirHotel(jugadoractual);
		actualizarIntercambiar(jugadoractual);
		actualizarFianza(jugadoractual);
	}

	private void actualizarFianza(Jugador jugadoractual) {
		// TODO Auto-generated method stub
		this.botonPagarFianza.setDisable(this.algopoly.obtenerPosicion(jugadoractual) != 5);

        this.actualizarBotones();


	}


	public void actualizarBotones(){

	    Jugador jugadorActual = this.algopoly.obtenerJugadorActual();
        actualizarVenderTerreno(jugadorActual);
        actualizarConstruirCasa(jugadorActual);
        actualizarConstruirHotel(jugadorActual);
        actualizarIntercambiar(jugadorActual);
    }

	public void setTerminarturno(boolean valor) {
		// TODO Auto-generated method stub
		this.botonTerminarTurno.setDisable(valor);
	}

	public void actualizarIntercambiar(Jugador jugador) {
		// TODO Auto-generated method stub
		this.botonIntercambiarTerreno.setDisable(jugador.getCantidadPropiedad() == 0);
	}



    public void actualizarConstruirHotel(Jugador jugador) {
		Tablero tablero = Tablero.getInstance();
        EstadoCasillero casillero = tablero.obtenerCasillero(jugador).getestado();
        if(casillero instanceof Propiedad) {
             this.botonConstruirHotel.setDisable(jugador.puedeconstruirhotel((Propiedad) casillero));
             return;
        }
        this.botonConstruirHotel.setDisable(true);
	}

	public void actualizarConstruirCasa(Jugador jugador) {
        Tablero tablero = Tablero.getInstance();
        EstadoCasillero casillero = tablero.obtenerCasillero(jugador).getestado();
        if(casillero instanceof Propiedad) {
            this.botonConstruirCasa.setDisable(jugador.puedeconstruircasas((Propiedad) casillero));
            return;
        }
        this.botonConstruirCasa.setDisable(true);
	}

	public void actualizarVenderTerreno(Jugador jugador) {
		// TODO Auto-generated method stub
		this.botonVenderTerreno.setDisable(jugador.getCantidadPropiedad() == 0);
	}

	public void agregaraccion(String accion) {
		// TODO Auto-generated method stub
		this.accionesjugador = this.accionesjugador + accion;
		this.text5.setText(accionesjugador);
	}
	
	public void actualizarposicion(Jugador jugadoractual) {
		Tablero tablero = Tablero.getInstance();
		this.posicionjugador.setText(tablero.obtenerCasillero(jugadoractual).getNombre() + "\n");
		this.dinerojugador.setText(jugadoractual.getDinero() + "\n");
	}

	public void actualizardinero() {
		// TODO Auto-generated method stub
		Jugador jugadoractual = this.algopoly.obtenerJugadorActual();
		this.dinerojugador.setText("$" +jugadoractual.getDinero() + "\n");
	}


	public void actualizarCapa(Jugador actual) {
		// TODO Auto-generated method stub
		this.hash.get(actual).actualizar();
	}
    

	public void getChoice(ChoiceBox<String> propiedadesJugador){
	    String propiedadAVender = propiedadesJugador.getValue();
    }

	public void escondercapa(Jugador anterior) {
		// TODO Auto-generated method stub
		this.hash.get(anterior).ocultar();
	}

	public void mostrarcapa(Jugador actual) {
		// TODO Auto-generated method stub
		this.hash.get(actual).mostrar();
	}
}