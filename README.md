Segundo laboratorio Bases de Datos NoSql 2021
El segundo laboratorio consiste en la implementación de una solución de software sin
interfaz gráfica, cuyos servicios son ofrecidos y consultados únicamente a través de
servicios rest. Es decir se deberá implementar un backend o capa de negocio que ofrezca
los servicios rest para ser consumidos, y cuyos datos sean almacenados y extraídos de una
base de datos nosql.
Se debe implementar un sistema que pretende emular ciertas operaciones de una solución
de autenticación/autorización de usuarios, del cual se esperan un conjunto de
funcionalidades que se detallan más adelante, dichas funcionalidades serán ofrecidas a
través de servicios Rest. El sistema debe utilizar una base de datos No Relacional de las
vistas en el curso y el despliegue de la solución deberá cumplir un mínimo de
requerimientos opcionales que se enumeran más adelante.
Requerimientos Funcionales Obligatorios
Observación: Todos los intercambios de información se realizan en formato JSON.
Operaciones a ser ofrecidas como API REST:
1. Obtener códigos de error - Se invoca la operación sin parámetros y se devuelve una
lista con los códigos de error del sistema junto con una descripción de los mismos.
2. Crear Usuario - Se pasará el correo electrónico del usuario a crear, contraseña,
nombre y apellido.El correo debe ser único en el sistema,el sistema genera un
usuario. En caso de existir el usuario se retornará el error con código 101.
3. Agregar Roles a Usuario - Dado un identificador de usuario (mail) y contraseña, se
puede agregar una lista de roles al usuario.El rol es un string, como por ejemplo
Rol1, Rol2, etc. En caso del usuario no existir se retorna el error con código 102, en
caso de la contraseña no coincidir se enviará el error 104. En caso de ya tener
asociado uno de los roles que se pasan por parámetros no se genera un error.
4. Eliminar Roles a Usuario - Dado un identificador de usuario (mail) y contraseña, se
puede eliminar un conjunto de roles pasando como parámetros una lista de roles del
usuario. En caso del usuario no existir se retorna el error con código 102, en caso de
no coincidir la contraseña se enviará un error con código 104. En caso de ya notener asociado uno de los roles que se pasan por parámetros se genera un error.
con código 103 y en la descripción del error se debe indicar el nombre del rol que no
se encuentra asignado al usuario.
5. Autenticar Usuario - Dado un identificador de usuario y una contraseña, devolver un
json con un campo true o false según corresponda.
Requerimientos No Funcionales
● Todo el intercambio de información será realizado mediante JSON a través de
servicios rest.
● Se debe utilizar una base de datos NoSql. Las bases de datos NoSql que se pueden
utilizar son todas las vistas en el curso.
● El código del trabajo y todo lo referente a documentación y configuración debe ser
almacenado en git (git público).
● Se espera la entrega de los casos de pruebas en postman
● El lenguaje utilizado para implementar el sistema debe ser: Java, Python, Node, o
.Net Core.




