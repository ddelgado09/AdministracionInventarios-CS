package views.login;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

import controller.Sesion;
import views.menu.Menu;

public class Login implements ActionListener {
	
	JFrame f;
	JTextField txtUsuario;
	JPasswordField txtContrasena;
	JButton btnInicioSesion;
	JLabel lUsuario;
	JLabel lContrasena;
	JLabel lMensaje;
	
	public Login()
	{		
		lUsuario = new JLabel("Usuario");
		lUsuario.setBounds(90, 70, 100, 30);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(90, 100, 200, 30);
		
		lContrasena = new JLabel("Contraseña");
		lContrasena.setBounds(90, 150, 100, 30);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(90, 180, 200, 30);
		
		btnInicioSesion = new JButton("Iniciar Sesión");
		btnInicioSesion.setBounds(110, 280, 150, 40);
		btnInicioSesion.addActionListener(this);
		
		lMensaje = new JLabel();
		lMensaje.setBounds(90, 320, 250, 20);
		
		f = new JFrame();
		f.add(lUsuario);
		f.add(lContrasena);
		f.add(txtUsuario);
		f.add(txtContrasena);
		f.add(btnInicioSesion);
		f.add(lMensaje);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		lMensaje.setText("");
		try {
			String usuario = txtUsuario.getText();
			String contrasena = new String(txtContrasena.getPassword());
			
			Sesion inicioSesion = new Sesion(usuario, contrasena);
			boolean check = inicioSesion.checkUser();
			
			if(!check)
			{
				lMensaje.setText("Usuario o contraseña incorrectos");
			}
			else
			{
				new Menu();
//				lMensaje.setText("Exito");
				
			}
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
}
