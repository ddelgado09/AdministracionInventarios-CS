package views.usuario;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.*;

import controller.Sesion;
import controller.Usuarios;
import templates.UsuarioTemp;
import utils.ButtonEditor;
import utils.ButtonRenderer;
import views.menu.Menu;

public class VerUsuario extends JFrame implements ActionListener {
	
	public Sesion sesion;
	private Usuarios usu;
	
	private String[] columns;
	private String[][] data;
	
	private JFrame f;
	private JTable tUsuarios;
	private JScrollPane sp;
	private JButton bAgregar;
	private JButton bVolver;
	private JPanel panel;
	
	public VerUsuario(Sesion sesion)
	{
		this.sesion = sesion;
		
		this.usu = new Usuarios();
		this.getUsuarios(0);
		this.tUsuarios = new JTable(this.data, this.columns);
		
		this.tUsuarios.getColumn("Editar").setCellRenderer(new ButtonRenderer());
		this.tUsuarios.getColumn("Editar").setCellEditor(
					new ButtonEditor(new JCheckBox())
				);
		
		this.tUsuarios.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
		this.tUsuarios.getColumn("Eliminar").setCellEditor(
					new ButtonEditor(new JCheckBox())
				);
		
		this.sp = new JScrollPane(this.tUsuarios);
		this.sp.setBounds(0, 0, 800, 300);
		
		this.bAgregar = new JButton("Agregar Usuario");
		this.bAgregar.setBounds(30,  400, 200, 30);
		this.bAgregar.addActionListener(this);
		
		this.bVolver = new JButton("Volver");
		this.bVolver.setBounds(300, 400, 200, 30);
		this.bVolver.addActionListener(this);
		
		panel.setLayout(new BorderLayout());
		
		f = new JFrame("Listado Usuarios - Almacenes Chaotic");
		f.add(bAgregar);
		f.add(bVolver);
		f.setLayout(null);
		f.add(sp);
		f.pack();
		f.setSize(800, 500);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();
		
		switch(action)
		{
			case "Agregar Usuario":
				new AgregarUsuario(this.sesion);
			break;
			
			case "Volver":
				new Menu(this.sesion);
			break;
		}
		
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	}
	
	private void getUsuarios(int id)
	{
		UsuarioTemp[] listadoUsuarios = this.usu.getUsuarios(id);
		
		if(listadoUsuarios != null)
		{
			int numUsuarios = listadoUsuarios.length;
			
			if(numUsuarios == 0)
			{
				this.columns = new String[1];
				this.columns[0] = "Sin Datos";
				
				this.data = new String[1][1];
				this.data[0][0] = "No hay datos almacenados";
			}
			else
			{
				this.columns = new String[10];
				
				this.columns[0] = "Id";
				this.columns[1] = "Nombre Completo";
				this.columns[2] = "Fecha de Nacimiento";
				this.columns[3] = "Nick";
				this.columns[4] = "Dirección";
				this.columns[5] = "Teléfono";
				this.columns[6] = "Email";
				this.columns[7] = "Rol";
				this.columns[8] = "Editar";
				this.columns[9] = "Eliminar";
				
				this.data = new String[numUsuarios][10];
				for(int n = 0; n < numUsuarios; ++n)
				{
					this.data[n][0] = Integer.toString(listadoUsuarios[n].getId());
					this.data[n][1] = listadoUsuarios[n].getNombre();
					this.data[n][2] = listadoUsuarios[n].getFechaNacimiento().toString();
					this.data[n][3] = listadoUsuarios[n].getNick();
					this.data[n][4] = listadoUsuarios[n].getDireccion();
					this.data[n][5] = Integer.toString(listadoUsuarios[n].getTelefono());
					this.data[n][6] = listadoUsuarios[n].getEmail();
					this.data[n][7] = listadoUsuarios[n].getRol();
					this.data[n][8] = "Editar";
					this.data[n][9] = "Eliminar";
					
				}
			}
		}
		else
		{
			this.columns = new String[1];
			this.columns[0] = "Error";
			
			this.data = new String[1][1];
			this.data[0][0] = "Hubo un error al listar los datos";
		}
	}

}
