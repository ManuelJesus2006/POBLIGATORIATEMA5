package view;

import controlador.Controlador;
import models.Admin;
import models.Cliente;
import models.Producto;
import models.Trabajador;
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
                    verCatalogoSinLogueo(controlador);
                    break;
                case 2: // Registrase
                    registraCliente(controlador);
                    break;
                case 3: // Iniciar sesión
                    usuarioLogueado = iniciaSesion(controlador);
                    break;
                default: // Op incorrecta
                    System.out.println("Opción incorrecta...");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                    break;
            }
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

        System.out.print("Introduce un email: ");
        String email = S.nextLine();
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

        if (controlador.getClientes().add(new Cliente(email, clave, nombre, localidad, provincia, direccion, movil)))
            System.out.println("Registrado correctamente...");
        else System.out.println("Ha ocurrido un error...");;
    }

    private static void verCatalogoSinLogueo(Controlador controlador) {
        int cont = 0;
        for (Producto producto : controlador.getCatalogo()) {
            System.out.println("======================================");
            if (producto.getRelevancia() > 9) System.out.println("************ Promo especial **********");
            System.out.println("- ID: " + producto.getId());
            System.out.println("- Marca: " + producto.getMarca() + " - Modelo: " + producto.getModelo());
            System.out.println("- Descripción: " + producto.getDescripcion());
            System.out.println("- Precio: " + producto.getPrecio());
            cont++;
            if (cont == 5) {
                Utils.pulsaContinuar();
                cont = 0;
            }
        }
        Utils.pulsaContinuar();
        Utils.limpiarpantalla();
    }

    private static void menuUsuario(Controlador controlador, Object user) {
        String op, correoTeclado, contraTeclado, nombreTeclado, claveTeclado, direccionTeclado, localidadTeclado,
                provinciaTeclado, tokenTeclado, token;
        int telefonoTeclado = -2;

        for (Admin admin : controlador.getAdmins()) {
            if (user.equals(admin)) {
                do {
                    System.out.println(Menus.menuAdministrador(controlador, admin));
                    op = S.nextLine();
                    switch (op) {
                        case "1": //Ver to el catálogo
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            verCatalogoSinLogueo(controlador);
                            break;
                        case "2": //Editar un producto
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            editarProducto();
                            break;
                        case "3": //Ver un resumen de todos los Clientes
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "4": //Ver un resumen de todos los Pedidos
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "5": // Ver un resumen de todos los Trabajadores
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "6": //Ver las estadísticas de la aplicación
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "7": //Cambiar el estado de un pedido
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "8": //Dar de alta un trabajador
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "9": //Dar de baja un trabajador
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "10": //Asignar un pedido a un trabajador
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "11": //Salir
                            System.out.println("Saliendo");
                            Utils.animacionFinSesion();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        default://Opción no existente
                            System.out.println("Valor no válido");
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                    }
                } while (!op.equals("11"));
            }
        } // Bucle de admin

        for (Trabajador trabajador : controlador.getTrabajadores()) {
            if (user.equals(trabajador)) {
                do {
                    System.out.println(Menus.menuTrabajador(controlador, trabajador));
                    op = S.nextLine();
                    switch (op) {
                        case "1": //Consultar los pedidos que tengo asignados
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "2": //Modificar el estado de un pedido
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "3": //Consultar el catálogo de productos
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "4": //Modificar un producto
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "5": //Ver el histórico de pedidos terminados
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "6": //Ver mi perfil
                            pintaPerfilTrabajador(trabajador);
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "7": //Modificar mis datos personales
                            modificaDatosPersonalesTrabajador(controlador, trabajador);
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "8": //Salir
                            System.out.println("Saliendo");
                            Utils.animacionFinSesion();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        default://Opción no existente
                            System.out.println("Valor no válido");
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                    }
                } while (!op.equals("8"));
            }
        } // Bucle de trabajadores

        for (Cliente cliente : controlador.getClientes()) {
            if (user.equals(cliente)) {
                do {
                    System.out.println(Menus.menuCliente(controlador, cliente));
                    op = S.nextLine();
                    switch (op) {
                        case "1"://Consultar el catálogo de productos
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            verCatalogoSinLogueo(controlador);
                            break;
                        case "2"://Realizar un pedido
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            realizarPedido(controlador, cliente);
                            break;
                        case "3"://Ver mis pedidos
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "4"://Ver mis datos personales
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "5"://Modificar mis datos personales
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "6":// Salir
                            System.out.println("Saliendo");
                            Utils.animacionFinSesion();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        default://Opción no existente
                            System.out.println("Valor no válido");
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                    }
                } while (!op.equals("7"));
            }
        } // Bucle de clientes

    }

    //Realizar el pedido decidiendo el procedimiento
    private static void realizarPedido(Controlador controlador, Cliente cliente) {
        int op;
        System.out.println("""
                1. Ver todo el catálogo
                2. Búsqueda por marca
                3. Búsqueda por modelo
                4. Búsqueda por descripción
                5. Búsqueda por término
                6. Búsqueda por precio
                7. Salir
                """);
        op = Integer.parseInt(S.nextLine());
        switch (op){
            case 1: //Ver todo el catálogo
                seleccionPorCatalogo(controlador, cliente);
                break;
            case 2: //Búsqueda por marca
                seleccionPorMarca(controlador, cliente);
                break;
        }
    }

    private static void seleccionPorMarca(Controlador controlador, Cliente cliente) {
        if (!cliente.getCarro().isEmpty()){
            System.out.println("Hemos detectado los siguientes productos en su carro: ");
            pintaCarrito(controlador, cliente);
            boolean error = false;
            int op = 0;
            do {
                error = false;
                try{
                    op = menuCarritoLlenoCliente();
                }catch (NumberFormatException e){
                    System.out.println("Introduce un valor válido....");
                    error = true;
                }
            } while(error);
            switch (op){
                case 1: //Añadir más productos al carrito
                    eligeProductoMarca(controlador, cliente);
                    break;
                case 2: //Vaciar el carro y añadir productos otra vez
                    //ArrayList vacio para vaciar el carro del cliente
                    cliente.vaciaCarro();
                    eligeProductoMarca(controlador, cliente);
                    break;
                case 3: //Realizar pedido
                    if (controlador.confirmaPedidoCliente(cliente.getId())) System.out.println("Pedido realizado con éxito");
                    else System.out.println("El pedido no se ha podido realizar");
            }
        }else eligeProductoMarca(controlador, cliente);
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
            try{
                productoElegido = Integer.parseInt(S.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Introduce un valor numérico....");
                error = true;
            }
            if (productoElegido != -1 && !error) controlador.addProductoCarrito(cliente, controlador.getCatalogo().get(productoElegido - 1).getId());
        }while(productoElegido != -1);
    }

    private static void pintaProductosEncontrados(ArrayList<Producto> productosTemp) {
        int cont = 0;
        for (Producto producto : productosTemp){
            System.out.println(cont + ". " + producto.getDescripcion() + " - " + producto.getMarca() + " - " +
                    producto.getModelo() + " - " + producto.getPrecio() + "€");
            cont++;
        }
    }

    private static void seleccionPorCatalogo(Controlador controlador, Cliente cliente){
        if (!cliente.getCarro().isEmpty()){
            System.out.println("Hemos detectado los siguientes productos en su carro: ");
            pintaCarrito(controlador, cliente);
            boolean error = false;
            int op = 0;
            do {
                error = false;
                try{
                    op = menuCarritoLlenoCliente();
                }catch (NumberFormatException e){
                    System.out.println("Introduce un valor válido....");
                    error = true;
                }
            } while(error);
            switch (op){
                case 1: //Añadir más productos al carrito
                    eligeProductoCatalogo(controlador, cliente);
                    break;
                case 2: //Vaciar el carro y añadir productos otra vez
                    //ArrayList vacio para vaciar el carro del cliente
                    cliente.vaciaCarro();
                    eligeProductoCatalogo(controlador, cliente);
                    break;
                case 3: //Realizar pedido
                    if (controlador.confirmaPedidoCliente(cliente.getId())) System.out.println("Pedido realizado con éxito");
                    else System.out.println("El pedido no se ha podido realizar");
            }
        }else eligeProductoCatalogo(controlador, cliente);

        System.out.println("Has salido de la selección de productos, estos son los productos a comprar: ");
        pintaCarrito(controlador, cliente);
        System.out.println("¿Desea continuar con la compra?(S/N)");
        if (S.nextLine().equals("S")){
            if (controlador.confirmaPedidoCliente(cliente.getId())) System.out.println("Pedido realizado con éxito");
            else System.out.println("El pedido no se ha podido realizar");
        }else System.out.println("Ha cancelado la compra, sus productos elegidos siguen en el carro");
    }

    private static void eligeProductoCatalogo(Controlador controlador, Cliente cliente) {
        int productoElegido = -1;
        pintaResumenCatalogo(controlador);
        do {
            System.out.print("Introduzca el número del producto a añadir al carrito (-1 para finalizar selección): ");
            try{
                productoElegido = Integer.parseInt(S.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Introduce un valor numérico....");
            }
            if (productoElegido != -1) controlador.addProductoCarrito(cliente, controlador.getCatalogo().get(productoElegido - 1).getId());
        }while(productoElegido != -1);
    }

    private static void pintaResumenCatalogo(Controlador controlador) {
        int cont = 1;
        for (Producto producto : controlador.getCatalogo()){
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
        for (Producto producto : cliente.getCarro()){
            System.out.println(cont + ". " + producto.getDescripcion() + " - " + producto.getMarca() + " - " +
                    producto.getModelo() + " - " + producto.getPrecio() + "€");
            cont++;
        }
    }

    //Funciones generales
    private static void editarProducto() {

    }

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
        if (telefonoTeclado != 1) trabajador.setMovil(telefonoTeclado);

        System.out.println("Tus datos han sido modificados...");
    }

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

    private static void pintaPerfilTrabajador(Trabajador trabajador) {
        System.out.println("******* VER PERFIL *******");
        System.out.println(trabajador);
    }
}
