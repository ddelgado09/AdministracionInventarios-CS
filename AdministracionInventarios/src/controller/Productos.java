package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.connection.Connect;
import templates.ProductoTemp;

public class Productos {

	private Connect conn;
	
	public Productos()
	{
		this.conn = new Connect();
	}
	
	public ProductoTemp[] getProductos(int id)
	{
		String queryCount = "SELECT COUNT(*) AS total_productos FROM productos";
		
		String query = "SELECT p.*, pr.nombre as nombre_proveedor FROM productos p "
				+ "INNER JOIN proveedores pr ON pr.id = p.proveedor";
		
		try
		{
			PreparedStatement stmtCount = this.conn.getConnection().prepareStatement(queryCount);
			PreparedStatement stmt = this.conn.getConnection().prepareStatement(query);
			
			if(id != 0)
			{
				queryCount += " WHERE id = ?";
				query += " WHERE id = ?";
				stmtCount.setInt(1, id);
				stmt.setInt(1, id);
			}
			
			ResultSet rsCount = stmtCount.executeQuery();
			rsCount.next();
			int totalProductos = rsCount.getInt("total_productos");
			
			ResultSet rs = stmt.executeQuery();
			ProductoTemp[] result = new ProductoTemp[totalProductos];
			
			int n = 0;
			while(rs.next())
			{
				ProductoTemp prod = new ProductoTemp(
						rs.getInt("id"), rs.getString("nombre"), rs.getInt("cantidad"), 
						rs.getFloat("valor_unitario"), rs.getString("nombre_proveedor"));
				result[n] = prod;
				++n;
			}
			
			return result;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
			return null;
		}
	}
}
