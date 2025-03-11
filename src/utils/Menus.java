package utils;

import controlador.Controlador;
import models.Admin;
import models.Cliente;
import models.Trabajador;

import java.util.Scanner;

public class Menus {
    public static final Scanner S = new Scanner(System.in);

    //Menu del administrador
    public static String menuAdministrador(Controlador controlador, Admin admin) {
        String salida = "";
        salida += "FERNANSHOP\n";
        salida += "Bienvenido " + admin.getNombre() + ". Tenemos " + 0 + " pedidos sin asignar. Debe asignarlos a un " +
                "trabajador\n";
                //(tienda.contadorPedidos() == 1 ? " pedido" : " pedidos") + " por asignar." + "\n";
        salida += "1.- Ver todo el catálogo\n";
        salida += "2.- Editar un producto\n";
        salida += "3.- Ver un resumen de todos los Clientes\n";
        salida += "4.- Ver un resumen de todos los Pedidos\n";
        salida += "5.- Ver un resumen de todos los Trabajadores\n";
        salida += "6.- Ver las estadísticas de la aplicación\n";
        salida += "7.- Cambiar el estado de un pedido\n";
        salida += "8.- Dar de alta un trabajador\n";
        salida += "9.- Dar de baja un trabajador\n";
        salida += "10.- Asignar un pedido a un trabajador\n";
        salida += "11.- Salir\n";
        salida += "Introduce una opción: ";
        return salida;
    }

    // Menu del cliente
    public static String menuCliente(Controlador controlador, Cliente cliente) {
        String salida = "";
        salida += "FERNANSHOP" + "\n";
        salida += "Bienvenido " + cliente.getNombre() + "\n";
        salida += "Actualmente tiene " + cliente.getCarro().size() + " productos en su carro\n";
        salida += "1.- Consultar el catálogo de productos\n";
        salida += "2.- Realizar un pedido\n";
        salida += "3.- Ver mis pedidos\n";
        salida += "4.- Ver mis datos personales\n";
        salida += "5.- Modificar mis datos personales\n";
        salida += "6.- Salir\n";
        salida += "Introduce una opción: ";
        return salida;
    }

    //Menu del trabajador
    public static String menuTrabajador(Controlador controlador, Trabajador trabajador) {
        String salida = "";
        salida += "FERNANSHOP" + "\n";
        salida += "Bienvenido " + trabajador.getNombre() + ". Tienes \n"; //+ trabajador.numPedidosAsignados() +
            //    (trabajador.numPedidosAsignados() == 1 ? " pedido" : " pedidos") + " que gestionar\n";
        salida += "1.- Consultar los pedidos que tengo asignados\n";
        salida += "2.- Modificar el estado de un pedido\n";
        salida += "3.- Consultar el catálogo de productos\n";
        salida += "4.- Modificar un producto\n";
        salida += "5.- Ver el histórico de pedidos terminados\n";
        salida += "6.- Ver mi perfil\n";
        salida += "7.- Modificar mis datos personales\n";
        salida += "8.- Salir\n";
        salida += "Introduce una opción:";
        return salida;
    }
}
