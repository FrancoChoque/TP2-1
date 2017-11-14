public class Jugador {


    private String nombre = "NONAME";
    private int dinero;
    private int valorQueseTieneQueMover;
    private boolean tieneQueMoverse;
    private int numeroPropiedades;
    
    public Jugador(String unNombre){
    	
        this.nombre = unNombre;

        this.dinero = 100000;
        this.valorQueseTieneQueMover = 0;
        this.tieneQueMoverse = false;
        this.numeroPropiedades = 0;
       
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
    
    public void setDinero(int unMonto){
    	this.dinero = unMonto;
    }
    
    public void sumarDinero(int unMonto){
    	this.dinero += unMonto;
    }
    
    public void setValorQueseTieneQueMover(int valor){
    	this.valorQueseTieneQueMover = valor;
    }
    
    public int getValorQueseTieneQueMover(){
    
    	return this.valorQueseTieneQueMover;
    }
    
    public void comenzarTurno(){
    	this.tieneQueMoverse = true;
    }
    
    public void continuarMoviendose(){
    	this.tieneQueMoverse = true;
    }
    
    public boolean getTieneQueMoverse(){
    	return this.tieneQueMoverse;
    }
    
    public void seMovio(){
    	this.tieneQueMoverse = false;
    }
    
    public int getNumeroPropiedades() {
		return numeroPropiedades;
	}

	public void setNumeroPropiedades(int numPropiedades) {
		this.numeroPropiedades = numPropiedades;
	}
	
	public void aumentarNumeroDePropiedades(int unAumento){
		this.numeroPropiedades += unAumento;
	}
}
