package utils;

import clases.Cliente;

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
				cliente.getPassword() == password) {
			System.out.println(cliente.getCode());
			return true;
		}
		
		return false;
	}
}
