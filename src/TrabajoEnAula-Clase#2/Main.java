import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Paciente p = new Paciente();
    public static void main(String[] args) {
        menu(sc);
    }

    public static void menu(Scanner sc){

        int opcion;

        do{
            System.out.println("\n======== MENU =======\n");
            System.out.println("1. Registrar un paciente");
            System.out.println("2. Mostrar información de pacientes");
            System.out.println("3. Calcular IMC");
            System.out.println("4. Determinar estado del paciente");
            System.out.println("5. Mostrar todos los pacientes registrados");
            System.out.println("6. Salir del sistema");

            System.out.print("\n¿Qué desea hacer?: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

        
            switch (opcion) {
            case 1:
                p.agregarPaciente(sc);
                break;
            case 2:
                System.out.println("\n=== INFORMACION DEL PACIENTE ===");
                p.mostrarInformacion();
                break;
            case 3:
                System.out.printf("\n|> Su IMC es: %.1f\n", p.calcularIMC());
                break;
            case 4:
                System.out.println("\n|> Estado del paciente: " + p.determinarEstado());  
                break;
            case 5:
                p.mostrarTodos();
                break;
            case 6:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción invalida.");
                break;
            }
        }while(opcion != 6);
    }
}