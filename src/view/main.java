package view;

import controlador.Controlador;
import data.DataProductos;
import models.Producto;
import utils.Utils;

import java.util.Objects;
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
                Marque su opción:
                """);
                try{
                    op = Integer.parseInt(S.nextLine());
                }catch (NumberFormatException e){
                    excepcion = true;
                    System.out.println("Introduzca un valor numérico");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                }
            }while(excepcion);
            switch (op) {
                case 1: // Ver el catálogo
                    verCatalogoSinLogueo(controlador);
                    break;
                case 2: // Registrase
                    registraNuevoUsuario(controlador);
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
    }

    private static void registraNuevoUsuario(Controlador controlador) {
        controlador.lo
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
            if (cont == 5){
                Utils.pulsaContinuar();
                cont = 0;
            }
        }
        Utils.pulsaContinuar();
        Utils.limpiarpantalla();
    }

    private static void menuUsuario(Controlador controlador, Object user) {

    }
}
