/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;



/**
 *
 * @author esteb
 */
public class Universidad {
    private int codigo;
    private String nombre;
    private int periodo;
    private int yearFundacion;
    private int numFacultades;

    public Universidad(int codigo, String nombre, int periodo, int yearFundacion, int numFacultades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.periodo = periodo;
        this.yearFundacion = yearFundacion;
        this.numFacultades = numFacultades;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getYearFundacion() {
        return yearFundacion;
    }

    public void setYearFundacion(int yearFundacion) {
        this.yearFundacion = yearFundacion;
    }

    public int getNumFacultades() {
        return numFacultades;
    }

    public void setNumFacultades(int numFacultades) {
        this.numFacultades = numFacultades;
    }

    @Override
    public String toString() {
        return "Universidad{" + "codigo=" + codigo + ", nombre=" + nombre 
                + ", periodo=" + periodo + ", yearFundacion=" + yearFundacion 
                + ", numFacultades=" + numFacultades + '}';
    }

    
}
