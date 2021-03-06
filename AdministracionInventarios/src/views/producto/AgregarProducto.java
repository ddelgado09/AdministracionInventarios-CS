package views.producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Productos;
import controller.Proveedores;
import controller.Sesion;
import templates.ProductoTemp;
import templates.ProveedorTemp;

public class AgregarProducto implements ActionListener {

	public Sesion sesion;
	
	private JLabel tituloForm;
	private JLabel lNombre;
	private JTextField tNombre;
	private JLabel lCantidad;
	private JTextField tCantidad;
	private JLabel lValorUnitario;
	private JTextField tValorUnitario;
	private JLabel lProveedor;
	private JComboBox tProveedor;
	private JButton btnGuardarProducto;
	private JLabel lResultado;
	private JFrame f;
	
	public AgregarProducto(Sesion sesion)
	{
		this.sesion = sesion;
		
		this.tituloForm = new JLabel("Formulario - Agregar Producto");
		this.tituloForm.setBounds(20, 5, 300, 20);

		this.lNombre = new JLabel("Nombre del Producto");
		this.lNombre.setBounds(20, 40, 200, 30);
		
		this.tNombre = new JTextField();
		this.tNombre.setBounds(160, 40, 250, 30);
		
		this.lCantidad = new JLabel("Cantidad Inicial");
		this.lCantidad.setBounds(20, 100, 200, 30);
		
		this.tCantidad = new JTextField();
		this.tCantidad.setBounds(160, 100, 250, 30);
		
		this.lValorUnitario = new JLabel("Valor Unitario");
		this.lValorUnitario.setBounds(20, 160, 200, 30);
		
		this.tValorUnitario = new JTextField();
		this.tValorUnitario.setBounds(160, 160, 250, 30);
		
		this.lProveedor = new JLabel("Proveedor");
		this.lProveedor.setBounds(20, 220, 200, 30);
		
		this.tProveedor = new JComboBox(this.listaProveedores());
		this.tProveedor.setBounds(160, 220, 250, 30);
		
		this.btnGuardarProducto = new JButton("Agregar");
		this.btnGuardarProducto.setBounds(300, 350, 180, 50);
		this.btnGuardarProducto.addActionListener(this);
		
		this.lResultado = new JLabel("");
		this.lResultado.setBounds(20, 220, 1000, 200);
		
		this.f = new JFrame("Agregar Producto - Mercado Chaotic");
		f.add(this.tituloForm);
		f.add(this.lNombre);
		f.add(this.tNombre);
		f.add(this.lCantidad);
		f.add(this.tCantidad);
		f.add(this.lValorUnitario);
		f.add(this.tValorUnitario);
		f.add(this.lProveedor);
		f.add(this.tProveedor);
		f.add(this.btnGuardarProducto);
		f.add(lResultado);
		f.setSize(500, 450);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String msj = "<html><font color=red>";
		
		lResultado.setText("");
		if(this.tNombre.getText().equals(""))
		{
			msj += "Falta el campo \"Nombre\"<br/>";
		}
		
		if(this.tCantidad.getText().equals(""))
		{
			msj += "Falta el campo \"Cantidad\"<br/>";
		}
		else if(!this.isNumeric(this.tCantidad.getText()))
		{
			msj += "El valor en el campo \"Cantidad\" no es v�lido<br/>";
		}
		
		if(this.tValorUnitario.getText().equals(""))
		{
			msj += "Falta el campo \"Valor Unitario\"<br/>";
		}
		else if(!this.isNumeric(this.tValorUnitario.getText()))
		{
			msj += "El valor en el campo \"Valor Unitario\" no es v�lido<br/>";
		}
		
		msj += "</font></html>";
		
		if(!msj.equals("<html><font color=red></font></html>"))
		{
			this.lResultado.setText(msj);
			return;
		}
		
		String nombre = this.tNombre.getText();
		int cantidad = Integer.parseInt(this.tCantidad.getText());
		Double valorUnitario = Double.parseDouble(this.tValorUnitario.getText());
		String proveedor = (String) this.tProveedor.getItemAt(this.tProveedor.getSelectedIndex());
		
		ProductoTemp prod = new ProductoTemp(nombre, cantidad, valorUnitario, proveedor);
		
		Productos setProd = new Productos();
		int result = setProd.setProducto(prod);
		
		switch(result)
		{
			case 0:
				this.lResultado.setText("Ya existe un producto con el nombre ingresado");
			break;
			
			case 1:
				new VerProducto(this.sesion);
				f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			break;
			
			case 2:
				this.lResultado.setText("No se ha podido insertar el producto");
			break;
			
			case 3:
				this.lResultado.setText("Ya existe un producto con el nombre ingresado");
			break;
		}
		
	}
	
	private String[] listaProveedores()
	{
		Proveedores prov = new Proveedores();
		ProveedorTemp[] listadoProveedores = prov.getProveedores(0);
		
		int len = listadoProveedores.length;
		String[] listaProveedores = new String[len];
		
		for(int i = 0; i < len; ++i)
		{
			listaProveedores[i] = listadoProveedores[i].getNombre();
		}
		
		return listaProveedores;
	}
	
	private boolean isNumeric(String num)
	{
		if(num == null)
		{
			return false;
		}
		
		try
		{
			double d = Double.parseDouble(num);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		
		return true;
	}
}
