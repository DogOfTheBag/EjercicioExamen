package data;

import data.enums.ActiRealizada;
import data.enums.Continente;
import data.enums.FormaOrdenar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public class Sede {
    private static int contadorID = 1;
    
    private final int ID;
    private final String NOM;
    int tuberiasReparadas;
    int tuberiasInstaladas;
    List <Trabajador> trabajadores;
    Continente continente;

    public Sede(String NOM, Continente continente, int reparadas, int instaladas) {
        this.ID = contadorID++;
        this.NOM = NOM;
        this.continente = continente;
        this.tuberiasReparadas = reparadas;
        this.tuberiasInstaladas = instaladas;
        trabajadores = new LinkedList();
    }
    
    public boolean añadirTrabajador(String nombre, double sueldo, int horasTrabajadas, ActiRealizada actividad, int sedeID) throws Exception{
        boolean añadido;
        if(Trabajador.trabajadorEsValido(nombre, sueldo)){
            trabajadores.add(new Trabajador(nombre,sueldo,horasTrabajadas,actividad,sedeID));
            añadido = true;
            return true;
        }
        añadido = false;
        return añadido;
    }
    
    public boolean eliminarEmpleado(){
        String stringID = JOptionPane.showInputDialog(""+ this.getTrabajadores() + "\n Introduzca que empleado quiere eliminar:");
        int id = Integer.parseInt(stringID);
        Iterator<Trabajador> iterator = trabajadores.iterator();
        while(iterator.hasNext()){
            Trabajador t = iterator.next();
            if(t.getID() == id){
                iterator.remove();
                JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "No se ha encontrado el trabajador indicado, o no existe");
        return false;
    }
    
    public boolean modificarSueldoEmpleado(){
        String stringID = JOptionPane.showInputDialog(null, this.getTrabajadores() + "\n Introduce el ID del trabajador al modificar");
        int id = Integer.parseInt(stringID);
        String stringSueldo = JOptionPane.showInputDialog("Introduce el nuevo sueldo");
        double sueldo = Double.parseDouble(stringSueldo);
        for (Trabajador t : trabajadores) {
            if(t.getID() == id){
                try {
                    t.setSueldo(sueldo);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    Logger.getLogger(Sede.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }
        }
        return false;
    }
    public String listadoTrabajadoresOrdenados(FormaOrdenar ordenacion){
        List <Trabajador> trabajadoresOrdenados = new ArrayList(this.getTrabajadores());
       
        switch(ordenacion){
            case FormaOrdenar.SUELDO -> trabajadoresOrdenados.sort(Comparator.comparingDouble(Trabajador::getSueldo));
            case FormaOrdenar.NOMBRE -> trabajadoresOrdenados.sort(Comparator.comparing(Trabajador::getNombre));
            case FormaOrdenar.ACTIVIDAD -> trabajadoresOrdenados.sort(Comparator.comparing(Trabajador::getActividad));
        }
        StringBuilder listaOrdenada = new StringBuilder("Listado ordenado de trabajadores según " + ordenacion + "\n");
        
        for (Trabajador t : trabajadoresOrdenados) {
            listaOrdenada.append(t.toString()).append("\n");
        }
        
        return listaOrdenada.toString();
    }

    public int getID() {
        return ID;
    }

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    @Override
    public String toString() {
        return "Sede "+ ID + ", de nombre " + NOM + ", ubicada en " + continente + ", con los siguientes trabajadores:" + trabajadores.toString() + "\n";
    }

    
}
