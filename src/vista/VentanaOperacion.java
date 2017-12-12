package vista;

import static javafx.scene.text.Font.font;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import controlador.App;
import controlador.BotonConfirmarConstruirCasaHandler;
import controlador.BotonVolverHandler;
import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Jugador.Jugador;
import vista.eventos.BotonConfirmarCobrarFianzaHandler;
import vista.eventos.BotonConfirmarConstruirHotelHandler;
import vista.eventos.BotonConfirmarVenderTerrenoHandler;

public class VentanaOperacion {


	public VentanaOperacion() {
	}

	public void ventanaconstruirhotel(Propiedad prop) {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Construir hotel");

        BorderPane layout = new BorderPane();
        
        Text text1 = new Text();
        text1.setText("Desea construir un hotel\n");
        text1.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        Text text2 = new Text();
        text2.setText("en "+ prop.getNombre());
        text2.setFont(font("Helvetica", FontPosture.REGULAR, 20));

        Text text3 = new Text();
        text3.setText(" por $" + prop.getValorCasa() + "?");
        text3.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        TextFlow textos = new TextFlow();
        textos.setTextAlignment(TextAlignment.CENTER);
        textos.getChildren().addAll(text1, text2, text3);
        textos.setPadding(new Insets(10,10,10,10));
        
        layout.setTop(textos);
               
        
        HBox opciones = new HBox();
        opciones.setAlignment(Pos.TOP_CENTER);
        opciones.setSpacing(15);
        opciones.setPadding(new Insets(10,10,10,10));
        layout.setBottom(opciones);
 
        Button botonaceptar = new Button();
        botonaceptar.setText("Construir");
        botonaceptar.setMinWidth(80);
        EventHandler<ActionEvent> botonaceptarhandler = new BotonConfirmarConstruirHotelHandler(stage);
        botonaceptar.setOnAction(botonaceptarhandler);
        
        
        Button botonrechazar = new Button();
        botonrechazar.setMinWidth(80);
        botonrechazar.setText("Volver");
        EventHandler<ActionEvent> botonrechazarhandler = new BotonVolverHandler(stage);
        botonrechazar.setOnAction(botonrechazarhandler);
        
        
        
        
        opciones.getChildren().addAll(botonaceptar, botonrechazar);
        
        Scene scene = new Scene(layout, 300,170);
        stage.setScene(scene);
        stage.showAndWait();
	}

	public void venderterreno(Jugador actual) {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Vender terreno");

        BorderPane layout = new BorderPane();
        
        Text text1 = new Text();
        text1.setText("Seleccione la propiedad\n");
        text1.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        Text text2 = new Text();
        text2.setText("que desee vender");
        text2.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        TextFlow textos = new TextFlow();
        textos.setTextAlignment(TextAlignment.CENTER);
        textos.getChildren().addAll(text1, text2);
        textos.setPadding(new Insets(10,10,10,10));
        
        layout.setTop(textos);
        
		
		LinkedList<Comprable> propiedadess = actual.getpropiedades();
		Iterator<Comprable> iter = propiedadess.iterator();
		HashMap<String, Comprable> map = new HashMap<String, Comprable>();
		
		while(iter.hasNext()) {
			Comprable comprable = iter.next();
			map.put(comprable.getNombre(), comprable);			
		}
        
        
        ComboBox<String> combobox = new ComboBox<String>();
        Set<String> entradas = map.keySet();
        Iterator<String> iter2 = entradas.iterator();
        while(iter.hasNext()) {
        	String propiedadactual = iter2.next();
        	combobox.getItems().add(propiedadactual);        	
        }
        
        layout.setCenter(combobox);
        
        
        HBox opciones = new HBox();
        opciones.setAlignment(Pos.TOP_CENTER);
        opciones.setSpacing(15);
        opciones.setPadding(new Insets(10,10,10,10));
        layout.setBottom(opciones);
 
        Button botonaceptar = new Button();
        botonaceptar.setText("Vender");
        EventHandler<ActionEvent> botonaceptarhandler = new BotonConfirmarVenderTerrenoHandler(stage,combobox,map);
        botonaceptar.setOnAction(botonaceptarhandler);
        
        
        Button botonrechazar = new Button();
        botonrechazar.setText("Volver");
        EventHandler<ActionEvent> botonrechazarhandler = new BotonVolverHandler(stage);
        botonrechazar.setOnAction(botonrechazarhandler);
        
        
        
        
        opciones.getChildren().addAll(botonaceptar, botonrechazar);
        
        Scene scene = new Scene(layout, 300,170);
        stage.setScene(scene);
        stage.showAndWait();
	}


