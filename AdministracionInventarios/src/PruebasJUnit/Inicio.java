package PruebasJUnit;

public class Inicio {
	
	
	public boolean InicioSesion(boolean usuario, boolean contrasena) {
		
	if(usuario == true || contrasena == true){			
		return true;
		
	}
	if(usuario == false || contrasena == false) {
		return false;
		
	}
	
	if(usuario == false || contrasena == true) {
		
		return false;
		
	}
	
	else
	{
		return false;
		
	}
	
  }
}

	
	


