import java.util.HashMap;

public class Tablero {

	static final int CANTIDAD_CASILLAS = 20;
	static final int MAYOR_POSICION_TABLERO = 19;

    private HashMap <Jugador,Integer> posicionJugadores;

    private Casillero[] Casilleros;

    public Tablero(){
        posicionJugadores = new HashMap<Jugador,Integer>();
        
        
        Casilleros = new Casillero[CANTIDAD_CASILLAS]; //Cambie el hashmap por un array
        for(int i= 0; i<CANTIDAD_CASILLAS; i++) {
        	Casilleros[i] = new Casillero();
        }
        
        cargarCasilleros();

    }


    public void agregarJugador(Jugador unJugador){

        posicionJugadores.put(unJugador, 0);

    }

    public Casillero obtenerCasillero(Jugador unJugador){

        return Casilleros[ posicionJugadores.get(unJugador) ];

    }

    public int obtenerPosicion(Jugador unJugador){

        return posicionJugadores.get(unJugador);
        
    }


    public void moverJugador(Jugador unJugador, int unDesplazamiento){
    	int pos = posicionJugadores.get(unJugador);
    	unJugador.comenzarAmoverse();
    	Casillero casilla = Casilleros[pos];
    	if(unJugador.puedeMoverse() ) {
    		unJugador.setValorQueseTieneQueMover(unDesplazamiento);
    		while(unJugador.getTieneQueMoverse()){
    			int posicionNueva = unJugador.getValorQueseTieneQueMover() + this.posicionJugadores.get(unJugador);
    			if(posicionNueva > MAYOR_POSICION_TABLERO){
    				posicionNueva = posicionNueva % CANTIDAD_CASILLAS;
    			}
    			posicionJugadores.put(unJugador, posicionNueva);
    		    unJugador.seMovio();
    		    casilla = Casilleros[posicionNueva];
    		    casilla.hacerEfectoDelCasillero(unJugador);
    		}
        }else{
        	casilla.hacerEfectoDelCasillero(unJugador);
        }   
    }

    private void cargarCasilleros(){

        Salida salida = new Salida();
        Casilleros[0].setEstado(salida);
        
        Quini6 quini6 = new Quini6();
        Casilleros[1].setEstado(quini6);
        
        BuenosAiresSur buenosAiresSur = new BuenosAiresSur();
        Casilleros[2].setEstado(buenosAiresSur);
        
        Edesur edesur = new Edesur();
        Casilleros[3].setEstado(edesur);
        
        BuenosAiresNorte buenosAiresNorte = new BuenosAiresNorte();
        Casilleros[4].setEstado(buenosAiresNorte);
        
        Carcel carcel = new Carcel(this);
        Casilleros[5].setEstado(carcel);
        
        CordobaSur cordobaSur = new CordobaSur();
        Casilleros[6].setEstado(cordobaSur);
        
        AvanceDinamico avance = new AvanceDinamico();
        Casilleros[7].setEstado(avance);
        
        Subte subte = new Subte();
        Casilleros[8].setEstado(subte);
        
        CordobaNorte cordobaNorte = new CordobaNorte();
        Casilleros[9].setEstado(cordobaNorte);
        
        ImpuestoAlLujo impuesto = new ImpuestoAlLujo();
        Casilleros[10].setEstado(impuesto);
        
        SantaFe santafe = new SantaFe();
        Casilleros[11].setEstado(santafe);
        
        Aysa aysa = new Aysa();
        Casilleros[12].setEstado(aysa);
        
        SaltaNorte saltaNorte = new SaltaNorte();
        Casilleros[13].setEstado(saltaNorte);
        
        SaltaSur saltaSur = new SaltaSur();
        Casilleros[14].setEstado(saltaSur);
        
        Policia policia = new Policia(this);
        Casilleros[15].setEstado(policia);
        
        Tren tren = new Tren();
        Casilleros[16].setEstado(tren);
        
        Neuquen neuquen = new Neuquen();
        Casilleros[17].setEstado(neuquen);
        
        RetrocesoDinamico retroceso = new RetrocesoDinamico();
        Casilleros[18].setEstado(retroceso);
        
        Tucuman tucuman = new Tucuman();
        Casilleros[19].setEstado(tucuman);


    }


	public int preguntarTurnosEnCalabozo(Jugador unjugador) {
		Carcel unacarcel = (Carcel) Casilleros[5].getestado();
		return unacarcel.preguntarTurnosEnCalabozo(unjugador);
		
	}



}
