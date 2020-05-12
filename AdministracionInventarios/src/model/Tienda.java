package model;

import java.util.ArrayList;

public class Tienda {
	
	 private int id;
	 private String nombre;
	 private String ciudad;
	 private String direccion;
	 private String telefono;
	 private ArrayList<Inventario> lstInventarios = new ArrayList<Inventario>();
	 private ArrayList<Tienda> lstTienda = new ArrayList<Tienda>();
	 
	 public ArrayList<Tienda> getLstTienda() {
			return lstTienda;
		}

		public void setLstTienda(ArrayList<Tienda> lstTienda) {
			this.lstTienda = lstTienda;
		}	    

	   
		public Tienda(int id, String nombre, String ciudad, String direccion, String telefono) {
	        this.id = id;
	        this.nombre = nombre;
	        this.ciudad = ciudad;
	        this.direccion = direccion;
	        this.telefono = telefono;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public Tienda() {

	    }
	    
	    public Tienda buscarTienda(Tienda tienda, int id) {
	        for (int i = 0; i < getLstTienda().size(); i++) {
	            if (getLstTienda().get(i).getId()==(id)) {
	                tienda = (Tienda) getLstTienda().get(i);
	            }
	        }
	        return tienda;
	    }

	    public Inventario buscarInventario(Inventario inventario, String id) {
	        for (int i = 0; i < getLstInventarios().size(); i++) {
	            if (getLstInventarios().get(i).getId().equals(id)) {
	                inventario = (Inventario) getLstInventarios().get(i);
	            }
	        }
	        return inventario;
	    }

	 

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getCiudad() {
	        return ciudad;
	    }

	    public void setCiudad(String ciudad) {
	        this.ciudad = ciudad;
	    }

	    public String getDireccion() {
	        return direccion;
	    }

	    public ArrayList<Inventario> getLstInventarios() {
			return lstInventarios;
		}

		public void setLstInventarios(ArrayList<Inventario> lstInventarios) {
			this.lstInventarios = lstInventarios;
		}

		public void setDireccion(String direccion) {
	        this.direccion = direccion;
	    }

	    public String getTelefono() {
	        return telefono;
	    }

	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }

	    

	   
}
