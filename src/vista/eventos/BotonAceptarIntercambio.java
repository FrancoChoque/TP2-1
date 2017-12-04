package vista.eventos;

import estados.Comprable.Comprable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import modelo.Jugador.Jugador;
import vista.ContenedorIntercambio;


public class BotonAceptarIntercambio implements EventHandler<ActionEvent>{
	
	private Stage stage;
	private Jugador remitente;
	private Comprable propiedadDelRemitente;
	private Jugador destinatario;
	private Comprable propiedadDelDestino;
	
	public BotonAceptarIntercambio(Stage stage, Jugador remitente, Comprable propiedadDelRemitente, Jugador destinatario,
	Comprable propiedadDelDestino){
		this.stage = stage;
    	this.remitente = remitente;
    	this.propiedadDelRemitente = propiedadDelRemitente;
        this.destinatario = destinatario;
        this.propiedadDelDestino = propiedadDelDestino;
	}
	public void handle(ActionEvent actionEvent){
		remitente.intercambiarPropiedades(destinatario,propiedadDelDestino,propiedadDelRemitente);
		System.out.println("intercambio aceptado");
		ContenedorIntercambio contenedorIntercambio = new ContenedorIntercambio();
		contenedorIntercambio.interCambioAceptado(stage);
		
	}
}
