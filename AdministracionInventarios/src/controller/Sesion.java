package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import model.connection.*;

public class Sesion {

	private String usuario;
	private String contrasena;
	private Connect conn;
	
	public Sesion(String usuario, String contrasena)
	{
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.conn = new Connect();
	}
	
	public boolean checkUser()
	{
		String query = "SELECT * FROM usuarios WHERE nick = ?";
		int id = 0;
		String nombres = null;
		String nick = null;
		String contrasena = null;
		String hashText = null;	
		
		try
		{
			PreparedStatement stmt = this.conn.getConnection().prepareStatement(query);
			stmt.setString(1, this.usuario);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				id = rs.getInt("id");
				nombres = rs.getString("nombre") + " " + rs.getString("apellido");
				nick = rs.getString("nick");
				byte[] decodedBytes = Base64.getDecoder().decode(rs.getString("contrasena"));
				contrasena = new String(decodedBytes);
			}
			
			if(contrasena.equals(this.contrasena))
			{
				return true;	
			}
			else
			{
				return false;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
}
