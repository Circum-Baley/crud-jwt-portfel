# crud-jwt-portfel


Portafolio, CRUD de usuario para la obtencion de recursos, mediante metodo de seguridad JWT

_SpringBoot_

JWT Authentication & Authorization

Spring Security - Postgres

1 - /api/auth/signup - POST - 

{
	"username":"admin",
	"email":"email@gmail.com",
	"password":"123456789",
        "role":["admin"]
}
 
2 - /api/auth/signin - POST - Ingreso de usuario 

{
	"username":"admin",
	"password":"123456789"
}

{
	"id":3,
	"username":"admin",
	"email":"email@gmail.com",
	"roles":[
		"ROLE_USER"
	],
	"accessToken":"alkshbdvlakjsbfvlahbdlciWDKL.ASDAWSDCAS.ceAWECD",
	"TokeType":"Bearer"
}

3 - /api/auth/all - GET - Recupera Recursos Publico

return -> Recursos Publico OK

4 - /api/test/user - GET -  Acceso a recursos de rol de usuario

return -> Recursos De Usuarios

5 - /api/test/mod - GET - Acceso a recurso de rol de moderador 

return -> Recursos De Moderador

6 - /api/test/admin - GET - Acceso a recurso de rol de administrador 

return -> Recursos De Administrador
