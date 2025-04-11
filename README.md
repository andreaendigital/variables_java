# Venta de Entradas en Java

## Descripción del Proyecto :scroll:

Gestionaremos un sistema de venta de entradas, se ha solicitado la implementación de un programa en Java que permita realizar diferentes operaciones como venta, promoción, búsqueda y eliminación de entradas. Además, se deben aplicar descuentos del 10% para estudiantes y del 15% para personas de la tercera edad.
Usando Estructuras de Control y Condicionales en Java, identificacndo tipos de variables.

## Sobre el proyecto 🚀

### ✨ Requerimientos ✨

👌 1. Incluir un menú de opciones para que los usuarios puedan seleccionar diferentes acciones.

a)	Venta de entradas.
- Solicitar al usuario la ubicación de la entrada (por ejemplo, VIP, Platea, General).
- Aplicar descuento del 10% si el cliente es estudiante y del 15% si es de la tercera edad.
- Mostrar el precio final y almacenar la entrada vendida.

b)	Promociones
- Mostrar las promociones disponibles, incluyendo descuentos especiales por compra de múltiples entradas.

c)	Búsqueda de entradas
- Permitir la búsqueda de entradas por número, ubicación o tipo (estudiante, tercera edad).
- Mostrar la información de las entradas encontradas.

d)	Eliminación de entradas
- Elimina una entrada específica mediante su número.

e)	Estructuras condicionales y ciclos iterativos
- Emplea una estructura condicional para determinar si se aplica un descuento y calcular el precio final de la entrada.
- Utiliza un ciclo iterativo para realizar búsquedas y recorrer la lista de entradas vendidas.


👌 2. Declara variables para almacenar información relevante, como el nombre del teatro, la capacidad de la sala, el número de entradas disponibles y el precio unitario de las entradas. Luego, inicializa las variables de la siguiente manera: 
- 4 variables locales o más para almacenar temporalmente datos como el tipo de entrada, descuentos temporales, etc.
- 4 variables de instancia o más para almacenar información persistente sobre las entradas vendidas, como el número, ubicación, precio final, etc.
- 3 variables estáticas o más para contabilizar estadísticas globales, como el total de ingresos o la cantidad de entradas vendidas.


## Visuales :mage_woman:

Manejo de error al ingresar opciones no validas en el menú principal:

![Captura de pantalla 2025-04-11 124704](https://github.com/user-attachments/assets/b75dca7e-01a0-4b6b-8c24-b7b9da619fa5)

![Captura de pantalla 2025-04-11 124714](https://github.com/user-attachments/assets/36c7e703-34aa-4925-aff5-75d5da93c2e5)


Menú de Promociones en opcion 2:
![Captura de pantalla 2025-04-11 124856](https://github.com/user-attachments/assets/ef807896-de66-42b8-8508-a6827e4d8c58)

Manejo de errores en submenú de búsqueda: 
![Captura de pantalla 2025-04-11 125001](https://github.com/user-attachments/assets/c94360db-046f-41c5-99ea-613f89d83b47)

Manejo de errores en opción de eliminación: 
![Captura de pantalla 2025-04-11 125042](https://github.com/user-attachments/assets/e25dda95-8243-429c-9ec2-f4ab0c5e75ce)

Manejo de error, cuando aún la lista está vacía:
![Captura de pantalla 2025-04-11 125119](https://github.com/user-attachments/assets/6cc1f3cf-3e8f-4502-9bc0-1e16f0c4ab1c)

Validación / manejo de error, cuando usuario ingresa información en cada variable:
![Captura de pantalla 2025-04-11 125343](https://github.com/user-attachments/assets/0cd21542-bed2-4cc9-9b10-bf7e5a85ae6d)

Confirmación de entradas disponibles: 
![Captura de pantalla 2025-04-11 125412](https://github.com/user-attachments/assets/e4b3d688-2452-4eb5-aee3-49e352e9d2e5)

Descuento aplicado según edad. Sistema evalúa con qué descuento obtiene el menor precio y aplica el mayor descuento. 
En el ejemplo decide si aplicar promociónd de 4ta entrada al 50% o 10% de tercera edad:

![Captura de pantalla 2025-04-11 125510](https://github.com/user-attachments/assets/a1d4f888-f18f-4ddb-871e-54eeec7231ea)

Al finalizar compra, genera detalle de cada entrada comprada con su ID particular: 
![Captura de pantalla 2025-04-11 125531](https://github.com/user-attachments/assets/33d4d3f7-a964-427e-b67a-98989835fc4a)

Entrega un resumen de entradas al terminar la venta:
![Captura de pantalla 2025-04-11 125538](https://github.com/user-attachments/assets/0f627259-f5de-475a-b9e8-f969e2d84ea3)

Eliminación de entrada por ID, en este ejemplo se elimina ID 2: 
![Captura de pantalla 2025-04-11 130148](https://github.com/user-attachments/assets/6237a34a-ad4d-4512-9776-8b5e8631d17a)

Se aprecia al enlistar las entradas existentes que ya no existe la de ID 2:
![Captura de pantalla 2025-04-11 130204](https://github.com/user-attachments/assets/c6e82698-6d43-40d9-b0e2-c24f94134a1f)

Búsqueda por ID, en el ejemplo nos entrega el detalle de la entrada n°5
![Captura de pantalla 2025-04-11 130600](https://github.com/user-attachments/assets/906e32ed-d8ec-4bb4-9e74-fdccbcfcc330)

Búsqueda por tipo de entrada: 
![Captura de pantalla 2025-04-11 131713](https://github.com/user-attachments/assets/32b264ed-27e5-4a25-abdc-7500b7a249d2)

Búsqueda por tipo de ubicación:
![Captura de pantalla 2025-04-11 131811](https://github.com/user-attachments/assets/717de324-ac4b-449a-913a-30dcbdb6c5b6)

Validación de entradas disponibles:
![Captura de pantalla 2025-04-11 132607](https://github.com/user-attachments/assets/d122c6ee-c14a-40fe-b543-8e6e892dcc9a)

No vende entradas cuando no hay disponibles:
![Captura de pantalla 2025-04-11 132727](https://github.com/user-attachments/assets/c5d8d74b-29b4-4439-a26a-5ed08b17a274)


## Autora ⚡ 

- **Andrea Rosero** ⚡  - [Andrea Rosero](https://github.com/andreaendigital)
