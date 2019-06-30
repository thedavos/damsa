package app;

import utils.Encryption;

public class App {
	public static void main(String[] args) throws Exception {
		String appKeyId="002792ce63312bb0000000002";
		String appKey="K002rnwo3o8z8P29Os8HMnaqrPwymsg";
		String USER_AGENT="damsa";
		
		String hashed = Encryption.SHA1("contraseña");
		System.out.println(hashed);
		
		
	}
}