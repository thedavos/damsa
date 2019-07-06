package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import clases.Empresa;
import models.ClientModel;
import models.EnterpriseModel;
import utils.FileManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class PerfilEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtRUC;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtCelular;
	public static Empresa empresa = null;
	private File fileSelected = null;
	private JLabel lblImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilEmpresa frame = new PerfilEmpresa(empresa);
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
	public PerfilEmpresa(Empresa empresa) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtNombre.setText(empresa.getName());
				txtDireccion.setText(empresa.getAddress());
				txtCorreo.setText(empresa.getEmail());
				txtRUC.setText(empresa.getRuc());
				txtTelefono.setText(empresa.getPhone() + "");
				txtCelular.setText(empresa.getCellphone() + "");
				System.out.println(empresa.getProfileUrl());
				if (empresa.getProfileUrl() != null) {
					lblImagen.setIcon(FileManager.ResizeImageIcon(FileManager.ConvertURLToIcon(empresa.getProfileUrl())));
				}
			}
		});
		setTitle("Empresa - Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Actualizar Datos de Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(10, 11, 472, 307);
		contentPane.add(panel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(23, 111, 71, 14);
		panel.add(lblContrasea);
		
		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setBounds(25, 33, 71, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(114, 30, 223, 20);
		panel.add(txtNombre);
		
		JLabel lblRuc = new JLabel("RUC");
		lblRuc.setBounds(25, 72, 71, 14);
		panel.add(lblRuc);
		
		txtRUC = new JTextField();
		txtRUC.setColumns(10);
		txtRUC.setBounds(114, 69, 223, 20);
		panel.add(txtRUC);
		
		JLabel label_6 = new JLabel("Direcci\u00F3n");
		label_6.setBounds(23, 153, 71, 14);
		panel.add(label_6);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(112, 150, 130, 20);
		panel.add(txtDireccion);
		
		JLabel label_7 = new JLabel("Correo");
		label_7.setBounds(23, 191, 71, 14);
		panel.add(label_7);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(113, 188, 130, 20);
		panel.add(txtCorreo);
		
		JLabel label_8 = new JLabel("Telefono");
		label_8.setBounds(23, 231, 71, 14);
		panel.add(label_8);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(112, 228, 130, 20);
		panel.add(txtTelefono);
		
		JLabel label_9 = new JLabel("Celular");
		label_9.setBounds(23, 275, 71, 14);
		panel.add(label_9);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(112, 269, 130, 20);
		panel.add(txtCelular);
		
		lblImagen = new JLabel("");
		lblImagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fileSelected = FileManager.openFileSystem(1);
				String filePath = null;
				
				try {
					filePath = fileSelected.getPath();
					
					System.out.println(filePath);
					
					if (filePath != null) {
						ImageIcon iconResized = FileManager.ResizeImageIcon(filePath, 180, 180);
						lblImagen.setIcon(iconResized);
					}
				} catch (NullPointerException err) {
					System.err.println(err);
				} catch (Exception err) {
					 JOptionPane.showMessageDialog(null, "Ups! Error abriendo la imagen " + err);
				}
			}
		});
		lblImagen.setForeground(Color.BLACK);
		lblImagen.setBounds(268, 111, 180, 180);
		panel.add(lblImagen);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiarContrasena cm =new CambiarContrasena(empresa);
				cm.setVisible(true);
			}
		});
		btnCambiar.setBounds(114, 107, 89, 23);
		panel.add(btnCambiar);
		
		JButton btnAcualizar = new JButton("Actualizar");
		btnAcualizar.setIcon(new ImageIcon(PerfilEmpresa.class.getResource("/images/iconos22x22/intercambio.png")));
		btnAcualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// nombre, apellidos, dni, edad, direccion, genero, correo, telefono, celular, imageurl
				String nombre, apellidos, direccion, correo, ruc;
				int age, telefono, celular;
				char genero;
				
				EnterpriseModel em = new EnterpriseModel();
				
				nombre = txtNombre.getText();
				direccion = txtDireccion.getText();
				correo = txtCorreo.getText();
				ruc = txtRUC.getText();
				telefono = Integer.parseInt(txtTelefono.getText());
				celular = Integer.parseInt(txtCelular.getText());
				
				empresa.setName(nombre);
				empresa.setRuc(ruc);
				empresa.setAddress(direccion);
				empresa.setEmail(correo);
				empresa.setPhone(telefono);
				empresa.setCellphone(celular);
				
				if(fileSelected != null) {
					empresa.saveFile(fileSelected, empresa.getFolder() + "/");
					empresa.setProfileUrl(empresa.getDownload(empresa.getFolder(), fileSelected.getName()));
				} 
				
				int result = em.updateEnterprise(empresa, ruc);
				
				if(result != 0) {
					JOptionPane.showMessageDialog(null, "Datos Actualizados");
				} else {
					JOptionPane.showMessageDialog(null, "Los datos no han sido actualizados, probablemente hubo un error");
				}
			}
		});
		btnAcualizar.setBounds(59, 329, 120, 23);
		contentPane.add(btnAcualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(PerfilEmpresa.class.getResource("/images/iconos22x22/cancelar.png")));
		btnCancelar.setBounds(286, 329, 120, 23);
		contentPane.add(btnCancelar);
	}

}
