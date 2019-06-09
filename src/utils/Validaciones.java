package utils;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.*;


public class Validaciones {
	
	public void valcontraseña()
	{
		try 
		{
			
				
				String clave = "[a-z0-9]{4,10}";
				/* System.out.println(Pattern.matches(usuario, txtUsuario.getText()));
				System.out.println(Pattern.matches(clave, txtClave.getText())); */
			
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void valdni()
	{
		try {
			String dni = "[0-9]{8}";
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void valedad()
	{
		try {
			String edad = "[0-9]{3}";
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void valgenero()
	{
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void valcorreo()
	{
		try {
			
			String correo = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void valtelefono()
	{
		try {
			String telefono = "[0-9]{6}";
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void valcelular()
	{
		try {
			String dni = "[0-9]{9}";
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void valruc()
	{
		try {
			String dni = "[0-9]{11}";
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
