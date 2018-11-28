/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author xp
 */
public class DOM {
    Document doc = null;
    
    public int abrir_XML_DOM(File fichero) {
        try {
        
        DocumentBuilderFactory  factory = DocumentBuilderFactory.newInstance();
        
        factory.setIgnoringComments(true);
        factory.setIgnoringElementContentWhitespace(true);
        
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        doc = builder.parse(fichero);
        
        return 0;
        } catch (Exception e) {
            return -1;
        }
    }
    
    public String recorrerDOMyMostrar(){
        String datos_nodo[] = null;
        String salida = "";
        Node node;
        
        Node raiz = doc.getFirstChild();
        NodeList nodelist = raiz.getChildNodes();
        
        for (int i=0; i < nodelist.getLength();i++){
            node = nodelist.item(i);
            if(node.getNodeType()== Node.ELEMENT_NODE){
                datos_nodo = procesarObjeto(node);
            }
        }
        return salida;
    }
    
    protected String[] procesarObjeto(Node n){
        String datos[] = new String[10];
        Node ntemp = null;
        int contador = 3;
        
        datos[0]= n.getAttributes().item(0).getNodeValue();
        datos[1]= n.getAttributes().item(0).getNodeValue();
        datos[2]= n.getAttributes().item(0).getNodeValue();
        
        NodeList nodos = n.getChildNodes();
        
        for (int i = 0; i < nodos.getLength(); i++) {
            ntemp = nodos.item(i);
                
                if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
                    datos[contador] = ntemp.getChildNodes().item(0).getNodeValue();
                    contador++;
            }
        }
        return datos;
    }
    
    public int guardarDOMcomoFile(File archivo){
        try {

            
            OutputFormat format = new OutputFormat(doc);
            format.setIndenting(true);
            XMLSerializer serializer = new XMLSerializer(new FileOutputStream(archivo), format);
            serializer.serialize(doc);
            

            return 0;
            
        } catch (Exception e) {
            return -1;
        }
    }
        
    
    public int añadirDOM(String nombre, String partes, String precio, String activas, String pasivas, String daño, String vida, String resistencias, String CDR, String mana){
        try {
            Node nactivas = doc.createElement("activas");
            Node nactivas_text = doc.createTextNode(activas);
            nactivas.appendChild(nactivas_text);
            
            Node npasivas = doc.createElement("pasivas");
            Node npasivas_text = doc.createTextNode(pasivas);
            npasivas.appendChild(npasivas_text);
            
            Node ndaño = doc.createElement("daño");
            Node ndaño_text = doc.createTextNode(daño);
            ndaño.appendChild(ndaño_text);
            
            Node nvida = doc.createElement("vida");
            Node nvida_text = doc.createTextNode(vida);
            nvida.appendChild(nvida_text);
            
            Node nresistencias = doc.createElement("resistencias");
            Node nresistencias_text = doc.createTextNode(resistencias);
            nresistencias.appendChild(nresistencias_text);
            
            Node nCDR = doc.createElement("cooldownReduction");
            Node nCDR_text = doc.createTextNode(CDR);
            nCDR.appendChild(nCDR_text);
            
            Node nmana = doc.createElement("mana");
            Node nmana_text = doc.createTextNode(mana);
            nmana.appendChild(nmana_text);
            
            Node nObjeto = doc.createElement("objeto");
            ((Element)nObjeto).setAttribute("nombre", nombre);
            ((Element)nObjeto).setAttribute("partes", partes);
            ((Element)nObjeto).setAttribute("precio", precio);
            nObjeto.appendChild(nactivas);
            nObjeto.appendChild(npasivas);
            nObjeto.appendChild(ndaño);
            nObjeto.appendChild(nvida);
            nObjeto.appendChild(nresistencias);
            nObjeto.appendChild(nCDR);
            nObjeto.appendChild(nmana);
            
            
            Node raiz = doc.getChildNodes().item(0);
            raiz.appendChild(nObjeto);
            
            return 0;
        } catch (Exception e) {
            return -1;
        }
    } 
    
        
}
