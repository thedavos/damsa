# Damsa
Java Aplicación de Escritorio que permite la gestión de almacenamiento de materiales, compra,  reportes y control de usuarios.

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
- MiPerfil
- Darse de Baja

#### Materiales
- Almacenar
- Visualizar

#### Compra y Venta
- Ver Stock
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
