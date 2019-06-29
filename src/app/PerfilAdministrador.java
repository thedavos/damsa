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
import java.awt.event.ActionEvent;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilAdministrador frame = new PerfilAdministrador();
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
	public PerfilAdministrador() {
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
		panel.setBackground(Color.WHITE);
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
		
		JComboBox cboGenero = new JComboBox();
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
		
		JLabel lblImagen = new JLabel("imagen...");
		lblImagen.setForeground(Color.BLACK);
		lblImagen.setBounds(279, 208, 194, 153);
		panel.add(lblImagen);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiarContraseña cm =new CambiarContraseña();
				cm.setVisible(true);
			}
		});
		btnCambiar.setBounds(113, 273, 89, 23);
		panel.add(btnCambiar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Datos Actualizados");
			}
		});
		btnActualizar.setBounds(203, 415, 104, 23);
		contentPane.add(btnActualizar);
	}

}
