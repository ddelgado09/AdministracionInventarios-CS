package views.proveedor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import controller.Proveedores;
import controller.Sesion;
import templates.ProveedorTemp;
import utils.ButtonEditor;
import utils.ButtonRenderer;
import views.menu.Menu;

public class VerProveedor extends JFrame implements ActionListener {

	private String[] columns;
	private String[][] data;
	
	public Sesion sesion;
	private JPanel panel;
	private JLabel lTitulo;
	private JTable tProveedores;
	private JScrollPane sp;
	private JFrame f;
	private Proveedores prov;
	private JButton bAgregar;
	private JButton bVolver;
	
	
	public VerProveedor(Sesion sesion)
	{
		this.sesion = sesion;
		
		this.prov = new Proveedores();
		this.getProductos(0);
		
		panel = new JPanel();
		
		this.tProveedores = new JTable(this.data, this.columns);
		
		this.tProveedores.getColumn("Editar").setCellRenderer(new ButtonRenderer());
		this.tProveedores.getColumn("Editar").setCellEditor(
					new ButtonEditor(new JCheckBox())
				);
		
		this.tProveedores.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
		this.tProveedores.getColumn("Eliminar").setCellEditor(
					new ButtonEditor(new JCheckBox())
				);
		
		this.sp = new JScrollPane(this.tProveedores);
		this.sp.setBounds(0, 0, 600, 300);
		
		this.bAgregar = new JButton("Agregar Proveedor");
		this.bAgregar.setBounds(30, 400, 200, 30);
		this.bAgregar.addActionListener(this);
		
		this.bVolver = new JButton("Volver");
		this.bVolver.setBounds(350, 400, 200, 30);
		this.bVolver.addActionListener(this);
		
		panel.setLayout(new BorderLayout());
		
		f = new JFrame("Listado Proveedores - Almacenes Chaotic");
		f.add(bAgregar);
		f.add(bVolver);
		f.setLayout(null);
		f.add(sp);
		f.pack();
		f.setSize(600, 560);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();
		
		switch(action)
		{
			case "Agregar Proveedor":
				new AgregarProveedor(this.sesion);
			break;
			
			case "Volver":
				new Menu(this.sesion);
			break;
		}
		
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	}
	
	private void getProductos(int id)
	{
		ProveedorTemp[] listadoProveedores = this.prov.getProveedores(id);
		
		if(listadoProveedores != null)
		{
			
			int numProveedores = listadoProveedores.length;
			
			if(numProveedores == 0)
			{
				this.columns = new String[1];
				this.columns[0] = "Sin Datos";
				
				this.data = new String[1][1];
				this.data[0][0] = "No hay datos almacenados";
			}
			else
			{
				this.columns = new String[4];
				
				this.columns[0] = "Id";
				this.columns[1] = "Nombre";
				this.columns[2] = "Editar";
				this.columns[3] = "Eliminar";
				
				this.data = new String[numProveedores][4];
				
				for(int n = 0; n < numProveedores; ++n)
				{
					this.data[n][0] = Integer.toString(listadoProveedores[n].getId());
					this.data[n][1] = listadoProveedores[n].getNombre();
					this.data[n][2] = "Editar";
					this.data[n][3] = "Eliminar";
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
