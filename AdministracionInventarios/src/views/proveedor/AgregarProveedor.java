package views.proveedor;

import controller.Proveedores;
import controller.Sesion;
import templates.ProveedorTemp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class AgregarProveedor implements ActionListener {

	public Sesion sesion;
	
	private JFrame f;
	private JLabel lTitulo;
	private JLabel lNombre;
	private JTextField tNombre;
	private JLabel lResultado;
	private JButton btnGuardar;
	
	
	public AgregarProveedor(Sesion sesion)
	{
		this.sesion = sesion;
		
		this.lTitulo = new JLabel("Formulario - Agregar Proveedor");
		this.lTitulo.setBounds(20, 5, 300, 50);
		
		this.lNombre = new JLabel("Nombre Proveedor");
		this.lNombre.setBounds(20, 40, 200, 30);
		
		this.tNombre = new JTextField();
		this.tNombre.setBounds(160, 40, 180, 30);
		
		this.btnGuardar = new JButton("Registrar");
		this.btnGuardar.setBounds(60, 200, 200, 30);
		this.btnGuardar.addActionListener(this);
		
		this.lResultado = new JLabel("");
		this.lResultado.setBounds(20, 250, 400, 30);
		
		this.f = new JFrame();
		this.f.add(this.lTitulo);
		this.f.add(this.lNombre);
		this.f.add(this.tNombre);
		this.f.add(this.btnGuardar);
		this.f.add(this.lResultado);
		
		this.f.setSize(400, 300);
		this.f.setLayout(null);
		this.f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String msj = null;
		lResultado.setText("");
		if(this.tNombre.getText().equals(""))
		{
			msj += "Falta el campo \"Nombre\"<br/>";
		}
		msj += "</font></html>";
		
		if(msj.equals("<html><font color=red></font></html>"))
		{
			this.lResultado.setText(msj);
			return;
		}
		
		String nombre = this.tNombre.getText();
		
		ProveedorTemp prov = new ProveedorTemp(nombre);
		Proveedores proveedor = new Proveedores();
		
		int result = proveedor.setProveedor(prov);
		System.out.println(result);
		
		switch(result)
		{
			case 0:
				this.lResultado.setText("El proveedor a registrar ya existe");
			break;
			
			case 1:
				new VerProveedor(this.sesion);
				this.f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			break;
			
			case 2:
				this.lResultado.setText("No se ha podido registrar el proveedor");
			break;
			
			case 3:
				this.lResultado.setText("Ha ocurrido un error de validacion datos");
			break;
		}
	}
}
