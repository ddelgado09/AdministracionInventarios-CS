package templates;

/**
 * @author Diego Delgado
 *
 */
public class ProductoTemp {

	private int id;
	private String nombre;
	private int cantidad;
	private double valorUnitario;
	private String proveedor;
	
	public ProductoTemp()
	{
		
	}
	
	public ProductoTemp(String nombre, int cantidad, double valorUnitario, String proveedor)
	{
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
		this.proveedor = proveedor;
	}
	
	public ProductoTemp(int id, String nombre, int cantidad, float valorUnitario, String proveedor)
	{
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
		this.proveedor = proveedor;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	
	
}
