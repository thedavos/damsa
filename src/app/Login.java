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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(72, 83, 46, 14);
		contentPanel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(149, 80, 86, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(72, 114, 72, 14);
		contentPanel.add(lblContrasea);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(149, 111, 86, 17);
		contentPanel.add(txtContraseña);
		
		JComboBox cboElije = new JComboBox();
		cboElije.setModel(new DefaultComboBoxModel(new String[] {"Ciente", "Empresa"}));
		cboElije.setSelectedIndex(-1);
		cboElije.setBounds(72, 150, 86, 20);
		contentPanel.add(cboElije);
		
		
		
		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.setBounds(27, 203, 86, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblTimer = new JLabel("timer");
		lblTimer.setBounds(10, 11, 46, 14);
		contentPanel.add(lblTimer);
		
		JLabel lblCounter = new JLabel("counter");
		lblCounter.setBounds(67, 37, 46, 14);
		contentPanel.add(lblCounter);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(245, 45, 179, 136);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnIngresar = new JButton("Ingresar");
				btnIngresar.setActionCommand("OK");
				buttonPane.add(btnIngresar);
				getRootPane().setDefaultButton(btnIngresar);
			}
			{
				JButton btnRegistra = new JButton("Registrar");
				btnRegistra.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int num=0;
						num = cboElije.getSelectedIndex();
						if (num==1) {
							
						}else {
							
						}
						
					
					}
				});
				btnRegistra.setActionCommand("Cancel");
				buttonPane.add(btnRegistra);
			}
		}
		
	}
	
	
}
