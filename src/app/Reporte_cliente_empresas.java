package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.Cliente;
import clases.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.ActionEvent;

public class Reporte_cliente_empresas extends JFrame {

	private JPanel contentPane;
	private JTable Clientes;
	private JTable Empresas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte_cliente_empresas frame = new Reporte_cliente_empresas();
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
	public Reporte_cliente_empresas() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		setResizable(false);
		setTitle("Ver Clientes y Empresas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1154, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Clientes :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 30, 137, 22);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 82, 1113, 213);
		contentPane.add(scrollPane);
		
		Clientes = new JTable();
		Clientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Dni", "Nombre", "Apellidos", "Creado", "Modificado", "Edad", "Genero", "Direccion", "Correo", "Telefono", "Celular", "Ver Imagen", "Esatdo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		scrollPane.setViewportView(Clientes);
		
		JLabel lblEmpresas = new JLabel("Empresas :");
		lblEmpresas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresas.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblEmpresas.setBounds(10, 325, 137, 22);
		contentPane.add(lblEmpresas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(17, 377, 1113, 213);
		contentPane.add(scrollPane_1);
		
		Empresas = new JTable();
		Empresas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Ruc", "Nombre", "Creado", "Modificado", "Direecion", "Correo", "Telefono", "Celular", "Ver Imagen", "Estado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Empresas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane_1.setViewportView(Empresas);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmPrincipal p = new frmPrincipal();
				p.setVisible(true);
				dispose();
			}
		});
		btnAceptar.setBounds(299, 629, 137, 23);
		contentPane.add(btnAceptar);
		
		JButton btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.setBounds(505, 629, 137, 23);
		contentPane.add(btnGenerarReporte);
		
		JButton btnVerReporte = new JButton("Ver Reporte");
		btnVerReporte.setBounds(709, 629, 137, 23);
		contentPane.add(btnVerReporte);
		

	}
}
