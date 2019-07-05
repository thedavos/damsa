package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.*;
import models.AdminModel;
import models.ClientModel;
import models.EnterpriseModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class CambiarContrasena extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JLabel lblContraseaActual;
	private JLabel lblContraseaNueva;
	private JLabel lblConfirmarNueva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambiarContrasena frame = new CambiarContrasena();
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
	public CambiarContrasena() {}
	public CambiarContrasena(Cliente cliente) {
		doDesign();
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				ClientModel cm = new ClientModel();
				
				String newPassword = passwordField_1.getText();
				String actualPassword = passwordField.getText();
				String passwordConfirmed = passwordField_2.getText(); 
				
				if (newPassword.equals(passwordConfirmed)) {
					cliente.setPassword(newPassword);
					cm.updatePassword(cliente, cliente.getDni());
					
					if (result != 0) {
						JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Error al actualizar datos");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "La contraseña nueva no coincide con la contraseña confirmada");
				}
			}
		});
		btnAceptar.setBounds(197, 136, 89, 23);
		contentPane.add(btnAceptar);
	}
	
	public CambiarContrasena(Empresa empresa) {
		doDesign();
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				EnterpriseModel em = new EnterpriseModel();
				
				String newPassword = passwordField_1.getText();
				String actualPassword = passwordField.getText();
				String passwordConfirmed = passwordField_2.getText(); 
				
				if (newPassword.equals(passwordConfirmed)) {
					empresa.setPassword(newPassword);
					em.updatePassword(empresa, empresa.getRuc());
					
					if (result != 0) {
						JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Error al actualizar datos");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "La contraseña nueva no coincide con la contraseña confirmada");
				}
			}
		});
		btnAceptar.setBounds(197, 136, 89, 23);
		contentPane.add(btnAceptar);
	}
	
	public CambiarContrasena(Admin admin) {
		doDesign();
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				AdminModel am = new AdminModel();
				String newPassword = passwordField_1.getText();
				String actualPassword = passwordField.getText();
				String passwordConfirmed = passwordField_2.getText(); 
				
				if (newPassword.equals(passwordConfirmed)) {
					admin.setPassword(newPassword);
					am.updatePassword(admin, admin.getDni());
					
					if (result != 0) {
						JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Error al actualizar datos");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "La contraseña nueva no coincide con la contraseña confirmada");
				}
				
			}
		});
		btnAceptar.setBounds(197, 136, 89, 23);
		contentPane.add(btnAceptar);
	}
	
	void doDesign() {
		setResizable(false);
		setTitle("Cambiar Contrase\u00F1a");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 344, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblContraseaActual = new JLabel("Contrase\u00F1a Actual");
		lblContraseaActual.setBounds(21, 25, 106, 14);
		contentPane.add(lblContraseaActual);
		
		lblContraseaNueva = new JLabel("Contrase\u00F1a Nueva");
		lblContraseaNueva.setBounds(21, 61, 106, 14);
		contentPane.add(lblContraseaNueva);

		lblConfirmarNueva.setBounds(21, 102, 134, 14);
		contentPane.add(lblConfirmarNueva);
		
		JLabel lblNewLabel = new JLabel("Nueva");
		lblNewLabel.setBounds(81, 118, 46, 14);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 25, 134, 23);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(170, 61, 134, 23);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(170, 102, 134, 23);
		contentPane.add(passwordField_2);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(CambiarContrasena.class.getResource("/images/iconos22x22/dialog-cancel-3.png")));
		btnCancelar.setBounds(182, 162, 116, 23);
		contentPane.add(btnCancelar);
	}
}
