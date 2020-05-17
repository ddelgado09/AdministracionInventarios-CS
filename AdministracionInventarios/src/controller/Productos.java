package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.connection.Connect;
import templates.ProductoTemp;
/**
 * 
 * @author Diego Delgado
 * @version 1.0.0
 *
 */
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
	
	public int setProducto(ProductoTemp prod)
	{
		String queryGetProveedorId = "SELECT id FROM proveedores WHERE nombre = ?";
		String queryCheckProducto = "SELECT COUNT(*) AS total_productos FROM productos WHERE LOWER(nombre) = LOWER(?)";
		String queryInsertProveedor = "INSERT INTO proveedores(nombre) VALUES (?)";
		String queryInsertProducto = "INSERT INTO productos(nombre, nombre_venta, "
				+ "cantidad, valor_unitario, proveedor) VALUES (?, ?, ?, ?, ?)";
		
		try
		{
			String nombre = prod.getNombre();
			int cantidad = prod.getCantidad();
			Double valorUnitario = prod.getValorUnitario();
			String proveedor = prod.getProveedor();
			int proveedorId = 0;
			
			PreparedStatement stmtProd = this.conn.getConnection().prepareStatement(queryCheckProducto);
			stmtProd.setString(1, nombre);
			
			ResultSet rsProd = stmtProd.executeQuery();
			rsProd.next();
			if(rsProd.getInt("total_productos") > 0 )
			{
				return 3;
			}
			
			PreparedStatement stmtGetProveedorId = this.conn.getConnection().prepareStatement(queryGetProveedorId);
			stmtGetProveedorId.setString(1, proveedor);
			
			ResultSet rsGetProveedorId = stmtGetProveedorId.executeQuery();
			while(rsGetProveedorId.next())
			{
				proveedorId = rsGetProveedorId.getInt("id");
			}
			
			
			stmtProd = this.conn.getConnection().prepareStatement(queryInsertProducto);
			stmtProd.setString(1, nombre);
			stmtProd.setString(2, nombre);
			stmtProd.setInt(3, cantidad);
			stmtProd.setDouble(4, valorUnitario);
			stmtProd.setInt(5, proveedorId);
			
			int result = stmtProd.executeUpdate();
			if(result != 0)
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
			return 2;
		}
	}
}
