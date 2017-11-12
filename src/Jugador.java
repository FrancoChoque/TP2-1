public class Jugador {


    private String nombre = "NONAME";
    private int dinero; 
    public Jugador(String unNombre){
    	
        this.nombre = unNombre;

        this.dinero = 100000;
    }



    public int arrojarDados(){

        int valordado1;
        int valordado2;

        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        valordado1 = dado1.arrojar();
        valordado2 = dado2.arrojar();

        return valordado1 + valordado2;
    }
    
    public int getDinero(){
    	return this.dinero;
    }
    
    public void sumarDinero(int unMonto){
    	this.dinero += unMonto;
    }
}
