package views.producto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class EliminarProducto extends JFrame implements ActionListener {

	private JPanel PanelDatos;
	private JTextField tNombre;
	private JTable tProductos;


	public EliminarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PanelDatos = new JPanel();
		PanelDatos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelDatos);
		PanelDatos.setLayout(null);
		
		JButton btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setBounds(264, 178, 139, 35);
		PanelDatos.add(btnEliminarProducto);
		
		tNombre = new JTextField();
		tNombre.setText("Ingrese nombre del producto");
		tNombre.setBounds(54, 31, 185, 29);
		PanelDatos.add(tNombre);
		tNombre.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(54, 71, 95, 23);
		PanelDatos.add(btnNewButton);
		
		
		
	}
}
