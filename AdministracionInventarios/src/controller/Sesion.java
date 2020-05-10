package controller;

import java.util.ArrayList;

import model.connection.*;

public class Sesion {

	private String usuario;
	private String contrasena;
	
	public Sesion(String usuario, String contrasena)
	{
		this.usuario = usuario;
		this.contrasena = contrasena;	
	}
	
	public boolean checkUser()
	{
		String query = "SELECT * FROM usuarios WHERE nick = ?";
		String[] rows = {"nick", "contrasena"};
		String[] params = {this.usuario};
		
		Connect conn =  new Connect();
		ArrayList<String[]> result = conn.querySelect(query, rows, params);
		
		System.out.println(result);
		return true;
	}
}
