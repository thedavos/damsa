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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stock extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusca;
	private JTable jTVer;
	private DefaultTableModel modelo;
	private JButton btnFiltrar;
	final Object []object = new Object[11];

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
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 852, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBusca = new JTextField();
		txtBusca.setBounds(10, 28, 618, 20);
		contentPane.add(txtBusca);
		txtBusca.setColumns(10);
		
		JButton btnTodo = new JButton("Todo");
		btnTodo.setBounds(737, 27, 89, 23);
		contentPane.add(btnTodo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 816, 289);
		contentPane.add(scrollPane);
		
		
		modelo= new DefaultTableModel();
		jTVer = new JTable();
		jTVer.setModel(modelo);
		modelo.addColumn("Material");
		modelo.addColumn("Usuario");
		modelo.addColumn("Cod. Material");
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Precio");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Tipo");
		modelo.addColumn("Estado");
		modelo.addColumn("Imagen");
		modelo.addColumn("Creado");
		modelo.addColumn("Modificado");
		scrollPane.setViewportView(jTVer);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(335, 367, 89, 23);
		contentPane.add(btnCerrar);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFiltrar.setBounds(638, 27, 89, 23);
		contentPane.add(btnFiltrar);
	}
	
}
