package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.SystemColor;
import utils.*;
import app.*;
import clases.*;
import models.AdminModel;
import models.ClientModel;
import models.EnterpriseModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class frmPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblusuario;
	private static frmPrincipal frame = new frmPrincipal();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	
	public frmPrincipal() {
		setResizable(false);
		setBounds(100, 100, 1375, 740);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setLocationRelativeTo(null);
		getContentPane().setLayout(null);


		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 629, 1387, 55);
		getContentPane().add(panel);
		
		lblusuario = new JLabel("");
		lblusuario.setBounds(10, 11, 291, 34);
		lblusuario.setForeground(Color.BLUE);
		lblusuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblusuario.setBackground(Color.GREEN);
		
		lblusuario.setText("USUARIO: " + Usuario);
		
		lblhora = new JLabel("HORA");
		lblhora.setHorizontalAlignment(SwingConstants.CENTER);
		lblhora.setBounds(1050, 11, 167, 34);
		lblhora.setForeground(Color.BLUE);
		lblhora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblhora.setBackground(Color.GREEN);
		
		
		//hilo de la hora -- llamo ala clase hora
		hora hilo= new hora(lblhora);
		panel.setLayout(null);
		panel.add(lblusuario);
		panel.add(lblhora);
		
		lblfecha = new JLabel("FECHA");
		lblfecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblfecha.setBounds(839, 11, 167, 34);
		panel.add(lblfecha);
		lblfecha.setForeground(Color.BLUE);
		lblfecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblfecha.setBackground(Color.GREEN);
		//inicio el hilo
		hilo.start();
		//fecha
		fecha();
		
		
	}
	
	public static String Usuario = "DESCONOCIDO";
	private JLabel lblfecha;
	private JLabel lblhora;
	private JPanel panel;
	
	
	//**********************************************************************************************************************************
	// Menú Admin
	public frmPrincipal(Admin admin) {
		
		setBounds(100, 100, 1375, 740);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		//setResizable(false);
		
		Usuario = admin.getName();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPerfil = new JMenu("Perfil");
		mnPerfil.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/iconos16x16/modificar.png")));
		menuBar.add(mnPerfil);
		
		setLocationRelativeTo(null);
		
		JMenuItem mntmMiperfil = new JMenuItem("MiPerfil");
		mntmMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PerfilAdministrador pc=new PerfilAdministrador(admin);
				pc.setVisible(true);
				dispose();
			}
		});
		mnPerfil.add(mntmMiperfil);
		
		JMenuItem mntmDarseDeBaja = new JMenuItem("Darse de Baja");
		mntmDarseDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int input =JOptionPane.showConfirmDialog(null, "Seguro cerra cuenta", "Eliminar Cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (input==0) {
					
					AdminModel am = new AdminModel();
					
					am.deleteAdmin(admin, admin.getDni());
					
					JOptionPane.showMessageDialog(null, "Cuenta Eliminado");
				}
				else {
					JOptionPane.showMessageDialog(null, "Sin Cambios");
				}
			}
		});
		
		mnPerfil.add(mntmDarseDeBaja);
		
		JMenu mnReporte = new JMenu("Reporte");
		mnReporte.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/iconos16x16/Reporte.png")));
		menuBar.add(mnReporte);
		
		JMenuItem mntmReporteDeCliente = new JMenuItem("Reporte de Cliente y Empresas\r\n");
		mntmMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reporte_cliente_empresas rc = new Reporte_cliente_empresas();
				rc.setVisible(true);
			}
		});
		mnReporte.add(mntmReporteDeCliente);
		
		JMenuItem mntmReporteDeTodos = new JMenuItem("Reporte de todos los materiales donados");
		mnReporte.add(mntmReporteDeTodos);
		
		JMenuItem mntmReporteDeTodas = new JMenuItem("Reporte de todas las sesiones");
		mnReporte.add(mntmReporteDeTodas);
		
		JMenuItem mntmReporteDeBoletas = new JMenuItem("Reporte de Boletas emitidas");
		mnReporte.add(mntmReporteDeBoletas);
		
		JMenu mnNewMenu_1 = new JMenu("Control de Usuario");
		mnNewMenu_1.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/iconos16x16/group.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCrearUsuarioNormal = new JMenuItem("Crear Usuario Normal");
		mntmCrearUsuarioNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrodeCliente rg = new RegistrodeCliente();
				rg.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmCrearUsuarioNormal);
		
		JMenuItem mntmCrearUsuarioEmpresa = new JMenuItem("Crear Usuario Empresa");
		mntmCrearUsuarioEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrodeEmpresa rg = new RegistrodeEmpresa();
				rg.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmCrearUsuarioEmpresa);
		
		JMenuItem mntmVisualizarUsuarios = new JMenuItem("Visualizar Usuarios");
		mnNewMenu_1.add(mntmVisualizarUsuarios);
		
		JMenuItem mntmModificarUsuario = new JMenuItem("Modificar Usuario");
		mnNewMenu_1.add(mntmModificarUsuario);
		
		JMenu mnContacto = new JMenu("Contacto");
		mnContacto.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/iconos16x16/bricks.png")));
		menuBar.add(mnContacto);
		
		JMenuItem mntmDesarrolladores = new JMenuItem("Desarrolladores");
		mntmDesarrolladores.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Desarrolladores de = new Desarrolladores();
				de.setVisible(true);
			}
		});
		mnContacto.add(mntmDesarrolladores);
		
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 629, 1387, 55);
		getContentPane().add(panel);
		
		lblusuario = new JLabel("");
		lblusuario.setBounds(10, 11, 291, 34);
		lblusuario.setForeground(Color.BLUE);
		lblusuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblusuario.setBackground(Color.GREEN);
		
		lblusuario.setText("USUARIO: " + Usuario);
		
		lblhora = new JLabel("HORA");
		lblhora.setHorizontalAlignment(SwingConstants.CENTER);
		lblhora.setBounds(1050, 11, 167, 34);
		lblhora.setForeground(Color.BLUE);
		lblhora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblhora.setBackground(Color.GREEN);
		
		
		//hilo de la hora -- llamo ala clase hora
		hora hilo= new hora(lblhora);
		panel.setLayout(null);
		panel.add(lblusuario);
		panel.add(lblhora);
		
		lblfecha = new JLabel("FECHA");
		lblfecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblfecha.setBounds(839, 11, 167, 34);
		panel.add(lblfecha);
		lblfecha.setForeground(Color.BLUE);
		lblfecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblfecha.setBackground(Color.GREEN);
		//inicio el hilo
		hilo.start();
		//fecha
		fecha();
	}
		void diseno(){
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));	
		
	}
		
		//*************************************************************************************************************************************+
		// Menú Cliente
		public frmPrincipal(Cliente cliente) {
		
		setBounds(100, 100, 1375, 740);
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	        
	    setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		//setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		Usuario = cliente.getName();
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JMenuItem mntmMiperfil = new JMenuItem("MiPerfil");
		mnPerfil.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/iconos16x16/modificar.png")));
		mntmMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PerfilCliente pc=new PerfilCliente(cliente);
				pc.setVisible(true);
				dispose();
			}
		});
		mnPerfil.add(mntmMiperfil);
		
		JMenuItem mntmDarseDeBaja = new JMenuItem("Darse de Baja");
		mntmDarseDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int input =JOptionPane.showConfirmDialog(null, "Seguro cerra cuenta", "Eliminar Cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (input==0) {
					ClientModel cm = new ClientModel();
					
					cm.deleteClient(cliente, cliente.getDni());
					
					JOptionPane.showMessageDialog(null, "Cuenta Eliminado");
				}
				else {
					JOptionPane.showMessageDialog(null, "Sin Cambios");
				}
			}
		});
		mnPerfil.add(mntmDarseDeBaja);
		
		JMenu mnNewMenu = new JMenu("Materiales");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Almacenar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Materialesingreso mi = new Materialesingreso(cliente);
				mi.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmVisualizar = new JMenuItem("Visualizar");
		mnNewMenu.add(mntmVisualizar);
		
		JMenu mnCompraYVenta = new JMenu("Compra y Venta");
		menuBar.add(mnCompraYVenta);
		
		JMenuItem mntmStock = new JMenuItem("Stock");
		mntmStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock s =new Stock();
				s.setVisible(true);
			}
		});
		mnCompraYVenta.add(mntmStock);
		
		JMenu mnReporte = new JMenu("Reporte");
		mnReporte.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/iconos16x16/Reporte.png")));
		menuBar.add(mnReporte);
		
		JMenuItem mntmReporteCompra = new JMenuItem("Reporte Compras");
		mnReporte.add(mntmReporteCompra);
		
		JMenuItem mntmReporteMaterial = new JMenuItem("Reporte Materiales Donados");
		mnReporte.add(mntmReporteMaterial);
		
		JMenu mnContacto = new JMenu("Contacto");
		mnContacto.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/iconos16x16/bricks.png")));
		menuBar.add(mnContacto);
		
		JMenuItem mntmDesarrolladores = new JMenuItem("Desarrolladores");
		mntmDesarrolladores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desarrolladores de = new Desarrolladores();
				de.setVisible(true);
			}
		});
		mnContacto.add(mntmDesarrolladores);
		
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 629, 1387, 55);
		getContentPane().add(panel);
		
		lblusuario = new JLabel("");
		lblusuario.setBounds(10, 11, 291, 34);
		lblusuario.setForeground(Color.BLUE);
		lblusuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblusuario.setBackground(Color.GREEN);
		
		lblusuario.setText("USUARIO: " + Usuario);
		
		lblhora = new JLabel("HORA");
		lblhora.setHorizontalAlignment(SwingConstants.CENTER);
		lblhora.setBounds(1050, 11, 167, 34);
		lblhora.setForeground(Color.BLUE);
		lblhora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblhora.setBackground(Color.GREEN);
		
		
		//hilo de la hora -- llamo ala clase hora
		hora hilo= new hora(lblhora);
		panel.setLayout(null);
		panel.add(lblusuario);
		panel.add(lblhora);
		
		lblfecha = new JLabel("FECHA");
		lblfecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblfecha.setBounds(839, 11, 167, 34);
		panel.add(lblfecha);
		lblfecha.setForeground(Color.BLUE);
		lblfecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblfecha.setBackground(Color.GREEN);
		//inicio el hilo
		hilo.start();
		//fecha
		fecha();
	}
  
		
		
		//********************************************************************************************************************************
		// Menú Empresa
		public frmPrincipal(Empresa empresa) {

		setBounds(100, 100, 1375, 740);
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	        
	    setLocationRelativeTo(null);
	    getContentPane().setLayout(null);
		//setResizable(false);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		Usuario = empresa.getName();
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JMenuItem mntmMiperfil = new JMenuItem("MiPerfil");
		mntmMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PerfilEmpresa pe = new PerfilEmpresa(empresa);
				pe.setVisible(true);
				dispose();
			}
		});
		
		mnPerfil.add(mntmMiperfil);
		
		JMenuItem mntmDarseDeBaja = new JMenuItem("Darse de Baja");
		mntmDarseDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int input =JOptionPane.showConfirmDialog(null, "Seguro cerra cuenta", "Eliminar Cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (input==0) {
					EnterpriseModel em = new EnterpriseModel();
					
					em.deleteEnterprise(empresa, empresa.getRuc());
					
					JOptionPane.showMessageDialog(null, "Cuenta Eliminado");
				}
				else {
					JOptionPane.showMessageDialog(null, "Sin Cambios");
				}
			}
		});
		mnPerfil.add(mntmDarseDeBaja);
		
		JMenu mnNewMenu = new JMenu("Materiales");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Almacenar");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmVisualizar = new JMenuItem("Visualizar");
		mnNewMenu.add(mntmVisualizar);
		
		JMenu mnCompraYVenta = new JMenu("Compra y Venta");
		menuBar.add(mnCompraYVenta);
		
		JMenuItem mntmStock = new JMenuItem("Stock");
		mnCompraYVenta.add(mntmStock);
		
		JMenuItem mMaterialVender = new JMenuItem("Material Vender");
		mnCompraYVenta.add(mMaterialVender);
		
		JMenu mnReporte = new JMenu("Reporte");
		mnReporte.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/iconos16x16/Reporte.png")));
		menuBar.add(mnReporte);
		
		JMenuItem mntmReporteCompra = new JMenuItem("Reporte Compras");
		mnReporte.add(mntmReporteCompra);
		
		JMenuItem mntmReporteMaterial = new JMenuItem("Reporte Materiales Donados");
		mnReporte.add(mntmReporteMaterial);
		
		JMenuItem mntmReporteVentas = new JMenuItem("Reporte Ventas");
		mnReporte.add(mntmReporteVentas);
		
		JMenu mnContacto = new JMenu("Contacto");
		mnContacto.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/iconos16x16/bricks.png")));
		menuBar.add(mnContacto);
		
		JMenuItem mntmDesarrolladores = new JMenuItem("Desarrolladores");
		mntmDesarrolladores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desarrolladores de = new Desarrolladores();
				de.setVisible(true);
			}
		});
		mnContacto.add(mntmDesarrolladores);
		
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 629, 1387, 55);
		getContentPane().add(panel);
		
		lblusuario = new JLabel("");
		lblusuario.setBounds(10, 11, 291, 34);
		lblusuario.setForeground(Color.BLUE);
		lblusuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblusuario.setBackground(Color.GREEN);
		
		lblusuario.setText("USUARIO: " + Usuario);
		
		lblhora = new JLabel("HORA");
		lblhora.setHorizontalAlignment(SwingConstants.CENTER);
		lblhora.setBounds(1050, 11, 167, 34);
		lblhora.setForeground(Color.BLUE);
		lblhora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblhora.setBackground(Color.GREEN);
		
		
		//hilo de la hora -- llamo ala clase hora
		hora hilo= new hora(lblhora);
		panel.setLayout(null);
		panel.add(lblusuario);
		panel.add(lblhora);
		
		lblfecha = new JLabel("FECHA");
		lblfecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblfecha.setBounds(839, 11, 167, 34);
		panel.add(lblfecha);
		lblfecha.setForeground(Color.BLUE);
		lblfecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblfecha.setBackground(Color.GREEN);
		//inicio el hilo
		hilo.start();
		//fecha
		fecha();
	}
		
		
		public void fecha()
		{
			//llamo al metodo fecha
			String fecha = Fecha();
			lblfecha.setText(fecha);	
		}
		
		public String nombre(int mes)
		{
			switch (mes)
			{
			case 1: return "Enero";
			case 2: return "Febrero";
			case 3: return "Marzo";
			case 4: return "Abril";
			case 5: return "Mayo";
			case 6: return "Junio";
			case 7: return "Julio";
			case 8: return "Agosto";
			case 9: return "Septiembre";
			case 10: return "Octubre";
			case 11: return "Noviembre";
			case 12: return "Diciembre";
			}
			return "Error";
		}

		public String Fecha()
		{
			//importo la libreria GregorianCalendar para hacer la funcion de fecha
			GregorianCalendar fecha = new GregorianCalendar();
			//declaro como entero el dia
			int dia = fecha.get(fecha.DAY_OF_MONTH);
			//declaro como entero el mes
			int mes = fecha.get(fecha.MONTH);
			//declaro como entero el aÃ±o
			int año = fecha.get(fecha.YEAR);
			// le asigno a mifecha el formtato dia/mes/aÃ±o
			String mifecha = String.valueOf(dia)+"/"+nombre(mes)+"/"+String.valueOf(año);
			//retorna mifecha
			return mifecha;
		}
}