	public void cobrarfianza() {


	        Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Cobrar fianza");

            BorderPane layout = new BorderPane();

            Text text1 = new Text();
            text1.setText("La fianza cuesta $45000\n");
            text1.setFont(font("Helvetica", FontPosture.REGULAR, 20));

            Text text2 = new Text();
            text2.setText("Desea pagarla?");
            text2.setFont(font("Helvetica", FontPosture.REGULAR, 20));

            TextFlow textos = new TextFlow();
            textos.setTextAlignment(TextAlignment.CENTER);
            textos.getChildren().addAll(text1, text2);
            textos.setPadding(new Insets(10,10,10,10));

            layout.setTop(textos);



            HBox opciones = new HBox();
            opciones.setAlignment(Pos.TOP_CENTER);
            opciones.setSpacing(15);
            opciones.setPadding(new Insets(10,10,10,10));
            layout.setBottom(opciones);

            Button botonaceptar = new Button();
            botonaceptar.setText("Si");
            botonaceptar.setMinWidth(80);
            EventHandler<ActionEvent> botonaceptarhandler = new BotonConfirmarCobrarFianzaHandler(stage);
            botonaceptar.setOnAction(botonaceptarhandler);


            Button botonrechazar = new Button();
            botonrechazar.setText("No");
            botonrechazar.setMinWidth(80);
            EventHandler<ActionEvent> botonrechazarhandler = new BotonVolverHandler(stage);
            botonrechazar.setOnAction(botonrechazarhandler);


            opciones.getChildren().addAll(botonaceptar, botonrechazar);

            Scene scene = new Scene(layout, 300,170);
            stage.setScene(scene);
            stage.showAndWait();
    }


	public void ventanaconstruircasa(Jugador actual, Propiedad prop) {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Construir casa");

        BorderPane layout = new BorderPane();
        
        Text text1 = new Text();
        text1.setText("Desea construir una casa ");
        text1.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        Text text2 = new Text();
        text2.setText("en " + prop.getNombre());
        text2.setFont(font("Helvetica", FontPosture.REGULAR, 20));

        Text text3 = new Text();
        text3.setText(" por $" + prop.getValorCasa() + "?");
        text3.setFont(font("Helvetica", FontPosture.REGULAR, 20));
        
        TextFlow textos = new TextFlow();
        textos.setTextAlignment(TextAlignment.CENTER);
        textos.getChildren().addAll(text1, text2, text3);
        textos.setPadding(new Insets(10,10,10,10));
        
        layout.setTop(textos);
        
        
        
        HBox opciones = new HBox();
        opciones.setAlignment(Pos.TOP_CENTER);
        opciones.setSpacing(15);
        opciones.setPadding(new Insets(10,10,10,10));
        layout.setBottom(opciones);
 
        Button botonaceptar = new Button();
        botonaceptar.setMinWidth(80);
        botonaceptar.setText("Si");
        EventHandler<ActionEvent> botonaceptarhandler = new BotonConfirmarConstruirCasaHandler(stage);
        botonaceptar.setOnAction(botonaceptarhandler);
        
        
        Button botonrechazar = new Button();
        botonrechazar.setMinWidth(80);
        botonrechazar.setText("No");
        EventHandler<ActionEvent> botonrechazarhandler = new BotonVolverHandler(stage);
        botonrechazar.setOnAction(botonrechazarhandler);
        
        
        
        
        opciones.getChildren().addAll(botonaceptar, botonrechazar);
        
        Scene scene = new Scene(layout, 300,170);
        stage.setScene(scene);
        stage.showAndWait();
	}


