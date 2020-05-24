package views.producto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import controller.Productos;
import controller.Sesion;
import templates.ProductoTemp;
import utils.ButtonEditor;
import utils.ButtonRenderer;
import views.login.Login;

public class VerProducto extends JFrame implements ActionListener {
	
	private String[] columns;
	private String[][] data;
	
	public Sesion sesion;
	private JPanel panel;
	private JLabel lTitulo;
	private JTable tProductos;
	private TableCellRenderer tableRenderer; 
	private JScrollPane sp;
	private JFrame f;
	private Productos prod;
	private JButton bAgregar;
	private JButton bVolver;
	
	
	public VerProducto(Sesion sesion)
	{
		this.sesion = sesion;
		
		this.prod = new Productos();
		this.getProductos(0);
		
		panel = new JPanel();
		
		this.tProductos = new JTable(this.data, this.columns);
		
		this.tProductos.getColumn("Editar").setCellRenderer(new ButtonRenderer());
		this.tProductos.getColumn("Editar").setCellEditor(
					new ButtonEditor(new JCheckBox())
				);
		
		this.tProductos.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
		this.tProductos.getColumn("Eliminar").setCellEditor(
					new ButtonEditor(new JCheckBox())
				);
		
		this.sp = new JScrollPane(this.tProductos);
		this.sp.setBounds(0, 0, 600, 300);
		
		this.tableRenderer = tProductos.getDefaultRenderer(JButton.class);
		
		this.bAgregar = new JButton("Agregar Producto");
		this.bAgregar.setBounds(30, 400, 200, 30);
		this.bAgregar.addActionListener(this);
		
		this.bVolver = new JButton("Volver");
		this.bVolver.setBounds(350, 400, 200, 30);
		this.bAgregar.addActionListener(this);
		
		panel.setLayout(new BorderLayout());
		
		f = new JFrame("Listado Productos - Almacenes Chaotic");
		f.add(bAgregar);
		f.add(bVolver);
		f.setLayout(null);
		f.add(sp);
		f.pack();
		f.setLocationRelativeTo(this.lTitulo);
		f.setSize(600, 560);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();
		
		switch(action)
		{
			case "Agregar Producto":
				new AgregarProducto(this.sesion);
			break;
			
			case "Volver":
				new Login();
			break;
		}
		
		this.f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	}
	
	private void getProductos(int id)
	{
		ProductoTemp[] listadoProductos = this.prod.getProductos(id);
		
		if(listadoProductos != null)
		{
			
			int numProductos = listadoProductos.length;
			
			if(numProductos == 0)
			{
				this.columns = new String[1];
				this.columns[0] = "Sin Datos";
				
				this.data = new String[1][1];
				this.data[0][0] = "No hay datos almacenados";
			}
			else
			{
				this.columns = new String[7];
				
				this.columns[0] = "Id";
				this.columns[1] = "Nombre";
				this.columns[2] = "Cantidad";
				this.columns[3] = "Valor Unitario";
				this.columns[4] = "Proveedor";
				this.columns[5] = "Editar";
				this.columns[6] = "Eliminar";
				
				this.data = new String[numProductos][7];
				
				for(int n = 0; n < numProductos; ++n)
				{
					this.data[n][0] = Integer.toString(listadoProductos[n].getId());
					this.data[n][1] = listadoProductos[n].getNombre();
					this.data[n][2] = Integer.toString(listadoProductos[n].getCantidad());
					this.data[n][3] = Double.toString(listadoProductos[n].getValorUnitario());
					this.data[n][4] = listadoProductos[n].getProveedor();
					this.data[n][5] = "Editar";
					this.data[n][6] = "Eliminar";
				}
			}
		}
		
		
	}
}
