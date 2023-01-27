/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import Modelo.Carrera;
import java.util.List;

/**
 *
 * @author esteb
 */
public interface CarreraService {

    public void crear(Carrera carrera); 
    
    public List<Carrera> listar();
    
    public Carrera buscaCodigo(int codigo);
   
    public void modificar(Carrera carrera, int codigo);

    public void eliminar(int codigo);
    
    public List<Carrera> recuperarArchivo(String ruta);

    public void almacenarArchivo(Carrera carrera, String ruta);
}
