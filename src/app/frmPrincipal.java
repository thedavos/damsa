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
import app.*;
import clases.*;
import models.AdminModel;
import models.ClientModel;
import models.EnterpriseModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class frmPrincipal extends JFrame {

	private JPanel contentPane;
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
		
	}
	//**********************************************************************************************************************************
	// Menú Admin
	public frmPrincipal(Admin admin) {
		

        setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 562, 361);
		
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
				dispose();
			}
		});
		mnNewMenu_1.add(mntmCrearUsuarioNormal);
		
		JMenuItem mntmCrearUsuarioEmpresa = new JMenuItem("Crear Usuario Empresa");
		mntmCrearUsuarioEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrodeEmpresa rg = new RegistrodeEmpresa();
				rg.setVisible(true);
				dispose();
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
	}
		void diseno(){
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}
		
		//****************************************************************************************************************************
		// Menú Cliente
		public frmPrincipal(Cliente cliente) {

	    setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 562, 361);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		setLocationRelativeTo(null);
		
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
		menuBar.add(mnReporte);
		
		JMenuItem mntmReporteCompra = new JMenuItem("Reporte Compras");
		mnReporte.add(mntmReporteCompra);
		
		JMenuItem mntmReporteMaterial = new JMenuItem("Reporte Materiales Donados");
		mnReporte.add(mntmReporteMaterial);
		
		JMenu mnContacto = new JMenu("Contacto");
		menuBar.add(mnContacto);
		
		JMenuItem mntmDesarrolladores = new JMenuItem("Desarrolladores");
		mntmDesarrolladores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desarrolladores de = new Desarrolladores();
				de.setVisible(true);
			}
		});
		mnContacto.add(mntmDesarrolladores);
	}
  
		
		
		//********************************************************************************************************************************
		// Menú Empresa
		public frmPrincipal(Empresa empresa) {

	    setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 562, 361);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		
		setLocationRelativeTo(null);
		
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
		menuBar.add(mnReporte);
		
		JMenuItem mntmReporteCompra = new JMenuItem("Reporte Compras");
		mnReporte.add(mntmReporteCompra);
		
		JMenuItem mntmReporteMaterial = new JMenuItem("Reporte Materiales Donados");
		mnReporte.add(mntmReporteMaterial);
		
		JMenuItem mntmReporteVentas = new JMenuItem("Reporte Ventas");
		mnReporte.add(mntmReporteVentas);
		
		JMenu mnContacto = new JMenu("Contacto");
		menuBar.add(mnContacto);
		
		JMenuItem mntmDesarrolladores = new JMenuItem("Desarrolladores");
		mntmDesarrolladores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desarrolladores de = new Desarrolladores();
				de.setVisible(true);
			}
		});
		mnContacto.add(mntmDesarrolladores);
	}
}
