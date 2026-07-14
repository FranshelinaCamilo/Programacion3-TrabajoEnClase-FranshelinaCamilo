package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Cita;

public class ArchivoUtils {
    public static void guardarCita(List<Cita> citas){
        try{
            FileWriter fw = new FileWriter("Citas.txt", false);
            BufferedWriter bf = new BufferedWriter(fw);
            for(Cita cita: citas){
                bf.write(cita.getCodigo() + " - " + cita.getNombrePaciente() + " - " + cita.getCedula() + " - " + 
                cita.getTelefono() + " - " + cita.getMedico() + " - " + cita.getEspecialidad() + " - " + 
                cita.getFechaCita() + " - "+ cita.getHora() + " - " + cita.getMotivoConsulta() + " - " + 
                cita.getEstado());
                bf.newLine();
            }
            bf.close();
            fw.close();
        }catch(IOException e){
            System.out.println("Error al guardar la cita: " + e.getMessage());
        }
    }

    public static List<Cita> leerCitas() throws IOException {
        List<Cita> lista = new ArrayList<>();
        File archivo = new File("Citas.txt");

        if (!archivo.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(" - ");
                if (datos.length == 10) {
                    Cita cita = new Cita(
                        datos[0],
                        datos[1],
                        Long.parseLong(datos[2]),
                        Long.parseLong(datos[3]),
                        datos[4],
                        datos[5],
                        LocalDate.parse(datos[6]),
                        LocalTime.parse(datos[7]),
                        datos[8],
                        datos[9]
                    );
                    lista.add(cita);
                }
            }
        }
        return lista;
    }
}
