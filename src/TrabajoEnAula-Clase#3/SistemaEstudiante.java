import java.util.*;

public class SistemaEstudiante {
    private List<Estudiante> estudiantes;

    public SistemaEstudiante() {
        estudiantes = new ArrayList<>();
    }

    public void registrarEstudiante(Scanner sc) {
        System.out.print("|> Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine();

        System.out.print("|> Ingrese la edad del estudiante: ");
        int edad = sc.nextInt();

        System.out.print("|> Ingrese el índice académico del estudiante: ");
        double indiceAcademico = sc.nextDouble();
        sc.nextLine();

        try {
            EstudianteInvalidoException.validarEstudiante(nombre, edad, indiceAcademico);

            Estudiante nuevoEstudiante = new Estudiante(nombre, edad, indiceAcademico);
            estudiantes.add(nuevoEstudiante);
            
            System.out.println("\nEstudiante registrado correctamente.");

        }catch (EstudianteInvalidoException e) {

            System.out.println(e.getMessage());

        }
        finally {

            System.out.println("Proceso finalizado.");

        }
    }

    public void mostrarInformacion() {
        for (Estudiante est : estudiantes) {
            System.out.println(est.toString());
        }
    }
}
