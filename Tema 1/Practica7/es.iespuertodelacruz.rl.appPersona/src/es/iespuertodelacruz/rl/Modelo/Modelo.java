/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import es.iespuertodelacruz.rl.Vista.Vista;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author ruben
 */
public class Modelo {
    
    ArrayList<Persona>personas=new ArrayList();
    
    Persona p1 = new Persona("Juan","13572468F",24,67,1.70);
    Persona p2 = new Persona("Lidia","24687531G",29,54,1.64);
    Persona p3 = new Persona("Pablo","97534680W",37,82,1.76);
    Persona p4 = new Persona("Sara","86421357P",21,49,1.58);
    Persona p5 = new Persona("Antonio","02461357B",39,75,1.73);
    
    Vista v = new Vista();
    
    /**
     * Escribe objetos de tipo Persona en el fichero que le pasa por parámetro.
     * @param f 
     */
    public void llenarFichero(File f) throws IOException{
        
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);
        personas.add(p5);
        
        for (Persona p : personas) {
            
            Path path = Paths.get(f.getAbsolutePath());
                boolean finalizar=false;
            
            try (BufferedWriter bw = Files.newBufferedWriter(path, StandardOpenOption.APPEND, StandardOpenOption.CREATE)){
                //PrintWriter pw = new PrintWriter(bw);
                
                bw.write(p.getNombre()+";"+p.getDni()+";"+p.getEdad()+";"+p.getPeso()+";"+p.getAltura()+"\n");
                bw.close();

                } catch (IOException ex) {
                    System.out.println(ex);
            }
        }
    }
    
    /**
     * A partir de un fichero crea objetos de tipo persona, los añade a un ArrayList y luego los muestra llamando a la función de la vista.
     * @param f
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void mostrarFichero(File f) throws FileNotFoundException, IOException{
 
        Path path = Paths.get(f.getAbsolutePath());
        
        try (BufferedReader br = Files.newBufferedReader(path)) {
            
            String linea;
            while( (linea = br.readLine())!=null){
                String[]datosPersona = linea.split(";");
                System.out.println("Estoy aqui");
                
                for (int i = 0; i < datosPersona.length; i++) {
                 Persona p = new Persona(datosPersona[0],datosPersona[1],Integer.parseInt(datosPersona[2]),Integer.parseInt(datosPersona[3]),Double.parseDouble(datosPersona[4]));
                 personas.add(p);
                 System.out.println("Ahora estoy creando personas");
                }    
            }
            v.mostrarFichero(personas);
        }
    }
}
