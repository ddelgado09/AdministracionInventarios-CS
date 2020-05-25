package controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.connection.Connect;
import templates.UsuarioTemp;

public class Usuarios {
	
	private Connect conn;

	public Usuarios()
	{
		this.conn = new Connect();
	}
	
	public UsuarioTemp[] getUsuarios(int id)
	{
		String queryGetCountUsuarios = "SELECT COUNT(*) AS total_usuarios FROM usuarios";
		String queryGetUsuarios = "SELECT u.*, r.nombre AS nombre_rol FROM usuarios u INNER JOIN roles r ON u.rol = r.nombre";
		UsuarioTemp[] result;
		
		if(id != 0)
		{
			queryGetUsuarios += " WHERE id = ?";
		}
		
		try
		{
			PreparedStatement stmtGetCountUsuarios = this.conn.getConnection().prepareStatement(queryGetCountUsuarios);
			PreparedStatement stmtGetUsuarios = this.conn.getConnection().prepareStatement(queryGetUsuarios);
			
			if(id != 0)
			{
				stmtGetUsuarios.setInt(1, id);
			}
			
			ResultSet rsGetCountUsuarios = stmtGetCountUsuarios.executeQuery();
			
			int totalUsuarios = 0;
			while(rsGetCountUsuarios.next())
			{
				totalUsuarios = rsGetCountUsuarios.getInt("total_usuarios");
			}
			ResultSet rsGetUsuarios = stmtGetUsuarios.executeQuery();
			int n = 0;
			result = new UsuarioTemp[totalUsuarios];
			while(rsGetUsuarios.next())
			{
				int idUsuario = rsGetUsuarios.getInt("id");
				String nombreUsuario = rsGetUsuarios.getString("nombres") + rsGetUsuarios.getString("apellidos");
				Date fechaNacimientoUsuario = rsGetUsuarios.getDate("fechaNacimiento");
				String nickUsuario = rsGetUsuarios.getString("nick");
				String direccionUsuario = rsGetUsuarios.getString("direccion");
				int telefonoUsuario = rsGetUsuarios.getInt("telefono");
				String emailUsuario = rsGetUsuarios.getString("email");
				String rolUsuario = rsGetUsuarios.getString("nombre_rol");
				result[n] = new UsuarioTemp(idUsuario, nombreUsuario, fechaNacimientoUsuario, nickUsuario, 
						direccionUsuario, telefonoUsuario, emailUsuario, rolUsuario);
				n++;
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
