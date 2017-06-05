
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.lang3.StringUtils;



/**
 *********************************************************************
 * @author Josivan Pereira da Silva - Msc. Engenharia da Informação
 * Professor em: 
 * Universidade Cruzeiro do Sul e
 * Faculdade Impacta de Tecnologia
 * *******************************************************************
 */

public class SynonymsOnWebFinder {
    
    String primaryWord = "";    
    String stringURIs [];
    String answer[] = null;
    String words0 [] = null;
    String words1 [] = null;
    String words2 [] = null;
    URL uri;
    URLConnection connection;
    BufferedReader in;
    String inputLine;
    
    public void lookforSynonyms(String w){
         
        primaryWord = w;  
        stringURIs = new String [3];
    
        stringURIs [0] = "https://www.sinonimos.com.br/"+ primaryWord +"/";
        stringURIs [1] = "http://www.antonimosesinonimos.com.br/"+ primaryWord +"/";
        stringURIs [2] = "http://sinonimos-online.com/"+ primaryWord +".html";
        
        StringParser sp = new StringParser();

        // ****************** First Synonyms Website *********************************************
        // https://www.sinonimos.com.br/carro/
        
        answer = null;
        try {
            uri = new URL(stringURIs[0]);
            connection = uri.openConnection();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            inputLine ="";           
             while ((inputLine = in.readLine()) != null)  {  
                if(inputLine.contains("class=\"sinonimos\"><em>1</em>")){
                    inputLine += in.readLine().trim();                     
                    while( !(in.readLine().startsWith("class='s-wrapper'><div")) ){                        
                        inputLine += in.readLine().trim();                        
                    }                    
                    break;
                    
                }            
            }             
            in.close();        
            
            //System.out.println(inputLine);
            //inputLine = inputLine.replaceAll("\t", "@");  		
            
            words0 = StringUtils.substringsBetween(inputLine, "class=\"sinonimo\">", "</a>");
            for (String w0 : words0) {
                System.out.println( w0); // good
            }  
            words0 = sp.clearNoiseOfArrayString(words0);
            
        } 
        catch (MalformedURLException ex) {    ex.printStackTrace();   } 
        catch (IOException ex) {    ex.printStackTrace();   }  
        
        // ****************** Second Synonyms Website *********************************************
        // http://www.antonimosesinonimos.com.br/carro/
        try {
            uri = new URL(stringURIs[1]);
            connection = uri.openConnection();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
                       
            while ((inputLine = in.readLine()) != null)  {
                if(inputLine.startsWith("<meta name=\"description\"")){
                    answer = inputLine.split(((primaryWord.charAt(0)+"").toUpperCase()+primaryWord.substring(1, (primaryWord.length()))+"."));
                    words1 = answer[1].split(" , ");
                }            
            }               
            in.close();            
        } 
        catch (MalformedURLException ex) {    ex.printStackTrace();   } 
        catch (IOException ex) {    ex.printStackTrace();   }  
        
        //for(int i = 0; i<words1.length;i++){    System.out.println(words1[i]);  }
        
        
        words1 = sp.clearNoiseOfArrayString(words1);
        
        System.out.println("");
        for(int i = 0; i<words1.length;i++){    System.out.println(words1[i]);  }
        
        // ****************** Third Synonyms Website *********************************************
        // http://sinonimos-online.com/
        answer = null;
        try {
            uri = new URL(stringURIs[2]);
            connection = uri.openConnection();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            inputLine ="";           
             while ((inputLine = in.readLine()) != null)  {  
                if(inputLine.contains("[substantivo]")){
                    inputLine = "";
                    for(int i = 0; i<=10;i++){                        
                        inputLine += in.readLine().trim();
                    }                    
                    break;
                }            
            }             
            in.close();        
            
            System.out.println("");
            inputLine = inputLine.replaceAll("\t", "@");  		
            words2 = StringUtils.substringsBetween(inputLine, "title=", ">");
            for (String w2 : words2) {
                System.out.println( w2); // good
            }   
            words2 = sp.clearNoiseOfArrayString(words2);
        } 
        catch (MalformedURLException ex) {    ex.printStackTrace();   } 
        catch (IOException ex) {    ex.printStackTrace();   }  
        
        
        LORepositoriesCatcher lorc = new LORepositoriesCatcher();
        lorc.lookforLOsAtRepository("https://phet.colorado.edu/pt_BR/search?q=", words0);
        lorc.lookforLOsAtRepository("http://portaldoprofessor.mec.gov.br/buscaGeral.html?q=", words1);
        lorc.lookforLOsAtRepository("http://www.lume.ufrgs.br/search?query=", words2);
        
    }
    
}
