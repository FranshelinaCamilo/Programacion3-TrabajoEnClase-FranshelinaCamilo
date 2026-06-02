import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static SistemaEstudiante est = new SistemaEstudiante();
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar información de estudiantes");
            System.out.println("3. Salir");

            System.out.print("\nSeleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    est.registrarEstudiante(sc);
                    break;
                case 2:
                    est.mostrarInformacion();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");

            }
        } while (opcion != 3);
    }
}