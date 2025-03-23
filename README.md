# **Indíce**
  

0.  **Instalación.**

-  **MENÚ PRINCIPAL.**

1. **QUIENES SOMOS**

2. **FUNCIONAMIENTO DEL MENÚ PRINCIPAL.**

3. **MENÚ CLIENTE.**

- **CONSULTAR EL CATÁLOGO DE PRODUCTOS**

- **REALIZAR UN PEDIDO**
  
- **VER MIS PEDIDOS**

- **VER MIS DATOS PERSONALES**

- **MODIFICAR MIS DATOS PERSONALES**

- **CERRAR SESIÓN**

4. **MENÚ TRABAJADOR.**

- **CONSULTAR LOS PEDIDOS QUE TENGO ASIGNADOS**

- **MODIFICAR EL ESTADO DE UN PEDIDO**

- **CONSULTAR EL CATÁLOGO DE PRODUCTOS**

- **MODIFICAR UN PRODUCTO DEL CATÁLOGO**

- **VER MI PERFIL**

- **MODIFICAR MIS DATOS PERSONALES**

- **CERRAR SESIÓN**

5. **MENÚ DE ADMINISTRADOR.**

- **ASIGNAR UN PEDIDO A UN TRABAJADOR**

- **MODIFICAR EL ESTADO DE UN PEDIDO**

- **DAR DE ALTA UN TRABAJADOR**

- **VER TODOS LOS PEDIDOS**
  
- **VER TODOS LOS TRABAJADORES**
  
- **APAGAR EL SOFTWARE**

6. **CAMBIOS Y FUNCIONALIDADES NUEVAS**
   

