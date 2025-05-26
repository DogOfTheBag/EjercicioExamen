package data;

import data.enums.Continente;
import data.enums.ActiRealizada;
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
        Sede sede = new Sede ("Mauritania",Continente.AFRICA);
        try {
            sede.añadirTrabajador("Pepe", 1087,ActiRealizada.MANITAS, sede.getID());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            sede.añadirTrabajador("Luis", 1087,ActiRealizada.MANITAS, sede.getID());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            sede.añadirTrabajador("    ", 1563,ActiRealizada.CONTABLE, sede.getID());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            sede.añadirTrabajador("Maria", 0,ActiRealizada.EJECUTIVO, sede.getID());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        Sede sede2 = new Sede ("Madrid",Continente.EUROPA);
        sede2.getTrabajadores().add(new Trabajador("Alberto", 1087,ActiRealizada.MANITAS, sede2.getID()));
        sede2.getTrabajadores().add(new Trabajador("Mario", 1087,ActiRealizada.MANITAS, sede2.getID()));
        sede2.getTrabajadores().add(new Trabajador("Alex", 1563,ActiRealizada.CONTABLE, sede2.getID()));
        sede2.getTrabajadores().add(new Trabajador("Jalen", 2064,ActiRealizada.EJECUTIVO, sede2.getID()));
        
        
        sede.eliminarEmpleado();
        
        System.out.println("" + sede + "\n\n" + sede2);
    }
}
