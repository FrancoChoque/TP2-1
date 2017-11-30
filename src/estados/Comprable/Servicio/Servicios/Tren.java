package estados.Comprable.Servicio.Servicios;


import estados.Comprable.Servicio.Servicio;
import modelo.Tablero;

public class Tren extends Servicio {

    public int getPrecioCompra(){
        return 38000;
    }


    public int getCostoPase(int valorDados){

        Tablero tablero = Tablero.getInstance();

        if(this.getDuenio() == tablero.getSubte().getDuenio()){
            return valorDados * 800;
        }

        return valorDados*450;
    }

    public String getNombre(){
        return "Tren";
    }
}
