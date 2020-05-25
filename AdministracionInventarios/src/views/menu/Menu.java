package views.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

import controller.Sesion;
import views.login.Login;
import views.producto.AgregarProducto;
import views.producto.EliminarProducto;
import views.producto.ModificarProducto;
import views.producto.VerProducto;
import views.proveedor.VerProveedor;
import views.usuario.VerUsuario;

public class Menu implements ActionListener {
	
	public Sesion sesion;
	
	private JFrame f;
	private JLabel nombreSesion;
	private JLabel fechaSesion;
	private JButton btnVerProductos;
	private JButton btnVerProveedores;
	private JButton btnSalir;
	
	public Menu(Sesion sesion)
	{
		this.sesion = sesion;
		
		nombreSesion = new JLabel("Bienvenido(a): " + sesion.getNombres() + " - " + sesion.getRol());
		nombreSesion.setBounds(15, 0, 400, 30);
		
		fechaSesion = new JLabel("Último inicio de sesión: " + sesion.getFechaConexion());
		fechaSesion.setBounds(15, 20, 300, 30);
		
		btnVerProductos = new JButton("Listado Productos");
		btnVerProductos.setBounds(80, 80, 200, 30);
		btnVerProductos.addActionListener(this);
		
		btnVerProveedores = new JButton("Listado Proveedores");
		btnVerProveedores.setBounds(80, 160, 200, 30);
		btnVerProveedores.addActionListener(this);
		
		btnSalir = new JButton("Cerrar sesión");
		btnSalir.setBounds(620, 20, 120, 20);
		btnSalir.addActionListener(this);
		
		f = new JFrame("Menú Principal - Supermercados Chaotic");
		f.add(nombreSesion);
		f.add(fechaSesion);
		f.add(btnVerProductos);
		f.add(btnVerProveedores);
		f.add(btnSalir);
		f.setSize(800, 500);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();
		
		switch(action)
		{
			case "Listado Proveedores":
				new VerProveedor(this.sesion);
			break;
			
			case "Listado Productos":
				new VerProducto(this.sesion);
			break;
			
			case "Listado Usuarios":
				new VerUsuario(this.sesion);
			break;
			
			case "Cerrar sesión":
				new Login();
			break;
		}
		
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	}
	
}
