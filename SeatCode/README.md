# Cortacesped

Proyecto creado en eclipse, donde se desarrolla la funcionalidad de dos cortacesped dentro de un tablero, según especificaciones concretas.

## Instalación

Para poder ejecutar el programa:

	1- Descargar código desde github. 
	   Mediante un IDE, por ejemplo eclipse, ejecutar mvn package a nivel del fichero pom.xml y posteriormente ejecutar dentro de la ruta
	   ./target/ 
	   Desde línea de comando ejecutar java -jar SeatCodeMower.jar
	   
	2- Descargar archivo src/main/java/SeatCodeMower.jar desde github
	   Desde línea de comando ejecutar java -jar SeatCodeMower.jar
	 

## Acerca del programa

La introducción de datos, se ha realizado mediante la petición de datos al usuario (Intentando validar todos los casos para que el programa sea lo más robusto).

En el caso que un cortacesped no pueda avanzar (por estar ocupada la posición por el otro cortacesped o porque se salga de la cuadrícula establecida), se queda en la misma 
celda y no lanza ninguna excepción. He preferido hacerlo así para que no pare el programa.

## Futuras mejoras

Entrada de datos Via API Rest.
Cobertura de código + pruebas end-to-end.



