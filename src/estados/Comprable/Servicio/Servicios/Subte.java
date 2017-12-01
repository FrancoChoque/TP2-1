package estados.Comprable.Servicio.Servicios;


import estados.Comprable.Servicio.Servicio;
import modelo.Tablero;

public class Subte extends Servicio {

    public int getPrecioCompra(){
        return 40000;
    }


    public int getCostoPase(int valorDados){

        Tablero tablero = Tablero.getInstance();

        if(this.getDuenio() == tablero.getTren().getDuenio()){
            return valorDados * 1100;
        }

        return valorDados*600;
    }

    public String getNombre(){
        return "Subte";
    }
}
