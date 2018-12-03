/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import generated.Objetos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.w3c.dom.Document;

/**
 *
 * @author xp
 */
public class JAXB {
    
    Objetos misObjetos;
    
    List<Objetos.Objeto> objeto;
    
    
    public int  abrir_XML_JAXB(File fichero){
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Objetos.class);
            
            Unmarshaller u = contexto.createUnmarshaller();
            
            misObjetos = (Objetos)u.unmarshal(fichero);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
    public String recorrerJAXByMostrar(){
        String Datos_nodo[] = null;
        String cadena_resultado = "";
        
        List<Objetos.Objeto> lLibros = misObjetos.getObjeto();
//        for(int i=0; i<lLibros.size();i++){
//            
//            cadena_resultado = cadena_resultado + "\n" + "El nombre es: " + lLibros.get(i).getNombre();
//            cadena_resultado = cadena_resultado + "\n" + "Las partes son: " + lLibros.get(i).getPartes();
//            cadena_resultado = cadena_resultado + "\n" + "El precio es: " + lLibros.get(i).getPrecio();
//            cadena_resultado = cadena_resultado + "\n" + "Las activas son: " + lLibros.get(i).getActivas();
//            cadena_resultado = cadena_resultado + "\n" + "Las pasivas son: " + lLibros.get(i).getPasivas();
//            cadena_resultado = cadena_resultado + "\n" + "El daño es: " + lLibros.get(i).getDaño();
//            cadena_resultado = cadena_resultado + "\n" + "La vida es: " + lLibros.get(i).getVida();
//            cadena_resultado = cadena_resultado + "\n" + "Las resistencias son: " + lLibros.get(i).getResistencias();
//            cadena_resultado = cadena_resultado + "\n" + "El CDR es: " + lLibros.get(i).getCooldownReduction();
//            cadena_resultado = cadena_resultado + "\n" + "El mana es: " + lLibros.get(i).getMana();
//            cadena_resultado = cadena_resultado + "\n" + "----------------------" + "\n";
//        }
        return cadena_resultado;
        
    }
   
    
    
     public int guardarJAXB (File fichero,String archivo) {
 
         try {
             
             System.out.println("1");
         // Instanciamos el contexto, indicando la clase que será el RootElement.
JAXBContext jaxbContext = JAXBContext.newInstance(archivo);
             System.out.println("2");
// Creamos un Marshaller, que es la clase capaz de convertir nuestro java bean
// en una cadena XML
Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
             System.out.println("3");
// Indicamos que vamos a querer el XML con un formato amigable (saltos de linea,
// sangrado, etc)
jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
             System.out.println("4");
// Hacemos la conversión llamando al método marshal, pasando una instancia del java
// bean que quermos convertir a XML y un OutpuStream donde queramos que salga el XML,
// en esta caso, la salida estándar. Podría ser un fichero o cualquier otro Stream.
jaxbMarshaller.marshal(Objetos.class, new FileWriter("fichero.xml"));
System.out.println("5");


            return 0;
            
        } catch (Exception e) {
            return -1;
        }
         
//        try {
//            File file = new File (nameFile);
//            JAXBContext jc = JAXBContext.newInstance(this.getClass());
//            Marshaller jaxbMarshaller = jc.createMarshaller();
// 
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
// 
//            jaxbMarshaller.marshal(this, new FileWriter(nameFile, true));
// 
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    
    
}
