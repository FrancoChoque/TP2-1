package modelo;
import java.util.Random;


public class Dado {



    private int valor;

	public int arrojar(){

        Random rand = new Random();
        
        valor = rand.nextInt(6) + 1;
        
        return  valor;

    }

	public int getValor() {
		// TODO Auto-generated method stub
		return valor;
	}

}
