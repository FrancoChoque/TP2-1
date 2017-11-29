package vista;

import controlador.App;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modelo.Jugador.Jugador;
import vista.eventos.BotonSalir;

public class ContenedorIntercambioElegirPropiedades extends VBox{
	private Jugador remitente;
	private Jugador destinatario;
	public ContenedorIntercambioElegirPropiedades(Jugador remitente, Jugador destinatario){
		this.remitente = remitente;
		this.destinatario = destinatario;
	}
	public void mostrar(){
		App datosVista = App.getInstance();
		if(destinatario.getCantidadPropiedad() != 0){
			Scene scene = new Scene(this, 640, 480);
			
	        
	        ComboBox<String> comboBoxremitente = new ComboBox<String>();
	        for(int i=0;i < this.remitente.getCantidadPropiedad();i++){
	        	comboBoxremitente.getItems().add("una propiedad remitente");
	        }
	        
	        ComboBox<String> comboBoxDestinatario = new ComboBox<String>();
	        for(int i=0;i < this.destinatario.getCantidadPropiedad();i++){
	        	comboBoxDestinatario.getItems().add("una propiedad destinario");
	        }
	        
	        Button cancelar = new Button();
	        cancelar.setText("Cancelar");
	        
	        BotonSalir botonCancelar = new BotonSalir();
	        cancelar.setOnAction(botonCancelar);
	        
	        
	        GridPane grid = new GridPane();
			grid.setVgap(4);
			grid.setHgap(10);
			grid.setPadding(new Insets(5, 5, 5, 5));
			grid.add(new Label("propiedad a ceder: "), 0, 0);
			grid.add(comboBoxremitente, 1, 0);
			grid.add(new Label("propiedad a recibir: "), 2, 0);
			grid.add(comboBoxDestinatario, 3, 0);           
			grid.add(cancelar, 0, 3);
			
			
	        this.getChildren().add(grid);
	        datosVista.getPrimaryStage().setScene(scene);
	        
	        
		}else{
			ContenedorMensaje contenedorMensaje = new ContenedorMensaje("El jugador seleccionado no tiene propiedades");
	        Scene escenaIntercambio = new Scene(contenedorMensaje, 640, 480);
			datosVista.getPrimaryStage().setScene(escenaIntercambio);;
		}
	}	 
}
