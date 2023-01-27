/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Universidad;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esteb
 */
public class UniversidadServiceImpl implements UniversidadService {

    private static List<Universidad> universidadList = new ArrayList<>();

    @Override
    public void crear(Universidad universidad) {
        this.universidadList.add(universidad);
        this.almacenarArchivo(universidad, "C:/Netbeans1/universidad.dat");
    
    }

    @Override
    public List<Universidad> listar() {
        return this.universidadList;
    }

    @Override
    public Universidad UniversidadCodigo(int codigo) {
        Universidad retorno = null;
        for (Universidad universidad : this.universidadList) {
            if (codigo == universidad.getCodigo()) {
                retorno = universidad;
                break;

            }
        }
        return retorno;
    }

    @Override
    public void modificar(Universidad universidad, int codigo) {

        int indice = -1;
        for (Universidad universidades : this.universidadList) {
            indice++;
            if (codigo == universidades.getCodigo()) {
                this.universidadList.set(indice, universidad);

            }

        }
    }

    @Override
    public void eliminar(int codigo) {
        int indice = -1;
        for (Universidad universidades : this.universidadList) {
            indice++;
            if (codigo == universidades.getCodigo()) {
                this.universidadList.remove(indice);

            }

        }
        
    }
@Override
    public void almacenarArchivo(Universidad universidad, String ruta) {
     DataOutputStream salida = null;

        try {
            salida = new DataOutputStream(new FileOutputStream(ruta, true));
            salida.writeUTF(universidad.getNombre());
            salida.writeInt(universidad.getPeriodo());
            salida.writeInt(universidad.getYearFundacion());
            salida.writeInt(universidad.getNumFacultades());
            salida.writeInt(universidad.getCodigo() );
           

        } catch (IOException ex) {
            Logger.getLogger(UniversidadServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    
    }
      public   void setUniversidadList(List<Universidad> universidadList) {
        UniversidadServiceImpl.universidadList= universidadList;
    }
      public void Actualizar() {
          var Borrarfile= new File("C:/Netbeans1/universidad.dat");
        Borrarfile.delete();
        
        
        for(var i=0;i<universidadList.size();i++){
        this.almacenarArchivo(universidadList.get(i),"C:/Netbeans1/universidad.dat");
        }
    

}
