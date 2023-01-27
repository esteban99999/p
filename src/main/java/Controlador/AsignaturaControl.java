/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Controlador;

import Modelo.Asignatura;
import Modelo.Carrera;
import Servicio.AsignaturaServiceImpl;
import Servicio.CarreraServiceImpl;
import java.util.List;

/**
 *
 * @author esteb
 */
public class AsignaturaControl {

  private AsignaturaServiceImpl asignaturaServiceImpl =new AsignaturaServiceImpl();
  private CarreraServiceImpl carreraServiceImpl=new CarreraServiceImpl();
  
  public AsignaturaControl(){
  this.asignaturaServiceImpl = new AsignaturaServiceImpl(); 
  }
  public String crear(String[] data) {
      try {
        String retorno = "No se puede crear la Asignatura:";
        String nombre = data[0];
        String libroGuia = data[1];
        int numHoras = Integer.valueOf(data[2]).intValue();
        int numUnidades = Integer.valueOf(data[3]).intValue();
        Carrera carrera = this.carreraServiceImpl.buscaCodigo(Integer.valueOf(data[4]));
        int codigo=Integer.valueOf(data[5]).intValue();
        if( carrera== null){
        throw new NumberFormatException(" No existe carrera "); 
        }
        if (numUnidades < 0) {
            retorno += " El numero de Unidades no son validos ";
        } else {
            if (numUnidades <= 4 ) {
                retorno += " El de unidades no es valido ";
            } else {
                
                Asignatura asignatura = new Asignatura(codigo, nombre, libroGuia, numHoras, numUnidades,carrera);
                if (this.codigoActual(codigo)) {
                                    throw new RuntimeException(" Codigo Existente ");
                                } else {
                                    this.asignaturaServiceImpl.crear(asignatura);
                                    retorno = "Creado Satisfactoriamente ";
                                }
            }
  }
        return retorno;
  } catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Codigo Existente");
        }
}
  public boolean codigoActual(int codigo) {
        boolean retorno = false;
        for (Asignatura asignatura : this.asignaturaServiceImpl.listar()) {
            if (asignatura.getCodigo() == codigo) {
                retorno = true;

            }
        }

        return retorno;
    }
  public String modificar(String[] data) {
      try {
        String retorno = "No se puede crear la Asignatura:";
        String nombre = data[0];
        String libroGuia = data[1];
        int numHoras = Integer.valueOf(data[2]).intValue();
        int numUnidades = Integer.valueOf(data[3]).intValue();
        Carrera carrera = this.carreraServiceImpl.buscaCodigo(Integer.valueOf(data[4]));
        int codigo=Integer.valueOf(data[5]).intValue();
        int modificar = Integer.valueOf(data[6]).intValue();
        if (numUnidades < 0) {
            retorno += " El numero de Unidades no son validos ";
        } else {
            if (numUnidades <= 4 ) {
                retorno += " El de unidades no es valido ";
            } else {
                
                Asignatura asignatura = new Asignatura(codigo, nombre, libroGuia, numHoras, numUnidades,carrera);
                if (!this.codigoActual(modificar)) {
                                    throw new RuntimeException(" Codigo No Existente ");

                                } else {
                                    this.asignaturaServiceImpl.modificar(asignatura, modificar);
                                    retorno = "Modificado Satisfactoriamente ";
                                }
            }
  }
        return retorno;
  } catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Codigo No Existente");
        }
}
  
  public List<Asignatura> listar() {
        return this.asignaturaServiceImpl.listar();
  }
  public void eliminar(String codigos) {
        int codigo = Integer.valueOf(codigos).intValue();
        try {
            if (!this.codigoActual(codigo)) {
                throw new RuntimeException(" Codigo No Existente ");

            } else {

                this.asignaturaServiceImpl.eliminar(codigo);
            }
        } catch (NumberFormatException e1) {
            throw new RuntimeException("Codigo no valido");
        }

    }
}
