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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
<<<<<<< HEAD

=======
import utils.Timer;
>>>>>>> davos

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

<<<<<<< HEAD

	public Cliente cliente;
	static private Login dialog;
	public int num;
	
	

=======
	public Cliente cliente;
	public int num;
	static public Login dialog;
	static public JLabel lblCounter;
>>>>>>> davos

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			Login dialog = new Login();

			dialog = new Login();
<<<<<<< HEAD

			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
=======
			
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			initThread();
>>>>>>> davos
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
<<<<<<< HEAD
		lblUsuario.setBounds(72, 83, 46, 14);
		contentPanel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(149, 80, 86, 20);
=======
		lblUsuario.setBounds(72, 83, 97, 14);
		contentPanel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(179, 78, 86, 20);
>>>>>>> davos
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
<<<<<<< HEAD
		lblContrasea.setBounds(72, 114, 72, 14);
		contentPanel.add(lblContrasea);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(149, 111, 86, 17);
=======
		lblContrasea.setBounds(72, 114, 97, 14);
		contentPanel.add(lblContrasea);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(179, 109, 86, 17);
>>>>>>> davos
		contentPanel.add(txtContraseña);
		
		JComboBox cboElije = new JComboBox();
		cboElije.setModel(new DefaultComboBoxModel(new String[] {"Ciente", "Empresa"}));
		cboElije.setSelectedIndex(-1);
		cboElije.setBounds(72, 150, 86, 20);
		contentPanel.add(cboElije);
		
		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});

<<<<<<< HEAD
		lblNewLabel.setBounds(27, 203, 86, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblTimer = new JLabel("timer");
		lblTimer.setBounds(10, 11, 46, 14);
		contentPanel.add(lblTimer);
		
		JLabel lblCounter = new JLabel("counter");
		lblCounter.setBounds(67, 37, 46, 14);
		contentPanel.add(lblCounter);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
=======
		lblNewLabel.setBounds(12, 209, 86, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblTimer = new JLabel("La ventana se cerrará en");
		lblTimer.setBounds(100, 19, 208, 14);
		contentPanel.add(lblTimer);
		
		lblCounter = new JLabel("10");
		lblCounter.setBounds(274, 19, 31, 14);
		contentPanel.add(lblCounter);
		
		JLabel lblNewLabel_1 = new JLabel("Imagen");
>>>>>>> davos
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
						
<<<<<<< HEAD
						int usu;
						String con;
						usu = Integer.parseInt(txtUsuario.getText());
						con = txtContraseña.getText();
						
						try {
							ClientModel cli = new ClientModel();
							cliente = cli.getClient(usu);							
=======
						int usu, dni;
						String con;
						usu = Integer.parseInt(txtUsuario.getText());
						con = txtContraseña.getText();
						System.out.println(usu);
						System.out.println(con);
						
						// Instanciando modelos
						ClientModel cli = new ClientModel();
						
						try {
							cliente = cli.getClient(usu);	
							cliente.getDni();
							cliente.getPassword();
>>>>>>> davos
							if (num==0){ 
								frmPrincipal frm = new frmPrincipal();
								frm.setVisible(true);
								dialog.dispose();
								
							}	
							else if(num==1){
								frmPrincipal frm = new frmPrincipal();
								frm.setVisible(true);
								dialog.dispose();
							}
<<<<<<< HEAD
							else if(num==-1)
								JOptionPane.showMessageDialog(null,"No existe ni cliente,Ni un usuario");
=======
							else JOptionPane.showMessageDialog(null,"No existe ni cliente, Ni un usuario");
>>>>>>> davos
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,"Ingrese sus Datos Correctamente");
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

<<<<<<< HEAD
						int num=0;
						num = cboElije.getSelectedIndex();
						if (num==1) {
							
						}else {
							
						}
						
					

						num=cboElije.getSelectedIndex();
						if (num==1) {
							RegistroEmpresa rgempre = new RegistroEmpresa();
							rgempre.setVisible(true);
						}else if(num==0){
=======
						int num=cboElije.getSelectedIndex();
						
						if (num == 1) {
							RegistroEmpresa rgempre = new RegistroEmpresa();
							rgempre.setVisible(true);
						} else if( num == 0){
>>>>>>> davos
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
	
<<<<<<< HEAD
=======
	static void initThread() {
		Timer counter = new Timer();
		counter.start();
		try {
			counter.startCounter();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
>>>>>>> davos

}
