/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Carrera;
import Modelo.Universidad;
import Servicio.CarreraServiceImpl;
import Servicio.UniversidadServiceImpl;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author esteb
 */
public class CarreraControl {
    
    private CarreraServiceImpl carreraServiceImpl=new CarreraServiceImpl();
    private UniversidadServiceImpl universidadServiceImpl=new UniversidadServiceImpl();
    
    public String crear(String[] data) {
        try {
        String retorno="No se puede crear Universidad:";
        String nombreCarrera = data[0];
        String nombreDirector = data[1];
        int numCiclos = Integer.valueOf(data[2]).intValue();
        String facultad = data[3];
        Universidad universidad = this.universidadServiceImpl.UniversidadCodigo(Integer.valueOf(data[4]));
        int codigo=Integer.valueOf(data[5]).intValue();
        if( universidad == null){
        throw new NumberFormatException(" No existe universidad "); 
        }
        if (numCiclos < 8 || numCiclos >10) {
            retorno += " El numero de ciclos no es valido ";
        } else {
            Carrera carrera = new Carrera(codigo, nombreCarrera, nombreDirector, numCiclos, facultad,universidad);
            if(this.codigoActual(codigo)){
                                throw new RuntimeException(" Codigo Existente ");
                                
                                }else{
                                this.carreraServiceImpl.crear(carrera);
                                retorno = "Creado Satisfactoriamente ";}
            }
        return retorno;
        }catch(NumberFormatException e1){
            throw new RuntimeException("Error en los parametros");
        }catch(RuntimeException e1){
            throw new RuntimeException("Codigo Existente");
        }
        }
    public boolean codigoActual(int codigo){
        boolean retorno = false;
        for(Carrera carrera:this.carreraServiceImpl.listar()){
            if(carrera.getCodigo()==codigo){
                retorno=true;
            
            }
        }
        
        return retorno;
}
    public String modificar(String[] data) {
        try {
        String retorno="No se puede crear Universidad:";
        String nombreCarrera = data[0];
        String nombreDirector = data[1];
        int numCiclos = Integer.valueOf(data[2]).intValue();
        String facultad = data[3];
        Universidad universidad = this.universidadServiceImpl.UniversidadCodigo(Integer.valueOf(data[4]));
        int codigo=Integer.valueOf(data[5]).intValue();
        int modificar = Integer.valueOf(data[6]).intValue();
        if (numCiclos < 8 || numCiclos >10) {
            retorno += " El numero de ciclos no es valido ";
        } else {
            Carrera carrera = new Carrera(codigo, nombreCarrera, nombreDirector, numCiclos, facultad,universidad);
            if(!this.codigoActual(modificar)){
                                throw new RuntimeException(" Codigo No Existente ");
                                
                                }else{
                                this.carreraServiceImpl.modificar(carrera, modificar);
                                retorno = "Modificado Satisfactoriamente ";}

                            }
        return retorno;
        }catch(NumberFormatException e1){
            throw new RuntimeException("Error en los parametros");
        }catch(RuntimeException e1){
            throw new RuntimeException("Codigo No Existente");
        }
        }
    
        public List<Carrera> listar(){
        return this.carreraServiceImpl.listar();
    }
        
        public void eliminar(String codigos) {
        
        int codigo = Integer.valueOf(codigos).intValue();
        try{
            if(!this.codigoActual(codigo)){
                throw new RuntimeException(" Codigo No Existente ");
                
            }else{
            
            this.carreraServiceImpl.eliminar(codigo);
            }
        }catch(NumberFormatException e1){
            throw new RuntimeException("Codigo no valido");
        }
        

    }
    
}
