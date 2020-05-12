package model;

public class Inventario {
	
	private String id;
	private String nombre;
	private String cantidad;
	private String precioIngreso;
	private String precioVenta;
	private String fechaIngreso;
	private String fechaVencimiento;
	

	public Inventario() {
	}

	public Inventario(String id, String nombre, String cantidad, String precioVenta, String fechaIngreso, String fechaVencimiento) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;		
		this.precioVenta = precioVenta;
		this.fechaIngreso = fechaIngreso;
		this.fechaVencimiento = fechaVencimiento;
		
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getPrecioIngreso() {
		return precioIngreso;
	}

	public void setPrecioIngreso(String precioIngreso) {
		this.precioIngreso = precioIngreso;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	

}
