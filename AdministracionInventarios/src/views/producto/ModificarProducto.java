package views.producto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ModificarProducto extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField tNombre;
	private JTextField lCantidad;
	private JTextField textField;

	
	public ModificarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tNombre = new JTextField();
		tNombre.setBounds(113, 22, 184, 28);
		contentPane.add(tNombre);
		tNombre.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(43, 63, 114, 28);
		contentPane.add(btnNewButton);
		
		lCantidad = new JTextField();
		lCantidad.setBounds(113, 124, 114, 20);
		contentPane.add(lCantidad);
		lCantidad.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(40, 127, 46, 14);
		contentPane.add(lblCantidad);
		
		textField = new JTextField();
		textField.setBounds(112, 155, 115, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor Unitario");
		lblValor.setBounds(26, 157, 76, 17);
		contentPane.add(lblValor);
		
		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setBounds(40, 29, 46, 14);
		contentPane.add(lblNombre);
		
		JButton btnModificarProducto = new JButton("Modificar");
		btnModificarProducto.setBounds(267, 223, 102, 34);
		contentPane.add(btnModificarProducto);
	}
}
