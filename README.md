# PRUEBA TÉCNICA: prices-ecommerce 

## Enunciado

En la base de datos de comercio electrónico de la compañía disponemos de la tabla PRICES que 
el precio final (pvp) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas.
A continuación se muestra un ejemplo de la tabla con los campos relevantes:


| BRAND_ID  | START_DATE          | END_DATE            | PRICE_LIST | PRODUCT_ID  | PRIORITY | PRICE | CURR  |
|-----------|---------------------|---------------------|------------|-------------|----------|-------|-------|
| 1         | 2020-06-14-00.00.00 | 2020-12-31-23.59.59 | 1          | 35455       | 0        | 35.50 | EUR   |
| 1         | 2020-06-14-15.00.00 | 2020-06-14-18.30.00 | 2          | 35455       | 1        | 25.45 | EUR   |
| 1         | 2020-06-15-00.00.00 | 2020-06-15-11.00.00 | 3          | 35455       | 1        | 30.50 | EUR   |
| 1         | 2020-06-15-16.00.00 | 2020-12-31-23.59.59 | 4          | 35455       | 1        | 38.95 | EUR   |

- BRAND_ID: foreign key de la cadena del grupo (1 = ZARA).
- START_DATE , END_DATE: rango de fechas en el que aplica el precio tarifa indicado.
- PRICE_LIST: Identificador de la tarifa de precios aplicable.
- PRODUCT_ID: Identificador código de producto.
- PRIORITY: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de 
- mayor prioridad (mayor valor numérico).
- PRICE: precio final de venta.
- CURR: iso de la moneda.

## Requisitos

Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta  tal que:

Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de
aplicación y precio final a aplicar.

Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el
nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los
mismos).

Desarrollar unos test al endpoint rest que  validen las siguientes peticiones al servicio con los datos del ejemplo:

-       Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
-       Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
-       Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
-       Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
-       Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)

Se valorará:

1. Calidad de código.
2. Diseño hexagonal.
3. Resultados correctos en los test.
4. Realizar la prueba en github (o similar) y documentando explicando cómo compilar, arrancar, probar, etc.

## ¿Cómo arrancarlo?

### A través de docker

La aplicación está dockerizada. Si el equipo en el que se ejecuta tiene docker instalado podría usar este método para
arrancarlo.

 
  1. Abrimos un terminal y navegamos al directorio raíz de la aplicación donde se encuentra nuestro fichero DockerFile.
  2. Generamos el artefacto de nuestro aplicación a través del comando: <u>mvnw clean package</u>
  3. Creamos la imágen docker a partir del .jar generado con el comando: <u>docker build -t prices-ecommerce .</u>
  4. Y por último creamos y desplegamos nuestro contenedor escribiendo: <u>docker run -d -p 8080:8080 --name prices-ecommerce prices-ecommerce</u>

### A través del propio proyecto

Si queremos arrancarlo sin ayuda de docker, simplemente haría falta:

1. Abrir el proyecto con algún IDE como IntelliJ o Eclipse
2. Navegar hacia la clase principal del proyecto: <u>EcommerceApplication.java</u>
3. Clicar en el botón play que se situa a la altura de la clase


## ¿Cómo probarlo?

Una vez hayamos arrancado el proyecto, se levantará en el puerto 8080 de nuestro equipo.
Tal y cómo se especifica en los requisitos, existe un solo endpoint que consulta el precio
a través de la fecha, identificador de producto e identificador de cadena, los cuales son 
informados a través de request params.

Con ayuda del navegador o postman lanzaríamos peticiones para atacar el servicio. A continuación
se indican algunas como ejemplo:

Para probar los casos de test:

1. http://localhost:8080/api/v1/prices?date=2020-06-14T10:00:00&productId=35455&brandId=1
2. http://localhost:8080/api/v1/prices?date=2020-06-14T16:00:00&productId=35455&brandId=1
3. http://localhost:8080/api/v1/prices?date=2020-06-15T14:00:00&productId=35455&brandId=1
4. http://localhost:8080/api/v1/prices?date=2020-06-15T10:00:00&productId=35455&brandId=1
5. http://localhost:8080/api/v1/prices?date=2020-06-16T21:00:00&productId=35455&brandId=1

Algunas peticiones para comprobar la gestión de excepciones:

1. invalid date -> http://localhost:8080/api/v1/prices?date=2020-06-33T10:00:00&productId=35455&brandId=1
2. productId parameter required -> http://localhost:8080/api/v1/prices?date=2020-06-14T10:00:00&brandId=1
3. brandId parameter required -> http://localhost:8080/api/v1/prices?date=2020-06-14T10:00:00&productId=35455&brandId=1
4. brandId parameter invalid value -> http://localhost:8080/api/v1/prices?date=2020-06-14T10:00:00&productId=35455&brandId=test
5. price not found due to brandId -> http://localhost:8080/api/v1/prices?date=2020-06-14T10:00:00&productId=35455&brandId=5

Se adjunta en la raíz el proyecto el fichero [prices-ecommerce-tests.postman_collection](prices-ecommerce-tests.postman_collection.json) que contiene estas mismas 
peticiones agrupadas en una colección que se pueden importar en postman.

## Documentación del servicio

He tratado de utilizar un enfoque API First, por lo que he definido el servicio utilizando la especificación
OAS 3. Se podría consultar de forma gráfica a través del [Swagger editor](https://editor.swagger.io/). 
Adjunto el fichero de definición del servicio [prices-oas-definition](prices-oas.yml).