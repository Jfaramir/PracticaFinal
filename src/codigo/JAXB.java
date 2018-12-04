/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import generated.Objetos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author xp
 */
public class JAXB {
    
    
    Objetos misObjetos;
    
    List <Objetos.Objeto> orbjeto;
    
    
    public int  abrir_XML_JAXB(File fichero){
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Objetos.class);
            
            Unmarshaller u = contexto.createUnmarshaller();
            
            misObjetos = (Objetos)u.unmarshal(fichero);
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }
    public String recorrerJAXByMostrar(){
        String Datos_nodo[] = null;
        String cadena_resultado = "";

       
        orbjeto = misObjetos.getObjeto();
        
        for(int i=0; i<orbjeto.size();i++){
            
            cadena_resultado = cadena_resultado + "\n" + "El nombre es: " + orbjeto.get(i).getNombre();
            cadena_resultado = cadena_resultado + "\n" + "Las partes son: " + orbjeto.get(i).getPartes();
            cadena_resultado = cadena_resultado + "\n" + "El precio es: " + orbjeto.get(i).getPrecio();
            cadena_resultado = cadena_resultado + "\n" + "Las activas son: " + orbjeto.get(i).getActivas();
            cadena_resultado = cadena_resultado + "\n" + "Las pasivas son: " + orbjeto.get(i).getPasivas();
            cadena_resultado = cadena_resultado + "\n" + "El daño es: " + orbjeto.get(i).getDano();
            cadena_resultado = cadena_resultado + "\n" + "La vida es: " + orbjeto.get(i).getVida();
            cadena_resultado = cadena_resultado + "\n" + "Las resistencias son: " + orbjeto.get(i).getResistencias();
            cadena_resultado = cadena_resultado + "\n" + "El CDR es: " + orbjeto.get(i).getCooldownReduction();
            cadena_resultado = cadena_resultado + "\n" + "El mana es: " + orbjeto.get(i).getMana();
            cadena_resultado = cadena_resultado + "\n" + "----------------------" + "\n";
        }
        return cadena_resultado;
        
    }
   
    
    
     public int guardarJAXB (File archivo) {
         
         JAXBContext contexto;
         
         try {
             
             contexto = JAXBContext.newInstance(Objetos.class);

             Marshaller m = contexto.createMarshaller();
             
             m.setProperty(m.JAXB_FORMATTED_OUTPUT, true);
             
             m.marshal(misObjetos, archivo);
             
            return 0;
            
        } catch (Exception e) {
            return -1;
        }
         
    }
    
}
