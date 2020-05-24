package views.login;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

import controller.Sesion;
import views.menu.Menu;

public class Login implements ActionListener {
	
	private JFrame f;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JButton btnInicioSesion;
	private JLabel lUsuario;
	private JLabel lContrasena;
	private JLabel lMensaje;
	
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
		
		f = new JFrame("Inicio de Sesión - Supermercados Chaotic");
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
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		lMensaje.setText("");
		try {
			String usuario = txtUsuario.getText();
			String contrasena = new String(txtContrasena.getPassword());
			
			if(usuario.equals("") || contrasena.equals(""))
			{
				txtContrasena.setText("");
				lMensaje.setText("<html><font color=red>Ingrese el usuario y la contraseña</font></html>");
				return;
			}
			
			Sesion inicioSesion = new Sesion(usuario, contrasena);
			boolean check = inicioSesion.checkUser();
			
			if(!check)
			{
				txtContrasena.setText("");
				lMensaje.setText("<html><font color=red>Usuario o contraseña incorrectos</font><html>");
			}
			else
			{
				new Menu(inicioSesion);
				f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
//				lMensaje.setText("Exito");
				
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
