package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

import app.*;
import clases.Material;
import models.*;

public class Stock extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusca;
	private JTable jTVer;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JButton btnFiltrar;
	

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				MaterialModel mm = new MaterialModel();
				
				ArrayList<Material> materials = mm.getMaterials();
				
				for (int i = 0; i < materials.size(); i++) {
					Material mat = materials.get(i);
					
					int id = mat.getId();
					String codUser = mat.getCodUser();
					String codMat = mat.getCodMat();
					String nombre = mat.getNombre();
					String desc = mat.getDesc();
					String tipo = mat.getTipo();
					String estado = mat.getEstado();
					
					Double precioVenta = mat.getPrecioVenta();
					int cantidad = mat.getCantidad();
					Date inicio = mat.getInicio();
					
					Object[] data = {
							id, 
							codUser, 
							codMat, 
							nombre, 
							desc, 
							precioVenta, 
							cantidad, 
							tipo, 
							estado, 
							"Ver Perfil", 
							inicio
							};
					modelo.addRow(data);
				}
				centrarValoreDeTabla();
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1236, 437);
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
		scrollPane.setBounds(10, 65, 1200, 289);
		contentPane.add(scrollPane);
		
		
		jTVer = new JTable();
		jTVer.setModel(modelo);
		modelo.addColumn("Id Material");
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
		scrollPane.setViewportView(jTVer);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(539, 365, 89, 23);
		contentPane.add(btnCerrar);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFiltrar.setBounds(638, 27, 89, 23);
		contentPane.add(btnFiltrar);
	}
	
	void centrarValoreDeTabla() {
		
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(JLabel.CENTER);
		jTVer.setDefaultRenderer(String.class, centerRender);
		
	}
	
}
