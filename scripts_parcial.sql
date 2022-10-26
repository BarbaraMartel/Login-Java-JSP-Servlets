show tables;
describe Usuario

/* Crear tabla Usuario */

CREATE TABLE Usuario (
	id int primary key auto_increment not null,
	correo varchar(100) not null unique,
	nombre varchar(40),
	apePaterno varchar(40),
	apeMaterno varchar(40),
	direccion varchar(100),
	pass varchar(100)

)

/* Insertar nuevo usuario*/

insert into Usuario (correo, nombre, apePaterno, apeMaterno, direccion, pass)
values
("email4@correo.com", "Lucia", "Rodriguez", "Salas", "Av. 28 Julio", "1234567"),
("email5@correo.com", "Alejandra", "Guerrero", "Linares", "Av. 28 Julio", "1234567"),
("email6@correo.com", "Raúl", "Medina", "Bustamante", "Av. 28 Julio", "1234567");


/* Consultar */
select * from Usuario

/*Login*/
select * from Usuario where correo = "ejemplo2@correo.com" and pass = "123123";

/*Recuperar contraseña*/
SELECT * FROM Usuario WHERE correo = "123123";

/* Procedimiento almacenado */

CREATE PROCEDURE showpass (IN p_correo varchar(100))

		begin
			select pass from Usuario where correo = p_correo;
		end
		
		CALL showpass ("ejemplo2@correo.com");
