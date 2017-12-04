package vista.eventos;

import estados.Comprable.Comprable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import modelo.Jugador.Jugador;
import vista.ContenedorIntercambio;

public class BotonSelecionarPropiedadesIntercambio implements EventHandler<ActionEvent>{

	private Stage stage;
	private Jugador remitente;
	private Comprable propiedadDelRemitente;
	private Jugador destinatario;
	private Comprable propiedadDelDestino;

    public BotonSelecionarPropiedadesIntercambio(Stage stage, Jugador remitente, Jugador destinatario) {
        this.stage = stage;
    	this.remitente = remitente;
    	this.propiedadDelRemitente = null;
        this.destinatario = destinatario;
        this.propiedadDelDestino = null;
    }
	@Override
    public void handle(ActionEvent actionEvent){
		if(this.validesDePropiedades()){
			ContenedorIntercambio contenedorIntercambio = new ContenedorIntercambio();
			contenedorIntercambio.aceptarProuesta(stage,remitente,propiedadDelRemitente,destinatario,propiedadDelDestino);
		}
	}
	private boolean validesDePropiedades() {
		if((this.propiedadDelDestino!= null) && (this.propiedadDelRemitente != null)){
			return true;
		}
		return false;
	}
	public void setPropiedadDelRemitente(Comprable comprable){
		this.propiedadDelRemitente =  comprable;
	}
	
	public void setPropiedadDelDestinatario(Comprable comprable){
		this.propiedadDelDestino = comprable;
	}
}
