package vista.eventos.mensajescasillero;

import controlador.AlertBox;
import estados.*;
import estados.Comprable.Propiedad.Propiedad;
import estados.Comprable.Servicio.Servicios.Aysa;
import estados.Comprable.Servicio.Servicios.Edesur;
import estados.Comprable.Servicio.Servicios.Subte;
import estados.Comprable.Servicio.Servicios.Tren;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import modelo.Jugador.Jugador;

public class Mensaje {

    AudioClip audioClip;
    Image imagen;
    AlertBox box;



    public void mensajeEfecto(Jugador jugador, EstadoCasillero estadoCasillero) {

        estadoCasillero.mensajeEfecto(jugador);

    }


    public void mensajeEfecto(Jugador jugador, Salida salida) {

        return;
    }

    public void mensajeEfecto(Jugador jugador, Quini6 quini6) {

        AlertBox box = new AlertBox();

        imagen = new Image("file:src/imagenes/Casilleros/quini6.png");

        box.mensajeEfecto(jugador,quini6,audioClip,imagen);


    }

    public void mensajeEfecto(Jugador jugador, Carcel carcel) {

        AlertBox box = new AlertBox();

        audioClip = new AudioClip("file:src/Sonido/carcel.mp3");

        audioClip.play();

        imagen = new Image("file:src/imagenes/Casilleros/carcel.png");

        box.mensajeEfecto(jugador,carcel,audioClip,imagen);


    }

    public void mensajeEfecto(Jugador jugador, Propiedad propiedad) {

        AlertBox box = new AlertBox();

        imagen = new Image("file:src/imagenes/Casilleros/argentina.png");

        box.mensajeEfecto(jugador,propiedad,audioClip,imagen);

        return;
    }

    public void mensajeEfecto(Jugador jugador, Aysa aysa) {

        AlertBox box = new AlertBox();

        imagen = new Image("file:src/imagenes/Casilleros/aysa.png");


        box.mensajeEfecto(jugador,aysa,audioClip,imagen);

        return;
    }

    public void mensajeEfecto(Jugador jugador, Edesur edesur) {

        AlertBox box = new AlertBox();

        imagen = new Image("file:src/imagenes/Casilleros/edesur.png");

        box.mensajeEfecto(jugador,edesur,audioClip,imagen);

        return;
    }

    public void mensajeEfecto(Jugador jugador, Tren tren) {

        AlertBox box = new AlertBox();

        imagen = new Image("file:src/imagenes/Casilleros/tren.png");

        box.mensajeEfecto(jugador,tren,audioClip,imagen);

        return;

    }

    public void mensajeEfecto(Jugador jugador, Subte subte) {

        AlertBox box = new AlertBox();

        imagen = new Image("file:src/imagenes/Casilleros/subte.png");

        box.mensajeEfecto(jugador,subte,audioClip,imagen);

        return;

    }

    public void mensajeEfecto(Jugador jugador, ImpuestoAlLujo impuestoAlLujo) {

        AlertBox box = new AlertBox();

        Image imagen = new Image("file:src/imagenes/Casilleros/afip.png");

        box.mensajeEfecto(jugador,impuestoAlLujo,audioClip,imagen);

        return;

    }

    public void mensajeEfecto(Jugador jugador, Policia policia) {

        AlertBox box = new AlertBox();

        imagen = new Image("file:src/imagenes/Casilleros/policia.png");

        audioClip = new AudioClip("file:src/Sonido/police.mp3");

        audioClip.play();

        box.mensajeEfecto(jugador,policia,audioClip,imagen);

        return;

    }

    public void mensajeEfecto(Jugador jugador, AvanceDinamico avanceDinamico) {

        AlertBox box = new AlertBox();

        Image imagen = new Image("file:src/imagenes/Casilleros/afip.png");

        box.mensajeEfecto(jugador,avanceDinamico,audioClip,imagen);

        return;
    }

    public void mensajeEfecto(Jugador jugador, RetrocesoDinamico retrocesoDinamico) {

        AlertBox box = new AlertBox();

        Image imagen = new Image("file:src/imagenes/Casilleros/afip.png");

        box.mensajeEfecto(jugador,retrocesoDinamico,audioClip,imagen);


    }

}
