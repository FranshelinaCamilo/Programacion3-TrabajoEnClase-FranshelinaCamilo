import java.util.*;

public class Paciente {
    private String nombre;
    private float peso;
    private float altura;

    ArrayList<Paciente> pacientes = new ArrayList<>();

    public Paciente(String nombre, float peso, float altura) {
        setNombre(nombre);
        setAltura(altura);
        setPeso(peso);
    }   

    public Paciente(){
        setNombre("");
        setAltura(0);
        setPeso(0);
    }

    public String getNombre() {
        return nombre;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void agregarPaciente(Scanner sc) {

        System.out.print("\n|> Digite el nombre del paciente: ");
        nombre = sc.nextLine();

        while(nombre.trim().isEmpty()){
            System.out.println("El nombre no puede estar vacío.");
            System.out.print("|> Digite el nombre del paciente: ");
            nombre = sc.nextLine();
        }

        System.out.print("|> Digite el peso (KG): ");
        peso = sc.nextFloat();

        while(peso <= 0){
            System.out.println("El peso debe ser mayor que 0.");
            System.out.print("|> Digite el peso (KG): ");
            peso = sc.nextFloat();
        }

        System.out.print("|> Digite la altura (METROS): ");
        altura = sc.nextFloat();

        while(altura <= 0){
            System.out.println("La altura debe ser mayor que 0.");
            System.out.print("|> Digite la altura (METROS): ");
            altura = sc.nextFloat();
        }

        Paciente nuevoPaciente = new Paciente(nombre, peso, altura);
        pacientes.add(nuevoPaciente);   
    }

    public float calcularIMC() {
        return getPeso() / (getAltura() * getAltura()); 
    }

    public void mostrarInformacion(){
        System.out.println("\nNombre: " + getNombre()
                           + "\nAltura: " + getAltura() + " m"
                           + "\nPeso: " + getPeso() + " kg"
                           + "\nIMC: " +  String.format("%.1f", calcularIMC())
                           + "\nEstado: " + determinarEstado());
    }

    public String determinarEstado(){

        float IMC = calcularIMC();
        if(IMC < 18.5){
            return "Tiene bajo peso";
        }
        else if(IMC <= 24.9  && IMC >= 18.5){
            return "Su peso es normal";
        }
        else if(IMC <= 29.9 && IMC >= 25){
            return "Tiene sobrepeso";
        }
        else{
            return "Tiene obesidad";
        }
    }

    public void mostrarTodos(){
        System.out.println("\n=== PACIENTES REGITRADOS ===");

        for(Paciente p: pacientes){
            p.mostrarInformacion();
            System.out.println("--------------------------------------");
        }
    }
}
