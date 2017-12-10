package controlador;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import estados.Comprable.Propiedad.Propiedad;
import estados.EstadoCasillero;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.effect.*;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import modelo.AlgoPoly;
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
	
	private AlgoPoly algopoly;

	private Text text5;
	private Button botonArrojarDados;
	private Button botonVenderTerreno;
	private Button botonIntercambiarTerreno;
	private Button botonConstruirCasa;
	private Button botonConstruirHotel;
	private Button botonTerminarTurno;
	private Button botonPagarFianza;
	private HashMap<Jugador, JugadorCapa> hash;

	
	
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
        Scene scene = new Scene(root, 1600, 900);
        mainApp.setecenaPrincipal(scene);
        
        // Agrego imagen del tablero
        Image unaimagen = new Image("file:src/imagenes/tablero.jpg");
        ImageView univ = new ImageView();
        univ.setImage(unaimagen);
        univ.setPreserveRatio(true);
        univ.setFitWidth(800);
        
       
        
        //Creo la pila de capas de jugadores
        StackPane stackcapas = new StackPane();
        
        // Creo los canvas para cada jugador, los agrego al hashmap
        Image iconojugador1 = new Image("file:src/imagenes/galera.jpg");
        Color colorjugador1 = Color.CYAN;
        
        Image iconojugador2 = new Image("file:src/imagenes/carretilla.jpg");
        Color colorjugador2 = Color.PINK;
        
        Image iconojugador3 = new Image("file:src/imagenes/auto.png");
        Color colorjugador3 = Color.SPRINGGREEN;
        
        Canvas canvasjugador1 = new Canvas(800, 800);
        GraphicsContext gcjugador1 = canvasjugador1.getGraphicsContext2D();
        JugadorCapa capajugador1 = new JugadorCapa(gcjugador1, jugador1, colorjugador1, iconojugador1);
        stackcapas.getChildren().add(canvasjugador1);
        hash.put(jugador1, capajugador1);
        
        
        Canvas canvasjugador2 = new Canvas(800, 800);
        GraphicsContext gcjugador2 = canvasjugador2.getGraphicsContext2D();
        JugadorCapa capajugador2 = new JugadorCapa(gcjugador2, jugador2, colorjugador2, iconojugador2);
        stackcapas.getChildren().add(canvasjugador2);
        hash.put(jugador2, capajugador2);
        
        Canvas canvasjugador3 = new Canvas(800, 800);
        GraphicsContext gcjugador3 = canvasjugador3.getGraphicsContext2D();
        JugadorCapa capajugador3 = new JugadorCapa(gcjugador3, jugador3, colorjugador3, iconojugador3);
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
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(10);
        
        hbox.getChildren().addAll(BotonSalir);
        
        root.setBottom(hbox);
        
        //Botonera de acciones en vertical
        VBox AccionesVBox = new VBox();
        AccionesVBox.setPadding(new Insets(10, 20, 10, 20));
        AccionesVBox.setSpacing(5);
        
        botonArrojarDados = new Button();
        Image imagenBoton = new Image("file:src/imagenes/dice.png");
        botonArrojarDados.setGraphic(new ImageView(imagenBoton));
        botonArrojarDados.setMinWidth(160);
        //botonArrojarDados.setMinWidth(Double.MAX_VALUE);
        EventHandler<ActionEvent> BotonArrojarDadosHandler = new BotonArrojarDadosHandler(this.algopoly ,hash, this,botonArrojarDados);
        botonArrojarDados.setOnAction(BotonArrojarDadosHandler);
        
        
        botonPagarFianza = new Button();
        //botonPagarFianza.setText("Pagar Fianza");
        Image imagenPagarFianza = new Image("file:src/imagenes/BotonPagarFianza.png");
        botonPagarFianza.setGraphic(new ImageView(imagenPagarFianza));
        botonPagarFianza.setMinWidth(160);
        //botonPagarFianza.setMinWidth(Double.MAX_VALUE);
        EventHandler<ActionEvent> BotonPagarFianzaHandler = new BotonPagarFianzaHandler();
        botonPagarFianza.setOnAction(BotonPagarFianzaHandler);
        
        
        botonVenderTerreno = new Button();
        //botonVenderTerreno.setText("Vender Terreno");
        Image imagenBotonVenderTerreno = new Image("file:src/imagenes/BotonVender.png");
        botonVenderTerreno.setGraphic(new ImageView(imagenBotonVenderTerreno));
        botonVenderTerreno.setMinWidth(160);
        //botonVenderTerreno.setMinWidth(Double.MAX_VALUE);
        EventHandler<ActionEvent> BotonVenderTerrenoHandler = new BotonVenderTerrenoHandler();
        botonVenderTerreno.setOnAction(BotonVenderTerrenoHandler);
        
        botonIntercambiarTerreno = new Button();
        //botonIntercambiarTerreno.setText("Intercambiar terreno");
        Image imagenBotonIntercambiar = new Image("file:src/imagenes/BotonIntercambio.png");
        botonIntercambiarTerreno.setGraphic(new ImageView(imagenBotonIntercambiar));
        botonIntercambiarTerreno.setMinWidth(160);
        //botonIntercambiarTerreno.setMinWidth(Double.MAX_VALUE);
        EventHandler<ActionEvent> BotonIntercambiarTerrenoHandler = new BotonIntercambiarTerrenoHandler();
        botonIntercambiarTerreno.setOnAction(BotonIntercambiarTerrenoHandler);

        botonConstruirCasa = new Button();
        //botonConstruirCasa.setText("Construir casa");
        Image imagenBotonConstruirCasa = new Image("file:src/imagenes/ConstuirCasa.png");
        botonConstruirCasa.setFont(Font.font("Helvetica", FontWeight.NORMAL, 16));
        botonConstruirCasa.setText("Constuir Casa");
        botonConstruirCasa.setContentDisplay(ContentDisplay.TOP);
        botonConstruirCasa.setGraphic(new ImageView(imagenBotonConstruirCasa));
        botonConstruirCasa.setMinWidth(160);
        //botonConstruirCasa.setMinWidth(Double.MAX_VALUE);
        EventHandler<ActionEvent> BotonConstruirCasaHandler = new BotonConstruirCasaHandler(this);
        botonConstruirCasa.setOnAction(BotonConstruirCasaHandler);

        botonConstruirHotel = new Button();
        Image imagenBotonConstruirHotel = new Image("file:src/imagenes/hotel2.png");
        botonConstruirHotel.setFont(Font.font("Helvetica", FontWeight.NORMAL, 16));
        botonConstruirHotel.setText("Construir hotel");
        botonConstruirHotel.setContentDisplay(ContentDisplay.TOP);
        botonConstruirHotel.setGraphic(new ImageView(imagenBotonConstruirHotel));
        botonConstruirHotel.setMinWidth(160);
        //botonConstruirHotel.setMinWidth(Double.MAX_VALUE);
        EventHandler<ActionEvent> BotonConstruirHotelHandler = new BotonConstruirHotelHandler();
        botonConstruirHotel.setOnAction(BotonConstruirHotelHandler);
        
        
        botonTerminarTurno = new Button();        
        //botonTerminarTurno.setText("Terminar turno");
        Image imagenBotonTerminar = new Image("file:src/imagenes/BotonTerminarTurno.png");
        botonTerminarTurno.setGraphic(new ImageView(imagenBotonTerminar));
        botonTerminarTurno.setMinWidth(160);
        //botonTerminarTurno.setMinWidth(Double.MAX_VALUE);
        EventHandler<ActionEvent> BotonTerminarTurnoHandler = new BotonTerminarTurnoHandler(this, juego);
        botonTerminarTurno.setOnAction(BotonTerminarTurnoHandler);
        
        
        AccionesVBox.getChildren().addAll(botonTerminarTurno,botonArrojarDados,
        		botonVenderTerreno, botonConstruirCasa,
        		botonConstruirHotel, botonPagarFianza,botonIntercambiarTerreno);
        
        root.setLeft(AccionesVBox);
        
        
        //Agrego Textflow a la derecha
        
        StackPane stackderecho = new StackPane();
        Image imagenFondoInformacion = new Image("file:src/imagenes/fondoLetras.png");
        
        
        //stackderecho.getChildren().addAll(helpIcon);
       /*       
        Text untexto = new Text();
        untexto.setText("Turno actual\n");
        
        Text textoestado = new Text();
        untexto.setText("Yolo: " + "swag" + "\n" + "blaze it 420");
        
        TextFlow textflow = new TextFlow(untexto,textoestado);
        textflow.setMaxHeight(600);
        textflow.setBackground(new Background(new BackgroundFill(valor, CornerRadii.EMPTY, Insets.EMPTY)));
        */
        
        Text textoInformacion = new Text("INFORMACION DEL JUGADOR\n");
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
         
        Text t = new Text();
        textoInformacion.setEffect(ds);
        textoInformacion.setCache(true);
        textoInformacion.setX(10.0f);
        textoInformacion.setY(270.0f);
        textoInformacion.setFill(Color.RED);
        textoInformacion.setFont(Font.font(null, FontWeight.BOLD, 25));
        
        
        Text textoturnojugador = new Text("Turno Actual: ");
        textoturnojugador.setFont(Font.font("Helvetica", FontWeight.NORMAL, 18));
        Text textodinerojugador = new Text("Dinero disponible: ");
        textodinerojugador.setFont(Font.font("Helvetica", FontWeight.NORMAL, 18));
        Text textoposicionjugador = new Text();
        textoposicionjugador.setText("Posicion del jugador: ");
        textoposicionjugador.setFont(Font.font("Helvetica", FontWeight.NORMAL, 18));
        Text textoaccionesjugador = new Text();
        textoaccionesjugador.setText("Acciones realizadas en el turno:\n");
        textoaccionesjugador.setFont(Font.font("Helvetica", FontWeight.NORMAL, 18));
        this.text5 = new Text();
        this.text5.setText(accionesjugador);
        
        
        TextFlow textFlowAcciones = new TextFlow(textoaccionesjugador,text5);
        textFlowAcciones.setLineSpacing(6);
        textFlowAcciones.setTextAlignment(TextAlignment.CENTER);
        
        
        TextFlow textFlow = new TextFlow(textoInformacion,textoturnojugador,this.nombrejugador, textodinerojugador,this.dinerojugador, textoposicionjugador,this.posicionjugador,
        		textFlowAcciones);
		textFlow.setLineSpacing(100);
		textFlow.setTextAlignment(TextAlignment.CENTER);
		textFlow.setStyle("-fx-background-color: transparent");
		
        //agrego margen a los textos
        ObservableList<Node> textos = textFlow.getChildren();
        Iterator<Node> iter = textos.iterator();
        while(iter.hasNext()) {
        	Node textoactual = iter.next();
        	textoactual.setTranslateX(7);
        	textoactual.setTranslateY(7);
        }
        
        
        textFlow.setMaxHeight(800);
        textFlow.setMinWidth(500);
        //textFlow.setLineSpacing(7);
        
        //agrego bordeado
        
        Canvas canvasderecho = new Canvas(600,800);
        GraphicsContext gcder = canvasderecho.getGraphicsContext2D();
        gcder.setFill(Color.WHEAT);
        gcder.fillRect(0, 0, 600, 800);
        gcder.setFill(Color.BLACK);
        gcder.setLineWidth(5);
        gcder.strokeLine(0, 0, 600, 0);
        gcder.strokeLine(600, 0, 600, 800);
        gcder.strokeLine(0, 0, 0, 800);
        gcder.strokeLine(0, 800, 600, 800);
        
        
        stackderecho.getChildren().addAll(new ImageView(imagenFondoInformacion),textFlow,canvasderecho);
        canvasderecho.toBack();
        root.setRight(stackderecho);

        //Agrego referencia a jugadores arriba
        
        Canvas referencias = new Canvas(1000, 100);
        GraphicsContext refgc = referencias.getGraphicsContext2D();
        refgc.drawImage(iconojugador1, 50, 25, 50, 50);
        refgc.fillText("Jugador 1\n" + nombreJugador1, 110, 35);
        refgc.setFill(colorjugador1);
        refgc.fillRect(110, 60,	75, 15);
        
        
        refgc.setFill(Color.BLACK);
        refgc.drawImage(iconojugador2, 300, 25, 50, 50);
        refgc.fillText("Jugador 2\n" + nombreJugador2, 360, 35);
        refgc.setFill(colorjugador2);
        refgc.fillRect(360, 60, 75, 15);
        
        refgc.setFill(Color.BLACK);
        refgc.drawImage(iconojugador3, 550, 25, 50, 50);
        refgc.fillText("Jugador 3\n" + nombrejugador3, 610, 35);
        refgc.setFill(colorjugador3);
        refgc.fillRect(610, 60, 75, 15);
        
        HBox topbox = new HBox();
        topbox.getChildren().add(referencias);
        topbox.setAlignment(Pos.CENTER);
        
        root.setTop(topbox);

        primaryStage.setTitle("AlgoPoly");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        this.actualizarturno();
    }
	
	public void actualizarturno() {
		Jugador jugadoractual = this.algopoly.obtenerJugadorActual();
		this.nombrejugador.setText(jugadoractual.getNombre() + "\n");
		this.nombrejugador.setFont(Font.font("Helvetica", FontWeight.NORMAL, 24));
		this.nombrejugador.setFill(hash.get(jugadoractual).getColor());
		
		this.dinerojugador.setText("$"+ jugadoractual.getDinero() + "\n" );
		this.dinerojugador.setFont(Font.font("Helvetica", FontWeight.NORMAL, 18));
		
		Tablero tablero = Tablero.getInstance();
        this.posicionjugador.setText(tablero.obtenerCasillero(jugadoractual).getNombre() + "\n");
		this.posicionjugador.setFont(Font.font("Helvetica", FontWeight.NORMAL, 18));
        
		this.accionesjugador = "";
		this.text5.setText(accionesjugador);
		this.text5.setFont(Font.font("Helvetica", FontWeight.NORMAL, 18));
		jugadoractual.setEstado(jugadoractual.getJugadorEmpezandoTurno() );



		this.botonArrojarDados.setDisable(false);
		setTerminarturno(true);
		this.botonPagarFianza.setDisable(true);

        if(!jugadoractual.puedeMoverse()){
            algopoly.getTablero().getCarcel().hacerEfectoDelCasillero(jugadoractual);
            actualizarPagarFianza(jugadoractual);
        }

        actualizarBotones();

    }

    public void actualizarPagarFianza(Jugador unJugador){
	    this.botonPagarFianza.setDisable(!algopoly.getTablero().getCarcel().puedePagarFianza(unJugador));
    }

    public void actualizarBotones(){

        Jugador jugadorActual = this.algopoly.obtenerJugadorActual();
        if(jugadorActual.getEstadoDeJugador() == jugadorActual.getJugadorTiroDados() || !jugadorActual.puedeMoverse()){
            botonArrojarDados.setDisable(true);
            this.setTerminarturno(false);
        }
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

	public void escondercapa(Jugador anterior) {
		// TODO Auto-generated method stub
		this.hash.get(anterior).ocultar();
	}

	public void mostrarcapa(Jugador actual) {
		// TODO Auto-generated method stub
		this.hash.get(actual).mostrar();
	}

	public void actualizarTodasCapas() {
		// TODO Auto-generated method stub
		Collection<JugadorCapa> collection = this.hash.values();
		Iterator<JugadorCapa> iter = collection.iterator();
		
		while(iter.hasNext()) {
			JugadorCapa capa = iter.next();
			capa.actualizar();
		}
		
	}

	public void quitarcapa(Jugador actual) {
		// TODO Auto-generated method stub
		this.hash.remove(actual);
	}
}