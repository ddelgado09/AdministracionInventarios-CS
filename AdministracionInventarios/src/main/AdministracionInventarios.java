package main;

import controller.Sesion;
import views.login.*;
import views.menu.Menu;

public class AdministracionInventarios {
	
	public static void main(String args[])
	{
//		new Login();
//		Sesion inicioSesion = new Sesion("ddelgado09", "diego1234.0");
//		inicioSesion.checkUser();
		new Menu(inicioSesion);
	}
}
