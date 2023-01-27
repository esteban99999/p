/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import Modelo.Asignatura;
import java.util.List;

/**
 *
 * @author esteb
 */
public interface AsignaturaService {
    public void crear(Asignatura asignatura);
    
    public List<Asignatura> listar();
    
    public void modificar(Asignatura asignatura, int codigo);

    public void eliminar(int codigo);
    
    public List<Asignatura> recuperarArchivo(String ruta) ;
    
    public void almacenarArchivo(Asignatura asigantura, String ruta) ;
}
