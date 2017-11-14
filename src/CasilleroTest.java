import org.junit.Assert;
import org.junit.Test;

public class CasilleroTest {

	@Test
	public void test00CrearCasilleroConEstadoServicioNoesNulo() {
		Servicio unservicio = new Servicio();
		
		Casillero uncasillero = new Casillero(unservicio);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test01CrearCasilleroConEstadoEdesurNoEsNulo() {
		Edesur unestado = new Edesur();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());	
	}

	@Test
	public void test02CrearCasilleroConEstadoTrenNoEsNulo() {
		Tren unestado = new Tren();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());	
	}
	
	@Test
	public void test03CrearCasilleroConEstadoSubteNoEsNulo() {
		Subte unestado = new Subte();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());	
	}
	
	@Test
	public void test04CrearCasilleroConEstadoAysaNoEsNulo() {
		Aysa unestado = new Aysa();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());	
	}
	
	@Test
	public void test05CrearCasilleroConEstadoTerrenoNoEsNulo() {
		Terreno unestado = new Terreno();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test06CrearCasilleroConEstadoBuenosAiresSurNoEsNulo() {
		BuenosAiresSur unestado = new BuenosAiresSur();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test07CrearCasilleroConEstadoBuenosAiresNorteNoEsNulo() {
		BuenosAiresNorte unestado = new BuenosAiresNorte();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test08CrearCasilleroConEstadoCordobaSurNoEsNulo() {
		CordobaSur unestado = new CordobaSur();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test09CrearCasilleroConEstadoCordobaNorteNoEsNulo() {
		CordobaNorte unestado = new CordobaNorte();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test10CrearCasilleroConEstadoSantaFeNoEsNulo() {
		SantaFe unestado = new SantaFe();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test11CrearCasilleroConEstadoSaltaNorteNoEsNulo() {
		SaltaNorte unestado = new SaltaNorte();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test12CrearCasilleroConEstadoSaltaSurNoEsNulo() {
		SaltaSur unestado = new SaltaSur();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test13CrearCasilleroConEstadoNeuquenNoEsNulo() {
		Neuquen unestado = new Neuquen();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test14CrearCasilleroConEstadoTucumanNoEsNulo() {
		Tucuman unestado = new Tucuman();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test15CrearCasilleroConEstadoCarcelNoEsNulo() {
		Carcel unestado = new Carcel();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test16CrearCasilleroConEstadoPoliciaNoEsNulo() {
		Policia unestado = new Policia(null);
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test17CrearCasilleroConEstadoSuerteNoEsNulo() {
		Suerte unestado = new Suerte();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test18CrearCasilleroConEstadoImpuestoAlLujoNoEsNulo() {
		ImpuestoAlLujo unestado = new ImpuestoAlLujo();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test19CrearCasilleroConEstadoAvanceDinamicoNoEsNulo() {
		AvanceDinamico unestado = new AvanceDinamico();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test20CrearCasilleroConEstadoRetrocesoDinamicoNoEsNulo() {
		RetrocesoDinamico unestado = new RetrocesoDinamico();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test21CrearCasilleroConEstadoQuini6NoEsNulo() {
		Quini6 unestado = new Quini6();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
	
	@Test
	public void test22CrearCasilleroConEstadoSalidaNoEsNulo() {
		Salida unestado = new Salida();
		
		Casillero uncasillero = new Casillero(unestado);
		
		Assert.assertNotNull(uncasillero.getestado());
	}
}
