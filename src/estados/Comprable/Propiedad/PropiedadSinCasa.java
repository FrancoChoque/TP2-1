package estados.Comprable.Propiedad;

import excepciones.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import modelo.Casa;
import modelo.Hotel;
import modelo.Jugador.Jugador;
import vista.Posicion;

public class PropiedadSinCasa implements PropiedadEstado {

    private Propiedad propiedad;

    public PropiedadSinCasa(Propiedad unaPropiedad){
        propiedad = unaPropiedad;
    }


    public int getCostoPase(){
        return propiedad.getCostoAlquiler();

    }



    public void construir(Jugador unJugador, Casa casa) throws DineroInsuficiente {
        if(!unJugador.puedePagar(propiedad.getValorCasa())) throw new DineroInsuficiente();

        propiedad.setPropiedadEstado(propiedad.getPropiedadConCasa());
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
		
	}





}
