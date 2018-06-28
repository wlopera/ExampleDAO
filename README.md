# ExampleDAO
Ejemplo Patrón DAO - Java JDBC - básico -ejemplo teorico

PASOS GENERALES PARA CREAR UN CRUD EN JAVA
Crear una base de datos y una tabla.
En Eclipse crear un nuevo proyecto Java.
Conectarte a la base de datos a través de JDBC Driver.
Programar los métodos para el CRUD.
Usar los métodos CRUD.


Pool de conexiones: BasicDataSource
Hemos visto en mysql-java-basico que podemos establecer la conexión con la base de datos por medio de la clase DriverManager.getConnection(). De esta forma obtenemos una Connection real con la base de datos, es decir, al llamar a este método, se establece la conexión con la base de datos y cuando llamemos al método connection.close(), dicha conexión se cierra.

Sin embargo, hay un pequeño problema con esto. Varios hilos no pueden usar una misma conexión física con la base de datos simultáneamente, ya que la información enviada o recibida por cada uno de los hilos se entremezcla con la de los otros, haciendo imposible una escritura o lectura coherente en dicha conexión.

Hay varias posibles soluciones para este problema:

Abrir y cerrar una conexión cada vez que la necesitemos. De esta forma, cada hilo tendrá la suya propia. Esta solución en principio no es eficiente, puesto que establecer una conexión real con la base de datos es un proceso costoso. Andar abriendo y cerrando conexiones con frecuencia puede hacer que nuestro programa vaya más lento de lo debido.
Usar una única conexión y sincronizar el acceso a ella desde los distintos hilos. Esta solución es más o menos buena, pero requiere cierta disciplina al codificar, ya que tendremos que acordarnos de poner siempre los synchronized antes de hacer cualquier transacción con la base de datos. También tiene la pega de que los hilos deben esperar unos por otros
Finalmente, podemos tener varias conexiones abiertas, de forma que cuando un hilo necesite una, la "reserve" para su uso y cuando termine, la "libere" para que pueda ser usada por los demás hilos, todo ello sin abrir y cerrar la conexión cada vez. De esta forma, si hay conexiones disponibles, un hilo no tiene que esperar a que otro acabe. Esta solución es en principo la ideal y es lo que se conoce como un pool de conexiones. Afortunadamente, no debemos preocuparnos de codificarlo nosotros mismos, ya que los hay disponibles en internet. Esta es la solución que vamos a detallar en este tutorial.

Links: para CRUD java
http://www.chuidiang.org/java/mysql/BasicDataSource-Pool-Conexiones.php
https://www.ecodeup.com/crud-java-manual-completo/
http://www.javamexico.org/blogs/marco_antonio_trejo_lemus/conexion_sql_por_jdbc

TODO: Falta crear transaccionalidad en los procesos CRUD
