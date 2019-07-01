package utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import clases.Admin;
import clases.Cliente;
import clases.Empresa;
import clases.Usuario;
import utils.Encryption;

public class Validation {
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	}
	
	public static boolean isClientValid(Cliente cliente, Object input, String password) {
		
		int dni = isNumeric(input.toString()) ? Integer.parseInt(input.toString()) : 0;
		
		try {
			if (
				(cliente.getDni() == dni || cliente.getCode().equalsIgnoreCase((String) input)) 
					&& 
					cliente.getPassword().equalsIgnoreCase(Encryption.SHA1(password))) {
				return true;
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean isEnterpriseValid(Empresa empresa, String input, String password) {
		try {
			if (
				(empresa.getRuc().equalsIgnoreCase(input) || empresa.getCode().equalsIgnoreCase(input)) 
					&& 
					empresa.getPassword().equalsIgnoreCase(Encryption.SHA1(password))) {
				return true;
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean isAdminValid(Admin admin, Object input, String password) {
		
		int dni = isNumeric(input.toString()) ? Integer.parseInt(input.toString()) : 0;
		
		try {
			if (
				(admin.getDni() == dni || admin.getCode().equalsIgnoreCase((String) input)) 
					&& 
					admin.getPassword().equalsIgnoreCase(Encryption.SHA1(password))) {
				return true;
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean isPasswordValid(String password)
	{
		try 
		{
			String pattern = "[a-z0-9]{4,10}";
			/* System.out.println(Pattern.matches(usuario, txtUsuario.getText()));
			System.out.println(Pattern.matches(clave, txtClave.getText())); */
			return true;
			
		} 
		catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
	
	public static boolean isDniValid(int dni)
	{
		try {
			String pattern = "[0-9]{8}";
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isAgeValid(int age)
	{
		try {
			String pattern = "[0-9]{3}";
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isGenderValid(String gender)
	{
		try {
			return true;
		} catch (Exception e) {
			// Añadir mensaje
			return false;
		}
	}
	
	public static boolean isEmailValid(String email)
	{
		try {
			String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			return true;
		} catch (Exception e) {
			// Añadir mensaje
			return false;
		}
	}
	
	public static boolean isPhoneValid(int phoneNumber)
	{
		try {
			String pattern = "[0-9]{6}";
			return true;
		} catch (Exception e) {
			// Añadir mensaje
			return false;
		}
	}
	
	public static boolean isCellPhoneValid(int cellphoneNumber)
	{
		try {
			String pattern = "[0-9]{9}";
			return true;
		} catch (Exception e) {
			// Añadir mensaje
			return false;
		}
	}
	
	public static boolean isRucValid(int ruc)
	{
		try {
			String pattern = "[0-9]{11}";
			return true;
		} catch (Exception e) {
			// Añadir mensaje
			return false;
		}
	}
}
