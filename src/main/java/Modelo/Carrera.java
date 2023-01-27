/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;



/**
 *
 * @author esteb
 */
public class Carrera {
    private int codigo;
    private String nombreCarrera;
    private String nombreDirector;
    private int numCiclos;
    private String facultad;
    private Universidad universidad;

    public Carrera(int codigo, String nombreCarrera, String nombreDirector
            , int numCiclos, String facultad, Universidad universidad) {
        this.codigo = codigo;
        this.nombreCarrera = nombreCarrera;
        this.nombreDirector = nombreDirector;
        this.numCiclos = numCiclos;
        this.facultad = facultad;
        this.universidad = universidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public int getNumCiclos() {
        return numCiclos;
    }

    public void setNumCiclos(int numCiclos) {
        this.numCiclos = numCiclos;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    @Override
    public String toString() {
        return "Carrera{" + "codigo=" + codigo + ", nombreCarrera=" 
                + nombreCarrera + ", nombreDirector=" + nombreDirector 
                + ", numCiclos=" + numCiclos + ", facultad=" + facultad 
                + ", universidad=" + universidad.getNombre() + '}';
    }
    
     
}
