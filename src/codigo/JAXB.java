/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import generated.Objetos;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author xp
 */
public class JAXB {
    
    Objetos misLibros;
    
    public int  abrir_XML_JAXB(File fichero){
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Objetos.class);
            
            Unmarshaller u = contexto.createUnmarshaller();
            
            misLibros = (Objetos)u.unmarshal(fichero);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
    public String recorrerJAXByMostrar(){
        String Datos_nodo[] = null;
        String cadena_resultado = "";
        
        List<Objetos.Objeto> lLibros = misLibros.getObjeto();
        for(int i=0; i<lLibros.size();i++){
            cadena_resultado = cadena_resultado + "\n" + "La editorial es: " + lLibros.get(i).getPrecio();
            cadena_resultado = cadena_resultado + "\n" + "La editorial es: " + lLibros.get(i).getNombre();
            cadena_resultado = cadena_resultado + "\n" + "La editorial es: " + lLibros.get(i).getPartes();
            cadena_resultado = cadena_resultado + "Publicado en: " + lLibros.get(i).getActivas();
            cadena_resultado = cadena_resultado + "\n" + "El titulo es: " + lLibros.get(i).getPasivas();
            cadena_resultado = cadena_resultado + "\n" + "El autor es: " + lLibros.get(i).getDaño();
            cadena_resultado = cadena_resultado + "\n" + "La editorial es: " + lLibros.get(i).getVida();
            cadena_resultado = cadena_resultado + "\n" + "La editorial es: " + lLibros.get(i).getResistencias();
            cadena_resultado = cadena_resultado + "\n" + "La editorial es: " + lLibros.get(i).getCooldownReduction();
            cadena_resultado = cadena_resultado + "\n" + "La editorial es: " + lLibros.get(i).getMana();
            cadena_resultado = cadena_resultado + "\n" + "----------------------" + "\n";
        }
        return cadena_resultado;
        
    }
    
    
    
}
