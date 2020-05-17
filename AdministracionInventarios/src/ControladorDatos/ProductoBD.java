package ControladorDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Inventario;

/*
public class ProductoBD {
	 private Connection conex ;
	    private ResultSet resultSet;
	    public ProductoBD() {
	        this.conex =  new Conexion().getConnection();
	    }

	    public ArrayList<Inventario> ConsultaTodos(int id) {
	        ArrayList<Inventario> lista = new ArrayList<>();
	        try {
	            Statement queryLogin = conex.createStatement();
	            resultSet = queryLogin.executeQuery("select id," +
	                    "nombre," +
	                    "cantidad," +	                    
	                    "precioVenta," +
	                    "fechaIngreso," +
	                    "fechaVencimiento," +
	                    "from INVENTARIO"
	                    );

	            while (resultSet.next()) {
	                lista.add(new Producto(resultSet.getString(1),
	                        resultSet.getString(2),
	                        resultSet.getString(3),
	                        resultSet.getString(4),
	                        resultSet.getString(5),
	                        resultSet.getString(6),
	                        resultSet.getString(7),
	                        resultSet.getString(8)));
	            }

	        } catch (SQLException | NullPointerException e) {

	            JOptionPane.showMessageDialog(null, e.toString());
	        }
	        return lista;
	    }
	    public void Crear(Producto pro, int id) {

	        try {
	            String queryIn="INSERT INTO PRODUCTO  VALUES ('"
	                    + pro.getId() + "' , '"
	                    + pro.getNombre() + "' , "
	                    + pro.getCantidad() + " , "
	                    + pro.getPrecioIngreso() + " , "
	                    + pro.getPrecioVenta() + " , default , '"
	                    + pro.getFechaVencimiento() + "' , NULL, "
	                    + id +" )";
	            Statement addProduct = conex.createStatement();
	            addProduct.execute(queryIn);
	            addProduct.close();
	        } catch (SQLException | NullPointerException e) {
	            JOptionPane.showMessageDialog(null, "Error insertando "+e.toString());
	        }
	    }
	    public void Modificar(Producto pro, int id) {

	        try {
	            String queryIn="UPDATE PRODUCTO SET nombre ='"
	                    + pro.getNombre() + "' , cantidad="
	                    + pro.getCantidad() + " , precioIngreso="
	                    + pro.getPrecioIngreso() + " , precioVenta="
	                    + pro.getPrecioVenta() + " , fechaIngreso='"
	                    + pro.getFechaIngreso() + "' , fechaVencimiento='"
	                    + pro.getFechaVencimiento() + "' WHERE ID ='"
	                    + pro.getId() + "' " +
	                    " AND tiendaId = "+id;
	            Statement addProduct = conex.createStatement();
	            addProduct.executeUpdate(queryIn);
	            addProduct.close();

	        } catch (SQLException | NullPointerException e) {
	            JOptionPane.showMessageDialog(null, "Error actualizando "+e.toString());
	        }
	    }
	    public void ModificarCantidad(String id,int cantidad,int tienda) {

	        try {
	            String queryIn="UPDATE PRODUCTO SET  cantidad="
	                    + cantidad + " WHERE ID ='"
	                    + id+"' " +
	                    " AND tiendaId = "+tienda;
	            Statement modProduct = conex.createStatement();
	            modProduct.executeUpdate(queryIn);
	            modProduct.close();

	        } catch (SQLException | NullPointerException e) {
	            JOptionPane.showMessageDialog(null, "Error actualizando "+e.toString());
	        }
	    }
	    public void Eliminar(String id, int tiendaId)  {
	        try {
	            Statement GetFachada = conex.createStatement();
	            GetFachada.execute("DELETE FROM PRODUCTO WHERE id ='" + id + "' AND tiendaId ="+tiendaId);
	            GetFachada.close();
	        } catch (SQLException | NullPointerException e) {

	            JOptionPane.showMessageDialog(null, "Error eliminando " + e.toString());
	        }
	    }

}*/