	public void menuReglas() {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Reglas de Algopoly");

        BorderPane layout = new BorderPane();
        
        Text text1 = new Text();
        text1.setText("Desarrollo del juego.\n");
        text1.setFont(font("Helvetica", FontWeight.BOLD, 20));
        text1.setTextAlignment(TextAlignment.LEFT);
        
        Text text2 = new Text();
        text2.setText("Es un juego por turnos de 3 jugadores. En cada turno cada jugador debe lanzar" + 
        		" un par de dados (numeros del 1 al 6 cada dado). El numero obtenido sera la suma de ambos resultados.\n\n"+
        		"Si un jugador al tirar los dados obtiene un doble numero (o sea 1 y 1 , o 3 y 3 , etc)" + 
        		" entonces tira nuevamente. Solo puede arrojarse dados hasta dos veces por turno.\n\n"+
        		"Las propiedades solo pueden ser compradas en el turno que se cae en ellas."+ 
        		"Si no dispone de suficiente dinero, debe volver a caer en la propiedad para comprarla.\n\n");
        text2.setFont(font("Helvetica", FontPosture.REGULAR, 18));
        text2.setTextAlignment(TextAlignment.LEFT);
        
        Text text3 = new Text("Construccion de casas y hoteles.\n");
        text3.setFont(font("Helvetica", FontWeight.BOLD, 20));
        text3.setTextAlignment(TextAlignment.LEFT);
        
        Text text4 = new Text("No se puede construir edificios en el mismo turno que se compra una propiedad.\n\n" +
        		"Antes de lanzar los dados, pueden construirse edificios si se encuentra en" +
        		"condiciones de hacerlo: el jugador debe tener el barrio y el dinero para pagar el edificio\n\n"+
        		"Los casilleros Buenos Aires, Cordoba y Salta permiten construir hoteles. Para construir un hotel"+
        		"el jugador debe tener las zonas Sur y Norte con la maxima cantidad de casas o un hotel y el dinero para pagar"+
        		"el edificio. Los terrenos que no tienen zonas norte y sur no pueden construir hotel.\n\n"+
        		"Cuando se construye un hotel las dos casas desaparecen.\n\n"+
        		"Antes de lanzar los dados, el jugador puede vender sus companias y propiedades, con los edificios"+
        		"que haya construido. El jugador cobra el 85% del precio del terreno y edificios construidos, si los tuviera."+
        		"Tambien pierde la titularidad del terreno, que queda disponible para comprar por cualquier jugador.\n\n"+
        		"Cuando se construye un hotel las dos casas desaparecen.\n\n");
        text4.setFont(font("Helvetica", FontPosture.REGULAR, 18));
        text4.setTextAlignment(TextAlignment.LEFT);
        
        Text text5 = new Text("Venta de propiedades\n");
        text5.setFont(font("Helvetica", FontWeight.BOLD, 20));
        text5.setTextAlignment(TextAlignment.LEFT);
        
        Text text6 = new Text("Antes de lanzar los dados, el jugador puede vender sus companias y propiedades, con los edificios"+
        		"que haya construido. El jugador cobra el 85% del precio del terreno y edificios construidos, si los tuviera."+
        		"Tambien pierde la titularidad del terreno, que queda disponible para comprar por cualquier jugador.\n\n");
        text6.setFont(font("Helvetica", FontPosture.REGULAR, 18));
        text6.setTextAlignment(TextAlignment.LEFT);
        
        Text text7 = new Text("Fin del juego\n");
        text7.setFont(font("Helvetica", FontWeight.BLACK, 20));
        text7.setTextAlignment(TextAlignment.LEFT);
        
        Text text8 = new Text("Un jugador sin propiedades cae en un casillero que genera gasto y no tiene dinero suficiente" +
        		" para pagar el gasto, queda fuera de juego.\n\n"+
        		"Si el jugador cae en un casillero que genera gasto y no tiene dinero suficiente, pero si tiene propiedades" +
        		" esta obligado a vender una de sus propiedades para pagar el gasto.\n\n" +
        		"El juego termina cuando solo quede un jugador.\n\n");
        text8.setFont(font("Helvetica", FontPosture.REGULAR, 18));
        text8.setTextAlignment(TextAlignment.LEFT);
        
        Text text9 = new Text();
        text9.setFont(font("Helvetica", FontPosture.REGULAR, 18));
        text9.setTextAlignment(TextAlignment.LEFT);
        
        TextFlow textos = new TextFlow();
        textos.setTextAlignment(TextAlignment.LEFT);
        textos.getChildren().addAll(text1, text2, text3, text4, text5,text6,text7,text8);
        textos.setPadding(new Insets(10,10,10,10));
        textos.setMaxWidth(770); 
        
        HBox opciones = new HBox();
        opciones.setAlignment(Pos.TOP_CENTER);
        opciones.setSpacing(15);
        opciones.setPadding(new Insets(10,10,10,10));
        layout.setBottom(opciones);
      
        Button botonrechazar = new Button();
        botonrechazar.setText("Volver");
        EventHandler<ActionEvent> botonrechazarhandler = new BotonVolverHandler(stage);
        botonrechazar.setOnAction(botonrechazarhandler);
        
        opciones.getChildren().addAll(botonrechazar);
        
        ScrollPane scroll = new ScrollPane(textos);
        scroll.setFitToHeight(true);
        layout.setCenter(scroll);      
        
        Scene scene = new Scene(layout, 800,600);
        stage.setScene(scene);
        stage.showAndWait();
	}

}
