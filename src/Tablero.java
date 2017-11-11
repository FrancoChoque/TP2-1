import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;

public class Tablero {

    private static final int SALIDA = 0;
    private static final int QUINI6 = 1;
    private static final int BSASSUR= 2;
    private static final int EDESUR = 3;
    private static final int BSASNOR = 4;
    private static final int CARCEL = 5;
    private static final int CORDOBASUR = 6;
    private static final int AVANCE = 7;
    private static final int SUBTE = 8;
    private static final int CORDOBANOR = 9;
    private static final int IMPUESTO = 10;
    private static final int SANTAFE = 11;
    private static final int AYSA = 12;
    private static final int SALTANOR = 13;
    private static final int SALTASUR = 14;
    private static final int POLICIA = 15;
    private static final int TREN = 16;
    private static final int NEUQUEN = 17;
    private static final int RETROCESO = 18;
    private static final int TUCUMAN = 19;








    private HashMap <Jugador,Integer> posicionJugadores;
    private HashMap <Integer,Casillero> posicionCasilleros;


    public Tablero(){
        super();
        posicionJugadores = new HashMap<Jugador,Integer>();
        posicionCasilleros = new HashMap<Integer,Casillero>();
        cargarCasilleros();

    }


    public void agregarJugador(Jugador unJugador){

        posicionJugadores.put(unJugador, SALIDA);


    }

    public Casillero obtenerCasillero(Jugador unJugador){

        return posicionCasilleros.get(posicionJugadores.get(unJugador));

    }

    public int obtenerPosicion(Jugador unJugador){

        return posicionJugadores.get(unJugador);

    }




    public void moverJugador(Jugador unJugador, int unDesplazamiento){


        posicionJugadores.put(unJugador, posicionJugadores.get(unJugador)+  unDesplazamiento);

    }

    private void cargarCasilleros(){

        Salida salida = new Salida();
        Quini6 quini6 = new Quini6();
        Terreno buenosAiresSur = new Terreno();
        Edesur edesur = new Edesur();
        Terreno buenosAiresNorte = new Terreno();
        Carcel carcel = new Carcel();
        Terreno cordobaSur = new Terreno();
        MovimientoDinamico avance = new MovimientoDinamico();
        Subte subte = new Subte();
        Terreno cordobaNorte = new Terreno();
        Impuesto impuesto = new Impuesto();
        Terreno santafe = new Terreno();
        Aysa aysa = new Aysa();
        Terreno saltaNorte = new Terreno();
        Terreno saltaSur = new Terreno();
        Policia policia = new Policia();
        Tren tren = new Tren();
        Terreno neuquen = new Terreno();
        MovimientoDinamico retroceso = new MovimientoDinamico();
        Terreno tucuman = new Terreno();




        posicionCasilleros.put(SALIDA, salida);
        posicionCasilleros.put(QUINI6, quini6);
        posicionCasilleros.put(BSASSUR, buenosAiresSur);
        posicionCasilleros.put(EDESUR, edesur);
        posicionCasilleros.put(BSASNOR, buenosAiresNorte);
        posicionCasilleros.put(CARCEL, carcel);
        posicionCasilleros.put(CORDOBASUR, cordobaSur);
        posicionCasilleros.put(AVANCE, avance);
        posicionCasilleros.put(SUBTE, subte);
        posicionCasilleros.put(CORDOBANOR, cordobaNorte);
        posicionCasilleros.put(IMPUESTO, impuesto);
        posicionCasilleros.put(SANTAFE, santafe);
        posicionCasilleros.put(AYSA, aysa);
        posicionCasilleros.put(SALTANOR, saltaNorte);
        posicionCasilleros.put(SALTASUR, saltaSur);
        posicionCasilleros.put(POLICIA, policia);
        posicionCasilleros.put(TREN, tren);
        posicionCasilleros.put(NEUQUEN, neuquen);
        posicionCasilleros.put(RETROCESO, retroceso);
        posicionCasilleros.put(TUCUMAN, tucuman);



    }



}
