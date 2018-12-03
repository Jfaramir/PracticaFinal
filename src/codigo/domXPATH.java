/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;


/**
 *
 * @author xp
 */
public class domXPATH {
    Document XMLdoc;
    
    String salida = "";
   
    
   
    
    public int EjecutaXpath(File fichero, String cosa){
        
        try {
             
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            Document XMLDoc = factory.newDocumentBuilder().parse(fichero);
            
            XPath xpath = XPathFactory.newInstance().newXPath();
            
            XPathExpression exp = xpath.compile(cosa);
            
            //Libros/Libro/*
            Object result = exp.evaluate(XMLDoc, XPathConstants.NODESET);

            NodeList nodeList = (NodeList) result;
 
            
            if(cosa.equals("/objetos/objeto")){
            for(int i=0; i < nodeList.getLength(); i++){     
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(0).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(2).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(1).getNodeValue() + "\n";
                salida = salida + nodeList.item(i).getTextContent() + "\n";
                salida = salida + "\n -----------------------";
      
            }
            }else if(cosa.equals("/objetos/objeto[nombre='Crisol de Mikael']")){
            for(int i=0; i < nodeList.getLength(); i++){     
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(0).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(2).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(1).getNodeValue() + "\n";
                salida = salida + nodeList.item(i).getTextContent() + "\n";
                salida = salida + "\n -----------------------";
      
            }
            }else if(cosa.equals("/objetos/objeto[nombre='Fuerza de trinidad']")){
            for(int i=0; i < nodeList.getLength(); i++){     
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(0).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(2).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(1).getNodeValue() + "\n";
                salida = salida + nodeList.item(i).getTextContent() + "\n";
                salida = salida + "\n -----------------------";
      
            }
            }else if(cosa.equals("/objetos/objeto[nombre='Filo fantasmal de Youmuu']")){
            for(int i=0; i < nodeList.getLength(); i++){     
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(0).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(2).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(1).getNodeValue() + "\n";
                salida = salida + nodeList.item(i).getTextContent() + "\n";
                salida = salida + "\n -----------------------";
      
            }
            }else if(cosa.equals("//objeto[@<3100]")){
            for(int i=0; i < nodeList.getLength(); i++){     
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(0).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(2).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(1).getNodeValue() + "\n";
                salida = salida + nodeList.item(i).getTextContent() + "\n";
                salida = salida + "\n -----------------------";
      
            }
            }else if(cosa.equals("//objeto[@>3100]")){
            for(int i=0; i < nodeList.getLength(); i++){     
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(0).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(2).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(1).getNodeValue() + "\n";
                salida = salida + nodeList.item(i).getTextContent() + "\n";
                salida = salida + "\n -----------------------";
      
            }
            }else if(cosa.equals("/objetos/objeto[@partes=1]" )){
            for(int i=0; i < nodeList.getLength(); i++){     
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(0).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(2).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(1).getNodeValue() + "\n";
                salida = salida + nodeList.item(i).getTextContent() + "\n";
                salida = salida + "\n -----------------------";
      
            }
            }else if(cosa.equals("/objetos/objeto[@partes=2]")){
            for(int i=0; i < nodeList.getLength(); i++){     
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(0).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(2).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(1).getNodeValue() + "\n";
                salida = salida + nodeList.item(i).getTextContent() + "\n";
                salida = salida + "\n -----------------------";
      
            }
            }else if(cosa.equals("/objetos/objeto[@partes=3]")){
            for(int i=0; i < nodeList.getLength(); i++){     
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(0).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(2).getNodeValue() + "\n";
                salida = salida + "\n" + nodeList.item(i).getAttributes().item(1).getNodeValue() + "\n";
                salida = salida + nodeList.item(i).getTextContent() + "\n";
                salida = salida + "\n -----------------------";
      
            }
            }else{
                for(int i=0; i < nodeList.getLength(); i++){     
                salida = salida + "\n" + nodeList.item(i).getTextContent() +"\n";
                
            }
            }
                       
                
            
            
            
            return 0;
            
        } catch (Exception e) {
            return -1;
        }
         
    }    
    
     
}
