import java.io.*;
import java.util.*;

public class Main{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu(); 
    }

    public static void menu(){
        int opcion; 

        do{
            System.out.println("\n=== Menú de Estudiantes ===");

            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Mostrar Estudiantes");
            System.out.println("3. Salir");

            System.out.print("\n|> Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    try{
                        FileWriter fw = new FileWriter("Estudiante.txt", true);
                        BufferedWriter bufferWriter = new BufferedWriter(fw);

                        System.out.print("\n|> Ingrese el nombre del estudiante: ");
                        String nombre = sc.nextLine();

                        System.out.print("|> Ingrese la edad del estudiante: ");
                        String edad = sc.nextLine();

                        System.out.print("|> Ingrese la matricula del estudiante: ");
                        String matricula = sc.nextLine();

                        bufferWriter.write("\nNombre: " + nombre);
                        bufferWriter.write("\nEdad: " + edad);
                        bufferWriter.write("\nMatrícula: " + matricula);
                        bufferWriter.write("\n-----------------------------");
                        bufferWriter.newLine();

                        bufferWriter.close();

                    } catch (Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                        try{
                            File archivo = new File("Estudiante.txt");
    
                            if(archivo.exists()){

                                FileReader read = new FileReader("Estudiante.txt");
                                String linea;   

                                BufferedReader buffer = new BufferedReader(read);
                                
                                while((linea = buffer.readLine()) != null){
                                    System.out.println(linea);
                                }

                                buffer.close();
                            } else {
                                System.out.println("El archivo no existe.");
                            }
                        } catch (Exception e){
                            System.out.println("Error: " + e.getMessage());
                        }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }
        }while(opcion != 3);
    }
}