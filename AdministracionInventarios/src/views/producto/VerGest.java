package views.producto;

//Listo?

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VerGest {
	
	private String[] columns;
	private String[][] data;
	
	private JPanel panel;
	private JLabel lId;
	private JTable tEmpleados;
	private JScrollPane sp;
	private JFrame f;
	private Empleados emp;
	private JButton bVolver;
	
	
	public VerGest()
	{
		//this.emp = new Usuarios();
		this.getProductos(0);
		
		panel = new JPanel();
		
		this.tEmpleados = new JTable(this.data, this.columns);
		this.sp = new JScrollPane(this.tEmpleados);
		
		this.bVolver = new JButton("Volver");
		this.bVolver.setBounds(400, 400, 300, 30);
		
		panel.setLayout(new BorderLayout());
		
		f = new JFrame("Listado de empleados - Almacenes Chaotic");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(sp);
		f.pack();
		f.setLocationRelativeTo(this.lId);
		f.setSize(600, 500);
		f.setVisible(true);
	}
	
	private void getProductos(int id)
	{
		GestInvTemp[] listadoEmpleados = this.emp.getProductos(id);
		
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
				
				
				this.data = new String[numProductos][5];
				
				for(int n = 0; n < numProductos; ++n)
				{
					this.data[n][0] = Integer.toString(listadoProductos[n].getId());
					this.data[n][1] = listadoProductos[n].getNombre();
					
				}
			}
		}
		
		
	}

}
