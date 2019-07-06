package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import utils.FileManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Stock extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusca;
	private JTable jTVer;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JButton btnFiltrar;
	public MaterialModel mm = new MaterialModel();
	public ArrayList<Material> materials = mm.getMaterials();

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
				fillTable(materials);
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1236, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBusca = new JTextField();
		txtBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String value = txtBusca.getText();
				clearTable();
				fillTable(filtrarMaterial(value));
			}
		});
		txtBusca.setBounds(10, 28, 618, 20);
		contentPane.add(txtBusca);
		txtBusca.setColumns(10);
		
		JButton btnTodo = new JButton("Todo");
		btnTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fillTable(materials);
			}
		});
		btnTodo.setBounds(737, 27, 89, 23);
		contentPane.add(btnTodo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 1200, 289);
		contentPane.add(scrollPane);
		
		
		jTVer = new JTable(modelo) {
			public Class getColumnClass(int column) {
				return (column == 9) ? ImageIcon.class : Object.class;
			}
		};
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

				filtrarMaterial(txtBusca.getText());

				String value = txtBusca.getText();
				clearTable();
				fillTable(filtrarMaterial(value));
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
	
	/*
	public ArrayList<Material> filtrarMaterial(String data) {
		ArrayList<Material> materialsFiltrados = new ArrayList<Material>();
		
		for (int i = 0; i < materials.size(); i++) {
			Material mat = materials.get(i);
			if (
					mat.getNombre().contains(data.toString()) ||
					mat.getCodUser().contains(data.toString()) ||
					mat.getDesc().contains(data.toString()) ||
					mat.getTipo().contains(data.toString()) ||
					mat.getEstado().contains(data.toString())
				) {
				materialsFiltrados.add(mat);
			}
		}
		
		return materialsFiltrados;
	}
	
	*/
	
	private ArrayList<Material> filtrarMaterial(String data) {
		ArrayList<Material> materialsFiltrados = new ArrayList<Material>();
		
		for (int i = 0; i < materials.size(); i++) {
			Material mat = materials.get(i);
			if (
					mat.getNombre().contains(data.toString()) ||
					mat.getCodUser().contains(data.toString()) ||
					mat.getDesc().contains(data.toString()) ||
					mat.getTipo().contains(data.toString()) ||
					mat.getEstado().contains(data.toString())
				) {
				materialsFiltrados.add(mat);
			}
		}
		
		return materialsFiltrados;
	}
	
	private void clearTable() {
		for (int i = 0; i < modelo.getRowCount(); i++) {
			modelo.removeRow(i);
		}
	}
	
	private void fillTable(ArrayList<Material> materials) {
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
			String notFoundURL = "https://f002.backblazeb2.com/file/damsa-files/materials/notfound.png";
			ImageIcon icon = null;
			
			ImageIcon notFound = FileManager.ResizeImageIcon(FileManager.ConvertURLToIcon(notFoundURL), 30, 30);
			if (mat.getMaterialUrl() != null) {
				icon = FileManager.ResizeImageIcon(FileManager.ConvertURLToIcon(mat.getMaterialUrl()), 30, 30);
			}
			
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
					icon == null ? notFound : icon, 
					inicio
					};
			modelo.addRow(data);
		}
		centrarValoreDeTabla();
	}
	
}
