/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Universidad;
import Servicio.UniversidadServiceImpl;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author esteb
 */
public class UniversidadControl {

   private UniversidadServiceImpl universidadServiceImpl =new UniversidadServiceImpl();
    public String crear(String[] data)throws Exception {
        try {
        String retorno="No se puede crear Universidad";
        String nombre = data[0];
        int periodo = Integer.valueOf(data[1]).intValue();
        int yearFundacion = Integer.valueOf(data[2]).intValue();
        int numFacultades = Integer.valueOf(data[3]).intValue();
        int codigo=Integer.valueOf(data[4]).intValue();

    if (periodo > 61 || periodo < 61) {
            retorno += " El año no es valido ";
                        } else {
                            Universidad universidad = new Universidad(codigo, nombre, periodo, yearFundacion, numFacultades);
                            if(this.codigoActual(codigo)){
                                throw new RuntimeException(" Codigo Existente ");
                                
                                }else{
                                this.universidadServiceImpl.crear(universidad);}
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
        for(Universidad universidad:this.universidadServiceImpl.listar()){
            if(universidad.getCodigo()==codigo){
                retorno=true;
            
            }
        }
        
        return retorno;
}
    public List<Universidad> listar(){
        return this.universidadServiceImpl.listar();
    }
    public String modificar(String[] data) {
        try {
        String retorno="No se puede crear Universidad";
        String nombre = data[0];
        int periodo = Integer.valueOf(data[1]).intValue();
        int yearFundacion = Integer.valueOf(data[2]).intValue();
        int numFacultades = Integer.valueOf(data[3]).intValue();
        int codigo=Integer.valueOf(data[4]).intValue();
        int universidadModificada = Integer.valueOf(data[5]).intValue();
    if (periodo > 61 || periodo < 61) {
            retorno += " El año no es valido ";
                        } else {
                            Universidad universidad = new Universidad(codigo, nombre, periodo, yearFundacion, numFacultades);
                            if(!this.codigoActual(universidadModificada)){
                                throw new RuntimeException(" Codigo No Existente ");
                            }else{
                            this.universidadServiceImpl.modificar(universidad, universidadModificada);
                            retorno = "Universidad modificada Exitosamente ";}
                        }
        return retorno;
        }catch(NumberFormatException e1){
            throw new RuntimeException("Error en los parametros");
        }catch(RuntimeException e1){
            throw new RuntimeException("Codigo No Existe");
        }
    }
      public void eliminar(String codigos) {
        int codigo = Integer.valueOf(codigos).intValue();
        try{
            if(!this.codigoActual(codigo)){
                throw new RuntimeException(" Codigo No Existente ");
                
            }else{
            
            this.universidadServiceImpl.eliminar(codigo);
            }
        }catch(NumberFormatException e1){
            throw new RuntimeException("Codigo no valido");
        }
    }
    
  
}
