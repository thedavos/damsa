package utils;

import clases.Cliente;
import clases.Empresa;

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
		if (
			(cliente.getDni() == (int) input || cliente.getCode() == (String) input) 
				&& 
				cliente.getPassword().equalsIgnoreCase(password)) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isEnterpriseValid(Empresa empresa, String input, String password) {
		if (
			(empresa.getRuc() == input || empresa.getCode() == input) 
				&& 
				empresa.getPassword().equalsIgnoreCase(password)) {
			return true;
		}
		
		return false;
	}
}
