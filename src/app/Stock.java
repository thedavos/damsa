package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Stock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable jTVer;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Stock() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(21, 28, 357, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnTodo = new JButton("Todo");
		btnTodo.setBounds(388, 27, 89, 23);
		contentPane.add(btnTodo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 483, 228);
		contentPane.add(scrollPane);
		
		
		modelo= new DefaultTableModel();
		jTVer = new JTable();
		jTVer.setModel(modelo);
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Precio de Venta");
		modelo.addColumn("Tipo");
		modelo.addColumn("Estado");
		modelo.addColumn("Imagen");
		scrollPane.setViewportView(jTVer);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(202, 304, 89, 23);
		contentPane.add(btnCerrar);
	}
}
