package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import clases.Cliente;
import models.ClientModel;
import utils.FileManager;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PerfilCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEdad;
	private JTextField txtDireccion;
	private JTextField txtcorreo;
	private JTextField txtTelefono;
	private JTextField txtCelular;
	private File fileSelected = null;
	public static Cliente cliente = null;
	private JComboBox cboGenro;
	private JLabel lblImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilCliente frame = new PerfilCliente(cliente);
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
	
	
	public PerfilCliente(Cliente cliente) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtNombre.setText(cliente.getName());
				txtApellido.setText(cliente.getLastname());
				txtDireccion.setText(cliente.getAddress());
				txtcorreo.setText(cliente.getEmail());
				txtDNI.setText(cliente.getDni() + "");
				txtEdad.setText(cliente.getAge() + "");
				txtTelefono.setText(cliente.getPhone() + "");
				txtCelular.setText(cliente.getCellphone() + "");
				cboGenro.setSelectedIndex(cliente.getGender() == 'M' ? 1 : 2);
				lblImagen.setIcon(FileManager.ConvertURLToIcon(cliente.getProfileUrl()));
			}
		});
		setTitle("Cliente - Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 494, 393);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Actualizar Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(24, 115, 71, 14);
		panel.add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(113, 109, 130, 20);
		panel.add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(24, 277, 71, 14);
		panel.add(lblContrasea);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(23, 33, 71, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(112, 30, 223, 20);
		panel.add(txtNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(23, 77, 71, 14);
		panel.add(lblApellidos);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(112, 71, 223, 20);
		panel.add(txtApellido);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(24, 154, 71, 14);
		panel.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(113, 151, 71, 20);
		panel.add(txtEdad);
		
		JLabel lblGenero = new JLabel("G\u00E9nero");
		lblGenero.setBounds(203, 154, 71, 14);
		panel.add(lblGenero);
		
		cboGenro = new JComboBox();
		cboGenro.setModel(new DefaultComboBoxModel(new String[] {"", "M", "F"}));
		cboGenro.setBounds(284, 151, 52, 20);
		panel.add(cboGenro);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(24, 199, 71, 14);
		panel.add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(113, 193, 130, 20);
		panel.add(txtDireccion);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(24, 236, 71, 14);
		panel.add(lblCorreo);
		
		txtcorreo = new JTextField();
		txtcorreo.setColumns(10);
		txtcorreo.setBounds(114, 233, 130, 20);
		panel.add(txtcorreo);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(24, 321, 71, 14);
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(113, 315, 130, 20);
		panel.add(txtTelefono);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(24, 358, 71, 14);
		panel.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(113, 352, 130, 20);
		panel.add(txtCelular);
		
		lblImagen = new JLabel();
		lblImagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fileSelected = FileManager.openFileSystem(1);
				String filePath = null;
				
				try {
					filePath = fileSelected.getPath();
				} catch (NullPointerException err) {
					System.err.println(err);
				}
				System.out.println(filePath);
				
				try {
					if (filePath != null) {
						ImageIcon iconResized = FileManager.ResizeImageIcon(filePath, 180, 180);
						lblImagen.setIcon(iconResized);
					}
				} catch (Exception err) {
					 JOptionPane.showMessageDialog(null, "Ups! Error abriendo la imagen " + err);
				}
			}
		});
		lblImagen.setForeground(Color.BLACK);
		lblImagen.setBounds(284, 192, 180, 180);
		panel.add(lblImagen);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiarContrasena cm = new CambiarContrasena();
				cm.setVisible(true);
			}
		});
		btnCambiar.setBounds(154, 273, 89, 23);
		panel.add(btnCambiar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// nombre, apellidos, dni, edad, direccion, genero, correo, telefono, celular, imageurl
				String nombre, apellidos, direccion, correo;
				int dni, age, telefono, celular;
				char genero;
				ClientModel cm = new ClientModel();
				
				nombre = txtNombre.getText();
				apellidos = txtApellido.getText();
				direccion = txtDireccion.getText();
				correo = txtcorreo.getText();
				dni = Integer.parseInt(txtDNI.getText());
				age = Integer.parseInt(txtEdad.getText());
				telefono = Integer.parseInt(txtTelefono.getText());
				celular = Integer.parseInt(txtCelular.getText());
				genero = cboGenro.getSelectedItem().toString().charAt(0);
				
				cliente.setName(nombre);
				cliente.setLastname(apellidos);
				cliente.setDni(dni);
				cliente.setAge(age);
				cliente.setAddress(direccion);
				cliente.setGender(genero);
				cliente.setEmail(correo);
				cliente.setPhone(telefono);
				cliente.setCellphone(celular);
				if(fileSelected != null) {
					cliente.saveFile(fileSelected, fileSelected.getPath());
					cliente.setProfileUrl(cliente.getDownload(cliente.getFolder(), fileSelected.getName()));
				} 
				
				int result = cm.updateClient(cliente, dni);
				
				if(result != 0) {
					JOptionPane.showMessageDialog(null, "Datos Actualizados");
				} else {
					JOptionPane.showMessageDialog(null, "Los datos no han sido actualizados, probablemente hubo un error");
				}
				
			}
		});
		btnActualizar.setBounds(207, 422, 105, 23);
		contentPane.add(btnActualizar);
		
	}
}
