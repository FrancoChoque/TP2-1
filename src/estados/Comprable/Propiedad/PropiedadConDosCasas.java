package estados.Comprable.Propiedad;

import excepciones.*;
import javafx.scene.canvas.GraphicsContext;
import modelo.Casa;
import modelo.Edificio;
import modelo.Hotel;
import modelo.Jugador.Jugador;
import vista.JugadorCapa;
import vista.Posicion;

public class PropiedadConDosCasas implements PropiedadEstado {

    private Propiedad propiedad;

    public PropiedadConDosCasas(Propiedad unaPropiedad){
        propiedad = unaPropiedad;
    }

    public int getCostoPase() {
        return propiedad.getCostoAlquilerConDosCasas();
    }

    @Override
    public void construir() {
        propiedad.setPropiedadEstado(propiedad.getPropiedadConHotel());
    }


    @Override
    public void puedeConstruir(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {
        throw new NoPuedeConstruirMasCasas();
    }

    @Override
    public void puedeConstruir(Jugador unJugador, Hotel hotel) throws JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles {
        propiedad.puedeEdificar(unJugador, hotel);
    }


    @Override
	public void dibujarEdificios(GraphicsContext gc, Posicion pos) {
		// TODO Auto-generated method stub
		gc.drawImage(JugadorCapa.getIconoCasa(), pos.getx() + JugadorCapa.getdesfaseX1(),
				pos.gety() + JugadorCapa.getdesfaseY(), JugadorCapa.getlargoedificio(), JugadorCapa.getalturaedificio());
		gc.drawImage(JugadorCapa.getIconoCasa(), pos.getx() + JugadorCapa.getdesfaseX2(),
				pos.gety() + JugadorCapa.getdesfaseY(), JugadorCapa.getlargoedificio(), JugadorCapa.getalturaedificio());
	}
}
