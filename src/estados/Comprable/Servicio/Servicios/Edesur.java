package estados.Comprable.Servicio.Servicios;

import estados.Comprable.Servicio.Servicio;
import modelo.Tablero;

public class Edesur extends Servicio {


    public int getPrecioCompra(){
        return 35000;
    }


    public int getCostoPase(int valorDados){

        Tablero tablero = Tablero.getInstance();

        if(this.preguntarDuenio() == tablero.getAysa().preguntarDuenio()){
            return valorDados * 1000;
        }

        return valorDados*500;
    }


}
