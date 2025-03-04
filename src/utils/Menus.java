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
        salida += "Bienvenido " + admin.getNombre() + ". Tienes " + 0 + " pedidos\n";
                //(tienda.contadorPedidos() == 1 ? " pedido" : " pedidos") + " por asignar." + "\n";
        salida += "1.- Asignar un pedido a un trabajador" + "\n";
        salida += "2.- Modificar el estado de un pedido" + "\n";
        salida += "3.- Dar de alta un trabajador" + "\n";
        salida += "4.- Ver todos los pedidos" + "\n";
        salida += "5.- Ver todos los clientes" + "\n";
        salida += "6.- Ver todos los trabajadores" + "\n";
        salida += "7.- Cerrar sesión" + "\n";
        salida += "Introduce una opción: ";
        return salida;
    }

    // Menu del cliente
    public static String menuCliente(Controlador controlador, Cliente cliente) {
        String salida = "";
        salida += "FERNANSHOP" + "\n";
        salida += "Bienvenido " + cliente.getNombre() + "\n";
        salida += "1.- Consultar el catálogo de productos" + "\n";
        salida += "2.- Realizar un pedido" + "\n";
        salida += "3.- Ver mis pedidos realizados" + "\n";
        salida += "4.- Ver mis datos personales" + "\n";
        salida += "5.- Modificar mis datos personales" + "\n";
        salida += "6.- Cerrar sesión" + "\n";
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
        salida += "6.- Ver mi perfil" + "\n";
        salida += "7.- Modificar mis datos personales\n";
        salida += "8.- Salir\n";
        salida += "Introduce una opción:";
        return salida;
    }
}
