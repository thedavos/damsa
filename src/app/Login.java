package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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


		
		setTitle("Login");

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(72, 83, 97, 14);
		contentPanel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(179, 78, 86, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(72, 114, 97, 14);
		contentPanel.add(lblContrasea);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(179, 109, 86, 17);
		contentPanel.add(txtContraseña);
		
		JComboBox cboElije = new JComboBox();
		cboElije.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Empresa"}));
		cboElije.setSelectedIndex(-1);
		cboElije.setBounds(72, 150, 86, 20);
		contentPanel.add(cboElije);
		
		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});

		lblNewLabel.setBounds(12, 209, 86, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblTimer = new JLabel("La ventana se cerrará en");
		lblTimer.setBounds(100, 19, 208, 14);
		contentPanel.add(lblTimer);
		
		lblCounter = new JLabel("10");
		lblCounter.setBounds(274, 19, 31, 14);
		contentPanel.add(lblCounter);
		
		JLabel lblNewLabel_1 = new JLabel("Imagen");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(245, 45, 179, 136);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnIngresar = new JButton("Ingresar");


				btnIngresar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						int usuario = 0;
						String cod = null, password = null;
						
						int tipoUsuario=cboElije.getSelectedIndex();
						String userInput = txtUsuario.getText();
						password = txtContraseña.getText();
						
						if (Validation.isNumeric(userInput)) {
							usuario = Integer.parseInt(userInput);
						} else {
							cod = userInput;
						}
						
						try {
							switch (tipoUsuario) {
								case 0:
									ClientModel cli = new ClientModel();
									cliente = usuario == 0 ? cli.getClient(cod) : cli.getClient(usuario);
									System.out.println(cliente);
									openMenu(cliente, cod != null ? cod : usuario, tipoUsuario, password);
									break;
								case 1:
									EnterpriseModel em = new EnterpriseModel();
									empresa = usuario == 0 ? em.getEnterprise((Object)cod) : em.getEnterprise(usuario + "");
									System.out.println(empresa);
									openMenu(empresa, cod != null ? cod : usuario + "", tipoUsuario, password);
									break;
								default:
									JOptionPane.showMessageDialog(null, "Ingrese un tipo de usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
									break;
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
							JOptionPane.showMessageDialog(null, "Ingrese sus Datos Correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				});

				btnIngresar.setActionCommand("OK");
				buttonPane.add(btnIngresar);
				getRootPane().setDefaultButton(btnIngresar);
			}
			{
				JButton btnRegistra = new JButton("Registrar");
				btnRegistra.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						int num=cboElije.getSelectedIndex();
						
						if (num == 1) {
							RegistroEmpresa rgempre = new RegistroEmpresa();
							rgempre.setVisible(true);
						} else if( num == 0){
							RegistroCliente rgcli = new RegistroCliente();
							rgcli.setVisible(true);
						}
						else
							JOptionPane.showMessageDialog(null,"Seleccione que tipo de Usuario es: ");				

					}
				});
				btnRegistra.setActionCommand("Cancel");
				buttonPane.add(btnRegistra);
			}
		}
		
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
	
	static void initThread() {
		Timer counter = new Timer();
		counter.start();
		try {
			counter.startCounter(dialog);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
