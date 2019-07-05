package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.JsonSyntaxException;

import clases.Cliente;
import models.ClientModel;
import utils.Encryption;
import utils.FileManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class RegistroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApe;
	private JTextField txtConfirmPassword;
	private JTextField txtPassword;
	private JTextField txtEdad;
	private JTextField txtGenero;
	private JTextField txtDirecc;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtDNI;
	private JTextField txtCelular;
	private File fileSelected;
	private JComboBox cboGenero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroCliente frame = new RegistroCliente();
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
	public RegistroCliente() {
		setResizable(false);
		
		
		setTitle("Registro Cliente");
		setBackground(SystemColor.activeCaption);
		setLocationRelativeTo(null);
		
		
		setBounds(100, 100, 851, 525);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(6, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JLabel lblDn = new JLabel("DNI");
		lblDn.setHorizontalAlignment(SwingConstants.CENTER);
		lblDn.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblDn.setBounds(10, 148, 150, 20);
		contentPane.add(lblDn);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(191, 64, 327, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblContraseas = new JLabel("Contrase\u00F1a");
		lblContraseas.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseas.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblContraseas.setBounds(10, 190, 150, 20);
		contentPane.add(lblContraseas);
		
		txtApe = new JTextField();
		txtApe.setColumns(10);
		txtApe.setBounds(191, 106, 327, 20);
		contentPane.add(txtApe);
		
		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblNombre.setBounds(10, 64, 150, 20);
		contentPane.add(lblNombre);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBounds(191, 232, 229, 20);
		contentPane.add(txtConfirmPassword);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidos.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblApellidos.setBounds(10, 106, 150, 20);
		contentPane.add(lblApellidos);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(191, 190, 229, 20);
		contentPane.add(txtPassword);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblEdad.setBounds(10, 274, 150, 20);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(191, 274, 86, 20);
		contentPane.add(txtEdad);
		
		JLabel lblGenero = new JLabel("G\u00E9nero ");
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenero.setBounds(270, 274, 150, 20);
		contentPane.add(lblGenero);
		
		
		JLabel lblDireccion = new JLabel("Direccion ");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblDireccion.setBounds(10, 316, 150, 20);
		contentPane.add(lblDireccion);
		
		txtDirecc = new JTextField();
		txtDirecc.setColumns(10);
		txtDirecc.setBounds(191, 316, 327, 20);
		contentPane.add(txtDirecc);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblCorreo.setBounds(10, 358, 150, 20);
		contentPane.add(lblCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(191, 400, 100, 20);
		contentPane.add(txtTelefono);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblTelefono.setBounds(10, 400, 150, 20);
		contentPane.add(lblTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(191, 358, 327, 20);
		contentPane.add(txtEmail);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setHorizontalAlignment(SwingConstants.CENTER);
		lblCelular.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblCelular.setBounds(270, 400, 150, 20);
		contentPane.add(lblCelular);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(191, 148, 150, 20);
		contentPane.add(txtDNI);
		
		JButton btnAceptar = new JButton("Guardar");
		btnAceptar.setIcon(new ImageIcon(RegistroCliente.class.getResource("/images/iconos22x22/disco-flexible.png")));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = null;
				ClientModel cm = new ClientModel();
				String password = txtPassword.getText();
				String confirmPassword = txtConfirmPassword.getText();
				
				if (!password.equals(confirmPassword)) {
					JOptionPane.showMessageDialog(null,"Contraseñas no coinciden");
					return;
				}
				
				try {
					cliente = new Cliente(
							Integer.parseInt(txtDNI.getText()),
							Encryption.SHA1(password),
							txtNombre.getText(),
							txtApe.getText(),
							cboGenero.getSelectedItem().toString().charAt(0),
							Integer.parseInt(txtEdad.getText()),
							txtEmail.getText(),
							txtDirecc.getText(),
							Integer.parseInt(txtTelefono.getText()),
							Integer.parseInt(txtCelular.getText())
						);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				if(fileSelected != null && cliente != null) {
					cliente.saveFile(fileSelected, cliente.getFolder() + "/");
					cliente.setProfileUrl(cliente.getDownload(cliente.getFolder(), fileSelected.getName()));
				} 
				
				if (cm.createClient(cliente) != 0) {
					JOptionPane.showMessageDialog(null,"El usuario " + cliente.getName() + " ha sido creado");
					
					Login l =new Login();
					l.setVisible(true);
					dispose();
				}
			}
		});
		btnAceptar.setBounds(306, 442, 113, 33);
		contentPane.add(btnAceptar);
		
		JLabel lblPorFavorIngrese = new JLabel("Por favor ingrese sus datos");
		lblPorFavorIngrese.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblPorFavorIngrese.setBounds(21, 22, 270, 20);
		contentPane.add(lblPorFavorIngrese);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmarContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarContrasea.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblConfirmarContrasea.setBounds(10, 232, 150, 20);
		contentPane.add(lblConfirmarContrasea);
		
		cboGenero = new JComboBox();
		cboGenero.setFont(new Font("Georgia", Font.PLAIN, 13));
		cboGenero.setModel(new DefaultComboBoxModel(new String[] {"","F", "M"}));
		cboGenero.setBounds(417, 274, 86, 20);
		contentPane.add(cboGenero);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(384, 400, 134, 20);
		contentPane.add(txtCelular);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(598, 106, 180, 180);
		contentPane.add(lblImagen);
		
		JButton btnSubirFoto = new JButton("Subir Foto");
		btnSubirFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnSubirFoto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSubirFoto.setBounds(641, 315, 100, 23);
		contentPane.add(btnSubirFoto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(RegistroCliente.class.getResource("/images/iconos22x22/cancelar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login l =new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(461, 442, 113, 33);
		contentPane.add(btnCancelar);
	}
}
