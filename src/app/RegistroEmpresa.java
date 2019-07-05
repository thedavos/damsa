package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import clases.Empresa;
import models.EnterpriseModel;
import utils.Encryption;
import utils.FileManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class RegistroEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtRUC;
	private JTextField txtPassword;
	private JTextField txtDirecc;
	private JTextField txtConfirmPassword;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JLabel lblNombre;
	private JLabel lblConfirmarContrasea;
	private JTextField txtCelular;
	private File fileSelected = null;
	private JLabel lblImagen;

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
		setResizable(false);
		
		
		setTitle("Registro Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 817, 426);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JLabel lblRuc = new JLabel("RUC");
		lblRuc.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblRuc.setHorizontalAlignment(SwingConstants.CENTER);
		lblRuc.setBounds(10, 100, 161, 20);
		contentPane.add(lblRuc);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(181, 60, 340, 20);
		contentPane.add(txtName);
		
		JLabel label_1 = new JLabel("Contrase\u00F1a");
		label_1.setFont(new Font("Georgia", Font.PLAIN, 13));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 140, 161, 20);
		contentPane.add(label_1);
		
		txtRUC = new JTextField();
		txtRUC.setColumns(10);
		txtRUC.setBounds(181, 100, 206, 20);
		contentPane.add(txtRUC);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos solicitados");
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseLosDatos.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblIngreseLosDatos.setBounds(21, 20, 241, 20);
		contentPane.add(lblIngreseLosDatos);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(181, 140, 206, 20);
		contentPane.add(txtPassword);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setBounds(10, 220, 161, 20);
		contentPane.add(lblDireccion);
		
		txtDirecc = new JTextField();
		txtDirecc.setColumns(10);
		txtDirecc.setBounds(181, 220, 340, 20);
		contentPane.add(txtDirecc);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setBounds(10, 260, 161, 20);
		contentPane.add(lblCorreo);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBounds(181, 180, 206, 20);
		contentPane.add(txtConfirmPassword);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setBounds(10, 300, 161, 20);
		contentPane.add(lblTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(181, 260, 340, 20);
		contentPane.add(txtEmail);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblCelular.setHorizontalAlignment(SwingConstants.CENTER);
		lblCelular.setBounds(274, 300, 161, 20);
		contentPane.add(lblCelular);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(181, 300, 113, 20);
		contentPane.add(txtTelefono);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnterpriseModel em = new EnterpriseModel();
				String password = txtPassword.getText();
				String confirmPassword = txtConfirmPassword.getText();
				
				if (!password.equals(confirmPassword)) {
					JOptionPane.showMessageDialog(null,"Contraseñas no coinciden");
					return;
				}
				
				Empresa empresa = new Empresa(
						txtRUC.getText(),
						txtName.getText(),
						txtEmail.getText(),
						txtDirecc.getText(),
						Integer.parseInt(txtTelefono.getText()),
						Integer.parseInt(txtCelular.getText())
				);
				
				try {
					empresa.setPassword(Encryption.SHA1(password));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				if(fileSelected != null && empresa != null) {
					empresa.saveFile(fileSelected, empresa.getFolder() + "/");
					empresa.setProfileUrl(empresa.getDownload(empresa.getFolder(), fileSelected.getName()));
				} 
				
				if (em.createEnterprise(empresa) != 0) {
					JOptionPane.showMessageDialog(null,"La empresa con el código: " + empresa.getCode() + " ha sido registrado exitosamente");
					
					Login l =new Login();
					l.setVisible(true);
					dispose();
				}
				
				
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(292, 348, 113, 23);
		contentPane.add(btnAceptar);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(10, 60, 161, 20);
		contentPane.add(lblNombre);
		
		lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmarContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarContrasea.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblConfirmarContrasea.setBounds(10, 180, 161, 20);
		contentPane.add(lblConfirmarContrasea);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(408, 300, 113, 20);
		contentPane.add(txtCelular);
		
		lblImagen = new JLabel("imagen");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImagen.setBounds(584, 60, 181, 140);
		contentPane.add(lblImagen);
		
		JButton btnSubir = new JButton("Subir Logo");
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fileSelected = FileManager.openFileSystem(1);
				String filePath = null;
				
				try {
					filePath = fileSelected.getPath();
					
					if (filePath != null) {
						ImageIcon iconResized = FileManager.ResizeImageIcon(filePath, 180, 180);
						lblImagen.setIcon(iconResized);
					}
				} catch (NullPointerException err) {
					System.err.println(err);
				} catch (Exception err) {
					 JOptionPane.showMessageDialog(null, "Ups! Error abriendo la imagen " + err);
				}
			}
		});
		btnSubir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSubir.setBounds(618, 236, 113, 23);
		contentPane.add(btnSubir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l =new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(432, 348, 113, 23);
		contentPane.add(btnCancelar);
	}
}
