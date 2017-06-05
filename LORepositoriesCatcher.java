import java.io.BufferedReader;
import java.net.URL;
import java.net.URLConnection;
/**
 *********************************************************************
 * @author Josivan Pereira da Silva - Msc. Engenharia da Informação
 * Professor em: 
 * Universidade Cruzeiro do Sul e
 * Faculdade Impacta de Tecnologia
 * *******************************************************************
 */

public class LORepositoriesCatcher {
    
    URL uri;
    URLConnection connection;
    BufferedReader in;
    String inputLine;
    
    public void lookforLOsAtRepository(String uri, String [] words ){
    
        String search = "";
        //testing:   https://phet.colorado.edu/pt_BR/search?q=soma+luz+onda
        
        search += uri;
        
        for(int i=0; i<words.length;i++){
            search += words[i] + "+";
        }
       
        System.out.println("\n" + search);
    
    }
    
}
