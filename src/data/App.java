package data;

import data.enums.Continente;
import data.enums.ActiRealizada;
import data.enums.FormaOrdenar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public class App extends Thread{

    /**
     * @param args the command line arguments
     */
    String ruta = "res/trabajadores.txt";
    private final boolean DEV_VERSION = true;
    
    @Override
    public void run() {
        if(DEV_VERSION){
            this.crearDatosPrueba();
        }
        else{
            
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new App().run();
    }
/*************************Parte de pruebas
 * 
 * Solo mirar debajo de esto si estamos en pruebas
 */   
    public void crearDatosPrueba(){
        Empresa empresa = new Empresa("Desatramques jaen");
        empresa.añadirSede(new Sede("Mauritania",Continente.AFRICA,24,655));
        empresa.añadirSede(new Sede("Madrid",Continente.EUROPA,874,55));
        empresa.añadirSede(new Sede("Estocolmo",Continente.EUROPA,140,5504));
        empresa.añadirSede(new Sede("Washington",Continente.AMERICA,300,5547));
        empresa.añadirSede(new Sede("Tokio",Continente.ASIA,10,154));
        empresa.añadirEmpleadoASede("Pepe", 1087,35,ActiRealizada.MANITAS, 1);
        empresa.añadirEmpleadoASede("Pepe", 1087,180,ActiRealizada.MANITAS, 2);
        empresa.añadirEmpleadoASede("Pepe", 1087,2,ActiRealizada.MANITAS, 3);
        empresa.añadirEmpleadoASede("Jose", 1087,13,ActiRealizada.MANITAS, 1);
        empresa.añadirEmpleadoASede("Jose", 1087,243,ActiRealizada.MANITAS, 2);
        empresa.añadirEmpleadoASede("Jose", 1087,5,ActiRealizada.MANITAS, 3);
        empresa.añadirEmpleadoASede("Fred", 1087,13,ActiRealizada.MANITAS, 4);
        empresa.añadirEmpleadoASede("George", 1087,243,ActiRealizada.CONTABLE, 4);
        empresa.añadirEmpleadoASede("Philip", 1087,5,ActiRealizada.EJECUTIVO, 4);
        empresa.añadirEmpleadoASede("Kiryu", 1087,13,ActiRealizada.MANITAS, 5);
        empresa.añadirEmpleadoASede("Majima", 1087,243,ActiRealizada.CONTABLE, 5);
        empresa.añadirEmpleadoASede("Shinji", 1087,5,ActiRealizada.EJECUTIVO, 5);
        empresa.añadirEmpleadoASede("Jotaro", 1087,5,ActiRealizada.EJECUTIVO, 5);
        empresa.añadirEmpleadoASede("Josuke", 1087,5,ActiRealizada.EJECUTIVO, 5);
        
        System.out.println(""+ empresa);
        
        JOptionPane.showMessageDialog(null, empresa.trabajadoresMasMenosHoras());
        
        empresa.guardarDatosEnFichero(ruta);
        
        empresa.compararTrabajadoresPorContinentes();
        
        empresa.compararTuberiasPorContinente(true);
        
        //empresa.compararTuberiasPorContinente(false);
        /*
        Sede sede = new Sede ("Mauritania",Continente.AFRICA);
        try {
            sede.añadirTrabajador("Pepe", 1087,35,ActiRealizada.MANITAS, sede.getID());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            sede.añadirTrabajador("Luis", 1087,35,ActiRealizada.MANITAS, sede.getID());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            sede.añadirTrabajador("Josefa", 1563,35,ActiRealizada.CONTABLE, sede.getID());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            sede.añadirTrabajador("Maria", 14512,35,ActiRealizada.EJECUTIVO, sede.getID());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        Sede sede2 = new Sede ("Madrid",Continente.EUROPA);
        sede2.getTrabajadores().add(new Trabajador("Alberto", 1242,35,ActiRealizada.MANITAS, sede2.getID()));
        sede2.getTrabajadores().add(new Trabajador("Mario", 1087,54,ActiRealizada.MANITAS, sede2.getID()));
        sede2.getTrabajadores().add(new Trabajador("Alex", 2045,3,ActiRealizada.CONTABLE, sede2.getID()));
        sede2.getTrabajadores().add(new Trabajador("Jalen", 1900,152,ActiRealizada.EJECUTIVO, sede2.getID()));
        sede2.getTrabajadores().add(new Trabajador("Julian", 1087,200,ActiRealizada.MANITAS, sede2.getID()));
        sede2.getTrabajadores().add(new Trabajador("Manu", 1900,23,ActiRealizada.EJECUTIVO, sede2.getID()));
        sede2.getTrabajadores().add(new Trabajador("Mamen", 1900,14,ActiRealizada.CONTABLE, sede2.getID()));
        
        
       // sede.eliminarEmpleado();
        //sede.modificarSueldoEmpleado();
        JOptionPane.showMessageDialog(null, sede2.listadoTrabajadoresOrdenados(FormaOrdenar.ACTIVIDAD));
        System.out.println(sede2.listadoTrabajadoresOrdenados(FormaOrdenar.ACTIVIDAD));
        System.out.println("" + sede + "\n\n" + sede2);
*/    
    }
}
