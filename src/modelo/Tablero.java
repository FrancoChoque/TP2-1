package modelo;




import java.util.HashMap;

import estados.*;
import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import estados.Comprable.Servicio.Servicios.Aysa;
import estados.Comprable.Servicio.Servicios.Edesur;
import estados.Comprable.Servicio.Servicios.Subte;
import estados.Comprable.Servicio.Servicios.Tren;
import estados.Comprable.Propiedad.Barrios.*;
import modelo.Jugador.Jugador;

public class Tablero {

    // Atributos y Metodos de clase

    static final int CANTIDAD_CASILLAS = 20;
    static final int MAYOR_POSICION_TABLERO = 19;

    static Tablero instance = new Tablero();

    static public Tablero getInstance() {
        return instance;
    }

    static public Tablero resetInstance() {
        instance.resetearTablero();
        return instance;
    }


    // Atributos y Metodos de instancia

    private HashMap<Jugador, Integer> posicionJugadores;
    private HashMap<Comprable, Integer> posicionComprables;

    private Casillero[] Casilleros;


    private Tablero() {
        posicionJugadores = new HashMap<Jugador, Integer>();
        this.posicionComprables = new HashMap<Comprable, Integer>();

        Casilleros = new Casillero[CANTIDAD_CASILLAS]; //Cambie el hashmap por un array
        for (int i = 0; i < CANTIDAD_CASILLAS; i++) {
            Casilleros[i] = new Casillero();
        }

        cargarCasilleros();

    }


    public void agregarJugador(Jugador unJugador) {

        posicionJugadores.put(unJugador, 0);

    }

    public Casillero obtenerCasillero(Jugador unJugador) {

        return Casilleros[posicionJugadores.get(unJugador)];

    }

    public int obtenerPosicion(Jugador unJugador) {

        return posicionJugadores.get(unJugador);

    }


    public void moverJugador(Jugador unJugador, int unDesplazamiento) {

        if (unJugador.puedeMoverse()) {
            int posicionNueva = unDesplazamiento + this.posicionJugadores.get(unJugador);
            if (posicionNueva > MAYOR_POSICION_TABLERO) {
                posicionNueva = posicionNueva % CANTIDAD_CASILLAS;
            }
            posicionJugadores.put(unJugador, posicionNueva);

        }



    }

    private void cargarCasilleros() {

        Salida salida = new Salida();
        Casilleros[0].setEstadoCasillero(salida);

        Quini6 quini6 = new Quini6();
        Casilleros[1].setEstadoCasillero(quini6);

        BuenosAiresSur buenosAiresSur = new BuenosAiresSur();
        Casilleros[2].setEstadoCasillero(buenosAiresSur);
        this.posicionComprables.put(buenosAiresSur, 2);

        Edesur edesur = new Edesur();
        Casilleros[3].setEstadoCasillero(edesur);
        this.posicionComprables.put(edesur, 3);

        BuenosAiresNorte buenosAiresNorte = new BuenosAiresNorte();
        Casilleros[4].setEstadoCasillero(buenosAiresNorte);
        this.posicionComprables.put(buenosAiresNorte, 4);
        
        Carcel carcel = new Carcel();
        Casilleros[5].setEstadoCasillero(carcel);

        CordobaSur cordobaSur = new CordobaSur();
        Casilleros[6].setEstadoCasillero(cordobaSur);
        this.posicionComprables.put(cordobaSur, 6);

        AvanceDinamico avance = new AvanceDinamico();
        Casilleros[7].setEstadoCasillero(avance);

        Subte subte = new Subte();
        Casilleros[8].setEstadoCasillero(subte);
        this.posicionComprables.put(subte,8);

        CordobaNorte cordobaNorte = new CordobaNorte();
        Casilleros[9].setEstadoCasillero(cordobaNorte);
        this.posicionComprables.put(cordobaNorte,9);

        ImpuestoAlLujo impuesto = new ImpuestoAlLujo();
        Casilleros[10].setEstadoCasillero(impuesto);

        SantaFe santafe = new SantaFe();
        Casilleros[11].setEstadoCasillero(santafe);
        this.posicionComprables.put(santafe, 11);

        Aysa aysa = new Aysa();
        Casilleros[12].setEstadoCasillero(aysa);
        this.posicionComprables.put(aysa,12);

        SaltaNorte saltaNorte = new SaltaNorte();
        Casilleros[13].setEstadoCasillero(saltaNorte);
        this.posicionComprables.put(saltaNorte,13);

        SaltaSur saltaSur = new SaltaSur();
        Casilleros[14].setEstadoCasillero(saltaSur);
        this.posicionComprables.put(saltaSur,14);

        Policia policia = new Policia(this);
        Casilleros[15].setEstadoCasillero(policia);

        Tren tren = new Tren();
        Casilleros[16].setEstadoCasillero(tren);
        this.posicionComprables.put(tren,16);

        Neuquen neuquen = new Neuquen();
        Casilleros[17].setEstadoCasillero(neuquen);
        this.posicionComprables.put(neuquen,17);

        RetrocesoDinamico retroceso = new RetrocesoDinamico();
        Casilleros[18].setEstadoCasillero(retroceso);

        Tucuman tucuman = new Tucuman();
        Casilleros[19].setEstadoCasillero(tucuman);
        this.posicionComprables.put(tucuman, 19);

        

    }

