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

public class Menu implements ActionListener {
	
	private JFrame f;
	private JLabel nombreSesion;
	private JLabel fechaSesion;
	private JButton btnCrear;
	private JButton btnModificar;
	private JButton btnVer;
	private JButton btnEliminar;
	private JButton btnSalir;
	
	public Menu(Sesion sesion)
	{
		nombreSesion = new JLabel("Bienvenido(a): " + sesion.getNombres() + " - " + sesion.getRol());
		nombreSesion.setBounds(15, 0, 400, 30);
		
		fechaSesion = new JLabel("Último inicio de sesión: " + sesion.getFechaConexion());
		fechaSesion.setBounds(15, 20, 300, 30);
		
		btnCrear = new JButton("Agregar producto");
		btnCrear.setBounds(80, 80, 200, 100);
		btnCrear.addActionListener(this);
		
		btnModificar = new JButton("Modificar datos producto");
		btnModificar.setBounds(490, 80, 200, 100);
		btnModificar.addActionListener(this);
		
		btnVer = new JButton("Ver los productos");
		btnVer.setBounds(80, 290, 200, 100);
		btnVer.addActionListener(this);
		
		btnEliminar = new JButton("Eliminar producto del registro");
		btnEliminar.setBounds(490, 290, 200, 100);
		btnEliminar.addActionListener(this);
		
		btnSalir = new JButton("Cerrar sesión");
		btnSalir.setBounds(620, 20, 120, 20);
		btnSalir.addActionListener(this);
		
		f = new JFrame("Menú Principal - Supermercados Chaotic");
		f.add(nombreSesion);
		f.add(fechaSesion);
		f.add(btnCrear);
		f.add(btnModificar);
		f.add(btnVer);
		f.add(btnEliminar);
		f.add(btnSalir);
		f.setSize(800, 500);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();
		System.out.println(action);
		
		switch(action)
		{
			case "Agregar producto":
				new AgregarProducto();
			break;
			
			case "Modificar datos producto":
				new ModificarProducto();
			break;
			
			case "Ver los productos":
				new VerProducto();
			break;
			
			case "Eliminar producto del registro":
				new EliminarProducto();
			break;
			
			case "Cerrar sesión":
				new Login();
			break;
		}
		
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	}
	
}
