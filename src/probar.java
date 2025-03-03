import static view.mainPractica.S;

public class probar {
    public static void main(String[] args) {
        int op;
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
        }while(excepcion);
    }
}
