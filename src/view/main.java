package view;

import controlador.Controlador;
import models.*;
import utils.Comunicaciones;
import utils.Menus;
import utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static final Scanner S = new Scanner(System.in);

    public static void main(String[] args) {
        Controlador controlador = new Controlador();

        do {
            System.out.println("            Bienvenidos a nuestra tienda online");
            System.out.println("============================================================");
            Object user = menuInicio(controlador);
            if (user != null) {
                menuUsuario(controlador, user);
            }
        } while (true);
    }

    private static Object menuInicio(Controlador controlador) {
        Object usuarioLogueado = null;
        int op = 0;
        boolean excepcion;
        do {
            do {
                excepcion = false;
                System.out.print("""
                        1. Ver el catálogo
                        2. Registrarse
                        3. Iniciar sesion
                        Marque su opción:""");
                try {
                    op = Integer.parseInt(S.nextLine());
                } catch (NumberFormatException e) {
                    excepcion = true;
                    System.out.println("Introduzca un valor numérico");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                }
            } while (excepcion);

            switch (op) {
                case 1: // Ver el catálogo
                    verCatalogo(controlador);
                    break;
                case 2: // Registrase
                    registraCliente(controlador);
                    break;
                case 3: // Iniciar sesión
                    usuarioLogueado = iniciaSesion(controlador);
                    if (usuarioLogueado == null) System.out.println("No se ha encontrado ningún usuario...");
                    break;
                default: // Op incorrecta
                    System.out.println("Opción incorrecta...");
                    break;
            }
            Utils.pulsaContinuar();
            Utils.limpiarpantalla();
        } while (usuarioLogueado == null);
        return usuarioLogueado;
    }

    private static Object iniciaSesion(Controlador controlador) {
        Object usuario = null;
        String op, email, pass;
        System.out.print("""
                ¿Cómo quieres loguearte?
                1. Cliente
                2. Trabajador
                3. Administrador
                Marque una opción:""");
        op = S.nextLine();

        switch (op) {
            case "1": //Cliente
                System.out.print("Introduce tu email: ");
                email = S.nextLine();
                System.out.print("Introduce tu clave: ");
                pass = S.nextLine();

                usuario = controlador.login(email, pass);
                break;
            case "2": //Trabajador
                System.out.print("Introduce tu nombre: ");
                email = S.nextLine();
                System.out.print("Introduce tu clave: ");
                pass = S.nextLine();

                usuario = controlador.login(email, pass);
                break;
            case "3": //Administrador
                System.out.print("Introduce tu nombre: ");
                email = S.nextLine();
                System.out.print("Introduce tu clave: ");
                pass = S.nextLine();

                usuario = controlador.login(email, pass);
                break;
            default:
                System.out.println("Opción incorrecta...");
                Utils.pulsaContinuar();
                Utils.limpiarpantalla();
                break;
        }
        return usuario;
    }

    private static void registraCliente(Controlador controlador) {
        boolean bandera = false;

        String email = compruebaCorreo(controlador);
        System.out.print("Introduce la clave: ");
        String clave = S.nextLine();
        System.out.print("Introduce tu nombre: ");
        String nombre = S.nextLine();
        System.out.print("Introduce la localidad: ");
        String localidad = S.nextLine();
        System.out.print("Introduce la provincia: ");
        String provincia = S.nextLine();
        System.out.print("Introduce la dirección: ");
        String direccion = S.nextLine();

        int movil = 0;

        do {
            System.out.print("Introduce el número de teléfono: ");
            try {
                movil = Integer.parseInt(S.nextLine());
                bandera = true;
            } catch (NumberFormatException e) {
                System.out.println("Debes introducer números...");
                Utils.pulsaContinuar();
                Utils.limpiarpantalla();
            }
        } while (!bandera);

        if (controlador.nuevoCliente(email, clave, nombre, localidad, provincia, direccion, movil)) {
            Cliente cliente = null;
            for (Cliente c : controlador.getClientes()) {
                if (c.getEmail().equals(email)) cliente = c;
            }

            String token = controlador.generaToken(cliente);

            System.out.println("Registrado correctamente...");
            Comunicaciones.enviaCorreoToken(email, "¡Hola! Bienvenido a FERNANSHOP " + nombre + ", " +
                    "tu token de verificación de la cuenta es", "TU CÓDIGO DE VERIFICACIÓN DE CUENTA", token, nombre);

        } else System.out.println("Ha ocurrido un error...");


    }

    private static void verCatalogo(Controlador controlador) {
        int cont = 0;
        for (Producto producto : controlador.getCatalogo()) {
            System.out.println();
            System.out.println("============================================================================\n");
            if (producto.getRelevancia() > 9) System.out.println("************ Promo especial ************");
            System.out.println("- ID: " + producto.getId());
            System.out.println("- Marca: " + producto.getMarca() + " - Modelo: " + producto.getModelo());
            System.out.println("- Descripción: " + producto.getDescripcion());
            System.out.println("- Precio: " + producto.getPrecio());
            cont++;
            System.out.println("\n============================================================================\n");
            if (cont == 5) {
                Utils.pulsaContinuar();
                cont = 0;
            }
        }
    }

    private static void menuUsuario(Controlador controlador, Object user) {
        String op;

        for (Admin admin : controlador.getAdmins()) {
            if (user.equals(admin)) {
                do {
                    System.out.println(Menus.menuAdministrador(controlador, admin));
                    op = S.nextLine();
                    switch (op) {
                        case "1": //Ver to el catálogo
                            verCatalogo(controlador);
                            break;
                        case "2": //Editar un producto
                            modificaProducto(controlador);
                            break;
                        case "3": //Ver un resumen de todos los Clientes
                            resumenClientes(controlador);
                            break;
                        case "4": //Ver un resumen de todos los Pedidos

                            break;
                        case "5": // Ver un resumen de todos los Trabajadores
                            resumenTrabajadores(controlador);
                            break;
                        case "6": //Ver las estadísticas de la aplicación
                            estadisticasApp(controlador);
                            break;
                        case "7": //Cambiar el estado de un pedido

                            break;
                        case "8": //Dar de alta un trabajador
                            altaTrabajador(controlador);
                            break;
                        case "9": //Dar de baja un trabajador
                            bajaTrabajador(controlador);
                            break;
                        case "10": //Asignar un pedido a un trabajador

                            break;
                        case "11": //Salir
                            Utils.animacionFinSesion();
                            break;
                        default://Opción no existente
                            System.out.println("Opción incorrecta...");
                            break;
                    }
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                } while (!op.equals("11"));
            }
        } // Bucle de admin

        for (Trabajador trabajador : controlador.getTrabajadores()) {
            if (user.equals(trabajador)) {
                compruebaToken(controlador, trabajador);
                if (trabajador.isValid()) {
                    do {
                        System.out.println(Menus.menuTrabajador(controlador, trabajador));
                        op = S.nextLine();
                        switch (op) {
                            case "1": //Consultar los pedidos que tengo asignados
                                break;
                            case "2": //Modificar el estado de un pedido
                                modificaPedido(controlador);
                                break;
                            case "3": //Consultar el catálogo de productos
                                verCatalogo(controlador);
                                break;
                            case "4": //Modificar un producto
                                modificaProducto(controlador);
                                break;
                            case "5": //Ver el histórico de pedidos terminados
                                break;
                            case "6": //Ver mi perfil
                                pintaPerfilTrabajador(trabajador);
                                break;
                            case "7": //Modificar mis datos personales
                                modificaDatosPersonalesTrabajador(controlador, trabajador);
                                break;
                            case "8": //Salir
                                Utils.animacionFinSesion();
                                break;
                            default://Opción no existente
                                System.out.println("Opción incorrecta...");
                                break;
                        }
                        Utils.pulsaContinuar();
                        Utils.limpiarpantalla();
                    } while (trabajador.isValid() && !op.equals("8"));
                }
            }
        } // Bucle de trabajadores

        for (Cliente cliente : controlador.getClientes()) {
            if (user.equals(cliente)) {

                compruebaToken(controlador, cliente);

                if (cliente.isValid()) {
                    do {
                        System.out.println(Menus.menuCliente(controlador, cliente));
                        op = S.nextLine();
                        switch (op) {
                            case "1"://Consultar el catálogo de productos
                                verCatalogo(controlador);
                                break;
                            case "2"://Realizar un pedido
                                realizarPedido(controlador, cliente);
                                break;
                            case "3"://Ver mis pedidos
                                verMisPedidos(cliente);
                                break;
                            case "4"://Ver mis datos personales
                                pintaPerfilCliente(cliente);
                                break;
                            case "5"://Modificar mis datos personales
                                modificaDatosPersonalesCliente(controlador, cliente);
                                break;
                            case "6":// Salir
                                Utils.animacionFinSesion();
                                break;
                            default://Opción no existente
                                System.out.println("Opción incorrecta...");
                                break;
                        }
                        Utils.pulsaContinuar();
                        Utils.limpiarpantalla();
                    } while (cliente.isValid() &&!op.equals("6"));
                }

            }
        } // Bucle de clientes

    }

    //Función que pinta todos los pedidos realizados por un cliente concreto
    private static void verMisPedidos(Cliente cliente) {
        for (Pedido p : cliente.getPedidos()) {
            System.out.println(p);
        }
    }

    // Función que modifica los datos personales de un Cliente
    private static void modificaDatosPersonalesCliente(Controlador controlador, Cliente cliente) {
        int telefonoTeclado = -2;

        System.out.print("""
                MODIFICACIÓN DE DATOS:
                Introduce el nuevo nombre del cliente:\s""");
        String nombreTeclado = S.nextLine();
        System.out.print("Introduce la nueva clave del cliente: ");
        String contraTeclado = S.nextLine();
        String correoTeclado = compruebaCorreo(controlador);
        System.out.print("Introduzca la nueva localidad (Introduzca 'no' para dejar mismos datos): ");
        String localidadTeclado = S.nextLine();
        System.out.print("Introduzca la nueva provincia (Introduzca 'no' para dejar mismos datos): ");
        String provinciaTeclado = S.nextLine();
        System.out.print("Introduzca la nueva dirección (Introduzca 'no' para dejar mismos datos): ");
        String direccionTeclado = S.nextLine();
        do {
            System.out.print("Introduzca su nuevo teléfono (-1 para dejar mismos datos): ");
            try {
                telefonoTeclado = Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduzca un valor numérico...");
                Utils.pulsaContinuar();
                Utils.limpiarpantalla();
            }
        } while (telefonoTeclado == -2);

        cliente.setNombre(nombreTeclado);
        cliente.setClave(contraTeclado);
        cliente.setEmail(correoTeclado);
        if (!localidadTeclado.equalsIgnoreCase("no")) cliente.setLocalidad(localidadTeclado);
        if (!provinciaTeclado.equalsIgnoreCase("no")) cliente.setLocalidad(provinciaTeclado);
        if (!direccionTeclado.equalsIgnoreCase("no")) cliente.setLocalidad(direccionTeclado);
        if (telefonoTeclado != -1) cliente.setMovil(telefonoTeclado);

        //Generamos el token después de la modificación de datos
        String token = controlador.generaToken(cliente);
        // Le mandamos el correo con el token
        Comunicaciones.enviaCorreoToken(cliente.getEmail(), "¡Hola! Bienvenido a FERNANSHOP " + cliente.getNombre() + ", " +
                "tu token de verificación de la cuenta es", "TU CÓDIGO DE VERIFICACIÓN DE CUENTA", token, cliente.getNombre());

        System.out.println("Tus datos han sido modificados...");
        Utils.pulsaContinuar();
        Utils.limpiarpantalla();
        // Hacemos que introduzca el token nuevo ya que ha cambiado sus datos personales
        compruebaToken(controlador, cliente);
    }

    private static void pintaPerfilCliente(Cliente cliente) {
        System.out.println("************** VER PERFIL **************");
        System.out.println(cliente);
    }

    //Metodo de que comprueba el token de un usuario
    private static void compruebaToken(Controlador controlador, Object user) {
        //Trabajadores
        for (Trabajador trabajador : controlador.getTrabajadores()) {
            if (user == trabajador) {
                if (!trabajador.isValid()) {
                    System.out.print("Introduce tu token para registrarte: ");
                    String tokenTeclado = S.nextLine();
                    if (controlador.compruebaToken(trabajador, tokenTeclado))
                        System.out.println("Token correcto...");
                    else System.out.println("Token incorrecto...");
                }
            }
        }
        //Clientes
        for (Cliente cliente : controlador.getClientes()) {
            if (user == cliente) {
                if (!cliente.isValid()) {
                    System.out.print("Introduce tu token para registrarte: ");
                    String tokenTeclado = S.nextLine();
                    if (controlador.compruebaToken(cliente, tokenTeclado))
                        System.out.println("Token correcto...");
                    else System.out.println("Token incorrecto...");
                }
            }
        }
    }

    // Funcion que da a elegir como se quiere dar de baja al Trabajador, si mediante su ID o en un menú de selección
    private static void bajaTrabajador(Controlador controlador) {
        if (controlador.getTrabajadores().isEmpty()) System.out.println("No hay trabajadores para dar de baja...");
        else {
            Trabajador temp = eligeTrabajadorByMenu(controlador);

            if (temp == null) System.out.println("No se ha encontrado ningún trabajador...");
            else {
                System.out.println("El trabajador es: ");
                System.out.println(temp);

                System.out.print("¿Deseas eliminar al trabajador? (S/N): ");
                String respuesta = S.nextLine();

                if (respuesta.equalsIgnoreCase("N")) System.out.println("Cancelando baja...");
                else if (respuesta.equalsIgnoreCase("S")) {
                    if (controlador.getTrabajadores().remove(temp)) System.out.println("Dado de baja correctamente...");
                    else System.out.println("Ha ocurrido un error...");
                } else System.out.println("Respuesta incorrecta...");
            }

        }
    }

    // Funcion que elimina un trabajador mediante un menú de selección
    private static Trabajador eligeTrabajadorByMenu(Controlador controlador) {
        int eligeTrabajador = -1;
        resumenTrabajadores(controlador);
        System.out.print("Selecciona al trabajador: ");
        try {
            eligeTrabajador = Integer.parseInt(S.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Debes introducir un número...");
        }
        if (eligeTrabajador > 0 && eligeTrabajador <= controlador.getTrabajadores().size()) {
            Trabajador trabajador = controlador.getTrabajadores().get(eligeTrabajador - 1);
            // Todo si el trabajador tiene pedidos pendientes no se puede eliminar
            //if (trabajador.getPedidosAsignados() != null && trabajador.getPedidosAsignados().isEmpty())
            return trabajador;
        }


        return null;
    }

    // Funcion que muestra el resumen de los trabajadores al admin
    private static void resumenTrabajadores(Controlador controlador) {
        if (controlador.getTrabajadores().isEmpty()) System.out.println("No hay trabajadores dados de alta...");
        else {
            int cont = 1;
            for (Trabajador t : controlador.getTrabajadores()) {
                pintaResumenTrabajador(cont, t);
                cont++;
            }
        }
    }

    // Funcion que pinta el resumen de un solo trabajador
    private static void pintaResumenTrabajador(int cont, Trabajador t) {
        System.out.println(cont + ".- ID: " + t.getId() + " .- " + t.getNombre() + "; Móvil: " + t.getMovil() + " - Correo: " + t.getEmail());
    }

    // Funcion que muestra el resumen de los clientes al admin
    private static void resumenClientes(Controlador controlador) {
        if (controlador.getClientes().isEmpty()) System.out.println("No hay clientes registrados...");
        else {
            int cont = 1;
            for (Cliente c : controlador.getClientes()) {
                pintaResumenCliente(cont, c);
                cont++;
            }
        }
    }

    // Funcion que pinta el resumen de un solo cliente
    private static void pintaResumenCliente(int cont, Cliente c) {
        System.out.println(cont + ".- ID: " + c.getId() + " - " + c.getNombre() + " - " + c.getLocalidad() + "(" +
                c.getProvincia() + "); Correo: " + c.getEmail() + " - Móvil: " + c.getMovil());
    }

    // Funcion que muestra el numero de clientes, trabajadores, pedidos, pedidos pendientes, pedidos completados o cancelados
    // y pedidos sin asignar
    private static void estadisticasApp(Controlador controlador) {
        // TODO cuando haya pedidos cambiarlo a printf
        System.out.println("""
                Bienvenido Administrador. Tenemos %d pedidos sin asignar. Debe asignarlos a un trabajador
                ===================================================
                            Estadisticas de la APP
                Número de clientes: %d
                Número de pedidos: %d
                Número de pedidos pendientes: %d
                Número de pedidos completados o cancelados: %d
                Número de pedidos sin asignar: %d
                ===================================================
                """);//, controlador.getClientes(), controlador.getTodosPedidos());
    }

    // Funcion que pide los datos para crear un nuevo trabajador
    private static void altaTrabajador(Controlador controlador) {
        System.out.print("Introduce el nombre del nuevo trabajador: ");
        String nombreTeclado = S.nextLine();
        System.out.print("Introduce la clave del nuevo trabajador: ");
        String pass = S.nextLine();
        String email = compruebaCorreo(controlador);
        System.out.print("Introduce el móvil del trabajador: ");
        int movil = Integer.parseInt(S.nextLine());

        if (controlador.nuevoTrabajador(email, pass, nombreTeclado, movil)) {
            System.out.println("Trabajador dado de alta correctamente...");
            for (Trabajador t : controlador.getTrabajadores()) {
                if (t.getEmail().equals(email)) {
                    //Generamos el token después de la modificación de datos
                    String token = controlador.generaToken(t);
                    // Le mandamos el correo con el token
                    Comunicaciones.enviaCorreoToken(t.getEmail(), "¡Hola! Bienvenido a FERNANSHOP " + t.getNombre()
                            + ", " + "tu token de verificación de la cuenta es", "TU CÓDIGO DE VERIFICACIÓN DE CUENTA", token, t.getNombre());
                }

            }

        } else System.out.println("Ha ocurrido un error...");
    }

    //Realizar el pedido decidiendo el procedimiento
    private static void realizarPedido(Controlador controlador, Cliente cliente) {
        int op;
        System.out.print("""
                1. Ver todo el catálogo
                2. Búsqueda por marca
                3. Búsqueda por modelo
                4. Búsqueda por descripción
                5. Búsqueda por término
                6. Búsqueda por precio
                7. Salir
                Introduce la opción que deseas:""");
        op = Integer.parseInt(S.nextLine());
        switch (op) {
            case 1: //Ver to el catálogo
                seleccionPorCatalogo(controlador, cliente);
                break;
            case 2: //Búsqueda por marca
                seleccionPorMarca(controlador, cliente);
                break;
            case 3: //Búsqueda por modelo
                seleccionaPorModelo(controlador, cliente);
                break;
            case 4: //Busqueda por descripción
                seleccionaPorDescripcion(controlador, cliente);
                break;
            case 5: //Busqueda por descripción
                seleccionaPorTermino(controlador, cliente);
                break;
            case 6: //Busqueda por descripción
                seleccionaPorPrecio(controlador, cliente);
                break;
            default:
                System.out.println("Opción incorrecta...");
                break;
        }
    }

    //Busca por precio máximo y mínimo y luego aparecen los resultados de la busqueda, que es donde el cliente decide el producto
    private static void seleccionaPorPrecio(Controlador controlador, Cliente cliente) {
        if (!cliente.getCarro().isEmpty()) { //Si el carro ya tiene productos añadidos
            System.out.println("Hemos detectado los siguientes productos en su carro: ");
            pintaCarrito(controlador, cliente);
            boolean error = false;
            int op = 0;
            do {
                error = false;
                try {
                    op = menuCarritoLlenoCliente();
                } catch (NumberFormatException e) {
                    System.out.println("Introduce un valor válido....");
                    error = true;
                }
            } while (error);
            switch (op) {
                case 1: //Añadir más productos al carrito
                    eligeProductoPrecio(controlador, cliente);
                    break;
                case 2: //Vaciar el carro y añadir productos otra vez
                    //ArrayList vacio para vaciar el carro del cliente
                    cliente.vaciaCarro();
                    eligeProductoPrecio(controlador, cliente);
                    break;
                case 3: //Realizar pedido
                    if (controlador.confirmaPedidoCliente(cliente.getId())) System.out.println("Pedido realizado con éxito, el total del pedido es de " + cliente.getPedidos().getLast().calculaTotalPedidoConIVA(Utils.IVA) + "euros");
                    else System.out.println("El pedido no se ha podido realizar");
            }
        } else eligeProductoPrecio(controlador, cliente);
        System.out.println("Has salido de la selección de productos, estos son los productos a comprar: ");
        pintaCarrito(controlador, cliente);
        System.out.println("¿Desea continuar con la compra?(S/N)");
        if (S.nextLine().equalsIgnoreCase("S")) {
            if (controlador.confirmaPedidoCliente(cliente.getId())) System.out.println("Pedido realizado con éxito, el total del pedido es de " + cliente.getPedidos().getLast().calculaTotalPedidoConIVA(Utils.IVA) + "euros");
            else System.out.println("El pedido no se ha podido realizar");
        } else System.out.println("Ha cancelado la compra, sus productos elegidos siguen en el carro");
    }

    private static void seleccionaPorTermino(Controlador controlador, Cliente cliente) {

    }

    private static void seleccionaPorDescripcion(Controlador controlador, Cliente cliente) {
        if (!cliente.getCarro().isEmpty()) {
            System.out.println("Hemos detectado los siguientes productos en su carro: ");
            pintaCarrito(controlador, cliente);
            boolean error = false;
            int op = 0;
            do {
                error = false;
                try {
                    op = menuCarritoLlenoCliente();
                } catch (NumberFormatException e) {
                    System.out.println("Introduce un valor válido....");
                    error = true;
                }
            } while (error);
            switch (op) {
                case 1: //Añadir más productos al carrito
                    eligeProductoDescripcion(controlador, cliente);
                    break;
                case 2: //Vaciar el carro y añadir productos otra vez
                    //ArrayList vacio para vaciar el carro del cliente
                    cliente.vaciaCarro();
                    eligeProductoDescripcion(controlador, cliente);
                    break;
                case 3: //Realizar pedido
                    if (controlador.confirmaPedidoCliente(cliente.getId())) System.out.println("Pedido realizado con éxito, el total del pedido es de " + cliente.getPedidos().getLast().calculaTotalPedidoConIVA(Utils.IVA) + "euros");
                    else System.out.println("El pedido no se ha podido realizar");
            }
        } else eligeProductoMarca(controlador, cliente);

        System.out.println("Has salido de la selección de productos, estos son los productos a comprar: ");
        pintaCarrito(controlador, cliente);
        System.out.println("¿Desea continuar con la compra?(S/N)");
        if (S.nextLine().equalsIgnoreCase("S")) {
            if (controlador.confirmaPedidoCliente(cliente.getId())) System.out.println("Pedido realizado con éxito, el total del pedido es de " + cliente.getPedidos().getLast().calculaTotalPedidoConIVA(Utils.IVA) + "euros");
            else System.out.println("El pedido no se ha podido realizar");
        } else System.out.println("Ha cancelado la compra, sus productos elegidos siguen en el carro");
    }

    private static void seleccionaPorModelo(Controlador controlador, Cliente cliente) {
        if (!cliente.getCarro().isEmpty()) {
            System.out.println("Hemos detectado los siguientes productos en su carro: ");
            pintaCarrito(controlador, cliente);
            boolean error = false;
            int op = 0;
            do {
                error = false;
                try {
                    op = menuCarritoLlenoCliente();
                } catch (NumberFormatException e) {
                    System.out.println("Introduce un valor válido....");
                    error = true;
                }
            } while (error);
            switch (op) {
                case 1: //Añadir más productos al carrito
                    eligeProductoModelo(controlador, cliente);
                    break;
                case 2: //Vaciar el carro y añadir productos otra vez
                    //ArrayList vacio para vaciar el carro del cliente
                    cliente.vaciaCarro();
                    eligeProductoModelo(controlador, cliente);
                    break;
                case 3: //Realizar pedido
                    if (controlador.confirmaPedidoCliente(cliente.getId())) System.out.println("Pedido realizado con éxito, el total del pedido es de " + cliente.getPedidos().getLast().calculaTotalPedidoConIVA(Utils.IVA) + "euros");
                    else System.out.println("El pedido no se ha podido realizar");
            }
        } else eligeProductoMarca(controlador, cliente);

        System.out.println("Has salido de la selección de productos, estos son los productos a comprar: ");
        pintaCarrito(controlador, cliente);
        System.out.println("¿Desea continuar con la compra?(S/N)");
        if (S.nextLine().equalsIgnoreCase("S")) {
            if (controlador.confirmaPedidoCliente(cliente.getId())) System.out.println("Pedido realizado con éxito, el total del pedido es de " + cliente.getPedidos().getLast().calculaTotalPedidoConIVA(Utils.IVA) + "euros");
            else System.out.println("El pedido no se ha podido realizar");
        } else System.out.println("Ha cancelado la compra, sus productos elegidos siguen en el carro");
    }

    private static void seleccionPorMarca(Controlador controlador, Cliente cliente) {
        if (!cliente.getCarro().isEmpty()) {
            System.out.println("Hemos detectado los siguientes productos en su carro: ");
            pintaCarrito(controlador, cliente);
            boolean error = false;
            int op = 0;
            do {
                error = false;
                try {
                    op = menuCarritoLlenoCliente();
                } catch (NumberFormatException e) {
                    System.out.println("Introduce un valor válido....");
                    error = true;
                }
            } while (error);
            switch (op) {
                case 1: //Añadir más productos al carrito
                    eligeProductoMarca(controlador, cliente);
                    break;
                case 2: //Vaciar el carro y añadir productos otra vez
                    //ArrayList vacio para vaciar el carro del cliente
                    cliente.vaciaCarro();
                    eligeProductoMarca(controlador, cliente);
                    break;
                case 3: //Realizar pedido
                    if (controlador.confirmaPedidoCliente(cliente.getId())) System.out.println("Pedido realizado con éxito, el total del pedido es de " + cliente.getPedidos().getLast().calculaTotalPedidoConIVA(Utils.IVA) + "euros");
                    else System.out.println("El pedido no se ha podido realizar");
            }
        } else eligeProductoMarca(controlador, cliente);

        System.out.println("Has salido de la selección de productos, estos son los productos a comprar: ");
        pintaCarrito(controlador, cliente);
        System.out.println("¿Desea continuar con la compra?(S/N)");
        if (S.nextLine().equalsIgnoreCase("S")) {
            if (controlador.confirmaPedidoCliente(cliente.getId())) System.out.println("Pedido realizado con éxito, el total del pedido es de " + cliente.getPedidos().getLast().calculaTotalPedidoConIVA(Utils.IVA) + "euros");
            else System.out.println("El pedido no se ha podido realizar");
        } else System.out.println("Ha cancelado la compra, sus productos elegidos siguen en el carro");
    }

    private static void seleccionPorCatalogo(Controlador controlador, Cliente cliente) {
        if (!cliente.getCarro().isEmpty()) {
            System.out.println("Hemos detectado los siguientes productos en su carro: ");
            pintaCarrito(controlador, cliente);
            boolean error = false;
            int op = 0;
            do {
                error = false;
                try {
                    op = menuCarritoLlenoCliente();
                } catch (NumberFormatException e) {
                    System.out.println("Introduce un valor válido....");
                    error = true;
                }
            } while (error);
            switch (op) {
                case 1: //Añadir más productos al carrito
                    eligeProductoCatalogo(controlador, cliente);
                    break;
                case 2: //Vaciar el carro y añadir productos otra vez
                    //ArrayList vacio para vaciar el carro del cliente
                    cliente.vaciaCarro();
                    eligeProductoCatalogo(controlador, cliente);
                    break;
                case 3: //Realizar pedido
                    if (controlador.confirmaPedidoCliente(cliente.getId())) System.out.println("Pedido realizado con éxito, el total del pedido es de " + cliente.getPedidos().getLast().calculaTotalPedidoConIVA(Utils.IVA) + "euros");
                    else System.out.println("El pedido no se ha podido realizar");
            }
        } else eligeProductoCatalogo(controlador, cliente);

        System.out.println("Has salido de la selección de productos, estos son los productos a comprar: ");
        pintaCarrito(controlador, cliente);
        System.out.println("¿Desea continuar con la compra?(S/N)");
        if (S.nextLine().equalsIgnoreCase("S")) {
            if (controlador.confirmaPedidoCliente(cliente.getId())) System.out.println("Pedido realizado con éxito, el total del pedido es de " + cliente.getPedidos().getLast().calculaTotalPedidoConIVA(Utils.IVA) + "euros");
            else System.out.println("El pedido no se ha podido realizar");
        } else System.out.println("Ha cancelado la compra, sus productos elegidos siguen en el carro");
    }

    private static void eligeProductoPrecio(Controlador controlador, Cliente cliente) {
        int productoElegido = 0;
        boolean error = false;
        ArrayList<Producto> productosTemp;
        System.out.println("Introduce el precio mínimo del producto a seleccionar: ");
        float precioMin = Float.parseFloat(S.nextLine());
        System.out.println("Introduce el precio máximo del producto a seleccionar: ");
        float precioMax = Float.parseFloat(S.nextLine());
        productosTemp = controlador.buscaProductosByPrecio(precioMin, precioMax);
        pintaProductosEncontrados(productosTemp);
        do {
            System.out.print("Introduzca el número del producto a añadir al carrito (-1 para finalizar selección): ");
            try {
                productoElegido = Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un valor numérico....");
                error = true;
            }
            if (productoElegido >= 1 && productoElegido < productosTemp.size()) {
                if (controlador.addProductoCarrito(cliente, productosTemp.get(productoElegido - 1).getId()))
                    System.out.println("Producto agregado a la cesta");
            } else if (productoElegido != -1) System.out.print("Dicha opción no existe: ");
        } while (error || productoElegido == -1);
    }

    private static void eligeProductoDescripcion(Controlador controlador, Cliente cliente) {
        int productoElegido = 0;
        boolean error = false;
        ArrayList<Producto> productosTemp;
        System.out.println("Introduce la marca del producto a seleccionar: ");
        String descripcionTeclado = S.nextLine();
        productosTemp = controlador.buscaProductosByDescripcion(descripcionTeclado);
        pintaProductosEncontrados(productosTemp);
        do {
            System.out.print("Introduzca el número del producto a añadir al carrito (-1 para finalizar selección): ");
            try {
                productoElegido = Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un valor numérico....");
                error = true;
            }
            if (productoElegido >= 1 && productoElegido < productosTemp.size()) {
                if (controlador.addProductoCarrito(cliente, productosTemp.get(productoElegido - 1).getId()))
                    System.out.println("Producto agregado a la cesta");
            } else if (productoElegido != -1) System.out.print("Dicha opción no existe: ");
        } while (error || productoElegido == -1);
    }

    private static void eligeProductoModelo(Controlador controlador, Cliente cliente) {
        int productoElegido = 0;
        boolean error = false;
        ArrayList<Producto> productosTemp;
        System.out.println("Introduce la marca del producto a seleccionar: ");
        String marcaTeclado = S.nextLine();
        productosTemp = controlador.buscaProductosByModelo(marcaTeclado);
        pintaProductosEncontrados(productosTemp);
        do {
            System.out.print("Introduzca el número del producto a añadir al carrito (-1 para finalizar selección): ");
            try {
                productoElegido = Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un valor numérico....");
                error = true;
            }
            if (productoElegido >= 1 && productoElegido < productosTemp.size()) {
                if (controlador.addProductoCarrito(cliente, productosTemp.get(productoElegido - 1).getId()))
                    System.out.println("Producto agregado a la cesta");
            } else if (productoElegido != -1) System.out.print("Dicha opción no existe: ");
        } while (error || productoElegido == -1);
    }

    private static void eligeProductoMarca(Controlador controlador, Cliente cliente) {
        int productoElegido = 0;
        boolean error = false;
        ArrayList<Producto> productosTemp;
        System.out.println("Introduce la marca del producto a seleccionar: ");
        String marcaTeclado = S.nextLine();
        productosTemp = controlador.buscaProductosByMarca(marcaTeclado);
        pintaProductosEncontrados(productosTemp);
        do {
            System.out.print("Introduzca el número del producto a añadir al carrito (-1 para finalizar selección): ");
            try {
                productoElegido = Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un valor numérico....");
                error = true;
            }
            if (productoElegido >= 1 && productoElegido < productosTemp.size()) {
                if (controlador.addProductoCarrito(cliente, productosTemp.get(productoElegido - 1).getId()))
                    System.out.println("Producto agregado a la cesta");
            } else if (productoElegido != -1) System.out.print("Dicha opción no existe: ");
        } while (error || productoElegido == -1);
    }

    private static void pintaProductosEncontrados(ArrayList<Producto> productosTemp) {
        int cont = 0;
        for (Producto producto : productosTemp) {
            System.out.println(cont + ". " + producto.getDescripcion() + " - " + producto.getMarca() + " - " +
                    producto.getModelo() + " - " + producto.getPrecio() + "€");
            cont++;
        }
    }

    private static void eligeProductoCatalogo(Controlador controlador, Cliente cliente) {
        int productoElegido = 0;
        boolean error = false;
        pintaResumenCatalogo(controlador);
        do {
            System.out.print("Introduzca el número del producto a añadir al carrito (-1 para finalizar selección): ");
            try {
                productoElegido = Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un valor numérico....");
                error = true;
            }
            if (productoElegido >= 1 && productoElegido <= controlador.getCatalogo().size()) {
                if (controlador.addProductoCarrito(cliente, controlador.getCatalogo().get(productoElegido - 1).getId()))
                    System.out.println("Producto agregado a la cesta");
            } else if (productoElegido != -1) System.out.print("Dicha opción no existe: ");
        } while (error || productoElegido != -1);

    }

    private static void pintaResumenCatalogo(Controlador controlador) {
        int cont = 1;
        for (Producto producto : controlador.getCatalogo()) {
            System.out.println(cont + ". " + producto.getDescripcion() + " - " + producto.getMarca() + " - " +
                    producto.getModelo() + " - " + producto.getPrecio() + "€");
            cont++;
        }
    }

    private static int menuCarritoLlenoCliente() {
        System.out.print("""
                ¿Que desea hacer?
                1. Añadir más productos al carro
                2. Vaciar el carro y añadir productos otra vez
                3. Realizar pedido
                Introduce opción:
                """);
        return Integer.parseInt(S.nextLine());
    }

    private static void pintaCarrito(Controlador controlador, Cliente cliente) {
        int cont = 1;
        for (Producto producto : cliente.getCarro()) {
            System.out.println(cont + ". " + producto.getDescripcion() + " - " + producto.getMarca() + " - " +
                    producto.getModelo() + " - " + producto.getPrecio() + "€");
            cont++;
        }
    }

    // Funcion que modifica los datos de un trabajador
    private static void modificaDatosPersonalesTrabajador(Controlador controlador, Trabajador trabajador) {
        int telefonoTeclado = -2;

        System.out.print("""
                MODIFICACIÓN DE DATOS:
                Introduce el nuevo nombre del trabajador:\s""");
        String nombreTeclado = S.nextLine();
        System.out.print("Introduce la nueva clave del trabajador: ");
        String contraTeclado = S.nextLine();
        String correoTeclado = compruebaCorreo(controlador);
        do {
            System.out.print("Introduzca su nuevo teléfono (-1 para dejar mismos datos): ");
            try {
                telefonoTeclado = Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduzca un valor numérico...");
                Utils.pulsaContinuar();
                Utils.limpiarpantalla();
            }
        } while (telefonoTeclado == -2);

        trabajador.setNombre(nombreTeclado);
        trabajador.setPass(contraTeclado);
        trabajador.setEmail(correoTeclado);
        if (telefonoTeclado != -1) trabajador.setMovil(telefonoTeclado);

        //Generamos el token después de la modificación de datos
        String token = controlador.generaToken(trabajador);
        // Le mandamos el correo con el token
        Comunicaciones.enviaCorreoToken(trabajador.getEmail(), "¡Hola! Bienvenido a FERNANSHOP " + trabajador.getNombre() + ", " +
                "tu token de verificación de la cuenta es", "TU CÓDIGO DE VERIFICACIÓN DE CUENTA", token, trabajador.getNombre());

        System.out.println("Tus datos han sido modificados...");
        Utils.pulsaContinuar();
        Utils.limpiarpantalla();
        // Hacemos que introduzca el token nuevo ya que ha cambiado sus datos personales
        compruebaToken(controlador, trabajador);
    }

    // Funcion que crea un correo con sus validaciones
    private static String compruebaCorreo(Controlador controlador) {
        boolean correoDistinto = false;
        String correoTeclado;
        do {  //Bucle que comprobará que el correo nuevo no se repita con el de otra persona
            System.out.print("Introduzca el correo electrónico:");
            correoTeclado = S.nextLine();
            if (!controlador.compruebaCorreos(correoTeclado)) {
                correoDistinto = true;
                if (!correoTeclado.contains("@") || (!correoTeclado.contains(".com") && !correoTeclado.contains(".es"))) {
                    System.out.println("El correo esta mal introducido...");
                    correoDistinto = false;
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                }
            } else {
                System.out.println("Este correo ya está en uso, introduzca uno nuevo...");
                Utils.pulsaContinuar();
                Utils.limpiarpantalla();
            }
        } while (!correoDistinto);
        return correoTeclado;
    }

    // Funcion que pinta el perfil de un trabajador
    private static void pintaPerfilTrabajador(Trabajador trabajador) {
        System.out.println("************** VER PERFIL **************");
        System.out.println(trabajador);
    }

    // Funcion que modifica el estado de un pedido o añade un comentario al pedido
    private static void modificaPedido(Controlador controlador) {
        String op;

        System.out.println("""
                Marque una opción:
                1. Modifica el estado
                2. Añade un comentario""");
        op = S.nextLine();

        switch (op) {
            case "1": // Modifica el estado
                System.out.println("""
                        Selecciona el nuevo estado:
                        1. En preparación
                        2. Enviado
                        3. Entregado
                        4. Cancelado
                        Introduce el nuevo estado:""");
                int estadoTeclado = Integer.parseInt(S.nextLine());

                break;
            case "2": //Añade un comentario
                System.out.print("Introduce el comentario para el pedido: ");
                String comentarioTeclado = S.nextLine();
                break;
            default:
                System.out.println("Opción incorrecta...");
                break;
        }
    }

    // Funcion que modifica un producto del catalogo
    public static void modificaProducto(Controlador controlador) {
        int id = -1;
        float precioTeclado = -2;
        boolean bandera = false;

        System.out.print("Selecciona la ID del producto: ");
        try {
            id = Integer.parseInt(S.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Debes introducir un valor númerico...");
        }
        Producto producto = controlador.buscaProductoById(id);

        if (producto == null) System.out.println("No se ha encontrado ningún producto");
        else {
            System.out.println("Has elegido: " + producto.getDescripcion() + " - " + producto.getMarca() + " - " + producto.getModelo()
                    + " - " + producto.getPrecio() + "€");

            System.out.print("Introduzca una marca nueva (introduce 'no' para dejar el anterior): ");
            String marcaTeclado = S.nextLine();
            System.out.print("Introduzca un modelo nuevo (introduce 'no' para dejar el anterior): ");
            String modeloTeclado = S.nextLine();
            System.out.print("Introduzca una descripción nueva (introduce 'no' para dejar el anterior): ");
            String descripcionTeclado = S.nextLine();
            do {
                System.out.print("Introduzca un precio nuevo (introduce '-1' para dejar el anterior): ");
                try {
                    precioTeclado = Float.parseFloat(S.nextLine());
                    bandera = true;
                } catch (NumberFormatException e) {
                    System.out.println("Debes introducir un número");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                }
            } while (!bandera);

            if (!marcaTeclado.equalsIgnoreCase("no")) producto.setMarca(marcaTeclado);
            if (!modeloTeclado.equalsIgnoreCase("no")) producto.setModelo(modeloTeclado);
            if (!descripcionTeclado.equalsIgnoreCase("no")) producto.setDescripcion(descripcionTeclado);
            if (precioTeclado != -1) producto.setPrecio(precioTeclado);

            System.out.println("Producto modificado con éxito...");
        }
    }
}
