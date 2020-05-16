package views.producto;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

import controller.Productos;
import templates.ProductoTemp;

public class VerProducto {
	
	private String[] columns;
	private String[][] data;
	
	private JPanel panel;
	private JLabel lTitulo;
	private JTable tProductos;
	private JScrollPane sp;
	private JFrame f;
	private Productos prod;
	private JButton bVolver;
	
	
	public VerProducto()
	{
		this.prod = new Productos();
		this.getProductos(0);
		
		panel = new JPanel();
		
		this.tProductos = new JTable(this.data, this.columns);
		this.sp = new JScrollPane(this.tProductos);
		
		this.bVolver = new JButton("Volver");
		this.bVolver.setBounds(400, 400, 300, 30);
		
		panel.setLayout(new BorderLayout());
		
		f = new JFrame("Listado Productos - Almacenes Chaotic");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(sp);
		f.pack();
		f.setLocationRelativeTo(this.lTitulo);
		f.setSize(600, 500);
		f.setVisible(true);
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
				this.columns = new String[5];
				
				this.columns[0] = "Id";
				this.columns[1] = "Nombre";
				this.columns[2] = "Cantidad";
				this.columns[3] = "Valor Unitario";
				this.columns[4] = "Proveedor";
				
				this.data = new String[numProductos][5];
				
				for(int n = 0; n < numProductos; ++n)
				{
					this.data[n][0] = Integer.toString(listadoProductos[n].getId());
					this.data[n][1] = listadoProductos[n].getNombre();
					this.data[n][2] = Integer.toString(listadoProductos[n].getCantidad());
					this.data[n][3] = Float.toString(listadoProductos[n].getValorUnitario());
					this.data[n][4] = listadoProductos[n].getProveedor();
				}
			}
		}
		
		
	}
}
