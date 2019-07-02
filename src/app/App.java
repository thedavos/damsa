package app;

import clases.Reporte;

public class App {
	public static void main(String[] args) throws Exception {
		Reporte reporte = new Reporte();
		reporte.setNameFile("saludo");
		reporte.setExtension("txt");
		System.out.println(reporte.readDownloadURL());
	}
}