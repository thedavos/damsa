package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.JsonSyntaxException;

import utils.FileManager;

import javax.swing.JLabel;
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



public class RegistroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtContra;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextField txtGenero;
	private JTextField txtDirecc;
	private JTextField txtCorreo;
	private JTextField txtTelef;
	private JTextField txtCelular;

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
		setBackground(SystemColor.activeCaption);
		setTitle("Registro Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 666, 525);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(6, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDn = new JLabel("DNI");
		lblDn.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblDn.setBounds(38, 385, 69, 20);
		contentPane.add(lblDn);
		
		txtDni = new JTextField();
		txtDni.setBounds(205, 64, 252, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblContraseas = new JLabel("Contrase\u00F1a");
		lblContraseas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseas.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblContraseas.setBounds(24, 146, 150, 20);
		contentPane.add(lblContraseas);
		
		txtContra = new JTextField();
		txtContra.setColumns(10);
		txtContra.setBounds(205, 105, 252, 20);
		contentPane.add(txtContra);
		
		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblNombre.setBounds(24, 64, 150, 20);
		contentPane.add(lblNombre);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(205, 187, 186, 20);
		contentPane.add(txtNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblApellidos.setBounds(24, 105, 150, 20);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(205, 146, 252, 20);
		contentPane.add(txtApellidos);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblEdad.setBounds(24, 245, 69, 14);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(88, 242, 86, 20);
		contentPane.add(txtEdad);
		
		JLabel lblGenero = new JLabel("G\u00E9nero ");
		lblGenero.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblGenero.setBounds(206, 248, 69, 14);
		contentPane.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(270, 245, 86, 20);
		contentPane.add(txtGenero);
		
		JLabel lblDireccion = new JLabel("Direccion ");
		lblDireccion.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblDireccion.setBounds(24, 287, 69, 14);
		contentPane.add(lblDireccion);
		
		txtDirecc = new JTextField();
		txtDirecc.setColumns(10);
		txtDirecc.setBounds(88, 284, 86, 20);
		contentPane.add(txtDirecc);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblCorreo.setBounds(206, 284, 69, 14);
		contentPane.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(270, 281, 86, 20);
		contentPane.add(txtCorreo);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblTelefono.setBounds(24, 325, 69, 14);
		contentPane.add(lblTelefono);
		
		txtTelef = new JTextField();
		txtTelef.setColumns(10);
		txtTelef.setBounds(88, 322, 86, 20);
		contentPane.add(txtTelef);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblCelular.setBounds(206, 328, 69, 14);
		contentPane.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(270, 325, 86, 20);
		contentPane.add(txtCelular);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAceptar.setBounds(234, 432, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblPorFavorIngrese = new JLabel("Por favor ingrese sus datos");
		lblPorFavorIngrese.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblPorFavorIngrese.setBounds(21, 11, 270, 20);
		contentPane.add(lblPorFavorIngrese);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmarContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmarContrasea.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblConfirmarContrasea.setBounds(24, 187, 150, 20);
		contentPane.add(lblConfirmarContrasea);
		/*JButton btnSubirImagen = new JButton("Subir Imagen");
		btnSubirImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileManager fm = new FileManager();
				
				try {
					fm.saveImage();
				} catch (IOException | JsonSyntaxException | NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnSubirImagen.setBounds(280, 218, 150, 25);
		contentPane.add(btnSubirImagen);*/
	}
}
