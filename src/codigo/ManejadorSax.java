/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



    

/**
 *
 * @author xp
 */




public class ManejadorSax extends DefaultHandler{
    
    int ultimoelement;
    String cadena_resultado = "";
   
    
    File fichero = null;
    
    SAXParser parser;
    
    ManejadorSax sh;
    
    public int abrir_XML_SAX(File ficheroXML){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            
            parser = factory.newSAXParser();
            
            sh = new ManejadorSax();
            
            fichero = ficheroXML;
            
            return 0 ;
            
        } catch (Exception e) {
            return -1;
        }
    }
   
    
    
    public ManejadorSax(){
        ultimoelement = 0;
    }
    
    
    @Override public void startElement(String uri, String localName, String qName, Attributes atts)throws SAXException{
        if (qName.equals("objetos")){
            ultimoelement= 11;
            cadena_resultado = cadena_resultado + "Se van a mostrar los objetos de este documento \n" ;
            cadena_resultado = cadena_resultado + "-------------------------------------------------------------------";

        }
        if(qName.equals("objeto")){
            cadena_resultado = cadena_resultado + "\nNombre: " + atts.getValue(atts.getQName(1))+"\n";
            ultimoelement = 2;
        }
        if(qName.equals("objeto")){
            cadena_resultado = cadena_resultado + "\nPrecio: " + atts.getValue(atts.getQName(0))+"\n";
            ultimoelement = 1;
        }
        if(qName.equals("objeto")){
            cadena_resultado = cadena_resultado + "\nPartes: " + atts.getValue(atts.getQName(2))+"\n";
            ultimoelement = 3;
        }
        else if(qName.equals("activas")){
            ultimoelement = 4;
            cadena_resultado = cadena_resultado + "\nActivas: " ;
        }
        else if (qName.equals("pasivas")) {
            ultimoelement = 5;
            cadena_resultado = cadena_resultado + "\nPasivas: " ;
        }
        else if (qName.equals("daño")) {
            ultimoelement = 6;
            cadena_resultado = cadena_resultado + "\nDaño: " ;
        }
        else if (qName.equals("vida")) {
            ultimoelement = 7;
            cadena_resultado = cadena_resultado + "\nVida: " ;
        }
        else if (qName.equals("resistencias")) {
            ultimoelement = 8;
            cadena_resultado = cadena_resultado + "\nResistencias: " ;
        }
        else if (qName.equals("cooldownReduction")) {
            ultimoelement = 9;
            cadena_resultado = cadena_resultado + "\nCooldown reduction: " ;
        }
        else if (qName.equals("mana")) {
            ultimoelement = 10;
            cadena_resultado = cadena_resultado + "\nMana: " ;
            
        }
        
    }
    
    @Override public void endElement(String uri, String localName, String qName) throws SAXException{
        if(qName.equals("objeto")){
            ultimoelement = 12;
            System.out.println("He encontrado el final de un elemento.");
            cadena_resultado = cadena_resultado + "\n -------------------------------------------------------------------------------------------";
        }
    }
    


     public void characters(char[] ch, int start, int length) throws SAXException{
        switch (ultimoelement) {
            case 1:
                for (int i = start; i<length + start; i++){
                    cadena_resultado = cadena_resultado + ch[i];
                }   break;
            case 4:
                for (int i = start; i<length + start; i++){
                    cadena_resultado = cadena_resultado + ch[i];
                }   break;
            case 5:
                for (int i = start; i<length + start; i++){
                    cadena_resultado = cadena_resultado + ch[i];
                }   break;
            case 6:
                for (int i = start; i<length + start; i++){
                    cadena_resultado = cadena_resultado + ch[i];
                }   break;
            case 7:
                for (int i = start; i<length + start; i++){
                    cadena_resultado = cadena_resultado + ch[i];
                }   break;
            case 8:
                for (int i = start; i<length + start; i++){
                    cadena_resultado = cadena_resultado + ch[i];
                }   break;
            case 9:
                for (int i = start; i<length + start; i++){
                    cadena_resultado = cadena_resultado + ch[i];
                }   break;
            case 10:
                for (int i = start; i<length + start; i++){
                    cadena_resultado = cadena_resultado + ch[i];
                }   break;
            case 12:
                for (int i = start; i<length + start; i++){
                    cadena_resultado = cadena_resultado + ch[i];
                }   break;
            default:
                break;
        }
    }
    
     
     
     public String recorrerSax (){
        try {
            parser.parse(fichero, sh);
            return sh.cadena_resultado;
        }catch (SAXException e) {
            e.printStackTrace(); return "Error al pasear con SAX";
        }catch(Exception e){
            e.printStackTrace(); return "Error al pasear con SAX";
        }
        
    }
   
}