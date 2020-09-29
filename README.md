# WChallenge

API REST basada en Java Spring Boot

El motor de bases de datos elegido para llevar a cabo la persistencia de datos es MySQL 

(*NOTA*: Se debe de tener creada una base de datos llamada "wchallenge" para levantar el proyecto)

Se puede consultar la Swagger API documentation accediendo a http://localhost:9090/swagger-ui.html , en la cual se podrá visualizar en detalle el funcionamiento de los endpoints a los que se puede acceder.

### ENDPOINTS

```
GET	/users				        Traer todos los Usuarios *(Requerimiento del enunciado)*
GET	/users/{id}			        Traer Usuario por id

GET	/albums				        Traer todos los Albums *(Requerimiento del enunciado)*
GET	/albums/{id}			        Traer Album por id
GET	/albums/user/{id}		        Traer todos los Albums por id de Usuario *(Requerimiento del enunciado)*

GET	/photos			            	Traer todas las Fotos *(Requerimiento del enunciado)*
GET	/photos/{id}			        Traer Foto por id
GET	/photos/album/{id}		        Traer todas las Fotos por id de Album
GET	/photos/user/{id}		        Traer todas las fotos por id de Usuario *(Requerimiento del enunciado)*
			
GET	/posts				        Traer todos los Posts
GET	/posts/user/{id}		        Traer todos los Posts por id de Usuario
			
GET	/comments			        Traer todos los Comentarios
GET	/comments/post/{id}		        Traer todos los Comentarios por id de Post
GET	/comments/filterByName/{name}		Traer Comentario filtrando por campo "name" *(Requerimiento del enunciado)*
GET	/comments//filterByUser/{id}		Traer Comentarios filtrando por id de Usuario *(Requerimiento del enunciado)*

GET	/permissions			        Traer todos los Permisos de usuario para albums compartidos
GET	/permissions/{id}		        Traer un Permiso por id
POST 	/permissions/addSharedAlbum		Registrar un Permiso de usuario enviando id de Usuario, tipo de Permiso, id de Album (En formato JSON)
POST 	/permissions/manage		    	Modificar un Permiso de usuario enviando id de Permiso, id de Usuario, tipo de Permiso, id de Album (En formato JSON)

GET 	/permissions/getUserPermission/{albumId}/{permissionType}	Traer todos los Usuario que poseen un Permiso determinado, en un Album en especifico
```
