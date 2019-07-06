package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Desarrolladores extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Desarrolladores frame = new Desarrolladores();
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
	public Desarrolladores() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		setTitle("Desarrolladores");
		
		setBounds(100, 100, 487, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVargasDominguesD = new JLabel("Vargas Domingues David");
		lblVargasDominguesD.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblVargasDominguesD.setHorizontalAlignment(SwingConstants.CENTER);
		lblVargasDominguesD.setBounds(135, 56, 175, 27);
		contentPane.add(lblVargasDominguesD);
		
		JLabel lblRosarioMirandaSnayder = new JLabel("Rosario Miranda Snayder");
		lblRosarioMirandaSnayder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblRosarioMirandaSnayder.setHorizontalAlignment(SwingConstants.CENTER);
		lblRosarioMirandaSnayder.setBounds(135, 101, 175, 27);
		contentPane.add(lblRosarioMirandaSnayder);
		
		JLabel lblSanchezRivasAbel = new JLabel("Sanchez Rivas Abel");
		lblSanchezRivasAbel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblSanchezRivasAbel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSanchezRivasAbel.setBounds(135, 146, 175, 27);
		contentPane.add(lblSanchezRivasAbel);
		
		JLabel lblCanoVarasMisael = new JLabel("Cano Varas Misael");
		lblCanoVarasMisael.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblCanoVarasMisael.setHorizontalAlignment(SwingConstants.CENTER);
		lblCanoVarasMisael.setBounds(135, 191, 175, 27);
		contentPane.add(lblCanoVarasMisael);
		
		JLabel lblLeccaAltamiranoFlor = new JLabel("Lecca Altamirano Flor ");
		lblLeccaAltamiranoFlor.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblLeccaAltamiranoFlor.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeccaAltamiranoFlor.setBounds(135, 236, 175, 27);
		contentPane.add(lblLeccaAltamiranoFlor);
		
		JLabel lblDesarrolladores = new JLabel("Desarrolladores");
		lblDesarrolladores.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesarrolladores.setForeground(new Color(75, 0, 130));
		lblDesarrolladores.setBackground(new Color(72, 61, 139));
		lblDesarrolladores.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblDesarrolladores.setBounds(135, 18, 186, 27);
		contentPane.add(lblDesarrolladores);
		
		JLabel lblContactanos = new JLabel("Cont\u00E1ctanos");
		lblContactanos.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		lblContactanos.setBounds(36, 272, 114, 14);
		contentPane.add(lblContactanos);
		
		JLabel lblDamsegmailcom = new JLabel("damse@gmail.com");
		lblDamsegmailcom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDamsegmailcom.setBounds(118, 296, 149, 27);
		contentPane.add(lblDamsegmailcom);
	}
}
