package estados.Comprable.Propiedad;

import excepciones.*;
import javafx.scene.canvas.GraphicsContext;
import modelo.Casa;
import modelo.Edificio;
import modelo.Hotel;
import modelo.Jugador.Jugador;
import vista.JugadorCapa;
import vista.Posicion;

public class PropiedadConCasa implements PropiedadEstado {

    private Propiedad propiedad;

    public PropiedadConCasa(Propiedad unaPropiedad){
        propiedad = unaPropiedad;
    }

    public int getCostoPase() {
        return propiedad.getCostoAlquilerConCasa();
    }

    @Override
    public void construir() {
        propiedad.setPropiedadEstado(propiedad.getPropiedadConDosCasas());
    }


    @Override
    public void puedeConstruir(Jugador unJugador, Casa casa) throws JugadorNoPoseeTodosLosBarrios, NoPuedeConstruirMasCasas {
        propiedad.puedeEdificar(unJugador, casa);
    }

    @Override
    public void puedeConstruir(Jugador unJugador, Hotel hotel) throws JugadorNoPoseeTodosLosBarrios, CasasInsuficientes, NoPuedeConstruirMasHoteles {
        throw new CasasInsuficientes();
    }

    @Override
	public void dibujarEdificios(GraphicsContext gc, Posicion pos) {
		// TODO Auto-generated method stub
		gc.drawImage(JugadorCapa.getIconoCasa(), pos.getx() + JugadorCapa.getdesfaseX1(),
				pos.gety() + JugadorCapa.getdesfaseY(), JugadorCapa.getlargoedificio(), JugadorCapa.getalturaedificio());
	}

}
