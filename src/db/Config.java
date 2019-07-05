package db;

public class Config {
	final public static String Driver = "com.mysql.jdbc.Driver";
	final public static String databaseName = "b10rpladoweqjjgn97ba";
	final public static String hostname = "b10rpladoweqjjgn97ba-mysql.services.clever-cloud.com";
	final public static String port = "3306";
	final public static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + databaseName + "?useSSL=false";
	final public static String username = "u5mihwrfaijyeblj";
	final public static String password = "7AM1Z9XXlnXdEeHOF0HP";

	// Tabla Cliente
	final public static String ClientTableName = "cliente";
	final public static String ClientID = "cliente_id";
	final public static String ClientCod = "codigo";
	final public static String ClientDNI = "dni";
	final public static String ClientPassword = "contraseña";
	final public static String ClientName = "nombre";
	final public static String ClientLastname = "apellidos";
	final public static String ClientAge = "edad";
	final public static String ClientGender = "genero";
	final public static String ClientAddress = "direccion";
	final public static String ClientEmail = "correo";
	final public static String ClientPhone = "telefono";
	final public static String ClientCellPhone = "celular";
	final public static String ClientURL = "profile_url";
	final public static String ClientState = "estado";
	
	// Tabla Admin
	final public static String AdminTableName = "admin";
	final public static String AdminID = "admin_id";
	final public static String AdminCod = "codigo";
	final public static String AdminDNI = "dni";
	final public static String AdminPassword = "contraseña";
	final public static String AdminName = "nombre";
	final public static String AdminLastname = "apellidos";
	final public static String AdminAge = "edad";
	final public static String AdminGender = "genero";
	final public static String AdminAddress = "direccion";
	final public static String AdminEmail = "correo";
	final public static String AdminPhone = "telefono";
	final public static String AdminCellPhone = "celular";
	final public static String AdminURL = "profile_url";
	final public static String AdminState = "estado";
	
	// Tabla Empresa
	final public static String EnterpriseTableName = "empresa";
	final public static String EnterpriseID = "empresa_id";
	final public static String EnterpriseCod = "codigo";
	final public static String EnterpriseRUC = "ruc";
	final public static String EnterprisePassword = "contraseña";
	final public static String EnterpriseName = "nombre";
	final public static String EnterpriseAddress = "direccion";
	final public static String EnterpriseEmail = "correo";
	final public static String EnterprisePhone = "telefono";
	final public static String EnterpriseCellPhone = "celular";
	final public static String EnterpriseURL = "profile_url";
	final public static String EnterpriseState = "estado";
	
	// Tabla factura
	final public static String FacturaTableName = "factura";
	final public static String FacturaID = "factura_id";
	
	// Tabla facturaDetalle
	final public static String FacturaDetalleTableName = "facturaDetalle";
	final public static String FacturaDetalleID = "factura_id";
	final public static String FacturaDetalleQuantity = "cantidad";
	
	// Tabla material
	final public static String MaterialTableName = "material";
	final public static String MaterialID = "material_id";
	final public static String MaterialCod = "codigo_material";
	final public static String MaterialName = "nombre";
	final public static String MaterialDescription = "descripcion";
	final public static String MaterialPrice = "precio_venta";
	final public static String MaterialQuantity = "cantidad";
	final public static String MaterialType = "tipo";
	final public static String MaterialState = "estado";
	final public static String MaterialURL = "material_img";
	
	// Tabla reporte
	final public static String ReporteTableName = "reporte";
	final public static String ReporteID = "reporte_id";
	final public static String ReporteURL = "reporte_url";
	final public static String ReporteName = "nombre";
	final public static String ReporteEXT = "extension";
	
	// Tabla sesion
	final public static String SesionTableName = "sesion_usuario";
	final public static String SesionID = "sesion_id";
	
	// Comunes
	final public static String CodigoUsuario = "codigo_usuario";
	final public static String Created = "creado";
	final public static String Modified = "modificado";
}
