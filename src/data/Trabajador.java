package data;

import data.enums.ActiRealizada;

/**
 *
 * @author alber
 */
public class Trabajador {
    private static int contadorID = 1;
    private final int ID;
    private String nombre;
    private double sueldo;
    private int horasTrabajadas;
    private ActiRealizada actividad;
    
    private int sedeID;

    public Trabajador(String nombre, double sueldo, int horasTrabajadas, ActiRealizada actividad, int sedeID) {
        this.ID = Trabajador.contadorID++;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.horasTrabajadas = horasTrabajadas;
        this.actividad = actividad;
        this.sedeID = sedeID;
    }

    
    public static boolean trabajadorEsValido(String nombre, double sueldo) throws Exception{
        if(nombre == null || nombre.trim().isEmpty())
            throw new Exception("El nombre no puede estar vacio");
        else if (sueldo < 1000  || sueldo > 100000)
            throw new Exception("El sueldo tiene que estar entre los 1000 y 100000 euros");
        else
            return true;
           
    }
    
    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) throws Exception {
        if(sueldo < 1000 || sueldo > 100000)
            throw new Exception("");
        this.sueldo = sueldo;
    }

    public ActiRealizada getActividad() {
        return actividad;
    }

    public void setActividad(ActiRealizada actividad) {
        this.actividad = actividad;
    }

    public int getSedeID() {
        return sedeID;
    }

    public void setSedeID(int sedeID) {
        this.sedeID = sedeID;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    
    @Override
    public String toString() {
        return "\nTrabajador " + ID + ", de nombre: " + nombre + ", con un sueldo de " + sueldo + ", que ha trabajado " 
                + horasTrabajadas + " horas, que hace la siguiente actividad: " + actividad;
    }
    
    
}
