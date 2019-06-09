package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistroEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField txtRuc;
	private JTextField txtContra;
	private JTextField txtNomb;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtTelefon;
	private JTextField txtcelular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroEmpresa frame = new RegistroEmpresa();
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
	public RegistroEmpresa() {
<<<<<<< HEAD
<<<<<<< HEAD
		setTitle("Registro Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
=======
		setTitle("Registro Empresa");		
>>>>>>> master
=======
		setTitle("Registro Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

>>>>>>> davos
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRuc = new JLabel("RUC");
		lblRuc.setBounds(31, 26, 46, 14);
		contentPane.add(lblRuc);
		
		txtRuc = new JTextField();
		txtRuc.setColumns(10);
		txtRuc.setBounds(95, 23, 86, 20);
		contentPane.add(txtRuc);
		
		JLabel label_1 = new JLabel("Contrase\u00F1a");
		label_1.setBounds(201, 26, 86, 14);
		contentPane.add(label_1);
		
		txtContra = new JTextField();
		txtContra.setColumns(10);
		txtContra.setBounds(277, 23, 86, 20);
		contentPane.add(txtContra);
		
		JLabel label_2 = new JLabel("Nombres");
		label_2.setBounds(31, 67, 69, 14);
		contentPane.add(label_2);
		
		txtNomb = new JTextField();
		txtNomb.setColumns(10);
		txtNomb.setBounds(95, 64, 86, 20);
		contentPane.add(txtNomb);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(213, 70, 69, 14);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(277, 67, 86, 20);
		contentPane.add(txtDireccion);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(31, 98, 69, 14);
		contentPane.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(95, 95, 86, 20);
		contentPane.add(txtCorreo);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(213, 101, 69, 14);
		contentPane.add(lblTelefono);
		
		txtTelefon = new JTextField();
		txtTelefon.setColumns(10);
		txtTelefon.setBounds(277, 98, 86, 20);
		contentPane.add(txtTelefon);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(31, 140, 69, 14);
		contentPane.add(lblCelular);
		
		txtcelular = new JTextField();
		txtcelular.setColumns(10);
		txtcelular.setBounds(95, 137, 86, 20);
		contentPane.add(txtcelular);
		
		JButton btnaceptar = new JButton("Aceptar");
		btnaceptar.setBounds(162, 180, 89, 23);
		contentPane.add(btnaceptar);
	}

}
