package model.connection;

import org.postgresql.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Connect {

	String url = "jdbc:postgresql://localhost/administracion_inventarios";
	private static final String USER = "postgres";
	private static final String PASSWORD = "12345";
	private Properties props;
	private Connection conn;
	
	public Connect()
	{
		this.props = new Properties();
		this.props.setProperty("user", USER);
		this.props.setProperty("password", PASSWORD);
		this.setConnection();
	}
	
	private void setConnection()
	{
		try
		{
			this.conn = DriverManager.getConnection(url, this.props);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		return this.conn;
	}
	
}
