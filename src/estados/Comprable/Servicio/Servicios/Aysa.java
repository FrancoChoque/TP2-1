package estados.Comprable.Servicio.Servicios;
import estados.Comprable.Cobrar;
import estados.Comprable.Comprable;
import estados.Comprable.Servicio.Servicio;
import modelo.Jugador.Jugador;
import modelo.Tablero;

public class Aysa extends Servicio {



    public int getPrecioCompra(){
        return 30000;
    }


    public int getCostoPase(int valorDados){

        Tablero tablero = Tablero.getInstance();

        if(this.preguntarDuenio() == tablero.getEdesur().preguntarDuenio()){
            return valorDados * 500;
        }

        return valorDados*300;
    }




}
