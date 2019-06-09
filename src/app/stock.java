package src.app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class stock extends JFrame {

	private JPanel contentPane;
	static public stock dialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stock frame = new stock();
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
	public stock() {
		setResizable(false);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCompraYVenta = new JLabel("compra y Venta ");
		lblCompraYVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompraYVenta.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCompraYVenta.setBounds(140, 95, 190, 74);
		contentPane.add(lblCompraYVenta);
	}
}
