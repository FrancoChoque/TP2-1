package estados.Comprable.Servicio.Servicios;
import estados.Comprable.Servicio.Servicio;
import modelo.Tablero;

public class Aysa extends Servicio {



    public int getPrecioCompra(){
        return 30000;
    }


    public int getCostoPase(int valorDados){

        Tablero tablero = Tablero.getInstance();

        if(this.getDuenio() == tablero.getEdesur().getDuenio()){
            return valorDados * 500;
        }

        return valorDados*300;
    }

    public String getNombre(){
        return "Aysa";
    }



}