## **0. INSTALACIÓN**
-Para poder usar nuestro programa tenemos que instalar la versión mas reciente del JDK (Java Development Kit) [click aquí para descargar](https://download.oracle.com/java/24/latest/jdk-24_windows-x64_bin.exe). Durante la instalación tenemos que asegurarnos de que esté instalado en **"C:\Program Files\Java"**, después tenemos que entrar en el **"Panel de Control"** (para entrar podemos meternos en "Configuración" y buscamos panel del control)

![image](https://github.com/user-attachments/assets/142e6ab5-3d75-49d5-b6e7-56d8e87320cd)


(También se puede dandole a la tecla Windows y escribir "Panel de Control")
![image](https://github.com/user-attachments/assets/c73cd836-d74e-4ed9-a4c7-757474680b84)

Al abrir el Panel de Control le daremos al botón de buscar donde escribiremos **"Variables"** y después pincharemos en el **"Editar las variables de entorno del sistema"**
![image](https://github.com/user-attachments/assets/989b2490-4316-4cd5-b08b-59a434ca3b67)

Se nos abrirá la siguiente pestaña y le daremos a **"Variables de entorno..."**

![image](https://github.com/user-attachments/assets/45a4f94e-5035-42a8-ba7b-67b8031e67b7)


-En la sección Variables del sistema busque la variable de entorno **PATH** y selecciónela. Haga clic en Editar. Si no existe la variable de entorno PATH haga clic en Nuevo.

-En la ventana **Editar la variable del sistema** (o **Nueva variable del sistema**), debe especificar el valor de la variable de entorno PATH. Haga clic en **Aceptar**. Cierre todas las demás ventanas haciendo clic en **Aceptar**.

-Para la comprobación le daremos a la letra Windows + R y se nos abrirá la pestaña **Ejecutar** y escribiremos el comando **cmd** y le daremos al botón de **Aceptar.**

![image](https://github.com/user-attachments/assets/6a6f6ac9-57ee-4f29-bdd5-757a992775b8)

-Para ver que todo es correcto escribimos el comando **"javac -version"**, si todo sale bien nos saldrá la versión 24
![image](https://github.com/user-attachments/assets/bf22037e-f064-4747-96fa-6eca49319485)

-Para ejecutar nuestro programa nos iremos al enlace de GitHub [aquí](https://github.com/ManuelJesus2006/POBLIGATORIATEMA5). Después le daremos a **"<> Code"** donde se desplegará varias opciones, y le daremos a **"Download ZIP"**

![image](https://github.com/user-attachments/assets/aaf2a7ae-ae88-4890-b386-fd5d2aedbae3)

-Al descargarlo, extraemos la carpeta en la ubicación donde más te convenga, al tenerla extraida nos meteros en la carpeta extraida y nos saldrá lo siguiente, donde ejecutaremos el **"PracticaObl5.bat"** haciendo doble click o dandole click derecho
al ratón y dandole a la opción **"Abrir"**:

![image](https://github.com/user-attachments/assets/c390e04f-0e66-486a-8ad3-9b40e2ff4f33)

![image](https://github.com/user-attachments/assets/4d9c717a-18a3-4f91-bf5e-dd361495ac87)


(En caso de que nos salga un pantallazo azul de Windows le daremos a donde ponga más información y le daremos a ejectucar de todas maneras)

![image](https://github.com/user-attachments/assets/7add125c-68b6-417e-899a-45b60eb6a69c)

![image](https://github.com/user-attachments/assets/b305e37c-0cec-4d8e-b70e-a38edcade4d2)

### **MENÚ PRINCIPAL**

- Finalmente tendremos nuestro programa en funcionamiento:

Principalmente, el programa nada mas iniciar nos avisará si queremos usar datos de prueba en el software, se deberá elegir la opción S o N, aunque no necesariamente en mayúsculas:

![image](https://github.com/user-attachments/assets/5ac49b8c-79d2-48a2-a84e-c72132efa6d6)

Si le damos a la opción "N" pasará directamente al menú principal:

![image](https://github.com/user-attachments/assets/59e5ebd9-7f6b-4176-9920-508b8ca97bff)

Si le damos al opción "S" nos dirá los datos de prueba para el programa:

![image](https://github.com/user-attachments/assets/684ea8de-e064-41ce-a837-e9e5f8fd9eab)

Y después volverá al menu principal, mostrado anteriormente

## 1. **QUIENES SOMOS**

Somos un programa que gestionará una tienda online.

- Gestionaremos **tres perfiles** donde tendremos el perfil usuario **"Cliente"**, un perfil **"Trabajador"**, y un perfil **"Administrador"**.

## 2. **FUNCIONAMIENTO DEL MENÚ PRINCIPAL.**

Está es la entrada del programa donde tendremos 3 opciones en nuestro menú principal, donde la **opción 1** será el **Ver el catalogo**, donde se podrá ver todos los productos de nuestra tienda de 5 en 5:

![image](https://github.com/user-attachments/assets/186172c9-3995-4647-ba41-70675b21e85e)
![image](https://github.com/user-attachments/assets/54a3b803-166d-44cc-af45-c4df81ae4e46)

- La **opción 2** será **Registrarse**, donde se registrarán los clientes:

![image](https://github.com/user-attachments/assets/8779fdad-6fea-499d-add3-89319401c756)

- La **opción 3** será **Iniciar sesión**, donde podrán iniciar sesión cualquiera de los 3 perfiles mediante un pequeño menu donde se elige el cargo al que iniciar sesión, después dependerá si introduce sus datos correctos de dicha categoría elegida:

![image](https://github.com/user-attachments/assets/0b63ab06-9389-4f07-8ce8-c96e6635e8e4)
![image](https://github.com/user-attachments/assets/3f3ac99f-ea9c-484f-a00f-338d2a700790)


## 3. **MENÚ CLIENTE**

- Para acceder tendremos que registrarnos primero en el menú principal en **"Registrarse"**, una vez hecho eso habremos registrado un cliente.

![image](https://github.com/user-attachments/assets/fb43f3f1-ac88-4871-803b-56d181cdcb82)

- Una vez registrados podemos iniciar sesión:

![image](https://github.com/user-attachments/assets/48b0236c-3a72-4771-b4a2-fea787e75b8e)

![image](https://github.com/user-attachments/assets/d97916fe-0f70-4d17-8686-c9314b06a8c9)

## **CONSULTAR EL CATÁLOGO DE PRODUCTOS**

- Esta opción nos permitirá ver todos los productos de nuestra tienda. Se desplegará un menú de distintos tipos de métodos de búsqueda:

![image](https://github.com/user-attachments/assets/e72cec3d-600c-4736-8a94-94f1814a8fde)

Si pulsamos la opción ver todo el catñalogo, saldrá todo el catálogo tal y como en la primera opción del menu principal:

![image](https://github.com/user-attachments/assets/8796b5d1-0ea7-45e5-9835-751e51113ff9)

Las opciones siguientes son busquedas concretas por marca, modelo, descripción, término y precio

**Por marca**

![image](https://github.com/user-attachments/assets/277de2fa-7937-403f-a604-b3faa11199dc)

**Por modelo**

![image](https://github.com/user-attachments/assets/c6506ac1-19bf-4b81-8599-5254f52ce97a)

**Por descripción**

![image](https://github.com/user-attachments/assets/ad49681a-acb6-427a-b838-a10a0e30f17a)

**Por término**

![image](https://github.com/user-attachments/assets/4063b098-4a1d-44f5-865e-1d1ac3706417)

**Por precio**

![image](https://github.com/user-attachments/assets/2946be4c-1b59-4618-8bc4-ecae12e764cb)

- Por último la opción de salir, donde se vuelve al menú principal:

![image](https://github.com/user-attachments/assets/b1c01aec-6107-473c-a204-1b6d490124b6)

## **REALIZAR UN PEDIDO**

- Realizaremos un pedido con los productos de la tienda, meteremos el producto del catálogo para añadirlo a la cesta (el tamaño de la cesta no tiene límite, aunque no se pueden poner productos duplicados). Para ello tenemos el siguiente menú:

![image](https://github.com/user-attachments/assets/3b41dd7a-3109-4793-bc28-793c0f9df51c)

**Inserta un producto en el carro**

Los productos se insertan uno a uno con un menú resumido de todos los productos resumidos

![image](https://github.com/user-attachments/assets/3770a711-53f1-4832-a8a3-ac287ba8d197)

**Ver el carro**

Mostrar los productos totales disponibles en el carro y el precio total de todo el carro

![image](https://github.com/user-attachments/assets/9409ccfc-6e05-46d3-892a-0c8224fc1a49)

**Eliminar un producto del carro**

**!!CAMBIAR TODO!!**

El programa nos pedirá por seguridad el código del artículo donde se puede revisar en el primer apartado del menu del cliente, introducidos el código y el producto será eliminado de nuestor carro

![image](https://github.com/user-attachments/assets/7430dc8f-5926-4d52-8a25-024adde151a1)

Podemos ver que ha funcionado: 

![image](https://github.com/user-attachments/assets/693bdc30-7b81-466c-beb3-e653838772b8)

**Confirmar pedido**

Nos saldra una ventana como esta:

![image](https://github.com/user-attachments/assets/7bbdbc70-ce32-4817-b9f0-95a12adbbc56)

Si le damos a "N" cancelará la opción de realizar pedido y volvera de nuevo al menú principal de realizar pedido

![image](https://github.com/user-attachments/assets/e5ddc10c-87ad-40e2-b44d-510aed29a5dd)

Si le damos a "S" el envió se realizará con éxito según los productos que tengamos en el carrito

![image](https://github.com/user-attachments/assets/1b5d3204-05d3-4d62-8007-2f1cd26f6488)

**Cancelar pedido**

Nos saldrá la lista de pedidos realizados por el cliente de forma enumerada comenzando por "1", el cliente deberá introducir el número de enumeración del pedido para elegir el pedido a cancelar

![image](https://github.com/user-attachments/assets/d31323e9-e2be-4e32-a1c6-96e6efe98f3b)

Cuando introduzcamos el número del pedido nos preguntará si de verdad estamos seguros de cancelarlo:

![image](https://github.com/user-attachments/assets/55e49b71-5e25-43a4-b798-130894baf4fd)

Si le damos a "N" cancelará la opción de cancelar pedido y volvera de nuevo al menú principal de realizar pedido

![image](https://github.com/user-attachments/assets/01e491f4-5744-4a8c-887f-5534606644bc)

Si le damos a "S" se cancelará el pedido con éxito

![image](https://github.com/user-attachments/assets/03d654f2-e4bd-4fa2-be55-acdf9c7b46e4)

Podemos ver por esta captura que ha funcionado:

![image](https://github.com/user-attachments/assets/96e67612-c9e9-453a-951e-3ef27751a42a)

**Salir**

Con esta opción volveremos al menú principal del cliente

![image](https://github.com/user-attachments/assets/3d1b0ecb-5db0-4646-8109-79a32bf7304a)

## **VER MIS PEDIDOS**

- Podremos ver los pedidos que hayamos realizado, tanto los cancelados como los no cancelados (pendientes).

![image](https://github.com/user-attachments/assets/a84b51af-b21c-4f65-96c1-1ef31b01b1fb)

(En caso de que no hayamos pedido nada)

**!!PONER IMAGEN!!**

## **VER MIS DATOS PERSONALES**

- Muestra los datos personales del cliente, introducidos durante el registro

![image](https://github.com/user-attachments/assets/0fdfeaa4-01cb-4aa0-baf4-b6e5b39c3f0a)

## **MODIFICAR MIS DATOS PERSONALES**

- Cambiar los datos personales del cliente

![image](https://github.com/user-attachments/assets/baee6d19-6c3b-49ed-b41e-de90bb043d97)

- Si vemos de nuevo los datos, vemos que ha funcionado

![image](https://github.com/user-attachments/assets/237329d4-9fa3-45df-b190-a11657f8ff79)

## **SALIR**

- Salir del menú de cliente, cerrar sesión y volver al menú principal

![image](https://github.com/user-attachments/assets/bb036f4a-b5cf-4e91-aaa8-91e7a6d9ba8f)

## 4. **MENÚ TRABAJADOR.**

El trabajador deberá ser creado por el administrador previamente, pero lo veremos en el apartado de administrador después

- El trabajador se registrará a traves de la opción de iniciar sesión, igual que el cliente, pero eligiendo la opción 2 "Trabajador":

![image](https://github.com/user-attachments/assets/50bb9f78-16a8-4073-9be8-88a7f4d704d4)

- Una vez la sesión iniciada, tendremos las siguiente opciones:

![image](https://github.com/user-attachments/assets/8ce35689-1ec0-41a8-90c8-af7968b862dd)

## **CONSULTAR LOS PEDIDOS QUE TENGO ASIGNADOS**

- Aquí el trabajador mira los pedidos que le han asignado desde administración, aunque a veces los pedidos se asignen automáticamente debido a la mucha disponibilidad de trabajadores. Para demostrar su funcionamiento, haremos que nuestro cliente de prueba haga un pedido y haremos que se asigne automáticamente o en su defecto el administrador se lo asigne a nuestro trabajador (en el apartado de administrador se verá como se asigna)

Una vez asignado volveremos a iniciar sesión en el trabajador cuyo pedido ha sido asignado y le daremos a la opción 1, nos saldrán todos los pedidos asignados, aunque en este caso solo haya uno:

![image](https://github.com/user-attachments/assets/d3696619-fa93-41ae-a766-ee18343b2d13)
(En el caso de que hayan pedidos)

![image](https://github.com/user-attachments/assets/6ebc9908-2605-477d-98b0-921d7cc25dce)
(En el caso de no exista ningún pedido)

## **MODIFICAR EL ESTADO DE UN PEDIDO**

- Aquí se modificar el estado de un pedido asignado a un trabajador, nos saldrán dos opciones:

![image](https://github.com/user-attachments/assets/332846a0-ddd6-4079-aa3e-d738afd8e97a)

**Modifica el estado**

- Saldrán los pedidos de forma enumerada y tendremos que poner el número de enumeración que nos aparece:

![image](https://github.com/user-attachments/assets/25c3bd84-3b9d-41b9-9eba-bc156fc63d3c)

- Saldrá un menú para elegir el nuevo estado:

![image](https://github.com/user-attachments/assets/7a897558-c3c5-4605-a165-41ce2d0b2276)

- Elegimos un nuevo estado para el pedido:

![image](https://github.com/user-attachments/assets/976d01de-c5b8-4873-afb3-c3d2579b6e0c)

**Añade comentario**

- Añadir un comentario de forma opcional al pedido asignado

![image](https://github.com/user-attachments/assets/a92b27c4-91f0-4951-90dd-057c823a0e9d)

- Podemos ver con esta captura que ha funcionado:

![image](https://github.com/user-attachments/assets/850320df-2d41-4290-977b-d21998a4d4ef)

## **CONSULTAR EL CATÁLOGO DE PRODUCTOS**

Si pulsamos esta opción, saldrá todo el catálogo tal y como en la primera opción del menu principal:

![image](https://github.com/user-attachments/assets/8796b5d1-0ea7-45e5-9835-751e51113ff9)

## **MODIFICAR UN PRODUCTO**

- Por seguridad, se pedirá la ID del producto para poder modificarlo:

![image](https://github.com/user-attachments/assets/e98b0fa5-9de9-4a4e-abb9-144e6e2bd951)

- Vamos a probar con este producto:

![image](https://github.com/user-attachments/assets/81f0eb78-5dda-459d-be34-a6c86b5f79ff)

- Ponemos los datos nuevos:

![image](https://github.com/user-attachments/assets/0178bdfe-2fbf-4243-b371-adc87c6780b5)

- Vemos con esta captura que funciona:

![image](https://github.com/user-attachments/assets/f3108129-004a-4b2f-8bdc-133e9b1be11b)

## **VER EL HISTÓRICO DE PEDIDOS TERMINADOS**

- Aquí podremos ver un resumen de todos los pedidos que han sido terminados de cambiar estado y comentarios

![image](https://github.com/user-attachments/assets/c10253e7-670a-4c7a-bae9-6062ab26f0d3)

## **VER MI PERFIL**

- Vemos los datos personales del trabajador

![image](https://github.com/user-attachments/assets/a9163b68-773d-4f2c-9859-ce62f584f354)

## **MODIFICAR MIS DATOS PERSONALES**

- Aquí modificamos los datos personales del trabajador

![image](https://github.com/user-attachments/assets/d7770594-14a6-40c6-8ea0-e0e3a2f88948)

![image](https://github.com/user-attachments/assets/53fb3bd3-7cd6-4688-833c-36a6ed8f0582)
(Vemos que ha funcionado)

## **SALIR**

- Cerramos sesión y volvemos al menu principal

![image](https://github.com/user-attachments/assets/6b39aeaf-6311-41cc-8474-3a3da6b12342)

## 5. **MENÚ TRABAJADOR.**


## 6. **CAMBIOS Y FUNCIONALIDADES NUEVAS**


## **IMPLANTACIÓN DE CORREOS ELECTRÓNICOS Y MENSAJES DE TELEGRAM**

Una de las funcionalidades más importantes es la implantación de correos electrónicos en el software, ocurrira en diferentes casos:
- **Durante el registro para generar un token para activar la cuenta registrada**
- **Cuando un trabajador o administrador modifique un pedido realizado**
- **Cuando el administrador asigna un pedido a un trabajador, este lo recibirán solo los trabajadores**
- **Cuando se realice un pedido nuevo por un cliente**

Y para el telegram ocurrirá cuando:
- **Cuando el administrador asigna un pedido a un trabajador, este lo recibirán solo los trabajadores**

## **SEGURIDAD AL REGISTRARTE**

Nos hemos fijado que cualquier cosa que metieras en el correo funcionaba, así que hemos mejorado la implementación de correos:






















