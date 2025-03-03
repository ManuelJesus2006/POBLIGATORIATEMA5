package view;

import controlador.Controlador;

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
        return null;
    }

    private static void menuUsuario(Controlador controlador, Object user) {

    }
}
