package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

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
		
		setBounds(100, 100, 454, 305);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(6, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDn = new JLabel("DNI");
		lblDn.setBounds(24, 23, 46, 14);
		contentPane.add(lblDn);
		
		txtDni = new JTextField();
		txtDni.setBounds(88, 20, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblContraseas = new JLabel("Contrase\u00F1a");
		lblContraseas.setBounds(194, 23, 86, 14);
		contentPane.add(lblContraseas);
		
		txtContra = new JTextField();
		txtContra.setColumns(10);
		txtContra.setBounds(270, 20, 86, 20);
		contentPane.add(txtContra);
		
		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(24, 64, 69, 14);
		contentPane.add(lblNombre);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(88, 61, 86, 20);
		contentPane.add(txtNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(206, 67, 69, 14);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(270, 64, 86, 20);
		contentPane.add(txtApellidos);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(24, 95, 69, 14);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(88, 92, 86, 20);
		contentPane.add(txtEdad);
		
		JLabel lblGenero = new JLabel("G\u00E9nero ");
		lblGenero.setBounds(206, 98, 69, 14);
		contentPane.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(270, 95, 86, 20);
		contentPane.add(txtGenero);
		
		JLabel lblDireccion = new JLabel("Direccion ");
		lblDireccion.setBounds(24, 137, 69, 14);
		contentPane.add(lblDireccion);
		
		txtDirecc = new JTextField();
		txtDirecc.setColumns(10);
		txtDirecc.setBounds(88, 134, 86, 20);
		contentPane.add(txtDirecc);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(206, 134, 69, 14);
		contentPane.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(270, 131, 86, 20);
		contentPane.add(txtCorreo);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(24, 175, 69, 14);
		contentPane.add(lblTelefono);
		
		txtTelef = new JTextField();
		txtTelef.setColumns(10);
		txtTelef.setBounds(88, 172, 86, 20);
		contentPane.add(txtTelef);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(206, 178, 69, 14);
		contentPane.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(270, 175, 86, 20);
		contentPane.add(txtCelular);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAceptar.setBounds(171, 219, 89, 23);
		contentPane.add(btnAceptar);
	}
}
