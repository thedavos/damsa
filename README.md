# Damse
Java Aplicación de Escritorio que permite la gestión de almacenamiento de materiales, compra,  reportes y control de usuarios.

### Entidades

#### Cliente


|    Campo    	|  Tipo  	| Restricción 	|                                           Detalle                                          	|
|:-----------:	|:------:	|:-----------:	|:------------------------------------------------------------------------------------------:	|
|     dni     	| String 	| Obligatorio 	| el dni no puede tener más de 8 letras                                                      	|
|  contraseña 	| String 	| Obligatorio 	| La contraseña debe tener: mayúsculas, minúsculas, números                                  	|
|    nombre   	| String 	| Obligatorio 	|                                                                                            	|
|  apellidos  	| String 	| Obligatorio 	|                                                                                            	|
|     edad    	|  Short 	| Obligatorio 	| la edad no puede pasar de 3 dígitos                                                        	|
|    genero   	|  Char  	| Obligatorio 	| El dato debe ser o 'M' o 'F'                                                               	|
|  direccion  	| String 	|             	|                                                                                            	|
|    correo   	| String 	|             	| Debe tener el @, y el .com, .es o .pe al final del correo.                                             |
|   telefono  	| String 	|             	| el dato ingresado no puede ser mayor a 6 dígitos, excluyendo el 044.  ej: 044673146        	|
|   celular   	| String 	|             	| el dato ingresado no puede ser mayor a 9 dígitos. excluyendo el +51.  ej: +51991424673     	|
| profile_url 	|  Image 	|             	| Pendiente: buscar un botón en java para ingresar una imagen desde  el sistema de archivos. 	|


#### Empresa

|    Campo    	|  Tipo  	| Restricción 	|                                           Detalle                                          	|
|:-----------:	|:------:	|:-----------:	|:------------------------------------------------------------------------------------------:	|
|     ruc     	| String 	| Obligatorio 	| el dni no puede tener más de 11 letras                                                     	|
|  contraseña 	| String 	| Obligatorio 	| La contraseña debe tener: mayúsculas, minúsculas, números                                  	|
|    nombre   	| String 	| Obligatorio 	|                                                                                            	|
|  direccion  	| String 	|             	|                                                                                            	|
|    correo   	| String 	|             	| Debe tener el @, y el .com, .es o .pe al final del correo.                                 	|
|   telefono  	| String 	|             	| el dato ingresado no puede ser mayor a 6 dígitos, excluyendo el 044.  ej: 044673146        	|
|   celular   	| String 	|             	| el dato ingresado no puede ser mayor a 9 dígitos. excluyendo el +51.  ej: +51991424673     	|
| profile_url 	|  Image 	|             	| Pendiente: buscar un botón en java para ingresar una imagen desde  el sistema de archivos. 	|


#### Material

|     Campo    	|  Tipo  	| Restricción 	|                                           Detalle                                          	|
|:------------:	|:------:	|:-----------:	|:------------------------------------------------------------------------------------------:	|
|    nombre    	| String 	| Obligatorio 	|                                                                                            	|
|  descripcion 	| String 	| Obligatorio 	|                                                                                            	|
| precio_venta 	| Double 	| Obligatorio 	|                                                                                            	|
|     tipo     	| String 	| Obligatorio 	|                                                                                            	|
|    estado    	| String 	| Obligatorio 	|                                                                                            	|
| material_img 	|  Image 	|             	| Pendiente: buscar un botón en java para ingresar una imagen desde  el sistema de archivos. 	|


### Gestión de Almacenamiento de Materiales

#### Cliente
- El cliente puede agregar materiales al almacén
- El cliente puede visualizar los materiales insertados en una tabla


#### Empresa
- La empresa puede agregar materiales al almacén
- La empresa puede visualizar los materiales agregados en una tabla

#### Administrador
- El Administrador puede modificar un material ingresado
- El Administrador puede "eliminar" un material ingresado

### Gestión de Compras y Ventas de los Materiales

#### Cliente
- El cliente puede visualizar los materiales en stock
- El cliente puede seleccionar un material o muchos para comprar
- El cliente puede elegir la cantidad de materiales a comprar


#### Empresa
- La empresa puede visualizar los materiales en stock
- La empresa puede seleccionar un material o muchos para comprar
- La empresa puede elegir la cantidad de materiales a comprar
- La empresa puede vender materiales


### Gestión de Reportes

#### Cliente
- El Cliente puede pedir un reporte con todas las compras que hizo
- El Cliente puede pedir un reporte de todos los materiales donados


#### Empresa
- La Empresa puede pedir un reporte con todas las compras que hizo
- La Empresa puede pedir un reporte de todos los materiales donados


#### Administrador
- El administrador puede pedir un reporte de todos los clientes y empresas
- El administrador puede pedir un reporte de todas las compras seǵun fecha
- El administrador puede pedir un reporte de todos los materiales donados
- El administrador puede pedir un reporte de todas las sesiones según fecha
- El administrador puede pedir un reporte de todos las boleta emitidas

### Control de Usuarios

#### Cliente
- El Cliente no puede visualizar el MenuItem de Control de Usuarios
- El Cliente puede visualizar el MenuItem de Perfil
- El Cliente puede modificar sus datos
- El Cliente puede modificar su foto de Perfil
- El Cliente no puede modificar su código


#### Empresa
- La Empresa no puede visualizar el MenuItem de Control de Usuarios
- La Empresa puede visualizar el MenuItem de Perfil
- La Empresa puede modificar sus datos
- La Empresa puede modificar su foto de Perfil
- La Empresa no puede modificar su código


#### Administrador
- Solo el administrador puede visualizar el MenuItem de Control de Usuarios
- El Administrador puede crear un usuario de tipo Cliente o Empresa
- El Administrador puede modificar un usuario de tipo Cliente o Empresa
- El Administrador puede visualizar todos los usuarios o filtrando por Cliente o Empresa


## Menú

### Menú Items

#### Perfil
- MiPerfil (Usuario Normal, Empresas)
- Darse de Baja (Usuario Normal, Empresas)

#### Materiales
- Almacenar (Usuario Normal, Empresas)
- Visualizar (Usuario Normal, Empresas)

#### Compra y Venta
- Ver Stock (Usuario Normal, Empresas)
  - Comprar Material (Solo Empresas)
- Vender Material (Solo Empresas)

#### Reporte
- Reporte de Compras (Solo Usuario Normal y Empresa)
- Reporte de Materiales Donados (Solo Usuario Normal y Empresa)
- Reporte de Ventas (Solo Empresa)
- Reporte de Clientes y Empresas (Solo Administradores)
- Reporte de todas las compras (Solo Administradores)
- Reporte de todos los materiales donados (Solo Administradores)
- Reporte de todos las sesiones (Solo Administradores)
- Reporte de Boletas emitidas (Solo Administradores)

#### Control de Usuarios (Solo Administradores)
- Crear Usuario Normal
- Crear Usuario Empresa
- Visualizar Usuarios
- Modificar Usuario

#### Contacto
- Desarrolladores
