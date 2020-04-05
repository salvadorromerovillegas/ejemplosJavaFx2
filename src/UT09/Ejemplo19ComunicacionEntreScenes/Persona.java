/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT09.Ejemplo19ComunicacionEntreScenes;

/**
 *
 * @author Salvador Romero
 */
public class Persona {
    private int edad;
    private String nombre;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String persona) {
        this.nombre = persona;
    }
    
    public String toString()
    {
        return nombre + " ("+edad+")";
    }
    
}
