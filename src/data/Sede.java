package data;

import data.enums.ActiRealizada;
import data.enums.Continente;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public class Sede {
    private static int contadorID = 1;
    
    private final int ID;
    private final String NOM;
    List <Trabajador> trabajadores;
    Continente continente;

    public Sede(String NOM, Continente continente) {
        this.ID = contadorID++;
        this.NOM = NOM;
        this.continente = continente;
        trabajadores = new LinkedList();
    }
    
    public boolean añadirTrabajador(String nombre, double sueldo, ActiRealizada actividad, int sedeID) throws Exception{
        boolean añadido;
        if(Trabajador.trabajadorEsValido(nombre, sueldo)){
            trabajadores.add(new Trabajador(nombre,sueldo,actividad,sedeID));
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
                t.setSueldo(sueldo);
                return true;
            }
        }
        return false;
    }

    public int getID() {
        return ID;
    }

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    @Override
    public String toString() {
        return "Sede "+ ID + ", de nombre " + NOM + ", ubicada en " + continente + ", con los siguientes trabajadores:" + trabajadores;
    }

    
}
