package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import app.*;
import clases.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class Materialesingreso extends JFrame {

	private JPanel contentPane;
	private JTextField txtPeso;
	private JTextField txtPrecioEstimado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Materialesingreso frame = new Materialesingreso();
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
	public Materialesingreso() {
		setTitle("Ingreso de Materiales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 359);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMaterial = new JLabel("Tipo");
		lblMaterial.setBounds(22, 41, 46, 14);
		contentPane.add(lblMaterial);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(22, 76, 46, 14);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(116, 83, 109, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JComboBox cboMaterial = new JComboBox();
		cboMaterial.setModel(new DefaultComboBoxModel(new String[] {"Plastico", "Carton", "Vidrio", "Metal"}));
		cboMaterial.setBounds(116, 48, 109, 20);
		contentPane.add(cboMaterial);
		
		JLabel lblJjjj = new JLabel("Estado:");
		lblJjjj.setBounds(22, 114, 46, 14);
		contentPane.add(lblJjjj);
		
		JLabel lblPrecioEstimado = new JLabel("Precio estimado:");
		lblPrecioEstimado.setBounds(22, 153, 84, 14);
		contentPane.add(lblPrecioEstimado);
		
		txtPrecioEstimado = new JTextField();
		txtPrecioEstimado.setBounds(116, 150, 109, 20);
		contentPane.add(txtPrecioEstimado);
		txtPrecioEstimado.setColumns(10);
		
		JLabel lblJpg = new JLabel("Jpg....");
		lblJpg.setBounds(416, 86, 46, 14);
		contentPane.add(lblJpg);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(Materialesingreso.class.getResource("/images/iconos22x22/disco-flexible.png")));
		btnGuardar.setBounds(116, 267, 112, 42);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(Materialesingreso.class.getResource("/images/iconos22x22/cancelar.png")));
		btnCancelar.setBounds(304, 267, 112, 42);
		contentPane.add(btnCancelar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Optimo", "Regular", "Malo"}));
		comboBox.setBounds(116, 114, 109, 20);
		contentPane.add(comboBox);
	}
}
