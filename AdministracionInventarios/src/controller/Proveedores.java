package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.connection.Connect;
import templates.ProveedorTemp;

public class Proveedores {
	
	private Connect conn;
	
	public Proveedores()
	{
		this.conn = new Connect();
	}
	
	public ProveedorTemp[] getProveedores(int id)
	{
		String queryGetNumProveedores = "SELECT COUNT(*) AS total_proveedores FROM proveedores";
		String queryGetProveedores = "SELECT * FROM proveedores";
		
		if(id != 0)
		{
			queryGetProveedores += " WHERE id = ?";
		}
		
		try
		{
			ProveedorTemp[] proveedores;
			int totalProveedores = 0;
			PreparedStatement stmtGetNumProveedores = this.conn.getConnection().prepareStatement(queryGetNumProveedores);
			ResultSet rsGetNumProveedores = stmtGetNumProveedores.executeQuery();
			while(rsGetNumProveedores.next())
			{
				totalProveedores = rsGetNumProveedores.getInt("total_proveedores");
			}
			
			PreparedStatement stmtGetProveedores = this.conn.getConnection().prepareStatement(queryGetProveedores);
			if(id != 0)
			{
				stmtGetProveedores.setInt(1, id);
			}
			
			ResultSet rsGetProveedores = stmtGetProveedores.executeQuery();
			
			int n = 0;
			proveedores = new ProveedorTemp[totalProveedores];
			while(rsGetProveedores.next())
			{
				ProveedorTemp  prov = new ProveedorTemp(rsGetProveedores.getInt("id"), rsGetProveedores.getString("nombre"));
				proveedores[n] = prov;
				++n;
				prov = null;
			}
			
			return proveedores;
			
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			return null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
	public int setProveedor(ProveedorTemp prov)
	{
		String queryCheckIfProveedorExists = "SELECT COUNT(*) as proveedor FROM proveedores WHERE LOWER(nombre) = LOWER(?)";
		String querySetProveedor = "INSERT INTO proveedores(nombre) VALUES (?)";
		
		String nombre = prov.getNombre();
		
		try
		{
			PreparedStatement stmtCheckIfProveedorExists = this.conn.getConnection().prepareStatement(queryCheckIfProveedorExists);
			stmtCheckIfProveedorExists.setString(1, nombre);
			ResultSet rsCheckIfProveedorExists = stmtCheckIfProveedorExists.executeQuery();
			
			while(rsCheckIfProveedorExists.next())
			{
				if(rsCheckIfProveedorExists.getInt("proveedor") > 0)
				{
					return 0;
				}
			}
			
			PreparedStatement stmtSetProveedor = this.conn.getConnection().prepareStatement(querySetProveedor);
			stmtSetProveedor.setString(1, nombre);
			int result = stmtSetProveedor.executeUpdate();
			
			if(result == 1)
			{
				return 1;
			}
			else
			{
				return 2;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return 3;
		}
	}
	

}
