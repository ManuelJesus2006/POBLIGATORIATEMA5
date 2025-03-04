package view;

import controlador.Controlador;
import models.Admin;
import models.Cliente;
import models.Producto;
import models.Trabajador;
import utils.Menus;
import utils.Utils;

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
                            break;
                        case "2": //Editar un producto
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
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
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "7": //Modificar mis datos personales
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
                            break;
                        case "2"://Realizar un pedido
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
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
}
