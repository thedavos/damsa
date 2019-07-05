package app;

import clases.Reporte;
import utils.Encryption;

public class App {
	public static void main(String[] args) throws Exception {
		System.out.println(Encryption.SHA1("dox001"));
		System.out.println(Encryption.SHA1("doxx002"));
	}
}