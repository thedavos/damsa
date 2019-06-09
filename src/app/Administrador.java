package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Administrador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
<<<<<<< HEAD
	private JPasswordField txtContraseña;
=======
	private JPasswordField txtContraseÃ±a;
>>>>>>> davos

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
		setBounds(100, 100, 450, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(35, 36, 46, 14);
		contentPanel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(35, 86, 75, 14);
		contentPanel.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(122, 33, 86, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
<<<<<<< HEAD
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(120, 83, 91, 20);
		contentPanel.add(txtContraseña);
=======
		txtContraseÃ±a = new JPasswordField();
		txtContraseÃ±a.setBounds(120, 83, 91, 20);
		contentPanel.add(txtContraseÃ±a);
>>>>>>> davos
		
		JLabel label = new JLabel("");
		label.setBounds(240, 11, 184, 123);
		contentPanel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ingresar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
