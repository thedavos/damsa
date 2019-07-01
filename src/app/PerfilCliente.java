package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilCliente frame = new PerfilCliente();
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
	public PerfilCliente() {
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
		
		JComboBox cboGenro = new JComboBox();
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
		
		JLabel lblImagen = new JLabel("imagen...");
		lblImagen.setForeground(Color.BLACK);
		lblImagen.setBounds(271, 194, 194, 153);
		panel.add(lblImagen);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiarContraseña cm = new CambiarContraseña();
				cm.setVisible(true);
			}
		});
		btnCambiar.setBounds(154, 273, 89, 23);
		panel.add(btnCambiar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Datos Actualizados");
			}
		});
		btnActualizar.setBounds(207, 422, 105, 23);
		contentPane.add(btnActualizar);
		
	}
}
