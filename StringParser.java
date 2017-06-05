/**
 *********************************************************************
 * @author Josivan Pereira da Silva - Msc. Engenharia da Informação
 * Professor em: 
 * Universidade Cruzeiro do Sul e
 * Faculdade Impacta de Tecnologia
 * *******************************************************************
 */

public class StringParser {
    
    String [] aux = null;
    String [] parser = null;
    
    public String [] clearNoiseOfArrayString(String [] array){
 
        for(int i=0; i<array.length;i++){
            array[i] = array[i].trim();
            array[i] = array[i].replaceAll("\"",    "")
                               .replaceAll("/",	    "")
                               .replace("\\",	    "") // dont use replaceAll here...
                               .replaceAll(">",	    "")
                               .replaceAll("<",     "");    
            //System.out.println(array[i]);
        } 
 
    return array;
        
    }
    
 
}
