package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.SystemColor;
import app.*;
import clases.*;

public class frmPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
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
	public frmPrincipal(){
		this.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
		frmPrincipal();
	}
	
	private void frmPrincipal() {
		setTitle("Sistema de Reciclaje ");
		
		setBounds(100, 100, 562, 361);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		JMenuItem mntmMiperfil = new JMenuItem("MiPerfil");
		mnPerfil.add(mntmMiperfil);
		
		JMenuItem mntmDarseDeBaja = new JMenuItem("Darse de Baja");
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
		
		JMenuItem mntmReporteDeCliente = new JMenuItem("Reporte de Cliente y Empresas\r\n");
		mnReporte.add(mntmReporteDeCliente);
		
		JMenuItem mntmReporteDeLas = new JMenuItem("Reporte de todas las Compras");
		mnReporte.add(mntmReporteDeLas);
		
		JMenuItem mntmReporteDeTodos = new JMenuItem("Reporte de todos los materiales donados");
		mnReporte.add(mntmReporteDeTodos);
		
		JMenuItem mntmReporteDeTodas = new JMenuItem("Reporte de todas las sesiones");
		mnReporte.add(mntmReporteDeTodas);
		
		JMenuItem mntmReporteDeBoletas = new JMenuItem("Reporte de Boletas emitidas");
		mnReporte.add(mntmReporteDeBoletas);
		
		JMenu mnNewMenu_1 = new JMenu("Control de Usuario");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCrearUsuarioNormal = new JMenuItem("Crear Usuario Normal");
		mnNewMenu_1.add(mntmCrearUsuarioNormal);
		
		JMenuItem mntmCrearUsuarioEmpresa = new JMenuItem("Crear Usuario Empresa");
		mnNewMenu_1.add(mntmCrearUsuarioEmpresa);
		
		JMenuItem mntmVisualizarUsuarios = new JMenuItem("Visualizar Usuarios");
		mnNewMenu_1.add(mntmVisualizarUsuarios);
		
		JMenuItem mntmModificarUsuario = new JMenuItem("Modificar Usuario");
		mnNewMenu_1.add(mntmModificarUsuario);
		
		JMenu mnContacto = new JMenu("Contacto");
		menuBar.add(mnContacto);
		
		JMenuItem mntmDesarrolladores = new JMenuItem("Desarrolladores");
		mnContacto.add(mntmDesarrolladores);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}
}