    //Metodo para borrar los duenios y edificios de los edificios comprables
    //Solo usar para crear tableros limpios para las pruebas.
    public void resetearTablero() {
        Casillero unacasilla;
        for (int i = 0; i < CANTIDAD_CASILLAS; i++) {
            unacasilla = Casilleros[i];
            EstadoCasillero unestado = unacasilla.getestado();
            if (!(unestado instanceof Comprable)) continue;
            ((Comprable) unestado).setEstado(((Comprable) unestado).getNoTieneDuenio());

            if (!(unestado instanceof Propiedad)) continue;
            ((Propiedad) unestado).vaciarEdificios();

        }
    }


    public int preguntarTurnosEnCalabozo(Jugador unjugador) {
        Carcel unacarcel = (Carcel) Casilleros[5].getestado();
        return unacarcel.preguntarTurnosEnCalabozo(unjugador);

    }


    public BuenosAiresSur getBuenosAiresSur() {
        return (BuenosAiresSur) Casilleros[2].getestado();
    }

    public Edesur getEdesur() {
        return (Edesur) Casilleros[3].getestado();
    }

    public BuenosAiresNorte getBuenosAiresNorte() {
        return (BuenosAiresNorte) Casilleros[4].getestado();
    }

    public Carcel getCarcel() {
        return (Carcel) Casilleros[5].getestado();
    }

    public CordobaSur getCordobaSur() {
        return (CordobaSur) Casilleros[6].getestado();
    }

    public Subte getSubte() {
        return (Subte) Casilleros[8].getestado();
    }

    public CordobaNorte getCordobaNorte() {
        return (CordobaNorte) Casilleros[9].getestado();
    }

    public SantaFe getSantaFe() {
        return (SantaFe) Casilleros[11].getestado();
    }

    public Aysa getAysa() {
        return (Aysa) Casilleros[12].getestado();
    }

    public SaltaNorte getSaltaNorte() {
        return (SaltaNorte) Casilleros[13].getestado();
    }

    public SaltaSur getSaltaSur() {
        return (SaltaSur) Casilleros[14].getestado();
    }

    public Tren getTren() {
        return (Tren) Casilleros[16].getestado();
    }

    public Neuquen getNeuquen() { return (Neuquen) Casilleros[17].getestado();}

    public Tucuman getTucuman() { return (Tucuman) Casilleros[19].getestado();}

	public HashMap<Comprable, Integer> obtenerComprables() {
		// TODO Auto-generated method stub
		return this.posicionComprables;
	}

}



