import java.util.LinkedList;

public class Jugador {

	static final int DINERO_INICIAL = 100000;
    private String nombre = "NONAME";
    private int dinero;

	private LinkedList<Comprable> propiedades;
	private boolean movimientoPosible; 
    
	private int valorQueseTieneQueMover;
    private boolean tieneQueMoverse;
    private int numeroPropiedades;
	
	public Jugador(String unNombre){

    	
        this.nombre = unNombre;

        this.dinero = DINERO_INICIAL;        
        propiedades = new LinkedList<Comprable>();
        
        movimientoPosible = true;
        
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

	public void comprar(Terreno unterreno) {
		if(! unterreno.tieneDuenio() ) {
			propiedades.add(unterreno);
			unterreno.cambiarDuenio(this);
			unterreno.pagarCompra(this) ;
		}
		
	}






	public boolean puedeMoverse() {
		// TODO Auto-generated method stub
		return movimientoPosible;
	}





	public void cambiarMovimiento() {
		// TODO Auto-generated method stub
		movimientoPosible = movimientoPosible ? false : true ;
	}



	public boolean puedePagar(int monto) {
		// TODO Auto-generated method stub
		return dinero >= monto;
	}
	
	public void setValorQueseTieneQueMover(int valor){
    	this.valorQueseTieneQueMover = valor;
    }
    
    public int getValorQueseTieneQueMover(){
    
    	return this.valorQueseTieneQueMover;
    }
    
    public void comenzarAmoverse(){
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
