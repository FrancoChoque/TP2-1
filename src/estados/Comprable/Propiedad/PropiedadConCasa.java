package estados.Comprable.Propiedad;

import excepciones.*;
import javafx.scene.canvas.GraphicsContext;
import modelo.Casa;
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



    public void construir(Jugador unJugador, Casa casa) throws DineroInsuficiente {
        if(!unJugador.puedePagar(propiedad.getValorCasa())) throw new DineroInsuficiente();
        propiedad.setPropiedadEstado(propiedad.getPropiedadConDosCasas());
    }

    public void construir(Jugador unJugador, Hotel hotel) throws DineroInsuficiente {

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
