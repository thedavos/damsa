package app;

import java.text.SimpleDateFormat;
import java.util.Date;
import clases.Reporte;
import utils.Encryption;

public class App {
	public static void main(String[] args) throws Exception {

		Reporte reporte = new Reporte();
		reporte.setNameFile("saludo");
		reporte.setExtension("txt");
		System.out.println(reporte.readDownloadURL());
		Date mydate = new Date();
		System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(mydate));

		System.out.println(Encryption.SHA1("dox001"));
		System.out.println(Encryption.SHA1("doxx002"));

	}
}