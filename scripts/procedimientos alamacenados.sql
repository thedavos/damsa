use damse;

 -- El cliente y/o empresa puede agregar materiales al almacén
delimiter $
create procedure insertar_materiales
(
in @material_id int,
in @codigo_usuario varchar(20),
in @codigo_material varchar(20) ,
in @nombre varchar(20) ,
in @descripcion varchar(150),
in @precio_venta decimal(4, 2),
in @cantidad int,
in @tipo varchar(10),
in @estado varchar(10) ,
in @material_img varchar(80),
in @creado datetime ,
in @modificado datetime
) begin
	insert into material
    values
    (@codigo_usuario,@codigo_material,@nombre,@descripcion,@precio_venta,@cantidad,@tipo,@estado,@material_img,@creado,@modificado);
end;
delimiter $;


 -- El cliente y/o empresa puede visualizar los materiales insertados en una tabla
delimiter $
create procedure usuario_ver
( in @codigo_usuario varchar(20)
) begin
select m.codigo_material,m.nombre,m.descripcion,m.precio_venta,m.cantidad,
m.tipo,m.estado,m.material_img,m.creado,m.modificado from material m;
when m.codigo_usuario = @codigo_usuario
end;
delimiter $

-- El Administrador puede modificar un material ingresado

delimiter $
create procedure modifcar_material
( 	in @material_id int,
	in @codigo_usuario varchar(20),
	in @codigo_material varchar(20) ,
	in @nombre varchar (20),
	in @descripcion varchar(150),
    in @precio_venta decimal(4, 2),
    in @cantidad int,
    in @tipo varchar(10),
    in @estado varchar(10),
    in @material_img varchar(80),
    in @creado datetime ,
    in @modificado datetime
)begin
update material
	set codigo_usuario = @codigo_usuario, codigo_material = @codigo_material, nombre = @nombre,
    descripcion = @descripcion, precio_venta = @precio_ventas, cantidad = @cantidad,
    tipo = @tipo, estado = @estado, material_img = @material_img, creado = @creado, modificado = @modificado
    where codigo_usuario = @codigo_usuario;
end;
delimiter $

-- El Administrador puede "eliminar" un material ingresado




-- El cliente puede visualizar los materiales en stock
delimiter $
create procedure visualizar_stock

delimiter $
