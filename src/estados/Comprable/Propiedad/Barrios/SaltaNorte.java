package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Propiedad.Propiedad;
import modelo.Jugador.Jugador;

public class SaltaNorte extends Propiedad {

	public int getPrecioCompra(){ return 23000; }

	public int getValorCasa(){ return 4500; }

	public int getValorHotel(){ return 7500; }

	public int getCostoAlquiler(){ return 2000; }

	public int getCostoAlquilerConCasa(){ return 3250;}

	public int getCostoAlquilerConDosCasas(){ return 3850;}

	public int getCostoAlquilerConHotel(){ return 5500;}
}
