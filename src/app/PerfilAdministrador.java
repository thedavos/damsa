package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import clases.Admin;
import models.AdminModel;
import models.ClientModel;
import utils.FileManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PerfilAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtCelular;
	public static Admin admin = null; 
	private JLabel lblImagen;
	private JComboBox cboGenero;
	private File fileSelected = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilAdministrador frame = new PerfilAdministrador(admin);
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
	public PerfilAdministrador(Admin admin) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtNombre.setText(admin.getName());
				txtApellidos.setText(admin.getLastname());
				txtDireccion.setText(admin.getAddress());
				txtCorreo.setText(admin.getEmail());
				txtDNI.setText(admin.getDni() + "");
				txtEdad.setText(admin.getAge() + "");
				txtTelefono.setText(admin.getPhone() + "");
				txtCelular.setText(admin.getCellphone() + "");
				cboGenero.setSelectedIndex(admin.getGender() == 'M' ? 1 : 2);
				if (admin.getProfileUrl() != null) {
					lblImagen.setIcon(FileManager.ResizeImageIcon(FileManager.ConvertURLToIcon(admin.getProfileUrl())));
				}
			}
		});
		setTitle("Administrador - Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Actualizar Datos del Administrador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(10, 11, 494, 393);
		contentPane.add(panel);
		
		JLabel label = new JLabel("DNI");
		label.setBounds(24, 115, 71, 14);
		panel.add(label);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(113, 109, 130, 20);
		panel.add(txtDNI);
		
		JLabel label_1 = new JLabel("Contrase\u00F1a");
		label_1.setBounds(24, 277, 71, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setBounds(23, 33, 71, 14);
		panel.add(label_2);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(112, 30, 223, 20);
		panel.add(txtNombre);
		
		JLabel label_3 = new JLabel("Apellidos");
		label_3.setBounds(23, 77, 71, 14);
		panel.add(label_3);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(112, 71, 223, 20);
		panel.add(txtApellidos);
		
		JLabel label_4 = new JLabel("Edad");
		label_4.setBounds(24, 154, 71, 14);
		panel.add(label_4);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(113, 151, 71, 20);
		panel.add(txtEdad);
		
		JLabel label_5 = new JLabel("G\u00E9nero");
		label_5.setBounds(203, 154, 71, 14);
		panel.add(label_5);
		
		cboGenero = new JComboBox();
		cboGenero.setModel(new DefaultComboBoxModel(new String[] {"", "M", "F"}));
		cboGenero.setBounds(284, 151, 61, 20);
		panel.add(cboGenero);
		
		JLabel label_6 = new JLabel("Direcci\u00F3n");
		label_6.setBounds(24, 199, 71, 14);
		panel.add(label_6);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(113, 193, 130, 20);
		panel.add(txtDireccion);
		
		JLabel label_7 = new JLabel("Correo");
		label_7.setBounds(24, 236, 71, 14);
		panel.add(label_7);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(114, 233, 130, 20);
		panel.add(txtCorreo);
		
		JLabel label_8 = new JLabel("Telefono");
		label_8.setBounds(24, 321, 71, 14);
		panel.add(label_8);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(113, 315, 130, 20);
		panel.add(txtTelefono);
		
		JLabel label_9 = new JLabel("Celular");
		label_9.setBounds(24, 355, 71, 14);
		panel.add(label_9);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(113, 352, 130, 20);
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
		lblImagen.setBounds(284, 183, 180, 180);
		panel.add(lblImagen);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiarContrasena cm =new CambiarContrasena(admin);
				cm.setVisible(true);
			}
		});
		btnCambiar.setBounds(113, 273, 89, 23);
		panel.add(btnCambiar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/images/iconos22x22/intercambio.png")));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// nombre, apellidos, dni, edad, direccion, genero, correo, telefono, celular, imageurl
				String nombre, apellidos, direccion, correo;
				int dni, age, telefono, celular;
				char genero;
				AdminModel am = new AdminModel();
				
				nombre = txtNombre.getText();
				apellidos = txtApellidos.getText();
				direccion = txtDireccion.getText();
				correo = txtCorreo.getText();
				dni = Integer.parseInt(txtDNI.getText());
				age = Integer.parseInt(txtEdad.getText());
				telefono = Integer.parseInt(txtTelefono.getText());
				celular = Integer.parseInt(txtCelular.getText());
				genero = cboGenero.getSelectedItem().toString().charAt(0);
				
				admin.setName(nombre);
				admin.setLastname(apellidos);
				admin.setDni(dni);
				admin.setAge(age);
				admin.setAddress(direccion);
				admin.setGender(genero);
				admin.setEmail(correo);
				admin.setPhone(telefono);
				admin.setCellphone(celular);
				if(fileSelected != null) {
					admin.saveFile(fileSelected, admin.getFolder() + "/");
					admin.setProfileUrl(admin.getDownload(admin.getFolder(), fileSelected.getName()));
				} 
				
				int result = am.updateAdmin(admin, dni);
				
				if(result != 0) {
					JOptionPane.showMessageDialog(null, "Datos Actualizados");
				} else {
					JOptionPane.showMessageDialog(null, "Los datos no han sido actualizados, probablemente hubo un error");
				}
			}
		});
		btnActualizar.setBounds(107, 415, 119, 23);
		contentPane.add(btnActualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/images/iconos22x22/cancelar.png")));
		btnCancelar.setBounds(290, 415, 113, 23);
		contentPane.add(btnCancelar);
	}

}
