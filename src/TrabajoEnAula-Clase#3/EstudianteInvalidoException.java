public class EstudianteInvalidoException extends Exception {

    public EstudianteInvalidoException(String message) {
        super(message);
    }

    public static void validarEstudiante(String nombre, int edad, double indice) throws EstudianteInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new EstudianteInvalidoException("\nError: El nombre no puede estar vacío.");
        }
        if (edad <= 18 || edad >= 100) {
            throw new EstudianteInvalidoException("\nError: La edad debe ser mayor o igual a 18 años.");
        }
        if (indice < 0 || indice > 4) {
            throw new EstudianteInvalidoException("\nError: El índice debe estar entre 0 y 4.");
        }
    }
}
