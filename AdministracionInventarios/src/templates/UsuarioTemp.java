package templates;

import java.util.Date;

public class UsuarioTemp {
	
	private int id;
	private int cedula;
	private String nombre;
	private Date fechaNacimiento;
	private String nick;
	private String direccion;
	private int telefono;
	private String email;
	private String rol;
	
	public UsuarioTemp(int id, int cedula, String nombre, Date fechaNacimiento, 
			String nick, String direccion, int telefono, String email, String rol)
	{
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.nick = nick;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.rol = rol;
	}
	
	public UsuarioTemp(int cedula, String nombre, Date fechaNacimiento, 
			String nick, String direccion, int telefono, String email, String rol)
	{
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.nick = nick;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
