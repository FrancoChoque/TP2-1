package controlador;

import controlador.excepciones.NombreInvalidoException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.AlgoPoly;




public class Login {

    private GridPane grid;
	private TextField player1TextField;
	private TextField player2TextField;


    public void login()  {

        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setTitle("Registro");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Ingrese el nombre de los jugadores");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(scenetitle, 0, 0, 4, 1);

        Button iniciarBoton = new Button();
        Button cerrarBoton = new Button();


        iniciarBoton.setText("Iniciar");
        BotonConfirmarNombresHandler confirmarnombres = new BotonConfirmarNombresHandler(this,stage);
        iniciarBoton.setOnAction(confirmarnombres);
        
        
        
        
        
        
        cerrarBoton.setText("Salir");

        //Labels

        Label jugador1 = new Label("Jugador 1");
        grid.add(jugador1, 0, 1);
        Label jugador2 = new Label("Jugador 2");
        grid.add(jugador2, 0, 2);


        //Input

        player1TextField = new TextField();
        player1TextField.setPromptText("Jugador Uno");
        grid.add(player1TextField, 1, 1);

        player2TextField = new TextField();
        player2TextField.setPromptText("Jugador Dos");
        grid.add(player2TextField, 1, 2);

        grid.add(iniciarBoton, 2,6);
        grid.add(cerrarBoton, 0,6);
        /*
        iniciarBoton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                VentanaJuego ventana = new VentanaJuego();
                App app = App.getInstance();
                if(player1TextField.getText().trim().length() ==0 || player2TextField.getText().trim().length() ==0){
                    System.out.println("ERROR CAMPOS VACIOS");
                }
                stage.close();
                ventana.initialize(app.getPrimaryStage(),app.getAlgoPoly(),player1TextField.getText(),player2TextField.getText());
            }
        });
        */

        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);

        stage.showAndWait();

    }


	public void confirmarnombres() throws NombreInvalidoException {
		// TODO Auto-generated method stub
		String nombre1 = player1TextField.getText().trim();
		String nombre2 = player2TextField.getText().trim();
		//String nombre3 = nombrejugador3.getText().trim();
		
		if( (nombre1.length() == 0) ||
			(nombre2.length() == 0)   ) throw new NombreInvalidoException();
		
	}


	public String getNombrejugador1() {
		// TODO Auto-generated method stub
		return this.player1TextField.getText();
	}


	public String getNombrejugador2() {
		// TODO Auto-generated method stub
		return this.player2TextField.getText();
	}




}
