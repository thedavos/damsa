package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RegistroEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField txtRuc;
	private JTextField txtContra;
	private JTextField txtNomb;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtTelefon;
	private JTextField txtcelular;
	private JLabel label;
	private JLabel lblConfirmarContrasea;

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
		setTitle("Registro Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 614, 463);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRuc = new JLabel("RUC");
		lblRuc.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblRuc.setHorizontalAlignment(SwingConstants.CENTER);
		lblRuc.setBounds(10, 100, 161, 20);
		contentPane.add(lblRuc);
		
		txtRuc = new JTextField();
		txtRuc.setColumns(10);
		txtRuc.setBounds(181, 60, 254, 20);
		contentPane.add(txtRuc);
		
		JLabel label_1 = new JLabel("Contrase\u00F1a");
		label_1.setFont(new Font("Georgia", Font.PLAIN, 13));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 140, 161, 20);
		contentPane.add(label_1);
		
		txtContra = new JTextField();
		txtContra.setColumns(10);
		txtContra.setBounds(181, 100, 254, 20);
		contentPane.add(txtContra);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos solicitados");
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseLosDatos.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblIngreseLosDatos.setBounds(21, 20, 241, 20);
		contentPane.add(lblIngreseLosDatos);
		
		txtNomb = new JTextField();
		txtNomb.setColumns(10);
		txtNomb.setBounds(181, 140, 161, 20);
		contentPane.add(txtNomb);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setBounds(10, 220, 161, 20);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(181, 220, 254, 20);
		contentPane.add(txtDireccion);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setBounds(10, 260, 161, 20);
		contentPane.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(181, 180, 161, 20);
		contentPane.add(txtCorreo);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setBounds(10, 300, 161, 20);
		contentPane.add(lblTelefono);
		
		txtTelefon = new JTextField();
		txtTelefon.setColumns(10);
		txtTelefon.setBounds(386, 246, 86, 20);
		contentPane.add(txtTelefon);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblCelular.setHorizontalAlignment(SwingConstants.CENTER);
		lblCelular.setBounds(10, 340, 161, 20);
		contentPane.add(lblCelular);
		
		txtcelular = new JTextField();
		txtcelular.setColumns(10);
		txtcelular.setBounds(204, 297, 86, 20);
		contentPane.add(txtcelular);
		
		JButton btnaceptar = new JButton("Aceptar");
		btnaceptar.setBounds(30, 380, 89, 23);
		contentPane.add(btnaceptar);
		
		label = new JLabel("Nombres");
		label.setFont(new Font("Georgia", Font.PLAIN, 13));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 60, 161, 20);
		contentPane.add(label);
		
		lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmarContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarContrasea.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblConfirmarContrasea.setBounds(10, 180, 161, 20);
		contentPane.add(lblConfirmarContrasea);
	}

}
