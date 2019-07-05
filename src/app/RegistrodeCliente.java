package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.JsonSyntaxException;

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


public class RegistrodeCliente extends JFrame {

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
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrodeCliente frame = new RegistrodeCliente();
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
	public RegistrodeCliente() {
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
		
		txtDni = new JTextField();
		txtDni.setBounds(191, 64, 327, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblContraseas = new JLabel("Contrase\u00F1a");
		lblContraseas.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseas.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblContraseas.setBounds(10, 190, 150, 20);
		contentPane.add(lblContraseas);
		
		txtContra = new JTextField();
		txtContra.setColumns(10);
		txtContra.setBounds(191, 106, 327, 20);
		contentPane.add(txtContra);
		
		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblNombre.setBounds(10, 64, 150, 20);
		contentPane.add(lblNombre);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(191, 232, 229, 20);
		contentPane.add(txtNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidos.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblApellidos.setBounds(10, 106, 150, 20);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(191, 190, 229, 20);
		contentPane.add(txtApellidos);
		
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
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(191, 400, 100, 20);
		contentPane.add(txtCorreo);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblTelefono.setBounds(10, 400, 150, 20);
		contentPane.add(lblTelefono);
		
		txtTelef = new JTextField();
		txtTelef.setColumns(10);
		txtTelef.setBounds(191, 358, 327, 20);
		contentPane.add(txtTelef);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setHorizontalAlignment(SwingConstants.CENTER);
		lblCelular.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblCelular.setBounds(270, 400, 150, 20);
		contentPane.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(191, 148, 150, 20);
		contentPane.add(txtCelular);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null,"Creacion de ususario correcto");
				System.exit(0);
			}
		});
		btnAceptar.setBounds(306, 442, 113, 23);
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
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Georgia", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"F", "M"}));
		comboBox.setBounds(417, 274, 86, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(384, 400, 134, 20);
		contentPane.add(textField);
		
		JLabel lblImagen = new JLabel("imagen");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(598, 106, 187, 162);
		contentPane.add(lblImagen);
		
		JButton btnNewButton = new JButton("Subir Foto");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(641, 298, 100, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmPrincipal p = new frmPrincipal();
				p.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(461, 442, 113, 23);
		contentPane.add(btnCancelar);
		
		

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
