package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.css.Counter;

import javax.swing.JLabel;

import javax.swing.JMenu;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import app.*;
import models.*;
import clases.Cliente;
import clases.Empresa;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import utils.Timer;
import utils.Validation;
import java.awt.Font;
import java.awt.Color;
import java.awt.Label;
import javax.swing.ImageIcon;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	public Cliente cliente;
	public Empresa empresa;
	
	static public Login dialog = new Login();
	static public JLabel lblCounter;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setVisible(true);
			initThread();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setResizable(false);

		
		setTitle("Login");
		
		setLocationRelativeTo(null);

		setBounds(100, 100, 521, 291);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// UTILIZADO PARA CENTRAR EL GUI
		setLocationRelativeTo(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblUsuario.setBounds(21, 62, 97, 19);
		contentPanel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(139, 62, 131, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblContrasea.setBounds(21, 107, 97, 19);
		contentPanel.add(lblContrasea);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(139, 107, 131, 19);
		contentPanel.add(txtContraseña);
		
		JComboBox cboElije = new JComboBox();
		cboElije.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Empresa"}));
		cboElije.setSelectedIndex(-1);
		cboElije.setBounds(139, 154, 131, 20);
		contentPanel.add(cboElije);
		
		JLabel lblNewLabel = new JLabel("admin..");
		lblNewLabel.setForeground(new Color(0, 102, 204));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Administrador a = new Administrador();
				a.setVisible(true);
				dispose();
				
			}
		});

		lblNewLabel.setBounds(10, 214, 86, 20);
		contentPanel.add(lblNewLabel);
		
		JLabel lblTimer = new JLabel("La ventana se cerrar\u00E1 en : ");
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblTimer.setBounds(98, 19, 205, 22);
		contentPanel.add(lblTimer);
		
		lblCounter = new JLabel("");
		lblCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCounter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCounter.setBounds(278, 19, 50, 22);
		contentPanel.add(lblCounter);
		
		JLabel lblNewLabel_1 = new JLabel("Imagen");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/images/imagenes/Llave.jpg")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(292, 49, 179, 136);
		contentPanel.add(lblNewLabel_1);
		
		JButton button = new JButton("Ingresar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setIcon(new ImageIcon(Login.class.getResource("/images/iconos22x22/dialog-accept.png")));
		button.setActionCommand("OK");
		button.setBounds(214, 208, 114, 29);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("Registrar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int a = cboElije.getSelectedIndex();
				
				if(a ==0)
				{
					RegistroCliente cl = new RegistroCliente();
					cl.setVisible(true);
					dispose();
				}else if (a == 1)
				{
					RegistroEmpresa em = new RegistroEmpresa();
					em.setVisible(true);
					dispose();
				}else
				{
					JOptionPane.showMessageDialog(null, "Eliga una opcion");
				}
				
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_1.setIcon(new ImageIcon(Login.class.getResource("/images/iconos22x22/user-new-3.png")));
		button_1.setActionCommand("Cancel");
		button_1.setBounds(346, 208, 114, 29);
		contentPanel.add(button_1);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de Usuario :");
		lblTipoDeUsuario.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblTipoDeUsuario.setBounds(21, 154, 132, 19);
		contentPanel.add(lblTipoDeUsuario);
		
	}
	
	void openMenu(Cliente cliente, Object usuario, int tipoUsuario, String password) {
		if (Validation.isClientValid(cliente, usuario, password) && tipoUsuario != -1) {
			frmPrincipal frm = new frmPrincipal();
			frm.setVisible(true);
			dialog.dispose();
		}
		else JOptionPane.showMessageDialog(null,"No existe ni cliente, Ni un usuario");
	}
	
	void openMenu(Empresa empresa, String usuario, int tipoUsuario, String password) {
		if (Validation.isEnterpriseValid(empresa, usuario, password) && tipoUsuario != -1) {
			frmPrincipal frm = new frmPrincipal();
			frm.setVisible(true);
			dialog.dispose();
		}
		else JOptionPane.showMessageDialog(null,"No existe ni empresa, Ni un usuario");
	}
	
	public static void initThread() {
		Timer counter = new Timer();
		counter.start();
		try {
			counter.startCounter(dialog);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
