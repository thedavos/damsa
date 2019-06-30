package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import utils.Timer;

public class Administrador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Administrador dialog = new Administrador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Administrador() {
		
		
		
		setTitle("ADMINISTRADOR");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 368, 195);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		setLocationRelativeTo(null);
		
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblUsuario.setBounds(22, 21, 101, 20);
		contentPanel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblContrasea.setBounds(22, 71, 101, 20);
		contentPanel.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(133, 21, 142, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(133, 71, 142, 20);
		contentPanel.add(txtContraseña);
		
		JButton button = new JButton("Ingresar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Accceso correcto");
				System.exit(0);
			}
		});
		button.setIcon(new ImageIcon(Administrador.class.getResource("/images/iconos22x22/dialog-accept.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBounds(45, 116, 122, 31);
		button.setActionCommand("OK");
		contentPanel.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					cancelar();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
		button_1.setIcon(new ImageIcon(Administrador.class.getResource("/images/iconos22x22/dialog-cancel-3.png")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBounds(189, 116, 132, 31);
		button_1.setActionCommand("Cancel");
		contentPanel.add(button_1);
	}
	
	
	void cancelar() throws Throwable
	{
		Timer counter = new Timer();
		Login login = new Login();

		dispose();
		// counter.start();
		
		login.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		login.setVisible(true);
		
		// Login.initThread();
	}
	
}
