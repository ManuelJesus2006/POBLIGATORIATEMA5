import static view.main.S;

public class probar {
    public static void main(String[] args) {
        /*int op;
        boolean excepcion;
        do {
            excepcion = false;
            System.out.println("""
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
            }
        }while(excepcion);*/
        try{
            int op = menuCarritoLlenoCliente();
        }catch (NumberFormatException e){
            System.out.println("Introduce un valor válido");
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
}
