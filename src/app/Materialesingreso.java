package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import app.*;
import clases.Cliente;
import clases.Material;
import utils.FileManager;
import models.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class Materialesingreso extends JFrame {
	public Materialesingreso() {
	}

	private JPanel contentPane;
	private JTextField txtcantidad;
	private JTextField txtnombre;
	private JTextField txtprecio;
	private File fileSelected = null;
	private JTextField txtdescripcion;
	private JComboBox cboestado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Materialesingreso frame = new Materialesingreso();
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
	
	
	public Materialesingreso(Cliente cliente) {
		
		setTitle("Ingreso de Materiales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 397);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JLabel lblMaterial = new JLabel("Tipo");
		lblMaterial.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterial.setBounds(10, 225, 147, 20);
		contentPane.add(lblMaterial);
		
		txtcantidad = new JTextField();
		txtcantidad.setBounds(185, 176, 109, 20);
		contentPane.add(txtcantidad);
		txtcantidad.setColumns(10);
		
		JComboBox cboMaterial = new JComboBox();
		cboMaterial.setBounds(185, 225, 109, 20);
		cboMaterial.setModel(new DefaultComboBoxModel(new String[] {"Plastico", "Carton", "Vidrio", "Metal"}));
		contentPane.add(cboMaterial);
		
		JLabel lblJjjj = new JLabel("Estado:");
		lblJjjj.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblJjjj.setHorizontalAlignment(SwingConstants.CENTER);
		lblJjjj.setBounds(10, 274, 147, 20);
		contentPane.add(lblJjjj);
		
		JLabel lblPrecioEstimado = new JLabel("Cantidad :");
		lblPrecioEstimado.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblPrecioEstimado.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioEstimado.setBounds(10, 176, 147, 20);
		contentPane.add(lblPrecioEstimado);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre,descripcion,tipo,estado,img,codmate;
				double precio;
				int cant;
				
				Material mat = new Material();
				
				nombre = txtnombre.getText();
				descripcion = txtdescripcion.getText();
				precio = Double.parseDouble(txtprecio.getText());
				cant = Integer.parseInt(txtcantidad.getText());
				tipo = cboMaterial.getSelectedItem().toString();
				estado=cboestado.getSelectedItem().toString();
				
				mat.setCodUser(cliente.getCode());
				mat.setNombre(nombre); 
				mat.setCodMat(mat.generateCodMat());
				System.out.println(mat.getCodMat());
				mat.setDesc(descripcion);
				mat.setPrecioVenta(precio);
				mat.setCantidad(cant);
				mat.setTipo(tipo);
				mat.setEstado(estado);
				if(fileSelected != null){
					mat.saveFile(fileSelected, mat.getFolder()+"/");
					mat.setMaterialUrl(mat.getDownload(mat.getFolder(), fileSelected.getName()));
				}
					
				MaterialModel mm = new MaterialModel();
				int result =mm.createMaterial(mat);
				
				if(result != 0){
				JOptionPane.showMessageDialog(null, "Se registro correctamente su material");
				}else
					JOptionPane.showMessageDialog(null, "No se ha registrado");
				
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuardar.setBounds(211, 314, 126, 33);
		btnGuardar.setIcon(new ImageIcon(Materialesingreso.class.getResource("/images/iconos22x22/disco-flexible.png")));
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(365, 314, 126, 33);
		btnCancelar.setIcon(new ImageIcon(Materialesingreso.class.getResource("/images/iconos22x22/cancelar.png")));
		contentPane.add(btnCancelar);
		
		cboestado = new JComboBox();
		cboestado.setBounds(185, 274, 109, 20);
		cboestado.setModel(new DefaultComboBoxModel(new String[] {"Optimo", "Regular", "Malo"}));
		contentPane.add(cboestado);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblNombre.setBounds(10, 28, 147, 20);
		contentPane.add(lblNombre);
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		txtnombre.setBounds(185, 29, 235, 20);
		contentPane.add(txtnombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion :");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblDescripcion.setBounds(10, 78, 147, 20);
		contentPane.add(lblDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio :");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblPrecio.setBounds(10, 127, 147, 20);
		contentPane.add(lblPrecio);
		
		txtprecio = new JTextField();
		txtprecio.setColumns(10);
		txtprecio.setBounds(185, 127, 120, 20);
		contentPane.add(txtprecio);
		
		JLabel lblimagen = new JLabel("Ingrese imagen....");
		lblimagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				fileSelected = FileManager.openFileSystem(1);
				String filePath = null;
				
				try {
					filePath = fileSelected.getPath();
					if(filePath != null ){
						ImageIcon iconResized = FileManager.ResizeImageIcon(filePath,180,180);
						lblimagen.setIcon(iconResized);
					}
				} catch (NullPointerException err) {
					System.err.println(err);
				}
				System.out.println(filePath);
				
				try {
					if (filePath != null) {
						ImageIcon iconResized = FileManager.ResizeImageIcon(filePath, 180, 180);
						lblimagen.setIcon(iconResized);
					}
				} catch (Exception err) {
					 JOptionPane.showMessageDialog(null, "Ups! Error abriendo la imagen " + err);
				}
			}
		});
		lblimagen.setBounds(480, 29, 180, 180);
		contentPane.add(lblimagen);
		
		txtdescripcion = new JTextField();
		txtdescripcion.setColumns(10);
		txtdescripcion.setBounds(185, 78, 235, 20);
		contentPane.add(txtdescripcion);
	}
}
