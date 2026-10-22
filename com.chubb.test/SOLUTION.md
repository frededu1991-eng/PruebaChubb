# Solución — Examen Práctico
se dio solucion agregando en  el controller una anotacion  deletemapping y PathVariable 
## Qué se implementó
se implmento base de datos h2 para mayor agilidad y entregar el ejercicio con tiempo

## Cómo se implementó
para implementar h2 se agrego al dependencia en el pom y en el aplication properties se agrego la cadena de conexion con el jdbc usuario y contraseña 

## Cambios en base de datos / configuración
se agrego un schema con la creacion de la tabla clients y segrego un insert con datos para poder realizar el ejercicio de consultar el cliente para saber el id y con ese id probar la eliminacion del cliente consultado

## Dificultades encontradas
las dificultades encontradas en mi caso fue el levantamiento del ambiente luefgo de superar ese inconveniente pase a desarrollar en el controller lo que se necesitaba pero tambien use ia generativa para poder crear la interaccion entre el service y el repositori

## Mejoras que podrían aplicarse
las mejoras que podria hacerce usar un gestor de base de datos mas conocido como sql server oracle o mysql  es lo unico que le miraria para mejorar de resto son implementaciones muy usadas dentro de la arquitectura de spring boot
```