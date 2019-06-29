package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CambiarContraseña extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambiarContraseña frame = new CambiarContraseña();
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
	public CambiarContraseña() {
		setResizable(false);
		setTitle("Cambiar Contrase\u00F1a");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 313, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContraseaActual = new JLabel("Contrase\u00F1a Actual");
		lblContraseaActual.setBounds(21, 25, 106, 14);
		contentPane.add(lblContraseaActual);
		
		JLabel lblContraseaNueva = new JLabel("Contrase\u00F1a Nueva");
		lblContraseaNueva.setBounds(21, 61, 106, 14);
		contentPane.add(lblContraseaNueva);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
				dispose();
			}
		});
		btnAceptar.setBounds(197, 136, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblConfirmarNueva = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmarNueva.setBounds(21, 102, 134, 14);
		contentPane.add(lblConfirmarNueva);
		
		JLabel lblNewLabel = new JLabel("Nueva");
		lblNewLabel.setBounds(81, 118, 46, 14);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 25, 116, 23);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(170, 61, 116, 23);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(170, 102, 116, 23);
		contentPane.add(passwordField_2);
	}
}
