package data;

import data.enums.ActiRealizada;
import data.enums.Continente;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public class Empresa {
    private final String NOM;
    private List<Sede> sedes;

    public Empresa(String NOM) {
        this.NOM = NOM;
        sedes = new LinkedList();
    }
    
    public void añadirSede(Sede s){
        sedes.add(s);
    }

    public String trabajadoresMasMenosHoras(){
        List <Trabajador> todosTrabajadores = new ArrayList();
        
        for (Sede S : sedes) {
            todosTrabajadores.addAll(S.getTrabajadores());
        }
        todosTrabajadores.sort(Comparator.comparingInt(Trabajador::getHorasTrabajadas).reversed());
        StringBuilder resultado = new StringBuilder("Los 3 trabajadores con más horas: \n");
        
        for (int i = 0; i < 3 && i < todosTrabajadores.size(); i++) {
            resultado.append(todosTrabajadores.get(i).toString()).append("\n");
        }
        
        resultado.append("\nLos 3 trabajadores con menos horas: \n");
        todosTrabajadores.sort(Comparator.comparingInt(Trabajador::getHorasTrabajadas));
        
        for (int i = 0; i < 3 && i < todosTrabajadores.size(); i++) {
            resultado.append(todosTrabajadores.get(i).toString()).append("\n");
        }
        
        return resultado.toString();
    }
    
    public void añadirEmpleadoASede(String nombre, double sueldo, int horasTrabajadas, ActiRealizada actividad, int sedeID){
        for (Sede s : sedes) {
            if(sedeID == s.getID())
                try {
                    s.añadirTrabajador(nombre,sueldo,horasTrabajadas,actividad,sedeID);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void compararTrabajadoresPorContinentes(){
        int africa = 0, europa = 0, asia = 0, america = 0;
        
        for (Sede s : sedes) {
            int numTrabajadores = s.getTrabajadores().size();
            switch(s.continente){
                case Continente.AFRICA -> africa += numTrabajadores;
                case Continente.EUROPA -> europa += numTrabajadores;
                case Continente.ASIA -> asia += numTrabajadores;
                case Continente.AMERICA -> america += numTrabajadores;
            }
        }
        System.out.println("Africa: " + africa);
        System.out.println("Europa: " + europa);
        System.out.println("Asia: " + asia);
        System.out.println("America: " + america);
        
        int[] valores = {africa, europa, asia, america};
        String[] nombres = {"Africa","Europa","Asia", "America"};
        
        int maxID = 0;
        int minID = 0;
        for (int i = 1; i < valores.length; i++) {
            if(valores[maxID] < valores[i])
                maxID = i;
            if (valores[minID] > valores[i])
                minID = i;
        }
        System.out.println("Continente con mas trabajadores: " + nombres[maxID] + " " + valores[maxID] + " trabajadores");
        System.out.println("Continente con menos trabajadores: " + nombres[minID] + " " + valores[minID] + " trabajadores");
    }
    
    void compararTuberiasPorContinente(boolean reparadas) {
        int africa = 0, europa = 0, asia = 0, america = 0;
        
        for (Sede s : sedes) {
            //el if con la condicion ternaria, estructura: condicion? (si verdadero lo que hace) : (si falso lo que hace)
            int cantidad = reparadas ? s.tuberiasReparadas : s.tuberiasInstaladas;
            switch(s.continente){
                case Continente.AFRICA -> africa += cantidad;
                case Continente.EUROPA -> europa += cantidad;
                case Continente.ASIA -> asia += cantidad;
                case Continente.AMERICA -> america += cantidad;
            }
        }  
        System.out.println("Africa: " + africa);
        System.out.println("Europa: " + europa);
        System.out.println("Asia: " + asia);
        System.out.println("America: " + america); 
        
        int[] valores ={africa,europa,asia,america};
        String[] nombres = {"Africa","Europa","Asia", "America"};
        
        for (int i = 0; i < valores.length - 1; i++) {
            for (int j = 0; j < valores.length - 1 - i; j++) {
                if (valores[j] > valores[j + 1]) {
                    // Intercambiar elementos
                    int temp = valores[j];
                    valores[j] = valores[j + 1];
                    valores[j + 1] = temp;
                    
                    String tempString = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = tempString;
                }
            }
        }
        
        
        
    }
    
    public int[] ordenarBurbuja(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambiar elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }
            }
        }
        return array;
    }   
    
    
    public void guardarDatosEnFichero(String ruta){
        List <Trabajador> todosTrabajadores = new ArrayList();
        
        for (Sede S : sedes) {
            todosTrabajadores.addAll(S.getTrabajadores());
        }
        try (PrintWriter p = new PrintWriter(new FileWriter(ruta))){
            for (Trabajador t : todosTrabajadores) {
                p.println(t.getID() + ";" + t.getNombre() + ";" + t.getSueldo() + ";" + t.getHorasTrabajadas() + ";" + t.getActividad() + ";" + t.getSedeID());
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 
    
    public String getNOM() {
        return NOM;
    }

    public List<Sede> getSedes() {
        return sedes;
    }

    @Override
    public String toString() {
        return "Empresa: " + NOM + ", con las siguientes sedes: " + sedes + "\n";
    }


    
    
}
