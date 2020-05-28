package PruebasJUnit;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class InicioTest {
	
	Inicio valor;

	@Test
	public void test() {
		System.out.println("Inicio sesionr");
		Inicio valor = new Inicio();
		boolean dato = valor.InicioSesion(true, false);
		Assert.assertNotEquals(dato, false);
		
		
	}

}
