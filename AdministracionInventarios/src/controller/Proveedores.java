package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.connection.Connect;

public class Proveedores {
	
	private Connect conn;
	
	public Proveedores()
	{
		this.conn = new Connect();
	}
	
	public ArrayList<String> getProveedores(int id)
	{
		String queryGetProveedores = "SELECT * FROM proveedores";
		ArrayList<String> proveedores = new ArrayList<String>();
		
		if(id != 0)
		{
			queryGetProveedores += " WHERE id = ?";
		}
		
		try
		{
			PreparedStatement stmtGetProveedores = this.conn.getConnection().prepareStatement(queryGetProveedores);
			if(id != 0)
			{
				stmtGetProveedores.setInt(1, id);
			}
			
			ResultSet rsGetProveedores = stmtGetProveedores.executeQuery();
			while(rsGetProveedores.next())
			{
				proveedores.add(rsGetProveedores.getString("nombre"));
			}
			
			return proveedores;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	

}
